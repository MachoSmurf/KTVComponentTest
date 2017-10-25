/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsitecomponent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import webservice.DatingSiteWebServiceException;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.Gender;
import webservice.Message;
import webservice.Preference;
import webservice.Profile;

/**
 *
 * @author MS-Laptop
 */
public class DatingSiteForClientTest {
    
    DatingSiteForClient ds;
    
    public DatingSiteForClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ds = new DatingSiteForClient();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetDatingSiteName() throws DatingSiteWebServiceException_Exception{
        Assert.assertEquals("Name test failed", "TestSite30Plus", ds.getDatingSiteName());        
    }
    
    @Test
    public void testRegisterParticipant() throws DatingSiteWebServiceException_Exception{
        XMLGregorianCalendar date = null;
        boolean registerResult = false;
        
        try{            
            DateFormat format = new SimpleDateFormat("Y/M/d");
            String dateStr = "1980/03/01";
            Date d = format.parse(dateStr);
            GregorianCalendar gregory = new GregorianCalendar();
            gregory.setTime(d);
            XMLGregorianCalendar calendarMale = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
            registerResult = ds.registerParticipant("Joost Kuijpers", "Hoofdstraat 73", "Groningen", "4183 KS", calendarMale, Gender.MALE, "NL 21 RABO 0123456789", "test@test.nl", "testpass");
        }
        catch (Exception e)
        {
            System.out.println(e);
            fail("Exception when registering:" + e);
        }        
        
        Assert.assertEquals("Expected Registration", true, registerResult);
    }    
       
    @Test
    public void testUnregisterParticipant() throws DatingSiteWebServiceException_Exception{
        Assert.assertEquals("Expected unvalid unregister response", false, ds.unregisterParticipant("0123456789"));
        try{
            ds.unregisterParticipant("short");
        }
        catch(DatingSiteWebServiceException_Exception dswe){
            Assert.assertEquals("Expected to short error for session ID", "ERROR: wrong length sessionId", dswe.getMessage());
        }
        try{
            ds.unregisterParticipant("thissessionIDistolong");
        }
        catch(DatingSiteWebServiceException_Exception dswe){
            Assert.assertEquals("Expected to short error for session ID", "ERROR: wrong length sessionId", dswe.getMessage());
        }
    }
    
    @Test
    public void testLogin() throws DatingSiteWebServiceException_Exception {        
        Assert.assertEquals("Ongeldige login verwacht (Null)", null, ds.login("onbekend", "Verkeerdwachtwoord"));
    }
    
    @Test
    public void testLogout() throws DatingSiteWebServiceException_Exception
    {
        Assert.assertEquals("Expected unvalid logout response", false, ds.logout("0123456789"));
        try{
            ds.logout("thissessionIDistolong");
        }
        catch(DatingSiteWebServiceException_Exception dswe){
            Assert.assertEquals("Expected to short error for session ID", "ERROR: wrong session id logout()", dswe.getMessage());
        }
        try{
            ds.logout("short");
        }
        catch(DatingSiteWebServiceException_Exception dswe){
            Assert.assertEquals("Expected to short error for session ID", "ERROR: wrong session id logout()", dswe.getMessage());
        }        
    }
    
    @Test
    public void testGetMessagesReceived() throws DatingSiteWebServiceException_Exception{
        
        List<Message> responseList = new ArrayList<>();
        responseList = ds.getMessagesReceived("0123456789");       
        Assert.assertEquals("Expected null on invalid sessionID for getMessagesReceived", new ArrayList(), responseList);
    }
    
    @Test
    public void testGetMessagesSend() throws DatingSiteWebServiceException_Exception{
        
        List<Message> responseList = new ArrayList<>();
        responseList = ds.getMessagesSent("0123456789");       
        Assert.assertEquals("Expected null on invalid sessionID for getMessagesSend", new ArrayList(), responseList);
    }
    
    @Test
    public void testSendMessage() throws DatingSiteWebServiceException_Exception{
        
        Profile nonExisting1 = new Profile();        
        boolean messageResult = ds.sendMessage("0123456789", nonExisting1, "Dit is een test");        
        Assert.assertEquals("Expected false on wrong session ID for sendMessage", false, messageResult);
    }
    
    @Test
    public void testRequestMatchingProfiles() throws DatingSiteWebServiceException_Exception{
        
        List<Profile> responseList = new ArrayList<>();
        responseList = ds.requestMatchingProfiles("0123456789");
        Assert.assertEquals("Expected false on wrong session ID for requestMessageProfile", new ArrayList(), responseList);
    }
    
    @Test 
    public void testGetPreference() throws DatingSiteWebServiceException_Exception{
        
        Preference responsePreference = ds.getPreference("0123456789");
        Assert.assertEquals("Expected false on wrong session ID for getPreference", null, responsePreference);
    }
}