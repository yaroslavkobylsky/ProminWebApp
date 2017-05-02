<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
    <div class="col-sm-12">
        <div class="panel panel-default">
            <div class="panel-heading">Edit assembly</div>
            <div class="panel-body">

                <div class="row">
                    <div class="col-sm-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">Assembly</div>
                            <div class="panel-body">
                                <div class="col-sm-3">
                                    <div class="form-group">
                                        <label for="assemblyName" class="control-label col-md-4">name: </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control input-sm" value="${assembly.name}" onchange="saveFields()" name="assemblyName" id="assemblyName">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-5">
                                    <div class="form-group">
                                        <label for="assemblyDesc" class="control-label col-md-4">desc name: </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control input-sm" value="${assembly.descName}" onchange="saveFields()" name="assemblyDesc" id="assemblyDesc">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="form-group">
                                        <label for="assemblyDesc" class="control-label col-md-4">additional: </label>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control input-sm" value="${assembly.additionalInfo}" onchange="saveFields()" name="additional" id="additional">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <br>

                <div class="row" >

                    <div class="col-sm-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">Assemblies</div>
                            <div class="panel-body">

                                <div class="row">
                                    <div class="row" >
                                        <div class="form-group">
                                            <div class="row">
                                                <label for="assemblyToAdd" class="control-label col-md-4">assembly:</label>
                                                <div class="col-md-8">
                                                    <select class="form-control input-sm" name="assemblyToAdd" id ="assemblyToAdd">
                                                        <option value='-1' disabled selected></option>
                                                        <c:forEach var="assembly" items="${assemblies}">
                                                            <option value='${assembly.id}'>${assembly.name} ${assembly.descName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="row">
                                                <label class="control-label col-md-4">quantity:</label>
                                                <div class="col-md-4">
                                                    <input type="number" min="1" step="1" value="1" class="form-control input-sm" name="assemblyQuantity" id="assemblyQuantity">
                                                </div>
                                                <div class="col-sm-4">
                                                    <button class="btn btn-success" type="submit" id="addAssembly" style="align-content: center" onclick="addAssembly()">add</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <table class="table" id="assemblyTable">
                                        <tbody>
                                        <c:forEach var="entry" items="${assembly.assemblies}">
                                            <tr id="part${entry.key.id}">
                                                <td>${entry.key.name}</td>
                                                <td>${entry.value}</td>
                                                <td><button class="btn btn-warning" onclick="deleteAssembly(${entry.key.id}, ${assembly.id})">-</button></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                        </div>
                    </div>

                    <!--add parts row-->
                    <div class="col-sm-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">Parts</div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="row">
                                            <label for="partToAdd" class="control-label col-md-4">part:</label>
                                            <div class="col-md-8">
                                                <select class="form-control input-sm" name="partToAdd" id ="partToAdd">
                                                    <option value='-1' disabled selected></option>
                                                    <c:forEach var="part" items="${parts}">
                                                        <option value='${part.id}'>${part.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <label class="control-label col-md-4">quantity:</label>
                                            <div class="col-md-4">
                                                <input type="number" min="1" step="1" value="1" class="form-control input-sm" name="partQuantity" id="partQuantity">
                                            </div>
                                            <div class="col-sm-4">
                                                <button class="btn btn-success" type="submit" id="addPart" style="align-content: center" onclick="addPart()">add</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <table class="table" id="partTable">
                                            <tbody>
                                            <c:forEach var="entry" items="${assembly.parts}">
                                                <tr id="part${entry.key.id}">
                                                    <td>${entry.key.name}</td>
                                                    <td>${entry.value}</td>
                                                    <td><button class="btn btn-warning" onclick="deletePart(${entry.key.id}, ${assembly.id})">-</button></td>
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

                <div class="row">
                    <div class="col-sm-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">Standard parts</div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="row">
                                            <label for="standardPartToAdd" class="control-label col-md-4">standard part:</label>
                                            <div class="col-md-8">
                                                <select class="form-control input-sm" name="standardPartToAdd" id ="standardPartToAdd">
                                                    <option value='-1' disabled selected></option>
                                                    <c:forEach var="standardPart" items="${standardParts}">
                                                        <option value='${standardPart.id}'>${standardPart.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <label class="control-label col-md-4">quantity:</label>
                                            <div class="col-md-4">
                                                <input type="number" min="1" step="1" value="1" class="form-control input-sm" name="standardPartQuantity" id="standardPartQuantity">
                                            </div>
                                            <div class="col-sm-4">
                                                <button class="btn btn-success" type="submit" id="addStandardPart" style="align-content: center" onclick="addStandardPart()">add</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <table class="table" id="standardPartTable">
                                        <tbody>
                                        <c:forEach var="entry" items="${assembly.standardParts}">
                                            <tr id="standardPart${entry.key.id}">
                                                <td>${entry.key.name}</td>
                                                <td>${entry.value}</td>
                                                <td><button class="btn btn-warning" onclick="deleteStandardPart(${entry.key.id}, ${assembly.id})">-</button></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="col-sm-6">
                        <div class="panel panel-default">
                            <div class="panel-heading">Materials</div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="row">
                                            <label for="materialToAdd" class="control-label col-md-4">material:</label>
                                            <div class="col-md-8">
                                                <select class="form-control input-sm" name="materialToAdd" id ="materialToAdd">
                                                    <option value='-1' disabled selected></option>
                                                    <c:forEach var="material" items="${materials}">
                                                        <option value='${material.id}'>${material.name} ${material.dimensions}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <label class="control-label col-md-4">quantity:</label>
                                            <div class="col-md-4">
                                                <input type="number" min="0" step="0.01" value="0" class="form-control input-sm" name="materialQuantity" id="materialQuantity">
                                            </div>
                                            <div class="col-sm-4">
                                                <button class="btn btn-success" type="submit" id="addMaterial" style="align-content: center" onclick="addMaterial()">add</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <table class="table" id="materialTable">
                                        <tbody>
                                        <c:forEach var="entry" items="${assembly.materials}">
                                            <tr id="material${entry.key.id}">
                                                <td>${entry.key.name}</td>
                                                <td>${entry.value}</td>
                                                <td><button class="btn btn-warning" onclick="deleteMaterial(${entry.key.id}, ${assembly.id})">-</button></td>
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


