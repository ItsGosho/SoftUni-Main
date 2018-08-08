<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<%@ page import="org.softuni.fdmc.data.repos.OrderRepository" %><%--
  Created by IntelliJ IDEA.
  User: Gosho
  Date: 08-Aug-18
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<h1>All Orders</h1>
<hr />
<%
    List<String> orderDetails=new LinkedList<>();
    ((OrderRepository) application.getAttribute("orders")).getOrders().stream()
            .sorted((x1,x2)-> x2.getMadeOn().compareTo(x1.getMadeOn()))
            .forEach(x->{
                orderDetails.add("Buyer: "+x.getUser().getUsername()+" Cat: "+x.getCat().getName()+" On: "+x.getMadeOn());
            });%>
<% for(String name : orderDetails) { %>
<h3>
    <%=name%>
</h3>
<% } %>
<br />
<a href="/">Back to Home</a>
</body>
</html>
