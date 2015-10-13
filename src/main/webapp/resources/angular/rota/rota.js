(function () {
    'use strict';
 
  var Rota = angular.module('RotaApp', ['QuestionarioApp','SendMailApp','ngRoute']);
  Rota.config(['$routeProvider',  function($routeProvider) { 
         $routeProvider
                       .when('/home', {
                        templateUrl: '../template/menu.html' 

                      }).when('/#error_login/:loginfail', { 
                        templateUrl: '../restrict/sendmail.html'

                      }).when('/sendmail', { 
                        templateUrl: '../restrict/sendmail.html'  

                      }) .when('/questionario', { 
                         templateUrl: '../../views/restrict/questionario.html' 

                      }).when('/resp_ok', {
                        templateUrl: '../template/jarespondido.html' 
                    }).otherwise({
                            redirectTo: "#/home"
                    }); 
  
  
   }]); // end end      
          
})(); // end end


