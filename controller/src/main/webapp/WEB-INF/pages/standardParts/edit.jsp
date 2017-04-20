
<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">Edit standard part</div>
            <div class="panel-body">
                <form action="/standardParts/edit?id=${standardPart.id}" method="post" id="editStandardPartForm">

                    <div class="row">
                        <div class="form-group">
                            <label for="standardPartName" class="control-label col-md-4">name: </label>
                            <div class="col-md-6">
                                <input type="text" value="${standardPart.name}" class="form-control input-sm" name="standardPartName" id="standardPartName">
                            </div>
                            <div class="col-md-2"></div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group">
                            <label for="gost" class="control-label col-md-4">GOST: </label>
                            <div class="col-md-6">
                                <input type="text" value="${standardPart.gost}" class="form-control input-sm" name="gost" id="gost">
                            </div>
                            <div class="col-md-2"></div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group">
                            <label for="weight" class="control-label col-md-4">weight: </label>
                            <div class="col-md-6">
                                <input type="number" min="0" step="0.001" value="${standardPart.weight}" class="form-control input-sm" name="weight" id="weight">
                            </div>
                            <div class="col-md-2"></div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group">
                            <label for="additionalInfo" class="control-label col-md-4">info: </label>
                            <div class="col-md-6">
                                <input type="text" value="${standardPart.additionalInfo}" class="form-control input-sm" name="additionalInfo" id="additionalInfo">
                            </div>
                            <div class="col-md-2"></div>
                        </div>
                    </div>

                    <br>
                    <br>

                    <div class="row">
                        <div class="col-sm-2"></div>
                        <div class="col-sm-3">
                            <button class="btn btn-success" type="submit" id="saveButton" onclick="return checkEditStandardPart()">Save</button>
                        </div>
                        <div class="col-sm-3"></div>
                        <div class="col-sm-4">
                            <a href="/standardParts/viewAll" role="button" class="btn btn-warning">Cancel</a>
                        </div>
                    </div>

                </form>

            </div>
        </div>
    </div>
</div>

