package grupo7.proyectoIntegrador.exception;

public class ExistingException extends Exception {

    /**
     * excepcion lanzada cuando la categoria ya existe.
     *
     * @param message
     */
    public ExistingException(String message) {
        super(message);
    }
}
