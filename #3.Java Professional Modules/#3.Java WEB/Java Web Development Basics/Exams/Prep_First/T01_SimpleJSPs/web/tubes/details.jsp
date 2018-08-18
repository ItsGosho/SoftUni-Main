<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList"%>
<%@ page import="app.Tube"%>
<%@ page import="app.TubeRepository" %><%--
  Created by IntelliJ IDEA.
  User: Gosho
  Date: 09-Aug-18
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>app.Tube Details</title>
</head>
<body>
<%String tubeName = request.getParameter("tubeName");
  Tube tube = TubeRepository.getByName(tubeName);
%>
<p>Tube:<%=tube.getTitle()%></p>
<p>Description:<%=tube.getDescription()%></p>
<p>Uploader:<%=tube.getUploader()%></p>
<p>Views:<%=tube.getViews()%></p>
<a href="/tubes/all.jsp">Back</a>
</body>
</html>
