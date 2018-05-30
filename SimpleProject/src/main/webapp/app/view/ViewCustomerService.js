mainApp.service('ViewCustomerService', ['$http', '$q' , function($http,$q){
		
	var data = [];
	
	this.setData = function (content) {
		data=content;		
	}	
	
	this.getData = function () {
		return data;		
	}	
	
	this.fetchAllCustomers = function () {
        var deferred = $q.defer();
        $http.get('admin/allCustomer').then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResp){
                console.error('Error while fetching Customers');
                deferred.reject(errResp);
            }
        );
        return deferred.promise;
    }
}]);