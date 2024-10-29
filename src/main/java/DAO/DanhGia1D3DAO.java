package DAO;

import java.util.List;
import javax.persistence.TypedQuery;

import model.DanhGia1D3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import util.MsgBox;

public class DanhGia1D3DAO implements DAOInterface<DanhGia1D3> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<DanhGia1D3> selectAll() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGia1D3 o";
                List<DanhGia1D3> results = session.createQuery(hql).list();
                tr.commit();
                session.close();
                return results;
            } catch (Exception e) {
                  MsgBox.alert(null, "Dữ liệu đã thay đổi, vui lòng load lại data");
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public DanhGia1D3 selectById(DanhGia1D3 t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(DanhGia1D3 t) {
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
    public boolean update(DanhGia1D3 t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(DanhGia1D3 t) {
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
            MsgBox.alert(null, "Dữ liệu đã thay đổi, vui lòng tải lại dữ liệu.");
            e.printStackTrace();
            tr.rollback();
            // TODO: handle exception

        }
        return false;
    }

    public List<DanhGia1D3> selectByMans(String mans) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGia1D3 o WHERE o.nhanSu.mans Like ?0 ";
                TypedQuery<DanhGia1D3> query = session.createQuery(hql);
                query.setParameter(0, mans);
                List<DanhGia1D3> results = query.getResultList();
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

    public DanhGia1D3 selectByMssv(String mssv) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGia1D3 o WHERE o.sinhVien.mssv Like ?0 ";
                TypedQuery<DanhGia1D3> query = session.createQuery(hql);
                query.setParameter(0, mssv);
                List<DanhGia1D3> results = query.getResultList();
                tr.commit();
                session.close();
                if (!(results.isEmpty())) {
                    return results.get(0);
                }

            } catch (Exception e) {
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return null;
    }

    public List<DanhGia1D3> layDanhSachDaPhanCong(String maHocKi) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGia1D3 o WHERE o.nhanSu.mans is not null AND o.hocKi.maHocKi like ?0";

                TypedQuery<DanhGia1D3> query = session.createQuery(hql);
                query.setParameter(0, maHocKi);
                List<DanhGia1D3> results = query.getResultList();
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

    public List<DanhGia1D3> layDanhSachChoPhanCong(String maHocKi) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGia1D3 o WHERE o.nhanSu.mans is null  and o.hocKi.maHocKi like ?0";
                TypedQuery<DanhGia1D3> query = session.createQuery(hql);
                query.setParameter(0, maHocKi);
                List<DanhGia1D3> results = query.getResultList();
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

    public List<DanhGia1D3> layDsDaPcOfCDCD(String macdcd) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGia1D3 o WHERE o.nhanSu.mans is not null and o.chienDichCD.maChienDichChuDong = :macdcd";
                TypedQuery<DanhGia1D3> query = session.createQuery(hql);
                query.setParameter("macdcd", macdcd);
                List<DanhGia1D3> results = query.getResultList();
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

    public List<DanhGia1D3> layDsChuaPcOfCDCD(String maChienDichChuDong) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                 String hql = "SELECT o FROM DanhGia1D3 o WHERE o.nhanSu.mans is null and o.chienDichCD.maChienDichChuDong = :macdcd";
                TypedQuery<DanhGia1D3> query = session.createQuery(hql);
                query.setParameter("macdcd", maChienDichChuDong);
                List<DanhGia1D3> results = query.getResultList();
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

    public int countByMans(String mans) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT COUNT(*) FROM DanhGia1D3 o WHERE o.nhanSu.mans LIKE ?0";
                TypedQuery<Long> query = session.createQuery(hql, Long.class);
                query.setParameter(0, mans);
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

    public List<String> Resultmans(String mans) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o.nhanSu.mans FROM DanhGia1D3 o WHERE o.nhanSu.mans LIKE ?0";
                TypedQuery<String> query = session.createQuery(hql);
                query.setParameter(0, mans);
                List<String> results = query.getResultList();
                tr.commit();
                session.close();
                return results;
            } catch (Exception e) {
                tr.rollback();
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setHocKi(String maCdCD, String maHocki) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "UPDATE DanhGia1D3 SET maHocKi = ?0 where maChienDichChuDong = ?1";
                Query query = session.createQuery(hql);
                query.setParameter(0, maHocki);
                query.setParameter(1, maCdCD);
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

    public void setChienDich(String maCdCD, String maChienDich) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "UPDATE DanhGia1D3 SET maChienDich = :maChienDich WHERE maChienDichChuDong = :maCdCD";
                Query query = session.createQuery(hql);
                query.setParameter("maChienDich", maChienDich);
                query.setParameter("maCdCD", maCdCD);
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

    public List<DanhGia1D3> getChamSocCN(String mans) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGia1D3 o WHERE o.nhanSu.mans like ?0";

                TypedQuery<DanhGia1D3> query = session.createQuery(hql);
                query.setParameter(0, mans);
                List<DanhGia1D3> results = query.getResultList();
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
    public boolean deleteofCDCD(String macdcd) {
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction tr = session.beginTransaction();
    try {
        String hql = "delete FROM DanhGia1D3 WHERE maChienDichChuDong = :macdcd";
        Query query = session.createQuery(hql);
        query.setParameter("macdcd", macdcd);
        query.executeUpdate();
        tr.commit();
        session.close();
        return true;
    } catch (Exception e) {
        e.printStackTrace();
        tr.rollback();
        return false;
    }
}

}
