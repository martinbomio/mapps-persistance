package com.mapps.persistence.impl;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mapps.exceptions.AthleteAlreadyExistException;
import com.mapps.exceptions.AthleteNotFoundException;
import com.mapps.model.Athlete;
import com.mapps.persistence.AthleteDAO;

import static org.junit.Assert.assertTrue;

/**
 *
 */
public class AthleteDAOIntegrationTest {

    private static EJBContainer ejbContainer;
    private Athlete testAthlete;
    private AthleteDAO athleteDAO;

    @BeforeClass
    public static void startTheContainer(){

        ejbContainer=EJBContainer.createEJBContainer();
    }
    @Before
     public void lookupABean() throws NamingException {
        Object object2=ejbContainer.getContext().lookup("java:global/mapps-persistence/AthleteDAO");
        assertTrue(object2 instanceof AthleteDAO);
        athleteDAO=(AthleteDAO)object2;
    }

    @AfterClass
    public static void stopTheContainer(){
        if(ejbContainer!=null){
             ejbContainer.close();
        }
    }

    @Test
    public void testAthlete() throws AthleteNotFoundException,AthleteAlreadyExistException{
        testAthlete=new Athlete(null, null, null,null,
                null,1.5, 1.2,44475992,null);
        athleteDAO.addAthlete(testAthlete);

        Athlete returnedAthlete = athleteDAO.getAthleteByIdDocument(testAthlete.getIdDocument());
        Assert.assertEquals(testAthlete.getIdDocument(), returnedAthlete.getIdDocument());
    }

}
