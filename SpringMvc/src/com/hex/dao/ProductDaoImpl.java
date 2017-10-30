package com.hex.dao;

import com.hex.vo.Product;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateObjectRetrievalFailureException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.sql.SQLException;

import com.hex.util.HexApplicationException;

@Repository("productDao")
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {

	@Autowired
	public ProductDaoImpl(SessionFactory sessionfactory){
	    setSessionFactory(sessionfactory);
	}
	
	public void insert(Product object) throws HexApplicationException {
	
		System.out.println("inside insert in DAO");
		try {
			getHibernateTemplate().save(object);
	System.out.println("inside insert in DAO -----> after getHibernateTemplate().save");

		} catch (DataIntegrityViolationException dataIntegrityViolationException) {
System.out.println("inside insert in DAO ----> catch (DataIntegrityViolationException )");

			throw new HexApplicationException(HexApplicationException.DATA_INTEGRITY_EXCEPTION, dataIntegrityViolationException);
		} catch (DataAccessException dataAccessException) {
System.out.println("inside insert in DAO -----> catch (DataAccessException ) ");

			throw new HexApplicationException(dataAccessException);
		}
	}

	public void delete(Product object) throws HexApplicationException {
	
		System.out.println("inside delete in DAO");
		try {
			getHibernateTemplate().delete(object);
		}
		catch ( DataAccessException dataAccessException ) {
			throw new HexApplicationException ( dataAccessException );
		}
	}

	public void deleteAll(java.util.Collection entries) throws HexApplicationException {
	
		System.out.println("inside deleteAll in DAO");
		try {
			getHibernateTemplate().deleteAll(entries);
		}
		catch ( DataAccessException dataAccessException ) {
			throw new HexApplicationException ( dataAccessException );
		}
	}

	public void update(Product object) throws HexApplicationException {
	
		System.out.println("inside update in DAO");
		try {
			select ( object );
			getHibernateTemplate().update(object);
		} catch (DataIntegrityViolationException dataIntegrityViolationException) {
		    throw new HexApplicationException(HexApplicationException.DATA_INTEGRITY_EXCEPTION, dataIntegrityViolationException);
		} catch (DataAccessException dataAccessException) {
		    throw new HexApplicationException(dataAccessException);
		}
	}

	public Product select(Product object) throws HexApplicationException {
	
		System.out.println("inside select in DAO");	
		try {
			Product woProductVO = (Product) getHibernateTemplate().load(
				Product.class, object.getProductid());
			return woProductVO;
		} catch (HibernateObjectRetrievalFailureException exception) {
		    exception.printStackTrace();
		    throw new HexApplicationException(HexApplicationException.RECORD_NOT_FOUND_EXCEPTION);
		} catch (DataAccessException dataAccessException) {
		    dataAccessException.printStackTrace();
		    throw new HexApplicationException(dataAccessException);
		}
	
	}

	public java.util.List getAllProduct() throws HexApplicationException {
		try {
			return getHibernateTemplate().find("from Product"); 
		} catch (HibernateObjectRetrievalFailureException exception) {
		    exception.printStackTrace();
		    throw new HexApplicationException(HexApplicationException.RECORD_NOT_FOUND_EXCEPTION);
		} catch (DataAccessException dataAccessException) {
		    throw new HexApplicationException(dataAccessException);
		}
	}

	public java.util.List getAllProduct(final int startRecord, final int endRecord) throws HexApplicationException {
		try {
			return getHibernateTemplate().execute(new HibernateCallback(){
				public Object doInHibernate(Session session) throws HibernateException {
					Query query = session.createQuery("from Product");
					query.setFirstResult(startRecord);
					query.setMaxResults(endRecord);
					List list = query.list();
					return list;
				}
			});
			}
		catch ( HibernateException hibernateException ) {
			throw new HexApplicationException ( hibernateException );
		}		
	}
	public int getProductCount() throws HexApplicationException {
		try {
			class ReturnValue  {
				Integer value;
			}
			final ReturnValue rv = new ReturnValue();
			getHibernateTemplate().execute(new HibernateCallback(){
				public Object doInHibernate(Session session) throws HibernateException {
					rv.value = 
						((Integer) session.createQuery("select count(*) from Product").uniqueResult());
					return null;
				}
			});
			return rv.value.intValue();
		}
		catch ( DataAccessException dataAccessException ) {
			throw new HexApplicationException ( dataAccessException );
		}
    }


    public List search(String fieldValue, String columnName)
			throws HexApplicationException {

			System.out.println("Entering into DAO implementation : " + fieldValue + "***" +columnName );
		
		try {
			return getHibernateTemplate().find(		
					"FROM Product obj WHERE upper(obj." + columnName + ") LIKE '%" + fieldValue.toUpperCase() + "%'");

		} catch (DataAccessException dataAccessException) {
			throw new HexApplicationException(dataAccessException);
		}

	}


}
