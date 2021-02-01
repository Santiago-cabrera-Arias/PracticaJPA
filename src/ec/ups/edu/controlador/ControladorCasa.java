package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Casa;
import ec.ups.edu.modelo.Persona;
import static ec.ups.edu.utils.UtilsJPA.getEntityManager;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author santi
 */
public class ControladorCasa extends AbstractControlador<Casa> {

    //Singleton
    public static ControladorCasa instancia;

    public static ControladorCasa getControladorCasa() {

        if (instancia == null) {

            instancia = new ControladorCasa();

        }

        return instancia;

    }

    //Acaba Singleton
    @Override
    public boolean validacion(Casa objeto) throws Exception {

        return true;

    }

    public Casa buscar(double valorcasa) {

        EntityManager em = getEntityManager();

        try {

            String jpql = "Select c from Casa c where c.valorcasa='" + valorcasa + "'";
            Casa c = (Casa) em.createQuery(jpql).getSingleResult();

            return c;

        } catch (NoResultException e) {

            System.out.println("Error " + e);

        }

        return null;

    }

}
