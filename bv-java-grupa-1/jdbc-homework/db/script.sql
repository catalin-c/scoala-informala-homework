CREATE DATABASE school;

CREATE SEQUENCE courses_id_seq;
CREATE TABLE courses (
  courseid INT PRIMARY KEY DEFAULT NEXTVAL('courses_id_seq'),
  area     TEXT NOT NULL,
  title    TEXT NOT NULL,
  descrip  TEXT NOT NULL,
  prereqs  TEXT NOT NULL
);

CREATE SEQUENCE classes_id_seq;
CREATE TABLE classes (
  classid   INT PRIMARY KEY DEFAULT NEXTVAL('classes_id_seq'),
  courseid  INT REFERENCES courses (courseid),
  days      TEXT NOT NULL,
  starttime DATE NOT NULL   DEFAULT CURRENT_DATE,
  endtime   DATE NOT NULL   DEFAULT CURRENT_DATE,
  bldg      TEXT NOT NULL,
  roomnum   TEXT NOT NULL
);

CREATE TABLE crosslistings (
  courseid  INT REFERENCES courses (courseid),
  dept      TEXT NOT NULL,
  coursenum TEXT NOT NULL
);

CREATE SEQUENCE profs_id_seq;
CREATE TABLE profs (
  profid   INT PRIMARY KEY DEFAULT NEXTVAL('profs_id_seq'),
  profname TEXT NOT NULL
);

CREATE TABLE courseprofs (
  courseid INT REFERENCES courses (courseid),
  profid   INT REFERENCES profs (profid)
);

INSERT INTO courses (area, title, descrip, prereqs)
VALUES ('Math', 'Short Calculus', 'Derivatives, integrals, differential equations, partial derivatives, maxima/minima of functions of several variables covered with less depth than full calculus. No trigonometry included.',
        '3 years of high school math');
INSERT INTO courses (area, title, descrip, prereqs)
VALUES ('Math', 'Intensive Precalculus', 'Algebra, analytic geometry, exponentials, logarithms, trigonometry, complex numbers, beyond usual coverage found in three-year high school mathematics program. One semester version of 1051-1151.',
        '3 years of high school math');
INSERT INTO courses (area, title, descrip, prereqs)
VALUES ('Math', 'Intro Honor Calculus ', 'Differential/integral calculus of functions of a single variable. Emphasizes hard problem-solving rather than theory.',
        'High school student');

INSERT INTO classes (courseid, days, starttime, endtime, bldg, roomnum)
  VALUES (1, 'Monday, Friday', '2018-09-17', '2019-06-28', '2D', '120');
INSERT INTO classes (courseid, days, starttime, endtime, bldg, roomnum)
  VALUES (3, 'Thursday, Friday', '2018-09-17', '2019-06-28', '7N', '88');
INSERT INTO classes (courseid, days, starttime, endtime, bldg, roomnum)
  VALUES (2, 'Wednesday, Thursday', '2018-09-17', '2019-06-28', '3K', '26');

INSERT INTO crosslistings (courseid, dept, coursenum)
  VALUES (3, 'COS', '3C2382');
INSERT INTO crosslistings (courseid, dept, coursenum)
  VALUES (1, 'DOS', 'NC1544');
INSERT INTO crosslistings (courseid, dept, coursenum)
  VALUES (1, 'RES', 'CL1923');

INSERT INTO profs (profname)
VALUES ('William Dyer');
INSERT INTO profs (profname)
VALUES ('Digory Kirke');
INSERT INTO profs (profname)
VALUES ('Hari Seldon');

INSERT INTO courseprofs (courseid, profid)
  VALUES (1, 3);
INSERT INTO courseprofs (courseid, profid)
  VALUES (2, 2);
INSERT INTO courseprofs (courseid, profid)
  VALUES (3, 1);
