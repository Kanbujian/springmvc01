<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
	    .inCenter{
	      margin:20px auto;width:600px 
	    }
	</style>

  </head>
  
  <body>
    <div class="inCenter">
       <p style="text-align:center"><a  href="add">添加</a>-----<a href="${LoginUser.username }/show">${LoginUser.username }</a></p>
       <c:forEach items="${users }" var="userMap">
       <a href="${userMap.value.username }/show">${userMap.value.username } </a>   --------  
       ${userMap.value.password }    --------
       ${userMap.value.email }   -------<a href="${userMap.value.username}/update">修改</a>
       ------<a href="${userMap.value.username }/delete">删除</a></br>  
       
       </c:forEach>
    </div><br>
  </body>
</html>
