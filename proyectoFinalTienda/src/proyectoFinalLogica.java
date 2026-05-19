import java.util.Scanner;

public class proyectoFinalLogica {

    // ═══════════════════════════════════════
    //           PARTE 1: CLASE PRODUCTO
    // ═══════════════════════════════════════
    static class Producto {
        String nombre;
        double precio;
        int cantidad;

        public Producto(String nombre, double precio, int cantidad) {
            this.nombre   = nombre;
            this.precio   = precio;
            this.cantidad = cantidad;
        }
    }

    // ═══════════════════════════════════════
    //      PARTE 2: VARIABLES GLOBALES
    // ═══════════════════════════════════════
    static Producto[][][] tienda             = new Producto[3][2][10];
    static int[][]        contadorProductos  = new int[3][2];
    static Scanner        sc                 = new Scanner(System.in);

    static String[] nombreZonas = {"Alimentos", "Limpieza", "Bebidas"};

    static String[][] nombreRepisas = {
        {"Verduras",    "Frutas"        },
        {"Detergentes", "Desinfectantes"},
        {"Jugos",       "Gaseosas"      }
    };

    // ═══════════════════════════════════════
    //      PARTE 3: CATÁLOGO PREDEFINIDO
    // ═══════════════════════════════════════
    static String[][][] catalogo = {
        {   // Zona 0: Alimentos
            {"Tomate", "Cebolla", "Aguacate", "Papa",     "Zanahoria"},
            {"Mango",  "Banano",  "Manzana",  "Pera",     "Naranja"  }
        },
        {   // Zona 1: Limpieza
            {"Ariel 1kg", "Fab 500g",    "Tide 800g", "Bold 1kg"},
            {"Fabuloso",  "Mr. Músculo", "Ajax",      "Pinesol" }
        },
        {   // Zona 2: Bebidas
            {"Jugo Hit",  "Jugo Del Valle", "Jugo Natura"                   },
            {"Coca-Cola", "Pepsi",          "Sprite",     "Manzana Postobon"}
        }
    };

    // ═══════════════════════════════════════
    //        PARTE 4: MENÚ PRINCIPAL
    // ═══════════════════════════════════════
    static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("   SISTEMA DE ORGANIZACIÓN DE TIENDA   ");
        System.out.println("========================================");
        System.out.println("1. Agregar productos a una repisa");
        System.out.println("2. Ver repisa organizada");
        System.out.println("3. Ver toda la tienda");
        System.out.println("0. Salir");
        System.out.println("========================================");
        System.out.print("Elige una opción: ");
    }

    // ═══════════════════════════════════════
    //     PARTE 5: SELECCIONAR ZONA Y REPISA
    // ═══════════════════════════════════════
    static int[] seleccionarZonaRepisa() {
        System.out.println("\n¿En qué zona?");
        for (int i = 0; i < nombreZonas.length; i++) {
            System.out.println("  " + (i + 1) + ". " + nombreZonas[i]);
        }
        System.out.print("Elige una zona: ");
        int zona = Integer.parseInt(sc.nextLine()) - 1;

        System.out.println("\n¿En qué repisa?");
        for (int i = 0; i < nombreRepisas[zona].length; i++) {
            System.out.println("  " + (i + 1) + ". " + nombreRepisas[zona][i]);
        }
        System.out.print("Elige una repisa: ");
        int repisa = Integer.parseInt(sc.nextLine()) - 1;

        return new int[]{zona, repisa};
    }

    // ═══════════════════════════════════════
    //       PARTE 6: AGREGAR PRODUCTO
    // ═══════════════════════════════════════
    static void agregarProducto() {
        try {
            int[] seleccion = seleccionarZonaRepisa();
            int zona   = seleccion[0];
            int repisa = seleccion[1];

            System.out.println("\nProductos disponibles en " + nombreRepisas[zona][repisa] + ":");
            String[] productosCatalogo = catalogo[zona][repisa];
            for (int i = 0; i < productosCatalogo.length; i++) {
                System.out.println("  " + (i + 1) + ". " + productosCatalogo[i]);
            }

            System.out.print("Elige un producto: ");
            int    opcionProducto = Integer.parseInt(sc.nextLine()) - 1;
            String nombreProducto = productosCatalogo[opcionProducto];

            System.out.print("Ingresa el precio de " + nombreProducto + ": $");
            double precio = Double.parseDouble(sc.nextLine());
            if (precio <= 0) {
                System.out.println("Error: el precio debe ser mayor a 0.");
                return;
            }

            System.out.print("Ingresa la cantidad: ");
            int cantidad = Integer.parseInt(sc.nextLine());
            if (cantidad < 0) {
                System.out.println("Error: la cantidad no puede ser negativa.");
                return;
            }

            int pos = contadorProductos[zona][repisa];
            tienda[zona][repisa][pos] = new Producto(nombreProducto, precio, cantidad);
            contadorProductos[zona][repisa]++;

            System.out.println("✅ " + nombreProducto + " agregado correctamente a " + nombreRepisas[zona][repisa]);

        } catch (NumberFormatException e) {
            System.out.println("Error: ingrese solo números válidos.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: opción fuera de rango.");
        }
    }
}