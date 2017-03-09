(function(){
	
	angular
	.module('restaurant')
	.controller('HomeCntrl',HomeController)
	
    HomeController.$inject=['$location'];
    function HomeController($location){
    	var homeVm=this;
              
        homeVm.button1=function(){
        	$location.path('/Guest');
        }
        
        homeVm.button2=function(){
        	$location.path('/Owner')
        }
    }
    
	
})();