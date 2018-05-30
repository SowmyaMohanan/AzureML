mainApp.controller('ViewCustomerController',[ '$scope','ViewCustomerService', function($scope, service){
	var view = this;
	view.customers = [];
	
	fetchAllCustomers();
	
	 function fetchAllCustomers(){
		 service.fetchAllCustomers().then(
         function(data) {
        	 view.customers = data;
         },
         function(errResp){
             console.error('Error while fetching Customers');
         }
     );
    }
}]);