<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Objects" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">LibGen</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/books">Books<span class="sr-only">(current)</span></a>
            </li>
        </ul>

        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${loggedId}">
                    <li class="nav-item">
                        <a href="/auth/login" class="nav-link">Login</a>
                    </li>
                    <li class="nav-item">
                        <a href="/auth/register" class="nav-link">Register</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a href="/auth/logout" class="nav-link">Logout</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>