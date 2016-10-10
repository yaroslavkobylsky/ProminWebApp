<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promin web application</title>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">
            <!-- Header -->
            <div>
                <tiles:insertAttribute name="header" />
            </div>

            <!-- Menu Page -->
            <%--<div class="span-5  border" style="height:400px;background-color:#FCFCFC;">--%>
                <%--<tiles:insertAttribute name="menu" />--%>
            <%--</div>--%>

            <!-- Body Page -->
            <div <%--class="span-19 last"--%>>
                <tiles:insertAttribute name="body" />
            </div>

            <!-- Footer Page -->
           <%-- <tiles:insertAttribute name="footer" />--%>
        </div>
    </body>
</html>