drop table `Collatz_Conjecture`; 

CREATE TABLE `Collatz_Conjecture` (
  `seq` double NOT NULL AUTO_INCREMENT COMMENT '����',
  `bounce` long NOT NULL COMMENT '����Ƚ��',
  `calc_times` integer NOT NULL COMMENT '�ҿ�ð�',
  `max_num` double NOT NULL COMMENT '�ִ밪',
  `hash_value` varchar(200) NOT NULL COMMENT '�ؽð�',
  `reg_date` datetime DEFAULT current_timestamp() COMMENT '����Ͻ�',
  `reg_id` varchar(45) DEFAULT NULL COMMENT '�����',
  `last_date` datetime DEFAULT current_timestamp() COMMENT '���������Ͻ�',
  `last_id` varchar(45) DEFAULT NULL COMMENT '����������',
  PRIMARY KEY (`seq`),
  UNIQUE KEY `collatz_conjecture_UNIQUE_01`(`hash_value`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Collatz Conjecture';