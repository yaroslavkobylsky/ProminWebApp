function checkEditPart(){
    console.log("checking edited part");
    var partName  = $("#partName").val();
    console.log("part name:" + partName);
    if (partName == "" || partName == " "){
        alert("enter part name");
        return false;
    }
    console.log("checking name is unique");
    var finalResult = false;
    $.ajax({url: "/isPartNameUniqueInEdit?name=" + partName + "&id=" + getUrlParameter("id"),
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