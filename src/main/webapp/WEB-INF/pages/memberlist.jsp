<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.springmvcmaventutorial.bean.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tagok listája</title>
</head>
<body>
	<table border="2">
		<thead>
			<tr>
				<td>Vezetéknév</td>
		        <td>Keresztnév</td>
		        <td>Telefonszám</td>
		        <td>Születési dátum</td>
		        <td>Város</td>
		        <td>Irányítószám</td>
		        <td>Cím</td>
			</tr>
		</thead>
		<c:if test="${not empty memberList}">
		    <c:forEach var="member" varStatus="status" items="${memberList}">
			    <tr>
			        <td><c:out value="${member.firstName}"/></td>
			        <td><c:out value="${member.lastName}"/></td>
			        <td><c:out value="${member.phoneNumber}"/></td>			        
			        <td><fmt:formatDate value="${member.birthDate}" pattern="yyyy-MM-dd" /></td>
			        <td><c:out value="${member.city}"/></td>
			        <td><c:out value="${member.zipCode}"/></td>
			        <td>
				        <c:out value="${member.streetAddress1}"/>
				        <c:out value="${member.streetAddress2}"/>
				        <c:out value="${member.streetAddress3}"/>
			        </td>
			    </tr>
		    </c:forEach>
	    </c:if>
	</table>
	<input type="button" name="cancel" onclick="location.href='home'" value="Vissza"/>
</body>
</html>