/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     2013.11.17. 21:05:25                         */
/*==============================================================*/

drop table BOOK_PERSON;

drop table BOOK;

drop table PERSON;

drop sequence SEQ_BOOK_ID;

drop sequence SEQ_PERSON_ID;

create sequence SEQ_BOOK_ID
start 20;

create sequence SEQ_PERSON_ID
start 20;

/*==============================================================*/
/* Table: BOOK                                                  */
/*==============================================================*/
create table BOOK (
   BOOK_ID              NUMERIC              not null,
   AUTHOR               VARCHAR(255)         null,
   TITLE                VARCHAR(255)         null,
   QUANTITY             NUMERIC              null,
   constraint PK_BOOK primary key (BOOK_ID)
);

/*==============================================================*/
/* Table: BOOK_PERSON                                           */
/*==============================================================*/
create table BOOK_PERSON (
   PERSON_ID            NUMERIC              not null,
   BOOK_ID              NUMERIC              not null,
   RENTED_DATE          DATE                 null,
   constraint PK_BOOK_PERSON primary key (PERSON_ID, BOOK_ID)
);

/*==============================================================*/
/* Table: PERSON                                                */
/*==============================================================*/
create table PERSON (
   PERSON_ID            NUMERIC              not null,
   FIRST_NAME           VARCHAR(255)         null,
   LAST_NAME            VARCHAR(255)         null,
   BIRTH_DATE           DATE                 null,
   CITY                 VARCHAR(255)         null,
   ZIP_CODE             VARCHAR(255)         null,
   STREET_ADDRESS_1     VARCHAR(255)         null,
   STREET_ADDRESS_2     VARCHAR(255)         null,
   STREET_ADDRESS_3     VARCHAR(255)         null,
   PHONE_NUMBER         VARCHAR(20)          null,
   constraint PK_PERSON primary key (PERSON_ID)
);

alter table BOOK_PERSON
   add constraint REFERENCE_1 foreign key (PERSON_ID)
      references PERSON (PERSON_ID)
      on delete cascade on update restrict;

alter table BOOK_PERSON
   add constraint REFERENCE_2 foreign key (BOOK_ID)
      references BOOK (BOOK_ID)
      on delete cascade on update restrict;

