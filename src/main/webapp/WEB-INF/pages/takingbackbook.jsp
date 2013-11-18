<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Könyv visszavétele</title>
</head>

<body>
<form:form action="takingbackbook" commandName="takinkBackBookFromMember">
    <fieldset>
    	<form:hidden path="member.id"/>
    	<div class="form-row">
    		<label>Kölcsönző: ${member.fullName}</label>           
     	</div>
     	<div class="form-row">
	     	<label>Könyvek:</label>
	     	<span class="input">
		   		<c:forEach items="${rentedBookList}" var="book" varStatus="i">
					<div class="form-row">
						<form:checkbox path="rentedBookList[${i.index}].id" value="${book.id}" label="${book.titleWithAuthor}" />
					</div>
		    	</c:forEach>
	    	</span>
    	</div>
    	   	
        <div class="form-buttons">
            <div class="button">
                <input type="submit" name="submit" value="Visszavesz"/>
                <input type="button" name="cancel" onclick="location.href='home'" value="Mégse"/>          
            </div>    
        </div>
    </fieldset>
</form:form>
</body>

</html>