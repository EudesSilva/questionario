(function () {
    'use strict';
    
    
  var App =  angular.module('QuestionarioApp', ['ServiceGenericApp']); 
    
  App.controller('ControllerSendMail', ['$scope','$http','ServiceGeneric', function($scope,$http,ServiceGeneric) {
        
    var subPath = 'sendmail/';  // warning slashes!   
    //var serverURL = 'http://localhost:8084/questionario/';
    ServiceGeneric.configURL( subPath ); // configure path generic service
      

    $scope.questions    = [];
    $scope.selectedQuestion = null;
    $scope.emaildestinatario = null;
      
      
    $scope.fetchAllQuestions = function( idUser ){ 
          ServiceGeneric.fetchAll( idUser )
              .then(
                  function(d) {
                            $scope.questions = d.data;
                            $scope.selectedQuestion = angular.copy($scope.questions[0]);
                       },
                        function(errorResponse){
                            console.error('Error fetching All', errorResponse);
                        }
                  );  
      }; 
 
    $scope.fetchAllQuestions(1);  // Fake User;
       
 
   $scope.sendEmail = function(){  
       var paramPath = $scope.selectedQuestion.idQuestionario + "/" + $scope.emaildestinatario;
        console.log('sendEmail  paramPath:::: ', paramPath  );  
          ServiceGeneric.fetchAll( paramPath )
              .then(
                       function(d) { 
                          $scope.emaildestinatario ='';
                          console.log('Success sendEmail data:::: ' , d.data );
                          console.log('Success sendEmail status:::: ' , d.status );
                       },
                        function(errorResponse){
                            console.error('Error send All', errorResponse);
                        }
                   ); 
 
        }; 
      
      
      
      
      
      
// Logger ------------------------------------------






          
      }]); // end
  
})(); // end end


