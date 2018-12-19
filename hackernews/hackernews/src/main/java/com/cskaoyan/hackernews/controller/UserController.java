package com.cskaoyan.hackernews.controller;

import com.cskaoyan.hackernews.bean.User;
import com.cskaoyan.hackernews.service.UserService;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: l
 * @CreateDate: 2018/12/18 22:11
 * @需求:
 * @思路说明:
 */
@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/reg/")
    public Map<String,Object> register(User user,String username,HttpSession session){

        HashMap<String, Object> map = new HashMap<>();
        boolean nameAvailable = userService.isNameAvailable(username);
        if (!nameAvailable) {
            map.put("msgname", "用户名重复");
        }

        user.setName(username);
        boolean register = userService.register(user);

        if (register) {
            User login = userService.login(user);

            map.put("code", 0);
            session.setAttribute("user", login);
        }else {
            map.put("msg", "fail");
        }

        return map;

    }


    @ResponseBody
    @RequestMapping("/login/")
    public Map<String,Object> login(User user, String username, HttpSession session){


        user.setName(username);
        User login = userService.login(user);

        System.out.println(login);

        HashMap<String, Object> map = new HashMap<>();

        if (login!=null) {
            map.put("code", 0);
            session.setAttribute("user", login);
        }else {
            map.put("msgname","用户名或密码错误");
            map.put("msgpwd","用户名或密码错误");
        }

        return map;
    }

    @RequestMapping("/logout/")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/hackernews";
    }


    @RequestMapping("/user/{id}/")
    public String userInfo(@PathVariable("id") Integer id,
                                       Model model){

        User user = userService.findUserById(id);

        model.addAttribute("user",user);

        return "personal";
    }


    /**登录后评论，待解决*/
    @RequestMapping("/")
    public String pop(Integer pop){
        if (pop==0){
            return "/hackernews";
        }
        return "";
    }

}
