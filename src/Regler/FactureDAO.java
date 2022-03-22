package Regler;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.HibernateUtil;

import Base_Donnee.Factures;

public class FactureDAO implements IFacture{

	@Override
	public boolean postAll(Factures T) {
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
	public List<Factures> getAll() {
        Transaction transaction = null;
        List<Factures> facture=null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();
            facture = session.createQuery("from Factures").list();
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
  
        return facture;
	}

	@Override
	public Factures getAllById(int id) {
	       Transaction transaction = null;
	        Factures Ftr = null;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    transaction = session.beginTransaction();
				    Ftr= session.byId(Factures.class).getReference(id);
				    transaction.commit();
				   System.out.println(Ftr.getFactureId());
				    
			}catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
			}
	        return Ftr;
	}

	@Override
	public boolean Update(Factures T) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(int id) {
        Transaction transaction = null;
        Factures facture = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            facture = session.get(Factures.class, id);
            session.delete(facture);
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
