package com.controller;

import com.domain.Permis;
import com.domain.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.UsersService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Resource(name = "usersServiceImpl")
    UsersService usersService;
/*    @RequestMapping(value = "/n/login")
    public void a() {
        System.out.println("a");
    }

    @RequestMapping(value = "/y/b/b")
    public void b(String name,String pwd) {
        Subject subject = SecurityUtils.getSubject();// 获取到Subject
        UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
        try {
            subject.login(token);
            System.out.println("登录成功");
        }catch (Exception e){
            System.out.println("用户名密码不存在");
        }

    }
    @RequiresAuthentication
    @RequiresPermissions(value={"user:update2"})
    @RequestMapping(value = "/y/p/c")
    public void c() {
        System.out.println("c");
    }

    @RequiresAuthentication
    @RequiresPermissions(value={"user:update"})
    @RequestMapping(value = "/y/d")
    public void d() {
        System.out.println("d");
    }*/

    @RequestMapping(value="/login" )
    public String login(HttpServletRequest request, Users users){
        Subject subject = SecurityUtils.getSubject();// 获取到Subject
        UsernamePasswordToken token = new UsernamePasswordToken(users.getUsername(), users.getUserpwd());
        try {
            subject.login(token); //只有这里成功，表示authc过滤器才能通过(表示登录成功)
           Users user = (Users)request.getSession().getAttribute("loginuser");
            System.out.println("登录成功"+user.getUsername());
            return "redirect:usersmenu";
        }catch (Exception e){
            System.out.println("登录失败");
        }
        return "forward:index.jsp";
    }

    /**
     * 登陆用户的后台主菜单
     *
     * @return
     */
    @RequiresAuthentication
    @RequestMapping("/usersmenu")
    public String usersMenu(HttpServletRequest request) {

        Users users = (Users) request.getSession().getAttribute("loginuser");
        List<Permis> permisList = usersService.selectPermisByUsersId2(users);
        List<Map<String ,Object>> listm=new ArrayList<>();
        for (Permis permis : permisList) {
            Map<String ,Object> m=new HashMap<>();
            m.put("id",permis.getId());
            m.put("pId",permis.getParent());
            m.put("name",permis.getPermistitle());
            m.put("url",permis.getHref());
            m.put("target","midframe");
            listm.add(m);
        }

        String s= new ObjectMapper().valueToTree(listm).toString();
        System.out.println(s);
        request.setAttribute("trees",s);
        return "usersmenu";
    }
}
