--
-- Type: TABLE; Owner: TM_WZ; Name: TMP_SUBJECT_RBM_CALCS
--
 CREATE TABLE "TM_WZ"."TMP_SUBJECT_RBM_CALCS" 
  (	"TRIAL_NAME" VARCHAR2(100 BYTE), 
"GENE_SYMBOL" VARCHAR2(100 BYTE), 
"ANTIGEN_NAME" VARCHAR2(100 BYTE), 
"MEAN_INTENSITY" NUMBER, 
"MEDIAN_INTENSITY" NUMBER, 
"STDDEV_INTENSITY" NUMBER
  ) SEGMENT CREATION DEFERRED
NOCOMPRESS LOGGING
 TABLESPACE "TRANSMART" ;
