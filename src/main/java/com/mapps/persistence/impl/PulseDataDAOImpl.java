package com.mapps.persistence.impl;

import com.mapps.exceptions.PulseDataNotFoundException;
import com.mapps.model.PulseData;
import com.mapps.persistence.PulseDataDAO;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Usuario1
 * Date: 22/11/13
 * Time: 06:00 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name="PulseDataDAO")
public class PulseDataDAOImpl implements PulseDataDAO {
    Logger logger= Logger.getLogger(PulseDataDAOImpl.class);
    @PersistenceContext(unitName = "mapps-persistence")
    EntityManager entityManager;

    @Override
    public void addGPSData(PulseData pulseData) {
        logger.info("a PulseData was added to the database");
        entityManager.persist(pulseData);
    }

    @Override
    public void deletePulseData(Long pulseDataId) throws PulseDataNotFoundException {
        PulseData pulseDataAux=getPulseDataById(pulseDataId);
        if(pulseDataAux!=null){
            entityManager.remove(pulseDataAux);
            logger.info("a pulseData was removed from the database");
        }
    }

    @Override
    public void updatePulseData(PulseData pulseData) throws PulseDataNotFoundException {
        PulseData pulseDataAux=getPulseDataById(pulseData.getId());
        if(pulseDataAux!=null){
            entityManager.merge(pulseDataAux);
            logger.info("A PulseData was updated in the database");
        }
    }

    @Override
    public PulseData getPulseDataById(Long pulseDataId) throws PulseDataNotFoundException {
        PulseData pulseDataAux=entityManager.find(PulseData.class,pulseDataId);
        if(pulseDataAux!=null){
            return pulseDataAux;
        }else{
            throw new PulseDataNotFoundException();
        }
    }
}
