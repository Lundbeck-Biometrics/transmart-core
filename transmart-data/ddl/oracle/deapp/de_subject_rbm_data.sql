--
-- Type: TABLE; Owner: DEAPP; Name: DE_SUBJECT_RBM_DATA
--
 CREATE TABLE "DEAPP"."DE_SUBJECT_RBM_DATA" 
  (	"TRIAL_NAME" VARCHAR2(100 BYTE), 
"ANTIGEN_NAME" VARCHAR2(100 BYTE), 
"N_VALUE" NUMBER, 
"PATIENT_ID" NUMBER(38,0), 
"GENE_SYMBOL" VARCHAR2(100 BYTE), 
"GENE_ID" NUMBER(10,0), 
"ASSAY_ID" NUMBER, 
"NORMALIZED_VALUE" NUMBER(18,5), 
"CONCEPT_CD" NVARCHAR2(100), 
"TIMEPOINT" VARCHAR2(100 BYTE), 
"DATA_UID" VARCHAR2(100 BYTE), 
"VALUE" NUMBER(18,4), 
"LOG_INTENSITY" NUMBER, 
"MEAN_INTENSITY" NUMBER, 
"STDDEV_INTENSITY" NUMBER, 
"MEDIAN_INTENSITY" NUMBER, 
"ZSCORE" NUMBER(18,4), 
"RBM_PANEL" VARCHAR2(50 BYTE), 
"UNIT" VARCHAR2(50 CHAR), 
"ID" NUMBER(38,0) NOT NULL ENABLE, 
 CONSTRAINT "PK_DE_SUBJECT_RBM_DATA" PRIMARY KEY ("ID")
 USING INDEX
 TABLESPACE "TRANSMART"  ENABLE
  ) SEGMENT CREATION IMMEDIATE
 TABLESPACE "TRANSMART" ;

--
-- Type: SEQUENCE; Owner: DEAPP; Name: DE_SUBJECT_RBM_DATA_SEQ
--
CREATE SEQUENCE  "DEAPP"."DE_SUBJECT_RBM_DATA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1272564 CACHE 20 NOORDER  NOCYCLE ;

--
-- Type: TRIGGER; Owner: DEAPP; Name: TRG_DE_SUBJ_RBM_DATA_ID
--
  CREATE OR REPLACE TRIGGER "DEAPP"."TRG_DE_SUBJ_RBM_DATA_ID" 
BEFORE INSERT ON deapp.de_subject_rbm_data 
FOR EACH ROW

BEGIN
  SELECT deapp.de_subject_rbm_data_seq.NEXTVAL
  INTO   :new.id
  FROM   dual;
END;
/
ALTER TRIGGER "DEAPP"."TRG_DE_SUBJ_RBM_DATA_ID" ENABLE;
 
--
-- Type: INDEX; Owner: DEAPP; Name: DE_SUBJECT_RBM_MCIDX1
--
CREATE BITMAP INDEX "DEAPP"."DE_SUBJECT_RBM_MCIDX1" ON "DEAPP"."DE_SUBJECT_RBM_DATA" ("TRIAL_NAME")
TABLESPACE "TRANSMART" ;

--
-- Type: INDEX; Owner: DEAPP; Name: DE_SUBJECT_RBM_MCIDX2
--
CREATE BITMAP INDEX "DEAPP"."DE_SUBJECT_RBM_MCIDX2" ON "DEAPP"."DE_SUBJECT_RBM_DATA" ("ANTIGEN_NAME")
TABLESPACE "TRANSMART" ;

--
-- Type: INDEX; Owner: DEAPP; Name: DE_SUBJECT_RBM_MCIDX3
--
CREATE BITMAP INDEX "DEAPP"."DE_SUBJECT_RBM_MCIDX3" ON "DEAPP"."DE_SUBJECT_RBM_DATA" ("PATIENT_ID")
TABLESPACE "TRANSMART" ;

--
-- Type: INDEX; Owner: DEAPP; Name: DE_SUBJECT_RBM_MCIDX4
--
CREATE BITMAP INDEX "DEAPP"."DE_SUBJECT_RBM_MCIDX4" ON "DEAPP"."DE_SUBJECT_RBM_DATA" ("GENE_SYMBOL")
TABLESPACE "TRANSMART" ;

