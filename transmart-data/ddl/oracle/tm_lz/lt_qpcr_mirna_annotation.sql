--
-- Type: TABLE; Owner: TM_LZ; Name: LT_QPCR_MIRNA_ANNOTATION
--
 CREATE TABLE "TM_LZ"."LT_QPCR_MIRNA_ANNOTATION" 
  (	"ID_REF" VARCHAR2(100 BYTE), 
"MIRNA_ID" VARCHAR2(100 BYTE), 
"SN_ID" VARCHAR2(100 BYTE), 
"ORGANISM" VARCHAR2(1000 BYTE), 
"GPL_ID" VARCHAR2(20 BYTE)
  ) SEGMENT CREATION IMMEDIATE
 TABLESPACE "TRANSMART" ;

