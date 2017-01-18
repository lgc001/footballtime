package cn.footballtime.web.controller;

import cn.footballtime.dto.CompetitionDto;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.service.CompetitionService;
import cn.footballtime.web.service.ManageService;
import cn.footballtime.web.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public String team(HttpServletRequest request, HttpServletResponse response,String competitionNo, Model model) throws Exception {
        String userName = manageLogin(request);
        if (userName.length() == 0) {
            response.sendRedirect("login");
        }

        //默认为2
        competitionNo = StringUtils.isEmpty(competitionNo) ? "A02" : competitionNo;

        CompetitionDto obj = _competitionService.getByCompetitionNo(competitionNo);

        model.addAttribute("userName", userName);
        model.addAttribute("competitionName", obj.getName());

        return "manage/team";
    }

    @RequestMapping(value = "/uploadTeamLogo")
    public String uploadTeamLogo(HttpServletRequest request, HttpServletResponse response,String teamNo, Model model) throws Exception {
        String userName = manageLogin(request);
        if (userName.length() == 0) {
            response.sendRedirect("login");
        }

        model.addAttribute("userName", userName);

        return "manage/uploadTeamLogo";
    }

    @RequestMapping(value = "/uploadTeamLogo", method = RequestMethod.POST)
    public String uploadTeamLogo(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        String userName = manageLogin(request);
        if (userName.length() == 0) {
            response.sendRedirect("login");
        }

        //上传目录
        Date currentTime = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMM");
        String folderName = formatDate.format(currentTime);
        String path = AppSetting.getUploadPicPath() + "/" + folderName + "/";//request.getServletContext().getRealPath("/")+"upload/images/"+folderName+"/";
        File savePath = new File(path);
        if (!savePath.exists()) { // 文件夹
            savePath.mkdir();
        }

        // 转型为MultipartHttpRequest：
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
        MultipartFile file = multipartRequest.getFile("filePic");
        // 获得文件名：
        String originalFilename = file.getOriginalFilename();
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String picNo = CommonUtil.getPicNoByPicExtendName(extendName);
        if (picNo.length() == 0) {
            throw new Exception("只接受jpg,png,gif这三种类型图");
        }
        String timeFileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(currentTime);
        String newFilename = timeFileName + picNo + extendName;

        InputStream input = file.getInputStream();

        saveFileFromInputStream(input, savePath.toString(), newFilename);

        return "manage/login";
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
