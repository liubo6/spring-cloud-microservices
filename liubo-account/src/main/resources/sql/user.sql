DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(64) NOT NULL,
  `userId` varchar(64) DEFAULT NULL COMMENT '用户编号',
  `userName` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `phone` varchar(20) NOT NULL COMMENT '手机号码',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `userStatus` varchar(32) DEFAULT NULL COMMENT '用户状态',
  `registerTime` datetime DEFAULT NULL COMMENT '注册时间',
  `country` varchar(32) DEFAULT NULL COMMENT '国家',
  `province` varchar(32) DEFAULT NULL COMMENT '省份',
  `city` varchar(64) DEFAULT NULL COMMENT '城市',
  `address` varchar(64) DEFAULT NULL COMMENT '详细地址',
  `ip` varchar(32) DEFAULT NULL COMMENT 'ip',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateDate` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `IDX_PHONE` (`phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
