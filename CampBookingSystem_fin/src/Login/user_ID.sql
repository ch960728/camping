create table User_tb(
   user_num number(4) not null,
   user_id varchar(20) not null,
   user_pw varchar(20) not null,
   user_name varchar(20) not null,
   user_phone varchar(20),
   user_account number(20) not null,
   Camp_num number(4),
   constraint user_num_pk_User PRIMARY KEY (user_num)
  )
update USER_TB set user_account = 10000000
where user_num = 1


alter table User_tb
add(   user_account number(20) not null)

create table camp_tb(
   Camp_num number(4) not null,
   User_num number(4) not null,
   Camp_payment number(20) not null,
   User_people number(8) not null,
   Camp_date_in date not null,
   Camp_date_out date not null,
   Camp_in char(1) constraint boolean_Camp_in_ck check(Camp_in ='0' or Camp_in ='1')   
)

select * from User_tb
select * from camp_tb

drop table User_tb
drop table camp_tb
drop sequence user_num
delete from  User_tb where User_num = 8

CREATE SEQUENCE user_num
    INCREMENT BY 1
    START WITH 1
    MAXVALUE 1000
    MINVALUE 1


insert into USER_TB
values(user_num.nextval, 'gugu', '9999', 'ºñµÑ±â', '01099999999', 0, 0)

select * from user_sequences
    
    