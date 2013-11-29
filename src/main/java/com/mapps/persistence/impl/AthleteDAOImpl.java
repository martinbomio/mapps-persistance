package com.mapps.persistence.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.mapps.exceptions.AthleteNotFoundException;
import com.mapps.model.Athlete;
import com.mapps.persistence.AthleteDAO;

/**
 *
 */
@Stateless(name="AthleteDAO")
public class AthleteDAOImpl implements AthleteDAO{

    Logger logger= Logger.getLogger(AthleteDAOImpl.class);
    @PersistenceContext(unitName = "mapps-persistence")
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
            entityManager.merge(athlete);
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

