(function(){
	
	angular
	.module('restaurant')
	.controller('GuestCntrl',GuestController)
	
    GuestController.$inject=['$http'];
    function GuestController($http){
        var guestVm=this;
        console.log("guest controller");	
        
        guestVm.addCust=function(){
			$http({
				   method:'POST',
				   url:'api/Reservation/add',
				   data:guestVm.newCust
				}).success(function(data){
					console.log(data);
				}).error(function(error){
					console.log(error);

				});	
		}
        
        
    }
    
	
})();