package Clients;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.HibernateUtil;

import Base_Donnee.Clients;

public class ModelClient implements IClient{
	@Override
	public boolean postAll(Clients T) {
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
	public List<Clients> getAll() {
		
			// TODO Auto-generated method stub
	        Transaction transaction = null;
	        List<Clients> client=null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            client = session.createQuery("from Clients").list();
	            transaction.commit();
	        }catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	        }
	  
	        return client;
	}
	@Override
	public Clients getAllById(int id) {
	       Transaction transaction = null;
	        Clients clt = null;
	        
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    transaction = session.beginTransaction();
				    clt= session.byId(Clients.class).getReference(id);
				    transaction.commit();
				    System.out.println(clt.getClientAge());
				    
			}catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
			}
	        return clt;
	}
	@Override
	public void Update(Clients T) {
        Transaction transaction = null;
        Clients client1 = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            client1 = session.get(Clients.class, T);
            session.delete(client1);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
	}


	@Override
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}


}
