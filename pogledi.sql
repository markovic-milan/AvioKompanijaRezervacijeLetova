use mydb;

drop view if exists prikaz_rezervacija;
create view prikaz_rezervacija (RezervacijaID, Datum_Leta, Klasa, Putnik, Sluzbenik, Polazi_iz, Dolazi_u, PutnikID) as 
select RezervacijaID,  l.DatumLeta, k.Naziv,concat(o.Ime, ' ', o.Prezime),concat(o1.Ime, ' ', o1.Prezime), ad.Grad, ad1.Grad, PutnikID from rezervacija r
inner join Klasa k on r.KlasaID=k.KlasaID 
inner join Let l on r.LetID=l.LetID
inner join Linija lin on lin.LinijaID=l.LinijaID
inner join Aerodrom a on a.AerodromID=lin.ODAerodromID
inner join Aerodrom a1 on a1.AerodromID=lin.DOAerodromID
inner join Adresa ad on ad.AdresaID=a.AdresaID
inner join Adresa ad1 on ad1.AdresaID=a1.AdresaID
inner join osoba o on o.OsobaID=r.PutnikID
inner join osoba o1 on o1.OsobaID=r.SluzbenikID order by RezervacijaID;

drop view if exists prikaz_linija;
create view prikaz_linija (LinijaID, VrijemePolaska, VrijemeDolaska, Polazi_sa, Dolazi_na) as
select LinijaID,VrijemePolaska ,VrijemeDolaska,a.Naziv,a1.Naziv from linija l
inner join aerodrom a on l.ODAerodromID=a.AerodromID
inner join aerodrom a1 on l.DOAerodromID=a1.AerodromID;

drop view if exists prikaz_letova;
create view prikaz_letova (LetID, Distanca, AvionID, LinijaID, PosadaID, DatumLeta, BrojPutnika) as 
select LetID, Distanca, concat(a.Proizvodjac, " - ", a.Model), concat(ad.Grad, " - ", ad1.Grad), PosadaID, DatumLeta, BrojPutnika from let l
inner join Avion a on l.AvionID=a.AvionID
inner join Linija lin on lin.LinijaID=l.LinijaID
inner join Aerodrom a0 on a0.AerodromID=lin.ODAerodromID
inner join Aerodrom a1 on a1.AerodromID=lin.DOAerodromID
inner join Adresa ad on ad.AdresaID=a0.AdresaID
inner join Adresa ad1 on ad1.AdresaID=a1.AdresaID;