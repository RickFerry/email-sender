CREATE TABLE emails (
   id UUID NOT NULL,
   user_id UUID,
   email_from VARCHAR(255),
   email_to VARCHAR(255),
   subject VARCHAR(255),
   text CLOB,
   send_date_email TIMESTAMP,
   status_email SMALLINT,
   CONSTRAINT pk_emails PRIMARY KEY (id)
);