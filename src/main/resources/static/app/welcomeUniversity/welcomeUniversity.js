'use strict';

angular.module('myApp.welcomeUniversity', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/welcomeUniversity', {
                    templateUrl: 'welcomeUniversity/welcomeUniversity.html',
                    controller: 'welcomeUniversityCtrl'
                });
            }])

        .controller('welcomeUniversityCtrl', ['$scope', 'PostUniv', function ($scope, PostUniv) {
//                $scope.InName;
//                $scope.InAddress;
//                $scope.InPhone;
                $scope.InEmail;
                $scope.InUser;
                $scope.InPassword;

                $scope.newUniversity = function () {                    
                    var university = {"email":$scope.InEmail,"id":$scope.InUser,"pass":$scope.InPassword};
                    PostUniv.save(university, function () {
                        console.info("Saved" + JSON.stringify(university));
                    });
                }
            }]);

