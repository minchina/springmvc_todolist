<%--
  Created by IntelliJ IDEA.
  User: ncmao
  Date: 8/25/15
  Time: 10:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File Page</title>
</head>
<body>
<form method="POST" action="/file/uploadFile" enctype="multipart/form-data">
  File to upload: <input type="file" name="file"><br />
  Name: <input type="text" name="name"><br /> <br />
  <input type="submit" value="Upload"> Press here to upload the file!
</form>

</body>
</html>
