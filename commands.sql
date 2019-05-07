/*
    CREATE SCHEMA...
*/
CREATE SCHEMA `basetest` ;



/*
    CREATE TABLES...
*/
CREATE TABLE `basetest`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `basetest`.`provider` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `basetest`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `cost_purchase` DECIMAL(10,2) NOT NULL,
  `cost_sale` DECIMAL(10,2) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`id`));



/*
    INSERTS...
*/
INSERT INTO `basetest`.`user` (`username`, `password`) VALUES ('admin', 'admin');

INSERT INTO `basetest`.`provider` (`name`, `email`) VALUES ('Fornecedor Teste', 'fornecedor@email.com');

INSERT INTO `basetest`.`product` (`name`, `cost_purchase`, `cost_sale`, `quantity`) VALUES ('Coca-Cola', '1.50', '3.50', '50');
INSERT INTO `basetest`.`product` (`name`, `cost_purchase`, `cost_sale`, `quantity`) VALUES ('Pepsi', '1.25', '3.20', '100');
