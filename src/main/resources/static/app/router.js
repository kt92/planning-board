angular
    .module('Pb')
    .config(function ($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');
        $stateProvider
            .state('template', {
                abstract: true,
                templateUrl: 'app/template/template.html',
                controller: 'TemplateCtrl as templateCtrl'
            })
            .state('tasks', {
                parent: 'template',
                url: '/',
                templateUrl: 'app/tasks/tasks.html'
            })
            .state('users', {
                parent: 'template',
                url: '/users',
                templateUrl: 'app/users/users.html'
            })
            .state('projects', {
                parent: 'template',
                url: '/projects',
                templateUrl: 'app/projects/projects.html'
            });
    });