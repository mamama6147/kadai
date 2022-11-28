SET CHARSET UTF8;


CREATE DATABASE IF NOT EXISTS sample;

use sample;

drop table IF EXISTS member;
drop table IF EXISTS companies;
drop table IF EXISTS project;


create table IF not EXISTS member(
    member_id INT NOT NULL AUTO_INCREMENT
  , member_name varchar(100)
  , member_rank varchar(100)
  , company_id INT
  , PRIMARY KEY (member_id)
);


create table IF not EXISTS companies(
    company_id INT NOT NULL AUTO_INCREMENT
  , company_name varchar(100)
  , company_alias varchar(100)
  , PRIMARY KEY (company_id)
);


create table IF not EXISTS project(
    project_id INT NOT NULL AUTO_INCREMENT
  , project_name varchar(100)
  , period_from DATE
  , period_to DATE
  , PRIMARY KEY (project_id)
);

create table IF not EXISTS assign(
    project_id INT
  , member_id INT
  , step_number DECIMAL
);


INSERT INTO member (
    member_id
  , member_name
  , member_rank
  , company_id
) VALUES
 (1,'yamada','A',1)
,(2,'suzuki','B',2)
,(3,'田中','B',2)
;


INSERT INTO companies (
    company_id
  , company_name
  , company_alias
) VALUES
 (1,'XXX company','X')
,(2,'YYY.Inc','YYY')
,(3,'ZZZGr','ZG')
;


INSERT INTO project (
    project_id
  , project_name
  , period_from
  , period_to
) VALUES
 (1,'A project','2022-07-01','2022-07-31')
,(2,'B project','2022-07-01','2022-09-20')
,(3,'C project','2022-08-10','2022-09-30')
;