CREATE TABLE users (
   id UUID NOT NULL,
   name VARCHAR(255),
   email VARCHAR(255),
   CONSTRAINT pk_users PRIMARY KEY (id)
);
