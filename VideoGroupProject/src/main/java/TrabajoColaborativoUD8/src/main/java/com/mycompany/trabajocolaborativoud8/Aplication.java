package TrabajoColaborativoUD8.src.main.java.com.mycompany.trabajocolaborativoud8;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Aplication {
    public static void main(String[] args) {
        ProductsDataAccessObject pda = new ProductsDataAccessObject();
        
        try{
            List<Products> lista = pda.selectAll();
        
            System.out.println("--NIVEL BAJO--");
            
            System.out.println("-----------------------------");
            System.out.println("Recogemos los nombres de los productos cuyo coste es mayor a 600:");
            System.out.println("");
            
            lista.stream()
                    .filter(e -> e.getStandardCost() > 600)
                    .map(e -> e.getProductName())
                    .forEach(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("Recogemos los nombres sin repetir de los productos cuyo coste es mayor a 600:");
            System.out.println("");
            
            lista.stream()
                    .filter(e -> e.getStandardCost() > 600)
                    .map(e -> e.getProductName())
                    .distinct()
                    .forEach(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("Recogemos los 5 primeros productos con un coste mayor a 600 y se ordenan ascendentemente:");
            System.out.println("");
            
            lista.stream()
                    .filter(e -> e.getStandardCost() > 600)
                    .sorted()
                    .limit(5)
                    .forEach(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("Ordenamos todos los productos con coste mayor a 600:");
            System.out.println("");
            
            lista.stream()
                    .sorted()
                    .filter(e -> e.getStandardCost() > 600)
                    .forEach(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("--NIVEL MEDIO--");
            
            System.out.println("-----------------------------");
            System.out.println("Recogemos en un conjunto los id de las categorias de los productos con coste mayor a 600, al ser conjuntos, no hay id de categorias duplicados:");
            System.out.println("");
            
            Set<Integer> setNombres = lista.stream()
                    .filter(e -> e.getStandardCost() > 600)
                    .map(e -> e.getCategoryId())
                    .collect(Collectors.toSet());
            
            setNombres.stream().forEach(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("Recogemos en una lista los nombres de los productos con coste mayor a 600:");
            System.out.println("");
            
            List<String> listNombres = lista.stream()
                    .filter(e -> e.getStandardCost() > 600)
                    .map(e -> e.getProductName())
                    .collect(Collectors.toList());
            
            listNombres.stream().forEach(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("Sumamos los costes de los productos con un id par:");
            System.out.println("");
            
            double sumaCostesIDPares = lista.stream()
                    .filter(e -> e.getCategoryId()%2 == 0)
                    .map(e -> e.getStandardCost())
                    .reduce(0.0, (suma, elem) -> suma + elem);
            
            System.out.println("Suma del coste de los productos con id par: "+sumaCostesIDPares);
            
            System.out.println("-----------------------------");
            System.out.println("Calculamos el precio promedio de todos los productos:");
            System.out.println("");
            
            double sumaPrecios = lista.stream()
                    .filter(e -> e.getStandardCost() > 600)
                    .map(e -> e.getListPrice())
                    .reduce(0.0, (suma, elem) -> suma + elem);
            
            double precioPromedio = sumaPrecios/lista.size();
            System.out.println("Precio promedio de los productos: "+precioPromedio);
            
            System.out.println("-----------------------------");
            System.out.println("--NIVEL ALTO--");
            
            System.out.println("-----------------------------");
            System.out.println("Buscamos todos los productos que empiecen por P y tengan un coste mayor a 600, los ordenamos, y nos muestra el primero:");
            System.out.println("");
            
            Optional<Products> buscar = lista.stream()
                    .filter(e -> e.getProductName().startsWith("P") && e.getStandardCost() > 600)
                    .sorted()
                    .findFirst();
            
            buscar.ifPresent(System.out::println);
            
            System.out.println("-----------------------------");
            System.out.println("Buscamos el valor maximo de los productos con coste mayor a la media del precio de los productos con coste mayor a 600:");
            System.out.println("");
            
            Optional<Double> precioProductos = lista.stream()
                    .filter(e -> e.getStandardCost() > precioPromedio)
                    .map(e -> e.getListPrice())
                    .max((e1, e2) -> Double.compare(e1, e2));
            
            System.out.println("El valor maximo del precio de los productos es: "  + precioProductos);
            
            System.out.println("-----------------------------");
            System.out.println("Nos saca el numero de productos que en la resta de los precios menos el coste sea mayor a 50:");
            System.out.println("");
            
            long contar = lista.stream()
                    .filter(e -> e.getListPrice() - e.getStandardCost() > 50)
                    .count();
            
            System.out.println("Cantidad de productoso con un beneficio superior a 50€ =" + contar);
            
            System.out.println("-----------------------------");
            System.out.println("Preguntamos si todos los productos de Almacenamiento (id categoria 5) tienen un coste mayor a 650E:");
            System.out.println("");
            
            boolean todoStorage = lista.stream()
                    .filter(e -> e.getCategoryId() == 5)
                    .allMatch(e -> e.getStandardCost() > 650);
            
            System.out.println("Todos los productos de Almacenamiento cuestan mas de 650E? "+todoStorage);
            
        }catch(ProductDataAccessException e){
            System.out.println(e);
        }
        
        
    }
}
