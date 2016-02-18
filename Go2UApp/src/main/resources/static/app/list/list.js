'use strict';

angular.module('myApp.list', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/list', {
                    templateUrl: 'list/list.html',
                    controller: 'listCtrl'
                });
            }])

        .controller('listCtrl', ['$scope','Get', function ($scope,Get) {
                $scope.listado = Get.query();
                $scope.predicate = 'prio';
                $scope.reverse = true;
                $scope.order = function (predicate) {
                    $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
                    $scope.predicate = predicate;
                };
            }]);
        
//        .controller('listCtrl', ['$scope', 'communication', function ($scope, communication) {
//                $scope.listado = communication.getListado();
//                $scope.predicate = 'prio';
//                $scope.reverse = true;
//                $scope.order = function (predicate) {
//                    $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
//                    $scope.predicate = predicate;
//                };
//            }]);