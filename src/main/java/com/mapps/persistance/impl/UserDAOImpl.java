package com.mapps.persistance.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.mapps.model.User;
import com.mapps.persistance.UserDAO;

/**
 *
 */
@Stateless(name = "UserDAO")
public class UserDAOImpl implements UserDAO {
    Logger logger = Logger.getLogger(UserDAOImpl.class);
    @PersistenceContext(unitName="mapps-persistance")
    EntityManager entityManager;

    @Override
    public User getUserbyUsername(String username) {
        return null;
    }
}
