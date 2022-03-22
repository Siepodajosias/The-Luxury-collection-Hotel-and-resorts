package Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.HibernateUtil;

import Base_Donnee.Services;

public class ModelService implements IService{

	@Override
	public boolean postAll(Services T) {
		// TODO Auto-generated method stub
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(T);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Services> getAll() {
        Transaction transaction = null;
        List<Services> service=null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            service = session.createQuery("from Services").list();
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
  
        return service; 
	}

	@Override
	public Services getAllById(int id) {
	       Transaction transaction = null;
	        Services svs = null;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    transaction = session.beginTransaction();
				    svs= session.byId(Services.class).getReference(id);
				    transaction.commit();
				    System.out.println(svs.getServiceDescription());
				    
			}catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
			}
	        return svs;
	}

	@Override
	public void Update(Services T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
