/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.logica;

import com.udea.modelo.MicroMarket;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author camilo.posadaa
 */
@Stateless
@LocalBean
public class MicroMarketManager {
    @PersistenceContext(unitName = "lab3ArquitecturaSoftware-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public List<MicroMarket> getAllZip() {
        Query query = em.createNamedQuery("MicroMarket.findAll");
        return query.getResultList();
    }
}
