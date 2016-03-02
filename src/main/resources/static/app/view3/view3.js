'use strict';

angular.module('myApp.view3', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view3', {
                    templateUrl: 'view3/view3.html',
                    controller: 'View3Ctrl'
                });
            }])

        .controller('View3Ctrl', ['$scope', 'PostQue', function ($scope,PostQue) {
                $scope.InDesc;
                $scope.InPrio;
                $scope.nq;

                $scope.newTask = function (){
                    var question = {"question":$scope.Que,
                            "answer":[
                            {"answer":$scope.SAns[0],
                                "academicProgram":[$scope.APAns[0][0]],
                                "valSum":[$scope.VAns[0][0]]},
                            {"answer":$scope.SAns[1],
                                "academicProgram":[$scope.APAns[1][0]],
                                "valSum":[$scope.VAns[1][0]]},
                            {"answer":$scope.SAns[2],
                                "academicProgram":[$scope.APAns[2][0]],
                                "valSum":[$scope.VAns[2][0]]
                            },
                            {"answer":$scope.SAns[3],
                                "academicProgram":[$scope.APAns[3][0]],
                                "valSum":[$scope.VAns[3][0]]
                            }
                        ]};
                    PostQue.save(question, function(){
                        //console.info("Saved "+JSON.stringify(question));
                    });
                    $scope.Que = "";
                    $scope.SAns[0]="";
                    $scope.APAns[0][0]=4;
                    $scope.VAns[0][0]=4;
                    $scope.SAns[1]="";
                    $scope.APAns[1][0]=4;
                    $scope.VAns[1][0]=4;
                    $scope.SAns[2]="";
                    $scope.APAns[2][0]=4;
                    $scope.VAns[2][0]=4;
                    $scope.SAns[3]="";
                    $scope.APAns[3][0]=4;
                    $scope.VAns[3][0]=4;
                };
                
                /*$scope.newTask = function () {
                    var task = {"num":$scope.nq, "preg":$scope.pre, "ans1":$scope.a1, "ans2":$scope.b2, "ans3":$scope.c3, "ans4":$scope.d4};
                    Post.save(task, function(){
                        console.info("Saved "+JSON.stringify(task));
                    });
                }*/
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
