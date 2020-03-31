package views;

import java.util.Scanner;

public class Menu {
  private Scanner teclado = null;
  private IO tecladoInstance = null;

  private void usage() {
    System.err.println("La entrada es incorrecta");
    teclado = tecladoInstance.resetTeclado();
  }

  public Menu() {
    tecladoInstance = IO.getInstance();
    teclado = tecladoInstance.getTeclado();
    boolean execution = true;

    while (execution) {
      FacturaView factura = new FacturaView();
      ClienteView cliente = new ClienteView();
      ItemTipoView itemTipo = new ItemTipoView();
      ItemView item = new ItemView();

      tecladoInstance.splitter(1);
      System.out.println("Elige una opción para continuar");
      System.out.println("1. Administrar facturas");
      System.out.println("2. Administrar items");
      System.out.println("3. Administrar Clientes");
      System.out.println("4. Administrar tipos de items");
      System.out.println("5. Salir");

      System.out.print("Opción > ");

      try {
        switch (teclado.nextInt()) {
          case 1:
            factura.menu();
            break;
          case 2:
            item.menu();
            break;
          case 3:
            cliente.menu();
            break;
          case 4:
            itemTipo.menu();
            break;
          case 5:
            System.out.println("Hasta luego.");
            execution = false;
        }
      } catch (Exception e) {
        usage();
      }
    }
  }
}
