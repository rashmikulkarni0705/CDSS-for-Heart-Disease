--------------------------------------------------------
--  File created - Thursday-September-18-2014   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence PATIENT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HEART"."PATIENT_SEQ"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table PATIENT
--------------------------------------------------------

  CREATE TABLE "HEART"."PATIENT" 
   (	"PATIENTID" NUMBER, 
	"NAME" VARCHAR2(4000 BYTE), 
	"ADDRESS" VARCHAR2(4000 BYTE), 
	"CONTACTNO" VARCHAR2(4000 BYTE), 
	"ACTIVE" VARCHAR2(1 BYTE), 
	"VAL1" NUMBER(8,2), 
	"VAL2" NUMBER(8,2), 
	"VAL3" NUMBER(8,2), 
	"VAL4" NUMBER(8,2), 
	"VAL5" NUMBER(8,2), 
	"VAL6" NUMBER(8,2), 
	"VAL7" NUMBER(8,2), 
	"FLAG" VARCHAR2(10 BYTE), 
	"VAL8" NUMBER(8,2), 
	"VAL9" NUMBER(8,2), 
	"VAL10" NUMBER(8,2), 
	"VAL12" NUMBER(8,2), 
	"VAL13" NUMBER(8,2), 
	"VAL11" NUMBER(8,2)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HEART.PATIENT
SET DEFINE OFF;
Insert into HEART.PATIENT (PATIENTID,NAME,ADDRESS,CONTACTNO,ACTIVE,VAL1,VAL2,VAL3,VAL4,VAL5,VAL6,VAL7,FLAG,VAL8,VAL9,VAL10,VAL12,VAL13,VAL11) values (21,'K','DSKF	','327234','1',23,1,3,3,7,7,8,'Yes',8,8,8,8,4,8);
--------------------------------------------------------
--  DDL for Index PATIENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "HEART"."PATIENT_PK" ON "HEART"."PATIENT" ("PATIENTID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table PATIENT
--------------------------------------------------------

  ALTER TABLE "HEART"."PATIENT" ADD CONSTRAINT "PATIENT_PK" PRIMARY KEY ("PATIENTID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "HEART"."PATIENT" MODIFY ("FLAG" NOT NULL ENABLE);
 
  ALTER TABLE "HEART"."PATIENT" MODIFY ("VAL9" NOT NULL ENABLE);
--------------------------------------------------------
--  DDL for Trigger BI_PATIENT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HEART"."BI_PATIENT" 
  before insert on "PATIENT"               
  for each row  
begin   
    select "PATIENT_SEQ".nextval into :NEW.PATIENTID from dual; 
end; 
/
ALTER TRIGGER "HEART"."BI_PATIENT" ENABLE;
