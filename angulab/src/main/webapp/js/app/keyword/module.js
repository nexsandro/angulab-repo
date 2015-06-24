
(function () {
    
    /*
       Configure application
    */
    var module = angular.module('keyword', [])
    
    .service('KeywordService', ['$http', '$rootScope', function($http, $rootScope) {
    	
    	return {
    		
    		list : listKeywords
    		
    	}
    	
    	function listKeywords(listFilter) {
    		
    		console.log(listFilter);
    		return $http.get(_controlPath + '/keyword/list?pageNumber=' + listFilter.pageNumber + "&pageSize=" + listFilter.pageSize)
    		    .then($rootScope.handleSuccess, $rootScope.handleError);
    		
    	}
    	
    }])
    
    .controller('KeywordController', ['KeywordService', '$scope', function(KeywordService, $scope) {
    	
    	$scope.pageFilter = {
    			pageNumber: 1,
    			pageSize: 2
    	};
    	
    	$scope.pageNext = function() {
    		$scope.pageFilter.pageNumber = $scope.pageFilter.pageNumber + 1;
    		$scope.navigate();
    	}
    	
    	$scope.pagePrevious = function() {
    		$scope.pageFilter.pageNumber = $scope.pageFilter.pageNumber - 1;
    		$scope.navigate();
    	}
    	
    	$scope.navigate = function () {
    		KeywordService.list($scope.pageFilter)
    		    .then(function(data) {
    		    	console.log(data);
    		    });
    	}
    	
    }]);
    

})();