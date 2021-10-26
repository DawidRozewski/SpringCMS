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
        <th>Title</th>
        <th>Added</th>
        <th>Content</th>
    </tr>

    <%--@elvariable id="smurfs" type="java.util.List"--%>
    <c:forEach var="a" items="${articles}">
        <tr>
            <td>${a.title}</td>
            <td>${a.created}</td>
            <td>${a.content}</td>
        </tr>
    </c:forEach>

</table>

</body>