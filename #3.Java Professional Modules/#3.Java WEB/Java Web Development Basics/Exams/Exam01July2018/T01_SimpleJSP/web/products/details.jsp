<%@ page import="java.util.List" %>
<%@ page import="app.Product" %>
<%@ page import="java.util.LinkedList"%>
<%@ page import="app.ProductRepository" %><%--
<%--
  Created by IntelliJ IDEA.
  User: Gosho
  Date: 21-Aug-18
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<%
    String productName = request.getParameter("productName");
    Product product = ProductRepository.getByName(productName);
%>
<p>Name:<%=product.getName()%></p>
<p>Description:<%=product.getDescription()%></p>
<p>Type:<%=product.getType()%></p>
<a href="/products/all.jsp">Back</a>
</body>
</html>
