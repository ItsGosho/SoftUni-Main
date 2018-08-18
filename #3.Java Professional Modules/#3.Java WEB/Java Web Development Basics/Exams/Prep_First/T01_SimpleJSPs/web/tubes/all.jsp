<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="app.Tube"%>
<%@ page import="app.TubeRepository" %><%--
  Created by IntelliJ IDEA.
  User: Gosho
  Date: 09-Aug-18
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tubes</title>
</head>
<body>
<%List<Tube> tubes=new LinkedList<Tube>(){{add(
        new Tube("Feel it Steel","Some cool new Song...",5,"Prakash"));
    add(new Tube("Despacito","No words...Just... No!",250,"Stamat"));
    add(new Tube("Gospodari Na Efira - ep.25","Mnogo smqh imashe tuka...",3,"Trichko"));}};
    TubeRepository.setTubes(tubes);
    %>

<% for(Tube tube : tubes) { %>
<h3>
    <a href="/tubes/details.jsp?tubeName=<%= tube.getTitle()%>"><%= tube.getTitle()%></a>
</h3>
<% } %>
</body>
</html>
