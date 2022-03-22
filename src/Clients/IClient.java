package Clients;

import java.util.List;

import Base_Donnee.Clients;

public interface IClient{
 public boolean postAll(Clients T);
 public List<Clients> getAll();
 public Clients getAllById(int id);
 public void Update(Clients T);
 public void Delete(int id);

}
