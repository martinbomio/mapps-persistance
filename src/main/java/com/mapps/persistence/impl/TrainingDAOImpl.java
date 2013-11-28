package com.mapps.persistence.impl;

import com.mapps.exceptions.TrainingNotFoundException;
import com.mapps.model.Training;
import com.mapps.persistence.TrainingDAO;
import org.apache.log4j.Logger;


import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Usuario1
 * Date: 27/11/13
 * Time: 09:41 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name = "TrainingDao")
public class TrainingDAOImpl implements TrainingDAO {

    Logger logger = Logger.getLogger(TrainingDAOImpl.class);
    @PersistenceContext(unitName="mapps-persistence")
    EntityManager entityManager;

    @Override
    public void addTraining(Training training) {
        logger.info("A Training was added to the database");
        entityManager.persist(training);
    }

    @Override
    public void deleteTraining(Long trainingId) throws TrainingNotFoundException {
        Training training=getTrainingById(trainingId);
        if(training!=null){
            entityManager.remove(training);
            logger.info("A Training was removed from the database");
        }
    }

    @Override
    public void updateTraining(Training training) throws TrainingNotFoundException {
        Training trainingAux=getTrainingById(training.getId());
        if(trainingAux!=null){
            entityManager.merge(training);
            logger.info("A Training was updated in the database");
        }
    }

    @Override
    public Training getTrainingById(Long trainingId) throws TrainingNotFoundException {
        Training TrainingAux=entityManager.find(Training.class, trainingId);
        if(TrainingAux!=null){
            return TrainingAux;
        }else{
            logger.error("The Training is not in the database");
            throw new TrainingNotFoundException();
        }
    }

    @Override
    public Training getTrainingByDate(Long trainingDate) throws TrainingNotFoundException {
        Query query=entityManager.createQuery("from Trainings as t where t.date=:date");
        query.setParameter("date",trainingDate);
        List<Training> results=query.getResultList();
        if(results.size()!=1) {
            throw new TrainingNotFoundException();
        }
            return results.get(0);


    }
}
