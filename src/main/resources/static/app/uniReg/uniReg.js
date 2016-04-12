'use strict';

angular.module('myApp.uniReg', ['ngRoute', 'ngMaterial'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/uniReg', {
                    templateUrl: 'uniReg/uniReg.html',
                    controller: 'uniRegCtrl'
                });
            }])

        .controller('uniRegCtrl', ['$scope', '$rootScope', 'GetUnivById', 'GetCarrUnivById', 'UpdateUni', 'PostCarrersUni', 'Usuario', '$compile', '$mdDialog', '$mdMedia', function ($scope, $rootScope, GetUnivById, GetCarrUnivById, UpdateUni, PostCarrersUni, Usuario, $compile, $mdDialog, $mdMedia) {
                $scope.userId = "";
                // Information variables
                $scope.user = "";
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
                // Alert variables
                $scope.status = '  ';
                $scope.customFullscreen = $mdMedia('xs') || $mdMedia('sm');

                // Save the Universiti information
                $scope.loadUni = function () {
                    $scope.userId = Usuario.getUser();
                    console.log($scope.userId);
                    $scope.data = GetUnivById.get({id: $scope.userId});
                    console.log($scope.data);
                    $scope.data.$promise.then(function (data) {
                        $scope.u = data;
                        $scope.user = $scope.u.username;
                        $scope.name = $scope.u.name;
                        $scope.email = $scope.u.email;
                        $scope.url = $scope.u.url;
                        $scope.city = $scope.u.city;
                        $scope.address = $scope.u.address;
                        $scope.number = $scope.u.number;
                        $scope.src_logo = $scope.u.logo;
                        $scope.desc = $scope.u.descp;
                        $scope.carrers = $scope.u.carrers;

                        if ($scope.carrers.length > 0) {
                            $scope.cName[0] = $scope.carrers[0].name;
                            $scope.addCarrer();
                            for (var i = 1; i < $scope.carrers.length; i++) {
                                $scope.cName[i] = $scope.carrers[i].name;
                                $scope.addCarrer();
                            }
                        }
                    });

//                    $scope.data = GetCarrUnivById.query({id: $scope.userId});
//                    $scope.data.$promise.then(function (data) {
//                        $scope.u = data;
//                        console.log(data);
//                    });
                };

                $scope.loadUni();

                // Save the Universiti information
                $scope.saveInfoUni = function (ev) {
                    var u = {'username': $scope.user,
                        'name': $scope.name,
                        'email': $scope.email,
                        'url': $scope.url,
                        'city': $scope.city,
                        'address': $scope.address,
                        'number': $scope.number,
                        'carrers': $scope.carrers,
                        'logo': $scope.src_logo,
                        'descp': $scope.desc
                    };

                    UpdateUni.save({id: $scope.userId}, u, function () {
                        console.info("Saved " + JSON.stringify(u));
                    });

                    $mdDialog.show(
                            $mdDialog.alert()
                            .parent(angular.element(document.querySelector('#popupContainer')))
                            .clickOutsideToClose(true)
                            .title('Univerity Information')
                            .textContent('The Univerity Information have been saved successfully.')
                            .ariaLabel('Alert Dialog Demo')
                            .ok('Got it!')
                            .targetEvent(ev)
                            );
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
                    var fragment = $scope.create('<div class="form-group"><input type="text" class="form-control" name="name" \n\
                                                    id="name' + $scope.carNumber + '" placeholder="Name" ng-model="cName['+ $scope.carNumber + ']"/></div>');
                    // You can use native DOM methods to insert the fragment:

                    var element = document.getElementById('carrers');

                    element.appendChild(fragment);

                    element = document.getElementById('name' + $scope.carNumber);
                    $compile(element)($scope);
                    $scope.carNumber += 1;
                };

                // Save carrers information
                $scope.saveCarrers = function (ev) {
                    $scope.carrers = [];
                    for (var i = 0; i < $scope.carNumber; i++) {
                        if ($scope.cName[i] != null) {
                            $scope.carrers.push({'id': i + 1000, 'name': $scope.cName[i]});
                        }
                    }
                    
//                    $scope.saveInfoUni(ev);

                    PostCarrersUni.save({id: $scope.userId}, $scope.carrers, function () {
                        console.info("Saved " + JSON.stringify($scope.carrers));
                    });

                    //Create new field
                    if ($scope.cName[$scope.carNumber - 1] != null) {
                        $scope.addCarrer();
                    }

//                     Appending dialog to document.body to cover sidenav in docs app
//                     Modal dialogs should fully cover application
//                     to prevent interaction outside of dialog
                    $mdDialog.show(
                            $mdDialog.alert()
                            .parent(angular.element(document.querySelector('#popupContainer')))
                            .clickOutsideToClose(true)
                            .title('Carrers')
                            .textContent('The Carrers have been saved successfully.')
                            .ariaLabel('Alert Dialog Demo')
                            .ok('Got it!')
                            .targetEvent(ev)
                            );
                };

            }]);
        