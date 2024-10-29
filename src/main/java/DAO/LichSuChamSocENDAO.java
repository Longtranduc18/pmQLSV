package DAO;

import java.util.List;
import javax.persistence.TypedQuery;
import model.HocKi;
import model.LichSuChamSocEN;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;
import util.MsgBox;

public class LichSuChamSocENDAO implements DAOInterface<LichSuChamSocEN> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<LichSuChamSocEN> getLichSuTheoMssv(String mssv) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM LichSuChamSocEN o WHERE o.mssv = :mssv ORDER BY o.thoiGianCS DESC";
                TypedQuery<LichSuChamSocEN> query = session.createQuery(hql);
                query.setParameter("mssv", mssv);
                query.setMaxResults(2); // chỉ trả về 5 dòng lịch sử gần nhất
                List<LichSuChamSocEN> results = query.getResultList();
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

    public List<LichSuChamSocEN> getLichSuResultFive(String mssv) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT new  LichSuChamSocEN(o.chienDich, o.nhanSu, o.thoiGianCS, o.phanLoaiNguyCo, o.lyDoGhiNhan, o.DienGiaiCT) FROM LichSuChamSocEN o WHERE o.mssv = :mssv ORDER BY o.thoiGianCS DESC";
                TypedQuery<LichSuChamSocEN> query = session.createQuery(hql);
                query.setParameter("mssv", mssv);
                query.setMaxResults(5); // chỉ trả về 5 dòng lịch sử gần nhất
                List<LichSuChamSocEN> results = query.getResultList();
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

    public List<LichSuChamSocEN> getLichSuTheoMans(String mans) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM LichSuChamSocEN o WHERE o.nhanSu.mans LIKE :mans";
                TypedQuery<LichSuChamSocEN> query = session.createQuery(hql);
                query.setParameter("mans", "%" + mans + "%");
                List<LichSuChamSocEN> results = query.getResultList();
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
    public List<LichSuChamSocEN> selectAll() {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM LichSuChamSocEN o";
                List<LichSuChamSocEN> results = session.createQuery(hql)
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
    public LichSuChamSocEN selectById(LichSuChamSocEN t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(LichSuChamSocEN t) {
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
    public boolean update(LichSuChamSocEN t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(LichSuChamSocEN t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<LichSuChamSocEN> LayLichSuTheoHK(String maHocKi) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {

                String hql = "SELECT o FROM LichSuChamSocEN o WHERE o.hocKi.maHocKi LIKE ?0 ORDER BY o.mssv, o.thoiGianCS DESC";
                TypedQuery<LichSuChamSocEN> query = session.createQuery(hql);
                query.setParameter(0, maHocKi);
                List<LichSuChamSocEN> results = query.getResultList();
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

    public int countheoHKVaMans(String maHocKi, String mans) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT COUNT(*) FROM LichSuChamSocEN o WHERE o.hocKi.maHocKi LIKE ?0 and o.nhanSu.mans LIKE ?1";
                TypedQuery<Long> query = session.createQuery(hql, Long.class);
                query.setParameter(0, maHocKi);
                query.setParameter(1, mans);
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
                String hql = "SELECT COUNT(*) FROM LichSuChamSocEN o WHERE o.hocKi.maHocKi LIKE ?0";
                TypedQuery<Long> query = session.createQuery(hql, Long.class);
                query.setParameter(0, maHocKi);
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
                String hql = "SELECT COUNT(*) FROM LichSuChamSocEN o WHERE o.chienDichCD.maChienDichChuDong =: macdcd";
                TypedQuery<Long> query = session.createQuery(hql, Long.class);
                query.setParameter("macdcd", macdcd);
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
