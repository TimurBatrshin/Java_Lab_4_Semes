<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<table>
    <tr>
        <th>Email</th>
        <th>Id</th>
    </tr>

    <#if users??>
        <#list users as user>
            <tr>
                <th>${user.email}</th>
                <th>${user.id}</th>
            </tr>
        </#list>
    </#if>

</table>
</body>
</html>