package AjouterEmployes;

import java.util.List;

import Base_Donnee.Employes;

public interface IAjouterE {
	 public boolean postAll(Employes T);
	 public List<Employes> getAll();
	 public Employes getAllById(int id);
	 public void Update(Employes T);
	 public boolean Delete(int id);
}
