<div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        <h1 style="text-align: center">View material</h1>
    </div>
    <div class="col-sm-4">
        <button class="btn"> <a href="/materials/edit?id=${material.id}">edit</a> </button>
    </div>
</div>
<br/>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <label  class="control-label col-md-6">name: </label>
        <label  class="control-label col-md-6">${material.name}</label>
    </div>
    <div class="col-md-3"></div>
</div>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <label  class="control-label col-md-6">dimensions: </label>
        <label  class="control-label col-md-6">${material.dimensions}</label>
    </div>
    <div class="col-md-3"></div>
</div>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <label  class="control-label col-md-6">GOST: </label>
        <label  class="control-label col-md-6">${material.gost}</label>
    </div>
    <div class="col-md-3"></div>
</div>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <label  class="control-label col-md-6">sort: </label>
        <label  class="control-label col-md-6">${material.sort}</label>
    </div>
    <div class="col-md-3"></div>
</div>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <label  class="control-label col-md-6">material type: </label>
        <label  class="control-label col-md-6">${material.materialType.name}</label>
    </div>
    <div class="col-md-3"></div>
</div>