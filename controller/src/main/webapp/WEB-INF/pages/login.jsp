<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tiles:importAttribute name="javascripts"/>
<tiles:importAttribute name="stylesheets"/>
<tiles:importAttribute name="title"/>
<html>
<head>
    <c:forEach var="script" items="${javascripts}">
        <script src="<c:url value="${script}"/>"></script>
    </c:forEach>

    <c:forEach var="style" items="${stylesheets}">
        <link type="text/css" rel="stylesheet" href="<c:url value="${style}"/>" />
    </c:forEach>

    <title>
        <tiles:insertAttribute name="title"></tiles:insertAttribute>
    </title>
</head>
<body>
<div class="container col-md-offset-3">
    <div class="row">
        <div class="col-xs-12 col-sm-12 col-lg-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">ISM Promin</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-12 ">
                            <form role="form" action="/login" method="post" id="login">
                                <div class="col-xs-12 col-sm-12 col-md-12 " >
                                    <br>
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                        <input type="text" name="userName" class="form-control input-lg" placeholder="user" required autofocus/>
                                    </div>

                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                        <input type="password" name="userPassword" class="form-control input-lg" placeholder="password" required />
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-12 col-md-12">
                                    <span class="wrong-pas-text">${message}</span>
                                    <hr class="colorgraph">
                                </div>
                                <div class="row">
                                    <div class="col-xs-offset-3 col-sm-offset-3  col-md-offset-3 col-xs-6 col-sm-6 col-md-6">
                                        <input type="submit" value="sign in" class="btn btn-primary btn-block btn-lg btn-success">
                                        </input>
                                    </div>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
