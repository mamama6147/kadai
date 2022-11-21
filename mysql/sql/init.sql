SET CHARSET UTF8;


CREATE DATABASE IF NOT EXISTS sample;

drop table IF EXISTS member;
drop table IF EXISTS companies;
drop table IF EXISTS project;


create table IF not EXISTS member(
    member_id INT AUTO_INCREMENT
  , member_name varchar(100)
  , member_rank varchar(100)
  , company_id INT
);


create table IF not EXISTS companies(
    company_id INT AUTO_INCREMENT
  , company_name varchar(100)
  , company_alias varchar(100)
);


create table IF not EXISTS project(
    project_id INT AUTO_INCREMENT
  , project_name varchar(100)
  , period_form DATE
  , period_to DATE
);


INSERT INTO member (
    member_id
  , member_name
  , member_rank
  , company_id
) VALUES
 (1,'山田太郎','A',1)
,(2,'鈴木次郎','B',2)
,(3,'田中花子です','B',2)
;


INSERT INTO companies (
    company_id
  , company_name
  , company_alias
) VALUES
 (1,'XXX株式会社','X')
,(2,'YYY.Inc','YYY')
,(3,'ZZZグループ','ZG')
;


INSERT INTO project (
    project_id
  , project_name
  , period_form
  , period_to
) VALUES
 (1,'A案件','2022-07-01','2022-07-31')
,(2,'B案件','2022-07-01','2022-09-20')
,(3,'C案件','2022-08-10','2022-09-30')
;