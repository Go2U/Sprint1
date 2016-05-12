'use strict';

angular.module('myApp.view3', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view3', {
                    templateUrl: 'view3/view3.html',
                    controller: 'View3Ctrl'
                });
            }])

        .controller('View3Ctrl', ['$scope', 'Usuario', 'PostQueSC','GetCarrUnivById',function ($scope,Usuario,PostQueSC,GetCarrUnivById) {
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
                    var question = {"question":$scope.Que,
                                    "answer":
                                        [{"answer":"nada","academicProgramC":
                                                [{"valSum":$scope.VAns[0][0],"id":{"idCarrer":$scope.APAns[0][0]}}]
                                        },{"answer":"poco","academicProgramC":
                                                [{"valSum":$scope.VAns[1][0],"id":{"idCarrer":$scope.APAns[1][0]}}]
                                        },{"answer":"Bastante","academicProgramC":
                                                [{"valSum":$scope.VAns[2][0],"id":{"idCarrer":$scope.APAns[2][0]}}]
                                        },{"answer":"Mucho","academicProgramC":
                                                [{"valSum":$scope.VAns[3][0],"id":{"idCarrer":$scope.APAns[3][0]}}]
                                        }]
                                    };
                    PostQueSC.save({id: $scope.userId},question, function(){
                        alert("Pregunta agregada");
                        
                    });
                    $scope.Que = "";
                    $scope.APAns[0][0]=4;
                    $scope.VAns[0][0]=4;
                    $scope.APAns[1][0]=4;
                    $scope.VAns[1][0]=4;
                    $scope.APAns[2][0]=4;
                    $scope.VAns[2][0]=4;
                    $scope.APAns[3][0]=4;
                    $scope.VAns[3][0]=4;
                };
            }]);
