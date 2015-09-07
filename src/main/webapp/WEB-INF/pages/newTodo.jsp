<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NEW TODO PAGE</title>
    <link rel="stylesheet" href="../../static/styles/todo.css" />
    <script type="text/javascript" src="../../static/bower_components/jquery/dist/jquery.min.js" ></script>
    <script type="text/javascript" src="../../static/js/jquery.formality-1.2.2.js"></script>
    <script type="text/javascript" src="../../static/js/jquery.tmpl.js" ></script>
    <script type="text/javascript" src="../../static/js/newToDo.js" ></script>
</head>
<body>

<h1>All todos</h1>
<div id="todos">

<c:forEach var="todo" items="${todos}">
    <div>
        <span>${todo.name}</span>
    </div>
</c:forEach>
</div>


<form  class="todo" name="NewToDoPageForm" method="post" action="/v1/todo/add">
    <div id="test_format" >
        Todo Name:<input type="text" name="name" value="${newtodo.name}">
        <select>
            <c:forEach varStatus="index" items="${newtodo.genders}">
                <option value="${newtodo.genders[index.index]}">${newtodo.genders[index.index]}</option>
            </c:forEach>
        </select>
    </div>

    <button type="button" id="submit_todo">Click Me To Submit</button>
</form>

<script type="text/javascript" >
    $(document).ready(function(){
        Equote.init().addListenr();
    })
</script>
</body>
</html>
