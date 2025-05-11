import java.util.ArrayList;
import java.util.List;

/**
 * @author Álvaro Pastor Periago
 */

public class Tienda {
    private List<Item> catalogo;

    public Tienda() {
        catalogo = new ArrayList<>();
        // Añadimos algunos productos al catálogo
        catalogo.add(new Item("Camiseta", 20.0));
        catalogo.add(new Item("Pantalón", 35.0));
        catalogo.add(new Item("Zapatillas", 50.0));
    }

    public void mostrarCatalogo() {
        System.out.println("Catálogo de la tienda:");
        for (int i = 0; i < catalogo.size(); i++) {
            Item item = catalogo.get(i);
            System.out.println((i + 1) + ". " + item.getNombre() + " - $" + item.getPrecio());
        }
    }

    public Item obtenerItemPorIndice(int indice) {
        if (indice < 0 || indice >= catalogo.size()) {
            return null;
        }
        return catalogo.get(indice);
    }

    public List<Item> getCatalogo() {
        return catalogo;
    }
}
