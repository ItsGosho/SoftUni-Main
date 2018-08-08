<%@ page import="java.util.List" %>
<%@ page import="org.softuni.fdmc.data.models.Cat" %>
<%@ page import="org.softuni.fdmc.data.repos.CatRepository" %><%--
  Created by IntelliJ IDEA.
  PersonImp: atriu
  Date: 1.6.2018 г.
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
    <link>
</head>
<body>
    <% String catName = request.getParameter("catName"); %>
    <% Cat cat = ((CatRepository) application.getAttribute("cats")).getByName(catName); %>
    <% if(cat != null) { %>
    <h1>Cat - <%=cat.getName()%></h1>
    <hr />
    <h3>Breed: <%= cat.getBreed()%></h3>
    <h3>Color: <%= cat.getColor()%></h3>
    <h3>Number Of Legs: <%= cat.getNumberOfLegs()%></h3>
    <h3>Creator: <%= cat.getCreator().getUsername()%></h3>
    <h3>Views: <%= cat.getViews()%></h3>
    <% cat.plusView(); %>
    <hr />
    <br>
    <form method="post" action="/cats/profile?catName=<%=catName%>">
        <button type="submit">Order</button>
    </form>
    <% } else { %>
    <h1>Cat, with name <%=catName%> was not found.</h1>
    <% } %>
<br />
<a href="/cats/all">Back</a>
</body>
</html>
