# Users schema

# --- !Ups

CREATE TABLE project (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    summary varchar(255) NOT NULL,
    info varchar(255) NOT NULL,
    status varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE item (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

# --- !Downs

DROP TABLE project;
DROP TABLE item;
