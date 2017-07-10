<html>
<body>
<h1>Hello World!</h1>

<table>
    <tr>
        <th>movie title</th>
        <th>producer</th>
        <th>genre</th>
    </tr>
    <#list films as film>
        <tr>
            <td>${film.film.name}</td>
            <td>${film.producer.name}  ${film.producer.surname} ${film.producer.patronymic}</td>
            <td>${film.genre.name}</td>
        </tr>
    </#list>
</table>
</body>
</html>