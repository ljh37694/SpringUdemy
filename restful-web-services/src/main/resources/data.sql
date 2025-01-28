insert into user_details(id,birth_date,name)
values(10001, current_date(), 'Lee');

insert into user_details(id,birth_date,name)
values(10002, current_date(), 'Park');

insert into user_details(id,birth_date,name)
values(10003, current_date(), 'Baek');

insert into post(id, description, user_id)
values(20001, 'I want to learn React', 10001);

insert into post(id, description, user_id)
values(20002, 'I want to learn Nest', 10002);

insert into post(id, description, user_id)
values(20003, 'I want to learn Java', 10002);