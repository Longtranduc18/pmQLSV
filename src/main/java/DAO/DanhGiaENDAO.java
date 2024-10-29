package DAO;

import java.util.List;
import javax.persistence.TypedQuery;
import model.DanhGiaEN;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import util.MsgBox;

public class DanhGiaENDAO implements DAOInterface<DanhGiaEN> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<DanhGiaEN> selectAll() {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaEN o";
                List<DanhGiaEN> results = session.createQuery(hql).list();
                tr.commit();
                session.close();
                return results;
            } catch (Exception e) {
                  MsgBox.alert(null, "Dữ liệu đã thay đổi, vui lòng load lại data");
                e.printStackTrace();
                tr.rollback();
                // TODO: handle exception

            }
        }
        return null;
    }

    @Override
    public DanhGiaEN selectById(DanhGiaEN t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(DanhGiaEN t) {
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
    public boolean update(DanhGiaEN t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(DanhGiaEN t) {
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

    public List<DanhGiaEN> selectByMans(String mans) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaEN o WHERE o.nhanSu.mans Like ?0 ";
                TypedQuery<DanhGiaEN> query = session.createQuery(hql);
                query.setParameter(0, mans);
                List<DanhGiaEN> results = query.getResultList();
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

    public DanhGiaEN selectByMssv(String mssv) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaEN o WHERE o.sinhVien.mssv Like ?0 ";
                TypedQuery<DanhGiaEN> query = session.createQuery(hql);
                query.setParameter(0, mssv);
                List<DanhGiaEN> results = query.getResultList();
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

    public List<DanhGiaEN> layDanhSachDaPhanCong(String maHocKi) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaEN o WHERE o.nhanSu.mans is not null and  o.hocKi.maHocKi like ?0";
                TypedQuery<DanhGiaEN> query = session.createQuery(hql);
                query.setParameter(0, maHocKi);
                List<DanhGiaEN> results = query.getResultList();
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

    public List<DanhGiaEN> layDanhSachChoPhanCong(String maHocKi) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaEN o WHERE o.nhanSu.mans is null and o.hocKi.maHocKi like ?0 ";
                TypedQuery<DanhGiaEN> query = session.createQuery(hql);
                query.setParameter(0, maHocKi);
                List<DanhGiaEN> results = query.getResultList();
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

    public List<DanhGiaEN> layDsDaPcOfCDCD(String macdcd) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaEN o WHERE o.nhanSu.mans is not null  and o.chienDichCD.maChienDichChuDong =: macdcd";
                TypedQuery<DanhGiaEN> query = session.createQuery(hql);
                query.setParameter("macdcd", macdcd);
                List<DanhGiaEN> results = query.getResultList();
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

    public List<DanhGiaEN> layDsChuaPcOfCDCD(String macdcd) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaEN o WHERE o.nhanSu.mans is null and  o.chienDichCD.maChienDichChuDong =:macdcd";
                TypedQuery<DanhGiaEN> query = session.createQuery(hql);
                query.setParameter("macdcd", macdcd);
                List<DanhGiaEN> results = query.getResultList();
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
                String hql = "SELECT COUNT(*) FROM DanhGiaEN o WHERE o.nhanSu.mans LIKE ?0";
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
                String hql = "SELECT o.nhanSu.mans FROM DanhGiaEN o WHERE o.nhanSu.mans LIKE ?0";
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
                String hql = "UPDATE DanhGiaEN SET maHocKi = ?0 where maChienDichChuDong = ?1";
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
                String hql = "UPDATE DanhGiaEN SET maChienDich = :maChienDich WHERE maChienDichChuDong = :maCdCD";
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

    public List<DanhGiaEN> getChamSocCN(String mans) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaEN o WHERE o.nhanSu.mans like ?0";

                TypedQuery<DanhGiaEN> query = session.createQuery(hql);
                query.setParameter(0, mans);
                List<DanhGiaEN> results = query.getResultList();
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
    public boolean deleteofCDCD(String  macdcd) {
        // TODO Auto-generated method stub
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "delete FROM DanhGiaEN  WHERE maChienDichChuDong =: macdcd";
              Query query = session.createQuery(hql);
                query.setParameter("macdcd", macdcd);
                 query.executeUpdate();
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
}
