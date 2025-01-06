
/**
 *
 * @author franc
 */
import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] inventario = new String[100][4];
        int productosRegistrados = 0;

        while (true) {
            System.out.println("\n--- Menú de Gestion de Inventario y Facturacion ---");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Actualizar existencias");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Facturar producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.next();

            switch (opcion) {
                case 1:
                    if (productosRegistrados >= 100) {
                        System.out.println("El inventario esta lleno. No se pueden agregar mas productos.");
                    } else {
                        System.out.print("Ingrese el codigo del producto: ");
                        String codigo = scanner.next();
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = scanner.next();
                        System.out.print("Ingrese el precio del producto: ");
                        String precio = scanner.next();
                        System.out.print("Ingrese la cantidad del producto: ");
                        String cantidad = scanner.next();

                        inventario[productosRegistrados][0] = codigo;
                        inventario[productosRegistrados][1] = nombre;
                        inventario[productosRegistrados][2] = precio;
                        inventario[productosRegistrados][3] = cantidad;
                        productosRegistrados++;
                        System.out.println("Producto agregado con éxito.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el codigo del producto a actualizar: ");
                    String codigoActualizar = scanner.next();
                    boolean encontrado = false;
                    for (int i = 0; i < productosRegistrados; i++) {
                        if (inventario[i][0].equalsIgnoreCase(codigoActualizar)) {
                            System.out.print("Ingrese la nueva cantidad: ");
                            String nuevaCantidad = scanner.next();
                            inventario[i][3] = nuevaCantidad;
                            System.out.println("Cantidad actualizada con éxito.");
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Inventario de Productos ---");
                    if (productosRegistrados == 0) {
                        System.out.println("No hay productos en el inventario.");
                    } else {
                        for (int i = 0; i < productosRegistrados; i++) {
                            System.out.println("Código: " + inventario[i][0] + 
                                               ", Nombre: " + inventario[i][1] + 
                                               ", Precio: $" + inventario[i][2] + 
                                               ", Cantidad: " + inventario[i][3]);
                        }
                    }
                    break;

                case 4:

                    System.out.print("Ingrese el código del producto a facturar: ");
                    String codigoFacturar = scanner.nextLine();
                    encontrado = false;
                    for (int i = 0; i < productosRegistrados; i++) {
                        if (inventario[i][0].equalsIgnoreCase(codigoFacturar)) {
                            encontrado = true;

                            int stock = Integer.parseInt(inventario[i][3]);
                            System.out.print("Ingrese la cantidad a facturar: ");
                            int cantidadFacturar = scanner.nextInt();
                            scanner.nextLine(); 
                            if (cantidadFacturar > stock) {
                                System.out.println("No hay suficientes existencias para facturar este producto.");
                            } else {
                                double precioUnitario = Double.parseDouble(inventario[i][2]);
                                double subtotal = precioUnitario * cantidadFacturar;
                                double iva = subtotal * 0.15;
                                double total = subtotal + iva;
                                if (total > 100) {
                                    total *= 0.9;
                                    System.out.println("Se aplicó un descuento del 10% por superar los $100.");
                                }
                                inventario[i][3] = String.valueOf(stock - cantidadFacturar);
                                System.out.println("\n--- Factura ---");
                                System.out.println("Producto: " + inventario[i][1]);
                                System.out.println("Cantidad: " + cantidadFacturar);
                                System.out.printf("Subtotal: $%.2f\n", subtotal);
                                System.out.printf("IVA (15%%): $%.2f\n", iva);
                                System.out.printf("Total: $%.2f\n", total);
                            }
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }
}

