/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsitecomponent;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
        try {
            //convert to XMLGregorianCalendar
            date = DatatypeFactory.newInstance().newXMLGregorianCalendar();
            date.setDay(10);
            date.setMonth(10);
            date.setYear(1980);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(DatingSiteForClientTest.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("failed to create date");
        }
        try{
            registerResult = ds.registerParticipant("Testuser1", "Teststraat1", "1234AB", "Amsterdam", date, Gender.MALE, "NL12RABO012234566", "testadres@testsite.nl", "testpass");
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
        Assert.assertEquals("Expected unvalid unregister response", false, ds.logout("0123456789"));
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
    
        
}
