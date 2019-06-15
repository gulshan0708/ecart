package com.gk.ecart.daoimpl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.stereotype.Repository;

import com.gk.ecart.dao.HibernateUtil;
import com.gk.ecart.dao.ProductDAO;
import com.gk.ecart.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	private static final Logger LOG = LogManager.getLogger(ProductDAOImpl.class);

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session;

	public Product get(int productId) {
		// TODO Auto-generated method stub
		LOG.info("Inside get method of ProductDaoImpl");
		session = sessionFactory.openSession();
		try {
			CriteriaBuilder cBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Product> cQuery = cBuilder.createQuery(Product.class);
			Root<Product> root = cQuery.from(Product.class);
			cQuery.select(root).where(cBuilder.equal(root.get("id"), productId));
			Query query = session.createQuery(cQuery);
			Product product = (Product) query.getSingleResult();
			return product;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			session.close();

		}

	}

	public List<Product> list() {
		// TODO Auto-generated method stub
		LOG.info("inside list method");
		session = sessionFactory.openSession();
		CriteriaBuilder cBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Product> cQuery = cBuilder.createQuery(Product.class);
		Root<Product> root = cQuery.from(Product.class);
		cQuery.select(root);
		Query query = session.createQuery(cQuery);
		List<Product> productList = query.getResultList();
		return productList;
	}

	public boolean add(Product product) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}

	}

	public boolean update(Product product) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		session = sessionFactory.openSession();

		try {
			session.beginTransaction();
			session.remove(product);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
	}

	

	public List<Product> listActiveProducts() {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		CriteriaBuilder cBuilder=session.getCriteriaBuilder();
		CriteriaQuery<Product> cQuery= cBuilder.createQuery(Product.class);
		Root<Product> root=cQuery.from(Product.class);
		
		cQuery.select(root).where(cBuilder.equal(root.get("active"), true));
		
		Query query=session.createQuery(cQuery);
		
		List<Product> productList=query.getResultList();
		session.close();
		return productList;
	}

	public List<Product> listActiveProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		try {
			CriteriaBuilder cBuilder=session.getCriteriaBuilder();
			CriteriaQuery<Product> cquery= cBuilder.createQuery(Product.class);
			Root<Product> root= cquery.from(Product.class);
			
			cquery.select(root).where(cBuilder.equal(root.get("categoryId"), categoryId));
			Query query=session.createQuery(cquery);
			
			List<Product> productList=query.getResultList();
			return productList;			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		finally {
			session.close();
		}
		
	}
	public List<Product> getProductsByParam(String param, int count) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		try {
			CriteriaBuilder cbuilder= session.getCriteriaBuilder();
			CriteriaQuery<Product> cQuery= cbuilder.createQuery(Product.class);
			Root<Product> root=cQuery.from(Product.class);
			
			cQuery.select(root).orderBy(cbuilder.asc(root.get(param)));
			
			 Query query= session.createQuery(cQuery);
			 List<Product> productList=query.getResultList();
			 return productList;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}finally {
			session.close(); 
		}
		
	}

	public List<Product> getLatestActiveProducts(int count) {
		session=sessionFactory.openSession();
		try {
			CriteriaBuilder cBuilder=session.getCriteriaBuilder();
			CriteriaQuery<Product> cquery= cBuilder.createQuery(Product.class);
			Root<Product> root= cquery.from(Product.class);
			
			cquery.select(root).where(cBuilder.equal(root.get("active"), true));
			Query query=session.createQuery(cquery);
			
			List<Product> productList=query.getResultList();
			 return productList;
			 
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}finally {
			session.close(); 
		}
	}

	public boolean deactivate(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

}
