'use strict';
        angular.module('myApp.calendar', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/calendar', {
        templateUrl: 'calendar/calendar.html',
                controller: 'calendarCtrl'
        });
        }])

        .controller('calendarCtrl', ['$scope', function ($scope) {
            $scope.vara = '';
        }]);