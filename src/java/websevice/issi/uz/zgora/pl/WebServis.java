/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package websevice.issi.uz.zgora.pl;

import ejb.issi.uz.zgora.pl.PracownicyBean;
import entities.issi.uz.zgora.pl.PracownicyEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author jacek
 */
@WebService(serviceName = "WebServis")
public class WebServis {

    @EJB
    private PracownicyBean ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "PobierzPracownikow")
    public List<PracownicyEntity> PobierzPracownikow() {
        return ejbRef.PobierzPracownikow();
    }

    
}
