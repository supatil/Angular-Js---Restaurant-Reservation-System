(function(){
	
	angular
	  .module('Myrestaurant',['ngRoute'])
	  .config(ModuleConfig1)
	  
	  ModuleConfig1.$inject=['$routeProvider'];
	  function ModuleConfig1($routeProvider){
		  $routeProvider
		  .when('/Reservations',{
			  templateUrl:'ReservationTemp.html',
			  controller:'RCntrl',
			  controllerAs:'reservationVm'
		  })
		  .when('/Cancel-Edit Reservation',{
			  templateUrl:'CancelEditReservationTemp.html',
			  controller:'CECntrl',
			  controllerAs:'canceleditVm'
		  })
		  .when('/Profile Settings',{
			  templateUrl:'OwnerLoginTemp.html',
	    	  controller:'PSCntrl',
	    	  controllerAs:'profileVm'
		  })
		  .when('/Seating Arrangement',{
			  templateUrl:'seatingTemp.html',
	    	  controller:'SeatingCntrl',
	    	  controllerAs:'seatingVm'
		  })
		  .otherwise({
			  redirectTo:'/Reservations'
		  })
	  }
	
	
	
	
	
	
})();