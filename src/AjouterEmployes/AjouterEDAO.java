package AjouterEmployes;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.HibernateUtil;

import Base_Donnee.Employes;

public class AjouterEDAO implements IAjouterE{

	@Override
	public boolean postAll(Employes T) {
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
	public List<Employes> getAll() {
        Transaction transaction = null;
        List<Employes> employe=null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employe = session.createQuery("from Employes").list();
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
  
        return employe;  
	}

	@Override
	public Employes getAllById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update(Employes T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Delete(int id) {
        Transaction transaction = null;
        Employes employe = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            employe = session.get(Employes.class, id);
            session.delete(employe);

            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
		
	}
}
