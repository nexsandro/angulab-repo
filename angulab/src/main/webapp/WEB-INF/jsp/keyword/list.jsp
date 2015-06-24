<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:ng="http://angularjs.org">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>JLabs Dictionary - AngularJS Labs</title>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/components/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/components/angular/angular.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/components/angular-route/angular-route.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/components/angular-translate/angular-translate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/components/angular-translate-loader-static-files/angular-translate-loader-static-files.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/components/angular-translate-loader-partial/angular-translate-loader-partial.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/app/keyword/module.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/app/module.js"></script>

    <script type="text/javascript">

        var _contextPath = '${pageContext.request.contextPath}'; 

        var _controlPath = '${pageContext.request.contextPath}/control';
        
    </script>
    
</head>

<body ng-controller="KeywordController as ctrl">

<form>
    <button ng-click="pageNext()">Next</button>
    <button ng-click="pagePrevious()">Previous</button>
</form>


</body>

</html>