package com.grocerybooking.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.grocerybooking.dao.GroceryDetailsDao;
import com.grocerybooking.dto.GroceryDetails;
import com.grocerybooking.dto.Inventory;
import com.grocerybooking.dto.OrderDetails;
import com.grocerybooking.entity.Product;

@Service
public class GroceryServiceImpl implements GroceryService{

	@Autowired
	GroceryDetailsDao groceryDetailsDao;

	@Override
	@Transactional
	public String processGrocery(GroceryDetails grocery) {
		String status=null;
		if(valitadeFields(grocery)) {
			Product product = new Product();
			populateProduct(grocery,product);
			status =groceryDetailsDao.addGroceryDtails(product);
		}
		else {
			status = "Validate the necessary request fields";
		}
		return status;
	}

	@Override
	public List<Product> fetchAllItems() {
		return groceryDetailsDao.fetchAllItems();
	}

	@Override
	@Transactional
	public String removeExistingGroceryItems(Integer productCode) {
		String status=null;
		if(productCode > 0)
		{
			status = groceryDetailsDao.removeProduct(productCode);
		} else {
			status = "ProductCode should be greated than 0";
		}
		return status;
	}

	@Override
	@Transactional
	public String updateExistingGroceryDetails(GroceryDetails grocery) {
		String status = null;
		if(null != grocery.getItemCode() && valitadeFields(grocery)) {
			status = groceryDetailsDao.updateExistingGroceryDetails(grocery);
		} else {
			status = "ProductCode should not be empty";
		}
		return status;
	}

	@Override
	@Transactional
	public List<Product> processOrder(List<OrderDetails> orderDetails) {
		List<OrderDetails> fetchOrders =orderDetails.stream().filter(o -> null!=o.getProductCode() && o.getQuantity() >0).collect(Collectors.toList());

		List<String> fetchProductCodes = fetchOrders.stream().map(OrderDetails :: getProductCode).collect(Collectors.toList());

		List<Product> orderedItems =groceryDetailsDao.fetchOrderDetails(fetchProductCodes);
		return orderedItems;
	}

	@Override
	@Transactional
	public String updateGroceryInventoryLevel(Inventory inventory) {
		String status= null;
		if(null != inventory.getProductCode() && null != inventory.getQuantity()) {
			status = groceryDetailsDao.updateGroceryInventoryLevel(inventory);
		} else {
			status = "Productcode and quantity should not be empty";
		}
		return status;
	}

	private void populateProduct(GroceryDetails grocery, Product product) {
		product.setName(grocery.getItemName());
		product.setPrice(grocery.getItemPrice());
		product.setSize(grocery.getItemSize());
		product.setDiscription(grocery.getItemDiscription());
		product.setCategort(grocery.getItemCategory());
		product.setQuantity(grocery.getItemQuantity());
	}

	private boolean valitadeFields(GroceryDetails grocery) {
		if(null != grocery.getItemName() && null != grocery.getItemPrice() && null != grocery.getItemCategory())
		{
			return true;
		}
		return false;
	}

	@Override
	public List<Product> fetchAvailableItems() {
		List<Product> availableItems = groceryDetailsDao.fetchAvailableItems();
		return availableItems;
	}

}
