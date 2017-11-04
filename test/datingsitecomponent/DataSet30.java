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
import webservice.ColorEyes;
import webservice.ColorHair;
import webservice.DatingSiteWebServiceException_Exception;
import webservice.Gender;

/**
 *
 * @author MS-Laptop
 */
public class DataSet30 {
    
    DatingSiteForClient ds;
    
    public DataSet30(DatingSiteForClient ds){
        this.ds = ds;
    }
    
    public void registerUsers() throws DatingSiteWebServiceException_Exception{
        //registerResult = ds.registerParticipant("Joost Kuijpers", "Hoofdstraat 73", "Groningen", "4183 KS", calendarMale, Gender.MALE, "NL 21 RABO 0123456789", "test@test.nl", "testpass");
        ds.registerParticipant("Test1", "Teststraat 1", "Testcity", "1234AB", generateDate("1987/01/01"), Gender.MALE, "0123451", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test2", "Teststraat 2", "Testcity", "1234AC", generateDate("1985/03/01"), Gender.MALE, "0123452", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test3", "Teststraat 3", "Testcity", "1234AD", generateDate("1983/05/01"), Gender.MALE, "0123453", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test4", "Teststraat 4", "Testcity", "1234AE", generateDate("1981/07/01"), Gender.MALE, "0123454", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test5", "Teststraat 5", "Testcity", "1234AF", generateDate("1979/09/01"), Gender.MALE, "0123455", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test6", "Teststraat 6", "Testcity", "1234AG", generateDate("1977/11/01"), Gender.MALE, "0123456", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test7", "Teststraat 7", "Testcity", "1234AH", generateDate("1975/03/01"), Gender.MALE, "0123457", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test8", "Teststraat 8", "Testcity", "1234AI", generateDate("1973/05/01"), Gender.MALE, "0123458", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test9", "Teststraat 9", "Testcity", "1234AJ", generateDate("1971/07/01"), Gender.MALE, "0123459", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test10", "Teststraat 10", "Testcity", "1234AK", generateDate("1969/09/01"), Gender.MALE, "0123450", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test11", "Teststraat 11", "Testcity", "1234AL", generateDate("1987/01/01"), Gender.FEMALE, "1123456", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test12", "Teststraat 12", "Testcity", "1234AM", generateDate("1985/03/01"), Gender.FEMALE, "2123456", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test13", "Teststraat 13", "Testcity", "1234AN", generateDate("1983/05/01"), Gender.FEMALE, "3123456", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test14", "Teststraat 14", "Testcity", "1234AO", generateDate("1981/07/01"), Gender.FEMALE, "4123456", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test15", "Teststraat 15", "Testcity", "1234AP", generateDate("1979/09/01"), Gender.FEMALE, "5123456", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test16", "Teststraat 16", "Testcity", "1234AQ", generateDate("1977/11/01"), Gender.FEMALE, "6123456", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test17", "Teststraat 17", "Testcity", "1234AR", generateDate("1975/03/01"), Gender.FEMALE, "7123456", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test18", "Teststraat 18", "Testcity", "1234AS", generateDate("1973/05/01"), Gender.FEMALE, "8123456", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test19", "Teststraat 19", "Testcity", "1234AT", generateDate("1971/07/01"), Gender.FEMALE, "9123456", "test1@30plusdatingtest.nl", "Dating301");
        ds.registerParticipant("Test20", "Teststraat 20", "Testcity", "1234AU", generateDate("1969/09/01"), Gender.FEMALE, "0123457", "test1@30plusdatingtest.nl", "Dating301");
    }
    
    public void setUserProfiles(){
        
    }

    public void setUserPreference() {
        
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
    
    private String Login(String email, String passwd) throws DatingSiteWebServiceException_Exception{
        return ds.login(email, passwd);
    }
}
