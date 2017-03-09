(function(){
		
	angular
	 .module('Myrestaurant')
	 .controller('RCntrl',ReservationsController)
	 
	 ReservationsController.$inject=['$http'];
	 function ReservationsController($http){
		 var reservationVm=this;
		 
		    	$http({
				   method:'GET',
				   url:'api/Reservation/all'
				}).success(function(data){
					console.dir(data);
					
					reservationVm.payload=data;
					console.log(reservationVm.payload);
				}).error(function(error){
					console.log(error);
				})
				
				
			
	 }
	
	
})();