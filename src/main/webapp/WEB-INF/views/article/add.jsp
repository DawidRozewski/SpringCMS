<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Add new article</h2>

<form:form modelAttribute="article">
    <form:hidden path="id"/>
    Title: <form:input path="title"/><br/>
    Author: <form:select path="author" items="${authors}" itemLabel="fullName" itemValue="id"/><br/>
    Categories: <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id" multiple="true"/><br/>
    Content: <form:input path="content"/><br/>

    <input type="submit" value="save"><br/>
</form:form>