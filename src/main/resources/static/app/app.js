var app = angular.module("Pb", ['ngMaterial']);

app.controller("AppCtrl", function ($mdSidenav, $log) {
    var vm = this;

    vm.toggleMenu = function(navID){
        console.log('toggleMenu');
        $mdSidenav(navID)
            .toggle()
            .then(function () {
                $log.debug("toggle " + navID + " is done");
            });
    };
});