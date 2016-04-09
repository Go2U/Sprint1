'use strict';

angular.module('myApp.welcomeStudent', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/welcomeStudent', {
                    templateUrl: 'welcomeStudent/welcomeStudent.html',
                    controller: 'welcomeStudentCtrl'
                });
            }])

        .controller('welcomeStudentCtrl', ['$rootScope', '$scope', 'GetStudentById', 'PostStu', '$http', '$location', 'Usuario', function ($rootScope, $scope, GetStudentById, PostStu, $http, $location, Usuario) {
                $scope.IUser = "";
                $scope.IPass = "";

                $scope.REid = "";
                $scope.RUser = "";
                $scope.RPass = "";
                

                $scope.loginStu = function () {
                    $scope.data = GetStudentById.get({id: $scope.IUser});
                    $scope.data.$promise.then(function (data) {
                        $scope.u = data;
                        if ($scope.u.lastName == $scope.IPass) {
                            Usuario.addUser($scope.IUser);
                            $rootScope.authenticated = true;
                            $location.path('/stuReg');
                        }
                    });
                };


                $scope.newStudent = function () {
                    var student = {"id": $scope.REid,"name":$scope.RUser ,"lastName": $scope.RPass};
                    PostStu.save(student, function () {
                        console.info("Saved" + JSON.stringify(student));
                        alert("Usuario registrado!")
                    });
                };
            }]);