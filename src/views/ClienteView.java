package views;

import controllers.implementations.ClientDAOImpl;

import java.util.Scanner;

public class ClienteView {
  private IO io = null;
  private Scanner teclado = null;
  private ClientDAOImpl clientDAO = null;

  public ClienteView() {
    io = IO.getInstance();
    teclado = io.getTeclado();
    clientDAO = new ClientDAOImpl();
  }

  public void menu() {
    io.splitter(1);
    System.out.println("-- Selecciona una opción --");
    System.out.println("1. Listar clientes");
    System.out.println("2. Añadir cliente");
    System.out.println("3. Actualizar cliente");
    System.out.println("4. Borrar cliente");
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
