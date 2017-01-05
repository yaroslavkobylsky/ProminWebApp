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
                        <th>Desc name</th>
                        <th>Additional info</th>
                        <th>Modified</th>
                        <th>User</th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="assembly" items="${assemblies}">
                        <tr>
                            <td>${assembly.id}</td>
                            <td>${assembly.name}</td>
                            <td>${assembly.descName}</td>
                            <td>${assembly.additionalInfo}</td>
                            <td>${assembly.lastDate}</td>
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
