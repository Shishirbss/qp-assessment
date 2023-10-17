# qp-assessment
Designed a Grocery Booking API

**Endpoints for Admin:**
1)Add new Grocery Items to the system
PUT: http://localhost:8001/addgroceryitem

2)View existing grocery items
GET:  http://localhost:8001/existinggroceryitems  

3)Remove grocery items from the system
DELETE: http://localhost:8001/removegrocery/{productCode}

4)Update details(eg, name,price) of existing grocery items
POST: http://localhost:8001/updategroceryDetails

5)Manage inventory levels of grocery items
POST: http://localhost:8001/manageinventorylevel

**Endpoints for User:**
1)View the list of available grocery items
GET: http://localhost:8001/fetchAvailableItems

2)Ability to book multible grocery items in a single order
GET: http://localhost:8001/OrderGroceryItems

**Query for user setup**
-- Drop userfirst if they exist
DROP USER if exists 'grocerydatabase'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'grocerydatabase'@'localhost' identified BY 'grocerydatabase';

GRANT ALL PRIVILEGES ON * . * TO 'grocerydatabase'@'localhost';

**Query for database and table setup (MySQL)**
-- create User and Password:
-- Drop userfirst if they exist
DROP USER if exists 'grocerydatabase'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'grocerydatabase'@'localhost' identified BY 'grocerydatabase';

GRANT ALL PRIVILEGES ON * . * TO 'grocerydatabase'@'localhost';

-- create database
CREATE DATABASE IF NOT EXISTS `grocery_database`;
USE `grocery_database`;

-- Table structure for table `grocery`
DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
`product_Code` integer NOT NULL auto_increment,
`product_Name` varchar(20) NOT NULL,
`product_price` decimal NOT NULL,
`product_size` varchar(10) DEFAULT NULL,
`product_quantity` integer,
`product_discription` varchar(100) DEFAULT NULL,
`product_category` varchar(15) NOT NULL,
primary key(`product_Code`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=latin1;

Api security is implimented but disabled, to enable please
1)Add spring security dependency to POM.xml
2)uncomment classes in com.grocerybooking.securityconfig
3)uncomment line-13 and coment line 15 in com.grocerybooking.GroceryBookingApiApplication class
4)Use Key: G-API-KEY , Value: grocerybooking while calling endpoints
Note: if using Postman to test endpoints select authorization as APIKEY and put Key: G-API-KEY , Value: grocerybooking

