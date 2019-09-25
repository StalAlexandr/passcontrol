<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<table>

<h1>История уроков на ${date?string("yyyy/MM/dd")}</h1>

<tr>
   <th>Курс</th>
   <th>Клиент</th>
 </tr>

<#list lessons as lesson>
    <tr>
        <td>${lesson.courseLevel.name}</td>
        <td>${lesson.pass.person.lastName} ${lesson.pass.person.firstName}</td>
    </tr>
</#list>
</table>
</body>
</html>