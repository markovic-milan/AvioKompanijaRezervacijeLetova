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

insert into aerodrom values(1,"Nikola Tesla",1);
insert into aerodrom values(2,"Mahovljani",2);
insert into aerodrom values(3,"Butmir",3);
insert into aerodrom values(4,"Frankfurt Airport",4);
insert into aerodrom values(5,"JFK Airport",5);

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
insert into poslovnica values(1,4,"123-456-789","poslovnica1@mail.com",1);

insert into posada values(1,2);

insert into nalog values(1,"password1","user1");
insert into nalog values(2,"password2","user2");
insert into nalog values(3,"password3","user3");

call dodaj_zaposlenog('1983-08-05',1,"SSS",1,1,8);
call dodaj_zaposlenog('1975-05-23',2,"VSS",1,2,3);
call dodaj_zaposlenog('1979-08-27',3,"VSS",1,3,2);

insert into sluzbenik values(1,1);
insert into pilot values(2,1);
insert into stjuardesa values(3,1);

insert into putnik values(4,"123456789");