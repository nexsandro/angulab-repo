<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html ng-app="termApp" id="ng-app">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome to Angulab!</title>

<!-- 
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery/1.10.2/jquery.js"></script>
 -->
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/angular-1.2.27/angular.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/angular-1.2.27/angular-route.js"></script>
	
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/ng-grid/ng-grid-2.0.8.min.js"></script>

	<link href="<%=request.getContextPath()%>/js/ng-grid/ng-grid.css" media="screen" rel="stylesheet" type="text/css">
	
	<style type="text/css">
	.gridStyle {
	    border: 1px solid rgb(212,212,212);
	    width: 600px; 
	    height: 200px
	}
	</style>
</head>

<body ng-controller="TermController as ctrl">

	<div ng-grid="ctrl.grid" class="gridStyle"></div>

	<script type="text/javascript">

	(function() {

		var app = angular.module('termApp', ['ngGrid']);

		// Term DAO
		app.service('termDao', function($http) {
			
		});

		// Term Controller
		app.controller('TermController', ['$scope', function($scope) {

			var ctrl = this;
			
			this.data = [
				{"id":1,"key":"teste.item.number1","description":"Teste item 1"},
				{"id":2,"key":"teste.item.number2","description":"Teste item 2"},
				{"id":3,"key":"teste.item.number3","description":"Teste item 3"},
				{"id":4,"key":"teste.item.number4","description":"Teste item 4"},
				{"id":5,"key":"teste.item.number5","description":"Teste item 5"}];

			this.grid = { 
					data : 'ctrl.data',
					enableRowSelection : true,
					columnDefs : [
						{ field : "id", displayName : "Id" },
						{ field : "key", displayName : "Key"},
						{ field : "description", displayName : "Description"},
						{ field : "id", displayName : "Id", cellTemplate : '<span ng-bind="row.getProperty(col.field)"></span>'}
					]
			};
			
			}]);

		})();
		
	</script>
</body>
</html>