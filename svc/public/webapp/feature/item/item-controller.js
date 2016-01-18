"use strict";
(function () {

    angular.module("app")
        .controller("itemController",
        ["$log", "itemRepository", ItemCtrl]);

    function ItemCtrl ($log, itemRepository) {
        var vm = this;
        $log.debug("At item Page");

        vm.controllerName = "itemController";

        itemRepository.getItems().then(function (results) {
            console.log("this is the value of results");
            console.log(results);
            vm.items = results;
        }, function (error) {
            vm.error = true;
            vm.errorMessage = error;
        });
    }
}());