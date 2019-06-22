package com.gk.ecart.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.gk.ecart.dao.CartLineDAO;
import com.gk.ecart.dao.HibernateUtil;
import com.gk.ecart.entity.Cart;
import com.gk.ecart.entity.CartLine;
import com.gk.ecart.entity.OrderDetail;
@Repository
public class CartLineDAOImpl implements CartLineDAO {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session session;

	public List<CartLine> list(int cartId) {
		// TODO Auto-generated method stub
		session = sf.openSession();

		CriteriaBuilder cbuilder = session.getCriteriaBuilder();
		CriteriaQuery<CartLine> cquery = cbuilder.createQuery(CartLine.class);
		Root<CartLine> root = cquery.from(CartLine.class);

		cquery.select(root).where(cbuilder.equal(root.get("cartId"), cartId));

		Query query = session.createQuery(cquery);

		List<CartLine> carlineList = query.getResultList();

		return carlineList;
	}

	public CartLine get(int id) {
		session = sf.openSession();

		CriteriaBuilder cbuilder = session.getCriteriaBuilder();
		CriteriaQuery<CartLine> cquery = cbuilder.createQuery(CartLine.class);
		Root<CartLine> root = cquery.from(CartLine.class);

		cquery.select(root).where(cbuilder.equal(root.get("id"), id));

		Query query = session.createQuery(cquery);

		CartLine cartline = (CartLine) query.getSingleResult();

		return cartline;
	}

	public boolean add(CartLine cartLine) {
		session=sf.openSession();
		org.hibernate.Transaction tx=session.getTransaction();

		try {
			tx.begin();
			session.persist(cartLine);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
	}

	public boolean update(CartLine cartLine) {
		session=sf.openSession();
		org.hibernate.Transaction tx=session.getTransaction();

		try {
			tx.begin();
			session.update(cartLine);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
	}
	

	public boolean remove(CartLine cartLine) {
		session=sf.openSession();
		org.hibernate.Transaction tx=session.getTransaction();

		try {
			tx.begin();
			session.remove(cartLine);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
	}

	public CartLine getByCartAndProduct(int cartId, int productId) {

		session=sf.openSession();
		try {
			CriteriaBuilder cbuilder= session.getCriteriaBuilder();
			CriteriaQuery<CartLine> cquery= cbuilder.createQuery(CartLine.class);
			Root<CartLine> root= cquery.from(CartLine.class);
			
		    List<Predicate> predicates = new ArrayList<Predicate>();

		    if(cartId != 0) {
		    	predicates.add(cbuilder.equal(root.get("cartId"), cartId));
		    }
		    if(productId != 0) {
		    	predicates.add(cbuilder.equal(root.get("productId"), productId));
		    }
			
			cquery.select(root).where(predicates.toArray(new Predicate[] {}));
			
			Query query=session.createQuery(cquery);
			
			CartLine cartline=(CartLine) query.getSingleResult();
			return cartline;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
		
	}

	public boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<CartLine> listAvailable(int cartId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		return false;
	}

}
