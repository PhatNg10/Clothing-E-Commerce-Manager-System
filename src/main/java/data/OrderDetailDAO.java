/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.OrderDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.EMUtil;

/**
 *
 * @author phatn
 */
public class OrderDetailDAO {
    public static void insert(OrderDetail orderDetail){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(orderDetail);
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally{
            em.close();
        }
    }
    
    public static void delete(OrderDetail orderDetail){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(orderDetail));
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    public static void update(OrderDetail orderDetail) {
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(orderDetail);
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
