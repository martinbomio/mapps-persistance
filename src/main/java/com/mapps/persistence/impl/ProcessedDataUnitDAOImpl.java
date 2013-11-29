package com.mapps.persistence.impl;

import com.mapps.exceptions.ProcessedDataUnitNotFoundException;
import com.mapps.model.ProcessedDataUnit;
import com.mapps.persistence.ProcessedDataUnitDAO;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Usuario1
 * Date: 27/11/13
 * Time: 09:27 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name="ProcessedDataUnitDAO")
public class ProcessedDataUnitDAOImpl implements ProcessedDataUnitDAO {

    Logger logger= Logger.getLogger(ProcessedDataUnitDAOImpl.class);
    @PersistenceContext(unitName = "mapps-persistence")
    EntityManager entityManager;

    @Override
    public void addProcessedDataUnit(ProcessedDataUnit processedDataUnit) {
        logger.info("a ProcessedDataUnit was added to the database");
        entityManager.persist(processedDataUnit);
    }

    @Override
    public void deleteProcessedDataUnit(Long processedDataUnitId) throws ProcessedDataUnitNotFoundException {
        ProcessedDataUnit processedDataUnitAux=getProcessedDataUnitById(processedDataUnitId);
        if(processedDataUnitAux!=null){
            entityManager.remove(processedDataUnitAux);
            logger.info("a processedDataUnit was removed from the database");
        }
    }

    @Override
    public void updateProcessedDataUnit(ProcessedDataUnit processedDataUnit) throws ProcessedDataUnitNotFoundException {
        ProcessedDataUnit processedDataUnitAux=getProcessedDataUnitById(processedDataUnit.getId());
        if(processedDataUnitAux!=null){
            entityManager.merge(processedDataUnit);
            logger.info("A ProcessedDataUnit was updated in the database");
        }
    }

    @Override
    public ProcessedDataUnit getProcessedDataUnitById(Long processedDataUnitId) throws ProcessedDataUnitNotFoundException {
        ProcessedDataUnit processedDataUnitAux=entityManager.find(ProcessedDataUnit.class,processedDataUnitId);
        if(processedDataUnitAux!=null){
            return processedDataUnitAux;
        }else{
            throw new ProcessedDataUnitNotFoundException();
        }
    }
}
