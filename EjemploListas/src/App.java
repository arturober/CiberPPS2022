import java.util.ArrayList;
import java.util.List;

public class App {
    public static void ejemplo1() {
        // int[] numeros = {3, 4, 12 ,4, 6};
        
        // Lista de enteros
        List<Integer> numeros = new ArrayList<>();
        numeros.add(23);
        numeros.add(12);
        numeros.add(7);
        numeros.add(8);
        numeros.add(0, 99); // Añade en la posición 0
        System.out.println(numeros);

        // Recorrer lista con un for
        for(int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.get(i)); // Con array -> numeros[i] 
        }

        // Modificar una posición
        numeros.set(1, 100); // Con array -> numeros[1] = 100
        System.out.println(numeros);
    }

    public static void ejemplo2() {
        // Lista con valores iniciales
        // Usamos new ArrayList porque usar solamente List.of nos devuelve una lista no modificable
        List<Integer> numeros = new ArrayList<>(List.of(24, 5, 16, 67));
        System.out.println("Lista inicial: " + numeros);
        System.out.println("Tamaño: " + numeros.size());
        numeros.remove(0); // Borra el número en la posición 0
        System.out.println("Primer número borrado: " + numeros);

        // Recorrer la lista con un bucle foreach
        for(int num: numeros) {
            System.out.println(num);
        }

        // Foreach funcional
        // numeros.forEach(e -> System.out.println(e));
    }

    public static void ejemplo3() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto(24, "Silla"));
        productos.add(new Producto(45, "Mesa"));
        productos.add(new Producto(15, "Teclado"));
        productos.add(new Producto(9.99, "Ratón"));
        System.out.println(productos);

        // Precio total de todos los productos de la lista
        double total = 0;
        for(Producto p: productos) {
            total += p.getPrecio();
        }
        System.out.println("Precio total de los productos " + total + "€");

        // Versión funcional
        // double total = productos.stream().mapToDouble(Producto::getPrecio).sum();
        // System.out.println("Precio total de los productos " + total + "€");
    }

    public static void main(String[] args) throws Exception {
        // ejemplo1();
        // ejemplo2();
        ejemplo3();
    }
}
