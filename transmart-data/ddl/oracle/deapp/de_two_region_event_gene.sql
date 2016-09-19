--
-- Type: TABLE; Owner: DEAPP; Name: DE_TWO_REGION_EVENT_GENE
--
 CREATE TABLE "DEAPP"."DE_TWO_REGION_EVENT_GENE" 
  (	"TWO_REGION_EVENT_GENE_ID" NUMBER NOT NULL ENABLE, 
"GENE_ID" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
"EVENT_ID" NUMBER(9,0) NOT NULL ENABLE, 
"EFFECT" VARCHAR2(500 BYTE), 
 CONSTRAINT "TWO_REGION_EVENT_GENE_ID" PRIMARY KEY ("TWO_REGION_EVENT_GENE_ID")
 USING INDEX
 TABLESPACE "TRANSMART"  ENABLE
  ) SEGMENT CREATION IMMEDIATE
 TABLESPACE "TRANSMART" ;

--
-- Type: REF_CONSTRAINT; Owner: DEAPP; Name: TWO_REGION_EVENT_GENE_FK
--
ALTER TABLE "DEAPP"."DE_TWO_REGION_EVENT_GENE" ADD CONSTRAINT "TWO_REGION_EVENT_GENE_FK" FOREIGN KEY ("EVENT_ID")
 REFERENCES "DEAPP"."DE_TWO_REGION_EVENT" ("TWO_REGION_EVENT_ID") ENABLE;

--
-- Type: INDEX; Owner: DEAPP; Name: TR_EVENT_GENE_GENE_ID
--
CREATE INDEX "DEAPP"."TR_EVENT_GENE_GENE_ID" ON "DEAPP"."DE_TWO_REGION_EVENT_GENE" ("GENE_ID")
TABLESPACE "TRANSMART" ;

--
-- Type: SEQUENCE; Owner: DEAPP; Name: DE_TWO_REGION_EVENT_GENE_SEQ
--
CREATE SEQUENCE  "DEAPP"."DE_TWO_REGION_EVENT_GENE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;

--
-- Type: TRIGGER; Owner: DEAPP; Name: TRG_TWO_REGION_EVENT_GENE_ID
--
  CREATE OR REPLACE TRIGGER "DEAPP"."TRG_TWO_REGION_EVENT_GENE_ID" 
before insert on "DEAPP"."DE_TWO_REGION_EVENT_GENE"
for each row begin
       	if inserting then
               	if :NEW."TWO_REGION_EVENT_GENE_ID" is null then
                       	select DE_TWO_REGION_EVENT_GENE_SEQ.nextval into :NEW."TWO_REGION_EVENT_GENE_ID" from dual;
               	end if;
       	end if;
end;
/
ALTER TRIGGER "DEAPP"."TRG_TWO_REGION_EVENT_GENE_ID" ENABLE;
 
