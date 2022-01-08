package exception;

public class RegraNegocioException extends RuntimeException {
    public RegraNegocioException(String texto) {
        super(texto);
    }
}
