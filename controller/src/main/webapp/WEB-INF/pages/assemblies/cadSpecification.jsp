<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-ms-4"></div>
<div class="col-ms-4">
    <h3 style="text-align: center">Specification</h3>
</div>
<div class="col-ms-4"></div>

<div class="row">
    <div class="col-md-3"></div>
    <div class="col-md-6">
        <c:forEach var="cadSpecificationEntry" items="cadSpecification">
            <table class="table">
                <thead>
                    <tr>
                        <th>Size</th>
                        <th>Zone</th>
                        <th>Pos.</th>
                        <th>Name</th>
                        <th>Desc name</th>
                        <th>Quant</th>
                        <th>Add</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="entry" items="${cadSpecification.cadSpecificationEntries}">
                    <tr>
                        <td>${entry.format}</td>
                        <td>${entry.zone}</td>
                        <td>${entry.position}</td>
                        <td>${entry.name}</td>
                        <td>${entry.descName}</td>
                        <td>${entry.numberOf}</td>
                        <td>${entry.additional}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:forEach>
    </div>
    <div class="col-md-3"></div>
</div>
