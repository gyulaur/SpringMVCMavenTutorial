<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Könyv törlése</title>
</head>

<body>
<form:form action="deletebook" commandName="book">
    <fieldset>
     	<form:select path="id" multiple="single"> 
      		<form:option value="0" label="<----select---->"/> 
     		<form:options items="${bookList}" itemValue="id" itemLabel="titleWithAuthor"/> 
     	</form:select> 
        
        <div class="form-buttons">
            <div class="button">
                <input type="submit" name="submit" value="Törlés"/>
                <input type="button" name="cancel" onclick="location.href='home'" value="Mégse"/>          
            </div>    
        </div>
    </fieldset>
</form:form>
</body>

</html>