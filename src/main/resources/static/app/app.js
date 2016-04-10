'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngMaterial',
    'ngRoute',
    'myApp.view1',
    'myApp.view2',
    'myApp.welcomeUniversity',
    'myApp.welcomeStudent',
    'myApp.list',
    'myApp.login',
    'myApp.clients',
    'myApp.uniReg',
    'myApp.stuReg',
    'myApp.calendar',
    'myApp.test',
    'myApp.view3',
    'services.services',
    'myApp.version'
]).
        config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
                $routeProvider.otherwise({redirectTo: '/view1'});
                $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
            }])

        .controller('rootCtrl', ['$scope', '$rootScope', '$http', '$location','Usuario', function ($scope, $rootScope, $http, $location,Usuario) {
                $scope.logout = function () {
                    $http.post('/logout', {}).success(function () {
                        $rootScope.authenticatedU = false;
                        Usuario.addUser("none");
                        $location.path("/");
                    }).error(function (data) {
                        $rootScope.authenticatedU = false;
                        $location.path("/");
                    });
                };
            }]);

