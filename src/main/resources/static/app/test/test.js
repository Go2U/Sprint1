'use strict';

angular.module('myApp.test', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/test', {
                    templateUrl: 'test/test.html',
                    controller: 'testCtrl'
                });
            }])
        .controller('testCtrl', ['$scope','Usuario', 'Test', '$mdDialog', '$mdMedia','PostQueSC','$location','GetCarrUnivById', function ($scope, Usuario , Test, $mdDialog, $mdMedia,PostQueSC,$location,GetCarrUnivById) {
                
                $scope.tests;
                $scope.carrer=[];
                $scope.userId = Usuario.getUser();
                
                $scope.data = GetCarrUnivById.get({id: $scope.userId});
                $scope.data.$promise.then(function (data) {
                        $scope.u = data;
                        $scope.carrer=$scope.u;
                });
                
                $scope.userID = Usuario.getUser();
                $scope.data = Test.query({id:$scope.userID});
                $scope.data.$promise.then(function (data) {
                        $scope.u = data;
                        $scope.tests=$scope.u;
                });
        

                $scope.predicate = 'id';
                $scope.reverse = true;
                $scope.order = function (predicate) {
                    $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
                    $scope.predicate = predicate;
                };

                $scope.status = '  ';
                $scope.customFullscreen = $mdMedia('xs') || $mdMedia('sm');

                $scope.showAdvanced = function (ev, test) {
                    var useFullScreen = ($mdMedia('sm') || $mdMedia('xs')) && $scope.customFullscreen;
                    $mdDialog.show({
                        controller: DialogController,
                        templateUrl: 'test/test.tmpl.html',
                        parent: angular.element(document.body),
                        targetEvent: ev,
                        clickOutsideToClose: true,
                        locals:{test:test,carr:$scope.carrer},
                        fullscreen: useFullScreen
                    })
                            .then(function (answer) {
                                $scope.status = 'You said the information was "' + answer + '".';
                            }, function () {
                                $scope.status = 'You cancelled the dialog.';
                            });
                    $scope.$watch(function () {
                        return $mdMedia('xs') || $mdMedia('sm');
                    }, function (wantsFullScreen) {
                        $scope.customFullscreen = (wantsFullScreen === true);
                    });
                };
                
                $scope.showModi = function (ev, cadena) {
                    $location.path('/view4').search({'idQuestion': cadena});
                };
                
                $scope.showAdd = function (ev, test) {
                    $location.path('/view3');
                };
                
                $scope.addQue = function (){
                    alert('Entra');
                };
            }]);
        
function DialogController($scope, $mdDialog, locals) {
    $scope.locals = locals;
    
    $scope.hide = function () {
        $mdDialog.hide();
    };
    
    $scope.cancel = function () {
        $mdDialog.cancel();
    };
    $scope.answer = function (answer) {
        $mdDialog.hide(answer);
    };
    $scope.convertir = function (numero) {
        var carr = locals.carr;
        var salida = "";
        for(var i=0;i<carr.length;i++){
            if(carr[i].id==numero){
                salida = carr[i].name;
            }
        }
        return salida;
    }
}
