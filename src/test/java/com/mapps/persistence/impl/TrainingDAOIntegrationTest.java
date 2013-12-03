package com.mapps.persistence.impl;

import com.mapps.exceptions.*;
import com.mapps.model.Athlete;
import com.mapps.model.Device;
import com.mapps.model.Institution;
import com.mapps.model.Training;
import com.mapps.persistence.AthleteDAO;
import com.mapps.persistence.DeviceDAO;
import com.mapps.persistence.InstitutionDAO;
import com.mapps.persistence.TrainingDAO;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;


/**
 *
 */
public class TrainingDAOIntegrationTest {

    private static EJBContainer ejbContainer;
    private Training testTraining;
    private Device testDevice;
    private Athlete testAthlete;
    private Institution testInstitution;

    private AthleteDAO athleteDAO;
    private DeviceDAO deviceDAO;
    private TrainingDAO trainingDAO;
    private InstitutionDAO institutionDAO;

    @BeforeClass
    public static void startTheContainer(){
        ejbContainer=EJBContainer.createEJBContainer();
    }
    @Before
    public void lookupABean() throws NamingException {

        Object object=ejbContainer.getContext().lookup("java:global/mapps-persistence/TrainingDAO");
        Object object2=ejbContainer.getContext().lookup("java:global/mapps-persistence/AthleteDAO");
        Object object3=ejbContainer.getContext().lookup("java:global/mapps-persistence/DeviceDAO");
        Object object4=ejbContainer.getContext().lookup("java:global/mapps-persistence/InstitutionDAO");

        assertTrue(object instanceof TrainingDAO);
        assertTrue(object2 instanceof AthleteDAO);
        assertTrue(object3 instanceof DeviceDAO);
        assertTrue(object4 instanceof InstitutionDAO);

        trainingDAO=(TrainingDAO)object;
        athleteDAO=(AthleteDAO)object2;
        deviceDAO=(DeviceDAO)object3;
        institutionDAO=(InstitutionDAO)object4;
    }
    @AfterClass
    public static void stopTheContainer(){
        if(ejbContainer!=null){
            ejbContainer.close();
        }
    }
    @Test
    public void testTraining() throws TrainingAlreadyExistException, TrainingNotFoundException, NullParameterException, AthleteAlreadyExistException, DeviceAlreadyExistException, InstitutionAlreadyExistException, AthleteNotFoundException, DeviceNotFoundException {
        Date dNow = new Date( );
        testInstitution=new Institution("hola",null,"URUGUAY");
        testAthlete=new Athlete(null, null, null,null,
                null,1.5, 1.2,"44475992",testInstitution);
        testDevice=new Device("0013A200","40813E2A",55,testInstitution);

        HashMap<Athlete,Device> mapAthleteDevice=new HashMap<Athlete,Device>();
        mapAthleteDevice.put(testAthlete,testDevice);

        testTraining=new Training("hola",dNow,0,0,0,0,0,mapAthleteDevice,null,null,null);

        institutionDAO.addInstitution(testInstitution);
        athleteDAO.addAthlete(testAthlete);
        deviceDAO.addDevice(testDevice);
        trainingDAO.addTraining(testTraining);
        Training returnedTraining = trainingDAO.getTrainingByName(testTraining.getName());

        if(returnedTraining.isStarted()){
            System.out.println("--------------");
        }
        Athlete returnedAthlete = athleteDAO.getAthleteByIdDocument(testAthlete.getIdDocument());
        Device returnedDevice = deviceDAO.getDeviceByDir(testDevice.getDirLow());

        Training prueba= trainingDAO.getTrainingOfDevice(returnedDevice,dNow);
        System.out.println(prueba.getName());

      //  Assert.assertEquals(testTraining.getName(), returnedTraining.getName());

      //  try{
      //          trainingDAO.deleteTraining(returnedTraining.getId());
      //          trainingDAO.getTrainingByName(returnedTraining.getName());
      //      }catch (TrainingNotFoundException e){
                    //TEST deleteAthlete
      //              Assert.assertTrue(true);
      //          }

    }


}
