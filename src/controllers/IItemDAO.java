package controllers;

import models.Item;

public interface IItemDAO {
  public Item[] getAllItems();
  public void updateItem(Item itemViejo, Item item);
  public void deleteItem(Item item);
  public void addItem(Item item);
  public Item findItem(int id);
}
