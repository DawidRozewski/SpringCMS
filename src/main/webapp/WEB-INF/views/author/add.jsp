<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Add new author</h2>

<form:form modelAttribute="author">
    <form:hidden path="id"/>
    Name: <form:input path="firstName"/><br/>
    Description: <form:input path="lastName"/><br/>
    <input type="submit" value="Save"> <br/>
</form:form>

<a href="/all">Show all authors</a><br/>