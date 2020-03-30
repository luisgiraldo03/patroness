package controllers;

import models.TipoItem;

public interface ITipoItemDAO {
  public TipoItem[] getAllTipoItem();
  public void updateTipoItem(TipoItem tipoItemViejo, TipoItem tipoItem);
  public void deleteTipoItem(TipoItem tipoItem);
  public void addTipoItem(TipoItem tipoItem);
  public TipoItem findTipoItem(int id);
}
