'use strict';

angular.module('myApp.uniReg', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
            $routeProvider.when('/uniReg', {
                templateUrl: 'uniReg/uniReg.html',
                controller: 'uniRegCtrl'
            });
        }])

        .controller('uniRegCtrl', ['$scope','$rootScope','GetUnivById','UpdateUni', 'PostCarrersUni', function ($scope,$rootScope,GetUnivById,UpdateUni,PostCarrersUni) {
            //
            $rootScope.uniUser = 'eci';
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
            $scope.carrers = [];
            $scope.cName = [];
            $scope.dep = [];
            
            // Save the Universiti information
            $scope.loadUni = function () {
                $scope.data=GetUnivById.get({id:$rootScope.uniUser});
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
                
                UpdateUni.save({id:$rootScope.uniUser}, u, function(){
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
                var fragment = $scope.create('<div class="form-group"><input type="text" class="form-control" name="name" id="name' + $scope.carrers + '" placeholder="Name" ng-model="cName['+$scope.carrers+']"/><input type="text" class="form-control" name="dep" id="dep' + $scope.carrers + '" placeholder="Department" ng-model="dep['+$scope.carrers+']"/></div>');
                // You can use native DOM methods to insert the fragment:
                var element = document.getElementById('carrers');
                element.appendChild(fragment);
                $scope.carNumber += 1;
            };
            
            // Save carrers information
            $scope.saveCarrers = function () {
                for (var i=0;i< ($scope.carNumber-1);i++){
                    $scope.carrers.push({'id':i+1000,'name':$scope.cName[i],'department':$scope.dep[i]});
                }
                console.log($scope.carrers);
                
                PostCarrersUni.save({id:$rootScope.uniUser}, $scope.carrers, function(){
                    console.info("Saved "+JSON.stringify($scope.carrers));
                });
            };

        }]);
        