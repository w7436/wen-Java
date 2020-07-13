use  new_test;
create table account(
    id int primary key auto_increment,
    name varchar(20),
    money float
);
insert into account(name,money) values('aaa',1000);
insert into account(name,money) values('bbb',1000);
insert into account(name,money) values('ccc',1000);