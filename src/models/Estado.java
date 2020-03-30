package models;

public class Estado {
  private int Id;
  private EstadoType EstadoType;
  private String Descripcion;

  public Estado(int id, EstadoType estadoType, String descripcion) {
    this.Id = id;
    this.EstadoType = estadoType;
    this.Descripcion = descripcion;
  }

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public models.EstadoType getEstadoType() {
    return EstadoType;
  }

  public void setEstadoType(models.EstadoType estadoType) {
    EstadoType = estadoType;
  }

  public String getDescripcion() {
    return Descripcion;
  }

  public void setDescripcion(String descripcion) {
    Descripcion = descripcion;
  }
}
