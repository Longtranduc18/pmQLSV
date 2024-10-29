package DAO;

import java.util.List;
import javax.persistence.TypedQuery;

import model.ChuyenNganh;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ChuyenNganhDAO implements DAOInterface<ChuyenNganh> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<ChuyenNganh> selectAll() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM ChuyenNganh o";
                List<ChuyenNganh> results = session.createQuery(hql).list();

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
    public ChuyenNganh selectById(ChuyenNganh t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(ChuyenNganh t) {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                session.save(t);
                System.out.println("them chuyen nganh thanh cong");
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
    public boolean update(ChuyenNganh t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(ChuyenNganh t) {
        // TODO Auto-generated method stub
        return false;
    }

    public String getMaChuyenNganh(String t) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM ChuyenNganh o WHERE o.tenChuyenNganh Like ?0";
                TypedQuery<ChuyenNganh> query = session.createQuery(hql);
                query.setParameter(0, t);
                List<ChuyenNganh> results = query.getResultList();
                tr.commit();
                session.close();
                if(results.size()>0) {
                	return results.get(0).getMaChuyenNganh();
                }
                
            } catch (Exception e) {
                tr.rollback();
                // TODO: handle exception
            	System.out.println("hihi");
                e.printStackTrace();
            }
        }
        return null;
    }
    
      public ChuyenNganh selectByName(String tenCN) {
          if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM ChuyenNganh o WHERE o.tenChuyenNganh like ?0";
              
                TypedQuery<ChuyenNganh> query = session.createQuery(hql);
                query.setParameter(0, tenCN);
                List<ChuyenNganh> results = query.getResultList();
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
