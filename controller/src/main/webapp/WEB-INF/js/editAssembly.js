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

function deletePart(partId, assemblyId){
    console.log("Delete part with id:" + partId +  " from assembly with id: " + assemblyId);
    $.ajax({
        type: 'POST',
        url: '/assemblies/edit/removePart',
        data: {
            'partId': partId,
            'assemblyId': assemblyId
        },
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log(this);
                console.log("result: " + this.result);
                if (this.result == -1 ){
                    console.log("part doesn't belong to the assembly");
                    alert("part doesn't belong to the assembly");
                }
                if (this.result == 0) {
                    console.log("server error");
                    alert("Server error, try later!");
                }
                if (this.result == 1) {
                    console.log("Part was removed from assembly");
                    $("#part" + partId).remove();
                    alert("Part was removed from assembly");
                }
            });
        }
    });
}

function addPart(){
    console.log("adding part to assembly");
    var partId = $("#partToAdd").val();
    if (partId < 0 || partId == null || partId == undefined){
        alert("Part must be selected");
        return;
    }
    var quantity = $("#partQuantity").val();
    if (quantity < 1){
        alert("Specify the quantity");
        return;
    }
    var partName = $("#partToAdd option:selected").text();
    console.log("part name:" + partName);
    var assemblyId = getUrlParameter("id");

    $.ajax({
        type: 'POST',
        url: '/assemblies/edit/addPart',
        data: {
            'partId': partId,
            'assemblyId': assemblyId,
            'quantity': quantity
        },
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log(this);
                console.log("result: " + this.result);
                if (this.result == -1 ){
                    console.log("part was not added to the assembly");
                    alert("part was not added to the assembly");
                }
                if (this.result == 0) {
                    console.log("server error");
                    alert("Server error, try later!");
                }
                if (this.result == 1) {
                    console.log("Part was added to the assembly");
                    alert("Part was added to the assembly");
                    var row = createTableRow(partName.trim(), quantity, partId, assemblyId, "deletePart", "part" + partId);
                    console.log(row);
                    $("#partTable").append(row);
                }
            });
        }
    })
}

function addStandardPart(){
    console.log("adding standard part to assembly");
    var standardPartId = $("#standardPartToAdd").val();
    console.log("standard part id:" + standardPartId);
    if (standardPartId < 0 || standardPartId == null || standardPartId == undefined){
        alert("Standard part must be selected");
        return;
    }
    var quantity = $("#standardPartQuantity").val();
    if (quantity < 1){
        alert("Specify the quantity");
        return;
    }
    var standardPartName = $("#standardPartToAdd option:selected").text();
    console.log("standard part name:" + standardPartName);
    var assemblyId = getUrlParameter("id");

    $.ajax({
        type: 'POST',
        url: '/assemblies/edit/addStandardPart',
        data: {
            'standardPartId': standardPartId,
            'assemblyId': assemblyId,
            'quantity': quantity
        },
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log(this);
                console.log("result: " + this.result);
                if (this.result == -1 ){
                    console.log("standard part was not added to the assembly");
                    alert("standard part was not added to the assembly");
                }
                if (this.result == 0) {
                    console.log("server error");
                    alert("Server error, try later!");
                }
                if (this.result == 1) {
                    console.log("Standard part was added to the assembly");
                    alert("Standard part was added to the assembly");
                    var row = createTableRow(standardPartName.trim(), quantity, standardPartId, assemblyId, "deleteStandardPart", "standardPart" + standardPartId);
                    console.log(row);
                    $("#standardPartTable").append(row);
                }
            });
        }
    })
}

function deleteStandardPart(standardPartId, assemblyId){
    console.log("Delete standard part with id:" + standardPartId +  " from assembly with id: " + assemblyId);
    $.ajax({
        type: 'POST',
        url: '/assemblies/edit/removeStandardPart',
        data: {
            'standardPartId': standardPartId,
            'assemblyId': assemblyId
        },
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log(this);
                console.log("result: " + this.result);
                if (this.result == -1 ){
                    console.log("standard part doesn't belong to the assembly");
                    alert("standard part doesn't belong to the assembly");
                }
                if (this.result == 0) {
                    console.log("server error");
                    alert("Server error, try later!");
                }
                if (this.result == 1) {
                    console.log("Standard part was removed from assembly");
                    $("#standardPart" + standardPartId).remove();
                    alert("Standard part was removed from assembly");
                }
            });
        }
    });
}

function createTableRow(name, quantity, fieldId, assemblyId, funcName, rowId){
    var row = $("<tr></tr>");
    var nameColumn = $("<td></td>");
    $(nameColumn).append(name);

    var quantityColoumn = $("<td></td>");
    $(quantityColoumn).append(quantity);

    var buttonColoumn = $("<td></td>");
    var button = $("<button></button>");
    $(button).attr("class", "btn btn-warning");
    $(button).attr("onclick", funcName + "(" + fieldId + ", " + assemblyId + ")");
    $(button).append("-");
    buttonColoumn.append(button);

    $(row).append(nameColumn);
    $(row).append(quantityColoumn);
    $(row).append(buttonColoumn);
    $(row).attr("id", rowId);

    return row;
}