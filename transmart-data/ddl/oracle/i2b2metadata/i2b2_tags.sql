--
-- Type: TABLE; Owner: I2B2METADATA; Name: I2B2_TAGS
--
 CREATE TABLE "I2B2METADATA"."I2B2_TAGS" 
  (	"TAG_ID" NUMBER(18,0) NOT NULL ENABLE, 
"PATH" VARCHAR2(400 BYTE) NOT NULL ENABLE, 
"TAG" VARCHAR2(1000 BYTE), 
"TAG_TYPE" VARCHAR2(400 BYTE) NOT NULL ENABLE, 
"TAGS_IDX" NUMBER NOT NULL ENABLE,
"TAG_OPTION_ID" NUMBER(18,0),
 CONSTRAINT "I2B2_TAGS_PATH_TAG_TYPE_KEY" UNIQUE ("PATH", "TAG_TYPE")
 USING INDEX
 TABLESPACE "INDX"  ENABLE
  ) SEGMENT CREATION IMMEDIATE
 TABLESPACE "TRANSMART" ;
--
-- Type: REF_CONSTRAINT; Owner: I2B2METADATA; Name: I2B2_TAGS_OPTION_ID_FK
--
ALTER TABLE "I2B2METADATA"."I2B2_TAGS" ADD CONSTRAINT "I2B2_TAGS_OPTION_ID_FK" FOREIGN KEY ("TAG_OPTION_ID")
 REFERENCES "I2B2METADATA"."I2B2_TAG_OPTIONS" ("TAG_OPTION_ID") ON DELETE SET NULL ENABLE;
--
-- Type: REF_CONSTRAINT; Owner: I2B2METADATA; Name: I2B2_TAGS_OPTION_ID_FK
--
ALTER TABLE "I2B2METADATA"."I2B2_TAGS" ADD CONSTRAINT "I2B2_TAGS_OPTION_ID_FK" FOREIGN KEY ("TAG_OPTION_ID")
 REFERENCES "I2B2METADATA"."I2B2_TAG_OPTIONS" ("TAG_OPTION_ID") ON DELETE SET NULL ENABLE;
>>>>>>> tr-data/pfizer-solr

--
-- Type: TRIGGER; Owner: I2B2METADATA; Name: TRG_I2B2_TAG_ID
--
  CREATE OR REPLACE TRIGGER "I2B2METADATA"."TRG_I2B2_TAG_ID" 
before insert on "I2B2_TAGS"    
for each row begin     
  if inserting then       
    if :NEW."TAG_ID" is null then          
      select SEQ_I2B2_DATA_ID.nextval into :NEW."TAG_ID" from dual;       
    end if;    
  end if; 
end;





/
ALTER TRIGGER "I2B2METADATA"."TRG_I2B2_TAG_ID" ENABLE;
 
