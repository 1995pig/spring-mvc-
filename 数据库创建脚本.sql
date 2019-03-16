-- 删除数据库
DROP DATABASE IF EXISTS mygoods ;
-- 创建数据库
CREATE DATABASE mygoods CHARACTER SET UTF8 ;
USE mygoods ;
-- 创建一级栏目表
CREATE TABLE item (
   iid                  bigint AUTO_INCREMENT ,
   title                varchar(50),
  CONSTRAINT pk_iid    PRIMARY KEY (IID)
) engine="innodb";
-- 创建二级栏目表
CREATE TABLE subitem (
   sid                  bigint AUTO_INCREMENT ,
   iid                  bigint,
   title                varchar(50),
 CONSTRAINT pk_sid PRIMARY KEY (sid) ,
 CONSTRAINT fk_iid FOREIGN KEY(iid) REFERENCES item(iid) ON DELETE CASCADE
) engine="innodb";
-- 创建商品表
CREATE TABLE goods (
   gid                  bigint AUTO_INCREMENT ,
   iid                  bigint,
   sid                  bigint,
   title                varchar(50)  not null,
   price		double ,
   photo                varchar(200),
   delflag		int ,
   CONSTRAINT pk_gid PRIMARY KEY (gid) ,
   CONSTRAINT fk_iid2 FOREIGN KEY(iid) REFERENCES item(iid) ON DELETE CASCADE ,
   CONSTRAINT fk_sid2 FOREIGN KEY(sid) REFERENCES subitem(sid) ON DELETE CASCADE 
) engine="innodb";

INSERT INTO item(title) VALUES ('图书音响') ;
INSERT INTO item(title) VALUES ('汽车用品') ;
INSERT INTO item(title) VALUES ('电脑办公') ;
INSERT INTO item(title) VALUES ('手机数码') ;
INSERT INTO item(title) VALUES ('家居生活') ;

INSERT INTO subitem(title,iid) VALUES ('儿童读物',1) ;
INSERT INTO subitem(title,iid) VALUES ('计算机',1) ;
INSERT INTO subitem(title,iid) VALUES ('人物传记',1) ;
INSERT INTO subitem(title,iid) VALUES ('汽车配件',2) ;
INSERT INTO subitem(title,iid) VALUES ('汽车改造',2) ;
INSERT INTO subitem(title,iid) VALUES ('显示器',3) ;
INSERT INTO subitem(title,iid) VALUES ('主板',3) ;
INSERT INTO subitem(title,iid) VALUES ('CPU',3) ;
INSERT INTO subitem(title,iid) VALUES ('内存',3) ;
INSERT INTO subitem(title,iid) VALUES ('手机',4) ;
INSERT INTO subitem(title,iid) VALUES ('内存卡',4) ;
INSERT INTO subitem(title,iid) VALUES ('耳机',4) ;
INSERT INTO subitem(title,iid) VALUES ('家庭装饰',5) ;
INSERT INTO subitem(title,iid) VALUES ('创意生活',5) ;