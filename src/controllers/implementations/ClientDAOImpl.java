package controllers.implementations;

import controllers.IClienteDAO;
import models.Cliente;
import storage.Storage;

public class ClientDAOImpl implements IClienteDAO {
  private Storage storage = null;

  public ClientDAOImpl() {
    storage = Storage.getInstance();
  }

  @Override
  public Cliente[] getAllClients() {
    Object[] clientes = storage.leer("client");
    if (clientes.length == 0) return new Cliente[0];
    Cliente[] clientsAssambler = new Cliente[clientes.length];

    for (int i = 0; i < clientes.length; i++) {
      clientsAssambler[i] = ((Cliente) clientes[i]);
    }

    return clientsAssambler;
  }

  @Override
  public void updateCliente(Cliente clienteViejo, Cliente datos) {
    if (!storage.actualizar("client", clienteViejo, datos)) {
      System.err.println("Error actualizando el cliente");
      return;
    }

    System.out.println("Cliente actualizado correctamente");
  }

  @Override
  public void deleteCliente(Cliente cliente) {
    if (!storage.eliminar("client", cliente)) {
      System.err.println("Error eliminando el cliente");
      return;
    }
    System.out.println("Cliente borrado");
  }

  @Override
  public void addCliente(Cliente cliente) {
    if(!storage.escribir("client", cliente)) {
      System.err.println("Error al añadir el cliente");
      return;
    }
    System.out.println("Cliente guardado");
  }

  @Override
  public Cliente findCliente(int id) {
    return ((Cliente) storage.buscar("client", id));
  }
}
