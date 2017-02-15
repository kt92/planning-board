angular
    .module('Pb')
    .factory("SessionService", function ($http) {
        return {
            getLoggedUser: getLoggedUser
        };

        function getLoggedUser() {
            return $http.get('/logged-user').then(function(response){
                return response.data;
            });
        }
    });