"use strict";

(function () {


    angular.module("app").service("projectRepository", ["$q", "$log", "projectDal", ProjectRepo]);

    function ProjectRepo($q, $log, projectDal) {

        var projectCache = [];
        console.log("This is project cache");
        /**
         *
         * @param criteria
         * @returns {*}
         */
        this.getProjects = function (criteria) {
            $log.debug("Repository:Project getProject");

            var deferred = $q.defer();
            projectDal.getProjects(criteria).then(function (results) {

                // This is a data change - broadcast events here if your application requires components communication
                projectCache = results;
                deferred.resolve(results);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };

        /**
         * Create or update requirement.  A requirement with no ID is new.
         * @returns {{}}
         */
        this.saveProject = function (projectToSave) {
            $log.debug("Repository:Project - saveProject");

            var deferred = $q.defer();
            var isUpdate = projectToSave.hasOwnProperty("id");


            $log.debug("isUpdate = " + isUpdate);
            $log.debug(JSON.stringify(projectToSave));

            projectDal.saveProject(projectToSave).then(function (project) {
                // Add newly created project to cache
                if (!isUpdate) {
                    projectCache.push(project);
                }
                deferred.resolve(project);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };

        /**
         * Delete the given project
         * @param projectToDelete
         * @returns {*}
         */
        this.deleteProject = function (projectToDelete) {
            $log.debug("Repository:Project - deleteProject");

            var deferred = $q.defer();
            projectDal.deleteProject(projectToDelete).then(function (projects) {
                _.remove(projectCache, {
                    id: projectToDelete.id
                });

                deferred.resolve(projectCache);
            }, function (error) {
                deferred.reject(error);
            });

            return deferred.promise;
        };

        $log.debug("Repository:Project Instantiated");
    }
}());