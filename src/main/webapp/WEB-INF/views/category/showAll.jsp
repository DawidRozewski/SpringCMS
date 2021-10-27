<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<head>
    <title>Categories</title>
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
        <th>Name</th>
        <th>Description</th>
        <th>Edit / Delete</th>
    </tr>

    <c:forEach var="c" items="${categories}">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.description}</td>
            <td><a href="edit?id=${c.id}">Edit</a>
                <a href="remove?id=${c.id}">Delete</a> </td>
        </tr>
    </c:forEach>

</table>
<p>
    <a href="/category/add">Add new category</a><br/></p>

</body>