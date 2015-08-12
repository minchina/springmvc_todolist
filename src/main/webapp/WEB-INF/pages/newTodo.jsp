
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NEW TODO PAGE</title>
    <script type="text/javascript" src="../../static/bower_components/jquery/dist/jquery.min.js" ></script>
    <script type="text/javascript" src="../../static/js/jquery.formality-1.2.2.js"></script>
    <script type="text/javascript" src="../../static/js/test.js" ></script>
</head>
<body>

<form name="NewToDoPageForm" method="post" action="/v1/todo/add">
    <div id="test_format" >
        <input type="text" name="name" >
        <input type="text" name="age">
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
