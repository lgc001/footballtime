package cn.footballtime.web.controller;

import cn.footballtime.dto.ManagerDto;
import cn.footballtime.utils.SecurityUtil;
import cn.footballtime.utils.security.AESUtil;
import cn.footballtime.web.config.AppSetting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

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

        ManagerDto managerDto = new ManagerDto();
        managerDto.setUserName("");
        managerDto.setPassword("");
        managerDto.setSaltFigure("");
        if(managerDto==null)
        {
            response.sendRedirect("login");
        }

        String inputPassowrd = SecurityUtil.encryptMD5(managerDto.getSaltFigure()+password).toUpperCase();
        if(inputPassowrd.equals(managerDto.getPassword().toUpperCase()))
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
}
