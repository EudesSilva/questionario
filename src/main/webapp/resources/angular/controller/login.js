(function () {
    'use strict';
    
    
  var AppLogin = angular.module('LoginApp', []);
 
  AppLogin.controller('ControllerLogin', ['$scope','$location',function( $scope,$location) {
      
    var paramError = $location.search().error_login; 
    var logoutOk   = $location.search().logoutOk;
    
    console.info('error_login:: ' , paramError ); 
  
   var error_login = paramError;
          
    if(error_login === 'true' ){
        $scope.showerror = true;  
        console.info('showerror TRUE');
    }else{
        $scope.showerror = false; 
        console.info('showerror FALSE');
    }      
          
    if(logoutOk === 'true' ){
        $scope.showlogout = true;  
        console.info('logoutOk TRUE');
    }else{
        $scope.showlogout = false; 
        console.info('logoutOk FALSE');
    }         
          
          
          
// Logger ------------------------------------------






          
      }]); // end
  
})(); // end end




