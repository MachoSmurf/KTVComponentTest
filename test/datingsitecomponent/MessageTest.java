/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsitecomponent;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.Message;
import webservice.Profile;

/**
 *
 * @author MS-Laptop
 * 
 * This file should test the sendMessage(), getMessagesSent() and getMessagesReceived() functionality of the interface
 */
public class MessageTest {
    
    IDatingSite ds30;
    IDatingSite ds50;
    Profile sender;  
    Profile receiver;  
    
    public static boolean dataSetInit;
    
    public MessageTest() {
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
    public void testCase10_1() throws DatingSiteWebServiceException_Exception
    {
        //// START TESTING USER 2 send message to user 12
        String sesID2 = ds30.login("test2@30plusdatingtest.nl", "Dating302");
        String sesID12 = ds30.login("test12@30plusdatingtest.nl", "Dating312");
        String content = "This message is for user12";

        receiver = ds30.getProfile(sesID12);
        
        ds30.sendMessage(sesID2, receiver, content);
        
        List<Message> getMessagesSent = ds30.getMessagesSent(sesID2);
        List<Message> getMessagesReceived = ds30.getMessagesReceived(sesID12);
        
        ds30.logout(sesID2);
        ds30.logout(sesID12);
        
        Assert.assertEquals("Expected This message is for Test12", "This message is for Test12", getMessagesReceived.get(0).getContent());
        Assert.assertEquals("Expected This message is for Test12", "This message is for Test12", getMessagesSent.get(0).getContent());
    }  
}
