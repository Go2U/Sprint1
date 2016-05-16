'use strict';

angular.module('myApp.welcomeStudent', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/welcomeStudent', {
                    templateUrl: 'welcomeStudent/welcomeStudent.html',
                    controller: 'welcomeStudentCtrl'
                });
            }])

        .controller('welcomeStudentCtrl', ['$rootScope', '$scope', 'GetStudentById', 'PostStu', '$http', '$location', 'Usuario', 'PostUser', '$mdDialog', function ($rootScope, $scope, GetStudentById, PostStu, $http, $location, Usuario, PostUser, $mdDialog) {
//                $scope.IUser = "";
//                $scope.IPass = "";
                $scope.RPass = "";
                $scope.RUser = "";
                $scope.REmail = "";

//                $scope.loginStu = function () {
//                    $scope.data = GetStudentById.get({id: $scope.IUser});
//                    $scope.data.$promise.then(function (data) {
//                        $scope.u = data;
//                        if ($scope.u.lastName == $scope.IPass) {
//                            Usuario.addUser($scope.IUser);
//                            $rootScope.authenticated = true;
//                            $location.path('/stuReg');
//                        }
//                    });
//                };

                $scope.newStudent = function (ev) {
                    var student = {"email": $scope.REmail, "username": $scope.RUser};
                    var user = {"username": $scope.RUser, "password": $scope.RPass, "role": 3};
                    PostUser.save(user, function () {
                        console.info("Saved" + JSON.stringify(user));
                    });
                    setTimeout(function () {
                        // rest of code here
                    }, 2000);
                    PostStu.save(student, function () {
                        console.info("Saved" + JSON.stringify(student));
                    });
                    $scope.RPass = "";
                    $scope.RUser = "";
                    $scope.REmail = "";
                    // Appending dialog to document.body to cover sidenav in docs app
                    // Modal dialogs should fully cover application
                    // to prevent interaction outside of dialog
                    $mdDialog.show(
                            $mdDialog.alert()
                            .parent(angular.element(document.querySelector('#popupContainer')))
                            .clickOutsideToClose(true)
                            .title('Sign Up')
                            .textContent('Your account has been created correctly.')
                            .ariaLabel('Alert Dialog Demo')
                            .ok('Got it!')
                            .targetEvent(ev)
                            );
                };

                var authenticate = function (credentials, callback) {
                    console.log('authenticate');
                    var headers = credentials ? {authorization: "Basic "
                                + btoa(credentials.username + ":" + credentials.password)
                    } : {};
                    console.log('headers');
                    $http.get('/api/user/', {headers: headers}).success(function (data) {
                        console.log('$http.get');
                        if (data.name) {
                            $rootScope.authenticatedS = true;
                            console.log('OK');
                        } else {
                            $rootScope.authenticatedS = false;
                            console.log('NOT');
                        }
                        callback && callback();
                    }).error(function () {
                        console.log('ERROR');
                        $rootScope.authenticatedS = false;
                        callback && callback();
                    });

                };

                //authenticate();
                $scope.credentials = {};
                $scope.login = function () {
                    authenticate($scope.credentials, function () {
                        console.log($rootScope.authenticatedS);
                        if ($rootScope.authenticatedS) {
                            console.log('OK');
                            Usuario.addUser($scope.credentials.username);
                            $location.path('/stuReg');
                            $scope.error = false;
                        } else {
                            console.log('NOT');
                            $location.path("/welcomeStudent");
                            document.getElementById("warning").style.visibility = 'visible';
                            $scope.error = true;
                        }
                    });
                };

            }]);