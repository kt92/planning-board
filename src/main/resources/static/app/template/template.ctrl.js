angular
    .module("Pb")
    .controller("TemplateCtrl", function (SessionService, $mdSidenav) {

        var vm = this;

        vm.loggedUserName = null;
        vm.toggleMenu = toggleMenu;

        initialize();

        function initialize() {
            SessionService.getLoggedUser().then(function (loggedUser) {
                vm.loggedUserName = loggedUser.userName;
            });
        }

        function toggleMenu(navID) {
            $mdSidenav(navID).toggle()
        }

    });