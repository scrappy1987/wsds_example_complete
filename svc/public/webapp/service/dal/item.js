"use strict";

(function () {

    angular.module("app").service("itemDal", ["dal", ItemDal]);

    function ItemDal (dal) {

        this.getItems = function () {
            return dal.http.GET("item");
        };
    }
}());
