<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Új könyv felvétele</title>
</head>

<body>
<form:form action="savebook" commandName="book">
	<form:hidden path="id" />
    <fieldset>
        <div class="form-row">
            <label for="author">Szerző:</label>
            <span class="input"><form:input path="author" /></span>
        </div>       
        <div class="form-row">
            <label for="title">Cím::</label>
            <span class="input"><form:input path="title" /></span>
        </div>
        <div class="form-row">
            <label for="quantity">Mennyiség:</label>
            <span class="input"><form:input path="quantity" placeholder="darab"/></span>
            <font color="red"><form:errors path="quantity"/></font>
        </div>
        <div class="form-buttons">
            <div class="button">
                <input type="submit" name="submit" value="Mentés"/>
                <input type="button" name="cancel" onclick="location.href='home'" value="Mégse"/>          
            </div>    
        </div>
    </fieldset>
</form:form>
</body>

</html>