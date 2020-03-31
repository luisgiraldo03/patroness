package controllers.implementations;

import controllers.IItemDAO;
import models.Item;
import storage.Storage;

public class ItemDAOImpl implements IItemDAO {
  private Storage storage = null;

  public ItemDAOImpl() {
    storage = Storage.getInstance();
  }

  @Override
  public Item[] getAllItems() {
    Object[] items = storage.leer("item");
    if (items.length == 0) return new Item[0];

    Item[] itemsAssambler = new Item[items.length];

    for(int i = 0; i < items.length; i++) {
      itemsAssambler[i] = ((Item) items[i]);
    }

    return itemsAssambler;
  }

  @Override
  public void updateItem(Item itemViejo, Item item) {
    if (!storage.actualizar("item", itemViejo, item)) {
      System.err.println("Error al actualizar el item");
      return;
    }

    System.out.println("Item actualizado");
  }

  @Override
  public void deleteItem(Item item) {
    if (!storage.eliminar("item", item)) {
      System.err.println("Error al eliminar la tabla");
      return;
    }

    System.out.println("Item borrado");
  }

  @Override
  public void addItem(Item item) {
    if (!storage.escribir("item", item)) {
      System.err.println("Error al guardar el item");
      return;
    }

    System.out.println("Item añadido");
  }

  @Override
  public Item findItem(int id) {
    return ((Item) storage.buscar("item", id));
  }
}
