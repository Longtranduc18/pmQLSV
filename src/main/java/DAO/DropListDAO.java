package DAO;

import java.util.List;

import model.DropList;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class DropListDAO implements DAOInterface<DropList>{
 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@Override
	public List<DropList> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DropList selectById(DropList t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(DropList t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(DropList t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(DropList t) {
		// TODO Auto-generated method stub
		return false;
	}

}
