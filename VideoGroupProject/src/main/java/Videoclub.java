import java.util.ArrayList;
import java.util.List;

public class Videoclub {
    private List<Usuario> usuarios;
    private List<Pelicula> peliculas;
    private List<Reserva> reservas;

    public Videoclub() {
        usuarios = new ArrayList<>();
        peliculas = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void agregarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public void agregarPelicula(Pelicula p) {
        peliculas.add(p);
    }

    public void reservarPelicula(Usuario u, Pelicula p) {
        if (p.getEstado() == EstadoPelicula.STOCK) {
            p.setEstado(EstadoPelicula.ALQUILADA);
            u.alquilarPelicula(p);

            Reserva r = new Reserva(u, p);
            reservas.add(r);

            System.out.println(u.getNombre() + " ha alquilado " + p.getTitulo());
        } else {
            p.agregarAListaEspera(u);
            System.out.println("Lo sentimos, "+u.getNombre()+" pero la película no disponible. Añadido a lista de espera.");
        }
    }

    public void devolverPelicula(Usuario u, Pelicula p) {
        u.devolverPelicula(p);
        p.setEstado(EstadoPelicula.STOCK);

        Usuario siguiente = p.siguienteEnEspera();
        if (siguiente != null) {
            reservarPelicula(siguiente, p);
        }
    }

    public void comprobarRetrasos() {
        for (Reserva r : reservas) {
            if (r.estaRetrasado()) {
                r.getUsuario().setRetraso(true);
                System.out.println("Usuario con retraso: " + r.getUsuario().getNombre());
            }
        }
    }
}
