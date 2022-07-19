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
<#if strings??>
    <#list strings as string>
        <img alt="sample" src="${'data:image/png;base64,'+string}"/>
    </#list>
</#if>
</body>
</html>