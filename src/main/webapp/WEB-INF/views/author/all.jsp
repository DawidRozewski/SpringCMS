<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<head>
    <title>Authors</title>
    <style>
        table, th, td {
            border-collapse: collapse;
            border: 1px solid black;
            padding: 5px;
        }
        th {
            background-color: #ccc;
        }
    </style>
</head>

<table>
    <tr>
        <th>Id</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Edit / Remove</th>
    </tr>

    <c:forEach var="a" items="${authors}">
        <tr>
            <td>${a.id}</td>
            <td>${a.firstName}</td>
            <td>${a.lastName}</td>
            <td><a href="edit?id=${a.id}">Edit</a>
                <a href="remove?id=${a.id}">Remove</a> </td>
        </tr>
    </c:forEach>

</table>
<p>
    <a href="/article/add">Add new article</a><br/></p>
    <a href="/author/add">Add new author</a><br/></p>
    <a href="/category/add">Add new category</a><br/></p>

    <strong><a href="/article/all"> Articles </a> </strong><br/>
    <strong><a href="/category/all"> Categories </a> </strong><br/>

</body>