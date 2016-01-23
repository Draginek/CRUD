/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.issi.uz.zgora.pl;

import entities.issi.uz.zgora.pl.GrupyEntity;
import entities.issi.uz.zgora.pl.PracownicyEntity;
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
public class PracownicyBean {

  @PersistenceContext(name = "CRUDPU")
    private EntityManager em;
    
  
    public List<PracownicyEntity> PobierzPracownikow(){
      Query query = em.createNamedQuery("PracownicyEntity.findAll");
      return query.getResultList();
    }
  
     public PracownicyEntity Pobierz(int id){
      return em.find(PracownicyEntity.class, id);
    }
  
    public void Edytuj(PracownicyEntity pracownik){
        em.merge(pracownik);
    }
     public void Usun(int id){
    PracownicyEntity pracownik = em.find(PracownicyEntity.class, id);
    em.remove(pracownik);
    }
    public void Dodaj(PracownicyEntity pracownik){
        if(pracownik.getLogin() != null)
        {
                GrupyEntity grupa = new GrupyEntity();
                grupa.setLogin(pracownik.getLogin());
                grupa.setGrupa("admin");
                em.persist(grupa);
        }
        em.persist(pracownik);
    }
     
    public boolean sprawdzLogin(String login){
        Query query = em.createNamedQuery("PracownicyEntity.findByLogin");
        query.setParameter("login", login);
        if(query.getResultList().isEmpty()){
                    return true;
        }return false;
    }
    
    
}
