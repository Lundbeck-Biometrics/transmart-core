--
-- Type: TABLE; Owner: BIOMART; Name: TMP_OMICSOFT_DISEASE_M1
--
 CREATE TABLE "BIOMART"."TMP_OMICSOFT_DISEASE_M1" 
  (	"ACCESSION" VARCHAR2(100 BYTE), 
"MESH_HEADING" VARCHAR2(256 BYTE), 
"MESH_DESCRIPTOR_ID" VARCHAR2(15 BYTE) NOT NULL ENABLE
  ) SEGMENT CREATION IMMEDIATE
 TABLESPACE "TRANSMART" ;

