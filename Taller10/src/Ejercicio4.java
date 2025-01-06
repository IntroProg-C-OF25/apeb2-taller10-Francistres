
/**
 *
 * @author franc
 */
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] inventario = new String[100][3];
        int productosRegistrados = 0;

        while (true) {
            System.out.println("\n--- Menu de Gestion de Inventario ---");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Actualizar existencias");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    if (productosRegistrados >= 100) {
                        System.out.println("El inventario esta lleno. No se pueden agregar mas productos.");
                    } else {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.next();
                        System.out.print("Ingrese el precio del producto: ");
                        String precio = scanner.next();
                        System.out.print("Ingrese la cantidad del producto: ");
                        String cantidad = scanner.next();

                        inventario[productosRegistrados][0] = nombre;
                        inventario[productosRegistrados][1] = precio;
                        inventario[productosRegistrados][2] = cantidad;
                        productosRegistrados++;
                        System.out.println("Producto agregado con éxito.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    String nombreActualizar = scanner.next();
                    boolean encontrado = false;
                    for (int i = 0; i < productosRegistrados; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreActualizar)) {
                            System.out.print("Ingrese la nueva cantidad: ");
                            String nuevaCantidad = scanner.next();
                            inventario[i][2] = nuevaCantidad;
                            System.out.println("Cantidad actualizada con exito.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    encontrado = false;
                    for (int i = 0; i < productosRegistrados; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreBuscar)) {
                            System.out.println("Producto encontrado:");
                            System.out.println("Nombre: " + inventario[i][0]);
                            System.out.println("Precio: " + inventario[i][1]);
                            System.out.println("Cantidad: " + inventario[i][2]);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.next();
                    encontrado = false;
                    for (int i = 0; i < productosRegistrados; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreEliminar)) {
                            for (int j = i; j < productosRegistrados - 1; j++) {
                                inventario[j][0] = inventario[j + 1][0];
                                inventario[j][1] = inventario[j + 1][1];
                                inventario[j][2] = inventario[j + 1][2];
                            }
                            productosRegistrados--;
                            System.out.println("Producto eliminado con exito.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("\n--- Inventario de Productos ---");
                    if (productosRegistrados == 0) {
                        System.out.println("No hay productos en el inventario.");
                    } else {
                        for (int i = 0; i < productosRegistrados; i++) {
                            System.out.println((i + 1) + ". Nombre: " + inventario[i][0]
                                    + ", Precio: " + inventario[i][1]
                                    + ", Cantidad: " + inventario[i][2]);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no valida. Intente de nuevo.");
            }
        }
    }
}
/***
 * run:

--- Menu de Gestion de Inventario ---
1. Agregar nuevo producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Seleccione una opci�n: 1
Ingrese el nombre del producto: borrador
Ingrese el precio del producto: 3.55
Ingrese la cantidad del producto: 2
Producto agregado con �xito.

--- Menu de Gestion de Inventario ---
1. Agregar nuevo producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Seleccione una opci�n: 5

--- Inventario de Productos ---
1. Nombre: borrador, Precio: 3.55, Cantidad: 2

--- Menu de Gestion de Inventario ---
1. Agregar nuevo producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Seleccione una opci�n: 6
Saliendo del programa
BUILD SUCCESSFUL (total time: 39 seconds)
 */