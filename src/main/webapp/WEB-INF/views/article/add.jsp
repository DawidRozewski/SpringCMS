<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Add new article</h2>

<form:form modelAttribute="article">
    Title: <form:input path="title"/><br/>
    Author: <form:select path="author" items="${author}" itemLabel="firstName" itemValue="id"/><br/>

    <input type="submit" value="save"><br/>

</form:form>