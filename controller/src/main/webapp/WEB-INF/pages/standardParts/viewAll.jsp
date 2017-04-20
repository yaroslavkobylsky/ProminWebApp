<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">List of all standard parts</div>
            <div class="panel-body">
                <div class="row">
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
                                <td><a href="/standardParts/view?id=${standardPart.id}">${standardPart.name}</a></td>
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
            </div>
        </div>
    </div>
</div>

<br/>



