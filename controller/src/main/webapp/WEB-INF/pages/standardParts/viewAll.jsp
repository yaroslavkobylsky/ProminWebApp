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
            <h1 style="text-align: center">List of all standard parts</h1>
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
                    <th>GOST</th>
                    <th>Weight</th>
                    <th>Additional info</th>
                    <th>Modified</th>
                    <th>User</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="standardPart" items="${standardParts}">
                    <tr>
                        <td>${standardPart.id}</td>
                        <td>${standardPart.name}</td>
                        <td>${standardPart.gost}</td>
                        <td>${standardPart.weight}</td>
                        <td>${standardPart.additionalInfo}</td>
                        <td>${standardPart.lastDate}</td>
                        <td>${standardPart.user.name}</td>
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
