<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jsonTest</title>
</head>
<body>
<c:forEach var="stu" items="${studentList}" varStatus="status">
<json:object>  
      <json:property name="id" value="${stu.id }"/>
      <json:property name="name" value="${stu.name }"/>
      <json:property name="type" value="${stu.type }"/>
</json:object>
</c:forEach>
<%-- <json:object>  
      <json:property name="itemCount" value="${cart.itemCount}"/>  
      <json:property name="subtotal" value="${cart.subtotal}"/>  
      <json:array name="items" var="item" items="${cart.lineItems}">  
        <json:object>  
          <json:property name="title" value="${item.title}"/>  
          <json:property name="description" value="${item.description}"/>  
          <json:property name="imageUrl" value="${item.imageUrl"/>  
          <json:property name="price" value="${item.price}"/>  
          <json:property name="qty" value="${item.qty}"/>  
        </json:object>  
      </json:array>  
    </json:object>   --%>
</body>
</html>