'use strict';

angular.module('myApp.welcomeUniversity', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/welcomeUniversity', {
                    templateUrl: 'welcomeUniversity/welcomeUniversity.html',
                    controller: 'welcomeUniversityCtrl'
                });
            }])

        .controller('welcomeUniversityCtrl', ['$rootScope', '$scope', 'GetUnivById', 'PostUniv', '$http', '$location', 'Usuario','$mdDialog', 'PostUser', function ($rootScope, $scope, GetUnivById, PostUniv, $http, $location, Usuario,$mdDialog,PostUser) {
//                $scope.IUser = "";
//                $scope.IPass = "";
                $scope.REmail = "";
                $scope.RUser = "";
                $scope.RPass = "";

//                $scope.loginUni = function () {
//                    $scope.data = GetUnivById.get({id: $scope.IUser});
//                    $scope.data.$promise.then(function (data) {
//                        $scope.u = data;
//                        if ($scope.u.pass == $scope.IPass) {
//                            Usuario.addUser($scope.IUser);
//                            $rootScope.authenticatedU = true;
//                            $location.path('/uniReg');
//                        }
//                    });
//                };


                $scope.newUniversity = function (ev) {
                    var university = {"email": $scope.REmail, "username": $scope.RUser, "city":0};
                    var user = {"username": $scope.RUser, "password": $scope.RPass, "role":2};
                    PostUser.save(user, function () {
                        console.info("Saved" + JSON.stringify(user));
                    });
                    PostUniv.save(university, function () {
                        console.info("Saved" + JSON.stringify(university));
                    });
                    $scope.REmail="";
                    $scope.RUser="";
                    $scope.REmail="";
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
                            $rootScope.authenticatedU = true;
                            console.log('OK');
                        } else {
                            $rootScope.authenticatedU = false;
                            console.log('NOT');
                        }
                        callback && callback();
                    }).error(function () {
                        console.log('ERROR');
                        $rootScope.authenticatedU = false;
                        callback && callback();
                    });

                };

                //authenticate();
                $scope.credentials = {};
                $scope.login = function () {
                    authenticate($scope.credentials, function () {
                        console.log($rootScope.authenticatedU);
                        if ($rootScope.authenticatedU) {
                            console.log('OK');
                            Usuario.addUser($scope.credentials.username);
                            $location.path('/uniReg');
                            $scope.error = false;
                        } else {
                            console.log('NOT');
                            $location.path("/welcomeUniversity");
                            document.getElementById("warning").style.visibility = 'visible';
                            $scope.error = true;
                        }
                    });
                };
            }]);