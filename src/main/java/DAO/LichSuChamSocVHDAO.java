package DAO;

import java.util.List;
import javax.persistence.TypedQuery;
import model.HocKi;
import model.LichSuChamSocVH;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.MsgBox;

public class LichSuChamSocVHDAO implements DAOInterface<LichSuChamSocVH> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

   
public List<LichSuChamSocVH> getLichSuTheoMssv(String mssv) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try { 
            String hql = "SELECT o FROM LichSuChamSocVH o WHERE o.mssv = :mssv ORDER BY o.thoiGianCS DESC";
            TypedQuery<LichSuChamSocVH> query = session.createQuery(hql);
            query.setParameter("mssv", mssv);
            query.setMaxResults(5); // chỉ trả về 5 dòng lịch sử gần nhất
            List<LichSuChamSocVH> results = query.getResultList();
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
public List<LichSuChamSocVH> getLichSuResultFive(String mssv) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try { 
            String hql = "SELECT new  LichSuChamSocVH(o.chienDich, o.nhanSu, o.thoiGianCS, o.phanLoaiNguyCo, o.lyDoGhiNhan, o.DienGiaiCT) FROM LichSuChamSocVH o WHERE o.mssv = :mssv ORDER BY o.thoiGianCS DESC";
            TypedQuery<LichSuChamSocVH> query = session.createQuery(hql);
            query.setParameter("mssv", mssv);
            query.setMaxResults(5); // chỉ trả về 5 dòng lịch sử gần nhất
            List<LichSuChamSocVH> results = query.getResultList();
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
public List<LichSuChamSocVH> getLichSuTheoMans(String mans) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try { 
            String hql = "SELECT o FROM LichSuChamSocVH o WHERE o.nhanSu.mans LIKE :mans";
            TypedQuery<LichSuChamSocVH> query = session.createQuery(hql);
            query.setParameter("mans", "%" + mans + "%");
            List<LichSuChamSocVH> results = query.getResultList();
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
    public List<LichSuChamSocVH> selectAll() {
      if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM LichSuChamSocVH o";
                List<LichSuChamSocVH> results = session.createQuery(hql)
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
    public LichSuChamSocVH selectById(LichSuChamSocVH t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(LichSuChamSocVH t) {
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
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean update(LichSuChamSocVH t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(LichSuChamSocVH t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public List<LichSuChamSocVH> LayLichSuTheoHK(String maHocKi) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try { 
      
            String hql = "SELECT o FROM LichSuChamSocVH o WHERE o.hocKi.maHocKi LIKE ?0 ORDER BY o.mssv, o.thoiGianCS DESC";
            TypedQuery<LichSuChamSocVH> query = session.createQuery(hql);
            query.setParameter(0,maHocKi);
            List<LichSuChamSocVH> results = query.getResultList();
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
            String hql = "SELECT COUNT(*) FROM LichSuChamSocVH o WHERE o.hocKi.maHocKi LIKE ?0 and o.nhanSu.mans LIKE ?1";
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
            String hql = "SELECT COUNT(*) FROM LichSuChamSocVH o WHERE o.hocKi.maHocKi LIKE ?0";
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
            String hql = "SELECT COUNT(*) FROM LichSuChamSocVH o WHERE o.chienDichCD.maChienDichChuDong =: macdcd";
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
