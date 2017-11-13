/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsitecomponent;

import static datingsitecomponent.GetParticipantInfoTest.dataSetInit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import webservice.ColorEyes;
import webservice.ColorHair;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.Gender;
import webservice.Preference;

/**
 *
 * @author MS-Laptop
 * 
 * This file should test the setPreference() and getPreference() functionality of the interface
 */
public class PreferenceTest {
    
    IDatingSite ds30;
    IDatingSite ds50;
    public static boolean dataSetInit;
    
    public PreferenceTest() {
        ds30 = new DatingSiteForClient();
        ds50 = new DatingSiteForClient2();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws DatingSiteWebServiceException_Exception {
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
    
    @Test
    public void user1Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test1@30plusdatingtest.nl", "Dating301");
        
        Preference pp = ds30.getPreference(sesID);
        
        //setPreference(sesID, Gender.FEMALE, 30, 35, 150, 175, ColorHair.ROOD, ColorEyes.BLAUW);
        Assert.assertEquals("Expected correct Gender preference for user1", Gender.FEMALE, pp.getGender());
        Assert.assertEquals("Expected correct minAge preference for user1", 30, pp.getMinAge());
        Assert.assertEquals("Expected correct maxAge preference for user1", 35, pp.getMaxAge());
        Assert.assertEquals("Expected correct minLength preference for user1", 150, pp.getMinLength());
        Assert.assertEquals("Expected correct maxLength preference for user1", 175, pp.getMaxLength());
        Assert.assertEquals("Expected correct colorHair preference for user1", ColorHair.ROOD, pp.getColorHair());
        Assert.assertEquals("Expected correct colorEyes preference for user1", ColorEyes.BLAUW, pp.getColorEyes());
        System.out.println("Correct preferences for user1 found.");
        
        ds30.logout(sesID);
    }
    
    @Test
    public void user2Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test2@30plusdatingtest.nl", "Dating302");
        
        Preference pp = ds30.getPreference(sesID);
        
        //(sesID, Gender.FEMALE, 30, 35, 155, 170, ColorHair.ROOD, ColorEyes.BLAUW);
        Assert.assertEquals("Expected correct Gender preference for user2", Gender.FEMALE, pp.getGender());
        Assert.assertEquals("Expected correct minAge preference for user2", 30, pp.getMinAge());
        Assert.assertEquals("Expected correct maxAge preference for user2", 35, pp.getMaxAge());
        Assert.assertEquals("Expected correct minLength preference for user2", 155, pp.getMinLength());
        Assert.assertEquals("Expected correct maxLength preference for user2", 170, pp.getMaxLength());
        Assert.assertEquals("Expected correct colorHair preference for user2", ColorHair.ROOD, pp.getColorHair());
        Assert.assertEquals("Expected correct colorEyes preference for user2", ColorEyes.BLAUW, pp.getColorEyes());
        System.out.println("Correct preferences for user2 found.");
        
        ds30.logout(sesID);
    }

    
    @Test
    public void user12Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test12@30plusdatingtest.nl", "Dating312");
        
        Preference pp = ds30.getPreference(sesID);
        
        //(sesID, Gender.MALE, 30, 35, 175, 180, ColorHair.BLOND, ColorEyes.BLAUW);
        Assert.assertEquals("Expected correct Gender preference for user12", Gender.MALE, pp.getGender());
        Assert.assertEquals("Expected correct minAge preference for user12", 30, pp.getMinAge());
        Assert.assertEquals("Expected correct maxAge preference for user12", 35, pp.getMaxAge());
        Assert.assertEquals("Expected correct minLength preference for user12", 175, pp.getMinLength());
        Assert.assertEquals("Expected correct maxLength preference for user12", 180, pp.getMaxLength());
        Assert.assertEquals("Expected correct colorHair preference for user12", ColorHair.BLOND, pp.getColorHair());
        Assert.assertEquals("Expected correct colorEyes preference for user12", ColorEyes.BLAUW, pp.getColorEyes());
        System.out.println("Correct preferences for user12 found.");
        
        ds30.logout(sesID);
    }
    
    @Test
    public void user13Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test13@30plusdatingtest.nl", "Dating313");
        
        Preference pp = ds30.getPreference(sesID);
        
        //(sesID, Gender.MALE, 30, 35, 175, 180, ColorHair.ROOD, ColorEyes.BLAUW);
        Assert.assertEquals("Expected correct Gender preference for user13", Gender.MALE, pp.getGender());
        Assert.assertEquals("Expected correct minAge preference for user13", 30, pp.getMinAge());
        Assert.assertEquals("Expected correct maxAge preference for user13", 35, pp.getMaxAge());
        Assert.assertEquals("Expected correct minLength preference for user13", 175, pp.getMinLength());
        Assert.assertEquals("Expected correct maxLength preference for user13", 180, pp.getMaxLength());
        Assert.assertEquals("Expected correct colorHair preference for user13", ColorHair.ROOD, pp.getColorHair());
        Assert.assertEquals("Expected correct colorEyes preference for user13", ColorEyes.BLAUW, pp.getColorEyes());
        System.out.println("Correct preferences for user13 found.");
        
        ds30.logout(sesID);
    }
    
    
    //Start testing on the dataset50+
    @Test
    public void user25Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test25@50plusdatingtest.nl", "Dating525");
        
        Preference pp = ds50.getPreference(sesID);
        
        //(sesID, Gender.FEMALE, 60, 60, 165, 165, ColorHair.BLOND, ColorEyes.BRUIN);
        Assert.assertEquals("Expected correct Gender preference for user25", Gender.FEMALE, pp.getGender());
        Assert.assertEquals("Expected correct minAge preference for user25", 60, pp.getMinAge());
        Assert.assertEquals("Expected correct maxAge preference for user25", 60, pp.getMaxAge());
        Assert.assertEquals("Expected correct minLength preference for user25", 165, pp.getMinLength());
        Assert.assertEquals("Expected correct maxLength preference for user25", 165, pp.getMaxLength());
        Assert.assertEquals("Expected correct colorHair preference for user25", ColorHair.BLOND, pp.getColorHair());
        Assert.assertEquals("Expected correct colorEyes preference for user25", ColorEyes.BRUIN, pp.getColorEyes());
        System.out.println("Correct preferences for user25 found.");
        
        ds50.logout(sesID);
    }
    
    
    @Test
    public void user26Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test26@50plusdatingtest.nl", "Dating526");
        
        Preference pp = ds50.getPreference(sesID);
        
        //(sesID, Gender.FEMALE, 45, 60, 165, 165, ColorHair.BLOND, ColorEyes.BRUIN);
        Assert.assertEquals("Expected correct Gender preference for user26", Gender.FEMALE, pp.getGender());
        Assert.assertEquals("Expected correct minAge preference for user26", 45, pp.getMinAge());
        Assert.assertEquals("Expected correct maxAge preference for user26", 60, pp.getMaxAge());
        Assert.assertEquals("Expected correct minLength preference for user26", 165, pp.getMinLength());
        Assert.assertEquals("Expected correct maxLength preference for user26", 165, pp.getMaxLength());
        Assert.assertEquals("Expected correct colorHair preference for user26", ColorHair.BLOND, pp.getColorHair());
        Assert.assertEquals("Expected correct colorEyes preference for user26", ColorEyes.BRUIN, pp.getColorEyes());
        System.out.println("Correct preferences for user26 found.");
        
        ds50.logout(sesID);
    }
    
    @Test
    public void user35Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test35@50plusdatingtest.nl", "Dating535");
        
        Preference pp = ds50.getPreference(sesID);
        
        //(sesID, Gender.MALE, 60, 60, 180, 190, ColorHair.BRUIN, ColorEyes.BLAUW);
        Assert.assertEquals("Expected correct Gender preference for user35", Gender.MALE, pp.getGender());
        Assert.assertEquals("Expected correct minAge preference for user35", 60, pp.getMinAge());
        Assert.assertEquals("Expected correct maxAge preference for user35", 60, pp.getMaxAge());
        Assert.assertEquals("Expected correct minLength preference for user35", 180, pp.getMinLength());
        Assert.assertEquals("Expected correct maxLength preference for user35", 190, pp.getMaxLength());
        Assert.assertEquals("Expected correct colorHair preference for user35", ColorHair.BRUIN, pp.getColorHair());
        Assert.assertEquals("Expected correct colorEyes preference for user35", ColorEyes.BLAUW, pp.getColorEyes());
        System.out.println("Correct preferences for user35 found.");
        
        ds50.logout(sesID);
    }
    
    @Test
    public void user36Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test36@50plusdatingtest.nl", "Dating536");
        
        Preference pp = ds50.getPreference(sesID);
        
        //(sesID, Gender.MALE, 45, 60, 180, 200, ColorHair.GRIJS, ColorEyes.BRUIN);
        Assert.assertEquals("Expected correct Gender preference for user36", Gender.MALE, pp.getGender());
        Assert.assertEquals("Expected correct minAge preference for user36", 45, pp.getMinAge());
        Assert.assertEquals("Expected correct maxAge preference for user36", 60, pp.getMaxAge());
        Assert.assertEquals("Expected correct minLength preference for user36", 180, pp.getMinLength());
        Assert.assertEquals("Expected correct maxLength preference for user36", 200, pp.getMaxLength());
        Assert.assertEquals("Expected correct colorHair preference for user36", ColorHair.GRIJS, pp.getColorHair());
        Assert.assertEquals("Expected correct colorEyes preference for user36", ColorEyes.BRUIN, pp.getColorEyes());
        System.out.println("Correct preferences for user36 found.");
        
        ds50.logout(sesID);
    }
}
