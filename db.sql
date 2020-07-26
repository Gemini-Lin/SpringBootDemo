drop database if exists demo;
create database demo;
use demo;
create table `Admin`(
  id int auto_increment,
  loginName varchar(255),
  password varchar(64),
  lastLoginTime datetime,
  remark  varchar(255),
  primary key (id)
);
insert into `Admin`(loginName,password) values('admin','admin123');
create table `MyClass`(
  id int auto_increment,
  name varchar(255),
  studentCount int,
  remark  varchar(255),
  primary key (id)
);

