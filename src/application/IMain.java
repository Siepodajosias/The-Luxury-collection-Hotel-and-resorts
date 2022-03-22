package application;

import Base_Donnee.Authentification;

public interface IMain {
	 public boolean postAll(Authentification T);
	 public Authentification getAllById(String id);

}
