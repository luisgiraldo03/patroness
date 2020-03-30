package controllers;

import models.Factura;

public interface IFacturaDAO {
  public Factura[] getAllFacturas();
  public void updateFactura(Factura facturaVieja, Factura factura);
  public void deleteFactura(Factura factura);
  public void addFactura(Factura factura);
  public Factura findFactura(int id);
}
