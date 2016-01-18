package models.services.project;

import com.fasterxml.jackson.databind.JsonNode;
import common.constants.WsdsConstants;
import models.persistence.dao.impl.ProjectDao;
import models.persistence.entities.ProjectEntity;
import models.services.ServiceOperation;
import play.Logger;
import common.util.json.play.JSONHelper;

import javax.inject.Inject;

public class FindProjectServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(FindProjectServiceOperation.class);

    private ProjectDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public FindProjectServiceOperation(ProjectDao dao, JSONHelper jsonHelper)
    {
        this.dao = dao;

        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(WsdsConstants.PROJECT_JSON_ID_PROPERTY).textValue());

        ProjectEntity project = dao.find(id);

        return jsonHelper.toJson(project);
    }
}
