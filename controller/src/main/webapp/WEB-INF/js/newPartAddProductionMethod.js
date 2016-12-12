function addProductionMethod(){
    console.log("adding production method");
    var method = $("#productionMethod").val();
    console.log("production method id: " + method);
    if (method == null || method == "-1"){
        alert("method was not selected");
        return false;
    }

    var mainDiv = $("<div></div>");
    divId = "div" + method;


    console.log("checking is production method not in list");
    var checkedDiv = document.getElementById(method);
    if (checkedDiv != null || checkedDiv != undefined){
        alert("production method already in list");
        return false;
    }
    else {
        console.log("production method not in list");
    }


    $(mainDiv).attr("id", method)
        .attr("style", "margin: 5px")
        .addClass("col-sm-12");

    var methodDiv = $("<div></div>");
    methodText = $("#productionMethod option:selected").text();
    $(methodDiv).addClass("col-sm-4")
                .html(methodText);
    mainDiv.append(methodDiv);

    var buttonDiv = $("<div></div>");
    $(buttonDiv).addClass("col-sm-4");
    var deleteButton = $("<button></button>");
    /*var divId = "#div" + id;*/
    deleteButton.addClass("btn btn-primary")
                .click(function () {
                    $("#" + method).remove();
                    return false;
                })
                .html("delete");
    $(buttonDiv).append(deleteButton);
    $(mainDiv).append(buttonDiv);

    var inputDiv = $("<div></div>");
    inputDiv.addClass("col-sm-4");
    var newInput = $("<input type='hidden'>");
    $(newInput).attr("name", "method" + method)
        .attr("id", "method" + method)
        .val(method);
    $(inputDiv).append(newInput);

    $(mainDiv).append(inputDiv);

    $(mainDiv).append($("<br>"));

    $("#addMethod").append(mainDiv);

    return false;
}

function deleteProductionMethod(id){
    console.log("deleting method with id:" + id);
    /*var divId = "#div" + id;*/
    $("#div" + id).remove();
    return false;
}