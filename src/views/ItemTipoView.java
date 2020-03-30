package views;

import controllers.implementations.TipoItemDAOImpl;

import java.util.Scanner;

public class ItemTipoView {
  private IO io = null;
  private Scanner teclado = null;
  private TipoItemDAOImpl tipoItemDAO = null;

  public ItemTipoView() {
    io = IO.getInstance();
    teclado = io.getTeclado();
    tipoItemDAO = new TipoItemDAOImpl();
  }

  public void menu() {
    io.splitter(1);
    System.out.println("-- Selecciona una opción --");
    System.out.println("1. Listar tipos de item");
    System.out.println("2. Añadir tipo de item");
    System.out.println("3. Actualizar tipo de item");
    System.out.println("4. Borrar tipo de item");
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
