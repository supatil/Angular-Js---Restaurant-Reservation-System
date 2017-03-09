(function(){
	
	angular
	.module('restaurant')
	.controller('OwnerCntrl',OwnerController)
	
    OwnerController.$inject=['$http','$location'];
    function OwnerController($http,$location){
        var ownerVm=this;
        ownerVm.tryLogin=function(){
    		$http({
    		   method:'POST',
    		   url:'api/Reservation/login',
    		   data:ownerVm.auth
    		}).success(function(data){
    			console.log(data);
    			$location.path('/OwnerLoggedInPage.html');
    			console.log($location.path);
    		}).error(function(error){
    			console.log(error);
    		});
    		
    	};
        	
    }
	
})();