--ALTER TABLE `payments`.`users`
--CHANGE COLUMN `user_id` `user_id` VARCHAR(64) NOT NULL ;

--CREATE TABLE `payments`.`users` (
--  `user_id` VARCHAR(64) NOT NULL,
--  `name` VARCHAR(255) NULL,
--  PRIMARY KEY (`user_id`));


INSERT INTO `payments`.`users`
(`user_id`,
`name`)
VALUES
("e8af92bd-1910-421e-8de0-cb3dcf9bf44d","Shay");

INSERT INTO `payments`.`users`
(`user_id`,
`name`)
VALUES
("d368e095-41b2-406a-9f92-3130c8f5e895","Ronaldo");

INSERT INTO `payments`.`users`
(`user_id`,
`name`)
VALUES
("ba942449-6136-41c8-a7c6-39524849f8dc","Messi");

INSERT INTO `payments`.`users`
(`user_id`,
`name`)
VALUES
("380572bb-4b03-46f6-9d15-223d15505e79","Mbappe");

COMMIT;