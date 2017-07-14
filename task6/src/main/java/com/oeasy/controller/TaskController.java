package com.oeasy.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.net.util.Base64;
import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oeasy.model.Student;
import com.oeasy.model.User;
import com.oeasy.service.StudentService;
import com.oeasy.service.UserService;
import com.oeasy.utils.DESUtil;
import com.oeasy.utils.MD5Util;
import com.oeasy.utils.MemcachedUtils;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
@Controller
@RequestMapping("/a")
public class TaskController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private UserService userService;
    //首页（无需登陆）
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        List<Student> studentList = studentService.select();
        String contextPath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath();
        model.addAttribute("contextpath", contextPath);
        model.addAttribute("studentList", studentList);
        return "index";
    }
    //职业（须登录）
    @RequestMapping(value = "/u/occupation.html", method = RequestMethod.GET)
    public String occupation(Model model, HttpServletRequest request) {
        String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
        System.out.println("路径：" + contextPath);
        model.addAttribute("contextpath", contextPath);
        return "occupation";
    }
    //Json 测试
    @RequestMapping(value = "/jsonTest.html", method = RequestMethod.GET)
    public String jsonTest(Model model, HttpServletRequest request) {
        List<Student> studentList = studentService.select();
        String contextPath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath();
        model.addAttribute("contextpath", contextPath);
        model.addAttribute("studentList", studentList);
        return "jsonTest";
    }
  //注册页面
    @RequestMapping(value = "/register.html", method = RequestMethod.POST)
    public String register(@RequestParam("user") String user, @RequestParam("passwd") String password) {
        String md5 = MD5Util.stringToMD5(password);
        userService.insert(user, md5);
        MemcachedUtils.add("user", new User("test",md5), new Date(10000000));//1000秒过期
        User usertest = (User)(MemcachedUtils.get("user"));
        System.err.println("用户名："+usertest.getUsername() + "，密码：" + usertest.getPassword());
        return "ok";
    }
    //登录页面
    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    //登录失败页面
    @RequestMapping(value = "/login/no.html", method = RequestMethod.GET)
    public String error() {
        return "no";
    }
    //登录处理
    @RequestMapping(value = "/login/validate", method = RequestMethod.POST)
    public void Validate(@RequestParam("username") String username, @RequestParam("password") String password,
                         HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String md5 = MD5Util.stringToMD5(password);
        //先是验证有无，返回true or false
        if (userService.verification(username, md5)) {
            User user = userService.selectByUsername(username);
            Long id = user.getId();
            Long createDate = new Date().getTime();
            String str = id + "=" + createDate;
            //加密
            byte[] result = DESUtil.desCrypto(str, "12345678");

            //把加密的字节数组转换成16进制
//            String results = TypeUtil.bytesToHexString(result);
            String results = Base64.encodeBase64String(result);
            /*Cookie 里面放的是 用户的id 和 创建时间*/
            Cookie cookie = new Cookie("token", results);
            cookie.setMaxAge(60 * 60 * 24 * 7);//7天
            cookie.setPath("/");
            System.out.println("新生成cookie和其MaxAge：" + cookie.getName() + "-->" + cookie.getMaxAge());
            httpServletResponse.addCookie(cookie);
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user", user);
            for (Cookie c : httpServletRequest.getCookies()) {
                System.out.println("cookes添加到response后重新获取cookies和其MaxAge：" + c.getName() + "-->" + c.getMaxAge());
            }
            try {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/a/index.html");
//                httpServletRequest.getRequestDispatcher("/index.html").forward(httpServletRequest, httpServletResponse);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/a/no.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //退出
    @RequestMapping(value = "/logout.html", method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("token")) {
                Cookie cookieKiller = new Cookie(c.getName(), "");
                /*同样的cookie名字 可以代替 原来的那个，设置 有效时间为o 就可以注销 */
                cookieKiller.setMaxAge(0);
                /**
                 * 删除 Cookie 时，只设置 maxAge=0 将不能够从浏览器中删除 cookie,
                 * 因为一个 Cookie 应当属于一个 path 与 domain，所以删除时，Cookie 的这两个属性也必须设置。
                 *
                 * 误区: 刚开始时，我没有发现客户端发送到服务器端的 cookie 的 path 与 domain 值为空这个问题。
                 * 因为在登陆系统时，我设置了 Cookie 的 path 与 domain 属性的值, 就误认为每次客户端请求时，都会把 Cookie 的
                 * 这两个属性也提交到服务器端，但系统并没有把 path 与 domain 提交到服务器端 (提交过来的只有 Cookie 的 key，value 值)。
                 */ 
                // 重点是这里 1, 必须设置 domain 属性的值 ??
                cookieKiller.setValue(null); 
                // 重点是这里 2, 必须设置 path 属性的值 
                cookieKiller.setPath("/");
                response.addCookie(cookieKiller);
                break;
            }
        }
        HttpSession session = request.getSession();
        /*不仅cookie 要注销，用户也要注销*/
        session.setAttribute("user", null);
        try {
            response.sendRedirect(request.getContextPath()+"/a/index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
