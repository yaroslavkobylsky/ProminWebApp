<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        <h1 style="text-align: center">Edit part</h1>
    </div>
    <div class="col-sm-4"></div>
</div>
<br/>

<form action="/parts/edit?id=${part.id}" method="post" id="editPartForm">

    <div class="row" style="margin: 5px">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="form-group">
                <label for="partName" class="control-label col-md-6">name: </label>
                <div class="col-md-6">
                    <input type="text" value="${part.name}" class="form-control input-sm" name="partName" id="partName">
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
                    <input type="text" value="${part.descName}" class="form-control input-sm" name="partDescName" id="partDescName">
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
                    <input type="number" min="0" step="0.01" value="${part.materialNormWeight}" class="form-control input-sm" name="partMaterialNormWeight" id="partMaterialNormWeight">
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
                    <input type="checkbox" class="form-control input-sm"
                    <c:if test="${part.isPurchased == true}"> checked = checked </c:if> name="isPurchased" id="isPurchased">
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
                        <option value='${part.material.id}' selected>${part.material.name} ${part.material.dimensions}</option>
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
        <div class="col-sm-6" id="addMethod">
            <c:forEach var="method" items="${part.productionMethods}">
                <div class="col-sm-12" id="div${method.id}" style="margin: 5px">
                    <div class="col-sm-4">${method.name}</div>
                    <div class="col-sm-4">
                        <button class="btn btn-primary" onclick="return deleteProductionMethod(${method.id})">delete</button>
                    </div>
                    <div class="col-sm-4">
                        <input value="${method.id}" name="method_${method.id}" hidden>
                    </div>
                </div>
                <br>
            </c:forEach>
        </div>
        <div class="col-md-1"></div>
    </div>

    <br/>
    <br/>

    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="col-sm-3"></div>
            <div class="col-sm-3">
                <button class="btn btn-success" type="submit" id="saveButton" style="align-content: center" onclick="return checkEditPart()">Save</button>
            </div>
            <div class="col-sm-3"></div>
            <div class="col-sm-3">
                <a href="/parts/viewAll" role="button" class="btn btn-warning">Cancel</a>
            </div>
        </div>
        <div class="col-sm-3"></div>
    </div>

</form>


