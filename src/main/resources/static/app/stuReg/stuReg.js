'use strict';

angular.module('myApp.stuReg', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/stuReg', {
                    templateUrl: 'stuReg/stuReg.html',
                    controller: 'stuRegCtrl'
                });
            }])

        .controller('stuRegCtrl', ['$scope', '$rootScope', 'GetStudentById','UpdateStu', 'Usuario', '$compile', '$mdDialog', '$mdMedia', function ($scope, $rootScope, GetStudentById, UpdateStu, Usuario, $compile, $mdDialog, $mdMedia) {
                $scope.userId = "";
                // Information variables
                $scope.user = "";
                $scope.email = "";
                $scope.name = "";
                $scope.lastName = "";
                $scope.gender = "";
                $scope.address = "";
                $scope.cellphone = "";

                $scope.loadStu = function () {
                    $scope.userId = Usuario.getUser();
                    $scope.data = GetStudentById.get({id: $scope.userId});
                    $scope.data.$promise.then(function (data) {
                        $scope.s = data;
                        $scope.user = $scope.s.username;
                        $scope.name = $scope.s.name;
                        $scope.email = $scope.s.email;
                        $scope.lastName = $scope.s.lastName;
                        $scope.gender = $scope.s.gender;
                        $scope.address = $scope.s.address;
                        $scope.cellphone = $scope.s.cellphone;
                    });
                };
                $scope.loadStu();

                $scope.saveInfoStu = function (ev) {
                    var s = {'username': $scope.user,
                        'email': $scope.email,
                        'name': $scope.name,
                        'lastName': $scope.lastName,
                        'gender': $scope.gender,
                        'address': $scope.address,
                        'cellphone': $scope.cellphone,
                    };

                    UpdateStu.save({id: $scope.userId}, s, function () {
                        console.info("Saved " + JSON.stringify(s));
                    });

                    $mdDialog.show(
                            $mdDialog.alert()
                            .parent(angular.element(document.querySelector('#popupContainer')))
                            .clickOutsideToClose(true)
                            .title('Student Information')
                            .textContent('The Student Information have been saved successfully.')
                            .ariaLabel('Alert Dialog Demo')
                            .ok('Got it!')
                            .targetEvent(ev)
                            );
                };
       
            }]);
        