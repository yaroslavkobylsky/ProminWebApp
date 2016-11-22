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

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="materialName" class="control-label col-md-4">name:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="materialName" id="materialName">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="materialDimensions" class="control-label col-md-4" style="font-size: x-large; text-align: right">dimensions:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="materialDimensions" id="materialDimensions">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="materialGOST" class="control-label col-md-4" style="font-size: x-large; text-align: right">GOST:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="materialGOST" id="materialGOST">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="materialSort" class="control-label col-md-4" style="font-size: x-large; text-align: right">Sort:</label>
                    <div class="col-md-8">
                        <input type="text" class="form-control" name="materialSort" id="materialSort">
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="form-group">
                    <label for="materialType" class="control-label col-md-4" style="font-size: x-large; text-align: right">Type:</label>
                    <div class="col-md-8">
                        <select class="form-control" name="materialType" id ="materialType">
                            <option value='-1' disabled selected></option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="col-md-3"></div>
        </div>

        <br/>
        <br/>

        <div class="row" style="margin: 5px">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <div class="col-sm-6">
                    <button class="btn btn-success" type="submit" id="saveButton" onclick="return checkUserData()">Save</button>
                </div>
                <div class="col-sm-6">
                    <a href="/materials/viewAll" role="button" class="btn btn-warning">Cancel</a>
                </div>
            </div>
            <div class="col-sm-3"></div>
        </div>
    </form>
</div>
</body>
</html>
