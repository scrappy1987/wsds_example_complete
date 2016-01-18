package models.persistence.dao.impl;

import models.persistence.dao.GenericDao;
import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.ItemEntity;
import models.persistence.entities.ProjectEntity;

import javax.inject.Inject;

public class ItemDao extends GenericDao<ItemEntity>
{
    @Inject
    public ItemDao(EntityManagerProvider emp)
    {
        super(emp);
    }

    //Add methods for any Project Entity specific database accesses here.
}
