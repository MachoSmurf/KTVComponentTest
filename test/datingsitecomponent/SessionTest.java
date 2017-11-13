/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsitecomponent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
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
import webservice.DatingSiteWebServiceException_Exception;
import webservice.Gender;

/**
 *
 * @author MS-Laptop
 * 
 * This file should test the Login(), Logout(), RegisterParticipant() and UnRegisterParticipant() functionality of the interface
 */
public class SessionTest {
    
    IDatingSite ds30;
    
    public SessionTest() {
        ds30 = new DatingSiteForClient();
    }
    
    @BeforeClass
    public static void setUpClass() {
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
    
    @Test
    public void SessionTest() throws DatingSiteWebServiceException_Exception{
        boolean registerResult = ds30.registerParticipant("TestUser1", "TestStreet1", "TestCity", "1234AA", generateDate("1980/01/01"), Gender.MALE, "123456789", "test001@plusdatingtestnl", "dating001");
        Assert.assertEquals("Expected true on registration attempt", true, registerResult);
        
        String sesID = ds30.login("test001@plusdatingtestnl", "dating001");
        Assert.assertEquals("Expected 10 char String on valid login", 10, sesID.length());
        
        boolean logoutResult = ds30.logout(sesID);
        Assert.assertEquals("Expected true on logout attempt", true, logoutResult);
        
        sesID = ds30.login("test001@plusdatingtestnl", "dating001");
        boolean unregisterResult = ds30.unregisterParticipant(sesID);
        Assert.assertEquals("Expected true on unregister attempt", true, unregisterResult);
        
        //sesID should no longer be valid according to JavaDoc
        logoutResult = ds30.logout(sesID);
        Assert.assertEquals("Expected false on logout with unregistered account", false, logoutResult);
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
