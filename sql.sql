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
	subno NUMBER NOT NULL, /* 강의코드 */
	name VARCHAR(50), /* 강의명 */
	grade NUMBER, /* 학년 */
	score VARCHAR(255), /* 학점 */
	people NUMBER, /* 인원수 */
	room VARCHAR(255), /* 강의실 */
	subtime DATE, /* 강의시간 */
	state VARCHAR(50), /* 상태 */
	startday DATE, /* 개강날 */
	endday DATE, /* 종강날 */
	division VARCHAR(50), /* 강의구분 */
	dno NUMBER, /* 학과번호 */
	pno NUMBER /* 교수아이디 */
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
	subno NUMBER /* 강의코드 */
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