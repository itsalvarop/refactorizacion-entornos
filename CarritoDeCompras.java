import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Álvaro Pastor Periago
 */

/**
 * Representa un carrito de compras donde se pueden agregar, eliminar ítems,
 * calcular el total y visualizar el contenido.
 */
public class CarritoDeCompras {

    /** Símbolo de moneda usado para mostrar los precios. */
    private static final String SIMBOLO_MONEDA = "$";

    /** Texto de encabezado usado en la impresión del carrito. */
    private static final String ENCABEZADO = "Detalles del carrito de compras:";

    /** Cantidad máxima permitida por producto. */
    private static final int CANTIDAD_MAXIMA = 1000;

    /** Mapa de ítems y sus cantidades en el carrito. */
    private final Map<Item, Integer> items;

    /**
     * Crea un carrito vacío.
     */
    public CarritoDeCompras() {
        items = new HashMap<>();
    }

    /**
     * Agrega un ítem al carrito con una cantidad especificada.
     *
     * @param item     Ítem a agregar.
     * @param cantidad Número de unidades (debe ser mayor que 0 y menor que el
     *                 máximo permitido).
     */
    public void agregarItem(Item item, int cantidad) {
        if (item == null || cantidad <= 0 || cantidad > CANTIDAD_MAXIMA) {
            System.out.println("Error: ítem nulo o cantidad inválida.");
            return;
        }

        int cantidadActual = items.getOrDefault(item, 0);
        items.put(item, cantidadActual + cantidad);
    }

    /**
     * Elimina un ítem del carrito si existe.
     *
     * @param item Ítem a eliminar.
     * @return true si el ítem fue eliminado, false si no estaba en el carrito.
     */
    public boolean removerItem(Item item) {
        if (!items.containsKey(item)) {
            return false;
        }
        items.remove(item);
        return true;
    }

    /**
     * Calcula el total del carrito (precio * cantidad por cada ítem).
     *
     * @return Precio total del carrito.
     */
    public double calcularTotal() {
        double total = 0.0;

        for (Map.Entry<Item, Integer> entrada : items.entrySet()) {
            Item item = entrada.getKey();
            int cantidad = entrada.getValue();
            total += item.getPrecio() * cantidad;
        }

        return total;
    }

    /**
     * Devuelve una lista con los ítems únicos del carrito (sin cantidades).
     *
     * @return Lista de ítems.
     */
    public List<Item> obtenerItems() {
        return new ArrayList<>(items.keySet());
    }

    /**
     * Devuelve una copia del mapa de ítems y sus cantidades.
     *
     * @return Mapa con ítems y cantidades.
     */
    public Map<Item, Integer> obtenerItemsConCantidad() {
        return new HashMap<>(items);
    }

    /**
     * Devuelve un resumen en texto del contenido del carrito.
     *
     * @return Detalles de los ítems y el total del carrito.
     */
    @Override
    public String toString() {
        String texto = ENCABEZADO + "\n";

        for (Map.Entry<Item, Integer> entrada : items.entrySet()) {
            Item item = entrada.getKey();
            int cantidad = entrada.getValue();
            double subtotal = item.getPrecio() * cantidad;

            texto += item.getNombre() + " x " + cantidad + " = " + SIMBOLO_MONEDA +
                    String.format("%.2f", subtotal) + "\n";
        }

        texto += "Total: " + SIMBOLO_MONEDA + String.format("%.2f", calcularTotal());
        return texto;
    }
}
