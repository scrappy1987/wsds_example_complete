"use strict";

(function () {
    /**
     * Global controller
     */
    angular.module("app")
        .controller("loginController",
        ["$state", "$window", "securityManager",   LoginCtrl]);

    function LoginCtrl($state, $window, securityManager) {
        var vm = this;

        vm.hasValidationError = false;
        vm.hasAuthenticationError = false;

        vm.errorText = {
            invalidCredentials: $$errorText.INVALID_CREDENTIALS,
            emptyCredentials: $$errorText.EMPTY_CRENDTIALS
        };

        vm.login = function () {
            vm.hasValidationError = false;
            vm.hasAuthenticationError = false;
            vm.credentials = {username: vm.username, password: vm.password};
            securityManager.login(vm.credentials).then(function (result) {
                    $window.sessionStorage.token = result.token;
                    $state.go("home.dashboard");
                },
                function (e) {
                    delete $window.sessionStorage.token;
                    vm.hasValidationError = true;
                    vm.hasAuthenticationError = true;
                    $state.go("login");
                });
        };
    }
}());
