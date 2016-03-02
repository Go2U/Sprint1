'use strict';
angular.module('services.services', ['ngRoute', 'ngResource'])

        .factory('communication', function () {
            var data = {
                listado: []
            };
            return {
                getListado: function () {
                    return data.listado;
                },
                addTodo: function (todo) {
                    data.listado.push(todo);
                }};
        })

        .factory('Post', function ($resource) {
            return $resource('/api/task/postTask');
        })

//        .controller('PostCtrl', function ($scope, Post) {
//            $scope.InDesc;
//            $scope.InPrio;
//            
//            $scope.newTask = function () {
//                alert($scope.InDesc+" - "+$scope.InPrio);
//                var post = new Post({desc: $scope.InDesc, prio: $scope.InPrio});
//                Post.$save();
//            }
//        })

        .factory('Get', function ($resource) {
            return $resource('/api/task/getTasks', {},
                    {get: {method: 'GET', isArray: true}});
        })

//        .controller('GetCtrl', function ($scope, Get) {
//            $scope.listado = Get.query();
//        });

        .factory('Clients', function ($resource) {
            return $resource('/clients', {}, {
                get: {
                    method: 'GET',
                    isArray: true
                }
            });

        })
        
        /*
         * University Services
         */
        // Get universities
        .factory('GetUniv', function ($resource) {
            return $resource('/api/uni', {}, {
                get: {
                    method: 'GET', 
                    isArray: true
                }
            });
        })
        //Get test
        .factory('Test', function ($resource) {
            return $resource('/test/getTestUniversity', {}, {
                get: {
                    method: 'GET',
                    isArray: true
                }
            });
        })
        // Get university by Id
        .factory('GetUnivById', function ($resource) {
            return $resource('/api/uni/:id', {id:'@id'}, {
                get: {
                    method: 'GET', 
                    isArray: false
                }
            });
        })
        // Update university information by Id
        .factory('UpdateUni', function ($resource) {
            return $resource('/api/uni/upd/:id',{id:'@id'});
        })
        // Post carrers to university by Id
        .factory('PostCarrersUni', function ($resource) {
            return $resource('/api/uni/:id/add',{id:'@id'});
        })
        // Post university
        .factory('PostUniv', function ($resource) {
            return $resource('/api/uni/add');
        })
        // Post Test
        .factory('PostQue', function ($resource) {
            return $resource('/test/postQuestions');
        });
;
