--用户表
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,  -- 用户名
  `password` varchar(255) NOT NULL, -- 密码
  `enabled` tinyint(1) NOT NULL,    -- 用户是否启用
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--权限表
CREATE TABLE `authorities` (
  `username` varchar(50)  NOT NULL, --权限所属的用户
  `authority` varchar(50) NOT NULL, --权限的名称
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--用户组
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT, --用户组id
  `group_name` varchar(50) NOT NULL,       --用户组名称
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--组成员，一对多，一个用户组可以包含多个用户
CREATE TABLE `group_members` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT, 
  `username` varchar(50) NOT NULL,         --用户
  `group_id` bigint(20) NOT NULL,          --用户组id
  PRIMARY KEY (`id`),
  KEY `fk_group_members_group` (`group_id`),
  CONSTRAINT `fk_group_members_group` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--组权限
CREATE TABLE `group_authorities` (
  `group_id` bigint(20) NOT NULL,        --用户组id
  `authority` varchar(50) NOT NULL,      --用户组权限
  KEY `fk_group_authorities_group` (`group_id`),
  CONSTRAINT `fk_group_authorities_group` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;