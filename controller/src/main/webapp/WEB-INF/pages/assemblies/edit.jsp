<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <h1 style="text-align: center">Edit assembly</h1>
        </div>
        <div class="col-sm-4"></div>
    </div>
    <br/>


    <div class="row">

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

    <br>
    <br>
    <br>

    <div class="row" >
        <!--add assemblies row-->
        <div class="col-sm-3" style="border: double">
            <div class="row">
                <div class="col-sm-12" style="text-align: center">assemblies</div>
            </div>

            <div class="row" >
                <div class="form-group">
                    <div class="row">
                        <label for="assemblyToAdd" class="control-label col-md-4">assembly:</label>
                        <div class="col-md-8">
                            <select class="form-control input-sm" name="assemblyToAdd" id ="assemblyToAdd">
                                <option value='-1' disabled selected></option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <label class="control-label col-md-4">quantity:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control input-sm" name="assemblyQuantity" id="assemblyQuantity">
                        </div>
                        <div class="col-sm-4">
                            <button class="btn btn-success" type="submit" id="addAssembly" style="align-content: center" onclick="return false">add</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!--add parts row-->
        <div class="col-sm-3">

            <div class="row">
                <div class="col-sm-12" style="text-align: center">parts</div>
            </div>

            <div class="row" >
                <div class="form-group">
                    <div class="row">
                        <label for="partToAdd" class="control-label col-md-4">part:</label>
                        <div class="col-md-8">
                            <select class="form-control input-sm" name="partToAdd" id ="partToAdd">
                                <option value='-1' disabled selected></option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <label class="control-label col-md-4">quantity:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control input-sm" name="partQuantity" id="partQuantity">
                        </div>
                        <div class="col-sm-4">
                            <button class="btn btn-success" type="submit" id="addPart" style="align-content: center" onclick="return false">add</button>
                        </div>
                    </div>
                </div>
            </div>




        </div>

        <!--add standard parts row-->
        <div class="col-sm-3">

            <div class="row">
                <div class="col-sm-12" style="text-align: center">standard parts</div>
            </div>

            <div class="row" >
                <div class="form-group">
                    <div class="row">
                        <label for="standardPartToAdd" class="control-label col-md-4">standard part:</label>
                        <div class="col-md-8">
                            <select class="form-control input-sm" name="standardPartToAdd" id ="standardPartToAdd">
                                <option value='-1' disabled selected></option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <label class="control-label col-md-4">quantity:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control input-sm" name="standardPartQuantity" id="standardPartQuantity">
                        </div>
                        <div class="col-sm-4">
                            <button class="btn btn-success" type="submit" id="addStandardPart" style="align-content: center" onclick="return false">add</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <!--add materials row-->
        <div class="col-sm-3">
            <div class="row">
                <div class="col-sm-12" style="text-align: center">materials</div>
            </div>

            <div class="row" >
                <div class="form-group">
                    <div class="row">
                        <label for="materialToAdd" class="control-label col-md-4">material:</label>
                        <div class="col-md-8">
                            <select class="form-control input-sm" name="materialToAdd" id ="materialToAdd">
                                <option value='-1' disabled selected></option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <label class="control-label col-md-4">quantity:</label>
                        <div class="col-md-4">
                            <input type="text" class="form-control input-sm" name="materialQuantity" id="materialQuantity">
                        </div>
                        <div class="col-sm-4">
                            <button class="btn btn-success" type="submit" id="addMaterial" style="align-content: center" onclick="return false">add</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>



    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>


    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="partName" class="control-label col-md-6">name: </label>
                <div class="col-md-6">
                    <input type="text" class="form-control input-sm" name="partName" id="partName">
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="partDescName" class="control-label col-md-6">description name: </label>
                <div class="col-md-6">
                    <input type="text" class="form-control input-sm" name="partDescName" id="partDescName">
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="partMaterialNormWeight" class="control-label col-md-6">material weight: </label>
                <div class="col-md-6">
                    <input type="number" min="0" step="0.01" value="0" class="form-control input-sm" name="partMaterialNormWeight" id="partMaterialNormWeight">
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="isPurchased" class="control-label col-md-6">purchased: </label>
                <div class="col-md-2">
                    <input type="checkbox" class="form-control input-sm" name="isPurchased" id="isPurchased">
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>

    <div class="row" style="margin: 5px">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="material" class="control-label col-md-6">material: </label>
                <div class="col-md-6">
                    <select class="form-control input-sm" name="material" id ="material">
                        <option value='-1' disabled selected></option>
                    </select>
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="productionMethod" class="control-label col-md-6">production method: </label>
                <div class="col-md-5">
                    <select class="form-control" name="productionMethod" id ="productionMethod">
                        <option value="-1" disabled selected></option>
                    </select>
                </div>
                <div class="col-md-1">
                    <button class="btn btn-primary" type="submit" id="addButton" onclick="return addProductionMethod()">add</button>
                </div>
            </div>
        </div>
        <div class="col-md-3"></div>
    </div>

    <div class="row">
        <div class="col-sm-5"></div>
        <div class="col-sm-6" id="addMethod"></div>
        <div class="col-md-1"></div>
    </div>

    <br/>
    <br/>

    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="col-sm-3"></div>
            <div class="col-sm-3">
                <button class="btn btn-success" type="submit" id="saveButton" style="align-content: center" onclick="return checkNewPart()">Save</button>
            </div>
            <div class="col-sm-3"></div>
            <div class="col-sm-3">
                <a href="/parts/viewAll" role="button" class="btn btn-warning">Cancel</a>
            </div>
        </div>
        <div class="col-sm-3"></div>
    </div>

</div>
</body>
</html>
