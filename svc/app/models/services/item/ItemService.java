package models.services.item;

import com.fasterxml.jackson.databind.JsonNode;
import common.util.json.play.JSONHelper;
import models.services.Service;
import models.services.UnavailableServiceOperation;
import models.services.project.*;

import javax.inject.Inject;

public class ItemService extends Service
{
    private ListItemServiceOperation listServiceOperation;

    private JSONHelper jsonHelper;

    @Inject public ItemService(UnavailableServiceOperation unavailableServiceOperation,
                               ListItemServiceOperation listServiceOperation,
                               JSONHelper jsonHelper)
    {
        super(unavailableServiceOperation);

        this.listServiceOperation = listServiceOperation;

        this.jsonHelper = jsonHelper;
    }

    @Override public JsonNode list()
    {
        return listServiceOperation.execute(jsonHelper.toJson(""));
    }


}
