package controllers.implementations;

import controllers.IFacturaDAO;
import models.Factura;
import storage.Storage;

public class FacturaDAOImpl implements IFacturaDAO {
  private Storage storage = null;

  public FacturaDAOImpl() {
    storage = Storage.getInstance();
  }

  @Override
  public Factura[] getAllFacturas() {
    Object[] factura = storage.leer("factura");
    if (factura.length == 0) return new Factura[0];
    Factura[] facturaAssambler = new Factura[factura.length];

    for (int i = 0; i < factura.length; i++) {
      facturaAssambler[i] = ((Factura) factura[i]);
    }

    return facturaAssambler;
  }

  @Override
  public void updateFactura(Factura facturaVieja, Factura factura) {
    if(!storage.actualizar("factura", facturaVieja, factura)) System.err.println("Error actualizando la factura");
  }

  @Override
  public void deleteFactura(Factura factura) {
    if (!storage.eliminar("factura", factura)) System.err.println("Error al eliminar la factura");
  }

  @Override
  public void addFactura(Factura factura) {
  if(!storage.escribir("factura", factura)) System.err.println("Error al guardar la factura");
  }

  @Override
  public Factura findFactura(int id) {
    return ((Factura) storage.buscar("factura", id));
  }
}
