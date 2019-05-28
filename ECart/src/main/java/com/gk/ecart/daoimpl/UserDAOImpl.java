package com.gk.ecart.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gk.ecart.dao.HibernateUtil;
import com.gk.ecart.dao.JPAUtil;
import com.gk.ecart.dao.UserDAO;
import com.gk.ecart.entity.Address;
import com.gk.ecart.entity.User;

public class UserDAOImpl implements UserDAO{
	
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	EntityManager entityManager;
	Session session;

	public User getByEmail(String email) {
		session=sessionFactory.openSession();
		
		
		CriteriaBuilder cbuilder=session.getCriteriaBuilder();
		CriteriaQuery<User> cquery=cbuilder.createQuery(User.class);
		Root<User> root=cquery.from(User.class);
		
		cquery.select(root).where(cbuilder.equal(root.get("email"),email));
		
		
		org.hibernate.query.Query<User> query=session.createQuery(cquery);
		
		User user=query.getSingleResult();
		
		
		
		return user;
	}

	public User get(int id) {
		// TODO Auto-generated method stub
		try {
		entityManager=JPAUtil.getEmf().createEntityManager();
		CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cquery= cBuilder.createQuery(User.class);
		Root<User> root= cquery.from(User.class);
		
		cquery.select(root).where(cBuilder.equal(root.get("id"), id));
		
		
		Query query=entityManager.createQuery(cquery);
		
		User user =(User)query.getSingleResult();
		

		return user;
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}finally {
			entityManager.close();

		}
	}

	public boolean add(User user) {
		try {
		entityManager=JPAUtil.getEmf().createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		return true;
		}catch (Exception e) {
			// TODO: handle exception
			entityManager.getTransaction().rollback();
			return false;
		}
		finally {
			entityManager.close();
		}
		
		
	}

	public Address getAddress(int addressId) {

		try {
			entityManager=JPAUtil.getEmf().createEntityManager();
			entityManager.getTransaction().begin();
			CriteriaBuilder cbuilder= entityManager.getCriteriaBuilder();
			CriteriaQuery<Address> cquery= cbuilder.createQuery(Address.class);
			Root<Address> root= cquery.from(Address.class);
			
			cquery.select(root).where(cbuilder.equal(root.get("addressId"), addressId));
			Query query=entityManager.createQuery(cquery);
			
			Address address=(Address) query.getSingleResult();
			entityManager.getTransaction().commit();
			return address;
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
			return null;
		}finally {
			entityManager.close();

		}
	}

	public boolean addAddress(Address address) {
		try {
			entityManager=JPAUtil.getEmf().createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(address);
			entityManager.getTransaction().commit();
			return true;
			}catch (Exception e) {
				entityManager.getTransaction().rollback();
				return false;
			}
			finally {
				entityManager.close();
			}
			
	}

	public boolean updateAddress(Address address) {
		try {
			entityManager=JPAUtil.getEmf().createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(address);
			entityManager.getTransaction().commit();
			return true;
			}catch (Exception e) {
				entityManager.getTransaction().rollback();
				return false;
			}
			finally {
				entityManager.close();
			}
	}

	public Address getBillingAddress(int userId) {
	
		try {
			entityManager=JPAUtil.getEmf().createEntityManager();
			entityManager.getTransaction().begin();
			CriteriaBuilder cbuilder= entityManager.getCriteriaBuilder();
			CriteriaQuery<Address> cquery= cbuilder.createQuery(Address.class);
			Root<Address> root= cquery.from(Address.class);
			
			cquery.select(root).where(cbuilder.equal(root.get("userId"), userId),
					cbuilder.equal(root.get("isBilling"), true));
			Query query=entityManager.createQuery(cquery);
			
			Address address=(Address) query.getSingleResult();
			entityManager.getTransaction().commit();
			return address;
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
			return null;
		}finally {
			entityManager.close();

		}
	}

	public List<Address> listShippingAddress(int userId) {
		try {
			entityManager=JPAUtil.getEmf().createEntityManager();
			entityManager.getTransaction().begin();
			CriteriaBuilder cbuilder= entityManager.getCriteriaBuilder();
			CriteriaQuery<Address> cquery= cbuilder.createQuery(Address.class);
			Root<Address> root= cquery.from(Address.class);
			
			cquery.select(root).where(cbuilder.equal(root.get("userId"), userId),
					cbuilder.equal(root.get("isShipping"), true));
			Query query=entityManager.createQuery(cquery);
			
			List<Address> addresslist= query.getResultList();
			entityManager.getTransaction().commit();
			return addresslist;
		} catch (Exception ex) {
			// TODO: handle exception
			System.out.println(ex.getMessage());
			return null;
		}finally {
			entityManager.close();
	}

}
}
