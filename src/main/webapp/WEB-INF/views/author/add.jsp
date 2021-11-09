<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Add new author</h2>

<head>
    <style>
        .error {
            color: red;
        }
    </style>
</head>


<form:form modelAttribute="author">
    <form:hidden path="id"/>

    FirstName: <form:input path="firstName"/><br/>
    <form:errors path="firstName" cssClass="error"/> <br/>

    LastName: <form:input path="lastName"/><br/>
    <form:errors path="lastName" cssClass="error"/><br/>

    <input type="submit" value="Save"> <br/>
</form:form>

<a href="/author/all">Show all authors</a><br/>