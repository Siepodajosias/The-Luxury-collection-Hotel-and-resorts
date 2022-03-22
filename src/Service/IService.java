package Service;

import java.util.List;
import Base_Donnee.Services;

public interface IService {
	 public boolean postAll(Services T);
	 public List<Services> getAll();
	 public Services getAllById(int id);
	 public void Update(Services T);
	 public void Delete(int id);

}
