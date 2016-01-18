"use strict";

(function () {

    angular.module("app").service("projectDal", ["dal", ProjectDal]);

    function ProjectDal (dal) {

        this.getProjects = function () {
            return dal.http.GET("project");
        };

        this.saveProject = function (projectToSave) {
            projectToSave.status = "In progress";
            return dal.http.POST("project", projectToSave);
        };

        this.updateProject = function (projectToUpdate) {
            return dal.http.PUT("project/", projectToUpdate);
        };

        this.deleteProject = function (projectToDelete) {
            return dal.http.DELETE("project/", projectToDelete);
        };

    }
}());
