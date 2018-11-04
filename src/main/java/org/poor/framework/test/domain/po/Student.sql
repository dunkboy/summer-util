-- auto Generated on 2018-11-03
-- DROP TABLE IF EXISTS student;
CREATE TABLE student(
	id BIGINT (20) NOT NULL AUTO_INCREMENT COMMENT 'id',
	tenant_id BIGINT (20) NOT NULL COMMENT 'tenantId',
	del_flag TINYINT (1) NOT NULL DEFAULT 0 COMMENT 'delFlag',
	name VARCHAR (50) NOT NULL COMMENT 'name',
	assign_type SMALLINT (2) NOT NULL COMMENT 'assignType',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'student';
