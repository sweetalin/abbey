package com.oeasy.interceptor;

import com.oeasy.service.UserService;
import com.oeasy.utils.DESUtil;

import org.apache.commons.net.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author alin
 *
 * 2017年6月13日
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies) {
            System.out.println("拦截器获取cookiesde的name，value 和 MaxAge："  + c.getName()+ "-->" + c.getValue() + "-->" + c.getMaxAge());
        }
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("token")) {
                    String token = cookies[i].getValue();
                    System.out.println("token的内容-------》" + token);

                    //byte[] tk1 = TypeUtil.hexStringToByte(token);
                    byte[] tk1 = Base64.decodeBase64(token);

                    byte[] tk2 = DESUtil.decrypt(tk1, "12345678");
                    String tk = new String(tk2);
                    System.out.println("解密后的token-------》" + tk);
                    String id = "";
                    String createTime = "";
                    for (int j = 0; j < tk.length(); j++) {
                        char c = tk.charAt(j);
                        if (c == '=') {
                            for (int k = j + 1; k < tk.length(); k++) {
                                createTime = createTime + tk.charAt(k);
                            }
                            break;
                        }
                        id = id + c;
                    }
                    System.out.println(id);
                    if (userService.selectByUserId(Long.parseLong(id)) != null) {
                        return true;
                    }
                }
            }
        }
        request.getSession();
        String contextPath = request.getContextPath();
        String uri = contextPath + "/a/login.html";
        response.sendRedirect(uri);
        return false;
/*        
        HttpSession session = request.getSession();
        if (null != session.getAttribute("user")) {
            return true;
        }
        String contextPath = request.getContextPath();
        String uri = contextPath + "/login.html";
        System.out.println("重定向路径：" + uri);
        response.sendRedirect(uri);
        return false;*/

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	System.out.println("postHandle");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    	System.out.println("afterCompletion");
    }
}
