(function () {
    'use strict';
    
    
  var App =  angular.module('SendMailApp', ['ServiceGenericApp']); 
    
  App.controller('ControllerSendMail', ['$scope','ServiceGeneric', function($scope,ServiceGeneric) {
      
          
    ServiceGeneric.configURLReset();
    var subPath = 'sendmail/';  // warning slashes!    
    ServiceGeneric.configURL( subPath ); // configure path generic service
     

    $scope.questions    = [];
    $scope.selectedQuestion = null;
    $scope.emaildestinatario = null;
      
      
    $scope.fetchAllQuestions = function( idUser ){ 
          ServiceGeneric.fetchAll( idUser )
              .then(
                  function(d) {
                           console.log("questions: ", JSON.stringify(d.data));
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


