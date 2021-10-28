<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<head>
    <title>Articles</title>
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
        <th>Title</th>
        <th>Authors</th>
        <th>Categories</th>
        <th>Content</th>
        <th>Created</th>
        <th>Updated</th>
        <th>Edit / Remove</th>
    </tr>

    <c:forEach var="a" items="${articles}">
        <tr>
            <td>${a.id}</td>
            <td>${a.title}</td>
            <td>${a.author}</td>
            <td><c:forEach items="${a.categories}" var="c" varStatus="loop">
                ${c.name}
                <c:if test="${loop.index + 1 lt a.categories.size()}">; </c:if>
            </c:forEach></td>
            <td>${a.content}</td>
            <td>${a.created}</td>
            <td>${a.updated}</td>
            <td><a href="edit?id=${a.id}">Edit</a>
                <a href="remove?id=${a.id}">Remove</a> </td>
        </tr>
    </c:forEach>

</table>
<p>
    <a href="/author/add">Add new author</a><br/></p>

</body>