<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Könyv kikölcsönzése</title>
</head>

<body>
<form:form action="rentabook" commandName="rentedBooksByMember">
    <fieldset>
    	<div class="form-row">
    		<label for="member.id">Kölcsönző:</label>
            <span class="input">
		     	<form:select path="member.id" multiple="single"> 
		      		<form:option value="0" label="<----select---->"/> 
		     		<form:options items="${memberList}" itemValue="id" itemLabel="fullName"/> 
		     	</form:select> 
	     	</span>
	     	<font color="red"><form:errors path="member.id"/></font>     	
     	</div>
     	<div class="form-row">
	     	<label>Könyvek:</label>
	     	<span class="input">
		   		<c:forEach items="${bookList}" var="book" varStatus="i">
					<div class="form-row">
						<form:checkbox path="rentedBookList[${i.index}].id" value="${book.id}" label="${book.titleWithAuthor}" />
						<font color="red"><form:errors path="rentedBookList[${i.index}].id"/></font>
					</div>
		    	</c:forEach>
	    	</span>
    	</div>
    	   	
        <div class="form-buttons">
            <div class="button">
                <input type="submit" name="submit" value="Kikölcsönöz"/>
                <input type="button" name="cancel" onclick="location.href='home'" value="Mégse"/>          
            </div>    
        </div>
    </fieldset>
</form:form>
</body>

</html>