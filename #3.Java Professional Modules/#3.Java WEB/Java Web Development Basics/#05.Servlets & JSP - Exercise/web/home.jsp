<%@ page import="org.softuni.fdmc.data.repos.UserRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
<h1>Welcome to Fluffy Duffy Munchkin Cats!</h1>
<%=session.getAttribute("username") == null
         ? "<h3>Login if you have an account, or Register if you don't! The first registered is the Admin :)!</h3>"
         : "<h3>Navigate through the application using the links below!</h3>"
%>
<hr/>
<% if (session.getAttribute("username") == null) { %>
<a href="/users/login">Login</a>
<br/>
<a href="/users/register">Register</a>
<% } else if(((UserRepository)session.getServletContext().getAttribute("users")).getByUsername((String) session.getAttribute("username")).getClass().getSimpleName().equals("Admin")) { %>
<a href="/cats/create">Create Cat</a>
<br/>
<a href="/cats/all">All Cats</a>
<br/>
<a href="/users/logout">Logout</a>
<br/>
<a href="/orders/allOrders">Orders</a>
<br/>
<%}else{%>
<a href="/cats/all">All Cats</a>
<br/>
<a href="/users/logout">Logout</a>
<br/>
<% } %>
</body>
</html>
