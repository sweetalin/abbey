<%@ page language="java" import="java.util.*"%>
<%@ page import="task1.*"%>
<%@ page contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>HAHA</title>
  </head>
  
  <body>
  <table border="1">
      <tr>
          <td>stu_id</td>
          <td>qq</td>
          <td>name</td>
          <td>type</td>
          <td>schoole_day</td>
          <td>gra_university</td>
          <td>online_id</td>
          <td>day_report</td>
          <td>wish</td>
          <td>rec_senior</td>
                   
          <td>check_senior</td>
          <td>create_at</td>
          <td>update_at</td>
      </tr>
        <%
           UserDao dao=new UserDaoImpl();
           List<User> list =dao.findAll();    
           for(User tl:list)
           {%>
          <tr>
              <td><%=tl.getStu_id() %></td>
              <td><%=tl.getQq() %></td>
              <td><%=tl.getName() %></td>
              <td><%=tl.getType() %></td>
              <td><%=tl.getSchool_day() %></td>
              <td><%=tl.getGra_university() %></td>
              <td><%=tl.getOnline_id() %></td>
              <td><%=tl.getDay_report() %></td>
              
              <td><%=tl.getWish() %></td>
              <td><%=tl.getRec_senior() %></td>
              <td><%=tl.getCheck_senior() %></td>
              <td><%=tl.getCreate_at() %></td>
              <td><%=tl.getUpdate_at() %> </td>
          </tr>
            <%}
       %>
  </table>
  </body>
</html>