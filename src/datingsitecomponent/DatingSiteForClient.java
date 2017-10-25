/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datingsitecomponent;
  
import webservice.DatingSiteWebServiceException_Exception;

/**
 *
 * @author MS-Laptop
 */
public class DatingSiteForClient {

    public String getDatingSiteName() throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.getDatingSiteName();
    } 

    public boolean registerParticipant(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, javax.xml.datatype.XMLGregorianCalendar arg4, webservice.Gender arg5, java.lang.String arg6, java.lang.String arg7, java.lang.String arg8) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.registerParticipant(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public boolean unregisterParticipant(java.lang.String arg0) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.unregisterParticipant(arg0);
    }   

    public String login(java.lang.String arg0, java.lang.String arg1) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.login(arg0, arg1);
    }

    public boolean logout(java.lang.String arg0) throws DatingSiteWebServiceException_Exception {
        webservice.DatingSiteForClientService service = new webservice.DatingSiteForClientService();
        webservice.IDatingSiteForClient port = service.getDatingSiteForClientPort();
        return port.logout(arg0);
    }
    
}
