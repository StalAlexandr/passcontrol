<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<table>

<h1>Посетители: </h1>

<tr>
   <th>Фамилия</th>
   <th>Имя</th>
   <th>Номер карточки</th>
 </tr>

<#list persons as person>
    <tr>
        <td>${person.lastName}</td>
        <td>${person.firstName}</td>
        <td>${person.cardNumber}</td>
    </tr>
</#list>
</table>
</body>
</html>