package DAO;

import java.util.List;
import javax.persistence.TypedQuery;

import model.ChienDich;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ChienDichDAO implements DAOInterface<ChienDich> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<ChienDich> selectAll() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM ChienDich o";
                List<ChienDich> results = session.createQuery(hql).list();
                tr.commit();
                session.close();
                return results;
            } catch (Exception e) {
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ChienDich selectById(ChienDich t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(ChienDich t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update(ChienDich t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(ChienDich t) {
        // TODO Auto-generated method stub
        return false;
    }

     public ChienDich selectByName(String tenCD){
         if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM ChienDich o WHERE o.tenChienDich like ?0";
              
                TypedQuery<ChienDich> query = session.createQuery(hql);
                query.setParameter(0, tenCD);
                List<ChienDich> results = query.getResultList();
                tr.commit();
                session.close();
                return results.get(0);
            } catch (Exception e) {
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return null;
    }
}
