create table member(
id int(10) auto_increment primary key,
user_id varchar(30) not null,
user_pass varchar(100) not null,
regDate datetime default now() not null,
loginDate datetime default now() not null
);

create table article(
id int(10) auto_increment primary key,
writer int(10) not null,
regDate datetime default now() not null,
updateDate datetime default now() not null,
title varchar(30) not null,
content text,
foreign key(writer) references member(id)
);