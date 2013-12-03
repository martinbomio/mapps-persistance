package com.mapps.persistence.impl;

import com.mapps.exceptions.TrainingAlreadyExistException;
import com.mapps.exceptions.TrainingNotFoundException;
import com.mapps.model.Training;
import com.mapps.persistence.TrainingDAO;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import static org.junit.Assert.assertTrue;


/**
 *
 */
public class TrainingDAOIntegrationTest {

    private static EJBContainer ejbContainer;
    private Training testTraining;
    private TrainingDAO trainingDAO;


    @BeforeClass
    public static void startTheContainer(){
        ejbContainer=EJBContainer.createEJBContainer();
    }
    @Before
    public void lookupABean() throws NamingException {

        Object object=ejbContainer.getContext().lookup("java:global/mapps-persistence/TrainingDAO");
        assertTrue(object instanceof TrainingDAO);
        trainingDAO=(TrainingDAO)object;
    }
    @AfterClass
    public static void stopTheContainer(){
        if(ejbContainer!=null){
            ejbContainer.close();
        }
    }
    @Test
    public void testTraining() throws TrainingAlreadyExistException, TrainingNotFoundException {
        testTraining=new Training("hola",null,0,0,0,0,0,null,null,null,null);

        trainingDAO.addTraining(testTraining);
        Training returnedTraining = trainingDAO.getTrainingByName(testTraining.getName());

        Assert.assertEquals(testTraining.getName(), returnedTraining.getName());

        try{
                trainingDAO.deleteTraining(returnedTraining.getId());
                trainingDAO.getTrainingByName(returnedTraining.getName());
            }catch (TrainingNotFoundException e){
                    //TEST deleteAthlete
                    Assert.assertTrue(true);
                }

    }


}
