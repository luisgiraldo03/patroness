package views;

import controllers.implementations.ClientDAOImpl;
import controllers.implementations.FacturaDAOImpl;
import controllers.implementations.ItemDAOImpl;
import models.Cliente;
import models.Factura;
import models.Item;

import java.util.Scanner;

public class FacturaView {
  private IO io = null;
  private Scanner teclado = null;
  private FacturaDAOImpl facturaDAO = null;
  private ClientDAOImpl clientDAO = null;
  private ItemDAOImpl itemDAO = null;

  public FacturaView() {
    io = IO.getInstance();
    teclado = io.getTeclado();
    facturaDAO = new FacturaDAOImpl();
    clientDAO = new ClientDAOImpl();
    itemDAO = new ItemDAOImpl();
  }

  public void menu() {
    io.splitter(1);
    System.out.println("-- Selecciona una opción --");
    System.out.println("1. Listar Facturas");
    System.out.println("2. Crear factura");
    System.out.println("3. Actualizar factura");
    System.out.println("4. Borrar factura");
    System.out.println("5. Volver");
    System.out.print("Opción > ");
    try {
      switch (teclado.nextInt()) {
        case 1:
          listar();
          break;
        case 2:
          crear();
          break;
        case 3:
          actualizar();
          break;
        case 4:
          borrar();
          break;
        case 5:
          break;
        default:
          System.out.println("> La opción elegida es incorrecta <");
      }
    } catch (Exception e) {
      System.err.println("La entrada es incorrecta");
      io.resetTeclado();
    }
  }

  private Factura crearFactura() {
    Factura factura = new Factura();
    System.out.println("-- Selecciona el cliente de la factura --");
    Cliente[] clientes = clientDAO.getAllClients();
    for (int i = 0; i < clientes.length; i++) {
      System.out.println((i + 1) + ". " + clientes[i].getNombre() + " " + clientes[i].getApellidos());
    }
    factura.setCliente(clientes[(teclado.nextInt()) - 1]);
    System.out.println("-- Lista de items --");
    boolean isFinish = false;

    Item[] items = itemDAO.getAllItems();

    while (!isFinish) {
      System.out.println("--- Items actuales ---");
      Item[] itemsFactura = factura.getAllItems();

      for (int i = 0; i < itemsFactura.length; i++) {
        System.out.println((i + 1) + ". " + itemsFactura[i].getDescripcion());
      }
      System.out.println("Total: " + factura.getTotalFactura());
      io.splitter(2);

      System.out.println("1. Añadir item");
      System.out.println("2. Quitar item");
      System.out.println("3. Terminar");
      System.out.print("Opcion > ");
      switch (teclado.nextInt()) {
        case 1:
          System.out.println("Items disponibles: ");
          for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i].getDescripcion() + " | valor: " + items[i].getValorUnitario());
          }
          System.out.println("Ingresa el item a añadir");
          factura.addItem(items[(teclado.nextInt()) - 1]);
          break;
        case 2:
          System.out.println("Ingresa el indice del item a eliminar");
          factura.removeItem(itemsFactura[(teclado.nextInt()) - 1]);
          break;
        case 3:
          isFinish = true;
          break;
      }
    }

    return factura;
  }

  public void crear() {
    io.splitter(1);
    Factura factura = crearFactura();
    facturaDAO.addFactura(factura);
    System.out.println("Factura creada creada correctamente en la fecha: "+ factura.getFechaFactura().toString());
    io.splitter(2);
  }

  public void listar() {
    io.splitter(1);
    Factura[] facturas = facturaDAO.getAllFacturas();
    System.out.println("-- Facturas guardadas --");
    System.out.println("Total de facturas: " + facturas.length);
    for (Factura factura :
            facturas) {
      System.out.println(factura.getNumeroFactura() + " | Factura de cliente: " + factura.getCliente().getNombre() +
              " | Total: " + factura.getTotalFactura() + " | Estado: " + factura.getEstado().getEstadoType());
    }
    io.splitter(2);
    io.waitKey();
  }

  public void actualizar() {
    io.splitter(1);
    System.out.println("-- Ingresa el id de la factura a actualizar");
    Factura facturaVieja = facturaDAO.findFactura(teclado.nextInt());
    System.out.println("Actualizando factura");
    System.out.println(facturaVieja.getNumeroFactura() + " Factura de cliente: " + facturaVieja.getCliente().getNombre() +
            "Total: " + facturaVieja.getTotalFactura() + " Estado: " + facturaVieja.getEstado().getEstadoType());
    Factura factura = crearFactura();
    factura.setNumeroFactura(facturaVieja.NumeroFactura);
    facturaDAO.updateFactura(facturaVieja, factura);
    io.splitter(2);
  }

  public void borrar() {
    io.splitter(1);
    System.out.println("-- Ingresa el id de la factura a eliminar");
    Factura factura = facturaDAO.findFactura(teclado.nextInt());
    facturaDAO.deleteFactura(factura);
    io.splitter(2);
  }
}
