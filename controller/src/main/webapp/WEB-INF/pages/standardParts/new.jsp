<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <div class="container">

        <div class="row">
            <div class="col-sm-3"></div>
            <div class="col-sm-6">
                <h1 style="text-align: center">Add new standard part</h1>
            </div>
            <div class="col-sm-3"></div>
        </div>
        <br/>

        <form action="/standardParts/new" method="post" id="addStandardPartForm">

            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="standardPartName" class="control-label col-md-4">name: </label>
                        <div class="col-md-6">
                            <input type="text" class="form-control input-sm" name="standardPartName" id="standardPartName">
                        </div>
                        <div class="col-md-2"></div>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>

            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="gost" class="control-label col-md-4">GOST: </label>
                        <div class="col-md-6">
                            <input type="text" class="form-control input-sm" name="gost" id="gost">
                        </div>
                        <div class="col-md-2"></div>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>

            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="weight" class="control-label col-md-4">weight: </label>
                        <div class="col-md-6">
                            <input type="number" min="0" step="0.001" value="0" class="form-control input-sm" name="weight" id="weight">
                        </div>
                        <div class="col-md-2"></div>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>

            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <div class="form-group">
                        <label for="additionalInfo" class="control-label col-md-4">info: </label>
                        <div class="col-md-6">
                            <input type="text" class="form-control input-sm" name="additionalInfo" id="additionalInfo">
                        </div>
                        <div class="col-md-2"></div>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>

            <br>
            <br>

            <div class="row">
                <div class="col-sm-3"></div>
                <div class="col-sm-6">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-3">
                        <button class="btn btn-success" type="submit" id="saveButton" onclick="return checkNewStandardPart()">Save</button>
                    </div>
                    <div class="col-sm-3"></div>
                    <div class="col-sm-4">
                        <a href="/parts/viewAll" role="button" class="btn btn-warning">Cancel</a>
                    </div>
                </div>
                <div class="col-sm-3"></div>
            </div>

        </form>

    </div>
</body>
</html>
