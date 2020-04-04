CREATE TABLE `corona_details` (
    `prefecture_name` varchar (256),
    `tested` bigint(11),
    `confirmed` bigint(11),
    `recovered` bigint(11),
    `critical` bigint(11),
    `active` bigint(11),
    `deaths` bigint(11),
    `created_at` datetime(3) DEFAULT NOW(3),
    `updated_at` datetime(3) DEFAULT NOW(3),
    PRIMARY KEY (prefecture_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
