use mydb;

insert into adresa values(1,"Srbija","Beograd",11000);
insert into adresa values(2,"Bosna i Hercegovina","Banja Luka",78000);
insert into adresa values(3,"Bosna i Hercegovina","Sarajevo",71000);
insert into adresa values(4,"Njemačka","Frankfurt",60547);
insert into adresa values(5,"SAD","New York",11430);
insert into adresa values(6,"Bosna i Hercegovina","Doboj",74000);
insert into adresa values(7,"Bosna i Hercegovina","Bijeljina",76300);
insert into adresa values(8,"Bosna i Hercegovina","Prijedor",79101);
insert into adresa values(9,"Srbija","Novi Sad",21000);
insert into adresa values(10,"Srbija","Niš",18101);
insert into adresa values(11,"Francuska","Pariz",11111);
insert into adresa values(12,"Kina","Peking",22222);
insert into adresa values(13,"UK","London",33333);
insert into adresa values(14,"Rusija","Moskva",44444);

insert into aerodrom values(1,"Beograd Airport",1);
insert into aerodrom values(2,"Banja Luka Airport",2);
insert into aerodrom values(3,"Sarajevo Airport",3);
insert into aerodrom values(4,"Frankfurt Airport",4);
insert into aerodrom values(5,"JFK Airport",5);
insert into aerodrom values(6,"Pariz Airport",11);
insert into aerodrom values(7,"Peking Airport",12);
insert into aerodrom values(8,"London Airport",13);
insert into aerodrom values(9,"Moskva Airport",14);

insert into banka values(1,"Moja Banka",1);
insert into banka values(2,"Naša Banka",2);
insert into banka values(3,"Nova Banka",9);

insert into osoba values (1,'Ana', 'Mirković', '0308983126116');
insert into osoba values (2,'Slavko', 'Popović', '0512983100067');
insert into osoba values (3,'Danijel', 'Stojanović', '0607989100027');
insert into osoba values (4,'Mirjana', 'Gavrić', '0702964105027');
insert into osoba values (5,'Nikola', 'Mitrović', '1002952100005');
insert into osoba values (6,'Stanko', 'Soldat', '1000672100005');
insert into osoba  values (7,'Dejan', 'Babić', '1010988101124');
insert into osoba values (8,'Marko', 'Mirković', '1206986101234');
insert into osoba values (9,'Petar', 'Janković', '1210987100018');
insert into osoba  values (10,'Mirko', 'Filipović', '1312981163309');
insert into osoba values (11,'Jelena', 'Vasković', '1503990125037');
insert into osoba values (12,'Nenad', 'Savić', '1804964163303');
insert into osoba values (13,'Zoran', 'Lazić', '1907951100012');
insert into osoba values (14,'Janko', 'Janković', '2102979163201');
insert into osoba values (15,'Milena', 'Petković', '2108968196769');
insert into osoba values (16,'Milijana', 'Đukić', '2108988105034');
insert into osoba values (17,'Branka', 'Miljević', '2208988105039');
insert into osoba values (18,'Miloš', 'Ninković', '2804950103891');

insert into avio_kompanija values(1,2,3,"AvioKompanija1",4);
insert into poslovnica values(1,"123-456-789","poslovnica1@mail.com",1,1);

insert into posada values(1,2);

insert into nalog values(1,"password1","user1");
insert into nalog values(2,"password2","user2");
insert into nalog values(3,"password3","user3");

insert into zaposleni values('1983-08-05',1,"SSS",1,1,8);
insert into sluzbenik values(1,1);

insert into linija values(1,'07:00:00','08:00:00',1,2);
insert into linija values(2,'13:30:00','16:45:00',1,9);
insert into linija values(3,'06:00:00','08:15:00',2,4);
insert into linija values(4,'12:00:00','14:15:00',2,4);
insert into linija values(5,'08:00:00','14:25:00',1,7);
insert into linija values(6,'15:30:00','17:00:00',6,8);
insert into linija values(7,' 10:00:00','17:15:00',4,7);
insert into linija values(8,'11:00:00','14:15:00',2,9);
insert into linija values(9,'18:00:00','00:00:00',3,9);
insert into linija values(10,'18:00:00','23:00:00',6,9);
insert into linija values(11,'00:00:00','09:00:00',1,5);

insert into klasa values(1, "ekonomska");
insert into klasa values(2, "biznis");
insert into klasa values(3, "prva");

insert into avion values(1,50,"747","Boeing");
insert into avion values(2,120,"737","Boeing");
insert into avion values(3,100,"777","Boeing");
insert into avion values(4,200,"A320","Airbus");

insert into let values(1,1000,1,1,1,"2020-10-02",0);
insert into let values(2,1955,3,2,1,"2021-10-02",0);
insert into let values(3,2650,4,3,1,"2021-02-03",0);
insert into let values(4,1200,1,6,1,"2021-11-02",0);

insert into putnik values(4,"123456789");
insert into putnik values(18,"123456786");
insert into rezervacija values(4,"2020-10-01",1,null,1,1);
insert into rezervacija values(18,"2021-11-01",1,null,2,4);