/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsitecomponent;

import static datingsitecomponent.ProfileTest.dataSetInit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
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
import webservice.ParticipantInfo;
import webservice.Profile;

/**
 *
 * @author MS-Laptop
 */
public class GetParticipantInfoTest {
    
    IDatingSite ds30;
    IDatingSite ds50;
    public static boolean dataSetInit;
    
    public GetParticipantInfoTest() {
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

    //We are going to test 2 males and 2 females from each datingsite on every aspect of their information.    
    @Test
    public void user1Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test1@30plusdatingtest.nl", "Dating301");
        //ds.registerParticipant("Test1", "Teststraat 1", "Testcity", "1234AB", generateDate("1987/01/01"), Gender.MALE, "0123451", "test1@30plusdatingtest.nl", "Dating301");
        
        ParticipantInfo pi = ds30.getParticipantInfo(sesID);
        Assert.assertEquals("Expected correct Address for user1", "Teststraat 1", pi.getAddress());
        Assert.assertEquals("Expected correct place for user1", "Testcity", pi.getPlace());
        Assert.assertEquals("Expected correct postal code for user1", "1234AB", pi.getPostalcode());
        Assert.assertEquals("Expected correct birthdate for user1", generateDate("1987/01/01"), pi.getBirthDate());
        Assert.assertEquals("Expected correct gender for user1", Gender.MALE, pi.getGender());
        Assert.assertEquals("Expected correct bankaccount for user1", "0123451", pi.getBankaccount());
        Assert.assertEquals("Expected correct email for user1", "test1@30plusdatingtest.nl", pi.getEmail());
        Assert.assertEquals("Expected correct password for user1", "Dating301", pi.getPassword());
        System.out.println("Correct participantInfo for user 1 found.");
        
    }
    
    @Test
    public void user2Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test2@30plusdatingtest.nl", "Dating302");
        //("Test2", "Teststraat 2", "Testcity", "1234AC", generateDate("1985/03/01"), Gender.MALE, "0123452", "test2@30plusdatingtest.nl", "Dating302");
        
        ParticipantInfo pi = ds30.getParticipantInfo(sesID);
        Assert.assertEquals("Expected correct Address for user2", "Teststraat 2", pi.getAddress());
        Assert.assertEquals("Expected correct place for user2", "Testcity", pi.getPlace());
        Assert.assertEquals("Expected correct postal code for user2", "1234AC", pi.getPostalcode());
        Assert.assertEquals("Expected correct birthdate for user2", generateDate("1985/03/01"), pi.getBirthDate());
        Assert.assertEquals("Expected correct gender for user2", Gender.MALE, pi.getGender());
        Assert.assertEquals("Expected correct bankaccount for user2", "0123452", pi.getBankaccount());
        Assert.assertEquals("Expected correct email for user2", "test2@30plusdatingtest.nl", pi.getEmail());
        Assert.assertEquals("Expected correct password for user2", "Dating302", pi.getPassword());
        System.out.println("Correct participantInfo for user2 found.");
        
    }
    
    @Test
    public void user12Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test12@30plusdatingtest.nl", "Dating312");
        //("Test12", "Teststraat 12", "Testcity", "1234AM", generateDate("1985/03/01"), Gender.FEMALE, "2123456", "test12@30plusdatingtest.nl", "Dating312");
        
        ParticipantInfo pi = ds30.getParticipantInfo(sesID);
        Assert.assertEquals("Expected correct Address for user12", "Teststraat 12", pi.getAddress());
        Assert.assertEquals("Expected correct place for user12", "Testcity", pi.getPlace());
        Assert.assertEquals("Expected correct postal code for user12", "1234AM", pi.getPostalcode());
        Assert.assertEquals("Expected correct birthdate for user12", generateDate("1985/03/01"), pi.getBirthDate());
        Assert.assertEquals("Expected correct gender for user12", Gender.FEMALE, pi.getGender());
        Assert.assertEquals("Expected correct bankaccount for user12", "2123456", pi.getBankaccount());
        Assert.assertEquals("Expected correct email for user12", "test12@30plusdatingtest.nl", pi.getEmail());
        Assert.assertEquals("Expected correct password for user12", "Dating312", pi.getPassword());
        System.out.println("Correct participantInfo for user12 found.");        
    }
    
    @Test
    public void user13Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds30.login("test13@30plusdatingtest.nl", "Dating313");
        //("Test13", "Teststraat 13", "Testcity", "1234AN", generateDate("1983/05/01"), Gender.FEMALE, "3123456", "test13@30plusdatingtest.nl", "Dating313");
        
        ParticipantInfo pi = ds30.getParticipantInfo(sesID);
        Assert.assertEquals("Expected correct Address for user13", "Teststraat 13", pi.getAddress());
        Assert.assertEquals("Expected correct place for user13", "Testcity", pi.getPlace());
        Assert.assertEquals("Expected correct postal code for user13", "1234AN", pi.getPostalcode());
        Assert.assertEquals("Expected correct birthdate for user13", generateDate("1983/05/01"), pi.getBirthDate());
        Assert.assertEquals("Expected correct gender for user13", Gender.FEMALE, pi.getGender());
        Assert.assertEquals("Expected correct bankaccount for user13", "3123456", pi.getBankaccount());
        Assert.assertEquals("Expected correct email for user13", "test13@30plusdatingtest.nl", pi.getEmail());
        Assert.assertEquals("Expected correct password for user13", "Dating313", pi.getPassword());
        System.out.println("Correct participantInfo for user13 found.");        
    }
    
    //Start testing dataset50+
    @Test
    public void user25Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test25@50plusdatingtest.nl", "Dating525");
        //("Test25", "Teststraat 25", "Testcity", "2345AF", generateDate("1969/09/01"), Gender.MALE, "1234565", "test25@50plusdatingtest.nl", "Dating525");
        
        ParticipantInfo pi = ds30.getParticipantInfo(sesID);
        Assert.assertEquals("Expected correct Address for user25", "Teststraat 25", pi.getAddress());
        Assert.assertEquals("Expected correct place for user25", "Testcity", pi.getPlace());
        Assert.assertEquals("Expected correct postal code for user25", "2345AF", pi.getPostalcode());
        Assert.assertEquals("Expected correct birthdate for user25", generateDate("1969/09/01"), pi.getBirthDate());
        Assert.assertEquals("Expected correct gender for user25", Gender.MALE, pi.getGender());
        Assert.assertEquals("Expected correct bankaccount for user25", "1234565", pi.getBankaccount());
        Assert.assertEquals("Expected correct email for user25", "test25@50plusdatingtest.nl", pi.getEmail());
        Assert.assertEquals("Expected correct password for user25", "Dating525", pi.getPassword());
        System.out.println("Correct participantInfo for user25 found.");        
    }
    
    
    @Test
    public void user26Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test26@50plusdatingtest.nl", "Dating526");
        //("Test26", "Teststraat 26", "Testcity", "2345AG", generateDate("1957/11/01"), Gender.MALE, "1234566", "test26@50plusdatingtest.nl", "Dating526");
        
        ParticipantInfo pi = ds30.getParticipantInfo(sesID);
        Assert.assertEquals("Expected correct Address for user26", "Teststraat 26", pi.getAddress());
        Assert.assertEquals("Expected correct place for user26", "Testcity", pi.getPlace());
        Assert.assertEquals("Expected correct postal code for user26", "2345AG", pi.getPostalcode());
        Assert.assertEquals("Expected correct birthdate for user26", generateDate("1957/11/01"), pi.getBirthDate());
        Assert.assertEquals("Expected correct gender for user26", Gender.MALE, pi.getGender());
        Assert.assertEquals("Expected correct bankaccount for user26", "1234566", pi.getBankaccount());
        Assert.assertEquals("Expected correct email for user26", "test26@50plusdatingtest.nl", pi.getEmail());
        Assert.assertEquals("Expected correct password for user26", "Dating526", pi.getPassword());
        System.out.println("Correct participantInfo for user26 found.");        
    }
    
    @Test
    public void user35Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test35@50plusdatingtest.nl", "Dating535");
        //("Test35", "Teststraat 35", "Testcity", "2345AP", generateDate("1959/09/01"), Gender.FEMALE, "5234567", "test35@50plusdatingtest.nl", "Dating535");
        
        ParticipantInfo pi = ds30.getParticipantInfo(sesID);
        Assert.assertEquals("Expected correct Address for user35", "Teststraat 35", pi.getAddress());
        Assert.assertEquals("Expected correct place for user35", "Testcity", pi.getPlace());
        Assert.assertEquals("Expected correct postal code for user35", "2345AP", pi.getPostalcode());
        Assert.assertEquals("Expected correct birthdate for user35", generateDate("1959/09/01"), pi.getBirthDate());
        Assert.assertEquals("Expected correct gender for user35", Gender.FEMALE, pi.getGender());
        Assert.assertEquals("Expected correct bankaccount for user35", "5234567", pi.getBankaccount());
        Assert.assertEquals("Expected correct email for user35", "test35@50plusdatingtest.nl", pi.getEmail());
        Assert.assertEquals("Expected correct password for user35", "Dating535", pi.getPassword());
        System.out.println("Correct participantInfo for user35 found.");        
    }
    
    @Test
    public void user36Test() throws DatingSiteWebServiceException_Exception{
        String sesID = ds50.login("test36@50plusdatingtest.nl", "Dating536");
        //("Test36", "Teststraat 36", "Testcity", "2345AQ", generateDate("1957/11/01"), Gender.FEMALE, "6234567", "test36@50plusdatingtest.nl", "Dating536");
        
        ParticipantInfo pi = ds30.getParticipantInfo(sesID);
        Assert.assertEquals("Expected correct Address for user36", "Teststraat 36", pi.getAddress());
        Assert.assertEquals("Expected correct place for user36", "Testcity", pi.getPlace());
        Assert.assertEquals("Expected correct postal code for user36", "2345AQ", pi.getPostalcode());
        Assert.assertEquals("Expected correct birthdate for user36", generateDate("1957/11/01"), pi.getBirthDate());
        Assert.assertEquals("Expected correct gender for user36", Gender.FEMALE, pi.getGender());
        Assert.assertEquals("Expected correct bankaccount for user36", "6234567", pi.getBankaccount());
        Assert.assertEquals("Expected correct email for user36", "test36@50plusdatingtest.nl", pi.getEmail());
        Assert.assertEquals("Expected correct password for user36", "Dating536", pi.getPassword());
        System.out.println("Correct participantInfo for user36 found.");        
    }
    
    
    
    
    
    private XMLGregorianCalendar generateDate(String dateString){
        try{
            DateFormat format = new SimpleDateFormat("Y/M/d");
            Date d = format.parse(dateString);
            GregorianCalendar gregory = new GregorianCalendar();
            gregory.setTime(d);
            XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
            return calendar;
        }
        catch(ParseException | DatatypeConfigurationException e)
        {
            System.out.println("Failed to generate date when populating testDataset: " + e.getMessage());
        }
        return null;
    }
}
