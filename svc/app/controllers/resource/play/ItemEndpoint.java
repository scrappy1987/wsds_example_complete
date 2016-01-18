package controllers.resource.play;

import models.services.item.ItemService;
import models.services.project.ProjectService;
import play.Logger;

import javax.inject.Inject;

public class ItemEndpoint extends ResourceEndpoint<ItemService>
{
    private static final Logger.ALogger logger = Logger.of(ItemEndpoint.class);

    @Inject public ItemEndpoint(ItemService itemservice)
    {
        super(itemservice);
    }
}
