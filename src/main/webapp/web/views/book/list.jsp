<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 26/07/22
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <jsp:include page="../fragments/head.jsp"/>
</head>
<body>
<jsp:include page="../fragments/navbar.jsp"/>
<div class="row">
    <div class="col-10 offset-1">
        <button type="button" class="btn btn-success" data-toggle="modal" data-target=".bd-example-modal-lg">
            Add Book
        </button>

        <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Add Bok</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <form method="post" action="/books/add" enctype="multipart/form-data">
                        <div class="modal-body">
                            <div class="container-fluid">
                                <div class="row">
                                    <div class="col-6">

                                        <div class="form-group">
                                            <label for="name">Book Name</label>
                                            <input type="text" name="name" class="form-control" id="name"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="author">Book Author</label>
                                            <input type="text" name="author" class="form-control" id="author"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="pageCount">Page count</label>
                                            <input type="number" name="pageCount" class="form-control" id="pageCount"/>
                                        </div>

                                    </div>
                                    <div class="col-6">
                                        <div class="form-group">
                                            <label for="genre">Genre</label>
                                            <select class="form-control" id="genre" name="genre">
                                                <option value="HORROR">Horror</option>
                                                <option value="ROMANCE">Romance</option>
                                                <option value="DRAMA">Drama</option>
                                                <option value="ROMANCE_DRAMA">Romance Drama</option>
                                                <option value="SUPER_NATURAL_HORROR">Super natural horror</option>
                                                <option value="SCI_FI">Sci-Fi</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="language">Language</label>
                                            <select class="form-control" id="language">
                                                <option value="UZ">Uz</option>
                                                <option value="RU">Ru</option>
                                                <option value="EN">En</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="file">Upload</label>
                                            <input type="file" name="file" class="form-control" id="file"/>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${books}" var="book">
                <%--            <ul>--%>
                <%--                <li>${book.name}</li>--%>
                <%--                <li>${book.author}</li>--%>
                <%--                <li>${book.pageCount}</li>--%>
                <%--                <li>${book.genre}</li>--%>
                <%--                <li>${book.language}</li>--%>
                <%--            </ul>--%>
                <div class="col-2">
                    <div class="card mt-5">
                        <img class="card-img-top" src="/download?filename=${book.cover.generatedName}"
                             alt="Card image cap">
                        <div class="card-body">

                            <a href="/download?filename=${book.file.generatedName}"
                               class="card-title">${book.name}(${book.file.size}B)</a>

                            <p class="card-text">Author : ${book.author}</p>
                            <p class="card-text">Pages : ${book.pageCount}</p>
                            <p class="card-text">Genre : ${book.genre}</p>
                            <p class="card-text">Language : ${book.language}</p>
                            <p class="card-text">Language : ${book.language}</p>
                            <a href="${pageContext.request.contextPath}/download?filename=${book.file.generatedName}" class="btn btn-outline-primary">Download</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>


    </div>
</div>


<jsp:include page="../fragments/js.jsp"/>
</body>
</html>
