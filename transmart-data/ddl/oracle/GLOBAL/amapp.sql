--
-- Type: USER; Name: AMAPP
--
CREATE USER "AMAPP" IDENTIFIED BY VALUES 'S:9571FFB20AE27E19978ABB02101BD2F2057143B93D977AC576CC50197513;02955D58870FE54F'
   DEFAULT TABLESPACE "TRANSMART"
   TEMPORARY TABLESPACE "TEMP";
--
-- Type: ROLE_GRANT; Name: AMAPP
--
GRANT "CONNECT" TO "AMAPP";
GRANT "RESOURCE" TO "AMAPP";
--
-- Type: TABLESPACE_QUOTA; Name: AMAPP
--
  DECLARE 
  TEMP_COUNT NUMBER; 
  SQLSTR VARCHAR2(200); 
BEGIN 
  SQLSTR := 'ALTER USER "AMAPP" QUOTA UNLIMITED ON "TRANSMART"';
  EXECUTE IMMEDIATE SQLSTR;
EXCEPTION 
  WHEN OTHERS THEN
    IF SQLCODE = -30041 THEN 
      SQLSTR := 'SELECT COUNT(*) FROM USER_TABLESPACES 
              WHERE TABLESPACE_NAME = ''TRANSMART'' AND CONTENTS = ''TEMPORARY''';
      EXECUTE IMMEDIATE SQLSTR INTO TEMP_COUNT;
      IF TEMP_COUNT = 1 THEN RETURN; 
      ELSE RAISE; 
      END IF;
    ELSE
      RAISE;
    END IF;
END;
/
  DECLARE 
  TEMP_COUNT NUMBER; 
  SQLSTR VARCHAR2(200); 
BEGIN 
  SQLSTR := 'ALTER USER "AMAPP" QUOTA UNLIMITED ON "INDX"';
  EXECUTE IMMEDIATE SQLSTR;
EXCEPTION 
  WHEN OTHERS THEN
    IF SQLCODE = -30041 THEN 
      SQLSTR := 'SELECT COUNT(*) FROM USER_TABLESPACES 
              WHERE TABLESPACE_NAME = ''INDX'' AND CONTENTS = ''TEMPORARY''';
      EXECUTE IMMEDIATE SQLSTR INTO TEMP_COUNT;
      IF TEMP_COUNT = 1 THEN RETURN; 
      ELSE RAISE; 
      END IF;
    ELSE
      RAISE;
    END IF;
END;
/
--
-- Type: SYSTEM_GRANT; Name: AMAPP
--