$(onDocumentReady);

function onDocumentReady(){
    console.log("edit assembly page loaded");
}


function saveFields(){
    $.ajax({
        type: 'POST',
        url: '/assemblies/edit/saveFields',
        data: {
            'name': $("#assemblyName").val(),
            'descName': $("#assemblyDesc").val(),
            'additional': $("#additional").val(),
            'id': getUrlParameter("id")
        },
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log(this);
                console.log("result: " + this.result);
                if (this.result == -1 ){
                    console.log("new name is not unique");
                    alert('Assembly name is not unique!');
                }
                if (this.result == 0) {
                    console.log("server error");
                    alert("Server error, try later!");
                }
                if (this.result == 1) {
                    console.log("changes were saved");
                    alert("Changes were saved!");
                }
            });
        }
    });
}