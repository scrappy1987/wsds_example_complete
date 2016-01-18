package models.services.project;

import com.fasterxml.jackson.databind.JsonNode;
import models.persistence.dao.impl.ProjectDao;
import models.persistence.entities.ProjectEntity;
import models.services.ServiceOperation;
import play.Logger;
import common.util.json.play.JSONHelper;

import javax.inject.Inject;
import java.util.List;

public class ListProjectsServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListProjectsServiceOperation.class);

    private ProjectDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public ListProjectsServiceOperation(ProjectDao dao, JSONHelper jsonHelper)
    {
        this.dao = dao;

        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        List<ProjectEntity> projects = dao.list();

        return jsonHelper.toJson(projects);
    }
}
