package cn.footballtime.web.controller;

import cn.footballtime.utils.SecurityUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
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
    @RequestMapping(value = "/login")
    public String login() {
        return "manage/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String userName=request.getParameter("userName");
        String password=request.getParameter("password");

        boolean isLoginSuccess = true;
        if(isLoginSuccess)
        {
            //使用request对象的getSession()获取session，如果session不存在则创建一个
            HttpSession session = request.getSession();
            //将数据存储到session中
            session.setAttribute("uid", userName);

            response.sendRedirect("index");
        }
        else
        {
            response.sendRedirect("login");
        }
    }

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception
    {
        String userName="";
        HttpSession session = request.getSession();
        if(session.getAttribute("uid")==null)
        {
            response.sendRedirect("login");
        }
        else
        {
            userName=session.getAttribute("uid").toString();
        }

        model.addAttribute("userName", userName);

        return "manage/index";
    }

    @RequestMapping(value = "/uploadpic",method = RequestMethod.POST)
    public String uploadPic(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception
    {
        String userName="";
        HttpSession session = request.getSession();
        if(session.getAttribute("uid")==null)
        {
            response.sendRedirect("login");
        }
        else
        {
            userName=session.getAttribute("uid").toString();
        }

        Date currentTime=new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMM");
        String folder = formatDate.format(currentTime);
        File uploadPath = new File(request.getServletContext().getRealPath("/")+"upload/images/"+folder+"/");
        //File uploadPath = new File("C:/javawork8/upload/images/"+folder+"/");
        //应保证在根目录中有此目录的存在  如果没有，下面则先创建新的文件夹
        if(!uploadPath.exists())
        {
            //System.out.println("创建新文件夹成功"+formatnowtime);
            uploadPath.mkdir();
        }

        //InputStream is=new FileInputStream(request.);//将<input>标签里面的图片文件写入流文件InpuStream

        return "manage/index";
    }

    @RequestMapping(value = "/uploadpic1",method = RequestMethod.POST)
    public String uploadPic1(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception
    {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解决上传文件名的中文乱码
        upload.setHeaderEncoding("UTF-8");
        factory.setSizeThreshold(1024 * 500);//设置内存的临界值为500K
        File linshi = new File("E:\\linshi");//当超过500K的时候，存到一个临时文件夹中
        factory.setRepository(linshi);
        upload.setSizeMax(1024 * 1024 * 5);//设置上传的文件总的大小不能超过5M
        try {
            // 1. 得到 FileItem 的集合 items
            List<FileItem> /* FileItem */items = upload.parseRequest(request);

            // 2. 遍历 items:
            for (FileItem item : items) {
                // 若是一个一般的表单域, 打印信息
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString("utf-8");

                    System.out.println(name + ": " + value);


                }
                // 若是文件域则把文件保存到 e:\\files 目录下.
                else {
                    String fileName = item.getName();
                    long sizeInBytes = item.getSize();
                    System.out.println(fileName);
                    System.out.println(sizeInBytes);

                    InputStream in = item.getInputStream();
                    byte[] buffer = new byte[1024];
                    int len = 0;

                    fileName = "e:\\files\\" + fileName;//文件最终上传的位置
                    System.out.println(fileName);
                    OutputStream out = new FileOutputStream(fileName);

                    while ((len = in.read(buffer)) != -1) {
                        out.write(buffer, 0, len);
                    }

                    out.close();
                    in.close();
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        return "manage/index";
    }
}
