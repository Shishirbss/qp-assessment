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

**Query for user setup**
-- Drop userfirst if they exist
DROP USER if exists 'grocerydatabase'@'localhost' ;

-- Now create user with prop privileges
CREATE USER 'grocerydatabase'@'localhost' identified BY 'grocerydatabase';

GRANT ALL PRIVILEGES ON * . * TO 'grocerydatabase'@'localhost';

**Query for database and table setup**
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

