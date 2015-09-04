<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ncmao
  Date: 9/4/15
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="<c:url value="/static/bower_components/bootstrap/dist/css/bootstrap.css" />" />
<link rel="stylesheet" href="<c:url value="/static/styles/premium.css" />" />
<html>
<head>
    <title>PremiumSummary</title>
</head>
<body>
<h1>Premium Summary</h1>

<div class="Summary" id="premiumSummary">
</div>

<script  src="<c:url value="/static/bower_components/jquery/dist/jquery.js" />"></script>
<script  src="<c:url value="/static/js/jquery.tmpl.js" />"></script>
<script  src="<c:url value="/static/bower_components/bootstrap/dist/js/bootstrap.min.js" />"></script>
<script  src="<c:url value="/static/js/premiumSummary.js" />"></script>
</body>

<script type="text/javascript">
    $(window).ready(function(){
        Equote.premium().startup();

    })
</script>
</html>
