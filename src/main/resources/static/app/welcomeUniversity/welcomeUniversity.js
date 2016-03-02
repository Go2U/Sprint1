'use strict';

angular.module('myApp.welcomeUniversity', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/welcomeUniversity', {
                    templateUrl: 'welcomeUniversity/welcomeUniversity.html',
                    controller: 'welcomeUniversityCtrl'
                });
            }])

        .controller('welcomeUniversityCtrl', ['$rootScope', '$scope', 'GetUnivById', 'PostUniv', '$http', '$location', 'Usuario', function ($rootScope, $scope, GetUnivById, PostUniv, $http, $location, Usuario) {
                $scope.IUser = "";
                $scope.IPass = "";

                $scope.REmail = "";
                $scope.RUser = "";
                $scope.RPass = "";

                $scope.loginUni = function () {
                    $scope.data = GetUnivById.get({id: $scope.IUser});
                    $scope.data.$promise.then(function (data) {
                        $scope.u = data;
                        if ($scope.u.pass == $scope.IPass) {
                            Usuario.addUser($scope.IUser);
                            $location.path('/uniReg');
                        }
                    });
                };


                $scope.newUniversity = function () {
                    var university = {"email": $scope.REmail, "id": $scope.RUser, "pass": $scope.RPass};
                    PostUniv.save(university, function () {
                        console.info("Saved" + JSON.stringify(university));
                    });
                };
            }]);