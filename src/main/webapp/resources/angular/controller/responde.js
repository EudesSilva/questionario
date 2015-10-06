(function () {
    'use strict';
 
   
  var RespondeQues = angular.module('RespondeApp', ['ngRoute',  'ServiceGenericApp']);
  RespondeQues.config(['$routeProvider',  function($routeProvider) {
        $routeProvider.
                when('/q/:question/id/:camarada/e/:email', {  
                controller: 'RespostaController',
                controllerAS:'ctrl',
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
                 
    }]);

         
 
  RespondeQues.controller('RespostaController', ['$scope','ServiceGeneric','$routeParams','$location','$http',
                                function($scope, ServiceGeneric,  $routeParams, $location,$http ) {
 
    var self = this;
    var subPath = 'responde/';  // warning slashes!    
    ServiceGeneric.configURL( subPath ); // configure path generic service
    
                                    
    $scope.perguntas= [];
    $scope.respostas= [];               
    $scope.resposta = { idResposta:null, descricaoResposta:'', gabaritoList:null, idPergunta:null,
                        descricaoAlternativa1:'',descricaoAlternativa2:'',descricaoAlternativa3:'',
                        descricaoAlternativa4:'',descricaoAlternativa5:'',
                        alternativa1:'',alternativa2:'',alternativa3:'',alternativa4:'',alternativa5:'' };
                    
    var ques = { idQuestionario:null, tituloQuestionario:'' };                 
    var destinatario = {idDestinatario:null,emailDestinatario:'',respondido:true, questionario:ques};
    
    
 
    function parseToResposta(){
       var res = { idResposta:null, descricaoResposta:'', gabaritoList:null, idPergunta:null,
                   alternativa1:'',alternativa2:'',alternativa3:'',alternativa4:'',alternativa5:'' };
               
        for(var p in $scope.perguntas ){  
            res                   = $scope.perguntas[p]; 
            res.descricaoResposta = $scope.perguntas[p].respostaPergunta;
            res.tipoResposta      = $scope.perguntas[p].tipoPergunta;
            res.idPergunta        = $scope.perguntas[p].idPergunta; 
            $scope.resposta = res;
            $scope.respostas.push( angular.copy($scope.resposta) );
        }
    }
    

 
    $scope.submitForm = function(){ 
           // logs  
           // parseToResposta();
           // logResposta();
          // logPergunta();
          // logResposta();
       parseToResposta();
       self.respostasQuestionario( $scope.respostas );  
    };
   
    $scope.fetchAllQuestions = function( idQuestionario ){ 
        console.info("Chamada do fetchAllQuestions :::");
        ServiceGeneric.fetchAll( idQuestionario )
              .then( 
                       function(d) {  
                          if( d.status === 204 ){  
                                                // logHeaders(d);    
                               self.jaRespondido();
                               console.log("jaRespondido : " );
                            } 
                        $scope.perguntas = d.data;  
                          console.log("Response : " , JSON.stringify(d.data));          
                       },
                        function(errorResponse){ 
                            console.error('Error fetching All', errorResponse);
                        }
                  );  
      }; 
      
 
    console.info('joinParam :::', $routeParams.question + '/' + $routeParams.email);
    // Call questions.
   var joinParam =   $routeParams.email+ '/' +$routeParams.question ; 
   $scope.fetchAllQuestions( joinParam ); 
       
       
       
       
    self.jaRespondido = function(){
        $location.path('/resp_ok');  
    };
    
 
    self.confirmarResposta = function(){ 
      
       ServiceGeneric.configURLReset();
       subPath = 'responde/registrar/';  // warning slashes!    
       ServiceGeneric.configURL( subPath ); 
       destinatario.idDestinatario = $routeParams.camarada;
       destinatario.respondido = true;
       destinatario.emailDestinatario = $routeParams.email;
       destinatario.questionario.idQuestionario = $routeParams.question; 
      ///  loggerDestinatario(destinatario);  /// Logger
      
       ServiceGeneric.update( destinatario )
              .then( 
                     function(d){  
                       console.log('confirmarResposta:',  JSON.stringify(d)  ); 
                        self.jaRespondido();
                     },  
                      function(errorResponse){
                        console.error('Error confirmarResposta destinatario.', errorResponse);
                 } 
          );  
     };
     
     
     
   self.respostasQuestionario = function( respostas ){ 
        ServiceGeneric.create( respostas )
                  .then( 
                         function(d){  
                              console.log('status respostas gravadas:' , JSON.stringify(d) ); 
                              self.confirmarResposta();
                         },  
                          function(errorResponse){
                               console.error('Error sending respostas.', errorResponse);
                          } 
              );  
    };
 
   
   
   
   
   
    // Logger ------------------------------------------
   
    function loggerDestinatario(d){
       console.log('POST DESTINATARIO:::');
       console.log(d.idDestinatario);
       console.log(d.respondido);
       console.log(d.emailDestinatario);
       console.log(d.questionario.idQuestionario); 
    }
   
     function loggerResposta(){  
            parseToResposta(); 
        for(var i in $scope.respostas ){
          console.log('Id Pergunta: ',$scope.respostas[i].idPergunta ); 
          console.log('Resposta: ',$scope.respostas[i].descricaoResposta ); 
          console.log('descricaoAlternativa1: ' , $scope.respostas[i].descricaoPergunta1 );
          console.log('alternativa1: ' , $scope.respostas[i].alternativa1 );
          console.log('descricaoAlternativa2: ' , $scope.respostas[i].descricaoPergunta2 );
          console.log('alternativa2: ' , $scope.respostas[i].alternativa2 );
          console.log('descricaoAlternativa3: ' , $scope.respostas[i].descricaoPergunta3 );
          console.log('alternativa3: ' , $scope.respostas[i].alternativa3 );
          console.log('descricaoAlternativa4: ' , $scope.respostas[i].descricaoPergunta4 );
          console.log('alternativa4: ' , $scope.respostas[i].alternativa4 );
          console.log('descricaoAlternativa5: ' , $scope.respostas[i].descricaoPergunta5 );
          console.log('alternativa5: ' , $scope.respostas[i].alternativa5 ); 
          console.log('Tipo : ', $scope.respostas[i].tipoPergunta );  
          console.log('---------------------------------------'); 
        }
     };
    
 
     function loggerPergunta(){
        for(var i in $scope.perguntas ){
          console.log('Id: ',$scope.perguntas[i].idPergunta);
          console.log('Pergunta: ',$scope.perguntas[i].descricaoPergunta );  
          console.log('Resposta: ',$scope.perguntas[i].respostaPergunta ); 
          console.log('descricaoAlternativa1: ' , $scope.perguntas[i].descricaoPergunta1 );
          console.log('alternativa1: ' , $scope.perguntas[i].alternativa1 );
          console.log('descricaoAlternativa2: ' , $scope.perguntas[i].descricaoPergunta2 );
          console.log('alternativa2: ' , $scope.perguntas[i].alternativa2 );
          console.log('descricaoAlternativa2: ' , $scope.perguntas[i].descricaoPergunta3 );
          console.log('alternativa3: ' , $scope.perguntas[i].alternativa3 );
          console.log('descricaoAlternativa4: ' , $scope.perguntas[i].descricaoPergunta4 );
          console.log('alternativa4: ' , $scope.perguntas[i].alternativa4 );
          console.log('descricaoAlternativa5: ' , $scope.perguntas[i].descricaoPergunta5 );
          console.log('alternativa5: ' , $scope.perguntas[i].alternativa5 ); 
          console.log('Tipo : ', $scope.perguntas[i].tipoPergunta );  
          console.log('---------------------------------------'); 
        }
     };
   
   
   
    function logHeaders(d){
         console.info('data :' , JSON.stringify(d.data));
         console.info('status :' , d.status);
         console.info('headers :' ,d.headers);
         console.info('config :' , d.config); 
    }
   
   
    
   
          
      }]); // end
  
})(); // end end


