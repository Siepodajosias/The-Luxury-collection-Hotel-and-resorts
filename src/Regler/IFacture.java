package Regler;

import java.util.List;

import Base_Donnee.Factures;

public interface IFacture {
	 public boolean postAll(Factures T);
	 public List<Factures> getAll();
	 public Factures getAllById(int id);
	 public boolean Update(Factures T);
	 public boolean Delete(int id);

}
