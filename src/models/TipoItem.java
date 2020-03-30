package models;

public class TipoItem {
  public int Id;
  private  String Descripcion;

  public TipoItem(int id, String descripcion) {
    this.Id = id;
    this.Descripcion = descripcion;
  }

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public String getDescripcion() {
    return Descripcion;
  }

  public void setDescripcion(String descripcion) {
    Descripcion = descripcion;
  }
}
