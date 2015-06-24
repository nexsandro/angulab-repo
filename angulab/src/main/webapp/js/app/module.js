
/**
 * Publish AngularJS Project 
 * 
 * Main module.
 * 
 * @author sebastiao dot santos at gmail dot com
 */

(function() {

  var app = angular.module('dict', ['ngRoute', 'keyword', 'pascalprecht.translate']);
	
  /*
   * Config routes
   */
  app.config(['$routeProvider', '$locationProvider', /* '$translateProvider', '$translatePartialLoaderProvider', */ function($routeProvider, $locationProvider/* , $translateProvider, $translatePartialLoaderProvider */) {

	/**
	 * Config dictionary translation. 
	 */
	  
	/*
    $translatePartialLoaderProvider.addPart('dict');
    $translatePartialLoaderProvider.addPart('dict2');
      
    $translateProvider.useLoader('$translatePartialLoader', {
          urlTemplate: _contextPath + '/{part}_{lang}.json'
    });

    $translateProvider.preferredLanguage('pt_BR');
    */
	  
	/*
	 * Home navigation rules.
	 */
  	$routeProvider
  	.when(
  			
  			'/company/:id',
  			{ templateUrl: _contextPath + '/company/edit.html' }
  			
  	)
  	.when(
  			
  			'/company',
  			{ templateUrl: _contextPath + '/company/edit.html' }
  			
  	).when(
  			
  			'/products',
  			{ templateUrl: _contextPath + '/product/list.html', controller: 'ProductListController', controllerAs: 'productListCtrl' }
  			
  	).
  	when(
  			
  			'/product/:id',
  			{ templateUrl: _contextPath + '/product/edit.html' }
  			
  	).
  	when(
  			
  			'/product',
  			{ templateUrl: _contextPath + '/product/edit.html' }
  			
  	).when(
  			
  			'/brands',
  			{ templateUrl: _contextPath + '/brand/list.html', controller: 'BrandListController', controllerAs: 'brandListCtrl' }
  			
  	).
  	when(
  			
  			'/brand/:id',
  			{ templateUrl: _contextPath + '/brand/edit.html' }
  			
  	).
  	when(
  			
  			'/brand',
  			{ templateUrl: _contextPath + '/brand/edit.html' }
  			
  	).when(
  			
  			'/manufacturers',
  			{ templateUrl: _contextPath + '/manufacturer/list.html', controller: 'ManufacturerListController', controllerAs: 'manufacturerListCtrl' }
  			
  	).
  	when(
  			
  			'/manufacturer/:id',
  			{ templateUrl: _contextPath + '/manufacturer/edit.html' }
  			
  	).
  	when(
  			
  			'/manufacturer',
  			{ templateUrl: _contextPath + '/manufacturer/edit.html' }
  			
  	).when(
  	
  			'/company/:companyId/negotiations',
  			{ templateUrl: _contextPath + '/negotiation/list.html', controller: 'NegotiationListController', controllerAs: 'negotiationListCtrl' }
  			
  	).when(
  	
  			'/company/:companyId/contacts',
  			{ templateUrl: _contextPath + '/contact/list.html', controller: 'ContactListController', controllerAs: 'contactListCtrl' }
  			
  	).
  	when(
  			
  			'/company/:companyId/contact/:contactId',
  			{ templateUrl: _contextPath + '/contact/edit.html' }
  			
  	).
  	when(
  			
  			'/company/:companyId/contact',
  			{ templateUrl: _contextPath + '/contact/edit.html' }
  			
  	).when(
  	
  			'/company/:companyId/marketSegments',
  			{ templateUrl: _contextPath + '/marketsegment/list.html', controller: 'MarketSegmentListController', controllerAs: 'marketSegmentListCtrl' }
  			
  	).
  	when(
  			
  			'/company/:companyId/marketSegment/:marketSegmentId',
  			{ templateUrl: _contextPath + '/marketsegment/edit.html' }
  			
  	).
  	when(
  			
  			'/company/:companyId/marketSegment',
  			{ templateUrl: _contextPath + '/marketsegment/edit.html' }
  			
  	); // $routeProvider.when
  	
  	 // use the HTML5 History API
    $locationProvider.html5Mode(true);
		
  }]);

  app.run(['$rootScope', '$q', function($rootScope, $q) {
	    
	    /*
	     * Handle promisse on success
	     */
	    $rootScope.handleSuccess = function(response) {
	    	var restResponse = response.data;
	    	
	    	if (restResponse.ack == 'SUCCESS')
	    	
	    		return restResponse.data;
	    	
	    	else if (restResponse.ack == 'ERROR') {
	    		
	    		// write messages.
	    		
	    	} else {
	    		
	    		return $q.reject("An rest response without the right structure ocurred!");
	    		
	    	}
	    	
	    }
	    
	    /*
	     * Handle promisse on error
	     */
	    $rootScope.handleError = function(response) {

			return $q.reject("An unknown error ocurred!");

	    }
	  
	  
  }]);
  

   /*
    * Application bootstrap
    */
	angular.element(document).ready(function() {
		
		angular.bootstrap(document, ['dict']);
		
	});
  
})();
