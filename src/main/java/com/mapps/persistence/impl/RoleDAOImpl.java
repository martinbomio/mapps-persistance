package com.mapps.persistence.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.mapps.exceptions.RoleNotFoundException;
import com.mapps.model.Role;
import com.mapps.persistence.RoleDAO;

/**
 * Implementation of RoleDAO.
 */
public class RoleDAOImpl implements RoleDAO{

    Logger logger = Logger.getLogger(RoleDAOImpl.class);
    @PersistenceContext(unitName="mapps-persistence")
    EntityManager entityManager;

    @Override
    public Role getByID(Long id) throws RoleNotFoundException {
        Role sportAux= entityManager.find(Role.class, id);
        if(sportAux!=null){
            logger.info("A Sport was fetched from the database");
            return sportAux;

        }else{
            logger.info("The sport is not in the database");
            throw new RoleNotFoundException();
        }
    }
}
