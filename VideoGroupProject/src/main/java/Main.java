public class Main {
    public static void main(String[] args) {

        Videoclub vc = new Videoclub();

        Usuario u1 = new Usuario("Juan", 1);
        Usuario u2 = new Usuario("Ana", 2);

        Pelicula p1 = new Pelicula("Matrix");

        vc.agregarUsuario(u1);
        vc.agregarUsuario(u2);
        vc.agregarPelicula(p1);

        vc.reservarPelicula(u1, p1);
        vc.reservarPelicula(u2, p1); // entra en lista de espera

        vc.devolverPelicula(u1, p1); // pasa a Ana automáticamente

        vc.comprobarRetrasos();
    }
}