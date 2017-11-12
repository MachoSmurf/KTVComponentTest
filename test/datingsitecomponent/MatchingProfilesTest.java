/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsitecomponent;

import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import webservice.ColorEyes;
import webservice.ColorHair;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.Profile;

/**
 *
 * @author MS-Laptop
 * 
 * This file should test the requestMatchingProfiles() functionality of the interface. In order to do this the testdataset as defined in version 2.2 of the
 * Testcases Imke Raymond.pdf is firstly loaded via profile registerParticipant()
 */
public class MatchingProfilesTest {
    
    IDatingSite ds30;
    IDatingSite ds50;
    
    public MatchingProfilesTest() {
        ds30 = new DatingSiteForClient();
        ds50 = new DatingSiteForClient2();
    }
    
    @BeforeClass
    public static void setUpClass(){
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws DatingSiteWebServiceException_Exception  {
        //Load up testDataset
        
        //load datingsite 30+ dataset
        DataSet30 d30 = new DataSet30(ds30);
        d30.registerUsers();
        
        //load datingsite 50+ dataset
        DataSet50 d50 = new DataSet50(ds50);
        d50.registerUsers();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void emptyTest()
    {
        System.out.println("Setup Complete");
    }
    
    @Test
    public void testCase9_1() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test2@30plusdatingtest.nl", "Dating302");
        List<Profile> matchingProfilesUser2 = ds30.requestMatchingProfiles(sesID);
        ds30.logout(sesID);
        
        //ds.setProfile(sesID, 155, ColorHair.ROOD, ColorEyes.BLAUW, "Shoppen", "Shopt graag");
        
        Assert.assertEquals("Expected Test12", 155, matchingProfilesUser2.get(0).getLength());
        Assert.assertEquals("Expected Test12", ColorHair.ROOD, matchingProfilesUser2.get(0).getColorHair());
        Assert.assertEquals("Expected Test12", ColorEyes.BLAUW, matchingProfilesUser2.get(0).getColorEyes());
        Assert.assertEquals("Expected Test12", "Shoppen", matchingProfilesUser2.get(0).getHobbies());
        Assert.assertEquals("Expected Test12", "Shopt graag", matchingProfilesUser2.get(0).getDescription());
        System.out.println("Found matching user for Test2: Found Test12!");
        
        sesID = ds30.login("test10@30plusdatingtest.nl", "Dating310");
        List<Profile> matchingProfilesUser10 = ds30.requestMatchingProfiles(sesID);
        ds30.logout(sesID);
        
        //ds.setProfile(sesID, 165, ColorHair.BLOND, ColorEyes.BRUIN, "Lezen", "Leest graag boeken");
        
        Assert.assertEquals("Expected Test36", 165, matchingProfilesUser10.get(0).getLength());
        Assert.assertEquals("Expected Test36", ColorHair.BLOND, matchingProfilesUser10.get(0).getColorHair());
        Assert.assertEquals("Expected Test36", ColorEyes.BRUIN, matchingProfilesUser10.get(0).getColorEyes());
        Assert.assertEquals("Expected Test36", "Lezen", matchingProfilesUser10.get(0).getHobbies());
        Assert.assertEquals("Expected Test36", "Leest graag boeken", matchingProfilesUser10.get(0).getDescription());
        System.out.println("Found matching user for Test10: Found Test36!");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
