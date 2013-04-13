/*
 ----------------------------------------------------------------------------
             Génération d'une base de données pour
                        SQL Server 7.x
                       (10/4/2013 21:33:24)
 ----------------------------------------------------------------------------
     Nom de la base : NemoVelo
     Projet : NemoVelo
     Auteur : Yohan Sanchez
     Date de dernière modification : 10/4/2013 21:33:10
 ----------------------------------------------------------------------------
*/

drop database NemoVelo;

/* -----------------------------------------------------------------------------
      OUVERTURE DE LA BASE NemoVelo
----------------------------------------------------------------------------- */

create database NemoVelo;

use NemoVelo;



/* -----------------------------------------------------------------------------
      TABLE : nemo_user
----------------------------------------------------------------------------- */

create table nemo_user
  (
     id bigint  not null  ,
     last_name varchar(128)  not null  ,
     first_Name varchar(128)  not null  ,
     email varchar(60)  not null  ,
	 crypted_password varchar(40)  not null  ,
     birth_date datetime  not null  ,
     create_date datetime  not null  ,
     constraint pk_nemo_user primary key (id)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : nemo_user_type
----------------------------------------------------------------------------- */

create table nemo_user_type
  (
     id_user bigint  not null  ,
     id_user_type bigint  not null  ,
     constraint pk_nemo_user_type primary key (id_user, id_user_type)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : user_type
----------------------------------------------------------------------------- */

create table user_type
  (
     id bigint  not null  ,
     id_parent_user_type bigint null  ,
     code varchar(128)  not null  ,
     name varchar(20)  not null  ,
     description varchar(20)  not null  ,
     constraint pk_user_type primary key (id)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : bike
----------------------------------------------------------------------------- */

create table bike
  (
     id bigint  not null  ,
     constraint pk_bike primary key (id)
  ) ;


/* -----------------------------------------------------------------------------
      TABLE : contact
----------------------------------------------------------------------------- */

  create table contact
  (
     id bigint  not null  ,
     street_number bigint  not null  ,
     street_name varchar(128)  not null  ,
     zip_code char(5)  not null  ,
     city varchar(128)  not null  ,
     country varchar(128)  not null  ,
     phone_number char(10)  not null  ,
     constraint pk_client primary key (id)
  ) ;


/* -----------------------------------------------------------------------------
      TABLE : stock
----------------------------------------------------------------------------- */

create table stock
  (
     id bigint  not null  ,
     code varchar(128)  not null  ,
     name varchar(128)  not null  ,
     description varchar(512)  not null  ,
     latitude decimal(8,6)  not null  ,
     longitude decimal(9,6)  not null  ,
     constraint pk_stock primary key (id)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : storage
----------------------------------------------------------------------------- */

create table storage
  (
     id bigint  not null  ,
     id_stock bigint  not null  ,
     id_storage_type bigint  not null  ,
     constraint pk_storage primary key (id)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : storage_type
----------------------------------------------------------------------------- */

create table storage_type
  (
     id bigint  not null  ,
     code varchar(128)  not null  ,
     name varchar(128)  not null  ,
     description varchar(512)  not null  ,
     constraint pk_storage_type primary key (id)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : terminal
----------------------------------------------------------------------------- */

create table terminal
  (
     id bigint  not null  ,
     id_stock bigint  not null  ,
     ip varchar(19)  not null  ,
     constraint pk_terminal primary key (id)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : bike_usage
----------------------------------------------------------------------------- */

create table bike_usage
  (
     id bigint  not null  ,
     id_nemo_user bigint  not null  ,
     id_bike_usage_type bigint  not null  ,
     id_bike bigint  not null  ,
     id_end_storage bigint  not null  ,
     start_date datetime not null  ,
     end_date datetime  null  ,
     comments varchar(512)  not null  ,
     constraint pk_bike_usage primary key (id)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : bike_usage_type
----------------------------------------------------------------------------- */

create table bike_usage_type
  (
     id bigint  not null  ,
     id_parent_bike_usage_type bigint null  ,
     name varchar(20)  not null  ,
     description varchar(20)  not null  ,
     constraint pk_bike_usage_type primary key (id)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : usage_possibility
----------------------------------------------------------------------------- */

create table usage_possibility
  (
     id_bike_usage_type bigint  not null  ,
     id_user_type bigint not null  ,
	 id_storage_type bigint not null  ,
	 id_rent bigint null  ,
	 id_guarantee bigint null  ,
     constraint pk_usage_possibility primary key (id_bike_usage_type, id_user_type, id_storage_type)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : price
----------------------------------------------------------------------------- */

create table price
  (
     id bigint  not null  ,
	 amount decimal(6,2) not null,
	 type_code enum("guarantee", "rent") not null,
     name varchar(128)  not null  ,
     description varchar(512)  not null  ,
	 price_duration int not null,
	 price_duration_unit enum("minute", "hour", "day", "week", "month") not null,
     constraint pk_price primary key (id)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : subscription
----------------------------------------------------------------------------- */

create table subscription
  (
     id bigint  not null  ,
     id_price bigint  not null  ,
	 id_nemo_user bigint  not null  ,
	 amount decimal(6,2) ,
     start_date datetime not null ,
     end_date datetime  null  ,
     constraint pk_subscription primary key (id)
  ) ;

/* -----------------------------------------------------------------------------
      TABLE : payment
----------------------------------------------------------------------------- */

create table payment
  (
     id bigint  not null  ,
	 id_subscription bigint  not null  ,
	 amount decimal(6,2) ,
     payment_date datetime not null ,
	 validated boolean not null ,
     constraint pk_payment primary key (id)
  ) ;


/* -----------------------------------------------------------------------------
      REFERENCES SUR LES TABLES
----------------------------------------------------------------------------- */


alter table contact
     add constraint fk_contact_nemo_user foreign key (id)
               references nemo_user (id);

alter table terminal
     add constraint fk_terminal_stock foreign key (id_stock)
               references stock (id);

alter table bike_usage
     add constraint fk_bike_usage_nemo_user foreign key (id_nemo_user)
               references nemo_user (id);

alter table bike_usage
     add constraint fk_bike_usage_bike foreign key (id_bike)
               references bike (id);

alter table bike_usage
     add constraint fk_bike_usage_storage foreign key (id_end_storage)
               references storage (id);

alter table bike_usage
     add constraint fk_bike_usage_bike_usage_type foreign key (id_bike_usage_type)
               references bike_usage_type (id);

alter table bike_usage_type
     add constraint fk_bike_usage_type_bike_usage_type foreign key (id_parent_bike_usage_type)
               references bike_usage_type (id);

alter table storage
     add constraint fk_storage_stock foreign key (id_stock)
               references stock (id);

alter table storage
     add constraint fk_storage_storage_type foreign key (id_storage_type)
               references storage_type (id);

alter table user_type
     add constraint fk_user_type_user_type foreign key (id_parent_user_type)
               references user_type (id);

alter table nemo_user_type
     add constraint fk_nemo_user_type_user_type foreign key (id_user_type)
               references user_type (id);

alter table nemo_user_type
     add constraint fk_nemo_user_type_nemo_user foreign key (id_user)
               references nemo_user (id);

alter table usage_possibility
     add constraint fk_usage_possibility_user_type foreign key (id_user_type)
               references user_type (id);

alter table usage_possibility
     add constraint fk_usage_possibility_bike_usage_type foreign key (id_bike_usage_type)
               references bike_usage_type (id);

alter table usage_possibility
     add constraint fk_usage_possibility_storage_type foreign key (id_storage_type)
               references storage_type (id);

alter table usage_possibility
     add constraint fk_usage_possibility_price_rent foreign key (id_rent)
               references price (id);

alter table usage_possibility
     add constraint fk_usage_possibility_price_guarantee foreign key (id_guarantee)
               references price (id);

alter table subscription
     add constraint fk_subscription_price foreign key (id_price)
               references price (id);

alter table subscription
     add constraint fk_subscription_nemo_user foreign key (id_nemo_user)
               references nemo_user (id);

alter table payment
     add constraint fk_payment_subscription foreign key (id_subscription)
               references subscription (id);
/*
 -----------------------------------------------------------------------------
               FIN DE GENERATION
 -----------------------------------------------------------------------------
*/
