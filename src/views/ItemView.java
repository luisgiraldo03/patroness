package views;

import controllers.implementations.ItemDAOImpl;
import controllers.implementations.TipoItemDAOImpl;
import models.Factura;
import models.Item;
import models.TipoItem;

import java.util.Scanner;

public class ItemView {
  private IO io = null;
  private Scanner teclado = null;
  private ItemDAOImpl itemDAO = null;
  private TipoItemDAOImpl tipoItemDAO = null;

  public ItemView() {
    io = IO.getInstance();
    teclado = io.getTeclado();
    itemDAO = new ItemDAOImpl();
    tipoItemDAO = new TipoItemDAOImpl();
  }

  public void menu() {
    io.splitter(1);
    System.out.println("-- Selecciona una opción --");
    System.out.println("1. Listar items");
    System.out.println("2. Añadir item");
    System.out.println("3. Actualizar item");
    System.out.println("4. Borrar item");
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

  private Item crearItem() {
    Item item = new Item();
    TipoItem[] tipoItems = tipoItemDAO.getAllTipoItem();
    System.out.println("-- Selecciona un tipo de item disponible --");
    for (var i = 0; i < tipoItems.length; i++) {
      System.out.println((i + 1) + ". " + tipoItems[i].getDescripcion());
    }
    item.setTipoItem(tipoItems[(teclado.nextInt()) - 1]);
    System.out.println("Ingresa la descripción del item: ");
    item.setDescripcion(teclado.next());
    System.out.println("Ingresa el valor unitario del item");
    item.setValorUnitario(teclado.nextFloat());
    return item;
  }

  public void crear() {
    io.splitter(1);
    Item item = crearItem();
    itemDAO.addItem(item);
    io.splitter(2);
  }

  public void listar() {
    io.splitter(1);
    Item[] items = itemDAO.getAllItems();
    System.out.println("-- Items guardados --");
    System.out.println("Total de items: " + items.length);
    for (Item item :
            items) {
      System.out.println(item.getId() + " | Descripción: " + item.getDescripcion() + " | Tipo: "
              + item.getTipoItem().getDescripcion() + " | Valor: " + item.getValorUnitario());
    }
    io.splitter(2);
    io.waitKey();
  }

  public void actualizar() {
    io.splitter(1);
    System.out.println("-- Ingresa el id del item a actualizar --");
    Item itemViejo = itemDAO.findItem(teclado.nextInt());
    Item item = crearItem();
    item.setId(itemViejo.Id);
    itemDAO.updateItem(itemViejo, item);
    io.splitter(2);
  }

  public void borrar() {
    io.splitter(1);
    System.out.println("-- Ingresa el id del item a borrar --");
    Item item = itemDAO.findItem(teclado.nextInt());
    itemDAO.deleteItem(item);
    io.splitter(2);
  }
}
