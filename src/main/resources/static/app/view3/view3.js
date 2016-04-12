'use strict';

angular.module('myApp.view3', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view3', {
                    templateUrl: 'view3/view3.html',
                    controller: 'View3Ctrl'
                });
            }])

        .controller('View3Ctrl', ['$scope', 'Usuario', 'PostQue','GetCarrUnivById',function ($scope,Usuario,PostQue,GetCarrUnivById) {
                $scope.InDesc;
                $scope.InPrio;
                $scope.nq;
                $scope.carrer=[];
                $scope.userId = Usuario.getUser();
                
                $scope.data = GetCarrUnivById.get({id: $scope.userId});
                $scope.data.$promise.then(function (data) {
                        $scope.u = data;
                        $scope.carrer=$scope.u;
                        console.log($scope.carrer);
                });
                
                $scope.newTask = function (ev){
                    var question = {"idQuestion":10,
                                    "question":$scope.Que,
                                    "answer":
                                        [{"idAnswer":1,"answer":$scope.SAns[0],"academicProgramC":
                                                [{"valSum":$scope.VAns[0][0],"id":{"idAnswer":0,"idCarrer":$scope.APAns[0][0]}}]
                                        },{"idAnswer":2,"answer":$scope.SAns[1],"academicProgramC":
                                                [{"valSum":$scope.VAns[1][0],"id":{"idAnswer":0,"idCarrer":$scope.APAns[1][0]}}]
                                        },{"idAnswer":3,"answer":$scope.SAns[2],"academicProgramC":
                                                [{"valSum":$scope.VAns[2][0],"id":{"idAnswer":0,"idCarrer":$scope.APAns[2][0]}}]
                                        },{"idAnswer":4,"answer":$scope.SAns[3],"academicProgramC":
                                                [{"valSum":$scope.VAns[3][0],"id":{"idAnswer":0,"idCarrer":$scope.APAns[3][0]}}]
                                        }]
                                    };
                    PostQue.save(question, function(){
                        //console.info("Saved "+JSON.stringify(question));
                        alert("Pregunta agregada");
                        
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
            }]);
