-- auto Generated on 2018-09-02
-- DROP TABLE IF EXISTS my_user;
CREATE TABLE my_user(
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	name VARCHAR (50) NOT NULL DEFAULT '' COMMENT '姓名',
	password VARCHAR (50) NOT NULL DEFAULT '' COMMENT '密码',
	age INT (11) NOT NULL DEFAULT -1 COMMENT '年龄',
	sex INT (11) NOT NULL DEFAULT -1 COMMENT '性别',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'my_user';