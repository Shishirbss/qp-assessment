package com.grocerybooking.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.grocerybooking.dto.GroceryDetails;
import com.grocerybooking.dto.Inventory;
import com.grocerybooking.entity.Product;

@Repository
public class GroceryDetailsDaoImpl implements GroceryDetailsDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public String addGroceryDtails(Product product) {
		String status= null;
		try {
			entityManager.persist(product);
			status = "Product successfully added";
		} catch(Exception e) {
			status=e.getMessage();
		}
		return status;
	}

	@Override
	public List<Product> fetchAllItems() {
		TypedQuery<Product> query= entityManager.createQuery("from Product",Product.class);
		return query.getResultList();
	}

	@Override
	public String removeProduct(Integer productCode) {
		String status = null;
		Product productToRemove = entityManager.find(Product.class, productCode);
		if(null != productToRemove)
		{
			entityManager.remove(productToRemove);
			status = "ProductCode "+productCode+" is removed successfully";
		} else {
			status = "ProductCode "+productCode+" not found";
		}
		return status;
	}

	@Override
	public String updateExistingGroceryDetails(GroceryDetails grocery) {
		String status = null;
		Product productToUpdate = entityManager.find(Product.class,grocery.getItemCode());
		if(null != productToUpdate)
		{
			productToUpdate.setName(grocery.getItemName());
			productToUpdate.setPrice(grocery.getItemPrice());
			productToUpdate.setSize(grocery.getItemSize());
			productToUpdate.setDiscription(grocery.getItemDiscription());
			productToUpdate.setCategort(grocery.getItemCategory());
			productToUpdate.setQuantity(grocery.getItemQuantity());
			entityManager.merge(productToUpdate);
			status = "ProductCode "+grocery.getItemCode()+" updated";
		} else {
			status = "ProductCode "+grocery.getItemCode()+" not found";
		}
		return status;
	}

	@Override
	public String updateGroceryInventoryLevel(Inventory inventory) {
		String status = null;
		try {
			TypedQuery<Product> query = entityManager.createQuery("from Product where product_code =:data", Product.class);
			query.setParameter("data", inventory.getProductCode());
			query.executeUpdate();
			status ="Inventory level updated for productcode "+inventory.getProductCode()+" successfully";
		} catch (Exception e)
		{
			status = e.getMessage();
		}
		return status;
	}

	@Override
	public List<Product> fetchOrderDetails(List<String> orderDetails) {
		TypedQuery<Product> query = entityManager.createQuery("from Product where product_code=:data", Product.class);
		query.setParameter("data", orderDetails);
		return query.getResultList();
	}

	@Override
	public List<Product> fetchAvailableItems() {
		TypedQuery<Product> query = entityManager.createQuery("from Product where product_quantity >0",Product.class);
		return query.getResultList();
	}



}
