/**
 * Representa un producto disponible para agregar al carrito de compras.
 * Cada item tiene un nombre, un precio y restricciones de validación.
 */

/**
 * @author Álvaro Pastor Periago
 */
public class Item {
    /** Precio máximo permitido para un producto. */
    private static final double PRECIO_MAXIMO = 10000.0;

    /** Precio mínimo permitido para un producto. */
    private static final double PRECIO_MINIMO = 0.0;

    private String nombre;
    private double precio;

    /**
     * Crea un nuevo ítem con nombre y precio, validando el precio.
     *
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @throws IllegalArgumentException si el precio es menor que 0 o mayor que el
     *                                  máximo permitido.
     */
    public Item(String nombre, double precio) {
        if (precio < PRECIO_MINIMO || precio > PRECIO_MAXIMO) {
            throw new IllegalArgumentException("Precio no válido: " + precio);
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Devuelve el nombre del producto.
     * 
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el precio del producto.
     * 
     * @return Precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Representación en texto del ítem (nombre y precio).
     * 
     * @return Cadena con nombre y precio formateado.
     */
    @Override
    public String toString() {
        return nombre + " - $" + String.format("%.2f", precio);
    }

    /**
     * Compara si dos ítems son iguales por su nombre.
     * 
     * @param obj Objeto a comparar.
     * @return true si tienen el mismo nombre.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Item))
            return false;
        Item otro = (Item) obj;
        return nombre.equals(otro.nombre);
    }

    /**
     * Devuelve el código hash basado en el nombre.
     * 
     * @return hash del nombre.
     */
    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
