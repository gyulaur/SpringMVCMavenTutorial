<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.springmvcmaventutorial.bean.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kölcsönözhető könyvek listája</title>
</head>
<body>
	<table border="2">
		<thead>
			<tr>
				<td>Szerző</td>
		        <td>Cím</td>
		        <td>Mennyiség</td>
			</tr>
		</thead>
		<c:if test="${not empty bookList}">
		    <c:forEach var="book" varStatus="status" items="${bookList}">
			    <tr>
			        <td><c:out value="${book.author}"/></td>
			        <td><c:out value="${book.title}"/></td>
			        <td><c:out value="${book.quantity}"/></td>
			    </tr>
		    </c:forEach>
	    </c:if>
	</table>
	<input type="button" name="cancel" onclick="location.href='home'" value="Vissza"/>
</body>
</html>