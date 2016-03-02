'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngMaterial',
    'ngRoute',
    'myApp.view1',
    'myApp.view2',
    'myApp.list',
    'myApp.login',
    'myApp.clients',
    'myApp.uniReg',
    'myApp.calendar',
    'myApp.test',
    'services.services',
    'myApp.version'
]).
        config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
                $routeProvider.otherwise({redirectTo: '/view1'});
                $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
            }])

        .controller('rootCtrl', ['$scope', '$rootScope', '$http', '$location', function ($scope, $rootScope, $http, $location) {
                $scope.logout = function () {
                    $http.post('/logout', {}).success(function () {
                        $rootScope.authenticated = false;
                        $location.path("/login");
                    }).error(function (data) {
                        $rootScope.authenticated = false;
                        $location.path("/login");
                    });
                };
            }]);

