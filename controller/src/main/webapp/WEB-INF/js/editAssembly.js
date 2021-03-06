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
                    var row = createTableRow(partName.trim(), quantity, partId, assemblyId, "deletePart",
                        "part" + partId);
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
                    var row = createTableRow(standardPartName.trim(), quantity, standardPartId, assemblyId,
                        "deleteStandardPart", "standardPart" + standardPartId);
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

function addMaterial(){
    console.log("adding material to assembly");
    var materialId = $("#materialToAdd").val();
    console.log("material id:" + materialId);
    if (materialId < 0 || materialId == null || materialId == undefined){
        alert("Material must be selected");
        return;
    }
    var quantity = $("#materialQuantity").val();
    if (quantity < 0.01){
        alert("Specify the quantity");
        return;
    }
    var materialName = $("#materialToAdd option:selected").text();
    console.log("material name:" + materialName);
    var assemblyId = getUrlParameter("id");

    $.ajax({
        type: 'POST',
        url: '/assemblies/edit/addMaterial',
        data: {
            'materialId': materialId,
            'assemblyId': assemblyId,
            'quantity': quantity
        },
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log(this);
                console.log("result: " + this.result);
                if (this.result == -1 ){
                    console.log("material was not added to the assembly");
                    alert("material was not added to the assembly");
                }
                if (this.result == 0) {
                    console.log("server error");
                    alert("Server error, try later!");
                }
                if (this.result == 1) {
                    console.log("Material was added to the assembly");
                    alert("Material was added to the assembly");
                    var row = createTableRow(materialName.trim(), quantity, materialId, assemblyId,
                        "deleteMaterial", "material" + materialId);
                    console.log(row);
                    $("#materialTable").append(row);
                }
            });
        }
    })
}

function deleteMaterial(materialId, assemblyId){
    console.log("Delete material with id:" + materialId +  " from assembly with id: " + assemblyId);
    $.ajax({
        type: 'POST',
        url: '/assemblies/edit/removeMaterial',
        data: {
            'materialId': materialId,
            'assemblyId': assemblyId
        },
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log(this);
                console.log("result: " + this.result);
                if (this.result == -1 ){
                    console.log("material doesn't belong to the assembly");
                    alert("material doesn't belong to the assembly");
                }
                if (this.result == 0) {
                    console.log("server error");
                    alert("Server error, try later!");
                }
                if (this.result == 1) {
                    console.log("material was removed from assembly");
                    $("#material" + materialId).remove();
                    alert("material was removed from assembly");
                }
            });
        }
    });
}

function addAssembly(){
    console.log("adding assembly to assembly");
    var addAssemblyId = $("#assemblyToAdd").val();
    console.log("add assembly id:" + addAssemblyId);
    if (addAssemblyId < 0 || addAssemblyId == null || addAssemblyId == undefined){
        alert("Assembly must be selected");
        return;
    }
    var quantity = $("#assemblyQuantity").val();
    if (quantity < 1){
        alert("Specify the quantity");
        return;
    }
    var assAssemblyName = $("#assemblyToAdd option:selected").text();
    console.log("add assembly name:" + assAssemblyName);
    var assemblyId = getUrlParameter("id");

    $.ajax({
        type: 'POST',
        url: '/assemblies/edit/addAssembly',
        data: {
            'addAssemblyId': addAssemblyId,
            'assemblyId': assemblyId,
            'quantity': quantity
        },
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log(this);
                console.log("result: " + this.result);
                if (this.result == -1 ){
                    console.log("assembly was not added to the assembly");
                    alert("Assembly was not added to the assembly");
                }
                if (this.result == 0) {
                    console.log("server error");
                    alert("Server error, try later!");
                }
                if (this.result == 1) {
                    console.log("Assembly was added to the assembly");
                    alert("Assembly was added to the assembly");
                    var row = createTableRow(assAssemblyName.trim(), quantity, addAssemblyId, assemblyId,
                        "deleteAssembly", "assembly" + addAssemblyId);
                    console.log(row);
                    $("#assemblyTable").append(row);
                }
            });
        }
    })
}

function deleteAssembly(removeAssemblyId, assemblyId){
    console.log("Delete assembly with id:" + removeAssemblyId +  " from assembly with id: " + assemblyId);
    $.ajax({
        type: 'POST',
        url: '/assemblies/edit/removeAssembly',
        data: {
            'removeAssemblyId': removeAssemblyId,
            'assemblyId': assemblyId
        },
        success: function(result){
            $(jQuery.parseJSON(JSON.stringify(result))).each(function() {
                console.log(this);
                console.log("result: " + this.result);
                if (this.result == -1 ){
                    console.log("Assembly doesn't belong to the assembly");
                    alert("Assembly doesn't belong to the assembly");
                }
                if (this.result == 0) {
                    console.log("server error");
                    alert("Server error, try later!");
                }
                if (this.result == 1) {
                    console.log("Assembly was removed from assembly");
                    $("#assembly" + removeAssemblyId).remove();
                    alert("Assembly was removed from assembly");
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