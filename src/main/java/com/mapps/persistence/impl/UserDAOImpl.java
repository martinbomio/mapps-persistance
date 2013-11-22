package com.mapps.persistence.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mapps.exceptions.UserNotFoundException;
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
    public void addUser(User user) {
        logger.info("a user was added to the database");
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long userId) throws UserNotFoundException {
        User userAux=getUserById(userId);
        if(userAux!=null){
            entityManager.remove(userAux);
            logger.info("a user was removed from the database");
        }
    }

    @Override
    public void updateUser(User user) throws UserNotFoundException {
        User userAux=getUserById(user.getId());
        if(userAux!=null){
            entityManager.merge(userAux);
            logger.info("A user was updated in the database");
        }
    }

    @Override
    public User getUserById(Long userId) throws UserNotFoundException {
        User userAux=entityManager.find(User.class,userId);
        if(userAux!=null){
            return userAux;
        }else{
            throw new UserNotFoundException();
        }
    }
}
