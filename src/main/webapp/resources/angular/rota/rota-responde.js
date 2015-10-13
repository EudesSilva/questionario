(function () {
    'use strict';
 
  var Responde = angular.module('RotaRespondeApp', ['RespondeApp','ServiceGenericApp','ngRoute']);
  Responde.config(['$routeProvider',  function($routeProvider) {
        $routeProvider.
                when('/q/:question/id/:camarada/e/:email', {  
                templateUrl: '../template/questionario_resposta.html',
                    resolve: {
                      // I will cause a 1 second delay
                      delay: function($q, $timeout) {
                        var delay = $q.defer();
                        $timeout(delay.resolve, 500);
                        return delay.promise; 
                         }
                       } 
                }).when('/resp_ok', {
                    templateUrl: '../template/jarespondido.html' 
                }).otherwise({
                        redirectTo: "/"
                });
 
   }]); // end end      
          
})(); // end end


