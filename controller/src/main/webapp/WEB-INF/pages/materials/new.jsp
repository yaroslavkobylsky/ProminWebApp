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

    <form action="/materials/new" method="post" id="addMaterialForm">

        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="materialName" class="control-label col-md-6">name: </label>
                    <div class="col-md-6">
                        <input type="text" class="form-control input-sm" name="materialName" id="materialName">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="materialDimensions" class="control-label col-md-6">dimensions: </label>
                    <div class="col-md-6">
                        <input type="text" class="form-control input-sm" name="materialDimensions" id="materialDimensions">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="materialGOST" class="control-label col-md-6">GOST: </label>
                    <div class="col-md-6">
                        <input type="text" class="form-control input-sm" name="materialGOST" id="materialGOST">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="materialSort" class="control-label col-md-6">sort: </label>
                    <div class="col-md-6">
                        <input type="text" class="form-control input-sm" name="materialSort" id="materialSort">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="materialType" class="control-label col-md-6">type: </label>
                    <div class="col-md-6">
                        <select class="form-control input-sm" name="materialType" id ="materialType">
                            <option value='-1' disabled selected></option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <br/>
        <br/>

        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="col-sm-3"></div>
                <div class="col-sm-3">
                    <button class="btn btn-success" type="submit" id="saveButton" onclick="return checkUserData()">Save</button>
                </div>
                <div class="col-sm-3"></div>
                <div class="col-sm-3">
                    <a href="/materials/viewAll" role="button" class="btn btn-warning">Cancel</a>
                </div>
            </div>
            <div class="col-sm-3"></div>
        </div>
    </form>
</div>
</body>
</html>
