"use strict";

(function () {
    angular.module("app")
        .controller("homeController",
        ["$state", '$window', HomeCtrl]);

    function HomeCtrl($state, $window) {
        var vm = this;
        
        vm.isAtDashboard = function () {
            return $state.is("home.dashboard");
        };

        vm.isAtProject = function () {
            return $state.includes("home.project");
        };

        vm.isAtItem = function () {
            return $state.is("home.item");
        };

        vm.navigateToDashboard = function () {
            $state.go("home.dashboard");
        };

        vm.navigateToAddProject = function () {
            $state.go("home.projectadd");
        };

        vm.navigateToProject = function () {
            $state.go("home.project");
        };

        vm.navigateToItem = function () {
            $state.go("home.item");
        };

        vm.logout = function () {
            delete $window.sessionStorage.token;
            $state.go("login");
        };
    }
}());