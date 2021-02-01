package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Persona;
import ec.ups.edu.utils.UtilsJPA;
import static ec.ups.edu.utils.UtilsJPA.getEntityManager;
import ec.ups.edu.validaciones.ExcepcionCedula;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class ControladorPersona extends AbstractControlador<Persona> {

    Persona persona;
    UtilsJPA utilJPA = new UtilsJPA();

    //Empieza Singleton
    private static ControladorPersona instancia = new ControladorPersona();

    public static ControladorPersona getControladorPersona() {

        if (instancia == null) {

            instancia = new ControladorPersona();

        }

        return instancia;

    }

    //Fin Singleton.
    @Override
    public boolean validacion(Persona objeto) throws ExcepcionCedula {

        int total = 0;

        String cedula[] = objeto.getCedula().split("");

        if (cedula.length == 10) {

            for (int i = 0; i < cedula.length; i++) {

                if (i % 2 == 0) {

                    total += Integer.parseInt(cedula[i]) * 2;

                    if (Integer.parseInt(cedula[i]) * 2 > 9) {

                        total -= 9;

                    }

                } else {

                    total += Integer.parseInt(cedula[i]);

                }

                if (total == 10 && cedula[cedula.length - 1].equals("9")) {

                    return true;

                } else {

                    total = 10 - total % 10;

                    if (cedula[cedula.length - 1].equals("" + total)) {

                        return true;

                    }

                }

            }

            throw new ExcepcionCedula();

        }

        JOptionPane.showMessageDialog(null, "La cedula es incorrecta");

        return false;
    }

    public boolean iniciarSesion(String correo, String contrasena) {

        System.out.println(correo);
        System.out.println(contrasena);

        EntityManager em = getEntityManager();

        try {

            String jpql = "Select p from Persona p where p.correo='" + correo + "'";
            Persona persona = (Persona) em.createQuery(jpql).getSingleResult();

            System.out.println(persona);

            if (persona.getContrasena().equals(contrasena)) {

                return true;

                //return persona;
            }

            //return persona;
        } catch (NoResultException e) {

            System.out.println("No ha sido posible iniciar Sesion");
            return false;

        }

        return false;

    }

    public Persona buscar(String cedula) {

        EntityManager em = getEntityManager();

        try {

            String jpql = "Select p from Persona p where p.cedula='"+cedula+"'";
            Persona p = (Persona) em.createQuery(jpql).getSingleResult();

            return p;

        } catch (NoResultException e) {

            System.out.println("Error " + e);

        }

        return null;

    }

}
