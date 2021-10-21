/* 관리자 */
CREATE TABLE manager (
	id NUMBER NOT NULL, /* 아이디 */
	name VARCHAR(50), /* 이름 */
	password VARCHAR(50), /* 비밀번호 */
	tel VARCHAR(30), /* 연락처 */
	email VARCHAR(40), /* 이메일 */
	address VARCHAR(255) /* 주소 */
);
select * from professor;
CREATE UNIQUE INDEX PK_manager
	ON manager (
		id ASC
	);

/* 교수 */
CREATE TABLE professor (
	pno NUMBER NOT NULL, /* 교수아이디 */
	password VARCHAR(50), /* 비밀번호 */
	Major VARCHAR(50), /* 교수전공 */
	name VARCHAR(50), /* 교수이름 */
	COL2 BLOB, /* 교수사진 */
	address VARCHAR(255), /* 교수주소 */
	pro_room VARCHAR(255), /* 연구실위치 */
	tel VARCHAR(30), /* 교수전화번호 */
	email VARCHAR(40), /* 교수이메일 */
	dno NUMBER /* 학과번호 */
);

CREATE UNIQUE INDEX PK_professor
	ON professor (
		pno ASC
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
select * from student;
CREATE UNIQUE INDEX PK_student
	ON student (
		sno ASC
	);

/* 학과 */
CREATE TABLE department (
	dno NUMBER NOT NULL, /* 학과번호 */
	name VARCHAR(50), /* 학과명 */
	tel VARCHAR(30) /* 학과전화번호 */
);
select * from department
CREATE UNIQUE INDEX PK_department
	ON department (
		dno ASC
	);

/* 강의 */
CREATE TABLE subject (
	subno NUMBER NOT NULL, /* 강의코드 */
	name VARCHAR(50), /* 강의명 */
	grade NUMBER, /* 학년 */
	score VARCHAR(255), /* 학점 */
	people NUMBER, /* 인원수 */
	room VARCHAR(255), /* 강의실 */
	time DATE, /* 강의시간 */
	state VARCHAR(50), /* 상태 */
	start DATE, /* 개강날 */
	end DATE, /* 종강날 */
	division VARCHAR(50), /* 강의구분 */
	dno NUMBER, /* 학과번호 */
	pno NUMBER /* 교수아이디 */
);
select * from subject;

CREATE UNIQUE INDEX PK_subject
	ON subject (
		subno ASC
	);

/* 수강 */
CREATE TABLE register (
	regno NUMBER NOT NULL, /* 수강번호 */
	year NUMBER, /* 년도 */
	semester NUMBER, /* 학기 */
	score VARCHAR(255), /* 성적 */
	sno NUMBER, /* 학번(ID) */
	subno NUMBER /* 강의코드 */
);

CREATE UNIQUE INDEX PK_register
	ON register (
		regno ASC
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

CREATE UNIQUE INDEX PK_Notice
	ON Notice (
		Nno ASC
	);
	
	