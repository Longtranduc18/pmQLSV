package DAO;

import java.util.List;
import model.ChuyenNganh;

import model.HocKi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class HocKiDAO implements DAOInterface<HocKi> {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    @Override
    public List<HocKi> selectAll() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM HocKi o";
                List<HocKi> results = session.createQuery(hql).list();
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
    public HocKi selectById(HocKi t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(HocKi t) {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                session.save(t);
                tr.commit();
                session.close();
                return true;
            } catch (Exception e) {
                tr.rollback();
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean update(HocKi t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(HocKi t) {
        // TODO Auto-generated method stub
        return false;
    }
 public List<HocKi> selectAllMoiNhat() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT h FROM HocKi h ORDER BY h.STT DESC";
                List<HocKi> results = session.createQuery(hql).list();
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
public HocKi LayHocKiMoiNhat() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
               HocKi hocKi = (HocKi) session.createQuery("SELECT h FROM HocKi h ORDER BY h.STT DESC")
                                .setMaxResults(1)
                                .uniqueResult();
                tr.commit();
                session.close();
                return hocKi;
            } catch (Exception e) {
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return null;
    }
}
