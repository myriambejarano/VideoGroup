import java.util.*;
import java.util.List;

public class Usuario {
    private String nombre;
    private int id;
    private List<Pelicula> peliculasAlquiladas;
    private boolean retraso;

    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.peliculasAlquiladas = new ArrayList<>();
        this.retraso = false;
    }

    public void alquilarPelicula(Pelicula p) {
        peliculasAlquiladas.add(p);
    }

    public void devolverPelicula(Pelicula p) {
        peliculasAlquiladas.remove(p);
    }

    public void setRetraso(boolean retraso) {
        this.retraso = retraso;
    }

    public boolean tieneRetraso() {
        return retraso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
}
