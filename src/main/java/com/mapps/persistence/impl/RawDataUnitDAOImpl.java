package com.mapps.persistence.impl;

import com.mapps.exceptions.RawDataUnitNotFoundException;
import com.mapps.model.RawDataUnit;
import com.mapps.persistence.RawDataUnitDAO;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Usuario1
 * Date: 22/11/13
 * Time: 08:01 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name="RawDataUnitDAO")
public class RawDataUnitDAOImpl implements RawDataUnitDAO {

    Logger logger= Logger.getLogger(RawDataUnitDAOImpl.class);
    @PersistenceContext(unitName = "mapps-percistence")
    EntityManager entityManager;

    @Override
    public void addRawDataUnit(RawDataUnit rawDataUnit) {
        logger.info("a RawDataUnit was added to the database");
        entityManager.persist(rawDataUnit);
    }

    @Override
    public void deleteRawDataUnit(Long rawDataUnitId) throws RawDataUnitNotFoundException {

        RawDataUnit rawDataUnitAux=getRawDataUnitById(rawDataUnitId);
        if(rawDataUnitAux!=null){
            entityManager.remove(rawDataUnitAux);
            logger.info("a rawDataUnit was removed from the database");
        }
    }

    @Override
    public void updateRawDataUnit(RawDataUnit rawDataUnit) throws RawDataUnitNotFoundException {
        RawDataUnit rawDataUnitAux=getRawDataUnitById(rawDataUnit.getId());
        if(rawDataUnitAux!=null){
            entityManager.merge(rawDataUnitAux);
            logger.info("A rawDataUnit was updated in the database");
        }
    }

    @Override
    public RawDataUnit getRawDataUnitById(Long rawDataUnitId) throws RawDataUnitNotFoundException {
        RawDataUnit rawDataUnitAux=entityManager.find(RawDataUnit.class,rawDataUnitId);
        if(rawDataUnitAux!=null){
            return rawDataUnitAux;
        }else{
            throw new RawDataUnitNotFoundException();
        }
    }
}
