<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<br/>
<div class="row">
    <div class="col-sm-1"></div>
    <div class="col-sm-10">
        <div class="panel panel-default">
            <div class="panel-heading">List of all materials</div>
            <div class="panel-body">
                <div class="row">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Dimensions</th>
                                <th>GOST</th>
                                <th>Sort</th>
                                <th>Type</th>
                                <th>Modified</th>
                                <th>User</th>
                            </tr>
                            </thead>

                            <tbody>
                            <c:forEach var="material" items="${materials}">
                                <tr>
                                    <td>${material.id}</td>
                                    <td><a href="/materials/view?id=${material.id}">${material.name}</a></td>
                                    <td>${material.dimensions}</td>
                                    <td>${material.gost}</td>
                                    <td>${material.sort}</td>
                                    <td>${material.materialType.name}</td>
                                    <td>${material.lastDate}</td>
                                    <td>${material.user.name}</td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                </div>
            </div>
        </div>
    </div>
</div>


