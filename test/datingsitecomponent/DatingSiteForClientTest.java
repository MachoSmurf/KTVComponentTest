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
        boolean registerResult = ds.registerParticipant("Testuser1", "Teststraat1", "1234AB", "Amsterdam", date, Gender.MALE, "NL12RABO012234566", "testadres@testsite.nl", "testpass");
        
        Assert.assertEquals("Expected Registration", true, registerResult);
    }
    
    @Test
    public void testLogin() throws DatingSiteWebServiceException_Exception {        
        Assert.assertEquals("Ongeldige login verwacht (Null)", null, ds.login("onbekend", "Verkeerdwachtwoord"));
    }
    
}
