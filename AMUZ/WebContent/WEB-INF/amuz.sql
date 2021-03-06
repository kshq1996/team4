
/* Drop Tables */

DROP TABLE ORDERSDETAIL;
DROP TABLE ADDRESS;
DROP TABLE APPRAISE;
DROP TABLE COMBO;
DROP TABLE DISCOUNT;
DROP TABLE ORDERS;
DROP TABLE SELL;
DROP TABLE TYPETABLE;
DROP TABLE PRODUCT;
DROP TABLE USERTABLE;




/* Create Tables */

CREATE TABLE ADDRESS
(
	ADDRESS_ID NUMBER NOT NULL,
	CITY NVARCHAR2(10) NOT NULL,
	PROVINCE NVARCHAR2(10) NOT NULL,
	STATE NVARCHAR2(15) NOT NULL,
	STREET NVARCHAR2(20) NOT NULL,
	ADDRESSDETAIL NVARCHAR2(20) NOT NULL,
	USER_ID NUMBER NOT NULL,
	PRIMARY KEY (ADDRESS_ID)
);


CREATE TABLE APPRAISE
(
	PRODUCT_APPRISE_ID NUMBER NOT NULL,
	PRODUCT_ID NUMBER NOT NULL,
	USER_ID NUMBER NOT NULL,
	APPRAISETIME DATE NOT NULL,
	APPRAISEDETAIL NVARCHAR2(200) NOT NULL,
	APPRAISESCORE NUMBER NOT NULL,
	PRIMARY KEY (PRODUCT_APPRISE_ID)
);


CREATE TABLE COMBO
(
	COMBO_ID NUMBER NOT NULL,
	FIRSTCOMBO NVARCHAR2(10) NOT NULL,
	SECONDCOMBO NVARCHAR2(10),
	THIRDCOMBO NVARCHAR2(10),
	FORTHTYPE NVARCHAR2(10),
	FIFTHTYPE NVARCHAR2(10),
	PRODUCT_ID NUMBER NOT NULL,
	PRIMARY KEY (COMBO_ID)
);


CREATE TABLE DISCOUNT
(
	DISCOUNT_ID NUMBER NOT NULL,
	DISCOUNT FLOAT NOT NULL,
	PRODUCT_ID NUMBER NOT NULL,
	PRIMARY KEY (DISCOUNT_ID)
);


CREATE TABLE ORDERS
(
	ORDER_ID NUMBER NOT NULL,
	ORDER_TIME DATE NOT NULL,
	PRODUCT_ID NUMBER NOT NULL,
	USER_ID NUMBER NOT NULL,
	-- 0为待发货 1为未发货 2为已发货 3待评价
	ORDERSTATUS NUMBER DEFAULT 0 NOT NULL,
	PRIMARY KEY (ORDER_ID)
);


CREATE TABLE ORDERSDETAIL
(
	ORDERSDETAIL_ID NUMBER NOT NULL,
	PRODUCT_ID NUMBER NOT NULL,
	USER_ID NUMBER NOT NULL,
	ORDER_ID NUMBER NOT NULL,
	ADDRESS_ID NUMBER NOT NULL,
	PRIMARY KEY (ORDERSDETAIL_ID)
);


CREATE TABLE PRODUCT
(
	PRODUCT_ID NUMBER NOT NULL,
	PRODUCT_NAME NVARCHAR2(280) NOT NULL,
	PRODUCT_DETAIL VARCHAR2(300) DEFAULT '等待商家填写',
	PRODUCT_COST FLOAT DEFAULT 0 NOT NULL,
	PRODUCT_BRAND NVARCHAR2(100) DEFAULT '亚马逊' NOT NULL,
	PRODUCT_FROM NVARCHAR2(200) DEFAULT '中国' NOT NULL,
	-- 产品图片1
	PRODUCT_IMG1 NVARCHAR2(100) NOT NULL,
	PRODUCT_IMG2 NVARCHAR2(100),
	PRODUCT_IMG3 NVARCHAR2(100),
	PRODUCT_FORPEOPLE NVARCHAR2(50) NOT NULL,
	PRIMARY KEY (PRODUCT_ID)
);


CREATE TABLE SELL
(
	SELL_ID NUMBER NOT NULL,
	PRODUCT_ID NUMBER NOT NULL UNIQUE,
	SOLDNUM NUMBER NOT NULL,
	RESIDUENUM NUMBER NOT NULL,
	PRIMARY KEY (SELL_ID)
);


CREATE TABLE TYPETABLE
(
	TYPE_ID NUMBER NOT NULL,
	FIRSTTYPE NVARCHAR2(10) NOT NULL,
	SECONDTYPE NVARCHAR2(10),
	THIRDTYPE NVARCHAR2(10),
	FORTHTYPE NVARCHAR2(10),
	FIFTHTYPE NVARCHAR2(10),
	PRODUCT_ID NUMBER NOT NULL,
	PRIMARY KEY (TYPE_ID)
);


CREATE TABLE USERTABLE
(
	USER_ID NUMBER NOT NULL,
	USERNAME VARCHAR2(16) NOT NULL UNIQUE,
	PASSWORD VARCHAR2(16) NOT NULL,
	SEX CHAR(1) NOT NULL,
	TRUENAME NVARCHAR2(10) NOT NULL,
	ADDRESS_ID NUMBER NOT NULL,
	HEADIMG CHAR(50),
	STATUS CHAR(1) NOT NULL,
	USERLEVEL NUMBER DEFAULT 0 NOT NULL,
	EMAIL NVARCHAR2(16),
	EMAILSTATUS NUMBER DEFAULT 0 NOT NULL,
	PRIMARY KEY (USER_ID)
);



/* Create Foreign Keys */

ALTER TABLE ORDERSDETAIL
	ADD FOREIGN KEY (ADDRESS_ID)
	REFERENCES ADDRESS (ADDRESS_ID)
;


ALTER TABLE ORDERSDETAIL
	ADD FOREIGN KEY (ORDER_ID)
	REFERENCES ORDERS (ORDER_ID)
;


ALTER TABLE APPRAISE
	ADD FOREIGN KEY (PRODUCT_ID)
	REFERENCES PRODUCT (PRODUCT_ID)
;


ALTER TABLE COMBO
	ADD FOREIGN KEY (PRODUCT_ID)
	REFERENCES PRODUCT (PRODUCT_ID)
;


ALTER TABLE DISCOUNT
	ADD FOREIGN KEY (PRODUCT_ID)
	REFERENCES PRODUCT (PRODUCT_ID)
;


ALTER TABLE ORDERS
	ADD FOREIGN KEY (PRODUCT_ID)
	REFERENCES PRODUCT (PRODUCT_ID)
;


ALTER TABLE ORDERSDETAIL
	ADD FOREIGN KEY (PRODUCT_ID)
	REFERENCES PRODUCT (PRODUCT_ID)
;


ALTER TABLE SELL
	ADD FOREIGN KEY (PRODUCT_ID)
	REFERENCES PRODUCT (PRODUCT_ID)
;


ALTER TABLE TYPETABLE
	ADD FOREIGN KEY (PRODUCT_ID)
	REFERENCES PRODUCT (PRODUCT_ID)
;


ALTER TABLE ADDRESS
	ADD FOREIGN KEY (USER_ID)
	REFERENCES USERTABLE (USER_ID)
;


ALTER TABLE APPRAISE
	ADD FOREIGN KEY (USER_ID)
	REFERENCES USERTABLE (USER_ID)
;


ALTER TABLE ORDERS
	ADD FOREIGN KEY (USER_ID)
	REFERENCES USERTABLE (USER_ID)
;


ALTER TABLE ORDERSDETAIL
	ADD FOREIGN KEY (USER_ID)
	REFERENCES USERTABLE (USER_ID)
;



/* Comments */

COMMENT ON COLUMN ORDERS.ORDERSTATUS IS '0为待发货 1为未发货 2为已发货 3待评价';
COMMENT ON COLUMN PRODUCT.PRODUCT_IMG1 IS '产品图片1';



