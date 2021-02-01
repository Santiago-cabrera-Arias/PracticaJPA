package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Credito;

/**
 *
 * @author santi
 */
public class ControladorCredito extends AbstractControlador<Credito> {

    public static ControladorCredito instancia;

    public static ControladorCredito getControladorCasa() {

        if (instancia == null) {

            instancia = new ControladorCredito();
        }

        return instancia;

    }

    @Override
    public boolean validacion(Credito objeto) throws Exception {

        return true;

    }

}
