/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.issi.uz.zgora.pl;

import entities.issi.uz.zgora.pl.StanowiskaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jacek
 */
@Stateless
public class StanowiskaBean {

    
    @PersistenceContext(name = "CRUDPU")
    private EntityManager em;
    
    
    public List<StanowiskaEntity>PobierzStanowiska() {
    Query query = em.createNamedQuery("StanowiskaEntity.findAll");
    return query.getResultList();
    }
    
    public StanowiskaEntity Pobierz(int id){
                return em.find(StanowiskaEntity.class, id);
    }
    
    public void Dodaj(StanowiskaEntity stanowisko){
        em.persist(stanowisko);
    }
    public void Edytuj(StanowiskaEntity stanowisko){
        em.merge(stanowisko);
    }
    
    public void Usun(int id){
    StanowiskaEntity stanowisko = em.find(StanowiskaEntity.class, id);
    em.remove(stanowisko);
    }
}
