<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tag szerkesztése</title>
</head>

<body>
<form:form action="savemember" commandName="member">
	<form:hidden path="id" />
    <fieldset>
        <div class="form-row">
            <label for="firstName">Vezetéknév:</label>
            <span class="input"><form:input path="firstName" /></span>
        </div>       
        <div class="form-row">
            <label for="lastName">Keresztnév:</label>
            <span class="input"><form:input path="lastName" /></span>
        </div>
        <div class="form-row">
            <label for="birthDate">Születési idő:</label>
            <span class="input"><form:input path="birthDate" placeholder="yyyy-MM-dd"/></span>
            <font color="red"><form:errors path="birthDate"/></font>
        </div>
        <div class="form-row">
            <label for="city">Város:</label>
            <span class="input"><form:input path="city" /></span>
        </div>
        <div class="form-row">
            <label for="zipCode">Irányítószám:</label>
            <span class="input"><form:input path="zipCode" /></span>
        </div>
        <div class="form-row">
            <label for="streetAddress1">cím:</label>
            <span class="input"><form:input path="streetAddress1" /></span>
        </div>
        <div class="form-row">
            <label for="streetAddress2"></label>
            <span class="input"><form:input path="streetAddress2" /></span>
        </div>
        <div class="form-row">
            <label for="streetAddress3"></label>
            <span class="input"><form:input path="streetAddress3" /></span>
        </div>
        <div class="form-row">
            <label for="phoneNumber">Telefonszám:</label>
            <span class="input"><form:input path="phoneNumber" /></span>
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