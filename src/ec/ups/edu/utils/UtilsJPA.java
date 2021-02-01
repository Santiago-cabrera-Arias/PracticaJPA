/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.utils;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author santi
 */
public class UtilsJPA implements Serializable{

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU");

    public static EntityManager getEntityManager() {

        return emf.createEntityManager();
    }

}
