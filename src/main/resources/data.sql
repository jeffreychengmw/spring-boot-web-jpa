DROP TABLE IF EXISTS users;
CREATE TABLE users (
	id int(11) UNSIGNED NOT NULL AUTO_INCREMENT, 
	username varchar(255) NOT NULL, 
	password varchar(32) NOT NULL, 
	status tinyint(3) UNSIGNED NOT NULL, PRIMARY KEY (id)
);

insert into users(username, password, status) values ("jeffrey@qq.com", "vjret4gre90dsa90", 1);
insert into users(username, password, status) values ("lidongneng@qq.com", "986643608hhy897b79", 1);
insert into users(username, password, status) values ("hivesplace@qq.com", "1ru32r8n49r8uf89w", 1);