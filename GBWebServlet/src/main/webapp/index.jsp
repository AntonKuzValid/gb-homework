<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "List of products servlet" %>
</h1>
<h2>
    <%= "the number of products returned depends on the parameter"%>
</h2>
<h3>
    <%= "token = fullAccess"%>
</h3>
<h2>
    <%= "gives 10 randomly created products upon request with token:"%>
</h2>
<br/>
<a href="/GBWebServlet_war/getNew?getNew=10&token=fullAccess">/getNew?getNew=10</a>
<h2>
    <%= "gives 55 randomly created products upon request with token:"%>
</h2>
<a href="/GBWebServlet_war/getNew?getNew=55&token=fullAccess">/getNew?getNew=55</a>
<h2>
    <%= "gives 10 randomly created products upon request without token:"%>
</h2>
<br/>
<a href="/GBWebServlet_war/getNew?getNew=10">/getNew?getNew=10</a>
<h2>
    <%= "gives 55 randomly created products upon request without token:"%>
</h2>
<a href="/GBWebServlet_war/getNew?getNew=55">/getNew?getNew=55</a>
</body>
</html>