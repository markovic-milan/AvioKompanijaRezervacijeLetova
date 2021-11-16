-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`adresa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`adresa` (
  `AdresaID` INT NOT NULL AUTO_INCREMENT,
  `Drzava` VARCHAR(45) NOT NULL,
  `Grad` VARCHAR(45) NOT NULL,
  `PostanskiBroj` INT NOT NULL,
  PRIMARY KEY (`AdresaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`avio_kompanija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`avio_kompanija` (
  `Avio_KompanijaID` INT NOT NULL AUTO_INCREMENT,
  `BrojPoslovnica` INT NOT NULL,
  `BrojZaposlenih` INT NOT NULL,
  `Naziv` VARCHAR(45) NOT NULL,
  `AdresaID` INT NOT NULL,
  PRIMARY KEY (`Avio_KompanijaID`),
  INDEX `fk_Avio_Kompanija_Adresa1_idx` (`AdresaID` ASC) VISIBLE,
  CONSTRAINT `fk_Avio_Kompanija_Adresa1`
    FOREIGN KEY (`AdresaID`)
    REFERENCES `mydb`.`adresa` (`AdresaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`nalog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`nalog` (
  `NalogID` INT NOT NULL AUTO_INCREMENT,
  `Sifra` VARCHAR(45) NOT NULL,
  `KorisnickoIme` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`NalogID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`osoba`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`osoba` (
  `OsobaID` INT NOT NULL AUTO_INCREMENT,
  `Ime` VARCHAR(45) NOT NULL,
  `Prezime` VARCHAR(45) NOT NULL,
  `Jmb` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`OsobaID`),
  UNIQUE INDEX `Jmb_UNIQUE` (`Jmb` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`zaposleni`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`zaposleni` (
  `DatumRodjenja` DATE NOT NULL,
  `ZaposleniID` INT NOT NULL AUTO_INCREMENT,
  `StrucnaSprema` VARCHAR(45) NOT NULL,
  `Avio_KompanijaID` INT NOT NULL,
  `NalogID` INT NOT NULL,
  `AdresaID` INT NOT NULL,
  PRIMARY KEY (`ZaposleniID`),
  INDEX `fk_Zaposleni_Avio_Kompanija1_idx` (`Avio_KompanijaID` ASC) VISIBLE,
  INDEX `fk_Zaposleni_Nalog1_idx` (`NalogID` ASC) VISIBLE,
  INDEX `fk_Zaposleni_Adresa1_idx` (`AdresaID` ASC) VISIBLE,
  CONSTRAINT `fk_Zaposleni_Adresa1`
    FOREIGN KEY (`AdresaID`)
    REFERENCES `mydb`.`adresa` (`AdresaID`),
  CONSTRAINT `fk_Zaposleni_Avio_Kompanija1`
    FOREIGN KEY (`Avio_KompanijaID`)
    REFERENCES `mydb`.`avio_kompanija` (`Avio_KompanijaID`),
  CONSTRAINT `fk_Zaposleni_Nalog1`
    FOREIGN KEY (`NalogID`)
    REFERENCES `mydb`.`nalog` (`NalogID`),
  CONSTRAINT `fk_Zaposleni_Osoba`
    FOREIGN KEY (`ZaposleniID`)
    REFERENCES `mydb`.`osoba` (`OsobaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`administrator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`administrator` (
  `AdministratorID` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`AdministratorID`),
  INDEX `fk_Administrator_Zaposleni1_idx` (`AdministratorID` ASC) VISIBLE,
  CONSTRAINT `fk_Administrator_Zaposleni1`
    FOREIGN KEY (`AdministratorID`)
    REFERENCES `mydb`.`zaposleni` (`ZaposleniID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`aerodrom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`aerodrom` (
  `AerodromID` INT NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(45) NOT NULL,
  `AdresaID` INT NOT NULL,
  PRIMARY KEY (`AerodromID`),
  INDEX `fk_Aerodrom_Adresa1_idx` (`AdresaID` ASC) VISIBLE,
  CONSTRAINT `fk_Aerodrom_Adresa1`
    FOREIGN KEY (`AdresaID`)
    REFERENCES `mydb`.`adresa` (`AdresaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`posada`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`posada` (
  `PosadaID` INT NOT NULL AUTO_INCREMENT,
  `BrojClanova` INT NOT NULL,
  PRIMARY KEY (`PosadaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`avion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`avion` (
  `AvionID` INT NOT NULL AUTO_INCREMENT,
  `UkupanBrojSjedista` INT NOT NULL,
  `Model` VARCHAR(45) NOT NULL,
  `Proizvodjac` VARCHAR(45) NOT NULL,
  `PosadaID` INT NOT NULL,
  PRIMARY KEY (`AvionID`),
  INDEX `fk_Avion_Posada1_idx` (`PosadaID` ASC) VISIBLE,
  CONSTRAINT `fk_Avion_Posada1`
    FOREIGN KEY (`PosadaID`)
    REFERENCES `mydb`.`posada` (`PosadaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`banka`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`banka` (
  `BankaID` INT NOT NULL AUTO_INCREMENT,
  `Naziv` VARCHAR(45) NOT NULL,
  `AdresaID` INT NOT NULL,
  PRIMARY KEY (`BankaID`),
  INDEX `fk_Banka_Adresa1_idx` (`AdresaID` ASC) VISIBLE,
  CONSTRAINT `fk_Banka_Adresa1`
    FOREIGN KEY (`AdresaID`)
    REFERENCES `mydb`.`adresa` (`AdresaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`let`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`let` (
  `LetID` INT NOT NULL AUTO_INCREMENT,
  `DatumIVrijemePolaska` DATETIME NOT NULL,
  `DatumIVrijemeDolaska` DATETIME NOT NULL,
  `ODAerodromID` INT NOT NULL,
  `DOAerodromID` INT NOT NULL,
  `Distanca` INT NOT NULL,
  `Trajanje` TIME NOT NULL,
  `AvionID` INT NOT NULL,
  PRIMARY KEY (`LetID`),
  UNIQUE INDEX `I` (`AvionID` ASC, `DatumIVrijemeDolaska` ASC, `DatumIVrijemePolaska` ASC) VISIBLE,
  INDEX `fk_Let_Aerodrom1_idx` (`ODAerodromID` ASC) VISIBLE,
  INDEX `fk_Let_Aerodrom2_idx` (`DOAerodromID` ASC) VISIBLE,
  INDEX `fk_Let_Avion1_idx` (`AvionID` ASC) VISIBLE,
  CONSTRAINT `fk_Let_Aerodrom1`
    FOREIGN KEY (`ODAerodromID`)
    REFERENCES `mydb`.`aerodrom` (`AerodromID`),
  CONSTRAINT `fk_Let_Aerodrom2`
    FOREIGN KEY (`DOAerodromID`)
    REFERENCES `mydb`.`aerodrom` (`AerodromID`),
  CONSTRAINT `fk_Let_Avion1`
    FOREIGN KEY (`AvionID`)
    REFERENCES `mydb`.`avion` (`AvionID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`putnik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`putnik` (
  `PutnikID` INT NOT NULL AUTO_INCREMENT,
  `Pasos` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PutnikID`),
  UNIQUE INDEX `Pasoš_UNIQUE` (`Pasos` ASC) VISIBLE,
  INDEX `fk_Putnik_Osoba1_idx` (`PutnikID` ASC) VISIBLE,
  CONSTRAINT `fk_Putnik_Osoba1`
    FOREIGN KEY (`PutnikID`)
    REFERENCES `mydb`.`osoba` (`OsobaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`poslovnica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`poslovnica` (
  `PoslovnicaID` INT NOT NULL AUTO_INCREMENT,
  `Adresa` VARCHAR(45) NOT NULL,
  `Telefon` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NOT NULL,
  `Avio_KompanijaID` INT NOT NULL,
  PRIMARY KEY (`PoslovnicaID`),
  INDEX `fk_Poslovnica_Avio_Kompanija1_idx` (`Avio_KompanijaID` ASC) VISIBLE,
  CONSTRAINT `fk_Poslovnica_Avio_Kompanija1`
    FOREIGN KEY (`Avio_KompanijaID`)
    REFERENCES `mydb`.`avio_kompanija` (`Avio_KompanijaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`sluzbenik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sluzbenik` (
  `SluzbenikID` INT NOT NULL AUTO_INCREMENT,
  `PoslovnicaID` INT NOT NULL,
  PRIMARY KEY (`SluzbenikID`, `PoslovnicaID`),
  INDEX `fk_Službenik_Poslovnica1_idx` (`PoslovnicaID` ASC) VISIBLE,
  CONSTRAINT `fk_Službenik_Poslovnica1`
    FOREIGN KEY (`PoslovnicaID`)
    REFERENCES `mydb`.`poslovnica` (`PoslovnicaID`),
  CONSTRAINT `fk_Službenik_Zaposleni1`
    FOREIGN KEY (`SluzbenikID`)
    REFERENCES `mydb`.`zaposleni` (`ZaposleniID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`rezervacija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`rezervacija` (
  `PutnikID` INT NOT NULL,
  `DatumRezervacije` DATE NOT NULL,
  `SluzbenikID` INT NOT NULL,
  `RezervacijaId` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`RezervacijaId`),
  INDEX `fk_Rezervacija_Putnik1_idx` (`PutnikID` ASC) VISIBLE,
  INDEX `fk_Rezervacija_Službenik1_idx` (`SluzbenikID` ASC) VISIBLE,
  CONSTRAINT `fk_Rezervacija_Putnik1`
    FOREIGN KEY (`PutnikID`)
    REFERENCES `mydb`.`putnik` (`PutnikID`),
  CONSTRAINT `fk_Rezervacija_Službenik1`
    FOREIGN KEY (`SluzbenikID`)
    REFERENCES `mydb`.`sluzbenik` (`SluzbenikID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`karta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`karta` (
  `Cijena` DECIMAL(10,0) NOT NULL,
  `Destinacija` VARCHAR(45) NOT NULL,
  `Klasa` VARCHAR(45) NOT NULL,
  `PutnikID` INT NOT NULL,
  `DatumIzdavanja` DATE NOT NULL,
  `BrojSjedista` INT NOT NULL,
  `RezervacijaId` INT NOT NULL,
  `LetID` INT NOT NULL,
  PRIMARY KEY (`PutnikID`, `LetID`),
  UNIQUE INDEX `PutnikID_UNIQUE` (`PutnikID` ASC) VISIBLE,
  UNIQUE INDEX `K` (`BrojSjedista` ASC, `LetID` ASC) VISIBLE,
  INDEX `fk_Karta_Putnik1_idx` (`PutnikID` ASC) VISIBLE,
  INDEX `fk_Karta_Rezervacija1_idx` (`RezervacijaId` ASC) VISIBLE,
  INDEX `fk_Karta_Let1_idx` (`LetID` ASC) VISIBLE,
  CONSTRAINT `fk_Karta_Let1`
    FOREIGN KEY (`LetID`)
    REFERENCES `mydb`.`let` (`LetID`),
  CONSTRAINT `fk_Karta_Putnik1`
    FOREIGN KEY (`PutnikID`)
    REFERENCES `mydb`.`putnik` (`PutnikID`),
  CONSTRAINT `fk_Karta_Rezervacija1`
    FOREIGN KEY (`RezervacijaId`)
    REFERENCES `mydb`.`rezervacija` (`RezervacijaId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`pilot`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`pilot` (
  `ZaposleniID` INT NOT NULL,
  `PosadaID` INT NOT NULL,
  PRIMARY KEY (`ZaposleniID`, `PosadaID`),
  INDEX `fk_Pilot_Posada1_idx` (`PosadaID` ASC) VISIBLE,
  CONSTRAINT `fk_Pilot_Posada1`
    FOREIGN KEY (`PosadaID`)
    REFERENCES `mydb`.`posada` (`PosadaID`),
  CONSTRAINT `fk_Pilot_Zaposleni1`
    FOREIGN KEY (`ZaposleniID`)
    REFERENCES `mydb`.`zaposleni` (`ZaposleniID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`racun_aviokompanije`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`racun_aviokompanije` (
  `Racun_AvioKompanijeID` INT NOT NULL AUTO_INCREMENT,
  `BrojRačuna` VARCHAR(45) NOT NULL,
  `BankaID` INT NOT NULL,
  `Avio_KompanijaID` INT NOT NULL,
  PRIMARY KEY (`Racun_AvioKompanijeID`),
  INDEX `fk_Račun_AvioKompanije_Banka1_idx` (`BankaID` ASC) VISIBLE,
  INDEX `fk_Račun_AvioKompanije_Avio_Kompanija1_idx` (`Avio_KompanijaID` ASC) VISIBLE,
  CONSTRAINT `fk_Račun_AvioKompanije_Avio_Kompanija1`
    FOREIGN KEY (`Avio_KompanijaID`)
    REFERENCES `mydb`.`avio_kompanija` (`Avio_KompanijaID`),
  CONSTRAINT `fk_Račun_AvioKompanije_Banka1`
    FOREIGN KEY (`BankaID`)
    REFERENCES `mydb`.`banka` (`BankaID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`racun_zaposlenog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`racun_zaposlenog` (
  `Racun_ZaposlenoID` INT NOT NULL AUTO_INCREMENT,
  `BankaID` INT NOT NULL,
  `BrojRačuna` VARCHAR(45) NOT NULL,
  `Zaposleni_ZaposleniID` INT NOT NULL,
  PRIMARY KEY (`Racun_ZaposlenoID`),
  INDEX `fk_Račun_Zaposlenog_Banka1_idx` (`BankaID` ASC) VISIBLE,
  INDEX `fk_Račun_Zaposlenog_Zaposleni1_idx` (`Zaposleni_ZaposleniID` ASC) VISIBLE,
  CONSTRAINT `fk_Račun_Zaposlenog_Banka1`
    FOREIGN KEY (`BankaID`)
    REFERENCES `mydb`.`banka` (`BankaID`),
  CONSTRAINT `fk_Račun_Zaposlenog_Zaposleni1`
    FOREIGN KEY (`Zaposleni_ZaposleniID`)
    REFERENCES `mydb`.`zaposleni` (`ZaposleniID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`stjuardesa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`stjuardesa` (
  `ZaposleniID` INT NOT NULL,
  `PosadaID` INT NOT NULL,
  PRIMARY KEY (`ZaposleniID`, `PosadaID`),
  INDEX `fk_Stjuardesa_Posada1_idx` (`PosadaID` ASC) VISIBLE,
  CONSTRAINT `fk_Stjuardesa_Posada1`
    FOREIGN KEY (`PosadaID`)
    REFERENCES `mydb`.`posada` (`PosadaID`),
  CONSTRAINT `fk_Stjuardesa_Zaposleni1`
    FOREIGN KEY (`ZaposleniID`)
    REFERENCES `mydb`.`zaposleni` (`ZaposleniID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`ugovor_o_radu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ugovor_o_radu` (
  `UgovorID` VARCHAR(45) NOT NULL,
  `Pozicija` VARCHAR(45) NOT NULL,
  `Plata` DECIMAL(10,0) NOT NULL,
  PRIMARY KEY (`UgovorID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `mydb`.`zaposleni_ugovor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`zaposleni_ugovor` (
  `Od` DATE NOT NULL,
  `Zaposleni_UgovorID` INT NOT NULL,
  `Ugovor_o_radu_ID` VARCHAR(45) NOT NULL,
  `Do` DATE NOT NULL,
  PRIMARY KEY (`Od`, `Zaposleni_UgovorID`, `Ugovor_o_radu_ID`),
  UNIQUE INDEX `Od_UNIQUE` (`Od` ASC) VISIBLE,
  INDEX `fk_Zaposleni_has_Ugovor_o_radu_Ugovor_o_radu1_idx` (`Ugovor_o_radu_ID` ASC) VISIBLE,
  INDEX `fk_Zaposleni_has_Ugovor_o_radu_Zaposleni1_idx` (`Zaposleni_UgovorID` ASC) VISIBLE,
  CONSTRAINT `fk_Zaposleni_has_Ugovor_o_radu_Ugovor_o_radu1`
    FOREIGN KEY (`Ugovor_o_radu_ID`)
    REFERENCES `mydb`.`ugovor_o_radu` (`UgovorID`),
  CONSTRAINT `fk_Zaposleni_has_Ugovor_o_radu_Zaposleni1`
    FOREIGN KEY (`Zaposleni_UgovorID`)
    REFERENCES `mydb`.`zaposleni` (`ZaposleniID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
