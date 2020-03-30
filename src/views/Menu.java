package views;

import controllers.implementations.ClientDAOImpl;
import controllers.implementations.FacturaDAOImpl;
import controllers.implementations.ItemDAOImpl;
import controllers.implementations.TipoItemDAOImpl;
import models.Cliente;
import models.TipoItem;

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
            System.out.println("Hasta luego. Ponganos 5 :)");
            execution = false;
        }
      } catch (Exception e) {
        usage();
      }
    }
  }

  /*public void tipoItem() {
    *//*tecladoInstance.splitter(1);
    System.out.println("Ingresa un -1 para cancelar");
    System.out.println("Ingresa el nombre del tipo de item: ");
    System.out.print("Nombre > ");
    teclado.next();
    tecladoInstance.splitter(2);
    System.out.println("Ingresa una descripción para el tipo");
    System.out.print("Descripción > ");
    teclado.next();*//*
  }

  public void cliente() {
    Cliente cliente = new Cliente();

    try {
      tecladoInstance.splitter(1);
      System.out.println("Ingresa el nombre del cliente: ");
      System.out.print("Cliente > ");
      cliente.setNombre(teclado.next());
      tecladoInstance.splitter(2);
      System.out.println("Selecciona el genero: ");
      System.out.println("1. Masculino");
      System.out.println("2. Femenino");
      System.out.print("Opción > ");
      teclado.nextInt();
      tecladoInstance.splitter(2);
      System.out.println("Fecha de nacimiento");
      System.out.print("Dia: ");
      teclado.nextInt();
      System.out.print("\nMes: ");
      teclado.nextInt();
      System.out.println("\nAño: ");
      teclado.nextInt();
      tecladoInstance.splitter(2);
      System.out.println("Selecciona el estado civil:");
      System.out.println("1. Soltero");
      System.out.println("2. Casado");
      System.out.println("3. Unión libre");
      System.out.print("Opción > ");
      teclado.nextInt();
    } catch (Exception e) {
      usage();
    }
  }

  public void item() {
    System.out.println("--- Selecciona un tipo item ---");
    //imprimir los tipos de items
    tecladoInstance.splitter(2);
    System.out.println("Ingresa el nombre del item: ");
    System.out.print("Nombre > ");
    teclado.next();
    tecladoInstance.splitter(2);
    System.out.println("Ingresa la descripción del item: ");
    System.out.print("Descripción > ");
    teclado.next();
    tecladoInstance.splitter(2);
    System.out.println("Ingresa el valor unitario");
    System.out.print("Valor > ");
    teclado.nextFloat();
  }

  public void factura() {
    tecladoInstance.splitter(1);
    System.out.println("-- Selecciona el cliente --");
    //Imprimir clientes y poner la selección

    tecladoInstance.splitter(2);
    System.out.println("Agrega los items");
    //Imprimir lista de items
    System.out.println("Ingresa el numero del items separados por , O ingresa -1 para terminar");
  }*/
}
