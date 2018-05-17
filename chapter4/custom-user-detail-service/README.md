CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(50)  NOT NULL  COMMENT '用户名',
  `password` varchar(256)  NOT NULL COMMENT '密码',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `birthday` timestamp NULL DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `privilege` (
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `name` varchar(255) NOT NULL COMMENT '权限名称'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;