package models.services.item;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.persistence.dao.impl.ItemDao;
import models.persistence.dao.impl.ProjectDao;
import models.persistence.entities.ItemEntity;
import models.persistence.entities.ProjectEntity;
import models.services.ServiceOperation;
import play.Logger;

import javax.inject.Inject;
import java.util.List;

public class ListItemServiceOperation extends ServiceOperation
{
    private static final Logger.ALogger logger = Logger.of(ListItemServiceOperation.class);

    private ItemDao dao;

    private JSONHelper jsonHelper;

    @Inject
    public ListItemServiceOperation(ItemDao dao, JSONHelper jsonHelper)
    {
        this.dao = dao;

        this.jsonHelper = jsonHelper;
    }

    @Override protected JsonNode doExecute(JsonNode jsonRequest)
    {
        List<ItemEntity> items = dao.list();

        return jsonHelper.toJson(items);
    }
}
