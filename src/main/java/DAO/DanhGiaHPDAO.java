package DAO;

import java.util.List;
import javax.persistence.TypedQuery;

import model.DanhGiaHP;
import model.DanhGiaVH;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import util.MsgBox;

public class DanhGiaHPDAO implements DAOInterface<DanhGiaHP> {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<DanhGiaHP> selectAll() {
        // TODO Auto-generated method stub
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaHP o";
                List<DanhGiaHP> results = session.createQuery(hql).list();
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
    public DanhGiaHP selectById(DanhGiaHP t) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(DanhGiaHP t) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                session.saveOrUpdate(t);
                tr.commit();
                session.close();
                return true;
            } catch (Exception e) {
                MsgBox.alert(null, "Dữ liệu đã thay đổi, vui lòng load lại data");
                tr.rollback();
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean update(DanhGiaHP t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(DanhGiaHP t) {
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

    public List<DanhGiaHP> selectByMans(String mans) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaHP o WHERE o.nhanSu.mans = :mans and (o.trangThai = 1 or (o.trangThaiHP = 1 and o.trangThaiBL = 1) or (o.trangThaiHP = 0 and o.trangThaiBL = 0) )";
                TypedQuery<DanhGiaHP> query = session.createQuery(hql);
                query.setParameter("mans", mans);
                List<DanhGiaHP> results = query.getResultList();
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

    public DanhGiaHP selectByMssv(String mssv) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaHP o WHERE o.sinhVien.mssv Like ?0 ";
                TypedQuery<DanhGiaHP> query = session.createQuery(hql);
                query.setParameter(0, mssv);
                List<DanhGiaHP> results = query.getResultList();
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
public DanhGiaHP selectByMssvCSDT(String mssv) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaHP o WHERE o.sinhVien.mssv Like ?0 AND (\n"
                        + "(o.trangThaiHP = 1 AND o.trangThaiBL = 1) OR\n"
                        + "(o.trangThaiHP = 0 AND o.trangThaiBL = 0) OR\n"
                        + "(o.trangThai = 1)\n"
                        + ")";
                TypedQuery<DanhGiaHP> query = session.createQuery(hql);
                query.setParameter(0, mssv);
                List<DanhGiaHP> results = query.getResultList();
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
    public List<DanhGiaHP> layDanhSachDaPhanCong(String maHocKi) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaHP o WHERE o.nhanSu.mans is not null  and o.hocKi.maHocKi like ?0";
                TypedQuery<DanhGiaHP> query = session.createQuery(hql);
                query.setParameter(0, maHocKi);
                List<DanhGiaHP> results = query.getResultList();
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

    public List<DanhGiaHP> layDanhSachChoPhanCong(String maHocKi) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaHP o WHERE o.nhanSu.mans is null and  o.hocKi.maHocKi like ?0";
                TypedQuery<DanhGiaHP> query = session.createQuery(hql);
                query.setParameter(0, maHocKi);
                List<DanhGiaHP> results = query.getResultList();
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

    public List<DanhGiaHP> layDsDaPcOfCDCD(String macdcd) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaHP o WHERE o.nhanSu.mans is not null  and o.chienDichCD.maChienDichChuDong =: macdcd";
                TypedQuery<DanhGiaHP> query = session.createQuery(hql);
                query.setParameter("macdcd", macdcd);
                List<DanhGiaHP> results = query.getResultList();
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

    public List<DanhGiaHP> layDsChuaPcOfCDCD(String macdcd) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaHP o WHERE o.nhanSu.mans is null  and o.chienDichCD.maChienDichChuDong =: macdcd";
                TypedQuery<DanhGiaHP> query = session.createQuery(hql);
                query.setParameter("macdcd", macdcd);
                List<DanhGiaHP> results = query.getResultList();
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

    public boolean updateHP() {
        boolean success = false;
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "UPDATE DanhGiaHP SET trangThaiHP = false";
                Query query = session.createQuery(hql);
                query.executeUpdate();
                tr.commit();
                success = true;
            } catch (Exception e) {
                tr.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        return success;
    }

    public boolean updateBL() {
        boolean success = false;
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "UPDATE DanhGiaHP SET trangThaiBL = false";
                Query query = session.createQuery(hql);
                query.executeUpdate();
                tr.commit();
                success = true;
            } catch (Exception e) {
                tr.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        return success;
    }

    public void setHocKi(String maCdCD, String maHocki) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "UPDATE DanhGiaHP SET maHocKi = ?0 where maChienDichChuDong = ?1";
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
                String hql = "UPDATE DanhGiaHP SET maChienDich = :maChienDich WHERE maChienDichChuDong = :maCdCD";
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

    public int countByMans(String mans) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT COUNT(*) FROM DanhGiaHP o WHERE o.nhanSu.mans LIKE ?0 ";
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
                String hql = "SELECT o.nhanSu.mans FROM DanhGiaHP o WHERE o.nhanSu.mans LIKE ?0 AND (\n"
                        + "(o.trangThaiHP = 1 AND o.trangThaiBL = 1) OR\n"
                        + "(o.trangThaiHP = 0 AND o.trangThaiBL = 0) OR\n"
                        + "(o.trangThai = 1)\n"
                        + ")";
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

    public List<DanhGiaHP> getChamSocCN(String mans) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try {
                String hql = "SELECT o FROM DanhGiaHP o WHERE o.nhanSu.mans like ?0 AND (\n"
                        + "(o.trangThaiHP = 1 AND o.trangThaiBL = 1) OR\n"
                        + "(o.trangThaiHP = 0 AND o.trangThaiBL = 0) OR\n"
                        + "(o.trangThai = 1)\n"
                        + ")";

                TypedQuery<DanhGiaHP> query = session.createQuery(hql);
                query.setParameter(0, mans);
                List<DanhGiaHP> results = query.getResultList();
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
        // TODO Auto-generated method stub
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "delete FROM DanhGiaHP  WHERE maChienDichChuDong =: macdcd";
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
