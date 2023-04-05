package fr.afpa.dao;
import fr.afpa.utils.hibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Generic<T> {
 static Session session =  hibernateUtils.getSessionFactory().openSession();
    private Class<T> entity;

    public Generic(Class<T> entity) {
        this.entity = entity;
    }



    public void save(T obj) {
        Transaction transaction = null;
        try  {
            transaction = session.beginTransaction();
            Integer cle = (Integer) session.save(obj);
            transaction.commit();
        } catch (Exception e) {
        	e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void update(T obj)  {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
        }
    }
    public void delete(T obj)  {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
        } catch (Exception e) {
            if (tx != null)
                tx.rollback();
        }
    }
    public T findById(int id) {
        return (T) session.get(entity, id);
    }


    public List<T> findAll() {
        return (List<T>) session.createQuery("from " + entity.getName()).list();
    }

}
