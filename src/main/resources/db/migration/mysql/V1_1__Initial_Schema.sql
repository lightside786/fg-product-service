-- Create syntax for TABLE 'product_category'
CREATE TABLE `product_category` (
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
BEFORE INSERT ON product_category
FOR EACH ROW
  SET NEW.record_id = uuid();

-- Create syntax for TABLE 'products'
CREATE TABLE `products` (
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
  CONSTRAINT `PRODUCTS_IBFK_1` FOREIGN KEY (`category_id`) REFERENCES `product_category` (`id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TRIGGER before_insert_products
BEFORE INSERT ON products
FOR EACH ROW
  SET NEW.record_id = uuid();

-- Create syntax for TABLE 'product_images'
CREATE TABLE `product_images` (
  `id`          BIGINT(20)   NOT NULL AUTO_INCREMENT,
  `product_id`  BIGINT(20)   NOT NULL,
  `record_id`   VARCHAR(36)  NOT NULL,
  `description` VARCHAR(60)  NOT NULL,
  `url`         VARCHAR(120) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_PRD_IMG_RCRD_ID` (`record_id`),
  UNIQUE KEY `UK_PRD_IMG` (`product_id`, `url`),
  CONSTRAINT `PRODUCT_IMAGES_IBFK_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TRIGGER before_insert_prd_img
BEFORE INSERT ON product_images
FOR EACH ROW
  SET NEW.record_id = uuid();


-- Create syntax for TABLE 'tags'
CREATE TABLE `tags` (
  `id`        BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `tag`       VARCHAR(60) NOT NULL,
  `record_id` VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_TAG_RCRD_ID` (`record_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TRIGGER before_insert_tag
BEFORE INSERT ON tags
FOR EACH ROW
  SET NEW.record_id = uuid();

-- Create syntax for TABLE 'product_tags'
CREATE TABLE `product_tags` (
  `id`         BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT(20)  NOT NULL,
  `tag_id`     BIGINT(20)  NOT NULL,
  `record_id`  VARCHAR(36) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_PRD_TAG_ID` (`product_id`, `tag_id`),
  UNIQUE KEY `UK_PRD_TAG_RCRD_ID` (`record_id`),
  CONSTRAINT `PRODUCT_TAGS_IBFK_1` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `PRODUCT_TAGS_IBFK_2` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`)
    ON DELETE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TRIGGER before_insert_prd_tag
BEFORE INSERT ON product_tags
FOR EACH ROW
  SET NEW.record_id = uuid();


-- Create syntax for TABLE 'products'
CREATE TABLE `product_price` (
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
  CONSTRAINT `PRICE_PRD_FK` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
    ON DELETE CASCADE
)
  ENGINE = INNODB
  DEFAULT CHARSET = utf8;


CREATE TRIGGER before_insert_prod_price
BEFORE INSERT ON product_price
FOR EACH ROW
  SET NEW.record_id = uuid();