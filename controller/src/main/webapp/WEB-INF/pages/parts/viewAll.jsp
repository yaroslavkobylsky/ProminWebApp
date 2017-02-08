<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        <h1 style="text-align: center">List of all parts</h1>
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
                <th>Description name</th>
                <th>Material</th>
                <th>Is purchased</th>
                <th>Modified</th>
                <th>User</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="part" items="${parts}">
                <tr>
                    <td>${part.id}</td>
                    <td><a href="/parts/view?id=${part.id}">${part.name}</a></td>
                    <td>${part.descName}</td>
                    <td>${part.material.name} ${part.material.dimensions}</td>
                    <td>
                        <input type="checkbox" <c:choose>
                        <c:when test="${part.isPurchased =='true'}"> checked </c:when>
                        </c:choose>
                               disabled>
                    </td>
                    <td>${part.lastDate}</td>
                    <td>${part.user.name}</td>
                </tr>
            </c:forEach>

            </tbody>


        </table>
    </div>
    <div class="col-sm-1"></div>
</div>

