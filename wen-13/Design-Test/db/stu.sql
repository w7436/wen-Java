create database design_Test;

use design_Test;

create table stu(
    id int,
    name varchar(20),
    depart varchar(20),
    score int
)

select * from stu;

select id,name,depart,score from stu where score between 0 and 90;

select id,name,depart,score from stu where depart = '计算机系'order by score desc;