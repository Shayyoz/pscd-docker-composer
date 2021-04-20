--ALTER TABLE `payments`.`payment_methods`
--CHANGE COLUMN `method_id` `method_id` VARCHAR(64) NOT NULL ;

--CREATE TABLE `payments`.`payment_methods` (
--  `method_id` VARCHAR(64) NOT NULL,
--  `user_id` VARCHAR(255) NULL,
--  `masked_number` VARCHAR(255) NULL,
--  `payment_method_type` VARCHAR(255) NULL,
--  PRIMARY KEY (`method_id`));

INSERT INTO `payments`.`payment_methods`
(`method_id`,
`masked_number`,
`user_id`,
`payment_method_type`)
VALUES
("9a66cb29-ff24-4a03-9b75-df999dcad5bc","*9944","e8af92bd-1910-421e-8de0-cb3dcf9bf44d","CREDIT_CARD");

INSERT INTO `payments`.`payment_methods`
(`method_id`,
`masked_number`,
`user_id`,
`payment_method_type`)
VALUES
("5712768e-4d2d-46e5-9045-8ed731718227","*12345","e8af92bd-1910-421e-8de0-cb3dcf9bf44d","BANK_ACCOUNT");


INSERT INTO `payments`.`payment_methods`
(`method_id`,
`masked_number`,
`user_id`,
`payment_method_type`)
VALUES
("c0a64399-6ead-4989-8420-0310e678acb6","shayizak88@gmail.com","e8af92bd-1910-421e-8de0-cb3dcf9bf44d","PAYPAL");


INSERT INTO `payments`.`payment_methods`
(`method_id`,
`masked_number`,
`user_id`,
`payment_method_type`)
VALUES
("7dab1221-0c68-4981-8982-3a9823245def","*5498","d368e095-41b2-406a-9f92-3130c8f5e895","CREDIT_CARD");


INSERT INTO `payments`.`payment_methods`
(`method_id`,
`masked_number`,
`user_id`,
`payment_method_type`)
VALUES
("856701ae-3757-4ee5-bcc0-09248cc4cd48","*1238","ba942449-6136-41c8-a7c6-39524849f8dc","CREDIT_CARD");


INSERT INTO `payments`.`payment_methods`
(`method_id`,
`masked_number`,
`user_id`,
`payment_method_type`)
VALUES
("21180ba0-7a13-4359-942d-a9345b0e96d5","*85419","ba942449-6136-41c8-a7c6-39524849f8dc","BANK_ACCOUNT");

COMMIT;