"use strict";

(function () {

    angular.module('app')
        .controller("projectController",
        ["projectRepository", ProjectCtrl]);

    function ProjectCtrl(projectRepository ) {
        var vm = this;

        vm.controllerName = "projectController";

        projectRepository.getProjects().then(function (results) {
             vm.projects = results;
         }, function (error) {
             vm.error = true;
             vm.errorMessage = error;
         });
    }
}());