'use strict';

angular.module('myApp.view4', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view4', {
                    templateUrl: 'view4/view4.html',
                    controller: 'View4Ctrl'
                });
            }])

        .controller('View4Ctrl', ['$scope', 'Usuario', 'PostQueMod','GetCarrUnivById','$routeParams','QuestionGet',function ($scope,Usuario,PostQueMod,GetCarrUnivById,$routeParams,QuestionGet) {
                $scope.InDesc;
                $scope.InPrio;
                $scope.nq;
                $scope.carrer=[];
                $scope.Question;
                $scope.userId = Usuario.getUser();
                
                $scope.data = GetCarrUnivById.get({id: $scope.userId});
                $scope.data.$promise.then(function (data) {
                        $scope.u = data;
                        $scope.carrer=$scope.u;
                });
                
                $scope.data1 = QuestionGet.get({id: $routeParams.idQuestion});
                $scope.data1.$promise.then(function (data1) {
                        $scope.q = data1;
                        $scope.Question=$scope.q;
                        $scope.Que = $scope.Question.question;
                        $scope.SAns0=$scope.Question.answer[0].answer;
                        $scope.SAns1=$scope.Question.answer[1].answer;
                        $scope.SAns2=$scope.Question.answer[2].answer;
                        $scope.SAns3=$scope.Question.answer[3].answer;
                });
                
                
                $scope.newTask = function (ev){
                    var question = {"idQuestion":$scope.Question.idQuestion,"question":$scope.Que,
                                    "answer":
                                        [{"idAnswer":$scope.Question.answer[0].idAnswer,"answer":$scope.SAns0,"academicProgramC":
                                                [{"valSum":$scope.VAns00,"id":{"idAnswer":$scope.Question.answer[0].idAnswer,"idCarrer":$scope.APAns00}}]
                                        },{"idAnswer":$scope.Question.answer[1].idAnswer,"answer":$scope.SAns1,"academicProgramC":
                                                [{"valSum":$scope.VAns10,"id":{"idAnswer":$scope.Question.answer[1].idAnswer,"idCarrer":$scope.APAns10}}]
                                        },{"idAnswer":$scope.Question.answer[2].idAnswer,"answer":$scope.SAns2,"academicProgramC":
                                                [{"valSum":$scope.VAns20,"id":{"idAnswer":$scope.Question.answer[2].idAnswer,"idCarrer":$scope.APAns20}}]
                                        },{"idAnswer":$scope.Question.answer[3].idAnswer,"answer":$scope.SAns3,"academicProgramC":
                                                [{"valSum":$scope.VAns30,"id":{"idAnswer":$scope.Question.answer[3].idAnswer,"idCarrer":$scope.APAns30}}]
                                        }]
                                    };
                    console.log(question);
                    PostQueMod.save({id: $scope.userId},question, function(){
                        alert("Pregunta agregada");
                    });
                    $location.path('/test');
                };
            }]);
