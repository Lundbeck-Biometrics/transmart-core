--
-- Type: FUNCTION; Owner: BIOMART_USER; Name: BIO_CONCEPT_CODE_UID
--
  CREATE OR REPLACE FUNCTION "BIOMART_USER"."BIO_CONCEPT_CODE_UID" (
  CODE_TYPE_NAME VARCHAR2,
  BIO_CONCEPT_CODE VARCHAR2
) RETURN VARCHAR2 AS
BEGIN
  -- $Id$
  -- Creates uid for bio_concept_code.

  RETURN nvl(CODE_TYPE_NAME,'ERROR') || ':' || nvl(BIO_CONCEPT_CODE, 'ERROR');
END bio_concept_code_uid;
/
