/**
 * Created by rahul on 06/06/15.
 */
var app = angular.module('RadianceApp', ['ngMaterial','ngAnimate'])
    .config(function($mdThemingProvider) {
        $mdThemingProvider.theme('default')
            .primaryPalette('teal')
            .accentPalette('red');
    }).filter('tel', function (){});

app.controller('RadianceCtrl', ['$scope', '$mdSidenav', '$location','$window',function($scope, $mdSidenav,$location,$window){
    $scope.toggleSidenav = function(menuId) {
        $mdSidenav(menuId).toggle();
    };
    $scope.go = function ( path ) {
        $location.path( path );
    };

    $scope.addDataSource = function() {
        $window.location.href = '/addsource';
    };
}]);
