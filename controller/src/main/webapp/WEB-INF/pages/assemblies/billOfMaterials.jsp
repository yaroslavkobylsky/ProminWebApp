<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body>
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        <table class="table">
            <tbody>
            <c:forEach var="entry" items="${billOfMaterials.bill}">
                <tr>
                    <td>${entry.key.name} ${entry.key.dimensions} ${entry.key.gost}</td>
                    <td>${entry.value}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-sm-4"></div>
</body>
</html>
