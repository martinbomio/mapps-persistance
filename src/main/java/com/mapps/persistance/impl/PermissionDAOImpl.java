package com.mapps.persistance.impl;

import com.mapps.exceptions.PermissionNotFoundException;
import com.mapps.model.Permission;
import com.mapps.persistance.PermissionDAO;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 */
public class PermissionDAOImpl implements PermissionDAO {
    Logger logger = Logger.getLogger(PermissionDAOImpl.class);
    @PersistenceContext(unitName="mapps-persistance")
    EntityManager entityManager;

    @Override
    public void addPermission(Permission permission) {
        logger.info("A Permission was added to the database");
        entityManager.persist(permission);
    }

    @Override
    public void deletePermission(Long permissionId) throws PermissionNotFoundException {
        Permission permAux=getPermissionById(permissionId);
        entityManager.remove(permAux);
        logger.info("A Permission was removed from the database");
    }

    @Override
    public void updatePermission(Permission permission) throws PermissionNotFoundException {
        Permission permAux=getPermissionById(permission.getId());
        if(permAux!=null){
            entityManager.merge(permission);
            logger.info("A Permission was updated in the database");
        }
    }

    @Override
    public Permission getPermissionById(Long permissionId) throws PermissionNotFoundException {
        Permission permAux=entityManager.find(Permission.class, permissionId);
        if(permAux!=null){
            logger.info("A Permission was fetched from the database");
            return permAux;
        }else{
            logger.error("The Permission is not in the database");
            throw new PermissionNotFoundException();
        }
    }
}
