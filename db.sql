drop database if exists demo2;
create database demo2;
use demo2;
create table `Admin`(
  id int auto_increment,
  loginName varchar(255),
  password varchar(64),
  lastLoginTime datetime,
  remark  varchar(255),
  primary key (id)
);
insert into `Admin`(loginName,password) values('admin','admin123');
create table `Clazz`(
  id int auto_increment,
  name varchar(255),
  studentCount int,
  remark  varchar(255),
  primary key (id)
);

