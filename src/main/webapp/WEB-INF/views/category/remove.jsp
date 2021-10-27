<h2>Czy chcesz usunac kategorie ${category.name} ?</h2>

<form method="post">
    <input type="hidden" name="id" value="${category.id}">
    <button type="submit" value="yes" name="confirmed">TAK</button>
    <button type="submit" value="no" name="confirmed">NIE</button>
</form>