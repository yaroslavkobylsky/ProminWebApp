<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-4">
        <h1 style="text-align: center">View assembly</h1>
    </div>
    <div class="col-sm-4">
        <div class="col-sm-4">
            <button class="btn"> <a href="/assemblies/edit?id=${assembly.id}">edit</a> </button>
        </div>
    </div>
</div>

<br/>

<div class="row">
    <div class="col-sm-3">
        <a href="/assemblies/getCadSpecification?id=${assembly.id}">Cad specification</a>
    </div>
    <div class="col-sm-5">
        <a href="/assemblies/getListOfPurchasedParts?id=${assembly.id}">List of purchased parts</a>
    </div>
    <div class="col-sm-4"></div>


</div>

<br>

<div class="row">

    <div class="col-sm-3">
        <div class="form-group">
            <label class="control-label col-md-4">name: </label>
            <label class="col-md-8">${assembly.name}</label>
        </div>
    </div>

    <div class="col-sm-5">
        <div class="form-group">
            <label class="control-label col-md-4">desc name: </label>
            <label class="col-md-8">${assembly.descName}</label>
        </div>
    </div>

    <div class="col-sm-4">
        <div class="form-group">
            <label class="control-label col-md-4">additional: </label>
            <label class="col-md-8">${assembly.additionalInfo}</label>
        </div>
    </div>

</div>

<br>
<br>

<div class="row">
    <%--assemblies--%>
    <div class="row">
        <label class="col-md-3">Assemblies</label>
        <label class="col-md-3">Parts</label>
        <label class="col-md-3">Standard parts</label>
        <label class="col-md-3">Materials</label>
    </div>


    <div class="col-sm-3">
        <table class="table" id="assemblyTable">
            <tbody>
            <c:forEach var="entry" items="${assembly.assemblies}">
                <tr id="part${entry.key.id}">
                    <td>${entry.key.name}</td>
                    <td>${entry.value}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%--parts--%>
    <div class="col-sm-3">
        <table class="table" id="partTable">
            <tbody>
            <c:forEach var="entry" items="${assembly.parts}">
                <tr id="part${entry.key.id}">
                    <td>${entry.key.name}</td>
                    <td>${entry.value}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%--standard parts--%>
    <div class="col-sm-3">
        <table class="table" id="standardPartTable">
            <tbody>
            <c:forEach var="entry" items="${assembly.standardParts}">
                <tr id="standardPart${entry.key.id}">
                    <td>${entry.key.name}</td>
                    <td>${entry.value}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <%--materials--%>
    <div class="col-sm-3">
        <div class="col-sm-3">
            <table class="table" id="materialTable">
                <tbody>
                <c:forEach var="entry" items="${assembly.materials}">
                    <tr id="material${entry.key.id}">
                        <td>${entry.key.name}</td>
                        <td>${entry.value}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

