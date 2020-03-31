package views;

import controllers.implementations.TipoItemDAOImpl;
import models.Factura;
import models.TipoItem;

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

  public TipoItem crearTipoItem() {
    TipoItem tipoItem = new TipoItem();
    System.out.println("-- Añade una descripción al tipo de item --");
    tipoItem.setDescripcion(teclado.next());
    return tipoItem;
  }

  public void crear() {
    io.splitter(1);
    TipoItem tipoItem = crearTipoItem();
    tipoItemDAO.addTipoItem(tipoItem);
    io.splitter(2);
  }

  public void listar() {
    io.splitter(1);
    TipoItem[] tiposItem = tipoItemDAO.getAllTipoItem();
    System.out.println("-- Tipo de items guardados --");
    System.out.println("Total de items: " + tiposItem.length);
    for (TipoItem tipoItem :
            tiposItem) {
      System.out.println(tipoItem.getId() + " Descripción: " + tipoItem.getDescripcion());
    }
    io.splitter(2);
    io.waitKey();
  }

  public void actualizar() {
    io.splitter(1);
    System.out.println("-- Ingresa el id del tipo de item a actualziar --");
    TipoItem tipoItemViejo = tipoItemDAO.findTipoItem(teclado.nextInt());
    System.out.println("Editando el tipo de item: ");
    System.out.println(tipoItemViejo.getId() + " Descripción: " + tipoItemViejo.getDescripcion());
    TipoItem tipoItem = crearTipoItem();
    tipoItem.setId(tipoItemViejo.getId());
    tipoItemDAO.updateTipoItem(tipoItemViejo, tipoItem);
    io.splitter(2);
  }

  public void borrar() {
    io.splitter(1);
    System.out.println("-- Ingresa el id del tipo de item a borrar --");
    TipoItem tipoItem = tipoItemDAO.findTipoItem(teclado.nextInt());
    tipoItemDAO.deleteTipoItem(tipoItem);
  }
}
