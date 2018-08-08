<%@ page import="java.util.List" %>
<%@ page import="org.softuni.fdmc.data.models.Cat" %>
<%@ page import="org.softuni.fdmc.data.repos.CatRepository" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  PersonImp: atriu
  Date: 1.6.2018 г.
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
    <link rel="stylesheet" href="bootstrap.min.css">
</head>
<body>
    <h1>All Cats</h1>
    <hr />
    <%List<String> catNames=new LinkedList<>();
        ((CatRepository) application.getAttribute("cats")).getAllCats().stream()
            .sorted((x1,x2)-> Integer.compare(x2.getViews(),x1.getViews()))
            .forEach(x->{
        String catName=x.getName();
        catNames.add(catName);
    });%>
    <% for(String name : catNames) { %>
    <h3>
        <a href="/cats/profile?catName=<%= name%>"><%= name%></a>
    </h3>
    <% } %>
    <br />
    <a href="/">Back to Home</a>
</body>
</html>
