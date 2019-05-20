create table border_speed
(
  ID          int auto_increment
    primary key,
  MIN         int          null,
  DESCRIPTION varchar(200) null,
  MAX         int          null
);

create table cars
(
  ID         int auto_increment
    primary key,
  MARK       varchar(20) null,
  COLOR      varchar(20) null,
  GOS_NUMBER varchar(10) null,
  CNUM       varchar(6)  null,
  WEIGHT     int         null,
  MAX_SPEED  int         null
);

create table fine
(
  ID              int auto_increment
    primary key,
  CNUM            varchar(6) null,
  LOCATION_ID     int        null,
  BORDER_SPEED_ID int        null,
  CAR_ID          int        null
);

create table location
(
  ID     int auto_increment
    primary key,
  REGION varchar(30) null
);

create table user
(
  CNUM       varchar(6)  null,
  SURNAME    varchar(25) null,
  UNAME      varchar(25) null,
  FATHERNAME varchar(30) null,
  ADDRESS    varchar(25) null,
  PHONE      varchar(30) null
);

