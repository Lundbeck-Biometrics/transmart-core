--
-- Type: TABLE; Owner: AMAPP; Name: AM_TAG_TEMPLATE
--
 CREATE TABLE "AMAPP"."AM_TAG_TEMPLATE" 
  (	"TAG_TEMPLATE_ID" NUMBER NOT NULL ENABLE, 
"TAG_TEMPLATE_NAME" NVARCHAR2(200) NOT NULL ENABLE, 
"TAG_TEMPLATE_TYPE" NVARCHAR2(50) NOT NULL ENABLE, 
"TAG_TEMPLATE_SUBTYPE" NVARCHAR2(50), 
"ACTIVE_IND" CHAR(1 BYTE) NOT NULL ENABLE, 
 PRIMARY KEY ("TAG_TEMPLATE_ID")
 USING INDEX
 TABLESPACE "TRANSMART"  ENABLE
  ) SEGMENT CREATION IMMEDIATE
 TABLESPACE "TRANSMART" ;

--
-- Type: TRIGGER; Owner: AMAPP; Name: TRG_AM_TAG_TEMPLATE_ID
--
  CREATE OR REPLACE TRIGGER "AMAPP"."TRG_AM_TAG_TEMPLATE_ID" before insert on "AMAPP"."AM_TAG_TEMPLATE"    
for each row begin    
if inserting then      
  if :NEW."TAG_TEMPLATE_ID" is null then          
    select SEQ_AMAPP_DATA_ID.nextval into :NEW."TAG_TEMPLATE_ID" from dual;       
  end if;    
end if; 
end;
/
ALTER TRIGGER "AMAPP"."TRG_AM_TAG_TEMPLATE_ID" ENABLE;
 
