'use strict';

angular.module('myApp.uniReg', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/uniReg', {
                templateUrl: 'uniReg/uniReg.html',
                controller: 'uniRegCtrl'
            });
        }])

        .controller('uniRegCtrl', ['$scope','$rootScope','GetUnivById','UpdateUni', 'PostCarrersUni', 'Usuario', function ($scope,$rootScope,GetUnivById,UpdateUni,PostCarrersUni, Usuario) {
            $scope.userId = "";
            // Information variables
            $scope.user = "";
            $scope.pass = "";
            $scope.name = "";
            $scope.email = "";
            $scope.url = "";
            $scope.city = "";
            $scope.address = "";
            $scope.number = "";
            $scope.src_logo;
            $scope.desc = "";
            // Carrers variables
            $scope.carNumber = 1;
            $scope.carrers = new Array(30);
            $scope.cName = new Array(30);
            $scope.dep = new Array(30);
            
            // Save the Universiti information
            $scope.loadUni = function () {
                $scope.userId = Usuario.getUser();
                console.log($scope.userId);
                $scope.data=GetUnivById.get({id:$scope.userId});
                $scope.data.$promise.then(function(data) {
                    $scope.u = data;
                    $scope.user = $scope.u.id;
                    $scope.pass = $scope.u.pass;
                    $scope.name = $scope.u.name;
                    $scope.email = $scope.u.email;
                    $scope.url = $scope.u.url;
                    $scope.city = $scope.u.city;
                    $scope.address = $scope.u.address;
                    $scope.number = $scope.u.number;
                    $scope.src_logo = $scope.u.logo;
                    $scope.desc = $scope.u.descp;
                });
            };
            
            $scope.loadUni();
            
            // Save the Universiti information
            $scope.saveInfoUni = function () {
                var u = {'id':$scope.user,
                    'pass':$scope.pass,
                    'name':$scope.name,
                    'email':$scope.email,
                    'url':$scope.url,
                    'city':$scope.city,
                    'address':$scope.address,
                    'number':$scope.number,
                    'logo':$scope.src_logo,
                    'descp':$scope.desc
                };
                
                UpdateUni.save({id:$scope.userId}, u, function(){
                    console.info("Saved "+JSON.stringify(u));
                });
            };

            // Save and show image selected
            document.getElementById("logoURL").onchange = function () {
                var reader = new FileReader();

                reader.onload = function (e) {
                    // get loaded data and render thumbnail.
                    document.getElementById("logo").src = e.target.result;
                    document.getElementById("logo").style.visibility = 'visible';
                };

                // read the image file as a data URL.
                reader.readAsDataURL(this.files[0]);
                $scope.src_logo = this.files[0];
            };

            // Create HTML fragment to be inserted
            $scope.create = function (htmlStr) {
                var frag = document.createDocumentFragment();
                var temp = document.createElement('form-group');
                temp.innerHTML = htmlStr;
                while (temp.firstChild) {
                    frag.appendChild(temp.firstChild);
                }
                return frag;
            };

            // Add a new space for a new carrer
            $scope.addCarrer = function () {
                var fragment = $scope.create('<div class="form-group"><input type="text" class="form-control" name="name" id="name' + $scope.carNumber + '" placeholder="Name" ng-model="cName['+$scope.carNumber+']"/><input type="text" class="form-control" name="dep" id="dep' + $scope.carNumber + '" placeholder="Department" ng-model="dep['+$scope.carNumber+']"/></div>');
                // You can use native DOM methods to insert the fragment:
                var element = document.getElementById('carrers');
                element.appendChild(fragment);
                console.log($scope.carNumber);
                console.log($scope.cName);
                console.log($scope.dep);
                $scope.carNumber += 1;
            };
            
            // Save carrers information
            $scope.saveCarrers = function () {
                $scope.carrers=[];
                for (var i=0;i< ($scope.carNumber-1);i++){
                    $scope.carrers.push({'id':i+1000,'name':$scope.cName[i],'department':$scope.dep[i]});
                }
                console.log($scope.carrers);
                console.log($scope.cName);
                console.log($scope.dep);
                
                PostCarrersUni.save( {id:$scope.userId}, $scope.carrers, function(){
                    console.info("Saved "+JSON.stringify($scope.carrers));
                });
            };

        }]);
        