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

        });