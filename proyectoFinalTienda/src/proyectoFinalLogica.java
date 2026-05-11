import java.util.Scanner;
public class proyectoFinalLogica {

    //CLASE PRODUCTO para almacenar la información de cada producto (nombre, precio y cantidad)
    static class Producto {
        String nombre;
        double precio;
        int cantidad;

        public Producto(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }
    }

    //  MATRIZ Y VARIABLES GLOBALES (van afuera del main para que sean accesibles en todos los métodos)
    static Producto[][][] tienda = new Producto[3][2][10];

    static String[] nombreZonas = {"Alimentos", "Limpieza", "Bebidas"};

    static String[][] nombreRepisas = {
        {"Verduras", "Frutas"},
        {"Detergentes", "Desinfectantes"},
        {"Jugos", "Gaseosas"}
    };

    static int[][] contadorProductos = new int[3][2];

    static Scanner sc = new Scanner(System.in);


// ───── CATÁLOGO DE PRODUCTOS POR REPISA ─────
static String[][][] catalogo = {
    {   // Zona 0: Alimentos
        {"Tomate", "Cebolla", "Aguacate", "Papa", "Zanahoria"},
        {"Mango", "Banano", "Manzana", "Pera", "Naranja"}
    },
    {   // Zona 1: Limpieza
        {"Ariel 1kg", "Fab 500g", "Tide 800g", "Bold 1kg"},
        {"Fabuloso", "Mr. Músculo", "Ajax", "Pinesol"}
    },
    {   // Zona 2: Bebidas
        {"Jugo Hit", "Jugo Del Valle", "Jugo Natura"},
        {"Coca-Cola", "Pepsi", "Sprite", "Manzana Postobon"}
    }
};


// ───── MENÚ PRINCIPAL ─────
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


    // MAIN
    public static void main(String[] args) throws Exception {
    System.out.println("Bienvenido al sistema de organización de tienda.");

    int opcion = -1;

    while (opcion != 0) {
        mostrarMenu();

        try {
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("→ Agregar productos (próximamente)");
                    break;
                case 2:
                    System.out.println("→ Ver repisa (próximamente)");
                    break;
                case 3:
                    System.out.println("→ Ver tienda (próximamente)");
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: ingrese solo números.");
        }
    }
}

}