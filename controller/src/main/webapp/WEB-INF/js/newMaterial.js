$(onDocumentReady);

function onDocumentReady(){
    console.log("new material page loaded");
    loadMaterialTypes();
}


function loadMaterialTypes(){
    console.log("loading material types");
    $.ajax({url: "/getMaterialTypes",
            success: function(result){
                $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                    console.log("name:" + this.name);
                    console.log("id:" + this.id);
                    /*<option value="0">TSET0</option>*/
                    $("#materialType").append("<option value='" + this.id + "'>" + this.name + "</option>");
                });
    }});
}

function checkUserData(){
    console.log("checking user data!");
    var name = $("#materialName").val();
    console.log("material name: " + name);
    var dimensions = $("#materialDimensions").val();
    console.log("material dimensions: " + dimensions);
    if (name == "" || dimensions == ""){
        alert("name and dimensions must be set!");
        return false;
    }
}
