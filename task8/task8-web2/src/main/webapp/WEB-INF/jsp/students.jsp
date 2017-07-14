<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:object >
<json:property name="name" value="${student}"></json:property>
</json:object>
<body>
web2----------------------------------
</body>
</html>
<%-- <c:forEach var="stu" items="${student}" varStatus="status">
<json:object>  
      <json:property name="id" value="${stu.id }"/>
      <json:property name="name" value="${stu.name }"/>
      <json:property name="type" value="${stu.type }"/>
</json:object>
</c:forEach> --%>

