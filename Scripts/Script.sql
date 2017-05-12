-- 회사
DROP SCHEMA IF EXISTS ncs_erp;

-- 회사
CREATE SCHEMA ncs_erp;

-- 직책
CREATE TABLE title (
	tcode INT(11)     NOT NULL, -- 직책번호
	tname VARCHAR(10) null,      -- 직책명
	PRIMARY KEY (tcode)
);
-- 부서
CREATE TABLE department (
	dcode INT(11)  NOT NULL, -- 부서번호
	dname CHAR(10) NOT NULL, -- 부서명
	floor INT(11)  null,      -- 위치
	PRIMARY KEY (dcode)
);

-- 사원
CREATE TABLE employee (
	eno      INT(11)     NOT NULL, -- 사번
	ename    VARCHAR(20) NOT NULL, -- 사원명
	salary   INT(11)     NULL,     -- 급여
	dno      INT(11)     NULL,     -- 부서
	gender   TINYINT(1)  NULL,     -- 성별
	joindate DATE        NULL,     -- 입사일
	title    INT(11)     null,     -- 직책
	PRIMARY KEY (eno),
	FOREIGN KEY (title) REFERENCES title (tcode),
	FOREIGN KEY (dno) REFERENCES department (dcode)	
);

select*from title;
select*from department;
select*from employee;

insert into title(tcode,tname) values
(1,'사장'),(2,'부장'),(3,'과장'),(4,'대리'),(5,'사원');

insert into department(dcode,dname,floor) values
(1,'마케팅',10),(2,'개발',9),(3,'인사',6),(4,'총무',7),(5,'경영',4);

insert into employee(eno,ename,salary,dno,gender,joindate,title) values
(17001,'나사장',5000000,5,1,'2017-03-01',1),
(17002,'나부장',4000000,1,1,'2017-03-01',2),
(17003,'너부장',4000000,2,0,'2017-03-01',2),
(17004,'나과장',3500000,1,1,'2017-03-01',3),
(17005,'너과장',3500000,2,0,'2017-03-01',3),
(17006,'나대리',3000000,1,1,'2017-03-01',4),
(17007,'너대리',3000000,2,0,'2017-03-01',4),
(17008,'나사원',2500000,1,1,'2017-03-01',5),
(17009,'그사원',2000000,1,0,'2017-03-01',5),
(17010,'너사원',2500000,2,1,'2017-03-01',5),
(17011,'이사원',2000000,3,0,'2017-03-01',5);

select count(*) as isExists from information_schema.SCHEMATA where SCHEMA_NAME = 'ncs_erp';
select count(*) as isExists from information_schema.TABLES where TABLE_SCHEMA = 'ncs_erp' and TABLE_NAME='title';


Select tcode, tname from title;
select*from department;

UPDATE ncs_erp.department
SET dname='', floor=0
WHERE dcode=0;

select dcode, dname, floor from department;

SELECT eno, ename, salary, dno, gender, joinDate, title, t.tcode, t.tname , d.dcode,d.dname,d.floor 
FROM employee e join title t on e.title=t.tcode join department d on e.dno=d.dcode;