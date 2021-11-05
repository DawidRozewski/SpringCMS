<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Add new article</h2>

<form:form modelAttribute="article">
    <form:hidden path="id"/>
    <label> Title: <form:input path="title"/></label><br/>
    <label> Author: <form:select path="author.id" items="${authors}" itemLabel="fullName" itemValue="id"/></label><br/>
    <label> Categories: <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id" multiple="true"/></label><br/>
    <label> Content: <form:input path="content"/></label><br/>
    <input type="submit" value="Save"><br/>
</form:form>
