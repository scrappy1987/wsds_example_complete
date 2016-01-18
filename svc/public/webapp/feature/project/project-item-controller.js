"use strict";

(function () {
    /**
     * Manages individual projects within a ng-repeat set
     */
    angular.module('app')
        .controller("projectItemController",
        ["$state", "projectRepository", ProjectItemCtrl]);

    function ProjectItemCtrl($state, projectRepository) {
        var vm = this;
        // name constant - for trace and debugging
        vm.controllerName = "projectItemController";

        vm.delete = function (project) {
            var waitingDialog;
            BootstrapDialog.confirm({
                message: 'Are you sure that you want to delete this project?',
                type: BootstrapDialog.TYPE_WARNING,
                btnOKLabel: 'Delete!',
                btnOKClass: 'btn-warning',
                callback: function (confirmed) {
                    if (confirmed) {
                        waitingDialog = BootstrapDialog.show({
                            message: 'Please wait - Deleting project'
                        });
                        projectRepository.deleteProject(project).then(function () {
                            waitingDialog.close();
                        }, function (error) {
                            // TODO error
                        });
                    }
                }
            })
        };

        vm.amend = function (project) {
           //TODO amend
        };
    }

}());