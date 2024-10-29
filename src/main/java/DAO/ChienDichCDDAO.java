package DAO;

import java.util.List;

import model.ChienDichCD;
import model.HocKi;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class ChienDichCDDAO implements DAOInterface<ChienDichCD> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<ChienDichCD> selectAll() {
        // TODO Auto-generated method stub
       if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM ChienDichCD o";
                List<ChienDichCD> results = session.createQuery(hql).list();
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
    public ChienDichCD selectById(ChienDichCD t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(ChienDichCD t) {
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
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean update(ChienDichCD t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(ChienDichCD t) {
        // TODO Auto-generated method stub
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            session.remove(t);
            tr.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
            // TODO: handle exception

        }
        return false;
    }
public List<ChienDichCD> getDsChuaXuLy() {
        // TODO Auto-generated method stub
       if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM ChienDichCD o where o.trangThai = 0";
                List<ChienDichCD> results = session.createQuery(hql).list();
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
 public void updateTrangThai(String macdcd) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "UPDATE ChienDichCD SET trangThai = true where maChienDichChuDong =: macdcd";
                Query query = session.createQuery(hql);
                query.setParameter("macdcd", macdcd);
                query.executeUpdate();
                tr.commit();
                session.close();
            } catch (Exception e) {
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}

