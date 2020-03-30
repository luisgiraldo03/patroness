package models;

public class Item {
  public int Id;
  private TipoItem TipoItem;
  private String Descripcion;
  private int ValorUnitario;

  public Item(int id, TipoItem tipoItem, String descripcion, int valorUnitario) {
    this.Id = id;
    this.TipoItem = tipoItem;
    this.Descripcion = descripcion;
    this.ValorUnitario = valorUnitario;
  }

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public models.TipoItem getTipoItem() {
    return TipoItem;
  }

  public void setTipoItem(models.TipoItem tipoItem) {
    TipoItem = tipoItem;
  }

  public String getDescripcion() {
    return Descripcion;
  }

  public void setDescripcion(String descripcion) {
    Descripcion = descripcion;
  }

  public int getValorUnitario() {
    return ValorUnitario;
  }

  public void setValorUnitario(int valorUnitario) {
    ValorUnitario = valorUnitario;
  }
}
