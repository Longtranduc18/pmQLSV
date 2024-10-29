package DAO;

import java.util.List;
import javax.persistence.TypedQuery;
import model.DropListCT;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;
import util.MsgBox;

public class DropListCTDAO implements DAOInterface<DropListCT>{
 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@Override
	public List<DropListCT> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DropListCT selectById(DropListCT t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(DropListCT t) {
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
	public boolean update(DropListCT t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DropListCT t) {
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
 public List<DropListCT> getDropList(String t,String macd) {
        if (sessionFactory != null) {
            Session session = sessionFactory.openSession();
            Transaction tr = session.beginTransaction();
            try { 
                String hql = "SELECT o FROM DropListCT o WHERE o.dropList.maLoaiDl Like ?0 AND o.chienDich.maChienDich Like ?1";
                TypedQuery<DropListCT> query = session.createQuery(hql);
                query.setParameter(0, t);
                query.setParameter(1, macd);
                List<DropListCT> results = query.getResultList();
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
 public boolean XoaDropList(String maLoai,String macd, String noiDung) {
        // TODO Auto-generated method stub
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
            String hql = "delete FROM DropListCT  WHERE maLoaiDl =: maLoai and NoiDung=:noiDung and maChienDich =: macd ";
              Query query = session.createQuery(hql);
                query.setParameter("maLoai", maLoai);
                query.setParameter("noiDung", noiDung);
                query.setParameter("macd", macd);
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
 public boolean CapNhatDropList(String noiDung, String maLoaiDl, String macd) {
    if (sessionFactory != null) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        try {
             String hql = "update  DropListCT set noiDung = ?0 where maLoaiDl = ?1 and  maChienDich = ?2";
            Query query = session.createQuery(hql);
            query.setParameter(0,noiDung);
             query.setParameter(1,maLoaiDl);
             query.setParameter(2,macd);
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
