$(onDocumentReady);

function onDocumentReady(){
    console.log("new part page loaded");
    loadMaterials();
    loadProductionMethods();
}

function loadMaterials(){
    console.log("loading materials");
    $.ajax({url: "/getMaterials",
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log("name:" + this.name);
                console.log("id:" + this.id);
                $("#material").append("<option value='" + this.id + "'>" + this.name + " " + this.dimensions +  "</option>");
            });
        }});
};

function loadProductionMethods(){
    console.log("loading production methods");
    $.ajax({url: "/getProductionMethods",
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log("name:" + this.name);
                console.log("id:" + this.id);
                $("#productionMethod").append("<option value='" + this.id + "'>" + this.name + "</option>");
            });
        }});
}

function checkNewPart() {
    var partName  = $("#partName").val();
    console.log("part name:" + partName);
    if (partName == "" || partName == " "){
        alert("enter part name");
        return false;
    }
    console.log("checking name is unique");
    var finalResult = false;
    $.ajax({url: "/isPartNameUnique?name=" + partName,
        async: false,
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log(this);
                console.log("result: " + this.result);
                if (this.result == true ){
                    console.log("name is unique, returning true");
                    finalResult = true;
                }
                if (this.result == false) {
                    console.log("name is not unique, returning false");
                    alert("part name is not unique");
                    finalResult = false;
                }
            });
        }});
    return finalResult;
}


