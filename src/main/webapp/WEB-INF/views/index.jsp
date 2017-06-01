<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zouyuanfeng
  Date: 2017/6/1
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<c:out value="aa"/>
${END}
<form action="fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <button type="submit">提交</button>
</form>
</body>
</html>
