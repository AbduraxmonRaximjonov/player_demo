<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 26/07/22
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../fragments/head.jsp"/>
</head>
<body>
<jsp:include page="../fragments/navbar.jsp"/>

<div class="row">
    <div class="col-6 offset-3">
        <form method="post">
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
            <div class="form-group">
                <label for="genre">Genre</label>
                <select class="form-control" id="genre">
                    <option value="HORROR">HORROR</option>
                    <option value="ROMANCE">ROMANCE</option>
                    <option value="DRAMA">DRAMA</option>
                    <option value="ROMANCE_DRAMA">ROMANCE_DRAMA</option>
                    <option value="SUPER_NATURAL_HORROR">SUPER_NATURAL_HORROR</option>
                    <option value="SCI_FI">SCI_FI</option>
                </select>
            </div>
            <div class="form-group">
                <label for="language">Language</label>
                <select class="form-control" id="language" name="genre">
                    <option value="UZ">Uz</option>
                    <option value="RU">Ru</option>
                    <option value="EN">En</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>


<jsp:include page="../fragments/js.jsp"/>
</body>
</html>
