# rafaworld

#create database

add data to databse section - application.properties

![image](https://user-images.githubusercontent.com/30048214/50859431-a58b4980-1393-11e9-8751-4125e07fd5fa.png)


#create 3 tables in database

DROP TABLE IF EXISTS `role`; CREATE TABLE `role` ( `role_id` int(11) NOT NULL AUTO_INCREMENT, `role` varchar(255) DEFAULT NULL, PRIMARY KEY (`role_id`) ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`; CREATE TABLE `user` ( `user_id` int(11) NOT NULL AUTO_INCREMENT, `active` int(11) DEFAULT NULL, `email` varchar(255) NOT NULL, `last_name` varchar(255) NOT NULL, `name` varchar(255) NOT NULL, `password` varchar(255) NOT NULL, PRIMARY KEY (`user_id`) ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;DROP TABLE IF EXISTS `role`; CREATE TABLE `role` ( `role_id` int(11) NOT NULL AUTO_INCREMENT, `role` varchar(255) DEFAULT NULL, PRIMARY KEY (`role_id`) ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user`; CREATE TABLE `user` ( `user_id` int(11) NOT NULL AUTO_INCREMENT, `active` int(11) DEFAULT NULL, `email` varchar(255) NOT NULL, `last_name` varchar(255) NOT NULL, `name` varchar(255) NOT NULL, `password` varchar(255) NOT NULL, PRIMARY KEY (`user_id`) ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_role`; CREATE TABLE `user_role` ( `user_id` int(11) NOT NULL, `role_id` int(11) NOT NULL, PRIMARY KEY (`user_id`,`role_id`), KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`), FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`), FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

and insert values

 INSERT INTO `role` VALUES (1,'ROLE_ADMIN'); INSERT INTO `role` VALUES (2,'ROLE_USER');
 
 how to make admin
 
 Services.UserserviceImpl.saveUser -> 
 Role role = roleRepository.findByRole("ROLE_USER"); - change "ROLE_USER" -> "ROLE_ADMIN"
  
 #add mail data - application.properties
 
 ![image](https://user-images.githubusercontent.com/30048214/50859541-eedb9900-1393-11e9-890a-dd12edc572e2.png)
