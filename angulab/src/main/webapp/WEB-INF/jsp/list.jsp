<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html id="ng-app" ng-app="app">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome to Angulab!</title>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/1.10.2/jquery.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/angular-1.2.27/angular.js"></script>

	<script type="text/javascript" src="<%=request.getContextPath()%>/js/ng-grid/ng-grid-2.0.8.min.js"></script>

	<link href="<%=request.getContextPath()%>/js/ng-grid/ng-grid.css" media="screen" rel="stylesheet" type="text/css">

	<script type="text/javascript">

		(function() {

			var app = angular.module('app', []);

			// Term list controller
			app.controller('TermListController', function() {

				this.msg = function(msg) {
					console.log(msg);
					alert(msg);
					};
				
				});
			
			$})();
	
	</script>
</head>

<body ng-controller="TermListController">

Hello !!!

<button ng-click="msg('Hello controller!')">Say Hello</button>

</body>
</html>