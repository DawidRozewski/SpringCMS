<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Add new category</h2>

<form:form modelAttribute="category">
    <form:hidden path="id"/>
    Name: <form:input path="name"/><br/>
    <form:errors path="name"/><br/>

    Description: <form:input path="description"/><br/>

    <input type="submit" value="Zapisz"> <br/>
</form:form>

<a href="/category/all">Show all categories</a><br/>