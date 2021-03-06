drop database if exists blogdemo;
create database blogdemo default charset utf8mb4;

use blogdemo;



drop table IF EXISTS user;
create table user(
    id int primary key auto_increment,
    name varchar(20),
    create_time timestamp
);

drop table IF EXISTS article;
create table article(
                        id int primary key auto_increment,
                        title varchar(50) not null,
                        content mediumtext not null,
                        user_id int,
                        create_time timestamp,
                        foreign key(user_id) references user(id)
);
insert into user(name,create_time) values ('小绿','2020-05-10 12:00:00');
insert into article(title, content, user_id, create_time) values ('第一章','c1',1,CURRENT_TIMESTAMP );
insert into article(title, content, user_id, create_time) values ('第二章','c2',1,CURRENT_TIMESTAMP );
insert into article(title, content, user_id, create_time) values ('第三章','c3',1,CURRENT_TIMESTAMP );


update user set name = 'stu' where id = 1;

insert into article(user_id,title,content,create_time) select id,'新增标题','新增内容'，'2020-05-17 09:27:00' from user where name = 'stu';