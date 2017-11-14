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
    public static boolean dataSetInit;
    
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
        if (!dataSetInit)
        {
            //load datingsite 30+ dataset
            DataSet30 d30 = new DataSet30(ds30);
            d30.registerUsers();

            //load datingsite 50+ dataset
            DataSet50 d50 = new DataSet50(ds50);
            d50.registerUsers();      
                        
            dataSetInit = true;
        }
    }
    
    @After
    public void tearDown() {
    }
        
    //These tests can cover the the general idea behind test 9.1, 9.2, 9.3, 9.4 and 9.5. Simply because accesing the data in this stage is enough to prove acces to a profile.
    @Test
    public void user2MatchTest() throws DatingSiteWebServiceException_Exception{
        ////START TESTING USER 2//////
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
    }
    
    @Test
    public void user10MatchTest() throws DatingSiteWebServiceException_Exception{
        ////START TESTING USER 10//////
        String sesID = ds30.login("test10@30plusdatingtest.nl", "Dating310");
        List<Profile> matchingProfilesUser10 = ds30.requestMatchingProfiles(sesID);
        ds30.logout(sesID);        
        
        //ds.setProfile(sesID, 175, ColorHair.BLOND, ColorEyes.BRUIN, "Breien", "Is graag thuis");      
        Assert.assertEquals("Expected Test20", 175, matchingProfilesUser10.get(0).getLength());
        Assert.assertEquals("Expected Test20", ColorHair.BLOND, matchingProfilesUser10.get(0).getColorHair());
        Assert.assertEquals("Expected Test20", ColorEyes.BRUIN, matchingProfilesUser10.get(0).getColorEyes());
        Assert.assertEquals("Expected Test20", "Breien", matchingProfilesUser10.get(0).getHobbies());
        Assert.assertEquals("Expected Test20", "Is graag thuis", matchingProfilesUser10.get(0).getDescription());
        System.out.println("Found matching user for Test10: Found Test20!");
        
        //ds.setProfile(sesID, 165, ColorHair.BLOND, ColorEyes.BRUIN, "Lezen", "Leest graag boeken");        
        Assert.assertEquals("Expected Test36", 165, matchingProfilesUser10.get(1).getLength());
        Assert.assertEquals("Expected Test36", ColorHair.BLOND, matchingProfilesUser10.get(1).getColorHair());
        Assert.assertEquals("Expected Test36", ColorEyes.BRUIN, matchingProfilesUser10.get(1).getColorEyes());
        Assert.assertEquals("Expected Test36", "Lezen", matchingProfilesUser10.get(1).getHobbies());
        Assert.assertEquals("Expected Test36", "Leest graag boeken", matchingProfilesUser10.get(1).getDescription());
        System.out.println("Found matching user for Test10: Found Test36!");
    }
    
    @Test
    public void user20MatchTest() throws DatingSiteWebServiceException_Exception{
        ////START TESTING USER 20//////
        String sesID = ds30.login("test20@30plusdatingtest.nl", "Dating320");
        List<Profile> matchingProfilesUser20 = ds30.requestMatchingProfiles(sesID);
        ds30.logout(sesID);
        
        //ds.setProfile(sesID, 180, ColorHair.GRIJS, ColorEyes.BRUIN, "Vissen", "Visser");        
        Assert.assertEquals("Expected Test26", 180, matchingProfilesUser20.get(1).getLength());
        Assert.assertEquals("Expected Test26", ColorHair.GRIJS, matchingProfilesUser20.get(1).getColorHair());
        Assert.assertEquals("Expected Test26", ColorEyes.BRUIN, matchingProfilesUser20.get(1).getColorEyes());
        Assert.assertEquals("Expected Test26", "Vissen", matchingProfilesUser20.get(1).getHobbies());
        Assert.assertEquals("Expected Test26", "Visser", matchingProfilesUser20.get(1).getDescription());
        System.out.println("Found matching user for Test20: Found Test26!");
        
        //ds.setProfile(sesID, 200, ColorHair.GRIJS, ColorEyes.BRUIN, "Golf", "Graag buiten");
        Assert.assertEquals("Expected Test10", 200, matchingProfilesUser20.get(0).getLength());
        Assert.assertEquals("Expected Test10", ColorHair.GRIJS, matchingProfilesUser20.get(0).getColorHair());
        Assert.assertEquals("Expected Test10", ColorEyes.BRUIN, matchingProfilesUser20.get(0).getColorEyes());
        Assert.assertEquals("Expected Test10", "Golf", matchingProfilesUser20.get(0).getHobbies());
        Assert.assertEquals("Expected Test10", "Graag buiten", matchingProfilesUser20.get(0).getDescription());
        System.out.println("Found matching user for Test20: Found Test26!");
    }
    
    @Test
    public void user22MatchTest() throws DatingSiteWebServiceException_Exception{
        ////START TESTING USER 22//////
        String sesID = ds50.login("test22@50plusdatingtest.nl", "Dating522");
        List<Profile> matchingProfilesUser22 = ds50.requestMatchingProfiles(sesID);
        ds50.logout(sesID);
        
        //ds.setProfile(sesID, 155, ColorHair.ROOD, ColorEyes.BLAUW, "Shoppen", "Shopt graag");        
        Assert.assertEquals("Expected Test32", 155, matchingProfilesUser22.get(0).getLength());
        Assert.assertEquals("Expected Test32", ColorHair.ROOD, matchingProfilesUser22.get(0).getColorHair());
        Assert.assertEquals("Expected Test32", ColorEyes.BLAUW, matchingProfilesUser22.get(0).getColorEyes());
        Assert.assertEquals("Expected Test32", "Shoppen", matchingProfilesUser22.get(0).getHobbies());
        Assert.assertEquals("Expected Test32", "Shopt graag", matchingProfilesUser22.get(0).getDescription());
        System.out.println("Found matching user for Test22: Found Test32!");
    }
    
    
    @Test
    public void testCase9_6() throws DatingSiteWebServiceException_Exception{
        ////START TESTING USER 8//////
        String sesID = ds30.login("test8@30plusdatingtest.nl", "Dating308");
        List<Profile> matchingProfilesUser8 = ds50.requestMatchingProfiles(sesID);
        ds50.logout(sesID);
        
        //ds.setProfile(sesID, 155, ColorHair.ROOD, ColorEyes.BLAUW, "Shoppen", "Shopt graag"); 
        if (!matchingProfilesUser8.isEmpty()){
            fail("Expected zero matches for user 8");
        }
        System.out.println("No matching users found for user test8");
        
        ////START TESTING USER 28//////
        sesID = ds50.login("test28@50plusdatingtest.nl", "Dating528");
        List<Profile> matchingProfilesUser28 = ds50.requestMatchingProfiles(sesID);
        ds50.logout(sesID);
        
        //ds.setProfile(sesID, 155, ColorHair.ROOD, ColorEyes.BLAUW, "Shoppen", "Shopt graag");
        if (!matchingProfilesUser28.isEmpty()){
            fail("Expected zero matches for user 28");
        }        
        System.out.println("No matching users found for user test28");
    }

}
