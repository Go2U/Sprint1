'use strict';

angular.module('myApp.welcomeUniversity', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/welcomeUniversity', {
                    templateUrl: 'welcomeUniversity/welcomeUniversity.html',
                    controller: 'welcomeUniversityCtrl'
                });
            }])

        .controller('welcomeUniversityCtrl', ['$rootScope', '$scope', 'GetUnivById', 'PostUniv', '$http', '$location', 'Usuario', '$mdDialog', 'PostUser', 'SNIESCon', 'CheckUni', function ($rootScope, $scope, GetUnivById, PostUniv, $http, $location, Usuario, $mdDialog, PostUser, SNIESCon, CheckUni) {
                $scope.REmail = "";
                $scope.RUser = "";
                $scope.RPass = "";

                $scope.newUniversity = function (ev) {
                    $scope.data = SNIESCon.get({id: $scope.RUser});
                    console.log($scope.data);
//                    $scope.data2 = CheckUni.get({id: $scope.RUser});
//                    console.log($scope.data2);
                    $scope.data.$promise.then(function (data) {
                        $scope.u = data;
                        
                        if ($scope.u.nombreInstitucion != null) {
                            var university = {"email": $scope.REmail, "username": $scope.RUser, "city": 1, "name": $scope.u.nombreInstitucion, "address": $scope.u.direccion};
                            var user = {"username": $scope.RUser, "password": $scope.RPass, "role": 2, "salt": Math.floor(Math.random() * 10000 + 1)};
                            
                            PostUser.save(user, function () {
                                console.info("Saved" + JSON.stringify(user));
                            });

                            setTimeout(function () {
                                PostUniv.save(university, function () {
                                    console.info("Saved" + JSON.stringify(university));
                                });
                                $scope.REmail = "";
                                $scope.RUser = "";
                                $scope.RPass = "";
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
                            }, 500);
                        } else {
                            $mdDialog.show(
                                    $mdDialog.alert()
                                    .parent(angular.element(document.querySelector('#popupContainer')))
                                    .clickOutsideToClose(true)
                                    .title('Sign Up')
                                    .textContent('The university with NIT ' + $scope.RUser + ' does not exist. Please check and try again.')
                                    .ariaLabel('Alert Dialog Demo')
                                    .ok('OK')
                                    .targetEvent(ev)
                                    );
                        }
                    });
                };

                var authenticate = function (credentials, callback) {
                    console.log('authenticate');
                    var headers = credentials ? {authorization: "Basic "
                                + btoa(credentials.username + ":" + credentials.password)
                    } : {};
                    console.log('headers');
                    $http.get('/api/user', {headers: headers}).success(function (data) {
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