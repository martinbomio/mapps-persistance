package com.mapps.persistence.impl;

import com.mapps.exceptions.IMUDataNotFoundException;
import com.mapps.model.IMUData;
import com.mapps.persistence.IMUDataDAO;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Usuario1
 * Date: 22/11/13
 * Time: 05:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name="IMUDataDAO")
public class IMUDataDAOImpl implements IMUDataDAO {

    Logger logger= Logger.getLogger(IMUDataDAOImpl.class);
    @PersistenceContext(unitName = "mapps-persistence")
    EntityManager entityManager;

    @Override
    public void addIMUData(IMUData iMUData) {
        logger.info("a IMUData was added to the database");
        entityManager.persist(iMUData);
    }

    @Override
    public void deleteIMUData(Long iMUDataId) throws IMUDataNotFoundException {
        IMUData iMUDataAux=getIMUDataById(iMUDataId);
        if(iMUDataAux!=null){
            entityManager.remove(iMUDataAux);
            logger.info("a IMUData was removed from the database");
        }
    }

    @Override
    public void updateIMUData(IMUData iMUData) throws IMUDataNotFoundException {
        IMUData iMUDataAux=getIMUDataById(iMUData.getId());
        if(iMUDataAux!=null){
            entityManager.merge(iMUData);
            logger.info("A IMUData was updated in the database");
        }
    }

    @Override
    public IMUData getIMUDataById(Long iMUDataId) throws IMUDataNotFoundException {
        IMUData iMUDataAux=entityManager.find(IMUData.class,iMUDataId);
        if(iMUDataAux!=null){
            return iMUDataAux;
        }else{
            throw new IMUDataNotFoundException();
        }
    }
}
