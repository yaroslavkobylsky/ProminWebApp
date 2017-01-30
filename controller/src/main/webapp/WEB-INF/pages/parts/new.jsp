
<div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        <h1 style="text-align: center">Add new part</h1>
    </div>
    <div class="col-sm-4"></div>
</div>
<br/>

<form action="/parts/new" method="post" id="addPartForm">

    <div class="row" style="margin: 5px">
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

    <div class="row">
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

</form>


