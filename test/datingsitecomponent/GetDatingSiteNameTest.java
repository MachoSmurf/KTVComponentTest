/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsitecomponent;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import webservice.DatingSiteWebServiceException_Exception;

/**
 *
 * @author MS-Laptop
 */
public class GetDatingSiteNameTest {
    
    IDatingSite ds30;
    
    public GetDatingSiteNameTest() {
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
    public void getDatingSiteNameTest() throws DatingSiteWebServiceException_Exception{
        String dsName = ds30.getDatingSiteName();
        Assert.assertEquals("Expected TestSite50Plus as name", "TestSite50Plus", dsName);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
