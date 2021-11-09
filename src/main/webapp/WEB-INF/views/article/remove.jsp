<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Czy chcesz usunac artykuł ${article.id} ?</h2>

<form method="post">
    <input type="hidden" name="id" value="${article.id}">
    <button type="submit" value="yes" name="confirmed">TAK</button>
    <button type="submit" value="no" name="confirmed">NIE</button>
</form>