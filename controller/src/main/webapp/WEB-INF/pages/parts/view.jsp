<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        <h1 style="text-align: center">View part</h1>
    </div>
    <div class="col-sm-4">
        <button class="btn"> <a href="/parts/edit?id=${part.id}">edit</a> </button>
    </div>
</div>
<br/>

<div class="row" style="margin: 5px">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <label  class="control-label col-md-6">name: </label>
        <label  class="control-label col-md-6">${part.name}</label>
    </div>
    <div class="col-md-3"></div>
</div>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <label class="control-label col-md-6">description name: </label>
        <label class="control-label col-md-6">${part.descName}</label>
    </div>
    <div class="col-md-3"></div>
</div>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <label class="control-label col-md-6">material: </label>
        <label class="control-label col-md-6">${part.material.name} ${part.material.dimensions}</label>
    </div>
    <div class="col-md-3"></div>
</div>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
            <label class="control-label col-md-6">material weight: </label>
            <label class="control-label col-md-6">${part.materialNormWeight}</label>
    </div>
    <div class="col-md-3"></div>
</div>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <label class="control-label col-md-6">purchased: </label>
        <div class="col-md-2">
            <input type="checkbox" class="form-control input-sm"
                   <c:if test="${part.isPurchased == true}"> checked = checked </c:if>  disabled >
        </div>
        <div class="col-md-4"></div>
    </div>
    <div class="col-md-3"></div>
</div>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <label class="control-label col-md-6">date: </label>
        <label class="control-label col-md-6">${part.lastDate}</label>
    </div>
    <div class="col-md-3"></div>
</div>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <label class="control-label col-md-6">user: </label>
        <label class="control-label col-md-6">${part.user.name}</label>
    </div>
    <div class="col-md-3"></div>
</div>

<%--<div class="row">
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
</div>--%>

<%--<div class="row">
    <div class="col-sm-5"></div>
    <div class="col-sm-6" id="addMethod"></div>
    <div class="col-md-1"></div>
</div>--%>






