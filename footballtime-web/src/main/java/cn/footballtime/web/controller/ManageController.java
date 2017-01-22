package cn.footballtime.web.controller;

import cn.footballtime.dto.CompetitionDto;
import cn.footballtime.dto.TeamDto;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.service.CompetitionService;
import cn.footballtime.web.service.ManageService;
import cn.footballtime.web.service.TeamService;
import cn.footballtime.web.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/4.
 */
@Controller
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    private ManageService _manageService;

    @Autowired
    private CompetitionService _competitionService;

    @Autowired
    private TeamService _teamService;

    @RequestMapping(value = "/login")
    public String login() {
        return "manage/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isLoginSuccess = _manageService.login(userName,password);
        if (isLoginSuccess) {
            //使用request对象的getSession()获取session，如果session不存在则创建一个
            HttpSession session = request.getSession();
            //将数据存储到session中
            session.setAttribute("uid", userName);

            response.sendRedirect("index");
        } else {
            response.sendRedirect("login");
        }
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        String userName = manageLogin(request);
        if (userName.length() == 0) {
            response.sendRedirect("login");
        }

        model.addAttribute("userName", userName);

        return "/manage/index";
    }

    @RequestMapping(value = "/team")
    public String team(HttpServletRequest request, HttpServletResponse response,String competitionId, Model model) throws Exception {
        String userName = manageLogin(request);
        if (userName.length() == 0) {
            response.sendRedirect("login");
        }

        //默认为2
        competitionId = StringUtils.isEmpty(competitionId) ? "2" : competitionId;

        CompetitionDto obj = _competitionService.getCompetitionById(competitionId);

        model.addAttribute("userName", userName);
        model.addAttribute("competitionId", competitionId);
        model.addAttribute("competitionName", obj.getName());

        List<TeamDto> teamList = _teamService.GetTeamListByCompeitionIdAndSeason(competitionId,obj.getCurrentSeason());
        model.addAttribute("teamList", teamList);

        model.addAttribute("picUrl",AppSetting.getPicUrl());

        return "manage/team";
    }

    @RequestMapping(value = "/uploadTeamLogo")
    public String uploadTeamLogo(HttpServletRequest request, HttpServletResponse response,String competitionId,String teamNo, Model model) throws Exception {
        String userName = manageLogin(request);
        if (userName.length() == 0) {
            response.sendRedirect("login");
        }

        model.addAttribute("userName", userName);
        model.addAttribute("competitionId",competitionId);
        model.addAttribute("teamNo",teamNo);

        return "manage/uploadTeamLogo";
    }

    @RequestMapping(value = "/uploadTeamLogo", method = RequestMethod.POST)
    public void uploadTeamLogo(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
        String userName = manageLogin(request);
        if (userName.length() == 0) {
            response.sendRedirect("login");
        }

        //上传目录
        Date currentTime = new Date();
        String timeFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(currentTime);
        String folderName = timeFileName.substring(0,6);
        String rootPath = request.getSession().getServletContext().getRealPath("/") + "upload/";//AppSetting.getUploadPicPath()
        String path = rootPath + folderName + "/";//request.getServletContext().getRealPath("/")+"upload/images/"+folderName+"/";
        File savePath = new File(path);
        if (!savePath.exists()) { // 文件夹
            savePath.mkdirs();
        }

        // 转型为MultipartHttpRequest：
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
        MultipartFile file = multipartRequest.getFile("filePic");
        String teamNo = multipartRequest.getParameter("teamNo");
        String competitionId = multipartRequest.getParameter("competitionId");
        // 获得文件名：
        String originalFilename = file.getOriginalFilename();
        if(originalFilename.length()==0)
        {
            throw new Exception("请选择图片");
        }

        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
        extendName = extendName.toLowerCase().replace("jpep","jpg");
        String picNo = CommonUtil.getPicNoByPicExtendName(extendName);
        if (picNo.length() == 0) {
            throw new Exception("只接受jpg,png,gif这三种类型图");
        }
        String newFilename = timeFileName + picNo + extendName;

        InputStream input = file.getInputStream();

        try {
            saveFileFromInputStream(input, savePath.toString(), newFilename);

            _teamService.modifyTeamLogo(teamNo,timeFileName + picNo);
        }
        catch (Exception ex)
        {
            throw ex;
        }

        response.sendRedirect("team?competitionId="+competitionId);
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        //将数据存储到session中
        session.setAttribute("uid", "");

        response.sendRedirect("login");
    }

    /**
     * session登录验证
     *
     * @param request
     * @return
     */
    private String manageLogin(HttpServletRequest request) {
        String userName = "";
        HttpSession session = request.getSession();
        if (session.getAttribute("uid") != null) {
            userName = session.getAttribute("uid").toString();
        }

        return userName;
    }

    private void saveFileFromInputStream(InputStream stream, String path, String filename) throws IOException {
        FileOutputStream fs = new FileOutputStream(path + "/" + filename);
        byte[] buffer = new byte[1024 * 1024];
        int bytesum = 0;
        int byteread = 0;
        while ((byteread = stream.read(buffer)) != -1) {
            bytesum += byteread;
            fs.write(buffer, 0, byteread);
            fs.flush();
        }
        fs.close();
        stream.close();
    }
}
