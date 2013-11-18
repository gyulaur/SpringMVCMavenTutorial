<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kikölcsönzött könyvek:</title>
</head>

<body>
	<table border="2">
		<thead>
			<tr>
				<td>Tag neve</td>
		        <td>Telefonszáma</td>
		        <td>Címe</td>
		        <td>Könyv címe</td>
		        <td>Könyv írója</td>
		        <td>Kölcsönzés dátuma</td>
			</tr>
		</thead>
		<c:if test="${not empty rentedBooksByMemberList}">
		    <c:forEach var="rentedBooksByMember" varStatus="status" items="${rentedBooksByMemberList}">
		        <c:if test="${not empty rentedBooksByMemberList}">
				    <c:forEach var="rentedBook" varStatus="status" items="${rentedBooksByMember.rentedBookList}">
					    <tr>
					    	<td><c:out value="${rentedBooksByMember.member.fullName}"/></td>
					        <td><c:out value="${rentedBooksByMember.member.phoneNumber}"/></td>
					        <td><c:out value="${rentedBooksByMember.member.city}"/></td>
					        <td><c:out value="${rentedBook.title}"/></td>
					        <td><c:out value="${rentedBook.author}"/></td>
					        <td><fmt:formatDate value="${rentedBook.rentedDate}" pattern="yyyy-MM-dd" /></td>						        
					    </tr>
				    </c:forEach>
    			</c:if>
		    </c:forEach>
	    </c:if>
	</table>
	<input type="button" name="cancel" onclick="location.href='home'" value="Vissza"/>
</body>

</html>