(function() {

   //App =  angular.module('QuestionarioApp', ['ServiceGenericApp']);
 
 
//In AngularJS to make CORS working you also have to overwrite default settings of the angular httpProvider:
////http://stackoverflow.com/questions/17289195/angularjs-post-data-to-external-rest-api
//  App.config(['$httpProvider',function ($httpProvider) {
//      $httpProvider.defaults.useXDomain = true;
//      delete $httpProvider.defaults.headers.common['X-Requested-With'];
//  }]);
  
 
 // Repository oficial https://code.angularjs.org
 
 /* Validations
    $pristine: Se TRUE, se não interagir
    $dirty: Se TRUE, se interagiu
    $valid: Se TRUE, se todos controles estiverem válidos
    $invalid: Se TRUE, se tiver apenas 1 controle inválido no form
    $error: É um hash que contem todos inválidos
 */
 
/*
https://spring.io/blog/2015/01/12/the-login-page-angular-js-and-spring-security-part-ii
.run(['$http', '$cookies', function ($http, $cookies) {
    $http.defaults.transformResponse.unshift(function (data, headers) {
        var csrfToken = $cookies['XSRF-TOKEN'];

        if (!!csrfToken) {
            $http.defaults.headers.common['X-CSRF-TOKEN'] = csrfToken;
        }

        return data;
    });
}]);    
    
*/


 
})();
