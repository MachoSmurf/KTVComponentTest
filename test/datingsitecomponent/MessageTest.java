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
       
    @Before
    public void setUp() throws DatingSiteWebServiceException_Exception {
        ds30 = new DatingSiteForClient();
        ds50 = new DatingSiteForClient2();
        
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
    public void test2() throws DatingSiteWebServiceException_Exception
    {
        //// START TESTING Test2 send message to Test 12
        String sesID2 = ds30.login("test2@30plusdatingtest.nl", "Dating302");
        String sesID12 = ds30.login("test12@30plusdatingtest.nl", "Dating312");
        String content = "This message is for Test12";

        receiver = ds30.getProfile(sesID12);
        
        ds30.sendMessage(sesID2, receiver, content);
        
        List<Message> getMessagesSent2 = ds30.getMessagesSent(sesID2);
        List<Message> getMessagesReceived12 = ds30.getMessagesReceived(sesID12);
        
        ds30.logout(sesID2);
        ds30.logout(sesID12);
        
        Assert.assertEquals("Expected This message is for Test12", "This message is for Test12", getMessagesReceived12.get(getMessagesReceived12.size() -1).getContent());
        Assert.assertEquals("Expected This message is for Test12", "This message is for Test12", getMessagesSent2.get(getMessagesSent2.size() -1).getContent());
    } 
    
    @Test
    public void test10() throws DatingSiteWebServiceException_Exception
    {
        //// START TESTING Test10 send message to Test36
        String sesID10 = ds30.login("test10@30plusdatingtest.nl", "Dating310");
        String sesID36 = ds50.login("test36@50plusdatingtest.nl", "Dating536");
        String content = "This message is for Test36";
        
        receiver = ds50.getProfile(sesID36);
        ds30.sendMessage(sesID10, receiver, content);
        
        List<Message> getMessagesSent10 = ds30.getMessagesSent(sesID10);
        List<Message> getMessagesReceived36 = ds50.getMessagesReceived(sesID36);
        
        ds30.logout(sesID10);
        ds50.logout(sesID36);
        
        Assert.assertEquals("Expected This message is for Test36", "This message is for Test36", getMessagesReceived36.get(getMessagesReceived36.size() -1).getContent());
        Assert.assertEquals("Expected This message is for Test36", "This message is for Test36", getMessagesSent10.get(getMessagesSent10.size() -1).getContent());
    } 
    
       @Test
    public void test20() throws DatingSiteWebServiceException_Exception
    {
        //// START TESTING Test20 send message to Test26
        String sesID20 = ds30.login("test20@30plusdatingtest.nl", "Dating320");
        String sesID26 = ds50.login("test26@50plusdatingtest.nl", "Dating526");
        String content = "This message is for Test26";
        
        receiver = ds50.getProfile(sesID26);
        ds30.sendMessage(sesID20, receiver, content);
        
        List<Message> getMessagesSent20 = ds30.getMessagesSent(sesID20);
        List<Message> getMessagesReceived26 = ds50.getMessagesReceived(sesID26);
        
        ds30.logout(sesID20);
        ds50.logout(sesID26);
        
        Assert.assertEquals("Expected This message is for Test26", "This message is for Test26", getMessagesReceived26.get(getMessagesReceived26.size() -1).getContent());
        Assert.assertEquals("Expected This message is for Test26", "This message is for Test26", getMessagesSent20.get(getMessagesSent20.size() -1).getContent());
    } 
    
    @Test
    public void test22() throws DatingSiteWebServiceException_Exception
    {
        //// START TESTING Test22 send message to Test32
        String sesID22 = ds50.login("test22@50plusdatingtest.nl", "Dating522");
        String sesID32 = ds50.login("test32@50plusdatingtest.nl", "Dating532");
        String content1 = "This message is for Test32";
        
        receiver = ds50.getProfile(sesID32);
        ds50.sendMessage(sesID22, receiver, content1);
        
        List<Message> getMessagesSent22 = ds50.getMessagesSent(sesID22);
        List<Message> getMessagesReceived32 = ds50.getMessagesReceived(sesID32);
        
        ds50.logout(sesID22);
        ds50.logout(sesID32);
        
        Assert.assertEquals("Expected This message is for Test32", "This message is for Test32", getMessagesReceived32.get(getMessagesReceived32.size() -1).getContent());
        Assert.assertEquals("Expected This message is for Test32", "This message is for Test32", getMessagesSent22.get(getMessagesSent22.size() -1).getContent());
    } 
    
 
    
    
    
}