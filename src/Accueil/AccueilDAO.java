package Accueil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.HibernateUtil;

import Base_Donnee.Reservations;

public class AccueilDAO implements IAccueil{
	
	@Override
	public boolean postAll(Reservations T) {
		
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
	public List<Reservations> getAll() {
        Transaction transaction = null;
        List<Reservations> reservation=null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            reservation = session.createQuery("from Reservations").list();
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return reservation; 
	}

	@Override
	public Reservations getAllById(int id) {
	       Transaction transaction = null;
	        Reservations Rts = null;
	        try {
				Session session = HibernateUtil.getSessionFactory().openSession();
				    transaction = session.beginTransaction();
				    Rts= session.byId(Reservations.class).getReference(id);
			}catch (Exception e) {
				if (transaction != null) {
	                transaction.rollback();
			}
			}
	        return Rts;
	}

	@Override
	public boolean Update(Reservations T) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(T);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
		
	}

	@Override
	public boolean Delete(int id) {
        Transaction transaction = null;
        Reservations reservation = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            reservation = session.get(Reservations.class, id);
            session.delete(reservation);

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
