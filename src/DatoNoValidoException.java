class DatoNoValidoException extends Exception {
    public DatoNoValidoException() {
        super("Dato no válido");
    }

    public DatoNoValidoException(String mensaje) {
        super(mensaje);
    }
}
