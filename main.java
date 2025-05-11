import java.util.Scanner;

/**
 * @author Álvaro Pastor Periago
 */

public class main {
    public static void main(String[] args) {
        CarritoDeCompras carrito = new CarritoDeCompras();

        Item camiseta = new Item("Camiseta", 20.0);
        Item pantalon = new Item("Pantalón", 35.0);

        carrito.agregarItem(camiseta, 2);
        carrito.agregarItem(pantalon, 1);

        System.out.println(carrito.toString());

        Tienda tienda = new Tienda();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                tienda.mostrarCatalogo();
                System.out.println("Selecciona un número de producto (0 para salir): ");
                int opcion = scanner.nextInt();

                if (opcion == 0)
                    break;

                Item itemSeleccionado = tienda.obtenerItemPorIndice(opcion - 1);
                if (itemSeleccionado != null) {
                    System.out.println("¿Cuántas unidades quieres añadir?");
                    int cantidad = scanner.nextInt();
                    carrito.agregarItem(itemSeleccionado, cantidad);
                    System.out.println("Producto añadido.\n");
                } else {
                    System.out.println("Opción no válida.\n");
                }
            }

            System.out.println("\n" + carrito.toString());
        }
    }
}
