package com.mapps.persistence.impl;

import com.mapps.exceptions.SportNotFoundException;
import com.mapps.model.Sport;
import com.mapps.persistence.SportDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ejb.Stateless;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Usuario1
 * Date: 21/11/13
 * Time: 09:26 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "SportDao")
public class SportDAOImpl implements SportDAO {

    Logger logger= Logger.getLogger(SportDAOImpl.class);
    @PersistenceContext(unitName="mapps-persistence")
    EntityManager entityManager;

    @Override
    public void addSport(Sport sport) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteSport(Long sportId) throws SportNotFoundException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateSport(Sport sport) throws SportNotFoundException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Sport getSportById(Long sportId) throws SportNotFoundException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
