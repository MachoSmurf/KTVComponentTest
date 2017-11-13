/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsitecomponent;

import static datingsitecomponent.MatchingProfilesTest.dataSetInit;
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
import webservice.Profile;

/**
 *
 * @author MS-Laptop
 * 
 * This file should test the setProfile() and getProfile() functionality of the interface
 */
public class ProfileTest {
    
    IDatingSite ds30;
    IDatingSite ds50;
    public static boolean dataSetInit;
    
    public ProfileTest() {
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

    
    //We are going to test 2 males and 2 females from each datingsite on every aspect of their profile.    
    @Test
    public void user1Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test1@30plusdatingtest.nl", "Dating301");
        //ds.setProfile(sesID, 170, ColorHair.BLOND, ColorEyes.BLAUW, "Vissen", "Visser");
        
        Profile p = ds30.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user1", 170, p.getLength());
        Assert.assertEquals("Expected correct hair color for user1", ColorHair.BLOND, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user1", ColorEyes.BLAUW, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user1", "Vissen", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user1", "Visser", p.getDescription());
        System.out.println("Correct profile for user 1 found.");
        
        ds30.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.GROEN, "Voetbal", "Voetballer");
        p = ds30.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user1", 180, p.getLength());
        Assert.assertEquals("Expected correct hair color for user1", ColorHair.BRUIN, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user1", ColorEyes.GROEN, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user1", "Voetbal", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user1", "Voetballer", p.getDescription());
        System.out.println("User1 updated correctly.");
    }
    
    @Test
    public void user2Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test2@30plusdatingtest.nl", "Dating302");
        //ds.setProfile(sesID, 175, ColorHair.BLOND, ColorEyes.BLAUW, "Sporten", "Sportief");
        
        Profile p = ds30.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user2", 175, p.getLength());
        Assert.assertEquals("Expected correct hair color for user2", ColorHair.BLOND, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user2", ColorEyes.BLAUW, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user2", "Sporten", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user2", "Sportief", p.getDescription());
        System.out.println("Correct profile for user 2 found.");
        
        ds30.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.GROEN, "Voetbal", "Voetballer");
        p = ds30.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user2", 180, p.getLength());
        Assert.assertEquals("Expected correct hair color for user2", ColorHair.BRUIN, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user2", ColorEyes.GROEN, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user2", "Voetbal", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user2", "Voetballer", p.getDescription());
        System.out.println("User2 updated correctly.");
    }
    
    @Test
    public void user12Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test12@30plusdatingtest.nl", "Dating312");
        //ds.setProfile(sesID, 155, ColorHair.ROOD, ColorEyes.BLAUW, "Shoppen", "Shopt graag");
        
        Profile p = ds30.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user12", 155, p.getLength());
        Assert.assertEquals("Expected correct hair color for user12", ColorHair.ROOD, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user12", ColorEyes.BLAUW, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user12", "Shoppen", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user12", "Shopt graag", p.getDescription());
        System.out.println("Correct profile for user user12 found.");
        
        ds30.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.GROEN, "Knippen", "Kapster");
        p = ds30.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user12", 180, p.getLength());
        Assert.assertEquals("Expected correct hair color for user12", ColorHair.BRUIN, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user12", ColorEyes.GROEN, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user12", "Knippen", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user12", "Kapster", p.getDescription());
        System.out.println("user12 updated correctly.");
    }
    
    @Test
    public void user13Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test13@30plusdatingtest.nl", "Dating313");
        //ds.setProfile(sesID, 160, ColorHair.BLOND, ColorEyes.BLAUW, "Lezen", "Leest graag boeken");
        
        Profile p = ds30.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user13", 160, p.getLength());
        Assert.assertEquals("Expected correct hair color for user13", ColorHair.BLOND, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user13", ColorEyes.BLAUW, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user13", "Lezen", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user13", "Leest graag boeken", p.getDescription());
        System.out.println("Correct profile for user user13 found.");
        
        ds30.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.GROEN, "Knippen", "Kapster");
        p = ds30.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user13", 180, p.getLength());
        Assert.assertEquals("Expected correct hair color for user13", ColorHair.BRUIN, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user13", ColorEyes.GROEN, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user13", "Knippen", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user12", "Kapster", p.getDescription());
        System.out.println("user12 updated correctly.");
    }
    
    //start testing users from dataset50+
    @Test
    public void user25Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test25@50plusdatingtest.nl", "Dating525");
        //ds.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.BLAUW, "Motorrijden", "Motorrijder");
        
        Profile p = ds50.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user25", 180, p.getLength());
        Assert.assertEquals("Expected correct hair color for user25", ColorHair.BRUIN, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user25", ColorEyes.BLAUW, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user25", "Motorrijden", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user25", "Motorrijder", p.getDescription());
        System.out.println("Correct profile for user user25 found.");
        
        ds50.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.GROEN, "Kruiswoordpuzzels", "Puzzelaar");
        p = ds50.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user25", 180, p.getLength());
        Assert.assertEquals("Expected correct hair color for user25", ColorHair.BRUIN, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user25", ColorEyes.GROEN, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user25", "Kruiswoordpuzzels", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user25", "Puzzelaar", p.getDescription());
        System.out.println("user25 updated correctly.");
    }
    
    @Test
    public void user26Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test26@50plusdatingtest.nl", "Dating526");
        //ds.setProfile(sesID, 180, ColorHair.GRIJS, ColorEyes.BRUIN, "Vissen", "Visser");
        
        Profile p = ds50.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user26", 180, p.getLength());
        Assert.assertEquals("Expected correct hair color for user26", ColorHair.GRIJS, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user26", ColorEyes.BRUIN, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user26", "Vissen", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user26", "Visser", p.getDescription());
        System.out.println("Correct profile for user user26 found.");
        
        ds50.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.GROEN, "Kruiswoordpuzzels", "Puzzelaar");
        p = ds50.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user26", 180, p.getLength());
        Assert.assertEquals("Expected correct hair color for user26", ColorHair.BRUIN, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user26", ColorEyes.GROEN, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user26", "Kruiswoordpuzzels", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user26", "Puzzelaar", p.getDescription());
        System.out.println("user26 updated correctly.");
    }
    
    @Test
    public void user35Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test35@50plusdatingtest.nl", "Dating535");
        //ds.setProfile(sesID, 165, ColorHair.BLOND, ColorEyes.BRUIN, "Shoppen", "Shopt graag");
        
        Profile p = ds50.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user35", 165, p.getLength());
        Assert.assertEquals("Expected correct hair color for user35", ColorHair.BLOND, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user35", ColorEyes.BRUIN, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user35", "Shoppen", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user35", "Shopt graag", p.getDescription());
        System.out.println("Correct profile for user user35 found.");
        
        ds50.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.GROEN, "Breien", "Is graag thuis");
        p = ds50.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user35", 180, p.getLength());
        Assert.assertEquals("Expected correct hair color for user35", ColorHair.BRUIN, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user35", ColorEyes.GROEN, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user35", "Breien", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user35", "Is graag thuis", p.getDescription());
        System.out.println("user35 updated correctly.");
    }
    
    @Test
    public void user36Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test36@50plusdatingtest.nl", "Dating536");
        //ds.setProfile(sesID, 165, ColorHair.BLOND, ColorEyes.BRUIN, "Lezen", "Leest graag boeken");
        
        Profile p = ds50.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user36", 165, p.getLength());
        Assert.assertEquals("Expected correct hair color for user36", ColorHair.BLOND, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user36", ColorEyes.BRUIN, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user36", "Lezen", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user36", "Leest graag boeken", p.getDescription());
        System.out.println("Correct profile for user user36 found.");
        
        ds50.setProfile(sesID, 180, ColorHair.BRUIN, ColorEyes.GROEN, "Breien", "Is graag thuis");
        p = ds50.getProfile(sesID);
        Assert.assertEquals("Expected correct length for user36", 180, p.getLength());
        Assert.assertEquals("Expected correct hair color for user36", ColorHair.BRUIN, p.getColorHair());
        Assert.assertEquals("Expected correct eye color for user36", ColorEyes.GROEN, p.getColorEyes());
        Assert.assertEquals("Expected correct hobbies for user36", "Breien", p.getHobbies());
        Assert.assertEquals("Expected correct descriotion for user36", "Is graag thuis", p.getDescription());
        System.out.println("user36 updated correctly.");
    }
}
