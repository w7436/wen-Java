create database orderdemo;

use orderdemo;
drop database orderdemo;
drop table total;

create table total(
    id int primary key auto_increment,
    datetime Timestamp,
    money double
);

# 餐桌表
create table tables(
    id int primary key AUTO_INCREMENT,
    tableName varchar(20),
    tableStatus int default 0,
    orderDate TIMESTAMP
);
# 类别表（菜品）
create table foodType(
    id int primary key ,
    typeName varchar(20)
);

# 菜信息表
create table food(
    id int primary key auto_increment,
    foodName varchar(20),
    foodType_id int,
    price double,
    mprice double,
    image varchar(100),
    foreign key (foodType_id) references foodType(id)
);


# 订单表
create table orders(
    id int primary key auto_increment,
    table_id int,
    orderDate TIMESTAMP,
    totalPrice double,
    foreign key (table_id) references tables(id)
);

# 订单明细表
create table orderDatil(
    id int primary key auto_increment,
    order_Id int,
    food_Id int,
    foodCount int,
    foreign key (order_id) references orders(id),
    foreign key (food_Id) references food(id)
);


drop table total;
select * from total;