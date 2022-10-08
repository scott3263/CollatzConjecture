drop table `Collatz_Conjecture`; 

CREATE TABLE `Collatz_Conjecture` (
  `seq` double NOT NULL AUTO_INCREMENT COMMENT '순번',
  `bounce` long NOT NULL COMMENT '연산횟수',
  `calc_times` integer NOT NULL COMMENT '소요시간',
  `max_num` double NOT NULL COMMENT '최대값',
  `hash_value` varchar(200) NOT NULL COMMENT '해시값',
  `reg_date` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  `reg_id` varchar(45) DEFAULT NULL COMMENT '등록자',
  `last_date` datetime DEFAULT current_timestamp() COMMENT '최종수정일시',
  `last_id` varchar(45) DEFAULT NULL COMMENT '최종수정자',
  PRIMARY KEY (`seq`),
  UNIQUE KEY `collatz_conjecture_UNIQUE_01`(`hash_value`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Collatz Conjecture';