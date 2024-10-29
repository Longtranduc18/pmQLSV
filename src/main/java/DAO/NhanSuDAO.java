package DAO;

import java.util.List;
import javax.persistence.TypedQuery;

import model.NhanSu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class NhanSuDAO implements DAOInterface<NhanSu> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<NhanSu> selectAll() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM NhanSu o";
                List<NhanSu> results = session.createQuery(hql).list();
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
    public NhanSu selectById(NhanSu t) {
        // TODO Auto-generated method stub
          if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM NhanSu o WHERE o.mans = ?0";
                TypedQuery<NhanSu> query = session.createQuery(hql);
                query.setParameter(0, t.getMans());
                List<NhanSu> results = query.getResultList();
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
    

    @Override
    public boolean insert(NhanSu t) {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                t.setMatKhau("1");
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
    public boolean update(NhanSu t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(NhanSu t) {
        // TODO Auto-generated method stub
        return false;
    }
     public NhanSu Login(String user) {
         if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM NhanSu o WHERE o.mans = ?0";
                TypedQuery<NhanSu> query = session.createQuery(hql);
                query.setParameter(0, user);
                List<NhanSu> results = query.getResultList();
                tr.commit();
                session.close();
                if(results.size()>0){
                return results.get(0);}
            } catch (Exception e) {
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return null;
    
    }
     
      public List<NhanSu> selectNsOFF() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM NhanSu o WHERE o.trangThai = false";
                List<NhanSu> results = session.createQuery(hql).list();
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
        public List<NhanSu> selectNsON() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM NhanSu o WHERE o.trangThai = true";
                List<NhanSu> results = session.createQuery(hql).list();
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
public boolean UpdateTen(String hoTen,String mans) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "update  NhanSu set hoVaten = ?0 where mans like ?1";
            Query query = session.createQuery(hql);
            query.setParameter(0,hoTen);
             query.setParameter(1,mans);
            int rowCount = query.executeUpdate();
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
public boolean UpdateMatKhau(String matKhau,String mans) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
             String hql = "update  NhanSu set MatKhau = ?0 where mans like ?1";
            Query query = session.createQuery(hql);
            query.setParameter(0,matKhau);
             query.setParameter(1,mans);
            int rowCount = query.executeUpdate();
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
}
