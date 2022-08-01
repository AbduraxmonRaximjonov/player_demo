<%@ page import="java.util.List" %>
<%@ page import="uz.geeks.player_app.dao.MusicPlayerDao" %>
<%@ page import="uz.geeks.player_app.domains.MusicPlayer" %><%--
  Created by IntelliJ IDEA.
  User: ubuntu
  Date: 29/07/22
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title>Demo</title>
    <link rel="stylesheet" href="Demo.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body>

<%--            <c:forEach items="${musics}" var="music">--%>
<%--                <div class="col-2">--%>
<%--                    <div class="card mt-5">--%>
<%--                        <img class="card-img-top" src="<%=musicPlayer.getCover().getGeneratedName()%>"--%>
<%--                             alt="Card image cap">--%>
<%--                        <div class="card-body">--%>

<%--                            <a href="/download?filename=:<%=musicPlayer.getFile().getGeneratedName()%>"--%>
<%--                               class="card-title">: <%=musicPlayer.getName()%> (: <%=Math.round((musicPlayer.getFile().getSize())/(1024*1024))%>MB)</a>--%>

<%--                            <p class="card-text">Author : <%=musicPlayer.getAuthor()%></p>--%>
<%--                            <p class="card-text">chrome : <%=musicPlayer.getChrome_url()%></p>--%>
<%--                            <p class="card-text">Genre : <%=musicPlayer.getGenre()%></p>--%>
<%--                            <p class="card-text">tou tube : <%=musicPlayer.getYouTube_url()%></p>--%>

<%--                            <audio controls>--%>
<%--                                <source src="<%="audios/"+musicPlayer.getFile().getGeneratedName()%>" type="audio/mp3">--%>
<%--                            </audio>--%>
<%--                            <a href="${pageContext.request.contextPath}/download?filename=: <%=musicPlayer.getFile().getGeneratedName()%>" class="btn btn-outline-primary">Download</a>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            <%}%>--%>
<%--            </c:f orEach>--%>
<%--</div>--%>


<%--</div>--%>
<%--</div>--%>

</body>
</html>
