package com.hex.service;

import com.hex.vo.Product;
import com.hex.dao.ProductDao;
import java.util.List;
import com.hex.util.HexApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("productService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductImpl implements IProduct {
	
	@Autowired
	private ProductDao productDao;

	public void insert(Product object) throws HexApplicationException {
	
		System.out.println("inside insert in Service ");			
		productDao.insert(object);
		
	}

	public void delete(Product object) throws HexApplicationException {
	
		System.out.println("inside delete in Service ");	
		productDao.delete(object);
	
	}

	public void deleteAll(java.util.Collection entries) throws HexApplicationException {
	
		System.out.println("inside deleteAll in Service ");		
		productDao.deleteAll(entries);
	
	}

	public void update(Product object) throws HexApplicationException {
	
		System.out.println("inside update in Service ");	
		productDao.update(object);
	
	}

	public Object select(Product object) throws HexApplicationException {
	
		System.out.println("inside select in Service ");	
		return productDao.select(object);
	
	}

	public Object getAllProduct() throws HexApplicationException {
	
		System.out.println("inside getAllProduct in Service ");	
		return productDao.getAllProduct();
	
	}


	public Object getAllProduct(int startRecord, int endRecord) throws HexApplicationException {
	
		System.out.println("inside getAllProduct in Service ");	
		return productDao.getAllProduct(startRecord, endRecord);
	
	}

	public int getProductCount() throws HexApplicationException {
	
		System.out.println("inside getProductCount in Service ");	
		return productDao.getProductCount();
	
	}


	public List search(String fieldValue, String columnName) throws HexApplicationException {

	System.out.println("Entering into service implementation : " + fieldValue + "***" +columnName );
				
		return productDao.search(fieldValue, columnName);
	
	}


}
