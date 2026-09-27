/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import business.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import util.EMUtil;

/**
 *
 * @author phatn
 */
public class AddressDAO {
    public static Address selectById(int id){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        
        Address address = null;
        try {
            address = em.find(Address.class, id);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        finally {
            em.close();
        }
        return address;
    }
    
    public static void insert(Address address){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.persist(address);
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally{
            em.close();
        }
    }
    
    public static void delete(Address address){
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.remove(em.merge(address));
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    public static void deleteAllByIdCustomer(int customerId) {
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        String qString = "DELETE FROM Address a "
                + "WHERE a.customer_id = :id";
        Query q = em.createQuery(qString);
        q.setParameter("id", customerId);
        
        int count = 0;
        try{
            trans.begin();
            count = q.executeUpdate();
            trans.commit();
        }
        catch (Exception ex){
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    public static void update(Address address) {
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try {
            trans.begin();
            em.merge(address);
            trans.commit();
        }
        catch (Exception ex) {
            trans.rollback();
        }
        finally {
            em.close();
        }
    }
    
    public static Address selectDefaultAdress(int customerId) {
        EntityManager em = EMUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT a FROM Address a "
                + "WHERE a.customer_id = :id AND a.isDefault = true";
        TypedQuery<Address> q = em.createQuery(qString, Address.class);
        q.setParameter("id", customerId);
        
        Address defaultAddress = null;
        try {
            defaultAddress = q.getSingleResultOrNull();
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
        finally {
            em.close();
        }
        
        return defaultAddress;
    }
}
