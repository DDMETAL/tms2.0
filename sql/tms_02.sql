DROP database IF EXISTS tms_02;
CREATE database tms_02 DEFAULT CHARACTER SET 'utf8';
use tms_02;

DROP TABLE IF EXISTS `tms_projects`;
DROP TABLE IF EXISTS `tms_teams`;
DROP TABLE IF EXISTS `tms_product_types`;


--项目表
CREATE TABLE `tms_projects` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL COMMENT '项目编码',
  `name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `beginDate` datetime DEFAULT NULL COMMENT '开始日期',
  `endDate` datetime   DEFAULT NULL COMMENT '结束日期',
  `valid` tinyint(1) DEFAULT '1' COMMENT '是否有效',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser`  varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--团表
CREATE TABLE `tms_teams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '团名称',
  `projectId` int(11) DEFAULT NULL COMMENT '项目id',
  `valid` tinyint(1) DEFAULT '1' COMMENT '是否有效',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser`  varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
--产品类型表
CREATE TABLE `tms_product_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '资源名称',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `note` varchar(100) DEFAULT NULL COMMENT '备注',
  `parentId` int(11) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedTime` datetime DEFAULT NULL COMMENT '修改时间',
  `createdUser` varchar(20) DEFAULT NULL COMMENT '创建用户',
  `modifiedUser` varchar(20) DEFAULT NULL COMMENT '修改用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 COMMENT='资源管理';

--系统产品表
CREATE TABLE `tms_products` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增长主键',
  `code` varchar(50) NOT NULL COMMENT '产品编号',
  `name` varchar(200) DEFAULT '' COMMENT '产品名称',
  `teamId` int(11) DEFAULT NULL COMMENT '团号Id',
  `exText` varchar(500) DEFAULT NULL COMMENT '特殊提示',
  `onlineDate` date DEFAULT NULL COMMENT '上架时间',
  `offlineDate` date DEFAULT NULL COMMENT '下架时间',
  `quantity` int(11) DEFAULT '0' COMMENT '预售数量',
  `minQty` int(11) DEFAULT '0' COMMENT '最低数量',
  `soldQty` int(11) DEFAULT '0' COMMENT '已售数量',
  `price` decimal(10,0) DEFAULT '0' COMMENT '产品价格',
  `classId` int(11) DEFAULT '0' COMMENT '产品分类编号',
  `nights` int(11) DEFAULT '0' COMMENT '晚数',
  `state` int(11) DEFAULT '0' COMMENT '产品状态  0：待售  1：上架   2：下架',
  `note` varchar(2000) DEFAULT NULL COMMENT '备注',
  `createdUser` varchar(255) DEFAULT NULL COMMENT '创建人用户名',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedUser` varchar(255) DEFAULT NULL COMMENT '最后修改人用户名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--产品附件表
CREATE TABLE `tms_attachements` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '附件主键',
  `title` varchar(200) DEFAULT NULL COMMENT '标题',
  `fileName` varchar(200) DEFAULT NULL COMMENT '文件名称 ',
  `contentType` varchar(50) DEFAULT NULL COMMENT '文件类型',
  `filePath` varchar(200) DEFAULT NULL COMMENT '存储路径',
  `fileDisgest` varchar(200) DEFAULT NULL COMMENT '文件摘要',
  `athBelong` int(3) DEFAULT NULL COMMENT '附件归属' ,
  `belongId` int(11) DEFAULT NULL COMMENT '归属对象Id' ,
  `createdUser` varchar(255) DEFAULT NULL COMMENT '创建人用户名',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
  `modifiedUser` varchar(255) DEFAULT NULL COMMENT '修改人用户名',
  `modifiedTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8;