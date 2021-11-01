/* 관리자 */
DROP TABLE manager 
	CASCADE CONSTRAINTS;

/* 교수 */
DROP TABLE professor 
	CASCADE CONSTRAINTS;

/* 학생 */
DROP TABLE student 
	CASCADE CONSTRAINTS;

/* 학과 */
DROP TABLE department 
	CASCADE CONSTRAINTS;

/* 강의 */
DROP TABLE subject 
	CASCADE CONSTRAINTS;

/* 수강 */
DROP TABLE register 
	CASCADE CONSTRAINTS;

/* 공지사항 */
DROP TABLE Notice 
	CASCADE CONSTRAINTS;

/* 관리자 */
CREATE TABLE manager (
	id NUMBER NOT NULL, /* 아이디 */
	name VARCHAR(50), /* 이름 */
	password VARCHAR(50), /* 비밀번호 */
	tel VARCHAR(30), /* 연락처 */
	email VARCHAR(40), /* 이메일 */
	address VARCHAR(255) /* 주소 */
);

ALTER TABLE manager
	ADD
		CONSTRAINT PK_manager
		PRIMARY KEY (
			id
		);

/* 교수 */
CREATE TABLE professor (
	pno VARCHAR(50) NOT NULL, /* 교수아이디 */
	password VARCHAR(50), /* 비밀번호 */
	Major VARCHAR(50), /* 교수전공 */
	name VARCHAR(50), /* 교수이름 */
	COL2 BLOB, /* 교수사진 */
	state VARCHAR(50),  /*교수상태*/
	address VARCHAR(255), /* 교수주소 */
	pro_room VARCHAR(255), /* 연구실위치 */
	tel VARCHAR(30), /* 교수전화번호 */
	email VARCHAR(40), /* 교수이메일 */
	dno NUMBER /* 학과번호 */
);

ALTER TABLE professor
	ADD
		CONSTRAINT PK_professor
		PRIMARY KEY (
			pno
		);

/* 학생 */
CREATE TABLE student (
	sno NUMBER NOT NULL, /* 학번(ID) */
	password VARCHAR(50), /* 비밀번호 */
	name VARCHAR(50), /* 학생이름 */
	grade NUMBER, /* 학년 */
	year NUMBER, /* 입학년도 */
	address VARCHAR(255), /* 학생주소 */
	tel VARCHAR(30), /* 학생전화번호 */
	email VARCHAR(40), /* 학생이메일 */
	state VARCHAR(50), /* 재학상태 */
	dno NUMBER /* 학과번호 */
);

ALTER TABLE student
	ADD
		CONSTRAINT PK_student
		PRIMARY KEY (
			sno
		);

/* 학과 */
CREATE TABLE department (
	dno NUMBER NOT NULL, /* 학과번호 */
	name VARCHAR(50), /* 학과명 */
	tel VARCHAR(30) /* 학과전화번호 */
);

ALTER TABLE department
	ADD
		CONSTRAINT PK_department
		PRIMARY KEY (
			dno
		);

/* 강의 */
CREATE TABLE subject (
	subno VARCHAR(50) NOT NULL, /* 강의코드 */
	name VARCHAR(50), /* 강의명 */
	grade NUMBER, /* 학년 */
	score VARCHAR(255), /* 학점 */
	people NUMBER, /* 인원수 */
	room VARCHAR(255), /* 강의실 */
	subtime VARCHAR(50), /* 강의시간 */
	state VARCHAR(50), /* 상태 */
	startday DATE, /* 개강날 */
	endday DATE, /* 종강날 */
	division VARCHAR(50), /* 강의구분 */
	dno NUMBER, /* 학과번호 */
	pno VARCHAR(50) /* 교수아이디 */
);

ALTER TABLE subject
	ADD
		CONSTRAINT PK_subject
		PRIMARY KEY (
			subno
		);

/* 수강 */
CREATE TABLE register (
	regno NUMBER NOT NULL, /* 수강번호 */
	year NUMBER, /* 년도 */
	semester NUMBER, /* 학기 */
	score VARCHAR(255), /* 성적 */
	sno NUMBER, /* 학번(ID) */
	subno VARCHAR(50) /* 강의코드 */
);

ALTER TABLE register
	ADD
		CONSTRAINT PK_register
		PRIMARY KEY (
			regno
		);

/* 공지사항 */
CREATE TABLE Notice (
	Nno NUMBER NOT NULL, /* 번호 */
	time DATE, /* 작성일자 */
	division VARCHAR(50), /* 공지구분 */
	subject VARCHAR(50), /* 제목 */
	contents VARCHAR(50), /* 내용 */
	views NUMBER, /* 조회수 */
	id NUMBER /* 아이디 */
);

ALTER TABLE Notice
	ADD
		CONSTRAINT PK_Notice
		PRIMARY KEY (
			Nno
		);

ALTER TABLE professor
	ADD
		CONSTRAINT FK_department_TO_professor
		FOREIGN KEY (
			dno
		)
		REFERENCES department (
			dno
		);

ALTER TABLE student
	ADD
		CONSTRAINT FK_department_TO_student
		FOREIGN KEY (
			dno
		)
		REFERENCES department (
			dno
		);

ALTER TABLE subject
	ADD
		CONSTRAINT FK_department_TO_subject
		FOREIGN KEY (
			dno
		)
		REFERENCES department (
			dno
		);

ALTER TABLE subject
	ADD
		CONSTRAINT FK_professor_TO_subject
		FOREIGN KEY (
			pno
		)
		REFERENCES professor (
			pno
		);

ALTER TABLE register
	ADD
		CONSTRAINT FK_student_TO_register
		FOREIGN KEY (
			sno
		)
		REFERENCES student (
			sno
		);

ALTER TABLE register
	ADD
		CONSTRAINT FK_subject_TO_register
		FOREIGN KEY (
			subno
		)
		REFERENCES subject (
			subno
		);

ALTER TABLE Notice
	ADD
		CONSTRAINT FK_manager_TO_Notice
		FOREIGN KEY (
			id
		)
		REFERENCES manager (
			id
		);
		
		
		
		
		
		
		
------------
select * from department;
insert into department values(1,'컴퓨터공학과','1234-5678');
insert into department values(2,'기계공학과','9123-4567');

select * from student;

insert into student values('20210101','1234','김학생',1,2021,'지구상 어딘가','010-1234-5678','kim@naver.com','재학',1);
insert into student values('20210102','1234','이학생',1,2021,'지구상 어딘가','010-1234-5678','lee@naver.com','재학',1);
insert into student values('20210103','1234','박학생',1,2021,'지구상 어딘가','010-1236-2138','axcqw@naver.com','재학',1);
insert into student values('20210104','1234','최학생',1,2021,'지구상 어딘가','010-5345-3807','asdczv@naver.com','재학',1);
insert into student values('20210105','1234','명학생',1,2021,'지구상 어딘가','010-1234-3388','zcxvzxc@naver.com','재학',1);
insert into student values('20210106','1234','문학생',2,2021,'지구상 어딘가','010-3978-7805','leasdae@naver.com','재학',2);
insert into student values('20210107','1234','정학생',2,2021,'지구상 어딘가','010-1208-5555','zxcvz@naver.com','재학',2);
insert into student values('20210108','1234','임학생',2,2021,'지구상 어딘가','010-9365-6666','zxc@naver.com','재학',2);
insert into student values('20210109','1234','도학생',2,2021,'지구상 어딘가','010-7308-7560','kiasdqwem@naver.com','재학',2);
insert into student values('20210110','1234','장학생',2,2021,'지구상 어딘가','010-2378-6865','zxcvag@naver.com','재학',2);

insert into student values(20210101,'1234','김학생',1,2021,'지구상 어딘가','010-1234-5678','kim@naver.com','재학',1);
insert into student values(20210102,'1234','이학생',1,2021,'지구상 어딘가','010-1234-5678','lee@naver.com','재학',1);



insert into student values(?,?,?,?,?,?,?,?,'재학',1);

select sno, password, name, grade ,year, address, tel, email, state, dno from student

select sno, password, name, grade ,year, address, tel, email, state, dno from student where sno =?




Select s.sno, d.name, s.name, s.password , s.tel, s.email, s.address from student s ,department d where sno= '20210101';

Select s.sno, d.name as dname, s.name as sname, s.password , s.tel, s.email, s.address from student s ,department d where sno = '20210101'

select s.*, d.name as dname from student s, department d where sno = '20210101'
update student set state = '휴학' where sno='20210101'

Select p.pno, p.name, d.name, p.major, p.tel ,p.state from professor p , department d where p.dno= d.dno ;

insert into professor values('p001','p001','정보통신','김교수',null,'재직','지구상 어딘가','B501','010-1234-5678','tyyn@naver.com',1);
insert into professor values('p002','p002','정보통신','이교수',null,'재직','지구상 어딘가','B502','010-5623-7753','afdvjk@naver.com',1);
insert into professor values('p003','p003','인공지능','박교수',null,'재직','지구상 어딘가','B503','010-4786-1123','asfbikjq@naver.com',1);
insert into professor values('p004','p004','인공지능','최교수',null,'재직','지구상 어딘가','B504','010-8990-7831','asdscj@naver.com',1);

<<<<<<< HEAD
delete from professor where pno = 'p001'
delete from professor where pno = 'p002'
delete from professor where pno = 'p003'
delete from professor where pno = 'p004'

pno VARCHAR(50) NOT NULL, /* 교수아이디 */
	password VARCHAR(50), /* 비밀번호 */
	Major VARCHAR(50), /* 교수전공 */
	name VARCHAR(50), /* 교수이름 */
	COL2 BLOB, /* 교수사진 */
	state VARCHAR(50),  /*교수상태*/
	address VARCHAR(255), /* 교수주소 */
	pro_room VARCHAR(255), /* 연구실위치 */
	tel VARCHAR(30), /* 교수전화번호 */
	email VARCHAR(40), /* 교수이메일 */
	dno NUMBER /* 학과번호 */
=======
select * from student
select * from professor 
=======
>>>>>>> branch 'main' of https://github.com/academy-management/management.git
insert into professor values('p001','p001','정보통신','김교수',null,'재직','지구상, 어딘가','B501','010-1234-5678','tyyn@naver.com',1);
insert into professor values('p002','p002','정보통신','이교수',null,'재직','지구상, 어딘가','B502','010-5623-7753','afdvjk@naver.com',1);
insert into professor values('p003','p003','인공지능','박교수',null,'재직','지구상, 어딘가','B503','010-4786-1123','asfbikjq@naver.com',1);
insert into professor values('p009','9999','인공지능','최교수',null,'재직','지구상, 어딘가','B504','010-8990-7831','asdscj@naver.com',1);

Select p.pno, p.name, d.name as d_name , p.major, p.tel ,p.state from professor p , department d where p.dno= d.dno and p.name = '%이%' and d.name like '%%' order by pno desc


	
select s.name, s.score, s.startday, s.endday, r.score from register r, subject s where r.year= 2021 and r.semester = 1;
select s.name, s.score, s.startday, s.endday, r.score from register r, subject s where r.year= ? and r.semester = ?;
insert into subject values('c0001', '컴퓨터공학개론', 1, '3', 30, 'A관 101호', '월 1-3', '강의', sysdate, sysdate, '전공', 1, 'p001');
insert into subject values('c0002', '기초 프로그래밍', 1, '3', 30, 'A관 101호', '월 1-3', '강의', sysdate, sysdate, '전공', 1, 'p001');
insert into register values(201, 2021, 1, 80, '20210101', 'c0001');

select * from SUBJECT
insert into student values('20210101','1234','김학생',1,2021,'지구상 어딘가','010-1234-5678','kim@naver.com','재학',1);
insert into student values('20210102','1234','이학생',1,2021,'지구상 어딘가','010-1234-5678','lee@naver.com','재학',1);
insert into student values('20210103','1234','박학생',1,2021,'지구상 어딘가','010-1236-2138','axcqw@naver.com','재학',1);
insert into student values('20210104','1234','최학생',1,2021,'지구상 어딘가','010-5345-3807','asdczv@naver.com','재학',1);
insert into student values('20210105','1234','명학생',1,2021,'지구상 어딘가','010-1234-3388','zcxvzxc@naver.com','재학',1);
insert into student values('20210106','1234','문학생',2,2021,'지구상 어딘가','010-3978-7805','leasdae@naver.com','재학',2);
insert into student values('20210107','1234','정학생',2,2021,'지구상 어딘가','010-1208-5555','zxcvz@naver.com','재학',2);
insert into student values('20210108','1234','임학생',2,2021,'지구상 어딘가','010-9365-6666','zxc@naver.com','재학',2);
insert into student values('20210109','1234','도학생',2,2021,'지구상 어딘가','010-7308-7560','kiasdqwem@naver.com','재학',2);

insert into REGISTER values(1, 2021, 2, 'A+', 20210101, 'c0001')

select distinct re.regno, s.sno, s.name, d.name as dname, s.grade, re.score from student s, REGISTER re, DEPARTMENT d, subject su where re.sno = s.sno and s.dno = d.dno and re.subno = 'c0001'



insert into Notice values(1, '2021/10/21','전체','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(2, '2021/10/21','학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(3, '2021/10/21','학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(4, '2021/10/21','학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(9, '2021/10/21','컴퓨터공학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(6, '2021/10/21','전체','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(7, '2021/10/21','전체','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);

insert into manager values(1,'매니저','1234','010-5664-4455','asd@naver.com','asd');


update subject set name = '인공지능' , grade = 2 , score = 2 , room = '301호' , people =20, subtime = '월요일 6-7' , startday= sysdate, endday=sysdate, state= '강의' where subno = 'c0002' 

select * from manager
select * from notice
select * from subject;
>>>>>>> refs/remotes/origin/main

insert into SUBJECT values(?,?,?,?,?,?,?,'강의',?,?,?,?,?);

select s.subno , s.name , p.name , s.score , s.subtime , s.state from subject s,professor p where s.pno= p.pno and s.name like ? and p.name like ?;
select s.subno , s.name , p.name as p_name , s.score , s.subtime , s.state from subject s,professor p where s.pno= p.pno and s.name like '%%' and p.name like '%%' order by s.pno desc



-------------------
insert into Notice values(seqnotice.nextval, '2021-10-20','전체','신입생, 편입생 공지 드립니다.','내용입니다.',1,01);
insert into Notice values(seqnotice.nextval, '2021/10/21','전체','신입생, 편입생 공지 드립니다.','내용입니다.',1,01);
select * from subject;
delete from memo where Nno = 1;

	
select Nno, time, subject, views
from (select rownum rn, memos.* from (select * from Notice order by Nno desc) Notices)
where rn between ? and ?;	
	
select memoid, name, age from memo where memoid= ?

select Nno, subject, time, views from Notice where Nno=?

select Nno, subject, time, views from Notice
select * from professor
	
----------------------
update student set name = ?, password =? , tel=?, email= ?, address=?; where sno= ?

select s.*, d.name as dname from student s, department d where s.year like '%' || 20

-------------------------

select s.name, s.score, s.startday, s.endday, p.name, r.score  from register r, subject s , professor p where r.subno = s.subno and s.dno = p.dno;
select s.name, s.score, s.startday, s.endday, p.name, r.score  from register r, subject s , professor p where r.subno = s.subno;


<<<<<<< HEAD
select s.name as sname, r.semester as semester, s.startday as startday, s.endday as endday, p.name as pname, s.state as state from register r, subject s , professor p where r.subno = s.subno and s.dno = p.dno
select s.name as sname, s.score as score, s.startday as startday, s.endday as endday, p.name as pname, r.score as rscore from register r, subject s , professor p where r.year =? and r.semester =?
select s.name as sname, s.score as score, s.startday as startday, s.endday as endday, p.name as pname, r.score as rscore from register r, subject s , professor p where r.year =2021 and r.semester =1
=======
select s.name as sname, s.score as score, s.startday as startday, s.endday as endday, p.name as pname, r.score as rscore from register r, subject s , professor p where r.subno = s.subno and s.dno = p.dno
select s.name as sname, s.score as score, s.startday as startday, s.endday as endday, p.name as pname, r.score as rscore from register r, subject s , professor p where r.year =? and r.semester =?
select s.name as sname, s.score as score, s.startday as startday, s.endday as endday, p.name as pname, r.score as rscore from register r, subject s , professor p where r.year =2021 and r.semester =1

create sequence seq_notice;
>>>>>>> branch 'main' of https://github.com/academy-management/management.git



<<<<<<< HEAD
select s.name as sname, r.semester as semester, s.startday as startday, s.endday as endday, p.name as pname, s.state as state from register r, subject s , professor p where r.sno = ?


create sequence seqnotice;




-- 학과 데이터 2개 컴퓨터공학과, 기계공학과
insert into department values(1,'컴퓨터공학과','1234-5678');
insert into department values(2,'기계공학과','9123-4567');

-- 학생 데이터 아이디 20210101, 비밀번호 1234 김학생
insert into student values('20210101','1234','김학생',1,2021,'지구상 어딘가','010-1234-5678','kim@naver.com','재학',1);
insert into student values('20210102','1234','이학생',1,2021,'지구상 어딘가','010-1234-5678','lee@naver.com','재학',1);
insert into student values('20210103','1234','박학생',1,2021,'지구상 어딘가','010-1236-2138','axcqw@naver.com','재학',1);
insert into student values('20210104','1234','최학생',1,2021,'지구상 어딘가','010-5345-3807','asdczv@naver.com','재학',1);
insert into student values('20210105','1234','명학생',1,2021,'지구상 어딘가','010-1234-3388','zcxvzxc@naver.com','재학',1);
insert into student values('20210106','1234','문학생',2,2021,'지구상 어딘가','010-3978-7805','leasdae@naver.com','재학',2);
insert into student values('20210107','1234','정학생',2,2021,'지구상 어딘가','010-1208-5555','zxcvz@naver.com','재학',2);
insert into student values('20210108','1234','임학생',2,2021,'지구상 어딘가','010-9365-6666','zxc@naver.com','재학',2);
insert into student values('20210109','1234','도학생',2,2021,'지구상 어딘가','010-7308-7560','kiasdqwem@naver.com','재학',2);
insert into student values('20210110','1234','장학생',2,2021,'지구상 어딘가','010-2378-6865','zxcvag@naver.com','재학',2);

-- 교수 데이터 , 아이디 p001, 비번 p001 김교수
insert into professor values('p001','p001','정보통신','김교수',null,'재직','지구상 어딘가','B501','010-1234-5678','tyyn@naver.com',1);
insert into professor values('p002','p002','정보통신','이교수',null,'재직','지구상 어딘가','B502','010-5623-7753','afdvjk@naver.com',1);
insert into professor values('p003','p003','인공지능','박교수',null,'재직','지구상 어딘가','B503','010-4786-1123','asfbikjq@naver.com',1);
insert into professor values('p004','p004','인공지능','최교수',null,'재직','지구상 어딘가','B504','010-8990-7831','asdscj@naver.com',1);

-- 관리자 아이디 1 비밀번호 1234 이름 매니저
insert into manager values(1,'매니저','1234','010-5664-4455','asd@naver.com','asd');

-- 강의 데이터 3개 , 김교수가 강의하는 강의 데이터 2개
insert into subject values('c0001', '컴퓨터공학개론', 1, '3', 30, 'A관 101호', '월 1-3', '강의', sysdate, sysdate, '전공', 1, 'p001');
insert into subject values('c0002', '기초 프로그래밍', 1, '3', 30, 'B관 101호', '월 1-3', '강의', sysdate, sysdate, '전공', 1, 'p001');
insert into subject values('c0003', '자바 프로그래밍', 1, '3', 30, 'C관 101호', '월 1-3', '강의', sysdate, sysdate, '전공', 1, 'p002');

-- 수강 데이터 , 20210101(김학생)이  수강하고 있음,
insert into register values(1, 2021, 1, 50, '20210101', 'c0002');
insert into register values(2, 2021, 1, 60, '20210101', 'c0003');
insert into register values(3, 2021, 1, 70, '20210101', 'c0001');

-- 공지사항 데이터 
insert into Notice values(1, '2021/10/21','전체','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(2, '2021/10/21','학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(3, '2021/10/21','학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(4, '2021/10/21','학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(9, '2021/10/21','컴퓨터공학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(6, '2021/10/21','전체','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(7, '2021/10/21','전체','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);


select s.name as sname, r.semester as semester, s.startday as startday, s.endday as endday, p.name as pname, s.state as state from register r, subject s , professor p, student st where r.sno = st.sno
select * from register
select * from 

select p.dno as dno,  from professor p, department d where p.dno = d.dno;
=======

-- 학과 데이터 2개 컴퓨터공학과, 기계공학과
insert into department values(1,'컴퓨터공학과','1234-5678');
insert into department values(2,'기계공학과','9123-4567');

-- 학생 데이터 아이디 20210101, 비밀번호 1234 김학생
insert into student values('20210101','1234','김학생',1,2021,'지구상 어딘가','010-1234-5678','kim@naver.com','재학',1);
insert into student values('20210102','1234','이학생',1,2021,'지구상 어딘가','010-1234-5678','lee@naver.com','재학',1);
insert into student values('20210103','1234','박학생',1,2021,'지구상 어딘가','010-1236-2138','axcqw@naver.com','재학',1);
insert into student values('20210104','1234','최학생',1,2021,'지구상 어딘가','010-5345-3807','asdczv@naver.com','재학',1);
insert into student values('20210105','1234','명학생',1,2021,'지구상 어딘가','010-1234-3388','zcxvzxc@naver.com','재학',1);
insert into student values('20210106','1234','문학생',2,2021,'지구상 어딘가','010-3978-7805','leasdae@naver.com','재학',2);
insert into student values('20210107','1234','정학생',2,2021,'지구상 어딘가','010-1208-5555','zxcvz@naver.com','재학',2);
insert into student values('20210108','1234','임학생',2,2021,'지구상 어딘가','010-9365-6666','zxc@naver.com','재학',2);
insert into student values('20210109','1234','도학생',2,2021,'지구상 어딘가','010-7308-7560','kiasdqwem@naver.com','재학',2);
insert into student values('20210110','1234','장학생',2,2021,'지구상 어딘가','010-2378-6865','zxcvag@naver.com','재학',2);
select * from student
-- 교수 데이터 , 아이디 p001, 비번 p001 김교수
insert into professor values('p001','p001','정보통신','김교수',null,'재직','지구상,어딘가','B501','010-1234-5678','tyyn@naver.com',1);
insert into professor values('p002','p002','정보통신','이교수',null,'재직','지구상,어딘가','B502','010-5623-7753','afdvjk@naver.com',1);
insert into professor values('p003','p003','인공지능','박교수',null,'재직','지구상,어딘가','B503','010-4786-1123','asfbikjq@naver.com',1);
insert into professor values('p004','p004','인공지능','최교수',null,'재직','지구상,어딘가','B504','010-8990-7831','asdscj@naver.com',1);
insert into professor values('p005','p005','기계설계','장교수',null,'재직','지구상,어딘가','B504','010-8220-7831','asdscj@naver.com',2);
select dno from professor

-- 관리자 아이디 1 비밀번호 1234 이름 매니저
insert into manager values(1,'매니저','1234','010-5664-4455','asd@naver.com','asd');
select * from register
-- 강의 데이터 3개 , 김교수가 강의하는 강의 데이터 2개

insert into subject values('c0001', '컴퓨터공학개론', 1, '3', 30, 'A관 101호', '월 1-3', '강의', sysdate, sysdate, '전공', 1, 'p001');
insert into subject values('c0002', '기초 프로그래밍', 1, '3', 30, 'B관 101호', '월 1-3', '강의', sysdate, sysdate, '전공', 1, 'p001');
insert into subject values('c0003', '자바 프로그래밍', 1, '3', 30, 'C관 101호', '월 1-3', '강의', sysdate, sysdate, '전공', 1, 'p002');
select * from subject			register.subno = subjcet.subno  , subject.pno =professor .pno
-- 수강 데이터 , 20210101(김학생)이  수강하고 있음,
insert into register values(1, 2021, 1, 50, '20210101', 'c0002');
insert into register values(2, 2021, 1, 60, '20210101', 'c0003');
insert into register values(3, 2021, 1, 70, '20210101', 'c0001');

-- 공지사항 데이터 
insert into Notice values(1, '2021/10/21','전체','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(2, '2021/10/21','학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(3, '2021/10/21','학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(4, '2021/10/21','학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(9, '2021/10/21','컴퓨터공학과','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(6, '2021/10/21','전체','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);
insert into Notice values(7, '2021/10/21','전체','신입생, 편입생 공지 드립니다.','내용입니다.',1,1);


create sequence REG_SEQ

select * from register

select distinct re.regno, s.sno, s.name, d.name as dname, s.grade, re.score from student s, REGISTER re, DEPARTMENT d, subject su where re.sno = s.sno and s.dno = d.dno and re.subno = 'c0003'
select s.*, d.*, d.name as dname from student s, department d where s.dno = d.dno order by sno desc
 select s.*, d.*, d.name as dname from student s, department d where s.dno = d.dno and d.name='컴퓨터공학과' order by sno desc ;
select s.sno, s.name,  s.year , d.name as dname, s.tel, s.state from student s ,department d where s.dno = d.dno and d.name='컴퓨터공학과';
select s.*, d.*, d.name as dname from student s, department d where s.dno = d.dno and s.year like '%' || 2021 order by sno desc
select s.*, d.*, d.name as dname from student s, department d where s.dno = d.dno and s.name like '%' || '김' || '%' order by sno desc
select distinct re.regno, s.sno, s.name, d.name as dname, s.grade, re.score, re.subno, su.name as subname from student s, REGISTER re, DEPARTMENT d, subject su where re.sno = s.sno and s.dno = d.dno and re.subno = su.subno

select s.pno, s.subno , s.name , p.name as p_name, s.startday, s.endday, s.score , s.subtime , s.state from subject s,professor p where s.pno= p.pno and s.pno = 'p002' order by s.pno desc

select distinct s.*, s.dno as s_dno, p.dno as p_dno from student s, professor p where s.dno = p.dno and p.dno = 1
select distinct s.*, s.dno as s_dno, p.dno as p_dno, d.name as dname from student s, professor p, department d where s.dno = p.dno and s.dno = d.dno and p.dno = 1 and s.year like '%' || 2021 order by sno desc
select distinct s.*, s.dno as s_dno, p.dno as p_dno, d.name as dname from student s, professor p, department d where s.dno = p.dno and s.dno = d.dno and p.dno = 1 and s.name like '%' || '김' || '%' order by sno desc
select distinct s.*, s.dno as s_dno, p.dno as p_dno from student s, professor p where s.dno = p.dno and p.dno = 1

select s.name as sname, s.score as score, s.startday as startday, s.endday as endday, p.name as pname, r.score as rscore from register r, subject s , professor p where r.subno = s.subno  and s.pno =p.pno

select pno,address from professor
Select s.sno, d.name as d_name, s.name, s.password , s.tel, s.email, s.address ,s.dno from student s ,department d where s.dno=d.dno and sno = ?
select * from register

select s.name as sname, r.semester as semester, to_char(s.startday, 'YYYY.MM.DD') as startday, to_char(s.endday, 'YYYY.MM.DD') as endday, p.name as pname, r.score as rscore from register r, subject s , professor p where r.subno = s.subno  and s.pno =p.pno  and r.year = 2021 and r.semester = 2 and r.sno='20' 

select s.name as sname, r.semester as semester, to_char(s.startday, 'YYYY.MM.DD') as startday, to_char(s.endday, 'YYYY.MM.DD') as endday, p.name as pname, r.score as rscore ,r.regno from register r, subject s , professor p where r.subno = s.subno  and s.pno =p.pno  and r.year = 2021 and r.semester = 2 and r.sno='20210101'

select * from student

select * from subject;

--강의 테이블 1,2,3,4 컴공 10개, 경영학과 5개, 화학과 5개 교양수업10개
insert into subject values('c0001', '컴퓨터공학개론1반', 1, '3', 30, 'B관 101호', '월 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0002', '컴퓨터공학개론2반', 1, '3', 30, 'B관 101호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0003', '기초 프로그래밍1반', 1, '2', 30, 'B관 102호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p002');
insert into subject values('c0004', '기초 프로그래밍2반', 1, '2', 30, 'B관 102호', '수 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p002');
insert into subject values('c0005', '자바 프로그래밍', 1, '3', 30, 'B관 301호', '수 2-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p003');
insert into subject values('c0006', 'C프로그래밍', 1, '3', 30, 'B관 501호', '월 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p004');
insert into subject values('c0007', '이산수학', 1, '3', 30, 'B관 401호', '목 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p005');
insert into subject values('c0008', '이산수학', 1, '3', 30, 'B관 401호', '금 2-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p005');
insert into subject values('c0009', '논리회로설계1반', 1, '3', 30, 'A관 101호', '화 3-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0010', '논리회로설계2반', 1, '3', 30, 'A관 101호', '금 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');

insert into subject values('c0011', '자료구조1반', 2, '3', 30, 'B관 101호', '월 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0012', '자료구조2반', 2, '3', 30, 'B관 101호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0013', '컴퓨터구조1반', 2, '2', 30, 'B관 102호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p002');
insert into subject values('c0014', '컴퓨터구조2반', 2, '2', 30, 'B관 102호', '수 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p002');
insert into subject values('c0015', '리눅스', 2, '3', 30, 'B관 301호', '수 2-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p003');
insert into subject values('c0016', 'C프로그래밍2', 2, '3', 30, 'B관 501호', '월 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p004');
insert into subject values('c0017', '데이터베이스1반', 2, '3', 30, 'B관 401호', '목 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p005');
insert into subject values('c0018', '데이터베이스2반', 2, '3', 30, 'B관 401호', '금 2-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p005');
insert into subject values('c0019', '자바 프로그래밍2 1반', 2, '3', 30, 'A관 101호', '화 3-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0020', '자바 프로그래밍2 2반', 2, '3', 30, 'A관 101호', '금 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');

insert into subject values('c0021', '임베디드 1반', 3, '3', 30, 'B관 101호', '월 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0022', '임베디드 2반', 3, '3', 30, 'B관 101호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0023', '네트워크 1반', 3, '2', 30, 'B관 102호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p002');
insert into subject values('c0024', '네트워크 2반', 3, '2', 30, 'B관 102호', '수 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p002');
insert into subject values('c0025', '운영체제', 3, '3', 30, 'B관 301호', '수 2-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p003');
insert into subject values('c0026', '소프트웨어', 3, '3', 30, 'B관 501호', '월 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p004');
insert into subject values('c0027', '데이터베이스 1반', 3, '3', 30, 'B관 401호', '목 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p005');
insert into subject values('c0028', '데이터베이스 2반', 3, '3', 30, 'B관 401호', '금 2-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p005');
insert into subject values('c0029', '데이터통신 1반', 3, '3', 30, 'A관 101호', '화 3-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0030', '데이터통신 2반', 3, '3', 30, 'A관 101호', '금 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');

insert into subject values('c0031', '전자회로 1반', 4, '3', 30, 'B관 101호', '월 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0032', '전자회로 2반', 4, '3', 30, 'B관 101호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0033', '인공지능 1반', 4, '2', 30, 'B관 102호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p002');
insert into subject values('c0034', '인공지능 2반', 4, '2', 30, 'B관 102호', '수 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p002');
insert into subject values('c0035', '양자 컴퓨팅 및 정보의 기초', 4, '3', 30, 'B관 301호', '수 2-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p003');
insert into subject values('c0036', '딥러닝', 4, '3', 30, 'B관 501호', '월 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p004');
insert into subject values('c0037', '블록체인 1반', 4, '3', 30, 'B관 401호', '목 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p005');
insert into subject values('c0038', '블록체인 2반', 4, '3', 30, 'B관 401호', '금 2-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p005');
insert into subject values('c0039', '인터넷보안 1반', 4, '3', 30, 'A관 101호', '화 3-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');
insert into subject values('c0040', '인터넷보안 2반', 4, '3', 30, 'A관 101호', '금 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 1, 'p001');


insert into subject values('b0001', '회계학', 1, '3', 30, 'B관 101호', '월 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p006');
insert into subject values('b0002', '회계학', 1, '3', 30, 'B관 101호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p006');
insert into subject values('b0003', '재무관리', 1, '2', 30, 'B관 102호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공',2, 'p007');
insert into subject values('b0004', '재무관리', 1, '2', 30, 'B관 102호', '수 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p007');
insert into subject values('b0005', '마케팅', 1, '3', 30, 'B관 301호', '수 2-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p008');
insert into subject values('b0006', '인사·조직', 1, '3', 30, 'B관 501호', '월 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p009');
insert into subject values('b0007', 'MS/OM(생산운영관리)', 1, '3', 30, 'B관 401호', '목 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p010');
insert into subject values('b0008', 'MS/OM(생산운영관리)', 1, '3', 30, 'B관 401호', '금 2-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p010');
insert into subject values('b0009', '계량경영', 1, '3', 30, 'A관 101호', '화 3-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p006');
insert into subject values('b0010', '계량경영', 1, '3', 30, 'A관 101호', '금 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p006');

insert into subject values('b0011', '경영정보시스템', 2, '3', 30, 'B관 101호', '월 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p006');
insert into subject values('b0012', '경영정보시스템', 2, '3', 30, 'B관 101호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p006');
insert into subject values('b0013', '국제경영', 2, '2', 30, 'B관 102호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p007');
insert into subject values('b0014', '국제경영', 2, '2', 30, 'B관 102호', '수 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p007');
insert into subject values('b0015', '경영전략 ', 2, '3', 30, 'B관 301호', '수 2-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p008');
insert into subject values('b0016', '파이낸스', 2, '3', 30, 'B관 501호', '월 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p009');
insert into subject values('b0017', 'SSOM', 2, '3', 30, 'B관 401호', '목 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p010');
insert into subject values('b0018', 'SSOM', 2, '3', 30, 'B관 401호', '금 2-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p010');
insert into subject values('b0019', 'CSR', 2, '3', 30, 'A관 101호', '화 3-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p006');
insert into subject values('b0020', 'CSR', 2, '3', 30, 'A관 101호', '금 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 2, 'p006');


insert into subject values('d0001', '미적분학및연습', 1, '3', 30, 'B관 101호', '월 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p011');
insert into subject values('d0002', '미적분학및연습', 1, '3', 30, 'B관 101호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p011');
insert into subject values('d0003', '일반화학및연습', 1, '2', 30, 'B관 102호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공',3, 'p012');
insert into subject values('d0004', '일반화학및연습', 1, '2', 30, 'B관 102호', '수 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p012');
insert into subject values('d0005', '일반물리학및연습', 1, '3', 30, 'B관 301호', '수 2-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p013');
insert into subject values('d0006', '물리화학 I', 2, '3', 30, 'B관 501호', '월 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p014');
insert into subject values('d0007', '유기화학 I', 2, '3', 30, 'B관 401호', '목 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p015');
insert into subject values('d0008', '유기화학 I',2, '3', 30, 'B관 401호', '금 2-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p015');
insert into subject values('d0009', '분석화학 I', 2, '3', 30, 'A관 101호', '화 3-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p011');
insert into subject values('d0010', '분석화학 I', 2, '3', 30, 'A관 101호', '금 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p011');

insert into subject values('d0011', '양자화학', 3, '3', 30, 'B관 101호', '월 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p011');
insert into subject values('d0012', '양자화학', 3, '3', 30, 'B관 101호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p011');
insert into subject values('d0013', '유기화학 II', 3, '2', 30, 'B관 102호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p012');
insert into subject values('d0014', '유기화학 II', 3, '2', 30, 'B관 102호', '수 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p012');
insert into subject values('d0015', '분석화학 II ', 3, '3', 30, 'B관 301호', '수 2-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p013');
insert into subject values('d0016', '물리화학 III', 3, '3', 30, 'B관 501호', '월 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p014');
insert into subject values('d0017', '의약화학', 4, '3', 30, 'B관 401호', '목 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p015');
insert into subject values('d0018', '의약화학', 4, '3', 30, 'B관 401호', '금 2-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p015');
insert into subject values('d0019', '나노화학', 4, '3', 30, 'A관 101호', '화 3-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p011');
insert into subject values('d0020', '나노화학', 4, '3', 30, 'A관 101호', '금 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '전공', 3, 'p011');


insert into subject values('a0001', '교양타악실기', 1, '3', 30, 'B관 101호', '월 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p011');
insert into subject values('a0002', '교양타악실기', 1, '3', 30, 'B관 101호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p011');
insert into subject values('a0003', '교양댄스스포츠', 1, '2', 30, 'B관 102호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양',1, 'p012');
insert into subject values('a0004', '교양댄스스포츠', 1, '2', 30, 'B관 102호', '수 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양',1, 'p012');
insert into subject values('a0005', '교양골프', 1, '3', 30, 'B관 301호', '수 2-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p013');
insert into subject values('a0006', '교양윈드써핑', 2, '3', 30, 'B관 501호', '월 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p014');
insert into subject values('a0007', '교양수영', 2, '3', 30, 'B관 401호', '목 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p015');
insert into subject values('a0008', '교양수영',2, '3', 30, 'B관 401호', '금 2-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p015');
insert into subject values('a0009', '교양축구', 2, '3', 30, 'A관 101호', '화 3-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p011');
insert into subject values('a0010', '교양축구', 2, '3', 30, 'A관 101호', '금 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p011');

insert into subject values('a0011', '교양테니스', 3, '3', 30, 'B관 101호', '월 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p011');
insert into subject values('a0012', '교양테니스', 3, '3', 30, 'B관 101호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p011');
insert into subject values('a0013', '교양탁구', 3, '2', 30, 'B관 102호', '화 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p012');
insert into subject values('a0014', '교양탁구', 3, '2', 30, 'B관 102호', '수 1-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p012');
insert into subject values('a0015', '교양배드민턴 ', 3, '3', 30, 'B관 301호', '수 2-3', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p013');
insert into subject values('a0016', '교양승마', 3, '3', 30, 'B관 501호', '월 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p014');
insert into subject values('a0017', '사회봉사', 4, '3', 30, 'B관 401호', '목 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p015');
insert into subject values('a0018', '사회봉사', 4, '3', 30, 'B관 401호', '금 2-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p015');
insert into subject values('a0019', '융합과학특강', 4, '3', 30, 'A관 101호', '화 3-5', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p011');
insert into subject values('a0020', '융합과학특강', 4, '3', 30, 'A관 101호', '금 5-7', '강의', to_date('2021.09.05', 'YYYY.MM.DD'), to_date('2021.12.05', 'YYYY.MM.DD'), '교양', 1, 'p011');


select * from student;
select * from subject
select pno ,email from professor

select * from manager
update manager set email ='asdzcx@naver.com'


select * from student
update student set email='zxcqwec@naver.com' where sno = '20210102'