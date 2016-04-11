'use strict';

angular.module('myApp.stuReg', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/stuReg', {
                    templateUrl: 'stuReg/stuReg.html',
                    controller: 'stuRegCtrl'
                });
            }])

        .controller('stuRegCtrl', ['$scope', '$rootScope', 'GetUnivById', 'GetCarrUnivById', 'UpdateUni', 'PostCarrersUni', 'Usuario', '$compile', '$mdDialog', '$mdMedia', function ($scope, $rootScope, GetUnivById, GetCarrUnivById, UpdateUni, PostCarrersUni, Usuario, $compile, $mdDialog, $mdMedia) {
                $scope.userId = "";
                // Information variables
                $scope.user = "";
                $scope.name = "";
                $scope.lastName = "";
                $scope.gender = "";
                $scope.address = "";
                $scope.cellphone = "";

                $scope.loadStu = function () {
                    $scope.userId = Usuario.getUser();
                    $scope.data = GetUnivById.get({id: $scope.userId});
                    $scope.data.$promise.then(function (data) {
                        $scope.s = data;
                        $scope.user = $scope.s.id;
                        $scope.name = $scope.s.name;
                        $scope.lastName = $scope.s.lastName;
                        $scope.gender = $scope.s.gender;
                        $scope.address = $scope.s.address;
                        $scope.cellphone = $scope.s.cellphone;
                    });
                };
                $scope.loadStu();

                $scope.saveInfoStu = function (ev) {
                    var s = {'id': $scope.user,
                        
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
        