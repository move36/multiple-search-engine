<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Search</title>
	<link rel="stylesheet" type="text/css" href='<spring:url value="/resources/css/se.css" htmlEscape="true" />'>
  </head>
  <body>
  	 <form action='<spring:url value="/search" htmlEscape="true" />'>
   		<b>Search:</b>
   		<input name="term" type="text" />
   		<input type="submit" class="button" />
 	</form>
 	<div>
	    <c:forEach var="result" items="${results}">
	 		<div>
				<img height="20" src='<spring:url value="/resources/img/${result.engine}.gif" htmlEscape="true" />'/>
				<a href="${result.url}">${result.title}</a><br/>
				${result.description}<br/>
				<a href="${result.url}">${result.url}</a><br/>
				<br/>
		 	</div>
	    </c:forEach>
 	</div>
  </body>
</html>