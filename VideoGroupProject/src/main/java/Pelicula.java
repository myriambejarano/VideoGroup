import java.util.LinkedList;
import java.util.Queue;

public class Pelicula {
    private String titulo;
    private EstadoPelicula estado;
    private Queue<Usuario> listaEspera;

    public Pelicula(String titulo) {
        this.titulo = titulo;
        this.estado = EstadoPelicula.STOCK;
        this.listaEspera = new LinkedList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public EstadoPelicula getEstado() {
        return estado;
    }

    public void setEstado(EstadoPelicula estado) {
        this.estado = estado;
    }

    public void agregarAListaEspera(Usuario u) {
        listaEspera.add(u);
    }

    public Usuario siguienteEnEspera() {
        return listaEspera.poll();
    }
}
