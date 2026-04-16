public enum EstadoPelicula {
    STOCK(1),
    RESERVADA(2),
    ALQUILADA(3);

    private int codigo;

    EstadoPelicula(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
