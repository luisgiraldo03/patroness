package views;

import controllers.IClienteDAO;
import controllers.implementations.ClientDAOImpl;
import controllers.implementations.FacturaDAOImpl;
import controllers.implementations.ItemDAOImpl;
import controllers.implementations.TipoItemDAOImpl;
import models.Cliente;

import java.util.Scanner;

public class Menu {
  private ClientDAOImpl clientDAO = null;
  private FacturaDAOImpl facturaDAO = null;
  private ItemDAOImpl itemDAO = null;
  private TipoItemDAOImpl tipoItemDAO = null;
  private Scanner teclado = null;

  public void splitter(int type) {
    switch (type) {
      case 1:
        System.out.println("<------------------------------------------>");
        break;
      case 2:
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        break;
    }
  }

  public Menu() {
    teclado = new Scanner(System.in);
    boolean execution = true;

    clientDAO = new ClientDAOImpl();
    facturaDAO = new FacturaDAOImpl();
    itemDAO = new ItemDAOImpl();
    tipoItemDAO = new TipoItemDAOImpl();

    while (execution) {
      splitter(1);
      System.out.println("Elige una opción para continuar");
      System.out.println("1. Crear nueva factura");
      System.out.println("2. Crear tipo de items");
      System.out.println("3. Crear Cliente");
      System.out.println("4. Crear item");
      System.out.println("5. Salir");

      System.out.print("Opción > ");

      try {
        switch (teclado.nextInt()) {
          case 1:
            factura();
            break;
          case 2:
            tipoItem();
            break;
          case 3:
            cliente();
            break;
          case 4:
            item();
            break;
          case 5:
            System.out.println("Hasta luego. Ponganos 5 :)");
            execution = false;
        }
      } catch (Exception e) {
        System.err.println("La entrada es incorrecta");
        teclado = new Scanner(System.in);
      }
    }
  }

  public void tipoItem() {
    splitter(1);
    System.out.println("Ingresa un -1 para cancelar");
    System.out.println("Ingresa el nombre del tipo de item: ");
    System.out.print("Nombre > ");
    teclado.next();
    splitter(2);
    System.out.println("Ingresa una descripción para el tipo");
    System.out.print("Descripción > ");
    teclado.next();
  }

  public void cliente() {
    Cliente cliente = new Cliente();

    try {
      splitter(1);
      System.out.println("Ingresa el nombre del cliente: ");
      System.out.print("Cliente > ");
      cliente.setNombre(teclado.next());
      splitter(2);
      System.out.println("Selecciona el genero: ");
      System.out.println("1. Masculino");
      System.out.println("2. Femenino");
      System.out.print("Opción > ");
      teclado.nextInt();
      splitter(2);
      System.out.println("Fecha de nacimiento");
      System.out.print("Dia: ");
      teclado.nextInt();
      System.out.print("\nMes: ");
      teclado.nextInt();
      System.out.println("\nAño: ");
      teclado.nextInt();
      splitter(2);
      System.out.println("Selecciona el estado civil:");
      System.out.println("1. Soltero");
      System.out.println("2. Casado");
      System.out.println("3. Unión libre");
      System.out.print("Opción > ");
      teclado.nextInt();
    } catch (Exception e) {
      System.err.println("La entrada es incorrecta");
      teclado = new Scanner(System.in);
    }
  }

  public void item() {
    System.out.println("--- Selecciona un tipo item ---");
    //imprimir los tipos de items
    splitter(2);
    System.out.println("Ingresa el nombre del item: ");
    System.out.print("Nombre > ");
    teclado.next();
    splitter(2);
    System.out.println("Ingresa la descripción del item: ");
    System.out.print("Descripción > ");
    teclado.next();
    splitter(2);
    System.out.println("Ingresa el valor unitario");
    System.out.print("Valor > ");
    teclado.nextFloat();
  }

  public void factura() {
    splitter(1);
    System.out.println("-- Selecciona el cliente --");
    //Imprimir clientes y poner la selección

    splitter(2);
    System.out.println("Agrega los items");
    //Imprimir lista de items
    System.out.println("Ingresa el numero del items separados por , O ingresa -1 para terminar");
  }
}
