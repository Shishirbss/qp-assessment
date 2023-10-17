package com.grocerybooking.dao;

import java.util.List;

import com.grocerybooking.dto.GroceryDetails;
import com.grocerybooking.dto.Inventory;
import com.grocerybooking.entity.Product;

public interface GroceryDetailsDao {

	String addGroceryDtails(Product product);

	List<Product> fetchAllItems();

	String removeProduct(Integer productCode);

	String updateExistingGroceryDetails(GroceryDetails grocery);

	String updateGroceryInventoryLevel(Inventory inventory);

	List<Product> fetchOrderDetails(List<String> orderDetails);

	List<Product> fetchAvailableItems();

}
