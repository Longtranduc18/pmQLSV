package DAO;

import Views.HomeFarm;
import java.util.List;
import javax.persistence.TypedQuery;
import model.NhanSu;

import model.SinhVien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import util.MsgBox;

public class SinhVienDAO implements DAOInterface<SinhVien> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<SinhVien> selectAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SinhVien selectById(SinhVien t) {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM SinhVien o WHERE o.mssv = ?0";
                TypedQuery<SinhVien> query = session.createQuery(hql);
                query.setParameter(0, t.getMssv());
                List<SinhVien> results = query.getResultList();
                tr.commit();
                session.close();
                if(results.size()>0) {
                return results.get(0);}
            } catch (Exception e) {
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
                
            }
        }
        return null;
    }

    @Override
    public boolean insert(SinhVien t) {
        // TODO Auto-generated method stub

        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            try {
                Transaction transaction = session.beginTransaction();
                session.saveOrUpdate(t);
                transaction.commit();
                session.close();
                return true;
            } catch (Exception e) {
                System.out.println("DAO.SinhVienDAO.insert() lỗi: " + e);
                return false;
            }

        } else {
            return false;
        }

    }

    @Override
    public boolean update(SinhVien t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(SinhVien t) {
        // TODO Auto-generated method stub
        return false;
    }
    public boolean deleteAll() {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "delete from SinhVien";
            Query query = session.createQuery(hql);
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
    public SinhVien selectByIresultTwo(SinhVien t) {
if (sessionFactory != null) {
Session session = sessionFactory.openSession();
Transaction tr = session.beginTransaction();
try {
String hql = "SELECT new SinhVien(o.mssv, o.chuyenNganh) FROM SinhVien o WHERE o.mssv = ?0";
TypedQuery<SinhVien> query = session.createQuery(hql);
query.setParameter(0, t.getMssv());
List<SinhVien> resultList = query.getResultList();
tr.commit();
session.close();
if(!resultList.isEmpty()){
return resultList.get(0);
}

} catch (Exception e) {
tr.rollback();
e.printStackTrace();
}
}
return null;
}


}
