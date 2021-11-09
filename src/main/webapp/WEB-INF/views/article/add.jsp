<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Add new article</h2>
<head>
    <style>
        .error {
            color: red;
        }
    </style>
</head>


<form:form modelAttribute="article">
    <form:hidden path="id"/>
    Title: <form:input path="title"/><br/>
    <form:errors path="title" cssClass="error"/><br/>

    Author: <form:select path="author.id" items="${authors}" itemLabel="fullName" itemValue="id"/><br/>
    <form:errors path="author" cssClass="error"/><br/>

    Categories: <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id"
                             multiple="true"/><br/>
    <form:errors path="categories" cssClass="error"/><br/>

    Content: <form:input path="content"/><br/>
    <form:errors path="content" cssClass="error"/><br/>

    <input type="submit" value="Save"><br/>
</form:form>
