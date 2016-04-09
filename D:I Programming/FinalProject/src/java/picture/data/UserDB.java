/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package picture.data;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import picture.business.Users;

/**
 *
 * @author viniciuscustodio
 */
public class UserDB {

    public static void insertProduct(Users user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public static List checkPassword(Users user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u from Users u WHERE u.UserName = :user AND u.Password = :pwd";
        TypedQuery<Users> q = em.createQuery(qString, Users.class);
        q.setParameter("user", user.getUserName());
        q.setParameter("pwd", user.getPassword());
        List<Users> results = null;

        try {
            results = q.getResultList();
            System.out.println(results);
        } catch (NoResultException ex) {
            return null;
        } finally {
            em.close();
        }
        System.out.println("I will return");
        return results;
    }

}
