<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
</head>
<body>
<%--<nav class="navbar navbar-default">

<div class="btn-group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
       Assemblies<span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
        <li><a href="#">View all</a></li>
        <li><a href="#">New</a></li>
    </ul>
</div>

<div class="btn-group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Parts <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
        <li><a href="#">View all</a></li>
        <li><a href="#">New</a></li>
    </ul>
</div>

<div class="btn-group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Standard parts<span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
        <li><a href="#">View all</a></li>
    <li><a href="#">New</a></li>
    </ul>
</div>

<div class="btn-group">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Materials <span class="caret"></span>
    </button>
    <ul class="dropdown-menu">
        <li><a href="#">View all</a></li>
        <li><a href="#">New</a></li>
    </ul>
</div>
</nav>--%>

<div class="page-header">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>--%>
                <%--<a class="navbar-brand" href="#">Main</a>--%>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Assemblies<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <%--<li><a href="/assemblies/new">New</a></li>--%>
                            <li><a href="/assemblies/viewAll">View all</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Materials <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/materials/new">New material</a></li>
                            <li><a href="/materials/viewAll">View all</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Parts<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/parts/new">New Part</a></li>
                            <li><a href="/parts/viewAll">View all</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Standard parts<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/standardParts/new">New standard part</a></li>
                            <li><a href="/standardParts/viewAll">View all stadard parts</a></li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->



        </div><!-- /.container-fluid -->
    </nav>
</div>

</body>
</html>