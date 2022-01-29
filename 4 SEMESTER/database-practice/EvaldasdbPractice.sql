create database dbPractice;
use dbPractice;

CREATE TABLE `dbPractice`.`PapildomaPaslauga` ( `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT , `pavadinimas` VARCHAR(20) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`UzsakytaPapildomaPaslauga` ( `id` INT NOT NULL AUTO_INCREMENT , `uzsak.Data` DATE NOT NULL , `atsisak.Data` DATE NOT NULL , `abonentoID` INT NOT NULL , `op.papild.ID` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`OperatoriausPapildomaPaslauga` ( `id` INT NOT NULL AUTO_INCREMENT , `operat.ID` INT NOT NULL , `pap.paslgID` INT NOT NULL , `kaina` DECIMAL NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`PaslaugosKainaZonoje` ( `id` INT NOT NULL AUTO_INCREMENT , `operat.ID` INT NOT NULL , `paslg.ID` INT NOT NULL , `zonosID` INT NOT NULL , `kaina` DECIMAL NOT NULL , `initZonoje` VARCHAR(20) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`Salis` ( `id` INT NOT NULL AUTO_INCREMENT , `saliesKodas` VARCHAR(20) NOT NULL , `zonosID` INT NOT NULL , `pavadinimas` VARCHAR(20) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`RysisP2P` ( `id` INT NOT NULL AUTO_INCREMENT , `abo.ID` INT NOT NULL , `rysioInitVieta` VARCHAR(20) NOT NULL , `adresatoID` INT NOT NULL , `paslg.ID` INT NOT NULL , `adresatoNR` VARCHAR(20) NOT NULL , `rysioPradzia` DATE NOT NULL , `rysioPabaiga` DATE NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`Paslauga` ( `id` INT NOT NULL AUTO_INCREMENT , `pavadinimas` VARCHAR(20) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`Zona` ( `id` INT NOT NULL AUTO_INCREMENT , `pavadinimas` VARCHAR(20) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`UzsakytaLengvata` ( `id` INT NOT NULL AUTO_INCREMENT , `abo.ID` INT NOT NULL , `komplektoID` INT NOT NULL , `uzsakData` DATE NOT NULL , `atsisakData` DATE NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`UzsakomaLengvata` ( `id` INT NOT NULL AUTO_INCREMENT , `komplektoID` INT NOT NULL , `rinkinioID` INT NOT NULL , `kiekis` INT NOT NULL , `kaina` DECIMAL NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`PlanoRinkinys` ( `id` INT NOT NULL AUTO_INCREMENT , `planoID` INT NOT NULL , `paslg.ID` INT NOT NULL , `kaina` DECIMAL NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`Lengvata` ( `id` INT NOT NULL AUTO_INCREMENT , `rinkinioID` INT NOT NULL , `kiekis` INT NOT NULL , `kaina` DECIMAL NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`Abonentas` ( `id` INT NOT NULL AUTO_INCREMENT , `asmensID` INT NOT NULL , `planoID` INT NOT NULL , `numeris` VARCHAR(20) NOT NULL , `sutPradzia` DATE NOT NULL , `sutPabaiga` DATE NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`RysysInternetu` ( `id` INT NOT NULL AUTO_INCREMENT , `aboID` INT NOT NULL , `kieksMB` INT NOT NULL , `rysioPradzia` DATE NOT NULL , `rysioPabaiga` DATE NOT NULL , `sutPabaiga` DATE NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`Asmuo` ( `id` INT NOT NULL AUTO_INCREMENT , `miestoID` INT NOT NULL , `vardas` VARCHAR(30) NOT NULL , `pavarde` VARCHAR(30) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`Miestas` ( `id` INT NOT NULL AUTO_INCREMENT , `pavadinimas` VARCHAR(100) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`Planas` ( `id` INT NOT NULL AUTO_INCREMENT , `tipoID` INT NOT NULL , `operatID` INT NOT NULL , `pavadinimas` VARCHAR(50) NOT NULL , `kaina` DECIMAL NOT NULL , `internetoKiekis` INT NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`Operatorius` ( `id` INT NOT NULL AUTO_INCREMENT , `pavadinimas` VARCHAR(50) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`PlanoTipas` ( `id` INT NOT NULL AUTO_INCREMENT , `pavadinimas` VARCHAR(50) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`Devices` ( `id` INT NOT NULL AUTO_INCREMENT , `typeID` INT NOT NULL , `pavadinimas` VARCHAR(50) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`DeviceType` ( `id` INT NOT NULL AUTO_INCREMENT , `pavadinimas` VARCHAR(50) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 

CREATE TABLE `dbPractice`.`UzsakytasPapildomasInternetoPlanas` ( `id` INT NOT NULL AUTO_INCREMENT , `aboID` INT NOT NULL , `papildomoInternetoPlanoID` INT NOT NULL , `uzsak.Data` DATE NOT NULL , `atsisakData` DATE NOT NULL , `kaina` DECIMAL NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB; 


ALTER TABLE `UzsakytaPapildomaPaslauga` ADD CONSTRAINT `aboIDkey` FOREIGN KEY (`abonentoID`) REFERENCES `Abonentas`(`id`) ON DELETE CASCADE ON UPDATE CASCADE; 

ALTER TABLE `OperatoriausPapildomaPaslauga` ADD CONSTRAINT `operatorKey` FOREIGN KEY (`operat.ID`) REFERENCES `Operatorius`(`id`) ON DELETE CASCADE ON UPDATE CASCADE; ALTER TABLE `OperatoriausPapildomaPaslauga` ADD CONSTRAINT `papildPaslaugosKey` FOREIGN KEY (`pap.paslgID`) REFERENCES `PapildomaPaslauga`(`id`) ON DELETE CASCADE ON UPDATE CASCADE; 

ALTER TABLE `PaslaugosKainaZonoje` ADD CONSTRAINT `operatKey` FOREIGN KEY (`operat.ID`) REFERENCES `Operatorius`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ALTER TABLE `PaslaugosKainaZonoje` ADD CONSTRAINT `paslaugosKey` FOREIGN KEY (`paslg.ID`) REFERENCES `Paslauga`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;  ALTER TABLE `PaslaugosKainaZonoje` ADD CONSTRAINT `zonosKey` FOREIGN KEY (`zonosID`) REFERENCES `Zona`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `Salis` ADD CONSTRAINT `zonosFK` FOREIGN KEY (`zonosID`) REFERENCES `Zona`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `RysisP2P` ADD CONSTRAINT `aboIDFK` FOREIGN KEY (`abo.ID`) REFERENCES `Abonentas`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ALTER TABLE `RysisP2P` ADD CONSTRAINT `adresatoID` FOREIGN KEY (`adresatoID`) REFERENCES `Asmuo`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ALTER TABLE `RysisP2P` ADD CONSTRAINT `paslg.ID` FOREIGN KEY (`paslg.ID`) REFERENCES `Paslauga`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `UzsakytaLengvata` ADD CONSTRAINT `komplektoID` FOREIGN KEY (`komplektoID`) REFERENCES `UzsakomaLengvata`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `UzsakomaLengvata` ADD CONSTRAINT `rinkioFK` FOREIGN KEY (`rinkinioID`) REFERENCES `PlanoRinkinys`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `PlanoRinkinys` ADD CONSTRAINT `planoFK` FOREIGN KEY (`planoID`) REFERENCES `Planas`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ALTER TABLE `PlanoRinkinys` ADD CONSTRAINT `paslaugFK` FOREIGN KEY (`paslg.ID`) REFERENCES `Paslauga`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `Lengvata` ADD CONSTRAINT `rinkinioFK` FOREIGN KEY (`rinkinioID`) REFERENCES `PlanoRinkinys`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `Abonentas` ADD CONSTRAINT `asmensID` FOREIGN KEY (`asmensID`) REFERENCES `Asmuo`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ALTER TABLE `Abonentas` ADD CONSTRAINT `planoIDFK` FOREIGN KEY (`planoID`) REFERENCES `Planas`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `RysysInternetu` ADD CONSTRAINT `aboFK` FOREIGN KEY (`aboID`) REFERENCES `Abonentas`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `Asmuo` ADD CONSTRAINT `miestoFK` FOREIGN KEY (`miestoID`) REFERENCES `Miestas`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `Planas` ADD CONSTRAINT `tipoFK` FOREIGN KEY (`tipoID`) REFERENCES `PlanoTipas`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; ALTER TABLE `Planas` ADD CONSTRAINT `opFK` FOREIGN KEY (`operatID`) REFERENCES `Operatorius`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `Devices` ADD CONSTRAINT `typeFK` FOREIGN KEY (`typeID`) REFERENCES `DeviceType`(`id`) ON DELETE RESTRICT ON UPDATE RESTRICT; 

ALTER TABLE `UzsakytasPapildomasInternetoPlanas` ADD CONSTRAINT `abouzsakFK` FOREIGN KEY (`aboID`) REFERENCES `Abonentas`(`id`) ON DELETE CASCADE ON UPDATE CASCADE; ALTER TABLE `UzsakytasPapildomasInternetoPlanas` ADD CONSTRAINT `papIntFK` FOREIGN KEY (`papildomoInternetoPlanoID`) REFERENCES `Planas`(`id`) ON DELETE CASCADE ON UPDATE CASCADE; 

ALTER TABLE `UzsakytaPapildomaPaslauga` ADD CONSTRAINT `opPapilFK` FOREIGN KEY (`op.papild.ID`) REFERENCES `OperatoriausPapildomaPaslauga`(`id`) ON DELETE CASCADE ON UPDATE CASCADE; 


INSERT INTO `Zona` (`id`, `pavadinimas`) VALUES (NULL, 'Kazkokia1'), (NULL, 'Test2000'), (NULL, 'Neta'), (NULL, 'Juodsiliai'), (NULL, 'Panevezys'), (NULL, 'Futbolo'), (NULL, 'Krepsinio'), (NULL, 'TaipYra'), (NULL, 'KaipYra'), (NULL, 'KaPadarysi'), (NULL, 'Nespeju'), (NULL, 'DaugDarbo'), (NULL, 'hmmm'), (NULL, 'adsads'), (NULL, 'Blah'), (NULL, 'Raudona'), (NULL, 'Juoda'), (NULL, 'Zalia'), (NULL, 'Miego'), (NULL, 'Crap') 

INSERT INTO `Salis` (`id`, `saliesKodas`, `zonosID`, `pavadinimas`) VALUES (NULL, 'FR', '16', 'France'), (NULL, 'UK', '19', 'Britain'), (NULL, 'SPN', '17', 'Ispanija'), (NULL, 'SK', '18', 'Slovakija'), (NULL, 'PL', '18', 'Lenkija'), (NULL, 'GER', '12', 'Vokietija'), (NULL, 'EG', '13', 'Egypt'), (NULL, 'USA', '16', 'USA'), (NULL, 'DK', '15', 'Danija'), (NULL, 'LTU', '18', 'Lietuva') 

INSERT INTO `PapildomaPaslauga` (`id`, `pavadinimas`) VALUES (NULL, 'MobilusParasas'), (NULL, 'UzsienioSkambuciai') 

INSERT INTO `Paslauga` (`id`, `pavadinimas`) VALUES (NULL, 'Greitasis'), (NULL, 'Greitasis+'), (NULL, 'Brangusis'), (NULL, 'BrangusisExtra'), (NULL, 'Bomzams') 

INSERT INTO `Miestas` (`id`, `pavadinimas`) VALUES (NULL, 'Vilnius'), (NULL, 'Kaunas'), (NULL, 'Panevezys'), (NULL, 'Siauliai'), (NULL, 'Berlin') 

INSERT INTO `Operatorius` (`id`, `pavadinimas`) VALUES (NULL, 'Tele2'), (NULL, 'Telia'), (NULL, 'Bite') 

INSERT INTO `PlanoTipas` (`id`, `pavadinimas`) VALUES (NULL, 'Start1'), (NULL, 'Start2'), (NULL, 'LabaiExtra'), (NULL, 'Blogasis') 

INSERT INTO `DeviceType` (`id`, `pavadinimas`) VALUES (NULL, 'Kompiuteris'), (NULL, 'Telefonas'), (NULL, 'Plancete'), (NULL, 'Smart Watch') 

INSERT INTO `Devices` (`id`, `typeID`, `pavadinimas`) VALUES (NULL, '1', 'MacBookPro'), (NULL, '1', 'Thinkpad '), (NULL, '2', 'Iphone 7'), (NULL, '2', 'Samsung Galaxy S3'), (NULL, '2', 'Nokia 3310'), (NULL, '4', 'Apple watch'), (NULL, '3', 'iPad Pro'), (NULL, '3', 'iPad mini'), (NULL, '2', 'Iphone 11'), (NULL, '2', 'Iphone 8') 

INSERT INTO `Asmuo` (`id`, `miestoID`, `vardas`, `pavarde`) VALUES (NULL, '1', 'Evaldas', 'Paulauskas'), (NULL, '5', 'Samuel', 'Wohl'), (NULL, '2', 'Monika', 'Asdfg'), (NULL, '4', 'Justinas', 'Zailskas'), (NULL, '3', 'Mantas', 'Stankevicius') 

INSERT INTO `Planas` (`id`, `tipoID`, `operatID`, `pavadinimas`, `kaina`, `internetoKiekis`) VALUES (NULL, '1', '3', 'Studentiskas', '5', '1000'), (NULL, '2', '3', 'Studentiskas', '10', '2000') 
INSERT INTO `Planas` (`id`, `tipoID`, `operatID`, `pavadinimas`, `kaina`, `internetoKiekis`) VALUES (NULL, '1', '1', 'Studentiskas', '6', '1500'), (NULL, '2', '1', 'Studentiskas', '7', '2500'), (NULL, '3', '1', 'Verslininkams', '29', '100000') 
INSERT INTO `Planas` (`id`, `tipoID`, `operatID`, `pavadinimas`, `kaina`, `internetoKiekis`) VALUES (NULL, '4', '2', 'Studentiskas', '9', '500'), (NULL, '4', '2', 'Verslininkams', '30', '40000'), (NULL, '3', '2', 'Verslininkams', '60', '99999'), (NULL, '3', '2', 'Studentiskas', '15', '8000') 


INSERT INTO `Abonentas` (`id`, `asmensID`, `planoID`, `numeris`, `sutPradzia`, `sutPabaiga`) VALUES (NULL, '1', '6', '1111111', '2020-05-06', '2020-12-02'), (NULL, '2', '13', '999999', '2020-06-05', '2021-11-12'), (NULL, '5', '11', '123123123', '2020-04-07', '2020-07-01'), (NULL, '4', '12', '789789', '2020-07-01', '2020-09-11'), (NULL, '3', '7', '456456', '2020-06-04', '2020-06-30') 

INSERT INTO `OperatoriausPapildomaPaslauga` (`id`, `operat.ID`, `pap.paslgID`, `kaina`) VALUES (NULL, '3', '1', '5'), (NULL, '3', '2', '10'), (NULL, '1', '2', '12'), (NULL, '1', '1', '6'), (NULL, '2', '1', '30'), (NULL, '2', '2', '3') 

INSERT INTO `PaslaugosKainaZonoje` (`id`, `operat.ID`, `paslg.ID`, `zonosID`, `kaina`, `initZonoje`) VALUES (NULL, '3', '3', '18', '50', 'cvbbcv'), (NULL, '1', '5', '18', '10', 'xzxzc'), (NULL, '2', '3', '18', '60', 'asdads'), (NULL, '3', '5', '18', '11', 'hjk'), (NULL, '1', '3', '18', '75', 'fgh'), (NULL, '2', '5', '18', '3', 'Asd') 

INSERT INTO `PlanoRinkinys` (`id`, `planoID`, `paslg.ID`, `kaina`) VALUES (NULL, '6', '5', '30'), (NULL, '7', '3', '50'), (NULL, '8', '4', '60'), (NULL, '9', '1', '20'), (NULL, '11', '2', '25'), (NULL, '14', '5', '15'), (NULL, '10', '3', '70'), (NULL, '12', '4', '80'), (NULL, '13', '1', '90') 

INSERT INTO `RysisP2P` (`id`, `abo.ID`, `rysioInitVieta`, `adresatoID`, `paslg.ID`, `adresatoNR`, `rysioPradzia`, `rysioPabaiga`) VALUES (NULL, '1', 'Mokyklos g', '1', '5', '111111', '2020-06-05', '2020-06-30'), (NULL, '2', 'Jegos g', '2', '1', '22222', '2020-06-03', '2020-06-26'), (NULL, '3', 'Obuoliu g', '3', '2', '33333', '2020-06-01', '2020-06-24'), (NULL, '4', 'Stirnu g', '4', '3', '443444', '2020-06-03', '2020-06-27'), (NULL, '5', 'Panevezio g.', '5', '4', '555555', '2020-06-05', '2020-06-23') 

INSERT INTO `RysysInternetu` (`id`, `aboID`, `kieksMB`, `rysioPradzia`, `rysioPabaiga`, `sutPabaiga`) VALUES (NULL, '1', '99999', '2020-06-05', '2020-06-30', '2020-07-28'), (NULL, '2', '5000', '2020-06-05', '2020-06-30', '2020-07-08') 

INSERT INTO `UzsakomaLengvata` (`id`, `rinkinioID`, `kiekis`, `kaina`) VALUES (NULL, '1', '5', '4'), (NULL, '2', '2', '1'), (NULL, '3', '1', '1'), (NULL, '4', '10', '8'), (NULL, '5', '20', '12'), (NULL, '6', '25', '15'), (NULL, '7', '30', '20'), (NULL, '8', '2', '4'), (NULL, '9', '3', '5') 

INSERT INTO `UzsakytaLengvata` (`id`, `abo.ID`, `komplektoID`, `uzsakData`, `atsisakData`) VALUES (NULL, '1', '1', '2020-06-05', '2020-06-24'), (NULL, '2', '2', '2020-06-05', '2020-06-24'), (NULL, '3', '3', '2020-06-05', '2020-06-24'), (NULL, '4', '4', '2020-06-05', '2020-06-24'), (NULL, '5', '5', '2020-06-05', '2020-06-24') 

INSERT INTO `UzsakytaPapildomaPaslauga` (`id`, `uzsak.Data`, `atsisak.Data`, `abonentoID`, `op.papild.ID`) VALUES (NULL, '2020-06-05', '2020-06-30', '2', '3'), (NULL, '2020-06-12', '2020-07-09', '1', '1') 

INSERT INTO `UzsakytasPapildomasInternetoPlanas` (`id`, `aboID`, `papildomoInternetoPlanoID`, `uzsak.Data`, `atsisakData`, `kaina`) VALUES (NULL, '1', '7', '2020-06-05', '2020-07-05', '9'), (NULL, '5', '13', '2020-06-12', '2020-07-12', '15') 

INSERT INTO `Lengvata` (`id`, `rinkinioID`, `kiekis`, `kaina`) VALUES (NULL, '1', '60', '9'), (NULL, '2', '25', '7'), (NULL, '3', '30', '8'), (NULL, '4', '9', '3'), (NULL, '5', '5', '2'), (NULL, '6', '10', '6'), (NULL, '7', '15', '5'), (NULL, '8', '20', '7'), (NULL, '9', '10', '8') 




SELECT * FROM `Abonentas` WHERE `asmensID` = 1 

# Print all users with abonents

SELECT Asmuo.vardas, Asmuo.pavarde
FROM Abonentas
INNER JOIN Asmuo ON Abonentas.asmensID = Asmuo.id


# Print plan name and its price for each abonent and user, with some dates

SELECT Planas.pavadinimas, Planas.kaina ,Asmuo.vardas, Asmuo.pavarde, Abonentas.sutPradzia, Abonentas.sutPabaiga
FROM Abonentas
INNER JOIN Asmuo ON Abonentas.asmensID = Asmuo.id
INNER JOIN Planas ON Abonentas.planoID = Planas.id


# How many devices are created

SELECT COUNT(*) FROM `Devices`

# How many PlanoRinkinys are there that are more expensive than 10

SELECT COUNT(*) FROM `PlanoRinkinys` WHERE PlanoRinkinys.kaina > 10
