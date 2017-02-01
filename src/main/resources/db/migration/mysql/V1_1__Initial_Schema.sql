-- Create syntax for TABLE 'PRODUCT_CATEGORY'
CREATE TABLE `PRODUCT_CATEGORY` (
  `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `record_id`   VARCHAR(36)  NOT NULL,
  `name`        VARCHAR(120) NOT NULL,
  `description` VARCHAR(120) NOT NULL,
  `status`      VARCHAR(10)           DEFAULT 'ACTIVE',
  `created_on`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on`  TIMESTAMP    NULL     DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_CAT_RECORD_ID` (`record_id`),
  UNIQUE KEY `UK_CAT_NAME` (`name`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 13
  DEFAULT CHARSET = utf8;

CREATE TRIGGER before_insert_cat
BEFORE INSERT ON PRODUCT_CATEGORY
FOR EACH ROW
  SET NEW.record_id = uuid();

-- Create syntax for TABLE 'PRODUCTS'
CREATE TABLE `PRODUCTS` (
  `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `name`        VARCHAR(120) NOT NULL,
  `description` VARCHAR(120) NOT NULL,
  `category_id` BIGINT(20)   NOT NULL,
  `status`      VARCHAR(10)           DEFAULT 'ACTIVE',
  `record_id`   VARCHAR(36)  NOT NULL,
  `created_on`  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on`  TIMESTAMP    NULL     DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_PRD_NAME` (`name`),
  UNIQUE KEY `UK_PRD_RECORD_ID` (`record_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `PRODUCT_CATEGORY` (`id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TRIGGER before_insert_products
BEFORE INSERT ON PRODUCTS
FOR EACH ROW
  SET NEW.record_id = uuid();

-- Create syntax for TABLE 'PRODUCT_IMAGES'
CREATE TABLE `PRODUCT_IMAGES` (
  `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `product_id`  BIGINT(20)   NOT NULL,
  `record_id`   VARCHAR(36)  NOT NULL,
  `description` VARCHAR(60)  NOT NULL,
  `url`         VARCHAR(120) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_PRD_IMG_RCRD_ID` (`record_id`),
  UNIQUE KEY `UK_PRD_IMG` (`product_id`, `url`),
  CONSTRAINT `product_images_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `PRODUCTS` (`id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TRIGGER before_insert_prd_img
BEFORE INSERT ON PRODUCT_IMAGES
FOR EACH ROW
  SET NEW.record_id = uuid();


-- Create syntax for TABLE 'TAGS'
CREATE TABLE `TAGS` (
  `id`        BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `tag`       VARCHAR(60) NOT NULL,
  `record_id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_TAG_RCRD_ID` (`record_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TRIGGER before_insert_tag
BEFORE INSERT ON TAGS
FOR EACH ROW
  SET NEW.record_id = uuid();

-- Create syntax for TABLE 'PRODUCT_TAGS'
CREATE TABLE `PRODUCT_TAGS` (
  `id`         BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT(20)  NOT NULL,
  `tag_id`     BIGINT(20)  NOT NULL,
  `record_id`  VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_PRD_TAG_ID` (`product_id`, `tag_id`),
  UNIQUE KEY `UK_PRD_TAG_RCRD_ID` (`record_id`),
  CONSTRAINT `product_tags_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `PRODUCTS` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `product_tags_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `TAGS` (`id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TRIGGER before_insert_prd_tag
BEFORE INSERT ON PRODUCT_TAGS
FOR EACH ROW
  SET NEW.record_id = uuid();


-- Create syntax for TABLE 'PRODUCTS'
CREATE TABLE `PRODUCT_PRICE` (
  `id`             BIGINT(20)    NOT NULL AUTO_INCREMENT,
  `product_id`     BIGINT(20)    NOT NULL,
  `record_id`      VARCHAR(36)   NOT NULL,
  `price`          NUMERIC(5, 2) NOT NULL DEFAULT 1.00,
  `price_unit`     VARCHAR(5)             DEFAULT 'KG',
  `currency`       VARCHAR(3)    NOT NULL DEFAULT "AED",
  `eff_start_date` TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `eff_end_date`   DATE,
  `created_on`     TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_on`     TIMESTAMP     NULL     DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_PRICE_RCD_ID` (`record_id`),
  UNIQUE KEY `UK_PRICE_DATE` (`product_id`, `eff_start_date`),
  CONSTRAINT `price_prd_fk` FOREIGN KEY (`product_id`) REFERENCES `PRODUCTS` (`id`)
    ON DELETE CASCADE
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;


CREATE TRIGGER before_insert_prod_price
BEFORE INSERT ON PRODUCT_PRICE
FOR EACH ROW
  SET NEW.record_id = uuid();