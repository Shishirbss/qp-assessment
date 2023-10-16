# qp-assessment
Designed a Grocery Booking API

**Endpoints for Admin:**
1)Add new Grocery Items to the system
http://localhost:8001/addNewGroceryItems

2)View existing grocery items
http://localhost:8001/existingGroceryItems

3)Remove grocery items from the system
http://localhost:8001/removeGrocery/{productCode}

4)Update details(eg, name,price) of existing grocery items
http://localhost:8001/updateGroceryDetails

5)Manage inventory levels of grocery items
http://localhost:8001/manageInventoryLevel

**Endpoints for User:**
1)View the list of available grocery items
http://localhost:8001/fetchAvailableItems

2)Ability to book multible grocery items in a single order
http://localhost:8001/OrderGroceryItems
