(function(){
	'use strict';
	angular
	  .module('Myrestaurant')
	  .controller('PSCntrl',ProfileController)
	  
	  ProfileController.$inject[''];
	  function ProfileController(){
		  var profileVm=this;
		  console.log(profileVm);
	  }
})();