$(onDocumentReady);

function onDocumentReady(){
    console.log("view all assemblies page loaded");
}

function newAssembly(){
    console.log("new assembly");

    $.MessageBox({
        input    : true,
        message  : "Enter new assembly name:"
    }). done(function(data){
          console.log("entered text: " + data);
          if ($.trim(data)) {
              $.ajax({url: "/isAssemblyNameUnique?name=" + data,
                  async: false,
                  success: function(result){
                      $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                          console.log(this);
                          console.log("result: " + this.result);
                          if (this.result == true ){
                              console.log("name is unique, trying to create new assembly");
                              //----------------------------------------------------------
                              $.ajax({url: "/createNewAssembly?name=" + data,
                                  async: false,
                                  success: function(result){
                                      $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                                          console.log(this);
                                          console.log("result: " + this.result);
                                          if (this.result >= 0 ){
                                              console.log("Assembly was created with id: " + this.result);
                                              console.log("Sending redirect to edit assembly page");
                                              window.location.replace("/assemblies/edit?id=" + this.result);
                                              return false;
                                          }
                                          if (this.result == -1) {
                                              console.log("Assembly was not created!");
                                              alert("Assembly was not created!");
                                              return false;
                                          }
                                      });
                                  }});
                              //----------------------------------------------------------
                          }
                          if (this.result == false) {
                              console.log("name is not unique, returning false");
                              alert("Assembly name is not unique!");
                              return false;
                          }
                      });
                  }});
          } else {
              $.MessageBox("Name can not be empty!");
              return false;
          }
    });


    return false;
}