/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.issi.uz.zgora.pl;

import entities.issi.uz.zgora.pl.DepartamentyEntity;
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
public class DepartamentyBean {
    @PersistenceContext(name = "CRUDPU")
    private EntityManager em;

    
    
    public List<DepartamentyEntity> PobierzDepartamenty(){
        Query query = em.createNamedQuery("DepartamentyEntity.findAll");
        return query.getResultList();
}

    
   public DepartamentyEntity Pobierz (int id){
            return em.find(DepartamentyEntity.class, id);
   }
   public void Dodaj(DepartamentyEntity departament){
       em.persist(departament);
   }
   public void Edytuj(DepartamentyEntity departament){
       em.merge(departament);
   }
   public void Usun(int id){
       DepartamentyEntity departament = em.find(DepartamentyEntity.class, id);
       em.remove(departament);
   }
}

