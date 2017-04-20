
<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
    </div>
    <div class="col-sm-3">
        <button class="btn"> <a href="/standardParts/edit?id=${standardPart.id}">edit</a> </button>
    </div>
</div>
<br/>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">View standard part</div>
            <div class="panel-body">
                <div class="row">
                    <label class="control-label col-md-4">name: </label>
                    <label class="control-label col-md-8">${standardPart.name}</label>
                </div>

                <div class="row">
                    <label class="control-label col-md-4">GOST: </label>
                    <label class="control-label col-md-8">${standardPart.gost}</label>
                </div>

                <div class="row">
                    <label  class="control-label col-md-4">weight: </label>
                    <label  class="control-label col-md-8">${standardPart.weight}</label>
                </div>

                <div class="row">
                    <label  class="control-label col-md-4">info: </label>
                    <label  class="control-label col-md-8">${standardPart.additionalInfo}</label>
                </div>

                <div class="row">
                    <label  class="control-label col-md-4">date: </label>
                    <label  class="control-label col-md-8">${standardPart.lastDate}</label>
                </div>
            </div>
        </div>
    </div>
</div>






