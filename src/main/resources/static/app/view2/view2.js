'use strict';

angular.module('myApp.view2', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view2', {
                    templateUrl: 'view2/view2.html',
                    controller: 'View2Ctrl'
                });
            }])

        .controller('View2Ctrl', ['$scope', 'Post', function ($scope,Post) {
                $scope.InDesc;
                $scope.InPrio;

                $scope.newTask = function () {
                    var task = {"desc":$scope.InDesc,"prio":$scope.InPrio};
                    Post.save(task, function(){
                        console.info("Saved "+JSON.stringify(task));
                    });
                }
            }]);

//        .controller('View2Ctrl', ['$scope', 'communication', function ($scope, communication) {
//                $scope.InDesc;
//                $scope.InPrio;
//                
//                $scope.addTask = function(){
//                    communication.addTodo({desc:$scope.InDesc, prio:$scope.InPrio});
//                }
//                
//            }]);