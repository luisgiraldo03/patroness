package storage;

import models.Cliente;
import models.Factura;
import models.Item;
import models.TipoItem;

import java.util.ArrayList;

public class Storage {
  private static Storage instance = null;

  private int ClientIdCount = 0;
  private int ItemIdCount = 0;
  private int TipoItemIdCount = 0;
  private int FacturaIdCount = 0;
  private ArrayList<Cliente> ClientStorage;
  private ArrayList<Item> ItemStorage;
  private ArrayList<TipoItem> TipoItemStorage;
  private ArrayList<Factura> FacturaStorage;

  private Storage() {
    ClientStorage = new ArrayList<>();
    ItemStorage = new ArrayList<>();
    TipoItemStorage = new ArrayList<>();
    FacturaStorage = new ArrayList<>();
  }

  public boolean escribir(String tabla, Object datos) {
    try {
      switch (tabla) {
        case "client":
          Cliente cliente = (Cliente) datos;
          cliente.setId(ClientIdCount);
          ClientStorage.add(cliente);
          ClientIdCount++;
          break;
        case "item":
          Item item = (Item) datos;
          item.setId(ItemIdCount);
          ItemStorage.add(item);
          ItemIdCount++;
          break;
        case "tipoItem":
          TipoItem tipoItem = (TipoItem) datos;
          tipoItem.setId(TipoItemIdCount);
          TipoItemStorage.add(tipoItem);
          TipoItemIdCount++;
          break;
        case "factura":
          Factura factura = (Factura) datos;
          factura.setNumeroFactura(FacturaIdCount);
          FacturaStorage.add(factura);
          FacturaIdCount++;
          break;
        default:
          System.err.println("La tabla seleccionada no existe");
          return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public Object[] leer(String tabla) {
    switch (tabla) {
      case "client":
        Object[] a = ClientStorage.toArray();
        return a;
      case "item":
        return ItemStorage.toArray();
      case "tipoItem":
        return TipoItemStorage.toArray();
      case "factura":
        return FacturaStorage.toArray();
      default:
        System.err.println("La tabla seleccionada no existe");
        return new Object[0];
    }
  }

  public Object buscar(String tabla, int id) {
    switch (tabla) {
      case "client":
        return ClientStorage.stream().filter(cliente -> cliente.Id == id).findAny().orElse(null);
      case "item":
        return ItemStorage.stream().filter(item -> item.Id == id).findAny().orElse(null);
      case "tipoItem":
        return TipoItemStorage.stream().filter(tipoItem -> tipoItem.Id == id).findAny().orElse(null);
      case "factura":
        return FacturaStorage.stream().filter(factura -> factura.NumeroFactura == id).findAny().orElse(null);
      default:
        System.err.println("La tabla seleccionada no existe");
        return null;
    }
  }

  public boolean eliminar(String tabla, Object object) {
    switch (tabla) {
      case "client":
        return ClientStorage.remove((Cliente) object);
      case "item":
        return ItemStorage.remove((Item) object);
      case "tipoItem":
        return TipoItemStorage.remove((TipoItem) object);
      case "factura":
        return FacturaStorage.remove((Factura) object);
      default:
        System.err.println("La tabla seleccionada no existe");
        return false;
    }
  }

  public boolean actualizar(String tabla, Object old_datos, Object datos) {
    switch (tabla) {
      case "client":
        ClientStorage.remove((Cliente) old_datos);
        return ClientStorage.add((Cliente) datos);
      case "item":
        ItemStorage.remove((Item) old_datos);
        return ItemStorage.add((Item) datos);
      case "tipoItem":
        TipoItemStorage.remove((TipoItem) old_datos);
        return TipoItemStorage.add((TipoItem) datos);
      case "factura":
        FacturaStorage.remove((Factura) old_datos);
        return FacturaStorage.add((Factura) datos);
      default:
        System.err.println("La tabla seleccionada no existe");
        return false;
    }
  }

  public static Storage getInstance() {
    if (instance == null) instance = new Storage();
    return instance;
  }
}
