/**
 * 
 */
package com.grocerybooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.grocerybooking.dto.GroceryDetails;
import com.grocerybooking.dto.Inventory;
import com.grocerybooking.dto.OrderDetails;
import com.grocerybooking.entity.Product;
import com.grocerybooking.service.GroceryService;

@RestController
public class GroceryBookingController {

	@Autowired
	public GroceryService groceryService;
	
	@PutMapping("/addgroceryitem")
	public String addGroceryItems(@RequestBody GroceryDetails grocery)
	{
		String status=null;
		return status = groceryService.processGrocery(grocery);
	}
	
	@GetMapping("/existinggroceryitems")
	public List<Product> fetchAllGroceryItems()
	{
		return groceryService.fetchAllItems();
	}
	
	@DeleteMapping("/removegrocery/{productCode}")
	public String removeExistingGrocery(@PathVariable Integer productCode)
	{
		String status=null;
		return status = groceryService.removeExistingGroceryItems(productCode);
	}
	
	@PostMapping("/updategrocerydetails")
	public String updateExistingGroceryDetails(@RequestBody GroceryDetails grocery)
	{
		String status = null;
		return status = groceryService.updateExistingGroceryDetails(grocery);
	}
	
	@PostMapping("/manageinventorylevel")
	public String updateGrocertInventoryLevel(@RequestBody Inventory inventory)
	{
		String status =null;
		return status = groceryService.updateGroceryInventoryLevel(inventory);
	}
	
	@GetMapping("/fetchavailableitems")
	public List<Product> fetchAvailableGroceryItems()
	{
		return groceryService.fetchAvailableItems();
	}
	
	@GetMapping("/orderGroceryItems")
	public List<Product> orderGroceryItems(@RequestBody List<OrderDetails> orderDetails)
	{
		return groceryService.processOrder(orderDetails);
	}
}
