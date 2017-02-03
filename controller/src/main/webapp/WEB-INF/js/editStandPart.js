function checkEditStandardPart(){
    console.log( "checking user input" );
    var standardPartName  = $("#standardPartName").val();

    if(standardPartName == "" || standardPartName == " "){
        errorAlert("Error", "Enter standard part name!");
        return false;
    }
    var finalResult = false;
    $.ajax({url: "/isStandardPartNameUniqueInEdit?name=" + standardPartName + "&id=" + getUrlParameter("id"),
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
                    errorAlert("Error", "Standard part name is not unique!");
                    finalResult = false;
                }
            });
        }});
    return finalResult;
}