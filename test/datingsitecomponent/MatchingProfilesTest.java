/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsitecomponent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import webservice.DatingSiteWebServiceException_Exception;

/**
 *
 * @author MS-Laptop
 * 
 * This file should test the requestMatchingProfiles() functionality of the interface. In order to do this the testdataset as defined in version 2.2 of the
 * Testcases Imke Raymond.pdf is firstly loaded via profile registerParticipant()
 */
public class MatchingProfilesTest {
    
    DatingSiteForClient ds;
    
    public MatchingProfilesTest() {
        ds = new DatingSiteForClient();
    }
    
    @BeforeClass
    public void setUpClass() throws DatingSiteWebServiceException_Exception {
        //Load up testDataset
        int site = 30;
        if (site == 30)
        {
            //load datingsite 30+ dataset
            DataSet30 d30 = new DataSet30(ds);
            d30.registerUsers();
            d30.setUserProfiles();
            d30.setUserPreference();
        }
        if (site == 50)
        {
            //load datingsite 50+ dataset
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
