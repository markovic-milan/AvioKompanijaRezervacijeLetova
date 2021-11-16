use mydb;

drop procedure if exists dodaj_rezervaciju;
delimiter $$
create procedure dodaj_rezervaciju (in ime varchar(45), in prezime varchar(45), in jmb varchar(45),
 in pasos varchar(45), in datumRezervacije date, in sluzbenikID int, in klasaID int, in letID int)
begin
insert into osoba values(null, ime, prezime, jmb);
insert into	putnik values(last_insert_id(), pasos);
insert into rezervacija values(last_insert_id(), datumRezervacije, sluzbenikID, null, klasaID, letID);
end $$
delimiter ;

drop procedure if exists azuriraj_rezervaciju;
delimiter $$
create procedure azuriraj_rezervaciju (in rezervacijaID int, in klasa int)
begin
update rezervacija r set r.KlasaID=klasa where r.RezervacijaID=rezervacijaID;
end $$
delimiter ;

drop procedure if exists azuriraj_liniju;
delimiter $$
create procedure azuriraj_liniju (in linijaID int, in odAerodromaID int, in doAerodromaID int, in vrijemePolaska time, in vrijemeDolaska time)
begin
update linija l set l.VrijemePolaska=vrijemePolaska, l.VrijemeDolaska=vrijemeDolaska, l.ODAerodromID=odAerodromaID, l.DOAerodromID=doAerodromaID where l.LinijaID=linijaID;
end $$
delimiter ;

drop procedure if exists pregled_po_klasi;
delimiter $$
create procedure pregled_po_klasi (in klasa varchar(45))
begin
select * from prikaz_rezervacija p where p.Klasa=klasa;
end $$
delimiter ;

drop procedure if exists sortiraj_po_distanci;
delimiter $$
create procedure sortiraj_po_distanci ()
begin
select * from prikaz_letova p order by p.Distanca;
end $$
delimiter ;

drop trigger if exists broj_putnika;
create trigger broj_putnika before insert on rezervacija
for each row
update let
set BrojPutnika=BrojPutnika+1
where LetID=new.LetID;