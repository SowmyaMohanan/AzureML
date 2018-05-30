var mainApp = angular.module('mainApp',['ngRoute']);

mainApp.config(['$routeProvider', function($routeProvider){
	$routeProvider.
		when('/viewCustomer', {
			templateUrl : 'app/view/viewCustomer.jsp',
			controller : 'ViewCustomerController',
			controllerAs : 'view'
		});
}]);