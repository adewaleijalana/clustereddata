DROP TABLE IF EXISTS `fx_order_details`;

CREATE TABLE `fx_order_details`(
  `id` varchar(50) NOT NULL,
  `deal_id` varchar(45) NOT NULL,
  `ordering_currency` varchar(45) NOT NULL,
  `to_currency` varchar(45) DEFAULT NULL,
  `order_time` TIMESTAMP DEFAULT NULL,
  `amount` DECIMAL(18, 2) DEFAULT NULL,
  `version` bigint NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;