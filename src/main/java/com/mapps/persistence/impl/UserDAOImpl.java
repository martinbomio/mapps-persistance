package com.mapps.persistence.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.mapps.model.User;
import com.mapps.persistence.UserDAO;

/**
 *
 */
@Stateless(name = "UserDAO")
public class UserDAOImpl implements UserDAO {
    Logger logger = Logger.getLogger(UserDAOImpl.class);
    @PersistenceContext(unitName="mapps-persistence")
    EntityManager entityManager;

    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
