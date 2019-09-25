<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<table>

<h1>Действующие абонементы: </h1>

<tr>
   <th>Курс</th>
   <th>Клиент</th>
   <th>Дата начала</th>
   <th>Дата окончания</th>
   <th>Всего занятий</th>
   <th>Осталось занятий</th>
 </tr>

<#list passes as pass>
    <tr>
        <td>${pass.course.name}</td>
        <td>${pass.person.lastName} ${pass.person.firstName}</td>
        <td>${pass.launchDate?datetime?string("yyyy/MM/dd")}</td>
        <td>${pass.terminateDate?datetime?string("yyyy/MM/dd")}</td>
        <td>${pass.itemCount}</td>
        <td>${pass.currentItemCount}</td>
    </tr>
</#list>
</table>
</body>
</html>