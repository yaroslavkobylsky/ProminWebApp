<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        <button class="btn" onclick="return newAssembly()">Add new assembly</button>
    </div>
</div>

<br/>

<div class="row">
    <div class="col-sm-12">
        <div class="panel panel-default">
            <div class="panel-heading">List of all assemblies</div>
                <div class="panel-body">
                    <div class="row">
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
                                    <td>
                                        <a href="/assemblies/view?id=${assembly.id}">${assembly.name}</a>
                                    </td>
                                    <td>${assembly.descName}</td>
                                    <td>${assembly.additionalInfo}</td>
                                    <td>${assembly.lastDate}</td>
                                    <td>${assembly.user.name}</td>
                                </tr>
                            </c:forEach>
                            </tbody>

                        </table>
                    </div>

            </div>
        </div>
    </div>
</div>

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
                    <td>
                        <a href="/assemblies/view?id=${assembly.id}">${assembly.name}</a>
                    </td>
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

