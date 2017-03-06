<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-4"></div>
<div class="col-sm-4">
    <table class="table">
        <tbody>
        <c:forEach var="entry" items="${parts}">
            <tr id="standardPart${entry.key.id}">
                <td>${entry.key.name}</td>
                <td>${entry.key.descName}</td>
                <td>${entry.value}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="col-sm-4"></div>