package models.persistence.dao.impl;

import models.persistence.dao.play.EntityManagerProvider;
import models.persistence.entities.ProjectEntity;
import models.persistence.dao.GenericDao;

import javax.inject.Inject;

public class ProjectDao extends GenericDao<ProjectEntity>
{
    @Inject
    public ProjectDao(EntityManagerProvider emp)
    {
        super(emp);
    }

    //Add methods for any Project Entity specific database accesses here.
}
