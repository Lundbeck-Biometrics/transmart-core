--
-- Type: TABLE; Owner: BIOMART; Name: BIO_DATA_CORREL_DESCR
--
 CREATE TABLE "BIOMART"."BIO_DATA_CORREL_DESCR" 
  (	"BIO_DATA_CORREL_DESCR_ID" NUMBER(18,0) NOT NULL ENABLE, 
"CORRELATION" NVARCHAR2(510), 
"DESCRIPTION" NVARCHAR2(1000), 
"TYPE_NAME" NVARCHAR2(200), 
"STATUS" NVARCHAR2(200), 
"SOURCE" NVARCHAR2(100), 
"SOURCE_CODE" NVARCHAR2(200), 
 CONSTRAINT "BIO_MARKER_RELATIONSHIP_PK" PRIMARY KEY ("BIO_DATA_CORREL_DESCR_ID")
 USING INDEX
 TABLESPACE "INDX"  ENABLE
  ) SEGMENT CREATION IMMEDIATE
 TABLESPACE "TRANSMART" ;

--
-- Type: TRIGGER; Owner: BIOMART; Name: TRG_BIO_MKR_CORREL_DESCR_ID
--
  CREATE OR REPLACE TRIGGER "BIOMART"."TRG_BIO_MKR_CORREL_DESCR_ID" before insert on "BIO_DATA_CORREL_DESCR"    for each row 
begin     if inserting then       if :NEW."BIO_DATA_CORREL_DESCR_ID" is null then          select SEQ_BIO_DATA_ID.nextval into :NEW."BIO_DATA_CORREL_DESCR_ID" from dual;       end if;    end if; end;













/
ALTER TRIGGER "BIOMART"."TRG_BIO_MKR_CORREL_DESCR_ID" ENABLE;
 
