(function(){
		
	angular
	 .module('Myrestaurant')
	 .controller('CECntrl',CancelEditController)
	 
	 CancelEditController.$inject=['$http','$location'];
	 function CancelEditController($http,$location){
		 var canceleditVm=this;
		 
		    	$http({
				   method:'GET',
				   url:'api/Reservation/all'
				}).success(function(data){
					console.dir(data);
					canceleditVm.payload=data;
					console.log(canceleditVm.payload);
				}).error(function(error){
					console.log(error);
				})
				
				canceleditVm.deleteCust=function(position){
					position=position+1;						
					$http({
					   method:'POST',
					   url:'api/Reservation/delete/' +position 
				       
					}).success(function(data){
						canceleditVm.payload=data;
						
					}).error(function(error){
						console.log(error);

					});
				 
					
				};
				
			
	 }
	
	
})();