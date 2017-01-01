<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <h1 style="text-align: center">List of all materials</h1>
            </div>

        <div class="col-sm-4"></div>
        </div>

    <br/>

        <div class="row">
            <div class="col-sm-1"></div>
                <div class="col-sm-10">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Dimensions</th>
                            <th>GOST</th>
                            <th>Sort</th>
                            <th>Type</th>
                            <%--<th>Modified</th>--%>
                            <th>User</th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="material" items="${materials}">
                            <tr>
                                <td>${material.id}</td>
                                <td>${material.name}</td>
                                <td>${material.dimensions}</td>
                                <td>${material.gost}</td>
                                <td>${material.sort}</td>
                                <td>${material.materilalType.name}</td>
                                    <%--<td>${material.lastDate}</td>--%>
                                <td>${material.user.name}</td>
                            </tr>
                        </c:forEach>
                        </tbody>

                    </table>
                </div>
            <div class="col-sm-1"></div>
        </div>
    </div>
</body>
</html>
