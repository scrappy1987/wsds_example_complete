package models.services.project;

import com.fasterxml.jackson.databind.JsonNode;
import common.constants.WsdsConstants;
import models.persistence.dao.impl.ProjectDao;
import models.services.ServiceOperation;
import play.Logger;
import common.util.json.play.JSONHelper;

import javax.inject.Inject;

public class DeleteProjectServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(CreateProjectServiceOperation.class);

    private ProjectDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public DeleteProjectServiceOperation(ProjectDao dao, JSONHelper jsonHelper)
    {
        this.dao = dao;

        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        Long id = Long.parseLong(jsonRequest.findPath(WsdsConstants.PROJECT_JSON_ID_PROPERTY).textValue());

        dao.delete(id);

        return jsonHelper.toJson("{\"message\":\"Deleted Project with id" + id + "\"}");
    }
}
