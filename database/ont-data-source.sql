CREATE DATABASE IF NOT EXISTS `transaction_account`;

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account`
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `nickname`    varchar(128)        NOT NULL DEFAULT '未设置' COMMENT '昵称',
    `username`    varchar(64)         NOT NULL DEFAULT '' COMMENT '用户名',
    `password`    varchar(128)        NOT NULL DEFAULT '' COMMENT '密码',
    `balance`     decimal(20, 2)      NOT NULL DEFAULT '0.00' COMMENT '余额',
    `create_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `account` (`id`, `nickname`, `username`, `password`, `balance`, `create_time`, `update_time`)
VALUES (1, '小一', 'xiaoyi', '123456', 1000.00, '2020-01-09 17:04:28', '2020-01-09 17:44:33'),
       (2, '小二', 'xiaoer', '123456', 0.00, '2020-01-09 17:04:40', '2020-01-09 17:04:40');

