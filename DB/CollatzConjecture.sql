drop table `Collatz_Conjecture`; 

CREATE TABLE `Collatz_Conjecture` (
  `seq` double NOT NULL AUTO_INCREMENT COMMENT '순번',
  `bounce` double NOT NULL COMMENT '연산횟수',
  `max_num` double NOT NULL COMMENT '최대값',
  `hash_value` varchar(200) NOT NULL COMMENT '해시값',
  `reg_date` datetime DEFAULT current_timestamp() COMMENT '등록일시',
  `reg_id` varchar(45) DEFAULT NULL COMMENT '등록자',
  `last_date` datetime DEFAULT current_timestamp() COMMENT '최종수정일시',
  `last_id` varchar(45) DEFAULT NULL COMMENT '최종수정자',
  PRIMARY KEY (`seq`),
  UNIQUE KEY `collatz_conjecture_UNIQUE_01`(`hash_value`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Collatz Conjecture';


select * from Collatz_Conjecture;

select * from Collatz_Conjecture order by reg_date desc;

select format(max(seq), "#,##0"), 
       format(max(bounce), "#,##0"), 
       format(max(max_num), "#,##0"), 
       max(reg_date) 
from Collatz_Conjecture;

select * from Collatz_Conjecture where max_num = 1504774;

select * from Collatz_Conjecture where bounce = (select max(bounce) from Collatz_Conjecture where seq <= 10000);

