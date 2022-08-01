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
        <form method="post" action="/add" enctype="multipart/form-data">
            <div class="form-group">
                <label for="name">Music Name</label>
                <input type="text" name="name" class="form-control" id="name"/>
            </div>
            <div class="form-group">
                <label for="author">Book Author</label>
                <input type="text" name="author" class="form-control" id="author"/>
            </div>
            <div class="form-group">
                <label for="chrome_url">Chrome url</label>
                <input type="url" name="chrome_url" class="form-control" id="chrome_url"/>
            </div>
            <div class="form-group">
                <label for="genre">Genre</label>
                <select class="form-control" name="genre" id="genre">
                    <option value="CLASSIC">CLASSIC</option>
                    <option value="POPULAR_MUSIC">POPULAR MUSIC</option>
                    <option value="ROCK">ROCK</option>
                    <option value="POP">POP</option>
                    <option value="HIP_HOP">HIP HOP</option>
                    <option value="JAZZ">JAZZ</option>
                    <option value="ELECTRONIC">ELECTRONIC</option>
                    <option value="EDM">EDM</option>
                    <option value="MAQOM">MAQOM</option>
                    <option value="NASHIDA">NASHIDA</option>
                    <option value="DISCO">DISCO</option>
                    <option value="MOTIVATION">DISCO</option>
                    <option value="OTHER">DISCO</option>
                </select>
            </div>
            <div class="form-group">
                <label for="youTube_url">You Tube url</label>
                <input type="url" name="youTube_url" class="form-control" id="youTube_url"/>
            </div>

               <div class="form-group">
                   <label for="music">Music</label>
                   <input type="file" name="music" class="form-control" id="music"/>
               </div>

               <div class="form-group">
                   <label for="cover">Cover</label>
                   <input type="file" name="cover" class="form-control" id="cover"/>
               </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>


<jsp:include page="../fragments/js.jsp"/>
</body>
</html>
