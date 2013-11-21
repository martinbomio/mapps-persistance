package com.mapps.persistence.impl;

import com.mapps.exceptions.SportNotFoundException;
import com.mapps.model.Sport;
import com.mapps.persistence.SportDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.ejb.Stateless;
import org.apache.log4j.Logger;

/**
 *
 */
@Stateless(name = "SportDao")
public class SportDAOImpl implements SportDAO {

    Logger logger= Logger.getLogger(SportDAOImpl.class);
    @PersistenceContext(unitName="mapps-persistence")
    EntityManager entityManager;

    @Override
    public void addSport(Sport sport) {
        logger.info("A sport was added to the database");
        entityManager.persist(sport);
    }

    @Override
    public void deleteSport(Long sportId) throws SportNotFoundException {
        logger.info("A Sport was deleted from the database");
        Sport sportAux =getSportById(sportId);
        entityManager.remove(sportAux);
    }

    @Override
    public void updateSport(Sport sport) throws SportNotFoundException {

        Sport sportAux=getSportById(sport.getId());
        if(sportAux!=null){
            entityManager.merge(sportAux);
            logger.info("A Sport has been updated");
        }
    }

    @Override
    public Sport getSportById(Long sportId) throws SportNotFoundException {
         Sport sportAux= entityManager.find(Sport.class,sportId);
        if(sportAux!=null){
            logger.info("A Sport was fetched from the database");
            return sportAux;

        }else{
            logger.info("The sport is not in the database");
            throw new SportNotFoundException();
        }
    }
}
