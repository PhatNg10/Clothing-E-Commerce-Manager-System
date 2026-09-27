/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Wishlist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import util.EMUtil;

/**
 *
 * @author phatn
 */
public class WishlistDAO {
    public static void insert(Wishlist wishlist){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(wishlist);
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally{
            em.close();
        }
    }
    
    public static void delete(Wishlist wishlist){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(wishlist));
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    public static void update(Wishlist wishlist) {
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(wishlist);
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
