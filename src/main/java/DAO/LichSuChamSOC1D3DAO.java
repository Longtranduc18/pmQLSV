package DAO;

import java.util.List;
import javax.persistence.TypedQuery;

import model.LichSuChamSoc1D3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.MsgBox;

public class LichSuChamSOC1D3DAO implements DAOInterface<LichSuChamSoc1D3> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<LichSuChamSoc1D3> selectAll() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM LichSuChamSoc1D3 o";
                List<LichSuChamSoc1D3> results = session.createQuery(hql)
                .setMaxResults(50) // Chỉ lấy 50 dòng đầu tiên
                .list();
                tr.commit();
                session.close();
                return results;
            } catch (Exception e) {
                 MsgBox.alert(null, "Dữ liệu đã bị thay đổi, vui lòng load lại data");
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public LichSuChamSoc1D3 selectById(LichSuChamSoc1D3 t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(LichSuChamSoc1D3 t) {
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
    public boolean update(LichSuChamSoc1D3 t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(LichSuChamSoc1D3 t) {
        // TODO Auto-generated method stub
        return false;
    }
public List<LichSuChamSoc1D3> getLichSuTheoMssv(String mssv) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try { 
            String hql = "SELECT o FROM LichSuChamSoc1D3 o WHERE o.MSSV = :mssv ORDER BY o.thoiGianCS DESC";
            TypedQuery<LichSuChamSoc1D3> query = session.createQuery(hql);
            query.setParameter("mssv", mssv);
            query.setMaxResults(5); // chỉ trả về 5 dòng lịch sử gần nhất
            List<LichSuChamSoc1D3> results = query.getResultList();
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
public List<LichSuChamSoc1D3> getLichSuResultFive(String mssv) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try { 
            String hql = "SELECT new  LichSuChamSoc1D3 (o.chienDich, o.nhanSu, o.thoiGianCS, o.doiTuong, o.lyDoGhiNhan, o.DienGiaiCT) FROM LichSuChamSoc1D3 o WHERE o.MSSV = :mssv ORDER BY o.thoiGianCS DESC";
            TypedQuery<LichSuChamSoc1D3> query = session.createQuery(hql);
            query.setParameter("mssv", mssv);
            query.setMaxResults(2); // chỉ trả về 5 dòng lịch sử gần nhất
            List<LichSuChamSoc1D3> results = query.getResultList();
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
public List<LichSuChamSoc1D3> getLichSuTheoMans(String mans) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try { 
            String hql = "SELECT o FROM LichSuChamSoc1D3 o WHERE o.nhanSu.mans LIKE :mans";
            TypedQuery<LichSuChamSoc1D3> query = session.createQuery(hql);
            query.setParameter("mans", "%" + mans + "%");
            List<LichSuChamSoc1D3> results = query.getResultList();
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
public List<LichSuChamSoc1D3> LayLichSuTheoHK(String maHocKi) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "SELECT o FROM LichSuChamSoc1D3 o WHERE o.hocKi.maHocKi LIKE ?0 ORDER BY o.MSSV,o.thoiGianCS DESC";
            TypedQuery<LichSuChamSoc1D3> query = session.createQuery(hql);
            query.setParameter(0,maHocKi);
            List<LichSuChamSoc1D3> results = query.getResultList();
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
public int countheoHKVaMans(String maHocKi,String mans) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "SELECT COUNT(*) FROM LichSuChamSoc1D3 o WHERE o.hocKi.maHocKi LIKE ?0 and o.nhanSu.mans LIKE ?1";
            TypedQuery<Long> query = session.createQuery(hql, Long.class);
            query.setParameter(0,maHocKi);
            query.setParameter(1,mans);
             Long count = query.getSingleResult();
            tr.commit();
            session.close();
             return count.intValue();
        } catch (Exception e) {
            tr.rollback();
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    return 0;
}
public int countheoHK(String maHocKi) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "SELECT COUNT(*) FROM LichSuChamSoc1D3 o WHERE o.hocKi.maHocKi LIKE ?0";
            TypedQuery<Long> query = session.createQuery(hql, Long.class);
            query.setParameter(0,maHocKi);
             Long count = query.getSingleResult();
            tr.commit();
            session.close();
             return count.intValue();
        } catch (Exception e) {
            tr.rollback();
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    return 0;
}
public int countheomacdcd(String macdcd) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "SELECT COUNT(*) FROM LichSuChamSoc1D3 o WHERE o.chienDichCD.maChienDichChuDong =: macdcd";
            TypedQuery<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("macdcd",macdcd);
             Long count = query.getSingleResult();
            tr.commit();
            session.close();
             return count.intValue();
        } catch (Exception e) {
            tr.rollback();
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    return 0;
}
}
