package DAO;

import java.util.List;
import javax.persistence.TypedQuery;

import model.LichSuChamSocHP;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.MsgBox;

public class LichSuChamSOCHPDAO implements DAOInterface<LichSuChamSocHP> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<LichSuChamSocHP> selectAll() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM LichSuChamSocHP o";
                List<LichSuChamSocHP> results = session.createQuery(hql)
                .setMaxResults(50) // Chỉ lấy 50 dòng đầu tiên
                .list();
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
    public LichSuChamSocHP selectById(LichSuChamSocHP t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(LichSuChamSocHP t) {
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
                 MsgBox.alert(null, "Dữ liệu đã bị thay đổi, vui lòng load lại data");
                tr.rollback();
                e.printStackTrace();
               
            }
        }
        return false;
    }

    @Override
    public boolean update(LichSuChamSocHP t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(LichSuChamSocHP t) {
        // TODO Auto-generated method stub
        return false;
    }
public List<LichSuChamSocHP> getLichSuTheoMssv(String mssv) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try { 
            String hql = "SELECT o FROM LichSuChamSocHP o WHERE o.mssv = :mssv ORDER BY o.thoiGianCS DESC";
            TypedQuery<LichSuChamSocHP> query = session.createQuery(hql);
            query.setParameter("mssv", mssv);
            query.setMaxResults(5); // chỉ trả về 5 dòng lịch sử gần nhất
            List<LichSuChamSocHP> results = query.getResultList();
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
public List<LichSuChamSocHP> getLichSuResultFive(String mssv) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try { 
            String hql = "SELECT new  LichSuChamSocHP (o.chienDich, o.nhanSu, o.thoiGianCS, o.doiTuong, o.lyDoGhiNhan, o.dienGiaiCT) FROM LichSuChamSocHP o WHERE o.mssv = :mssv ORDER BY o.thoiGianCS DESC";
            TypedQuery<LichSuChamSocHP> query = session.createQuery(hql);
            query.setParameter("mssv", mssv);
            query.setMaxResults(5); // chỉ trả về 5 dòng lịch sử gần nhất
            List<LichSuChamSocHP> results = query.getResultList();
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
public List<LichSuChamSocHP> getLichSuTheoMans(String mans) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try { 
            String hql = "SELECT o FROM LichSuChamSocHP o WHERE o.nhanSu.mans LIKE :mans";
            TypedQuery<LichSuChamSocHP> query = session.createQuery(hql);
            query.setParameter("mans", "%" + mans + "%");
            List<LichSuChamSocHP> results = query.getResultList();
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
public List<LichSuChamSocHP> LayLichSuTheoHK(String maHocKi) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "SELECT o FROM LichSuChamSocHP o WHERE o.hocKi.maHocKi LIKE ?0 ORDER BY o.mssv, o.thoiGianCS DESC";
            TypedQuery<LichSuChamSocHP> query = session.createQuery(hql);
            query.setParameter(0,maHocKi);
            List<LichSuChamSocHP> results = query.getResultList();
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
public int countHKVaMans(String maHocKi,String mans) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "SELECT COUNT(*) FROM LichSuChamSocHP o WHERE o.hocKi.maHocKi LIKE ?0 and o.nhanSu.mans LIKE ?1";
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
public int countHK(String maHocKi) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "SELECT COUNT(*) FROM LichSuChamSocHP o WHERE o.hocKi.maHocKi LIKE ?0";
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
            String hql = "SELECT COUNT(*) FROM LichSuChamSocHP o WHERE o.chienDichCD.maChienDichChuDong =: macdcd";
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
