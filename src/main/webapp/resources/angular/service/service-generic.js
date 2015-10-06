(function () {
    'use strict';
    
  var AppServiceGeneric = angular.module('ServiceGenericApp', []);
 
  AppServiceGeneric.factory('ServiceGeneric', 
                    ['$http', '$q', function($http, $q){
 
 
   var serverURL = 'http://localhost:8084/questionario/';
   
   
    return {    // question/
        
        
     configURL: function(url){ 
         serverURL += url;
     },
     configURLReset: function(){
         serverURL = 'http://localhost:8084/questionario/';
     },
       
       
    fetchAll: function( idObject ) {
            return $http.get( serverURL + idObject )
            .then(
                    function(response){
                        return response;//.data;
                    }, 
                    function(errorResponse){
                        console.error('Error while fetching ! name method [fetchAll] ' , errorResponse);
                        return $q.reject(errorResponse);
                    }
            );
        },
     
      //JSON.stringify({ person: developer }),
     // 'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
     ///$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded; charset=UTF-8";
    create: function( Object ){ 
            return $http.post( serverURL , Object )
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errorResponse){
                        console.error('Error while creating ! name method [create] ' , errorResponse);
                        return $q.reject(errorResponse);
                    }
            );
        }, 
        
        
    update: function( Object ){
            return $http.put( serverURL , Object)
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errResponse){
                        console.error('Error while updating ! name method [update]');
                        return $q.reject(errResponse);
                    }
            );
        },
        


    delete: function( idObject ){ // return Empty, generated log error ( an empty string )
            return $http.delete( serverURL + idObject )
            .then(
                    function(response){
                        return response.data;
                    }, 
                    function(errorResponse){
                        console.error('Error while deleting ! name method [delete] ', errorResponse);
                        return $q.reject(errorResponse);
                    }
            );
        }

    }; // end return
    
    
}]);  // end 


})(); // end