
package managedbeans.issi.uz.zgora.pl;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jacek
 */


@Named
@SessionScoped
public class Jezyk implements Serializable{
private Locale jezyk;

    public Jezyk(){
        jezyk = FacesContext.getCurrentInstance().getViewRoot().getLocale();
}
    public Locale getJezyk() {
        return jezyk;
    }
    public void setJezyk(Locale jez) {
        jezyk = jez;
    }
    public void zmienJezyk(String jez){
    
        setJezyk(new Locale(jez));
    }
}
