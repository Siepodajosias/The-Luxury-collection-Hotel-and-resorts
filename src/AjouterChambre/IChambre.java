package AjouterChambre;

import java.util.List;

import Base_Donnee.Chambres;

public interface IChambre {
	 public boolean postAll(Chambres T);
	 public List<Chambres> getAll();
	 public Chambres getAllById(int id);
	 public void Update(Chambres T);
	 public boolean Delete(int id);
}
