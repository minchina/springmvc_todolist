<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
  <title>TODO主页</title>
  <link rel="stylesheet" type="text/css" href="/static/bower_components/todomvc-common/base.css">
  <link rel="stylesheet" href="/static/bower_components/bootstrap/dist/css/bootstrap.css">
</head>
<body>

<header id="header">
  <h1>ToDos</h1>
  <a href="users" class="btn btn-primary btn-lg" role="button">用户列表</a>
</header>

<section id="main" style="display: block;">
  <ul id="todo-list">

    <c:forEach items="${allToDos}" var="toDo">
      <li data-id="${toDo.id}" ${toDo.done==1? "class='completed'":""}>
        <input class="hidden" value="${toDo.done}">
        <div class="view">
          <label>${toDo.name}</label>
          <button class="destroy"></button>
        </div>
        <input class="edit" value="${toDo.name}">
      </li>
    </c:forEach>

  </ul>
</section>

<script  src="/static//bower_components/jquery/dist/jquery.js"  ></script>

</body>
</html>
