create database if not exists Lab_2_SQL;
use Lab_2_SQL;

CREATE TABLE Laptop (
	code int NOT NULL ,
	model varchar (50) NOT NULL ,
	speed smallint NOT NULL ,
	ram smallint NOT NULL ,
	hd real NOT NULL ,
	price decimal(8,2) NULL ,
	screen tinyint NOT NULL 
);

CREATE TABLE PC (
	code int NOT NULL ,
	model varchar (50) NOT NULL ,
	speed smallint NOT NULL ,
	ram smallint NOT NULL ,
	hd real NOT NULL ,
	cd varchar (10) NOT NULL ,
	price decimal(8,2) NULL 
);

CREATE TABLE Product (
	maker varchar (10) NOT NULL ,
	model varchar (50) NOT NULL ,
	type varchar (50) NOT NULL 
);

CREATE TABLE Printer (
	code int NOT NULL ,
	model varchar (50) NOT NULL ,
	color char (1) NOT NULL ,
	type varchar (10) NOT NULL ,
	price decimal(8,2) NULL 
);

ALTER TABLE Laptop ADD 
	CONSTRAINT PK_Laptop PRIMARY KEY  NONCLUSTERED 
	(
		code
	);

ALTER TABLE PC  ADD 
	CONSTRAINT PK_pc PRIMARY KEY  NONCLUSTERED 
	(
		code
	);

ALTER TABLE Product  ADD 
	CONSTRAINT PK_product PRIMARY KEY  NONCLUSTERED 
	(
		model
	); 


ALTER TABLE Printer  ADD 
	CONSTRAINT PK_printer PRIMARY KEY  NONCLUSTERED 
	(
		code
	); 

ALTER TABLE Laptop ADD 
	CONSTRAINT FK_Laptop_product FOREIGN KEY 
	(
		model
	) REFERENCES Product (
		model
	);

ALTER TABLE PC ADD 
	CONSTRAINT FK_pc_product FOREIGN KEY 
	(
		model
	) REFERENCES Product (
		model
	);

ALTER TABLE Printer ADD 
	CONSTRAINT FK_printer_product FOREIGN KEY 
	(
		model
	) REFERENCES Product (
		model
	);

#---Product------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Product values('B','1121','PC');
insert into Product values('A','1232','PC');
insert into Product values('A','1233','PC');
insert into Product values('E','1260','PC');
insert into Product values('A','1276','Printer');
insert into Product values('D','1288','Printer');
insert into Product values('A','1298','Laptop');
insert into Product values('C','1321','Laptop');
insert into Product values('A','1401','Printer');
insert into Product values('A','1408','Printer');
insert into Product values('D','1433','Printer');
insert into Product values('E','1434','Printer');
insert into Product values('B','1750','Laptop');
insert into Product values('A','1752','Laptop');
insert into Product values('E','2111','PC');
insert into Product values('E','2112','PC');
                                                                                                                                                                                                                                                                 
#---PC------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into PC values(1,'1232',500,64,5,'12x',600);
insert into PC values(2,'1121',750,128,14,'40x',850);
insert into PC values(3,'1233',500,64,5,'12x',600);
insert into PC values(4,'1121',600,128,14,'40x',850);
insert into PC values(5,'1121',600,128,8,'40x',850);
insert into PC values(6,'1233',750,128,20,'50x',950);
insert into PC values(7,'1232',500,32,10,'12x',400);
insert into PC values(8,'1232',450,64,8,'24x',350);
insert into PC values(9,'1232',450,32,10,'24x',350);
insert into PC values(10,'1260',500,32,10,'12x',350);
insert into PC values(11,'1233',900,128,40,'40x',980);
                                                                                                                                                                                                                                                                 
#---Laptop------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Laptop values(1,'1298',350,32,4,700,11);
insert into Laptop values(2,'1321',500,64,8,970,12);
insert into Laptop values(3,'1750',750,128,12,1200,14);
insert into Laptop values(4,'1298',600,64,10,1050,15);
insert into Laptop values(5,'1752',750,128,10,1150,14);
insert into Laptop values(6,'1298',450,64,10,950,12);
                                                                                                                                                                                                                                                                 
#---Printer------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Printer values(1,'1276','n','Laser',400);
insert into Printer values(2,'1433','y','Jet',270);
insert into Printer values(3,'1434','y','Jet',290);
insert into Printer values(4,'1401','n','Matrix',150);
insert into Printer values(5,'1408','n','Matrix',270);
insert into Printer values(6,'1288','n','Laser',400);


CREATE TABLE Income (
	code int NOT NULL ,
	point tinyint NOT NULL ,
	date datetime NOT NULL ,
	inc decimal(8,2) NOT NULL 
); 

CREATE TABLE Outcome (
	code int NOT NULL ,
	point tinyint NOT NULL ,
	date datetime NOT NULL ,
	`out` decimal(8,2) NOT NULL 
); 

CREATE TABLE Income_o (
	point tinyint NOT NULL ,
	date datetime NOT NULL ,
	inc decimal(8,2) NOT NULL 
); 

CREATE TABLE Outcome_o (
	point tinyint NOT NULL ,
	date datetime NOT NULL ,
	`out` decimal(8,2) NOT NULL 
); 

ALTER TABLE Income  ADD 
	CONSTRAINT PK_Income PRIMARY KEY  NONCLUSTERED 
	(
		code
	);   

ALTER TABLE Outcome  ADD 
	CONSTRAINT PK_Outcome PRIMARY KEY  NONCLUSTERED 
	(
		code
	);  

ALTER TABLE Income_o  ADD 
	CONSTRAINT PK_Income_o PRIMARY KEY  NONCLUSTERED 
	(
		point,
		date
	);   

ALTER TABLE Outcome_o  ADD 
	CONSTRAINT PK_Outcome_o PRIMARY KEY  NONCLUSTERED 
	(
		point,
		date
	);   
                                                                                                                                                                                                                                                                 
#---Income------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Income values(1,1,'2001-03-22 00:00:00.000',15000.00);
insert into Income values(2,1,'2001-03-23 00:00:00.000',15000.00);
insert into Income values(3,1,'2001-03-24 00:00:00.000',3600.00);
insert into Income values(4,2,'2001-03-22 00:00:00.000',10000.00);
insert into Income values(5,2,'2001-03-24 00:00:00.000',1500.00);
insert into Income values(6,1,'2001-04-13 00:00:00.000',5000.00);
insert into Income values(7,1,'2001-05-11 00:00:00.000',4500.00);
insert into Income values(8,1,'2001-03-22 00:00:00.000',15000.00);
insert into Income values(9,2,'2001-03-24 00:00:00.000',1500.00);
insert into Income values(10,1,'2001-04-13 00:00:00.000',5000.00);
insert into Income values(11,1,'2001-03-24 00:00:00.000',3400.00);
insert into Income values(12,3,'2001-09-13 00:00:00.000',1350.00);
insert into Income values(13,3,'2001-09-13 00:00:00.000',1750.00);
                                                                                                                                                                                                                                                                 
#-----Outcome 
insert into Outcome values(1,1,'2001-03-14 00:00:00.000',15348.00);
insert into Outcome values(2,1,'2001-03-24 00:00:00.000',3663.00);
insert into Outcome values(3,1,'2001-03-26 00:00:00.000',1221.00);
insert into Outcome values(4,1,'2001-03-28 00:00:00.000',2075.00);
insert into Outcome values(5,1,'2001-03-29 00:00:00.000',2004.00);
insert into Outcome values(6,1,'2001-04-11 00:00:00.000',3195.04);
insert into Outcome values(7,1,'2001-04-13 00:00:00.000',4490.00);
insert into Outcome values(8,1,'2001-04-27 00:00:00.000',3110.00);
insert into Outcome values(9,1,'2001-05-11 00:00:00.000',2530.00);
insert into Outcome values(10,2,'2001-03-22 00:00:00.000',1440.00);
insert into Outcome values(11,2,'2001-03-29 00:00:00.000',7848.00);
insert into Outcome values(12,2,'2001-04-02 00:00:00.000',2040.00);
insert into Outcome values(13,1,'2001-03-24 00:00:00.000',3500.00);
insert into Outcome values(14,2,'2001-03-22 00:00:00.000',1440.00);
insert into Outcome values(15,1,'2001-03-29 00:00:00.000',2006.00);
insert into Outcome values(16,3,'2001-09-13 00:00:00.000',1200.00);
insert into Outcome values(17,3,'2001-09-13 00:00:00.000',1500.00);
insert into Outcome values(18,3,'2001-09-14 00:00:00.000',1150.00);
                                                                                                                                                                                                                                                                
#---Income_o 
insert into Income_o values(1,'2001-03-22 00:00:00.000',15000.00);
insert into Income_o values(1,'2001-03-23 00:00:00.000',15000.00);
insert into Income_o values(1,'2001-03-24 00:00:00.000',3400.00);
insert into Income_o values(1,'2001-04-13 00:00:00.000',5000.00);
insert into Income_o values(1,'2001-05-11 00:00:00.000',4500.00);
insert into Income_o values(2,'2001-03-22 00:00:00.000',10000.00);
insert into Income_o values(2,'2001-03-24 00:00:00.000',1500.00);
insert into Income_o values(3,'2001-09-13 00:00:00.000',11500.00);
insert into Income_o values(3,'2001-10-02 00:00:00.000',18000.00);
                                                                                                                                                                                                                                                                 
#---Outcome_o 
insert into Outcome_o values(1,'2001-03-14 00:00:00.000',15348.00);
insert into Outcome_o values(1,'2001-03-24 00:00:00.000',3663.00);
insert into Outcome_o values(1,'2001-03-26 00:00:00.000',1221.00);
insert into Outcome_o values(1,'2001-03-28 00:00:00.000',2075.00);
insert into Outcome_o values(1,'2001-03-29 00:00:00.000',2004.00);
insert into Outcome_o values(1,'2001-04-11 00:00:00.000',3195.04);
insert into Outcome_o values(1,'2001-04-13 00:00:00.000',4490.00);
insert into Outcome_o values(1,'2001-04-27 00:00:00.000',3110.00);
insert into Outcome_o values(1,'2001-05-11 00:00:00.000',2530.00);
insert into Outcome_o values(2,'2001-03-22 00:00:00.000',1440.00);
insert into Outcome_o values(2,'2001-03-29 00:00:00.000',7848.00);
insert into Outcome_o values(2,'2001-04-02 00:00:00.000',2040.00);
insert into Outcome_o values(3,'2001-09-13 00:00:00.000',1500.00);
insert into Outcome_o values(3,'2001-09-14 00:00:00.000',2300.00);
insert into Outcome_o values(3,'2002-09-16 00:00:00.000',2150.00);


CREATE TABLE Battles (
	name varchar (20) NOT NULL ,
	date datetime NOT NULL 
); 

CREATE TABLE Classes (
	class varchar (50) NOT NULL ,
	type varchar (2) NOT NULL ,
	country varchar (20) NOT NULL ,
	numGuns tinyint NULL ,
	bore real NULL ,
	displacement int NULL 
); 

CREATE TABLE Ships (
	name varchar (50) NOT NULL ,
	class varchar (50) NOT NULL ,
	launched smallint NULL 
); 

CREATE TABLE Outcomes (
	ship varchar (50) NOT NULL ,
	battle varchar (20) NOT NULL ,
	result varchar (10) NOT NULL 
); 

ALTER TABLE Battles ADD 
	CONSTRAINT PK_Battles PRIMARY KEY  CLUSTERED 
	(
		name
	);   

ALTER TABLE Classes ADD 
	CONSTRAINT PK_Classes PRIMARY KEY  CLUSTERED 
	(
		class
	);   

ALTER TABLE Ships ADD 
	CONSTRAINT PK_Ships PRIMARY KEY  CLUSTERED 
	(
		name
	);   

ALTER TABLE Outcomes ADD 
	CONSTRAINT PK_Outcomes PRIMARY KEY  CLUSTERED 
	(
		ship,
		battle
	);   

ALTER TABLE Ships ADD 
	CONSTRAINT FK_Ships_Classes FOREIGN KEY 
	(
		class
	) REFERENCES Classes (
		class
	);

ALTER TABLE Outcomes ADD 
	CONSTRAINT FK_Outcomes_Battles FOREIGN KEY 
	(
		battle
	) REFERENCES Battles (
		name
	);
                                                                                                                                                                                                                                                               
#---Classes------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Classes values('Bismarck','bb','Germany',8,15,42000);
insert into Classes values('Iowa','bb','USA',9,16,46000);
insert into Classes values('Kon','bc','Japan',8,14,32000);
insert into Classes values('North Carolina','bb','USA',12,16,37000);
insert into Classes values('Renown','bc','Gt.Britain',6,15,32000);
insert into Classes values('Revenge','bb','Gt.Britain',8,15,29000);
insert into Classes values('Tennessee','bb','USA',12,14,32000);
insert into Classes values('Yamato','bb','Japan',9,18,65000);
                                                                                                                                                                                                                                                                 
#---Battles------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Battles values('Guadalcanal','1942-11-15 00:00:00.000');
insert into Battles values('North Atlantic','1941-05-25 00:00:00.000');
insert into Battles values('North Cape','1943-12-26 00:00:00.000');
insert into Battles values('Surigao Strait','1944-10-25 00:00:00.000');
insert into Battles values ('#Cuba62a'   , '1962-10-20');
insert into Battles values ('#Cuba62b'   , '1962-10-25');
                                                                                                                                                                                                                                                                 
#---Ships------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Ships values('California','Tennessee',1921);
insert into Ships values('Haruna','Kon',1916);
insert into Ships values('Hiei','Kon',1914);
insert into Ships values('Iowa','Iowa',1943);
insert into Ships values('Kirishima','Kon',1915);
insert into Ships values('Kon','Kon',1913);
insert into Ships values('Missouri','Iowa',1944);
insert into Ships values('Musashi','Yamato',1942);
insert into Ships values('New Jersey','Iowa',1943);
insert into Ships values('North Carolina','North Carolina',1941);
insert into Ships values('Ramillies','Revenge',1917);
insert into Ships values('Renown','Renown',1916);
insert into Ships values('Repulse','Renown',1916);
insert into Ships values('Resolution','Renown',1916);
insert into Ships values('Revenge','Revenge',1916);
insert into Ships values('Royal Oak','Revenge',1916);
insert into Ships values('Royal Sovereign','Revenge',1916);
insert into Ships values('Tennessee','Tennessee',1920);
insert into Ships values('Washington','North Carolina',1941);
insert into Ships values('Wisconsin','Iowa',1944);
insert into Ships values('Yamato','Yamato',1941);
insert into Ships values('South Dakota','North Carolina',1941); 
                                                                                                                                                                                                                                                             
#---Outcomes------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Outcomes values('Bismarck','North Atlantic','sunk');
insert into Outcomes values('California','Surigao Strait','OK');
insert into Outcomes values('Duke of York','North Cape','OK');
insert into Outcomes values('Fuso','Surigao Strait','sunk');
insert into Outcomes values('Hood','North Atlantic','sunk');
insert into Outcomes values('King George V','North Atlantic','OK');
insert into Outcomes values('Kirishima','Guadalcanal','sunk');
insert into Outcomes values('Prince of Wales','North Atlantic','damaged');
insert into Outcomes values('Rodney','North Atlantic','OK');
insert into Outcomes values('Schamhorst','North Cape','sunk');
insert into Outcomes values('South Dakota','Guadalcanal','damaged');
insert into Outcomes values('Tennessee','Surigao Strait','OK');
insert into Outcomes values('Washington','Guadalcanal','OK');
insert into Outcomes values('West Virginia','Surigao Strait','OK');
insert into Outcomes values('Yamashiro','Surigao Strait','sunk');
insert into Outcomes values('California','Guadalcanal','damaged');


CREATE TABLE Company (
	ID_comp int NOT NULL ,
	name char (10) NOT NULL 
);

CREATE TABLE Pass_in_trip (
	trip_no int NOT NULL ,
	date datetime NOT NULL ,
	ID_psg int NOT NULL ,
	place char (10) NOT NULL 
);

CREATE TABLE Passenger (
	ID_psg int NOT NULL ,
	name char (20) NOT NULL 
);

CREATE TABLE Trip (
	trip_no int NOT NULL ,
	ID_comp int NOT NULL ,
	plane char (10) NOT NULL ,
	town_from char (25) NOT NULL ,
	town_to char (25) NOT NULL ,
	time_out datetime NOT NULL ,
	time_in datetime NOT NULL 
);

ALTER TABLE Company ADD 
	CONSTRAINT PK2 PRIMARY KEY  CLUSTERED 
	(
		ID_comp
	);   

ALTER TABLE Pass_in_trip ADD 
	CONSTRAINT PK_pt PRIMARY KEY  CLUSTERED 
	(
		trip_no,
		date,
		ID_psg
	);   

ALTER TABLE Passenger ADD 
	CONSTRAINT PK_psg PRIMARY KEY  CLUSTERED 
	(
		ID_psg
	);   

ALTER TABLE Trip ADD 
	CONSTRAINT PK_t PRIMARY KEY  CLUSTERED 
	(
		trip_no
	);   

ALTER TABLE Pass_in_trip ADD 
	CONSTRAINT FK_Pass_in_trip_Passenger FOREIGN KEY 
	(ID_psg) REFERENCES Passenger (ID_psg);
ALTER TABLE Pass_in_trip ADD     
	CONSTRAINT FK_Pass_in_trip_Trip FOREIGN KEY 
	(trip_no) REFERENCES Trip (trip_no);
 
ALTER TABLE Trip ADD 
	CONSTRAINT FK_Trip_Company FOREIGN KEY 
	(
		ID_comp
	) REFERENCES Company (
		ID_comp
	);
                                                                                                                                                                                                                                                                 
#---Company------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Company values(1,'Don_avia  ');
insert into Company values(2,'Aeroflot  ');
insert into Company values(3,'Dale_avia ');
insert into Company values(4,'air_France');
insert into Company values(5,'British_AW');
                                                                                                                                                                                                                                                                 
#---Passenger------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Passenger values(1,'Bruce Willis        ');
insert into Passenger values(2,'George Clooney      ');
insert into Passenger values(3,'Kevin Costner       ');
insert into Passenger values(4,'Donald Sutherland   ');
insert into Passenger values(5,'Jennifer Lopez      ');
insert into Passenger values(6,'Ray Liotta          ');
insert into Passenger values(7,'Samuel L. Jackson   ');
insert into Passenger values(8,'Nikole Kidman       ');
insert into Passenger values(9,'Alan Rickman        ');
insert into Passenger values(10,'Kurt Russell        ');
insert into Passenger values(11,'Harrison Ford       ');
insert into Passenger values(12,'Russell Crowe       ');
insert into Passenger values(13,'Steve Martin        ');
insert into Passenger values(14,'Michael Caine       ');
insert into Passenger values(15,'Angelina Jolie      ');
insert into Passenger values(16,'Mel Gibson          ');
insert into Passenger values(17,'Michael Douglas     ');
insert into Passenger values(18,'John Travolta       ');
insert into Passenger values(19,'Sylvester Stallone  ');
insert into Passenger values(20,'Tommy Lee Jones     ');
insert into Passenger values(21,'Catherine Zeta-Jones');
insert into Passenger values(22,'Antonio Banderas    ');
insert into Passenger values(23,'Kim Basinger        ');
insert into Passenger values(24,'Sam Neill           ');
insert into Passenger values(25,'Gary Oldman         ');
insert into Passenger values(26,'Clint Eastwood      ');
insert into Passenger values(27,'Brad Pitt           ');
insert into Passenger values(28,'Johnny Depp         ');
insert into Passenger values(29,'Pierce Brosnan      ');
insert into Passenger values(30,'Sean Connery        ');
insert into Passenger values(31,'Bruce Willis        ');
insert into Passenger values(37,'Mullah Omar         ');
                                                                                                                                                                                                                                                                 
#---Trip------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Trip values(1100,4,'Boeing    ','Rostov                   ','Paris                    ','1900-01-01 14:30:00.000','1900-01-01 17:50:00.000');
insert into Trip values(1101,4,'Boeing    ','Paris                    ','Rostov                   ','1900-01-01 08:12:00.000','1900-01-01 11:45:00.000');
insert into Trip values(1123,3,'TU-154    ','Rostov                   ','Vladivostok              ','1900-01-01 16:20:00.000','1900-01-01 03:40:00.000');
insert into Trip values(1124,3,'TU-154    ','Vladivostok              ','Rostov                   ','1900-01-01 09:00:00.000','1900-01-01 19:50:00.000');
insert into Trip values(1145,2,'IL-86     ','Moscow                   ','Rostov                   ','1900-01-01 09:35:00.000','1900-01-01 11:23:00.000');
insert into Trip values(1146,2,'IL-86     ','Rostov                   ','Moscow                   ','1900-01-01 17:55:00.000','1900-01-01 20:01:00.000');
insert into Trip values(1181,1,'TU-134    ','Rostov                   ','Moscow                   ','1900-01-01 06:12:00.000','1900-01-01 08:01:00.000');
insert into Trip values(1182,1,'TU-134    ','Moscow                   ','Rostov                   ','1900-01-01 12:35:00.000','1900-01-01 14:30:00.000');
insert into Trip values(1187,1,'TU-134    ','Rostov                   ','Moscow                   ','1900-01-01 15:42:00.000','1900-01-01 17:39:00.000');
insert into Trip values(1188,1,'TU-134    ','Moscow                   ','Rostov                   ','1900-01-01 22:50:00.000','1900-01-01 00:48:00.000');
insert into Trip values(1195,1,'TU-154    ','Rostov                   ','Moscow                   ','1900-01-01 23:30:00.000','1900-01-01 01:11:00.000');
insert into Trip values(1196,1,'TU-154    ','Moscow                   ','Rostov                   ','1900-01-01 04:00:00.000','1900-01-01 05:45:00.000');
insert into Trip values(7771,5,'Boeing    ','London                   ','Singapore                ','1900-01-01 01:00:00.000','1900-01-01 11:00:00.000');
insert into Trip values(7772,5,'Boeing    ','Singapore                ','London                   ','1900-01-01 12:00:00.000','1900-01-01 02:00:00.000');
insert into Trip values(7773,5,'Boeing    ','London                   ','Singapore                ','1900-01-01 03:00:00.000','1900-01-01 13:00:00.000');
insert into Trip values(7774,5,'Boeing    ','Singapore                ','London                   ','1900-01-01 14:00:00.000','1900-01-01 06:00:00.000');
insert into Trip values(7775,5,'Boeing    ','London                   ','Singapore                ','1900-01-01 09:00:00.000','1900-01-01 20:00:00.000');
insert into Trip values(7776,5,'Boeing    ','Singapore                ','London                   ','1900-01-01 18:00:00.000','1900-01-01 08:00:00.000');
insert into Trip values(7777,5,'Boeing    ','London                   ','Singapore                ','1900-01-01 18:00:00.000','1900-01-01 06:00:00.000');
insert into Trip values(7778,5,'Boeing    ','Singapore                ','London                   ','1900-01-01 22:00:00.000','1900-01-01 12:00:00.000');
insert into Trip values(8881,5,'Boeing    ','London                   ','Paris                    ','1900-01-01 03:00:00.000','1900-01-01 04:00:00.000');
insert into Trip values(8882,5,'Boeing    ','Paris                    ','London                   ','1900-01-01 22:00:00.000','1900-01-01 23:00:00.000');
                                                                                                                                                                                                                                                                
#---Pass_in_trip------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ 
insert into Pass_in_trip values(1100,'2003-04-29 00:00:00.000',1,'1a        ');
insert into Pass_in_trip values(1123,'2003-04-05 00:00:00.000',3,'2a        ');
insert into Pass_in_trip values(1123,'2003-04-08 00:00:00.000',1,'4c        ');
insert into Pass_in_trip values(1123,'2003-04-08 00:00:00.000',6,'4b        ');
insert into Pass_in_trip values(1124,'2003-04-02 00:00:00.000',2,'2d        ');
insert into Pass_in_trip values(1145,'2003-04-05 00:00:00.000',3,'2c        ');
insert into Pass_in_trip values(1181,'2003-04-01 00:00:00.000',1,'1a        ');
insert into Pass_in_trip values(1181,'2003-04-01 00:00:00.000',6,'1b        ');
insert into Pass_in_trip values(1181,'2003-04-01 00:00:00.000',8,'3c        ');
insert into Pass_in_trip values(1181,'2003-04-13 00:00:00.000',5,'1b        ');
insert into Pass_in_trip values(1182,'2003-04-13 00:00:00.000',5,'4b        ');
insert into Pass_in_trip values(1187,'2003-04-14 00:00:00.000',8,'3a        ');
insert into Pass_in_trip values(1188,'2003-04-01 00:00:00.000',8,'3a        ');
insert into Pass_in_trip values(1182,'2003-04-13 00:00:00.000',9,'6d        ');
insert into Pass_in_trip values(1145,'2003-04-25 00:00:00.000',5,'1d        ');
insert into Pass_in_trip values(1187,'2003-04-14 00:00:00.000',10,'3d        ');
insert into Pass_in_trip values(8882,'2005-11-06 00:00:00.000',37,'1a        '); 
insert into Pass_in_trip values(7771,'2005-11-07 00:00:00.000',37,'1c        '); 
insert into Pass_in_trip values(7772,'2005-11-07 00:00:00.000',37,'1a        '); 
insert into Pass_in_trip values(8881,'2005-11-08 00:00:00.000',37,'1d        '); 
insert into Pass_in_trip values(7778,'2005-11-05 00:00:00.000',10,'2a        '); 
insert into Pass_in_trip values(7772,'2005-11-29 00:00:00.000',10,'3a        ');
insert into Pass_in_trip values(7771,'2005-11-04 00:00:00.000',11,'4a        ');
insert into Pass_in_trip values(7771,'2005-11-07 00:00:00.000',11,'1b        ');
insert into Pass_in_trip values(7771,'2005-11-09 00:00:00.000',11,'5a        ');
insert into Pass_in_trip values(7772,'2005-11-07 00:00:00.000',12,'1d        ');
insert into Pass_in_trip values(7773,'2005-11-07 00:00:00.000',13,'2d        ');
insert into Pass_in_trip values(7772,'2005-11-29 00:00:00.000',13,'1b        ');
insert into Pass_in_trip values(8882,'2005-11-13 00:00:00.000',14,'3d        ');
insert into Pass_in_trip values(7771,'2005-11-14 00:00:00.000',14,'4d        ');
insert into Pass_in_trip values(7771,'2005-11-16 00:00:00.000',14,'5d        ');
insert into Pass_in_trip values(7772,'2005-11-29 00:00:00.000',14,'1c        ');


