'use strict';

describe('myApp.welcomeStudent module', function() {

  beforeEach(module('myApp.welcomeStudent'));

  describe('welcomeStudent controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var welcomeStudentCtrl = $controller('welcomeStudentCtrl');
      expect(welcomeStudentCtrl).toBeDefined();
    }));

  });
});