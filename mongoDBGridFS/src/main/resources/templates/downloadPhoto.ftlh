<html>
<body>
<h1>Upload new Photo</h1>
<form method="POST" action="/saveFile" enctype="multipart/form-data">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    Title:<label>
        <input type="text" name="title" />
    </label>
    Image:<input type="file" name="file"/>
    <input type="submit" value="Upload" />
</form>
</body>
</html>