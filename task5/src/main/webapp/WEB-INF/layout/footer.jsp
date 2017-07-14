<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath %>" />
<footer>
    <div class="footer-top">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 link">
                    <h2>友情链接</h2>
                    <ul>
                        <li><a href="">手机软件</a></li>
                        <li><a href="">教师招聘</a></li>
                        <li><a href="">找工作</a></li>
                        <li><a href="">教师招聘</a></li>
                        <li><a href="">找工作</a></li>
                        <li><a href="">手机软件</a></li>
                        <li><a href="">教师招聘</a></li>
                        <li><a href="">手机软件</a></li>
                        <li><a href="">手机软件</a></li>
                        <li><a href="">找工作</a></li>
                        <li><a href="">手机软件</a></li>
                        <li><a href="">教师招聘</a></li>
                        <li><a href="">找工作</a></li>
                        <li><a href="">教师招聘</a></li>
                        <li><a href="">找工作</a></li>
                        <li><a href="">手机软件</a></li>
                        <li><a href="">教师招聘</a></li>
                        <li><a href="">手机软件</a></li>
                        <li><a href="">手机软件</a></li>
                        <li><a href="">找工作</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="footer-middle container">
        <div class="row">
            <div class="footer-middle-left col-lg-5 col-md-5 col-sm-6 col-xs-12">
                <p>技能树 — 改变你我</p>
                <ul>
                    <li><a href="">关于我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
                    <li><a href="">联系我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
                    <li><a href="">友情链接</a>&nbsp;&nbsp; &nbsp;&nbsp;</li>
                </ul>
            </div>
            <div class="footer-middle-middle col-lg-5 col-md-5 col-sm-6 col-xs-12">
                <p>旗下网站</p>
                <ul>
                    <li><a href="">草船云孵化器</a></li>
                    <li><a href="">最强IT特训营</a></li>
                </ul>
                <ul>
                    <li><a href="">葡萄藤轻游戏</a></li>
                    <li><a href="">桌游精灵</a></li>
                </ul>
            </div>
            <div class="footer-middle-right col-lg-2 col-md-2 col-sm-6 col-xs-12">
                <p>微信公众平台</p>
                <img src="${contextpath}/images/icon-footer-QRCodes.png">
            </div>
        </div>
    </div>
    <div class="footer-bottom">
        <p>Copyright © 2015技能树 www.jnshu.com All Rights Reserved | 京ICP备13005880号</p>
    </div>
</footer>
