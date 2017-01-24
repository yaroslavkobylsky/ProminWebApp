<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<tiles:importAttribute name="javascripts"/>
<tiles:importAttribute name="stylesheets"/>
<tiles:importAttribute name="title"/>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

        <div class="container">
            <div style="position: absolute; right: 30px">
                <a href="/logout" >logout</a>
            </div>

            <!-- Header -->
            <div>
                <tiles:insertAttribute name="header" />
            </div>
            <!-- Body Page -->
            <div>
                <tiles:insertAttribute name="body" />
            </div>
            <!-- Footer Page -->
           <%-- <tiles:insertAttribute name="footer" />--%>
        </div>
    </body>
</html>