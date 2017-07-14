<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<head>
<script>
function search(){
	window.location.href = "/task3/a/u/shhowUser?id=1";
	}
</script>
</head>

<body>
你好 JSP
 	
<br>

<table>
<tr>
<td>
<button id="btn" onclick="search()">跳转</button>
</td>
<td>
<%=new Date().toLocaleString()%>
</td>
</tr>
</table>

</body>
