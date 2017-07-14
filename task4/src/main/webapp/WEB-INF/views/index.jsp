<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>


<!--轮播图 begin-->
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="images/banner-1.jpg">
        </div>
        <div class="item">
            <img src="images/banner-2.jpg">
        </div>
        <div class="item">
            <img src="images/banner-3.jpg">
        </div>
        <div class="item">
            <img src="images/banner-4.jpg">
        </div>
    </div>
    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    </a>
</div>
<!--轮播图 end-->
<!--轮播下的大图标开始-->
<div class="main-middle-1 container">
    <div class="row">
        <div class="col-md-3 col-sm-12 advantage">
            <div class="efficient"></div>
            <h2>高效</h2>
            <p>将五到七年的成长时间，缩短到一年到三年。</p>
        </div>
        <div class="col-md-3 col-sm-12 advantage">
            <div class="normalized"></div>
            <h2>规范</h2>
            <p>标准的实战教程，不会走弯路</p>
        </div>
        <div class="col-md-3 col-sm-12 advantage">
            <div class="contacts"></div>
            <h2>人脉</h2>
            <p>同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。</p>
        </div>
        <div class="col-md-3 col-sm-12 hidden-sm hidden-xs main-middle-1-right">
            <i class="user"></i>
            <span>12400</span>
            <p>累计在线学习人数</p>
            <i class="user"></i>
            <span>12400</span>
            <p>学员已经找到满意工作</p>
        </div>
    </div>
</div>
<div class="main-middle-2 container">
    <h2>如何学习</h2>
    <div class="row">
        <ul class="list">
            <li class="col-lg-3 col-md-6 col-sm-6 col-xs-12 text-center">
                <span class="circle">1</span>
                <p>匹配你现在的个人情况寻找适合自己的岗位</p>
                <span class="arrow"></span>
            </li>
            <li class="col-lg-3 col-md-6 col-sm-6 col-xs-12 text-center">
                <span class="circle">2</span>
                <p>了解职业前景薪金待遇、竞争压力等</p>
                <span class="arrow"></span>
            </li>
            <li class="col-lg-3 col-md-6 col-sm-6 col-xs-12 text-center">
                <span class="circle">3</span>
                <p>掌握行业内顶级技能</p>
                <span class="arrow"></span>
            </li>
            <li class="col-lg-3 col-md-6 col-sm-6 col-xs-12 text-center">
                <span class="circle">4</span>
                <p>查看职业目标任务</p>
                <span class="arrow"></span>
            </li>
            <li class="col-lg-3 col-md-6 col-sm-6 col-xs-12 text-center">
                <span class="circle">5</span>
                <p>参考学习资源，掌握技能点，逐个完成任务</p>
                <span class="arrow"></span>
            </li>
            <li class="col-lg-3 col-md-6 col-sm-6 col-xs-12 text-center">
                <span class="circle">6</span>
                <p>加入班级，和小伙伴们互帮互助，一块学习</p>
                <span class="arrow"></span>
            </li>
            <li class="col-lg-3 col-md-6 col-sm-6 col-xs-12 text-center">
                <span class="circle">7</span>
                <p>选择导师，一路引导，加速自己成长</p>
                <span class="arrow"></span>
            </li>
            <li class="col-lg-3 col-md-6 col-sm-6 col-xs-12 text-center">
                <span class="circle">8</span>
                <p>完成职业技能，升级业界大牛</p>
                <span class="arrow"></span>
            </li>
        </ul>
    </div>
</div>
<div class="main-middle-3 container">
    <h2>优秀学员展示</h2>
    <div class="row">
        <ul class="show">
        
            <c:forEach items="${studentList}" var="sk">
                <li class="col-lg-3 col-md-6 col-sm-6 col-xs-12 text-center">
                    <div class="show-1">
                        <img class="avatar" src="images/${sk.avatar}.png">
                        <h2>${sk.type}：${sk.name}</h2>
                        <p>${sk.introduction}</p>
                    </div>
                </li>
            </c:forEach>
            
        </ul>
    </div>
    <div class="more">
        <div class="circle-2"></div>
        <div class="circle-2"></div>
        <div class="circle-2"></div>
        <div class="circle-2"></div>
    </div>
</div>
<div class="main-bottom container">
    <h2>战略合作企业</h2>
    <div class="row text-center">
        <div class="col-lg-1 col-md-1 hidden-sm hidden-xs"></div>
        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 img-bg">
            <img src="images/logo1-alibaba.jpg">
        </div>
        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 img-bg">
            <img src="images/logo2-jinshanyun.jpg">
        </div>
        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 img-bg">
            <img src="images/logo3-huanxin.jpg">
        </div>
        <div class="col-lg-2 col-md-2 col-sm-6 col-xs-12 img-bg">
            <img src="images/logo4-ronglian.jpg">
        </div>
        <div class="col-lg-2 col-md-2 col-sm-12 col-xs-12 img-bg">
            <img src="images/logo5-qiniu.png">
        </div>
        <div class="col-lg-1 col-md-1 hidden-sm hidden-xs"></div>
    </div>
</div>
<!--公共底部-->
