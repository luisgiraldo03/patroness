package controllers;

import models.Cliente;

public interface IClienteDAO {
  /**
   * Retrive all clients of the connection
   * @return Clients array
   */
  public Cliente[] getAllClients();

  /**
   * Update old client with new data
   * @param clienteViejo Old object storage in the database
   * @param datos New data to update
   */
  public void updateCliente(Cliente clienteViejo, Cliente datos);

  /**
   * Delete a client for Data base
   * @param cliente Client object storage in the database
   */
  public void deleteCliente(Cliente cliente);

  /**
   * Save a new client in the database
   * @param cliente `Client` object to add
   */
  public void addCliente(Cliente cliente);

  /**
   * Search a client in the database
   * @param id id del cliente a buscar
   * @return A fiended client is null when the client dosen't exists
   */
  public Cliente findCliente(int id);
}
