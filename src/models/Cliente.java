package models;

public class Cliente {
  public int Id;
  private String Nombre;
  private String Apellidos;
  private String Genero;
  private String FechaNacimiento;
  private String EstadoCivil;

  public Cliente(int id, String nombre, String apellidos, String genero, String fechaNacimiento, String estadoCivil) {
    String[] nombreUsuarios = nombre.split(" ");
    this.Id = id;
    this.Nombre = nombre;
    this.Apellidos = apellidos;
    this.Genero = genero;
    this.FechaNacimiento = fechaNacimiento;
    this.EstadoCivil = estadoCivil;
  }

  public Cliente() {}

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public String getNombre() {
    return Nombre;
  }

  public void setNombre(String nombre) {
    Nombre = nombre;
  }

  public String getApellidos() {
    return Apellidos;
  }

  public void setApellidos(String apellidos) {
    Apellidos = apellidos;
  }

  public String getGenero() {
    return Genero;
  }

  public void setGenero(String genero) {
    Genero = genero;
  }

  public String getFechaNacimiento() {
    return FechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    FechaNacimiento = fechaNacimiento;
  }

  public String getEstadoCivil() {
    return EstadoCivil;
  }

  public void setEstadoCivil(String estadoCivil) {
    EstadoCivil = estadoCivil;
  }
}