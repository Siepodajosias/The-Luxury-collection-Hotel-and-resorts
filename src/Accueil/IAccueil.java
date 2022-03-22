package Accueil;

import java.util.List;

import Base_Donnee.Reservations;

public interface IAccueil {
	 public boolean postAll(Reservations T);
	 public List<Reservations> getAll();
	 public Reservations getAllById(int id);
	 public boolean Update(Reservations T);
	 public boolean Delete(int id);
}
