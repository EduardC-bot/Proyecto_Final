
    // ═══════════════════════════════════════
    //       PARTE 9: VER TODA LA TIENDA
    // ═══════════════════════════════════════
    static void verTienda() {
        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║       ESTADO COMPLETO DE LA TIENDA   ║");
        System.out.println("╚══════════════════════════════════════╝");

        for (int zona = 0; zona < nombreZonas.length; zona++) {
            System.out.println("\n🏬 ZONA: " + nombreZonas[zona]);

            for (int repisa = 0; repisa < nombreRepisas[zona].length; repisa++) {
                int total = contadorProductos[zona][repisa];
                System.out.println("\n  📦 Repisa: " + nombreRepisas[zona][repisa]);

                if (total == 0) {
                    System.out.println("     (Sin productos)");
                } else {
                    ordenarRepisa(tienda[zona][repisa], total);
                    System.out.printf("  %-5s %-20s %-15s %-10s%n", "Pos.", "Producto", "Precio", "Cantidad");
                    System.out.println("  ----------------------------------------");
                    for (int p = 0; p < total; p++) {
                        Producto prod = tienda[zona][repisa][p];
                        System.out.printf("  %-5d %-20s $%-14.0f %-10d%n",
                            (p + 1), prod.nombre, prod.precio, prod.cantidad);
                    }
                }
            }
        }
        System.out.println("\n========================================");
    }

}


