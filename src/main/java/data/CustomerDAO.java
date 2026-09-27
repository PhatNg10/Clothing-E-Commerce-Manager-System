/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.EMUtil;

/**
 *
 * @author phatn
 */
public class CustomerDAO {
    public static void insert(Customer customer){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(customer);
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally{
            em.close();
        }
    }
    
    public static void delete(Customer customer){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(customer));
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    public static void update(Customer customer) {
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(customer);
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
