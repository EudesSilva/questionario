(function () {
    'use strict';
 
  var Rota = angular.module('RotaApp', ['ngRoute']);
  Rota.config(['$routeProvider',  function($routeProvider) {
        $routeProvider.
                when('/q/:question/e/:email', {
                    templateUrl: '../template/questionario_resposta.html', 
                    resolve: {
                      // I will cause a 1 second delay
                        delay: function($q, $timeout) {
                            var delay = $q.defer();
                            $timeout(delay.resolve, 1000);
                            return delay.promise;  
                         }
                     }
                  }).when('/resp_ok', {
                    templateUrl: '../template/jarespondido.html' 
                }).otherwise({
                        redirectTo: "/"
                }); 
                otherwise({
                    redirectTo: '/'
                });
                 
    }]);
   
})(); // end end


