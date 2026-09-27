/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.EMUtil;

/**
 *
 * @author phatn
 */
public class ReviewDAO {
    public static void insert(Review review){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(review);
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally{
            em.close();
        }
    }
    
    public static void delete(Review review){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(review));
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    public static void update(Review review) {
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(review);
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
