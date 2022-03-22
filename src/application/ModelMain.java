package application;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Session.HibernateUtil;

import Base_Donnee.Authentification;

public class ModelMain implements IMain{

	@Override
	public boolean postAll(Authentification T) {
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

	@Override
	public Authentification getAllById(String id) {
        Transaction transaction = null;
        Authentification auth = null;
        try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			    transaction = session.beginTransaction();
			    auth= session.byId(Authentification.class).getReference(id);
			    transaction.commit();
			 
		}catch(Exception e) {
			if (transaction != null) {
                transaction.rollback();
		}
		}
        return auth;
	}



}
