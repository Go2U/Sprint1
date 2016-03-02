'use strict';

angular.module('myApp.test', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/test', {
                    templateUrl: 'test/test.html',
                    controller: 'testCtrl'
                });
            }])
        .controller('testCtrl', ['$scope', 'Test', '$mdDialog', '$mdMedia','PostQue','$location', function ($scope, Test, $mdDialog, $mdMedia,PostQue,$location) {
                $scope.tests = Test.query();

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
                        locals:{test:test},
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
                
                $scope.showAdd = function (ev, test) {/*
                    var useFullScreen = ($mdMedia('sm') || $mdMedia('xs')) && $scope.customFullscreen;
                    $mdDialog.show({
                        controller: DialogController,
                        templateUrl: 'test/testAdd.tmpl.html',
                        parent: angular.element(document.body),
                        targetEvent: ev,
                        clickOutsideToClose: true,
                        locals:{test:test},
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
                    });*/
                    $location.path('/view3');
                };
                
                $scope.addQue = function (){
                    var question = {"question":$scope.Que,
                            "answer":[
                            {"answer":$scope.SAns[0],
                                "academicProgram":[$scope.APAns[0][0],$scope.APAns[0][1],$scope.APAns[0][2]],
                                "valSum":[$scope.VAns[0][0],$scope.VAns[0][1],$scope.VAns[0][2]]},
                            {"answer":$scope.SAns[1],
                                "academicProgram":[$scope.APAns[1][0],$scope.APAns[1][1],$scope.APAns[1][2]],
                                "valSum":[$scope.VAns[1][0],$scope.VAns[1][1],$scope.VAns[1][2]]},
                            {"answer":$scope.SAns[2],
                                "academicProgram":[$scope.APAns[2][0],$scope.APAns[2][1],$scope.APAns[2][2]],
                                "valSum":[$scope.VAns[2][0],$scope.VAns[2][1],$scope.VAns[2][2]]
                            }]};
                    PostQue.save(question, function(){
                        //console.info("Saved "+JSON.stringify(question));
                    });
                    $mdDialog.hide();
                    $scope.tests = Test.query();
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
}
