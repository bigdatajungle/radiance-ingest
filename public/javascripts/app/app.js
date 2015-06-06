/**
 * Created by rahul on 06/06/15.
 */
var app = angular.module('RadianceApp', ['ngMaterial']);

app.controller('RadianceCtrl', ['$scope', '$mdSidenav', function($scope, $mdSidenav){
    $scope.toggleSidenav = function(menuId) {
        $mdSidenav(menuId).toggle();
    };

}]);