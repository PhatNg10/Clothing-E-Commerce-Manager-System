/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.EMUtil;

/**
 *
 * @author phatn
 */
public class OrderDAO {
    public static void insert(Order order){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(order);
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally{
            em.close();
        }
    }
    
    public static void delete(Order order){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(order));
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    public static void update(Order order) {
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(order);
            trans.commit();
        }
        catch (Exception ex) {
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
}
