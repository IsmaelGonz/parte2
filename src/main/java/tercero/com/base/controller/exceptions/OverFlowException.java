package tercero.com.base.controller.exceptions;
/*
    Excepción que se lanza cuando se intenta agregar un elemento a una estructura de datos que ya está llena.
 */

public class OverFlowException extends Exception {
    /**
     * Creates a new instance of <code>EmptyException</code> without detail
     * message.
     */
    public OverFlowException() {
    }

    /**
     * Constructs an instance of <code>EmptyException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public OverFlowException(String msg) {
        super(msg);
    }
}