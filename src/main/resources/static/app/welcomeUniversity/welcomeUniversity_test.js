'use strict';

describe('myApp.welcomeUniversity module', function() {

  beforeEach(module('myApp.welcomeUniversity'));

  describe('welcomeUniversity controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var welcomeUniversityCtrl = $controller('welcomeUniversityCtrl');
      expect(welcomeUniversityCtrl).toBeDefined();
    }));

  });
});