package views;

import controllers.implementations.ClientDAOImpl;
import models.Cliente;
import models.Factura;

import java.util.Scanner;

public class ClienteView {
  private IO io = null;
  private Scanner teclado = null;
  private ClientDAOImpl clientDAO = null;

  public ClienteView() {
    io = IO.getInstance();
    teclado = io.getTeclado();
    clientDAO = new ClientDAOImpl();
  }

  public void menu() {
    io.splitter(1);
    System.out.println("-- Selecciona una opción --");
    System.out.println("1. Listar clientes");
    System.out.println("2. Añadir cliente");
    System.out.println("3. Actualizar cliente");
    System.out.println("4. Borrar cliente");
    System.out.println("5. Volver");
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

  private Cliente createCliente() {
    Cliente cliente = new Cliente();
    System.out.println("Ingresa el nombre del cliente");
    cliente.setNombre(teclado.next());
    System.out.println("Ingresa el primer apellido: ");
    cliente.setApellidos(teclado.next());
    System.out.println("-- Selecciona el sexo --");
    System.out.println("1. Hombre");
    System.out.println("2. Mujer");
    System.out.print("Sexo > ");
    cliente.setGenero(teclado.nextInt());
    System.out.println("Ingresa la fecha de nacimiento:");
    System.out.print("dd/mm/aaaa > ");
    cliente.setFechaNacimiento(teclado.next());
    System.out.println("-- Selecciona el estado civil --");
    System.out.println("1. Soltero@");
    System.out.println("2. Casado@");
    System.out.println("3. Union libre");
    cliente.setEstadoCivil(teclado.nextInt());
    return cliente;
  }

  public void crear() {
    io.splitter(1);
    Cliente cliente = createCliente();

    clientDAO.addCliente(cliente);
    io.splitter(2);
  }

  public void listar() {
    io.splitter(1);
    Cliente[] clientes = clientDAO.getAllClients();
    System.out.println("-- Clientes guardados --");
    System.out.println("Total de clientes: " + clientes.length);
    for (Cliente cliente :
            clientes) {
      System.out.println(cliente.Id + " | Nombre: " + cliente.getNombre() + " " + cliente.getApellidos() + " | Genero: "
              + cliente.getGenero());
    }
    io.splitter(2);
    io.waitKey();
  }

  public void actualizar() {
    io.splitter(1);
    System.out.println("-- Ingresa el id del usuario a actualizar --");
    Cliente clienteViejo = clientDAO.findCliente(teclado.nextInt());
    System.out.println("Actualizando cliente -->");
    System.out.println(clienteViejo.Id + " | Nombre: " + clienteViejo.getNombre() + " " + clienteViejo.getApellidos() + " | Genero: "
            + clienteViejo.getGenero());
    Cliente cliente = createCliente();
    cliente.setId(clienteViejo.getId());
    clientDAO.updateCliente(clienteViejo, cliente);
    io.splitter(2);
  }

  public void borrar() {
    io.splitter(1);
    System.out.println("Ingresa el id del cliente a borrar");
    System.out.print("Id > ");
    Cliente cliente = clientDAO.findCliente(teclado.nextInt());
    clientDAO.deleteCliente(cliente);
    io.splitter(2);
  }
}
