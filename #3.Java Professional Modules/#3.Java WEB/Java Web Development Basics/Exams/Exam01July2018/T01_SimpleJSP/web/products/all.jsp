<%@ page import="java.util.List" %>
<%@ page import="app.Product" %>
<%@ page import="java.util.LinkedList"%>
<%@ page import="app.ProductRepository" %><%--
  Created by IntelliJ IDEA.
  User: Gosho
  Date: 21-Aug-18
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<%List<Product> products=new LinkedList<Product>(){{add(
        new Product("Chuskopek","A universal tool for","Domestic"));
    add(new Product("Injeqktor","Dunno what is this","Cosmetic"));
    add(new Product("Plumbus","A domestic tool for everything","Food"));}};
    ProductRepository.setProducts(products);
%>
<%for(Product product : products){%>
<h3>
    <a href="/products/details.jsp?productName=<%= product.getName()%>"><%= product.getName()%></a>
</h3>
<% } %>
</body>
</html>
