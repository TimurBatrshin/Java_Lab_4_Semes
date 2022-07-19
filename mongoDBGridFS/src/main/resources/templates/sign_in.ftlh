<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring/>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form action="/sign_in" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input name="email" placeholder="EMAIL">
    <input name="password" placeholder="PASSWORD">
    <button type="submit">войти</button>
</form>

</body>
</html>