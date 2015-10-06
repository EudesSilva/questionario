(function () {
    'use strict';
     
 var App =  angular.module('QuestionarioApp', ['ServiceGenericApp']);   
 
App.controller('ControllerQuestionario', ['$scope','ServiceGeneric','$timeout',
                                         function($scope, ServiceGeneric, $timeout) {
        
   var self = this;
   var subPath = 'question/';  // warning slashes!
   ServiceGeneric.configURL( subPath ); // configure path generic service               
                         
                         
   self.novoQuestionario = function(pristine){
         self.questionario = { idQuestionario:null, tituloQuestionario:'' }; 
         $scope.pergunta = { idPergunta:null, descricaoPergunta:'', idQuestionario:null, tipoPergunta:false,
                             respostaPergunta:'',
                             descricaoAlternativa1:'',descricaoAlternativa2:'',descricaoAlternativa3:'',
                             descricaoAlternativa4:'',descricaoAlternativa5:'',
                             alternativa1:false,alternativa2:false,alternativa3:false,
                             alternativa4:false,alternativa5:false };
          
          self.questions    = [];
          self.gravacaoidQuestionario=null;
          self.gravouquestion = false;  // disable 
          if(pristine){
               $scope.formQuestion.$setPristine();
          }
     };
       
  
   self.novoQuestionario(false);
   
   
     
   function cleanSampleQuestion(isSample, isQuestion){
         if( !isSample ){
           $scope.pergunta.descricaoAlternativa1='';  
           $scope.pergunta.descricaoAlternativa2=''; 
           $scope.pergunta.descricaoAlternativa3=''; 
           $scope.pergunta.descricaoAlternativa4=''; 
           $scope.pergunta.descricaoAlternativa5=''; 
         }
        if(isQuestion){
            $scope.pergunta.descricaoPergunta ='';
        }
     }
        
     //For checking if a string is blank, null or undefined I use:      
   function isBlank(str) { 
        return (!str || /^\s*$/.test(str));
    }   
          
          
   self.fetchAllQuestions = function( idQuestionario ){ 
        
       if( ! isBlank( idQuestionario ) ){ 
          ServiceGeneric.fetchAll( idQuestionario )
              .then(
                       function(d) {
                            self.questions = d.data;
                            console.log("questions: ", JSON.stringify(d.data));
                       },
                        function(errorResponse){
                            console.error('Error fetching All', errorResponse);
                        }
                   ); 
        }else{
            console.log('Não existe perguntas ::::');
        } 
      }; 
 
     
   self.createQuestionario = function( pergunta ){
        ServiceGeneric.create(pergunta)
                  .then( 
                         function(data){
                            self.gravacaoidQuestionario = data; 
                           // console.log('createQuestionario:',  JSON.stringify(data)  );
                            self.gravouquestion = true;  // enable  
                            self.fetchAllQuestions(self.gravacaoidQuestionario);
                            console.log('gravacaoidQuestionario: ', self.gravacaoidQuestionario );
                            console.log('data: ', data ); 

                         },  
                          function(errorResponse){
                               console.error('Error creating Questionario.', errorResponse);
                          } 
              ); 
      };
      
      
  
      
   self.deletePergunta = function( pergunta ){ 
        console.log('pergunta:: ', pergunta); 
        ServiceGeneric.delete( pergunta.idPergunta )
              .then(
                     function(){
                        self.id = self.questions.indexOf(pergunta);

                          if (self.id !== -1) { 
                              $timeout(function() {   // problems using $scope.$apply(); error bug:
                                    self.questions.splice(self.id, 1);
                                }, 100); 
                               console.log('Refresh List is OK::::: '); 
                          }else{
                               console.log('Refresh List FAIL:::: '); 
                          } 
                      // fetchAll ?
                     },
                    
                    function(errorResponse){
                    console.error('Error while delete Questionario.', errorResponse);
                  } 
              );
    };
      
  
   self.submitForm = function() {  
        
      var isClean = $scope.pergunta.tipoPergunta; 
      cleanSampleQuestion( isClean, false ); 

      self.questionario.idQuestionario = self.gravacaoidQuestionario;
      $scope.pergunta.questionario = self.questionario;   
 
     // logPergunta(); 
      
      self.createQuestionario( $scope.pergunta );  
      
      console.log('SUBMIT :: IS OK ' , $scope.pergunta.questionario.idQuestionario);
 
      $timeout(function() {   // problems action time, request in server
         //$scope.pergunta.descricaoPergunta ="";
          cleanSampleQuestion( false, true );
       }, 500); 
 
    };
          
 
 
   // Logger ------------------------------------------
 
 
   function loggerPergunta(){ 
          console.log('Id: ',$scope.pergunta.idPergunta);
          console.log('Pergunta: ',$scope.pergunta.descricaoPergunta );  
          console.log('Resposta: ',$scope.pergunta.respostaPergunta ); 
          
          console.log('descricaoAlternativa1: ' , $scope.pergunta.descricaoAlternativa1 );
          console.log('alternativa1: ' , $scope.pergunta.alternativa1 );
          console.log('descricaoAlternativa2: ' , $scope.pergunta.descricaoAlternativa2 );
          console.log('alternativa2: ' , $scope.pergunta.alternativa2 );
          console.log('descricaoAlternativa2: ' , $scope.pergunta.descricaoAlternativa3 );
          console.log('alternativa3: ' , $scope.pergunta.alternativa3 );
          console.log('descricaoAlternativa4: ' , $scope.pergunta.descricaoAlternativa4 );
          console.log('alternativa4: ' , $scope.pergunta.alternativa4 );
          console.log('descricaoAlternativa5: ' , $scope.pergunta.descricaoAlternativa5 );
          console.log('alternativa5: ' , $scope.pergunta.alternativa5 ); 
           
          console.log('Questionario Id: ' , $scope.pergunta.questionario.idQuestionario );
          console.log('Questionario titulo: ' , $scope.pergunta.questionario.tituloQuestionario );
          
          console.log('Questionario self Id: ' , self.questionario.idQuestionario );
          console.log('Questionario self titulo: ' , self.questionario.tituloQuestionario );  
          
          console.log('Tipo : ', $scope.pergunta.tipoPergunta );  
          console.log('---------------------------------------'); 
   
     };
 
 
 
  
    }]); // end
  
})();