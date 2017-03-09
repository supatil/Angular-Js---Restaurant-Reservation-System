(function(){
	
	angular
	.module('Myrestaurant')
	.controller('SeatingCntrl',SeatingController)
	
    SeatingController.$inject=[];
    function SeatingController(){
        var seatingVm=this;
        console.log("guest controller");	
        
          
        
    }
    
	
})();