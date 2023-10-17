package com.grocerybooking.service;

import java.util.List;

import com.grocerybooking.dto.GroceryDetails;
import com.grocerybooking.dto.Inventory;
import com.grocerybooking.dto.OrderDetails;
import com.grocerybooking.entity.Product;

public interface GroceryService {

	String processGrocery(GroceryDetails grocery);

	List<Product> fetchAllItems();

	String removeExistingGroceryItems(Integer productCode);

	String updateExistingGroceryDetails(GroceryDetails grocery);

	List<Product> processOrder(List<OrderDetails> orderDetails);

	String updateGroceryInventoryLevel(Inventory inventory);

	List<Product> fetchAvailableItems();

}
