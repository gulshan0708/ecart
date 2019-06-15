package com.gk.ecart.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gk.ecart.dao.CategoryDAO;
import com.gk.ecart.dao.HibernateUtil;
import com.gk.ecart.entity.Category;

public class CategoryDAOImpl implements CategoryDAO {

	SessionFactory sf=HibernateUtil.getSessionFactory();
	Session session;
	Transaction tx;
	public Category get(int id) {
		// TODO Auto-generated method stub
		
		try {
			session= sf.openSession();
			 tx=session.getTransaction();
			 tx.begin();

			CriteriaBuilder cBuilder= session.getCriteriaBuilder();
			CriteriaQuery<Category> cquery=cBuilder.createQuery(Category.class);
			Root<Category> root= cquery.from(Category.class);
			
			cquery.select(root).where(cBuilder.equal(root.get("id"), id));
			
			Query query=session.createQuery(cquery);
			
			Category category=(Category) query.getSingleResult();
			
			return category;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				tx.rollback();
			} catch (IllegalStateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			return null;
		}finally {
			session.close();
			
		}
	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		session=sf.openSession();
		try {
			CriteriaBuilder cBuilder=session.getCriteriaBuilder();
			CriteriaQuery<Category> cquery= cBuilder.createQuery(Category.class);
			Root<Category> root= cquery.from(Category.class);
			
			cquery.select(root);
			
			Query query=session.createQuery(cquery);
			
			List<Category> categoryList= query.getResultList();
			
			return categoryList;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
			
		}finally {
			session.close();
		}
		
	}

	public boolean add(Category category) {
		session=sf.openSession();
		Transaction tx=null;
		
		try {
			tx=session.getTransaction();
			tx.begin();
			session.persist(category);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}finally {
			
			session.close();
			
		}
		
	}

	public boolean update(Category category) {
		session=sf.openSession();
		Transaction tx=null;
		
		try {
			tx=session.getTransaction();
			tx.begin();
			session.update(category);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}finally {
			
			session.close();
			
		}
		
	}

	public boolean delete(Category category) {
		session=sf.openSession();
      Transaction tx=null;
		
		try {
			tx=session.getTransaction();
			tx.begin();
			category.setActive(false);
			session.update(category);
			tx.commit();
			return true;
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		}finally {
			
			session.close();
			
		}
	}

}
