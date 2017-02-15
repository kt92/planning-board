var app = angular
    .module("Pb", ['ngMaterial', 'ui.router'])
    .config(function ($mdIconProvider) {
        $mdIconProvider.fontSet('md', 'material-icons');
    });