<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="<c:url value="/static/bower_components/todomvc-common/base.css" />"/>
    <link rel="stylesheet" href="<c:url value="/static/bower_components/bootstrap/dist/css/bootstrap.css" /> "/>
    <script src="<c:url value="/static/bower_components/jquery/dist/jquery.js" />"></script>
    <script  src="<c:url value="/static/js/jquery.tmpl.js" /> "></script>
    <script  src="<c:url value="/static/js/Utils.js" /> "></script>

    <title>用户列表</title>
</head>
<body>


<header id="header">
    <h1>用户列表</h1>
    <input id="new-todo" placeholder="请输入一个新用户" autofocus="">
</header>


<section id="main" style="display: block;">
    <ul id="todo-list">
        <c:forEach items="${allUsers}" var="User">
            <li data-id="${User.id}">
                <div class="view">
                    <a href="users/${User.name}/todos">${User.name}</a>
                    <button class="destroy"></button>
                </div>
            </li>
        </c:forEach>
    </ul>
</section>

<%--<script type='text/x-jquery-tmpl' id='newUserTemplate'>--%>
<%--<li data-id="${newUserId}">--%>
    <%--<div class="view">--%>
        <%--<a href="users/${newUserName}/todos">${newUserName}</a>--%>
        <%--<button class="destroy"></button>--%>
    <%--</div>--%>
<%--</li>--%>
<%--</script>--%>
<%--<div style="margin-top: 100px">--%>
<%--<jsp:include page="upload.jsp" />--%>
<%--</div>--%>

<script type='text/x-jquery-tmpl' id='person-template'>
  <div class='person'>
    <strong>Name: </strong> ${ Name } <br/>
    <strong>Age: </strong> ${ Age } <br/>
    <strong>Country: </strong> ${ Country } <br/>
  </div>

</script>

<script src="<c:url value="/static/js/user.js" />"></script>
</body>
</html>
