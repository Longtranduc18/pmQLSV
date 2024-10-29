package DAO;

import java.util.List;
import javax.persistence.TypedQuery;
import model.ChuyenNganh;

import model.PhanCong;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PhanCongDAO implements DAOInterface<PhanCong> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
   public List<PhanCong> selectAll() {
           if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM PhanCong o";
                List<PhanCong> results = session.createQuery(hql).list();
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
    public PhanCong selectById(PhanCong t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(PhanCong t) {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {

                session.saveOrUpdate(t);
                tr.commit();
                session.close();
                return true;
            } catch (Exception e) {
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean update(PhanCong t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(PhanCong t) {
        // TODO Auto-generated method stub
        return false;
    }
    
     public boolean deleteByMans(String mans) {
        if(sessionFactory!=null){
                     Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
             try {
                 List<PhanCong> listpc = selectByMans(mans);
                 for(PhanCong pc : listpc){
                      session.remove(pc);
                 }
                tr.commit();
                session.close();  
                return true;
            } catch (Exception e) {
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
            }
        }
      return false;
    }

    public List<PhanCong> getPhanCong(String t,String macd) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try { 
                String hql = "SELECT o FROM PhanCong o WHERE o.chuyenNganh.maChuyenNganh Like ?0 AND o.chienDich.maChienDich Like ?1";
                TypedQuery<PhanCong> query = session.createQuery(hql);
                query.setParameter(0, t);
                query.setParameter(1, macd);
                List<PhanCong> results = query.getResultList();
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
     public List<PhanCong> selectByMans(String mans) {
         if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try { 
                String hql = "SELECT o FROM PhanCong o WHERE o.nhanSu.mans Like ?0 ";
                TypedQuery<PhanCong> query = session.createQuery(hql);
                query.setParameter(0, mans);
            
                List<PhanCong> results = query.getResultList();
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
}
