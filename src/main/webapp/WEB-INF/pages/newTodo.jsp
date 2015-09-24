<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NEW TODO PAGE</title>
    <link rel="stylesheet" href="../../static/styles/todo.css" />
    <link rel="stylesheet" href="<c:url value="/static/bower_components/bootstrap/dist/css/bootstrap.css" />" />
    <script type="text/javascript" src="../../static/bower_components/jquery/dist/jquery.min.js" ></script>
    <script type="text/javascript" src="../../static/js/jquery.formality-1.2.2.js"></script>
    <script type="text/javascript" src="../../static/js/jquery.tmpl.js" ></script>
    <script type="text/javascript" src="../../static/js/newToDo.js" ></script>
</head>
<body>

<h1>All todos</h1>
<div id="todos">

    <span>${flag}</span>

    <c:forEach var="todo" items="${todos}">
    <div>
        <span>${todo.name}</span>
    </div>
</c:forEach>
</div>

<form  class="todo" name="NewToDoPageForm" method="post" action="/v1/todo/add">
    <div id="test_format" >
        Todo Name:<input type="text" name="name" value="${newtodo.name}" required>

        <input type="text" name="gender" value="${newtodo.gender}">

        <input name="name" type="text" class="hidden" value="${newtodo.userForm.name}">

        <button type="button" id="test_tmpl">Test Tmpl</button>
    </div>
    <button type="button" id="submit_todo">Click Me To Submit</button>
</form>

<script id="newTodoTemplate"  type="text/x-jQuery-tmpl">
     Todo Name:<input type="text" class="hasReplaced" name="name"  required>

        <input type="text" name="gender">

        <input name="name" type="text" class="hidden">

        <button type="button" id="test_tmpl">Test Tmpl</button>
</script>

<script type="text/javascript" >
    $(document).ready(function(){
        Equote.init().addListenr();
    })
</script>
</body>
</html>
