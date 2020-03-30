package views;

import controllers.implementations.ItemDAOImpl;

import java.util.Scanner;

public class ItemView {
  private IO io = null;
  private Scanner teclado = null;
  private ItemDAOImpl itemDAO = null;

  public ItemView() {
    io = IO.getInstance();
    teclado = io.getTeclado();
    itemDAO = new ItemDAOImpl();
  }

  public void menu() {
    io.splitter(1);
    System.out.println("-- Selecciona una opción --");
    System.out.println("1. Listar items");
    System.out.println("2. Añadir item");
    System.out.println("3. Actualizar item");
    System.out.println("4. Borrar item");
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
