/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans.issi.uz.zgora.pl;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author jacek
 */
@Named
@RequestScoped
public class Autoryzacja extends Pracownicy implements Serializable{
    private ExternalContext ctx;
    private HttpServletRequest request;
    
    public Autoryzacja() {
    	ctx = FacesContext.getCurrentInstance().getExternalContext();
    	request = (HttpServletRequest) ctx.getRequest();
    }
    public boolean isZalogowany() {
        return request.isUserInRole("admin");
    }
    public String wyloguj()
    {
        try { 
            request.logout();
        } catch (ServletException ex) {
            Logger.getLogger(Autoryzacja.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "login";
    }
}
