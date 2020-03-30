package models;

import java.util.ArrayList;
import java.util.Date;

public class Factura {
  public int NumeroFactura;
  private Date FechaFactura;
  private Cliente Cliente;
  private float TotalFactura;
  private Estado Estado;
  private ArrayList<Item> Items;

  public Factura(int numeroFactura, Cliente cliente) {
    this.NumeroFactura = numeroFactura;
    this.FechaFactura = new Date();
    this.Cliente = cliente;
    this.TotalFactura = 0;
    this.Estado = new Estado(0, EstadoType.Pendiente, "");
    this.Items = new ArrayList<Item>();
  }

  public int getNumeroFactura() {
    return NumeroFactura;
  }

  public void setNumeroFactura(int numeroFactura) {
    NumeroFactura = numeroFactura;
  }

  public models.Cliente getCliente() {
    return Cliente;
  }

  public void setCliente(models.Cliente cliente) {
    Cliente = cliente;
  }

  public models.Estado getEstado() {
    return Estado;
  }

  public void setEstado(EstadoType estado) {
    this.Estado.setEstadoType(estado);
  }

  public Date getFechaFactura() {
    return FechaFactura;
  }

  public float getTotalFactura() {
    return TotalFactura;
  }

  public void addItem(Item item) {
    Items.add(item);
    TotalFactura += item.getValorUnitario();
  }

  public Item[] getAllItems() {
    return (Item[]) Items.toArray();
  }

  public Item getItem(Item item) {
    return Items.get(Items.indexOf(item));
  }

  public boolean removeItem(Item item) {
    if(!Items.contains(item)) return false;

    if(Items.remove(item)) {
      TotalFactura -= item.getValorUnitario();
      return true;
    }
    return false;
  }
}
