# 7. В подключенном MySQL репозитории создать базу данных “Друзья
# человека”

drop database if exists HumanFriends;
create database HumanFriends;

# 8. Создать таблицы с иерархией из диаграммы в БД.

use HumanFriends;

create table Animals (
id int auto_increment primary key,
class_name varchar(20)
);

insert into Animals(class_name)
values ('Pets'), ('PackAnimals');

create table Pets (
id int auto_increment primary key,
class_name varchar(20),
class_id int, foreign key Pets(class_id) references Animals(id)
on delete cascade on update cascade
);

insert into Pets (class_name, class_id)
	values ('Dogs', 1),
			('Cats', 1),
			('Hamsters', 1);

create table PackAnimals (
id int auto_increment primary key,
class_name varchar(20),
class_id int, foreign key PackAnimals(class_id) references Animals(id)
on delete cascade on update cascade
);

insert into PackAnimals (class_name, class_id)
	values ('Horses', 2),
			('Camels', 2),
			('Donkeys', 2);

-- select * from animals a ;
-- select * from pets p ;
-- select * from packanimals p ;

# 9. Заполнить низкоуровневые таблицы именами(животных), командами
# которые они выполняют и датами рождения.

create table Dogs (
	id int auto_increment primary key,
	class_id int, foreign key Dogs(class_id) references Pets(id)
	on delete cascade on update cascade,
	name varchar(20),
	birth_date date,
	comands varchar(50)	
);
insert into Dogs (class_id, name, birth_date, comands)
	values (1, 'Dakan', "2020-01-01", 'sit lie voice'),
			(1, 'Diche', "2021-02-01", 'sit lie voice apport'),
			(1, 'Dinda', "2020-03-01", 'sit lie voice paw'),
			(1, 'Darde', "2022-04-01", 'sit lie voice poundce'),
			(1, 'Danna', "2023-05-01", 'sit lie voice apport paw');
-- select * from Dogs d;

create table Cats (
	id int auto_increment primary key,
	class_id int, foreign key Cats(class_id) references Pets(id)
	on delete cascade on update cascade,
	name varchar(20),
	birth_date date,
	comands varchar(50)	
);
insert into Cats (class_id, name, birth_date, comands)
	values (2, 'Crann', "2023-09-01", 'eat sleep purrs'),
			(2, 'Cheno', "2021-05-09", 'sleep eat purrs play'),
			(2, 'Conner', "2020-03-01", 'sleep purrs eat play'),
			(2, 'Ctenn', "2021-08-17", 'sleep eat play'),
			(2, 'Chara', "2023-10-01", 'eat sleep purrs play');
-- select * from Cats;

create table Hamsters (
	id int auto_increment primary key,
	class_id int, foreign key Hamsters(class_id) references Pets(id)
	on delete cascade on update cascade,
	name varchar(20),
	birth_date date,
	comands varchar(50)	
);
insert into Hamsters (class_id, name, birth_date, comands)
	values (3, 'Hohan', "2023-01-01", 'eat sleep'),
			(3, 'Hevis', "2023-08-01", 'sleep eat play'),
			(3, 'Harav', "2022-03-01", 'sleep eat play'),
			(3, 'Hando', "2024-02-01", 'sleep eat play'),
			(3, 'Hagra', "2023-05-01", 'eat sleep play');
-- select * from Hamsters;

create table Horses (
	id int auto_increment primary key,
	class_id int, foreign key Horses(class_id) references PackAnimals(id)
	on delete cascade on update cascade,
	name varchar(20),
	birth_date date,
	comands varchar(50)	
);
insert into Horses (class_id, name, birth_date, comands)
	values (1, 'Fitoc', "2020-10-01", 'gallop bow'),
			(1, 'Flina', "2021-12-04", 'gallop gait bow'),
			(1, 'Fanni', "2022-03-01", 'bow'),
			(1, 'Flory', "2019-02-01", 'gallop gait'),
			(1, 'Fauli', "2023-05-01", 'gallop bow');
-- select * from Horses;

create table Camels (
	id int auto_increment primary key,
	class_id int, foreign key Camels(class_id) references PackAnimals(id)
	on delete cascade on update cascade,
	name varchar(20),
	birth_date date,
	comands varchar(50)	
);
insert into Camels (class_id, name, birth_date, comands)
	values (2, 'Fitoc', "2018-12-01", 'gallop bow'),
			(2, 'Flina', "2020-12-04", 'gallop gait bow'),
			(2, 'Fanni', "2019-03-11", 'bow'),
			(2, 'Flory', "2023-02-01", 'gallop gait'),
			(2, 'Fauli', "2021-05-01", 'gallop bow');
-- select * from Camels;

create table Donkeys (
	id int auto_increment primary key,
	class_id int, foreign key Donkeys(class_id) references PackAnimals(id)
	on delete cascade on update cascade,
	name varchar(20),
	birth_date date,
	comands varchar(50)	
);
insert into Donkeys (class_id, name, birth_date, comands)
	values (3, 'Lahin', "2019-11-12", 'stop run'),
			(3, 'Linga', "2021-02-22", 'run go'),
			(3, 'Lans', "2017-11-11", 'stop'),
			(3, 'Linan', "2023-02-01", 'stop go run'),
			(3, 'Lixor', "2021-05-01", 'stop run');
-- select * from Donkeys;
		
# 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
# питомник на зимовку. 
		
delete from Packanimals 
where class_name = 'Camels';
select * from packanimals p ;

# Объединить таблицы лошади, и ослы в одну таблицу.

-- select * from Horses
-- union 
-- select * from donkeys d ;

# 11.Создать новую таблицу “молодые животные” в которую попадут все
# животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
# до месяца подсчитать возраст животных в новой таблице.

create table YoungAnimals (
	id int auto_increment primary key,
	name varchar(20),
	birth_date date,
	comands varchar(50),
	age varchar(20)
);
insert into YoungAnimals (name, birth_date, comands, age)
SELECT name, birth_date, comands, 
CONCAT(CAST(TIMESTAMPDIFF(YEAR, birth_date, NOW()) AS CHAR), " лет ", 
	CAST(MOD(TIMESTAMPDIFF(MONTH, birth_date, NOW()), 12)  AS CHAR), " мес.") AS age 
FROM Cats
WHERE TIMESTAMPDIFF(MONTH, birth_date, NOW()) BETWEEN 12 AND 36;

insert into YoungAnimals (name, birth_date, comands, age)
SELECT name, birth_date, comands, 
CONCAT(CAST(TIMESTAMPDIFF(YEAR, birth_date, NOW()) AS CHAR), " лет ", 
	CAST(MOD(TIMESTAMPDIFF(MONTH, birth_date, NOW()), 12)  AS CHAR), " мес.") AS age 
FROM Dogs
WHERE TIMESTAMPDIFF(MONTH, birth_date, NOW()) BETWEEN 12 AND 36;

insert into YoungAnimals (name, birth_date, comands, age)
SELECT name, birth_date, comands, 
CONCAT(CAST(TIMESTAMPDIFF(YEAR, birth_date, NOW()) AS CHAR), " лет ", 
	CAST(MOD(TIMESTAMPDIFF(MONTH, birth_date, NOW()), 12)  AS CHAR), " мес.") AS age 
FROM Hamsters
WHERE TIMESTAMPDIFF(MONTH, birth_date, NOW()) BETWEEN 12 AND 36;

insert into YoungAnimals (name, birth_date, comands, age)
SELECT name, birth_date, comands, 
CONCAT(CAST(TIMESTAMPDIFF(YEAR, birth_date, NOW()) AS CHAR), " лет ", 
	CAST(MOD(TIMESTAMPDIFF(MONTH, birth_date, NOW()), 12)  AS CHAR), " мес.") AS age 
FROM Donkeys 
WHERE TIMESTAMPDIFF(MONTH, birth_date, NOW()) BETWEEN 12 AND 36;

insert into YoungAnimals (name, birth_date, comands, age)
SELECT name, birth_date, comands, 
CONCAT(CAST(TIMESTAMPDIFF(YEAR, birth_date, NOW()) AS CHAR), " лет ", 
	CAST(MOD(TIMESTAMPDIFF(MONTH, birth_date, NOW()), 12)  AS CHAR), " мес.") AS age 
FROM Horses 
WHERE TIMESTAMPDIFF(MONTH, birth_date, NOW()) BETWEEN 12 AND 36;

insert into YoungAnimals (name, birth_date, comands, age)
SELECT name, birth_date, comands, 
CONCAT(CAST(TIMESTAMPDIFF(YEAR, birth_date, NOW()) AS CHAR), " лет ", 
	CAST(MOD(TIMESTAMPDIFF(MONTH, birth_date, NOW()), 12)  AS CHAR), " мес.") AS age 
FROM Camels
WHERE TIMESTAMPDIFF(MONTH, birth_date, NOW()) BETWEEN 12 AND 36;

-- select * from  YoungAnimals;

		
# 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
# прошлую принадлежность к старым таблицам.

select cats.name, Cats.birth_date, Cats.comands, Pets.class_name as subclass, Animals.class_name as class
from cats 
left join pets on cats.class_id = pets.id 
left join animals on pets.class_id = animals.id
union 
select Dogs.name, Dogs.birth_date, Dogs.comands, Pets.class_name as subclass, Animals.class_name as class
from Dogs 
left join pets on Dogs.class_id = pets.id 
left join animals on pets.class_id = animals.id
union 
select Hamsters.name, Hamsters.birth_date, Hamsters.comands, Pets.class_name as subclass, Animals.class_name as class
from Hamsters 
left join pets on Hamsters.class_id = pets.id 
left join animals on pets.class_id = animals.id
union 
select Horses.name, Horses.birth_date, Horses.comands, Packanimals.class_name as subclass, Animals.class_name as class
from Horses 
left join packanimals  on Horses.class_id = packanimals.id 
left join animals on packanimals.class_id = animals.id
union 
select Donkeys.name, Donkeys.birth_date, Donkeys.comands, packanimals.class_name as subclass, Animals.class_name as class
from Donkeys 
left join packanimals on Donkeys.class_id = packanimals.id 
left join animals on packanimals.class_id = animals.id;















