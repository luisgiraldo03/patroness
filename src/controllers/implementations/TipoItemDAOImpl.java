package controllers.implementations;

import controllers.ITipoItemDAO;
import models.TipoItem;
import storage.Storage;

public class TipoItemDAOImpl implements ITipoItemDAO {
  private Storage storage = null;

  public TipoItemDAOImpl() {
    storage = Storage.getInstance();
  }

  @Override
  public TipoItem[] getAllTipoItem() {
    Object[] tipoItem = storage.leer("tipoItem");
    if (tipoItem.length == 0) return new TipoItem[0];
    TipoItem[] tipoItemsAssambler = new TipoItem[tipoItem.length];

    for(int i = 0; i < tipoItem.length; i++) {
      tipoItemsAssambler[i] = ((TipoItem) tipoItem[i]);
    }

    return tipoItemsAssambler;
  }

  @Override
  public void updateTipoItem(TipoItem tipoItemViejo, TipoItem tipoItem) {
    if (!storage.actualizar("tipoItem", tipoItemViejo, tipoItem)) System.err.println("Error actualizando el tipo de item");
  }

  @Override
  public void deleteTipoItem(TipoItem tipoItem) {
    if (!storage.eliminar("tipoItem", tipoItem)) System.err.println("Error eliminando el tipo del item");
  }

  @Override
  public void addTipoItem(TipoItem tipoItem) {
    if (!storage.escribir("tipoItem", tipoItem)) System.err.println("Error al guarda el tipo de item");
  }

  @Override
  public TipoItem findTipoItem(int id) {
    return ((TipoItem) storage.buscar("tipoItem", id));
  }
}
