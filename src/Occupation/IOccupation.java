package Occupation;

import java.util.List;

import Base_Donnee.Occupation;

public interface IOccupation {
	 public boolean postAll(Occupation T);
	 public List<Occupation> getAll();
	 public Occupation getAllById(int id);
	 public boolean Update(Occupation T);
	 public void Delete(int id);
}
