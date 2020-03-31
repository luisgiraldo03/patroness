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

  public void setGenero(int genero) {
    switch (genero) {
      case 1:
        Genero = "Hombre";
        break;
      case 2:
        Genero = "Mujer";
      default:
        System.out.println("La opción no es admitida");
    }
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

  public void setEstadoCivil(int estadoCivil) {
    switch (estadoCivil) {
      case 1:
        EstadoCivil = "soltero";
        break;
      case 2:
        EstadoCivil = "Casado";
      case 3:
        EstadoCivil = "Union libre";
        break;
      default:
        System.out.println("Opción incorrecta");
    }
  }
}