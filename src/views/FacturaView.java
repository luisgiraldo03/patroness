package views;

import controllers.implementations.FacturaDAOImpl;

import java.util.Scanner;

public class FacturaView {
  private IO io = null;
  private Scanner teclado = null;
  private FacturaDAOImpl facturaDAO = null;

  public FacturaView() {
    io = IO.getInstance();
    teclado = io.getTeclado();
    facturaDAO = new FacturaDAOImpl();
  }

  public void menu() {
    io.splitter(1);
    System.out.println("-- Selecciona una opción --");
    System.out.println("1. Listar Facturas");
    System.out.println("2. Crear factura");
    System.out.println("3. Actualizar factura");
    System.out.println("4. Borrar factura");
    try {
      switch (teclado.nextInt()) {
        case 1:
          break;
        case 2:
          break;
        case 3:
          break;
        case 4:
          break;
        default:
          System.out.println("> La opción elegida es incorrecta <");
      }
    } catch (Exception e) {
      System.err.println("La entrada es incorrecta");
      io.resetTeclado();
    }
  }
}
