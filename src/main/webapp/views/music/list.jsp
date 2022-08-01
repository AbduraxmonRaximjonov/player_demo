<%@ page import="uz.geeks.player_app.dao.MusicPlayerDao" %>
<%@ page import="uz.geeks.player_app.domains.MusicPlayer" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 26/07/22
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <jsp:include page="../fragments/head.jsp"/>

</head>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    html {
        font-size: 62.5%;
    }


    .container {
        background: #222;
    }

    .container .heading {
        font-size: 3rem;
        padding: 2rem 0;
        text-align: center;
        font-family: Vemana2000, Gubbi, sans-serif;
        text-shadow: 0 .5rem 1rem #000;
        color: #fff;
    }

    .container .music-container {
        display: flex;
        align-items: center;
        flex-flow: column;
    }

    .container .music-container .box {
        height: 16rem;
        width: 80%;
        display: flex;
        align-items: center;
        background: #f9f9f9;
        border-radius: 1rem;
        box-shadow: 0 .5rem 1rem #000;
        overflow: hidden;
        margin: 2rem;
    }

    .container .music-container .box .image {
        height: 100%;
        width: 25%;
    }

    .container .music-container .box .image img {
        height: 100%;
        width: 100%;
    }


    .container .music-container .box .music {
        width: 75%;
    }

    .container .music-container .box .music audio {
        width: 100%;
        outline: none;
    }

</style>
<body>


<div class="container">
    <div class="heading">Music Gallery</div>

    <%--${pageContext.request.contextPath}--%>
    <c:forEach var="music" items="${musics}">
        <div class="music-container">
            <div class="box">
                <div class="image">
                    <a href="${pageContext.request.contextPath}/download?cover=${music.cover.generatedName}">img</a>
                </div>
                <div class="music">
                    <audio controls play>
                        <source src="${pageContext.request.contextPath}/audios/${music.file.generatedName}" type="audio/mp3"/>
                    </audio>
                </div>
            </div>
        </div>
    </c:forEach>
</div>


<jsp:include page="../fragments/js.jsp"/>
</body>
</html>
