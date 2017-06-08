<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-sm-8"></div>
    <div class="col-sm-4">
        <button class="btn"> <a href="/parts/edit?id=${part.id}">edit</a> </button>
    </div>
</div>
<br>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">View part</div>
            <div class="panel-body">

                <div class="row" style="margin: 5px">
                    <label  class="control-label col-md-5">name: </label>
                    <label  class="control-label col-md-7">${part.name}</label>
                </div>

                <div class="row">
                    <label class="control-label col-md-5">description name: </label>
                    <label class="control-label col-md-7">${part.descName}</label>
                </div>

                <div class="row">
                    <label class="control-label col-md-5">material: </label>
                    <label class="control-label col-md-7">${part.material.name} ${part.material.dimensions}</label>
                </div>

                <div class="row">
                    <label class="control-label col-md-5">material weight: </label>
                    <label class="control-label col-md-7">${part.materialNormWeight}</label>
                </div>

                <div class="row">
                    <label class="control-label col-md-5">purchased: </label>
                    <div class="col-md-2">
                        <input type="checkbox" class="form-control input-sm"
                        <c:if test="${part.isPurchased == true}"> checked = checked </c:if>  disabled >
                    </div>
                    <div class="col-md-5"></div>
                </div>

                <div class="row">
                    <label class="control-label col-md-5">date: </label>
                    <label class="control-label col-md-7">${part.lastDate}</label>
                </div>

                <div class="row">
                    <label class="control-label col-md-5">user: </label>
                    <label class="control-label col-md-7">${part.user.name}</label>
                </div>

            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
        <div class="panel panel-default">
            <div class="panel-heading">Add drawing</div>
            <div class="panel-body">
                <form:form method="POST"
                       action="${pageContext.request.contextPath}/parts/addDrawing/${part.id}"
                       modelAttribute="uploadForm"
                       enctype="multipart/form-data">

                    <div class="row">
                        <div class="col-md-8">
                            <input type="file" accept="image/jpeg" id="files" name="files">
                        </div>
                        <div class="col-md-2"></div>
                        <div class="col-md-2">
                            <input class="button-primary" type="submit" value="Add">
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>

</div>






