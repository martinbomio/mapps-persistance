package com.mapps.persistence.impl;

import com.mapps.exceptions.AthleteNotFoundException;
import com.mapps.model.Athlete;
import com.mapps.persistence.AthleteDAO;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Usuario1
 * Date: 22/11/13
 * Time: 04:16 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name="AthleteDAO")
public class AthleteDAOImpl implements AthleteDAO{

    Logger logger= Logger.getLogger(AthleteDAOImpl.class);
    @PersistenceContext(unitName = "mapps-percistence")
    EntityManager entityManager;

    @Override
    public void addAthlete(Athlete athlete) {
        logger.info("a athlete was added to the database");
        entityManager.persist(athlete);
    }

    @Override
    public void deleteAthlete(Long athleteId) throws AthleteNotFoundException {
        Athlete athAux=getAthleteById(athleteId);
        if(athAux!=null){
            entityManager.remove(athAux);
            logger.info("a Athlete was removed from the database");
        }
    }

    @Override
    public void updateAthlete(Athlete athlete) throws AthleteNotFoundException {
        Athlete athAux=getAthleteById(athlete.getId());
        if(athAux!=null){
            entityManager.merge(athAux);
            logger.info("A Athlete was updated in the database");
        }
    }

    @Override
    public Athlete getAthleteById(Long athleteId) throws AthleteNotFoundException {
        Athlete athAux=entityManager.find(Athlete.class,athleteId);
        if(athAux!=null){
            return athAux;
        }else{
            throw new AthleteNotFoundException();
        }
    }
    }

