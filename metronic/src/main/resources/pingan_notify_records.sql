/*
Navicat PGSQL Data Transfer

Source Server         : pg
Source Server Version : 100100
Source Host           : localhost:5432
Source Database       : metronic
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 100100
File Encoding         : 65001

Date: 2018-02-02 15:33:50
*/


-- ----------------------------
-- Table structure for pingan_notify_records
-- ----------------------------
DROP TABLE IF EXISTS "public"."pingan_notify_records";
CREATE TABLE "public"."pingan_notify_records" (
"id" int8 DEFAULT nextval('pingan_notify_records_id_seq'::regclass) NOT NULL,
"ord_id" varchar(32) COLLATE "default",
"ord_no" varchar(32) COLLATE "default",
"status" int2,
"amount" money,
"pay_time" varchar(32) COLLATE "default",
"trade_type" varchar(32) COLLATE "default",
"open_id" varchar(32) COLLATE "default",
"create_time" timestamptz(6)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "public"."pingan_notify_records"."ord_no" IS '订单号';
COMMENT ON COLUMN "public"."pingan_notify_records"."status" IS '支付状态1:成功;4失败;';
COMMENT ON COLUMN "public"."pingan_notify_records"."amount" IS '金额(单位:分)';
COMMENT ON COLUMN "public"."pingan_notify_records"."pay_time" IS '支付时间';
COMMENT ON COLUMN "public"."pingan_notify_records"."trade_type" IS '交易类型';
COMMENT ON COLUMN "public"."pingan_notify_records"."open_id" IS '商户open_id';
COMMENT ON COLUMN "public"."pingan_notify_records"."create_time" IS '创建时间';

-- ----------------------------
-- Records of pingan_notify_records
-- ----------------------------
INSERT INTO "public"."pingan_notify_records" VALUES ('1', '05e33cfe7bf4464daa645bae1e2a9769', '859456889140618391', '1', '￥0.01', '20170831163647', 'order_status_notify', 'c9a0523875e0708', '2017-08-31 16:56:50+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('2', '396ebdc50ea24e32b9ba80efb26ff48e', '103994106157735608', '1', '￥100.00', '20170901124404', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 12:44:08+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('3', '3be8d4cb6c574fdf996addaf0f01994f', '142700664996851686', '1', '￥4,000.00', '20170901125035', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 12:50:39+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('4', '6d8b0b5717cb4fe0b62ed538796435d5', '206658951499325360', '1', '￥58.00', '20170901130134', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:01:42+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('5', 'd04381ed57d7449e89e0d6eaef1f4e27', '212386665879157130', '1', '￥3.00', '20170901130212', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:02:18+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('6', '795bbb6a86c142a7b03b1771f5f4f050', '216115977346758998', '1', '￥3.00', '20170901130255', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:02:57+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('7', 'ac79ce2765384028b85a500b3a64f476', '255115029915111009', '1', '￥100.00', '20170901130920', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:09:22+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('8', 'eb2300fa61b84eefa12f35130a96918b', '272911876497205021', '1', '￥15.00', '20170901131214', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:12:21+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('9', 'bb9f6dfb1fa94584b7761e16e6ededc7', '283671454791661187', '1', '￥5.00', '20170901131402', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:14:09+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('10', '0ed21a7c39a64ecbb4ffbf39a86cf00d', '303112544522669228', '1', '￥5.50', '20170901131717', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:17:21+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('11', 'ec177b7d2ba94b9faa47a3d216ce3633', '325761627024801023', '1', '￥1,000.00', '20170901132108', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:21:16+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('12', '5a418a41afa1401aaa833fb8323691f7', '343123055618584329', '1', '￥3.00', '20170901132356', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:23:59+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('13', '9af08c0972794b11bcf1626b7b92a25b', '378217212893730533', '1', '￥0.10', '20170901132947', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:29:51+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('14', '61c44b1f40d4440baaeb99e7fc0ab7bf', '381961706892916343', '1', '￥0.01', '20170901133028', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:30:34+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('15', '498d84976dd7430f96ef11d3722a282f', '391297570485713828', '1', '￥0.01', '20170901133202', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:32:06+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('16', '3c515d0b0ccd460a8c522d184045ed7e', '461658683269474984', '1', '￥0.01', '20170901134340', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:43:42+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('17', '6105045dc078490281cd991388e44d25', '464590949468918173', '1', '￥0.01', '20170901134409', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:44:13+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('18', 'b25d2f66c15d4e979378bb0167992f39', '497026321115793677', '1', '￥1,100.00', '20170901134940', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:49:46+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('19', '72f96a0378a049bbb0d23a642217f4cb', '527974170743054056', '1', '￥15.00', '20170901135444', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:54:51+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('20', 'd0e7fe1484944d8e8a422cc7a27da048', '528065671244675817', '1', '￥2.50', '20170901135451', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 13:54:57+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('21', 'a036ff8165e44bea91b49ee67136aa36', '564511917055861172', '1', '￥0.02', '20170901140049', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 14:00:52+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('22', '02e69355ca254a1f91b93391b2cb6860', '569396783267332959', '1', '￥0.02', '20170901140145', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 14:01:47+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('23', 'e22272274f514057bd678ae490597562', '575490486743895427', '1', '￥0.01', '20170901140248', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 14:02:50+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('24', '9b02e04393cf4086b0dfa9c3fd889ac5', '590668398888803627', '1', '￥138.00', '20170901140514', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 14:05:20+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('25', 'e2a94595f3bd494285b3f6315ba1098b', '594308809479022386', '1', '￥132.00', '20170901140549', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 14:05:54+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('26', 'a0621cf637e94d2aaef209da67d062c0', '620107099061637485', '1', '￥133.00', '20170901141006', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 14:10:09+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('27', '8c877b07a34f44148b4844106e759de6', '624979478471378563', '1', '￥131.00', '20170901141054', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 14:11:01+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('28', 'dd1de6fb340c4f948cc8199d36c19424', '645838666737538114', '1', '￥145.00', '20170901141428', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 14:14:36+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('29', '6e337bb8e9a742fa9209e6c11f986c5a', '649951119138882793', '1', '￥10.00', '20170901141505', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 14:15:07+08');
INSERT INTO "public"."pingan_notify_records" VALUES ('30', '3993dadbebac42b891d97a21ed1f9001', '657992970258644628', '1', '￥140.00', '20170901141630', 'order_status_notify', 'c9a0523875e0708', '2017-09-01 14:16:37+08');
-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Uniques structure for table pingan_notify_records
-- ----------------------------
ALTER TABLE "public"."pingan_notify_records" ADD UNIQUE ("ord_no");

-- ----------------------------
-- Primary Key structure for table pingan_notify_records
-- ----------------------------
ALTER TABLE "public"."pingan_notify_records" ADD PRIMARY KEY ("id");
