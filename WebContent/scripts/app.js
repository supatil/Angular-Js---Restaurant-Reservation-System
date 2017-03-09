(function(){
	
	angular
	.module('restaurant',['ngRoute'])
	.config(moduleConfig)
    
	moduleConfig.$inject=['$routeProvider'];
    function moduleConfig($routeProvider){
    	$routeProvider
    	.when('/Home',{
    		templateUrl:'mainTemp.html',
    		controller:'HomeCntrl',
    		controllerAs:'homeVm'
    	})
    	.when('/Guest',{
    		templateUrl:'GuestTemp.html',
    		controller:'GuestCntrl',
    		controllerAs:'guestVm'
    	})
    	.when('/Owner',{
    		templateUrl:'OwnerLoginTemp.html',
    		controller:'OwnerCntrl',
    		controllerAs:'ownerVm'
    	}) 
    	 
    	.otherwise({
    		redirectTo:'/Home'
    	});

    }



})();