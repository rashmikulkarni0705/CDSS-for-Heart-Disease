CREATE TABLE  "PATIENT" 
   (	"PATIENTID" NUMBER, 
	"NAME" VARCHAR2(4000), 
	"ADDRESS" VARCHAR2(4000), 
	"CONTACTNO" VARCHAR2(4000), 
	"ACTIVE" VARCHAR2(1), 
	"VAL1" NUMBER(8,2), 
	"VAL2" NUMBER(8,2), 
	"VAL3" NUMBER(8,2), 
	"VAL4" NUMBER(8,2), 
	"VAL5" NUMBER(8,2), 
	"VAL6" NUMBER(8,2), 
	"VAL7" NUMBER(8,2), 
	"FLAG" VARCHAR2(10) NOT NULL ENABLE, 
	"VAL8" NUMBER(8,2), 
	 CONSTRAINT "PATIENT_PK" PRIMARY KEY ("PATIENTID") ENABLE
   )
/
CREATE UNIQUE INDEX  "PATIENT_PK" ON  "PATIENT" ("PATIENTID")
/
 CREATE SEQUENCE   "PATIENT_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE
/
CREATE OR REPLACE TRIGGER  "BI_PATIENT" 
  before insert on "PATIENT"               
  for each row  
begin   
    select "PATIENT_SEQ".nextval into :NEW.PATIENTID from dual; 
end; 

/
ALTER TRIGGER  "BI_PATIENT" ENABLE
/