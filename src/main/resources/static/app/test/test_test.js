'use strict';

describe('myApp.test module', function() {

  beforeEach(module('myApp.test'));

  describe('test controller', function(){

    it('should ....', inject(function($controller) {
      //spec body
      var testCtrl = $controller('testCtrl');
      expect(testCtrl).toBeDefined();
    }));

  });
});