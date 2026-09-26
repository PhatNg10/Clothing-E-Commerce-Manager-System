/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phatn
 */
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.EMUtil;

public class test {
    public static void main(String[] args) {

        EntityManagerFactory emf = EMUtil.getEmFactory();

        System.out.println("EntityManagerFactory: " + emf);
        System.out.println("isOpen: " + emf.isOpen());

        EntityManager em = emf.createEntityManager();

        System.out.println("EntityManager: " + em);
        System.out.println("isOpen: " + em.isOpen());

        em.close();
        emf.close();
    }
}
