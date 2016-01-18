package models.services.project;

import com.fasterxml.jackson.databind.JsonNode;
import common.constants.WsdsConstants;
import models.persistence.dao.impl.ProjectDao;
import models.persistence.entities.ProjectEntity;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;

public class CreateProjectServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(CreateProjectServiceOperation.class);

    private ProjectDao dao;

    @Inject
    public CreateProjectServiceOperation(ProjectDao dao)
    {
        this.dao = dao;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        ProjectEntity project = getProjectEntity(jsonRequest);

        dao.create(project);

        return jsonRequest;
    }

    private ProjectEntity getProjectEntity(JsonNode jsonRequest)
    {
        ProjectEntity project = new ProjectEntity();

        project.setStatus(jsonRequest.findPath(WsdsConstants.PROJECT_JSON_STATUS_PROPERTY).textValue());

        project.setInfo(jsonRequest.findPath(WsdsConstants.PROJECT_JSON_INFO_PROPERTY).textValue());

        project.setTitle(jsonRequest.findPath(WsdsConstants.PROJECT_JSON_TITLE_PROPERTY).textValue());

        project.setSummary(jsonRequest.findPath(WsdsConstants.PROJECT_JSON_SUMMARY_PROPERTY).textValue());

        return project;
    }
}
