package com.example.admin.controller;

import com.example.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    //访问项目主页为登录页
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    //提交的方式登录
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if("lzh".equals(user.getUsername())&&"123".equals(user.getPassword())){
            //把登录成功的用户保存在session
            session.setAttribute("loginUser",user);
            //登录成功重定向到main.html;  重定向防止表单重复提交
            return "redirect:/main.html";
        }else{
            model.addAttribute("failmsg","账号或密码错误");
            //回到登录页
            return "/login";
        }
    }

    //到main页面
    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        Object loginUser = session.getAttribute("loginUser");
        session.setMaxInactiveInterval(60*60);
        if (loginUser!=null){
            return "main";
        }else {
            model.addAttribute("failmsg","当前未登录，请重新登录");
            return "/login";
        }
    }
}