<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <h1 style="text-align: center">Add new material</h1>
        </div>
        <div class="col-sm-4"></div>
    </div>
    <br/>

    <form action="/parts/new" method="post" id="addPartForm">

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="partName" class="control-label col-md-4">name:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="partName" id="partName">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="partDescName" class="control-label col-md-4" style="font-size: x-large; text-align: right">description name:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="partDescName" id="partDescName">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="partMaterialNormWeight" class="control-label col-md-4" style="font-size: x-large; text-align: right">material norm weight:</label>
                    <div class="col-md-8">
                        <input type="number" min="0" step="0.01" value="0" class="form-control" name="partMaterialNormWeight" id="partMaterialNormWeight">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="isPurchased" class="control-label col-md-4" style="font-size: x-large; text-align: right">Purchased:</label>
                    <div class="col-md-8">
                        <input type="checkbox" class="form-control" name="isPurchased" id="isPurchased">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="material" class="control-label col-md-4" style="font-size: x-large; text-align: right">Material:</label>
                    <div class="col-md-8">
                        <select class="form-control" name="material" id ="material">
                            <option value='-1' disabled selected></option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="productionMethod" class="control-label col-md-4" style="font-size: x-large; text-align: right">Production method:</label>
                    <div class="col-md-6">
                        <select class="form-control" name="productionMethod" id ="productionMethod">
                            <option value="-1" disabled selected></option>
                        </select>
                    </div>
                    <div class="col-md-2">
                        <button class="btn btn-primary" type="submit" id="addButton" onclick="return addProductionMethod()">add</button>
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6" id="addMethod"></div>
            <div class="col-md-3"></div>
        </div>

        <br/>
        <br/>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="col-sm-6">
                    <button class="btn btn-success" type="submit" id="saveButton" onclick="return checkNewPart()">Save</button>
                </div>
                <div class="col-sm-6">
                    <a href="/parts/viewAll" role="button" class="btn btn-warning">Cancel</a>
                </div>
            </div>
            <div class="col-sm-3"></div>
        </div>

    </form>
</div>
</body>
</html>
