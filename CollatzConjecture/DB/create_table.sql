drop table `Collatz_Conjecture`; 

CREATE TABLE `Collatz_Conjecture` (
  `seq` double NOT NULL AUTO_INCREMENT COMMENT '순번',
  `calc_times` integer NOT NULL COMMENT '연산횟수',
  `max_num` double NOT NULL COMMENT '최대값',
  `reg_date` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  `reg_id` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '등록자',
  `last_date` datetime DEFAULT current_timestamp() COMMENT '최종수정일시',
  `last_id` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '최종수정자',
  PRIMARY KEY (`seq`)
) ENGINE=InnoDB AUTO_INCREMENT=610443 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Collatz Conjecture';