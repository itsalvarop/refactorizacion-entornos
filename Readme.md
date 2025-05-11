# Carrito de Compras en Java

Este proyecto implementa un sistema de carrito de compras orientado a objetos en Java. Permite la adición y eliminación de productos, así como la visualización de un resumen con cantidades y precio total a través de la consola.

---

## Estructura del Proyecto

El proyecto consta de **cuatro clases principales**:

### 1. `Item`
Representa un producto individual que puede ser añadido al carrito.

- **Atributos**:
    - `nombre`: Nombre del producto (String).
    - `precio`: Precio del producto (double, validado entre 0 y un máximo predefinido).

- **Características**:
    - Constructor con validación del precio.
    - Métodos `getNombre()` y `getPrecio()` para acceder a los atributos.
    - Sobrescritura de `toString()`, `equals()`, y `hashCode()` para facilitar la representación y el uso en colecciones.

---

### 2. `CarritoDeCompras`
Contiene la lógica del carrito de compras, incluyendo la gestión de los productos y el cálculo del precio total.

- **Funcionalidades**:
    - `agregarItem(Item item, int cantidad)`: Añade un ítem al carrito con una cantidad específica.
    - `removerItem(Item item)`: Elimina todas las instancias de un ítem del carrito.
    - `calcularTotal()`: Calcula el precio total de los ítems en el carrito.
    - `obtenerItems()`: Devuelve una lista de los ítems en el carrito.
    - `obtenerItemsConCantidad()`: Devuelve un mapa con los ítems y sus cantidades.
    - Sobrescritura de `toString()` para mostrar un resumen del carrito.

- **Validaciones**:
    - No se permiten cantidades negativas o superiores a un límite definido.
    - No se permite la adición de ítems nulos.

---

### 3. `Tienda`
Simula una tienda con un catálogo de productos.

- Permite al usuario seleccionar productos y cantidades mediante la consola.
- Muestra el catálogo de productos disponibles.

---

### 4. `main`
Clase principal que contiene el método `main` para la ejecución del programa. Gestiona la interacción entre la tienda, el usuario y el carrito de compras.

---

## Cómo Ejecutar

### 1. Compilación:

```bash
javac Item.java CarritoDeCompras.java Tienda.java main.java