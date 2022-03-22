package AjouterChambre;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.HibernateUtil;

import Base_Donnee.Chambres;

public class ModelChambre implements IChambre{
	private Chambres cl1;
	@Override
	public boolean postAll(Chambres T) {
		// TODO Auto-generated method stub
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            // save student object
            session.save(T);

            // commit the transaction
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
	public List<Chambres> getAll() {
		// TODO Auto-generated method stub
        Transaction transaction = null;
        List<Chambres> chambre=null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start the transaction
            transaction = session.beginTransaction();

            chambre = session.createQuery("from Chambres").list();

            // commit the transaction
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
  
        return chambre;  
	}

	@Override
	public Chambres getAllById(int id) {
	       Transaction transaction = null;
	        Chambres chb = null;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    transaction = session.beginTransaction();
				    chb= session.byId(Chambres.class).getReference(id);
				    transaction.commit();
				    System.out.println(chb.getChambreDescription());
			}catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
			}
	        return chb;
	}

	@Override
	public void Update(Chambres T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean Delete(int id) {
        Transaction transaction = null;
        Chambres chambre = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            chambre = session.get(Chambres.class, id);
            session.delete(chambre);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
		
	}
	public Chambres getCl1() {
		return cl1;
	}
	public void setCl1(Chambres cl1) {
		this.cl1 = cl1;
	}

}
