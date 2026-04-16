import java.time.LocalDate;

public class Reserva {
    private Usuario usuario;
    private Pelicula pelicula;
    private LocalDate fechaReserva;
    private LocalDate fechaDevolucion;

    public Reserva(Usuario usuario, Pelicula pelicula) {
        this.usuario = usuario;
        this.pelicula = pelicula;
        this.fechaReserva = LocalDate.now();
        this.fechaDevolucion = fechaReserva.plusDays(3);
    }

    public boolean estaRetrasado() {
        return LocalDate.now().isAfter(fechaDevolucion);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }
}
