package Occupation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.HibernateUtil;

import Base_Donnee.Occupation;

public class OccupationDAO implements IOccupation{

	@Override
	public boolean postAll(Occupation T) {
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
	public List<Occupation> getAll() {
        Transaction transaction = null;
        List<Occupation> occp=null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            occp = session.createQuery("from Occupation").list();
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
  
        return occp; 
	}

	@Override
	public Occupation getAllById(int id) {
	       Transaction transaction = null;
	        Occupation occp = null;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    transaction = session.beginTransaction();
				    occp= session.byId(Occupation.class).getReference(id);
				    transaction.commit();
				    System.out.println(occp.getOccupationId());
			}catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
			}
	        return occp;
	}

	@Override
	public boolean Update(Occupation T) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
