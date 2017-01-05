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
                        <c:forEach var="assembly" items="${materials}">
                            <tr>
                                <td>${assembly.id}</td>
                                <td>${assembly.name}</td>
                                <td>${assembly.dimensions}</td>
                                <td>${assembly.gost}</td>
                                <td>${assembly.sort}</td>
                                <td>${assembly.materilalType.name}</td>
                                    <%--<td>${material.lastDate}</td>--%>
                                <td>${assembly.user.name}</td>
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
