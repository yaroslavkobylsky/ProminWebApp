<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        <div class="col-sm-4">
            <button class="btn"> <a href="/assemblies/edit?id=${assembly.id}">edit</a> </button>
        </div>
    </div>
</div>

<br/>

<div class="row">
    <div class="col-sm-12">
        <div class="panel panel-default">
            <div class="panel-heading">View assembly</div>
            <div class="panel-body">

                <div class="row">
                    <div class="col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">Documents</div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <a href="/assemblies/getCadSpecification?id=${assembly.id}">Cad specification</a>
                                    </div>
                                    <div class="col-sm-5">
                                        <a href="/assemblies/getListOfPurchasedParts?id=${assembly.id}">List of purchased parts</a>
                                    </div>
                                    <div class="col-sm-4">
                                        <a href="/assemblies/getBillOfMaterials?id=${assembly.id}">Bill of materials</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <br>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">Assembly</div>
                            <div class="panel-body">

                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="form-group">
                                            <label class="control-label col-md-4">name: </label>
                                            <label class="col-md-8">${assembly.name}</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-5">
                                        <div class="form-group">
                                            <label class="control-label col-md-4">desc name: </label>
                                            <label class="col-md-8">${assembly.descName}</label>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="form-group">
                                            <label class="control-label col-md-4">additional: </label>
                                            <label class="col-md-8">${assembly.additionalInfo}</label>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
                <br>

                <div class="row">

                    <div class="col-sm-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">Assemblies</div>
                            <div class="panel-body">
                                <div class="col-sm-12">
                                    <table class="table" id="assemblyTable">
                                        <tbody>
                                        <c:forEach var="entry" items="${assembly.assemblies}">
                                            <tr id="part${entry.key.id}">
                                                <td>${entry.key.name}</td>
                                                <td>${entry.value}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--parts--%>
                    <div class="col-sm-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">Parts</div>
                            <div class="panel-body">
                                <div class="col-sm-12">
                                    <table class="table" id="partTable">
                                        <tbody>
                                        <c:forEach var="entry" items="${assembly.parts}">
                                            <tr id="part${entry.key.id}">
                                                <td>${entry.key.name}</td>
                                                <td>${entry.value}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--standard parts--%>
                    <div class="col-sm-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">Standard parts</div>
                            <div class="panel-body">
                                <div class="col-sm-12">
                                    <table class="table" id="standardPartTable">
                                        <tbody>
                                        <c:forEach var="entry" items="${assembly.standardParts}">
                                            <tr id="standardPart${entry.key.id}">
                                                <td>${entry.key.name}</td>
                                                <td>${entry.value}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--materials--%>
                    <div class="col-sm-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">Materials</div>
                            <div class="panel-body">
                                <div class="col-sm-12">
                                    <table class="table" id="materialTable">
                                        <tbody>
                                        <c:forEach var="entry" items="${assembly.materials}">
                                            <tr id="material${entry.key.id}">
                                                <td>${entry.key.name}</td>
                                                <td>${entry.value}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>


