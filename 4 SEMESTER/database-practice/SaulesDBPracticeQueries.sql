DROP DATABASE practiceDB;
CREATE DATABASE practiceDB;
USE practiceDB;

CREATE TABLE IrangosTipas(
	irangosTipoID INTEGER AUTO_INCREMENT NOT NULL,
    irangosTipoPavadinimas VARCHAR(20) NOT NULL,
    PRIMARY KEY(irangosTipoID)
);
    
CREATE TABLE Iranga(
	irangosID INTEGER AUTO_INCREMENT NOT NULL,
    irangosPavadinimas VARCHAR(100) NOT NULL,
    IrangosTipoID INTEGER NOT NULL, /*FK*/
    PRIMARY KEY(irangosID)
);

CREATE TABLE Planas(
	planoID INTEGER AUTO_INCREMENT NOT NULL,
    planoPavadinimas VARCHAR(60),
    kaina DECIMAL(4, 2),
    tipoID INTEGER, /*FK*/
    operatoriausID INTEGER, /*FK*/
    internetoPlanoID INTEGER, /*FK*/
    PRIMARY KEY(planoID)
);

CREATE TABLE PlanoTipas(
	tipoID INTEGER AUTO_INCREMENT NOT NULL,
    tipoPavadinimas VARCHAR(20),
    PRIMARY KEY(tipoID)
);

CREATE TABLE PlanoRinkinys(
	rinkinioID INTEGER AUTO_INCREMENT NOT NULL,
    kaina DECIMAL(4, 2),
    planoID INTEGER, /*FK*/
    paslaugosID INTEGER, /*FK*/
    PRIMARY KEY(rinkinioID)
);

CREATE TABLE Paslauga(
	paslaugosID INTEGER AUTO_INCREMENT NOT NULL,
    paslaugosPavadinimas VARCHAR(50),
    PRIMARY KEY(paslaugosID)
);

CREATE TABLE RysysP2P(
	abonentoID INTEGER,
    saliesKodas CHAR(6),
	paslaugosID INTEGER,
    adresatoNumeris VARCHAR(15),
    rysioPradzia DATETIME, /*YYY-MM-DD hh:mm:ss*/
    rysioPabaiga DATETIME /*YYY-MM-DD hh:mm:ss*/
    /*foreign keys???*/
);

CREATE TABLE Salis(
	saliesKodas CHAR(6),
    saliesPavadinimas VARCHAR(40),
    zonosID INTEGER,
    PRIMARY KEY(saliesKodas)
);

CREATE TABLE Zona(
	zonosID INTEGER AUTO_INCREMENT NOT NULL,
    zonosPavadinimas VARCHAR(50),
    PRIMARY KEY(zonosID)
);

CREATE TABLE PaslaugosKainaZonoje(
	operatoriausID INTEGER,
    paslaugosID INTEGER,
    zonosID INTEGER,
    kaina DECIMAL(5, 2),
    inicijuotaZonoje BIT /*??? gal BOOL? idk*/
    /*FOREIGN KEY(operatoriausID) REFERENCES Operatorius(operatoriausID), */
    /*FOREIGN KEY(paslaugosID) REFERENCES Paslauga(paslaugosID),*/
    /*FOREIGN KEY(zonosID) REFERENCES Zona(zonosID)*/
);

CREATE TABLE Operatorius(
	operatoriausID INTEGER AUTO_INCREMENT NOT NULL,
    operatoriausPavadinimas VARCHAR(10),
    PRIMARY KEY(operatoriausID)
);

CREATE TABLE InternetoPlanas(
	internetoPlanoID INTEGER AUTO_INCREMENT NOT NULL,
    planoPavadinimas VARCHAR(50),
    kiekisGB CHAR(10),
    kaina DECIMAL(5, 2),
    papildomaKaina DECIMAL(4, 2),
    operatoriausID INTEGER,
    PRIMARY KEY(internetoPlanoID)
);

CREATE TABLE Abonentas(
	abonentoID INTEGER AUTO_INCREMENT NOT NULL,
    sutartiesPradzia DATETIME, /*YYY-MM-DD hh:mm:ss*/
    sutartiesPabaiga DATETIME, /*YYY-MM-DD hh:mm:ss*/
    asmensID INTEGER,
    planoID INTEGER,
    PRIMARY KEY(abonentoID)
);

CREATE TABLE RysysInternetu(
	abonentoID INTEGER,
    kiekisGB INTEGER,
    kaina DECIMAL(5, 2),
    rysioPradzia DATETIME, /*YYY-MM-DD hh:mm:ss*/
    rysioPabaiga DATETIME /*YYY-MM-DD hh:mm:ss*/
);

CREATE TABLE Asmuo(
	asmensID INTEGER AUTO_INCREMENT NOT NULL,
    vardas VARCHAR(25),
    pavarde VARCHAR(20),
    telefonoNumeris CHAR(15),
    gyvenamosiosVietosID INTEGER,
    PRIMARY KEY(asmensID)
);

CREATE TABLE GyvenamojiVieta(
	gyvenamosiosVietosID INTEGER AUTO_INCREMENT NOT NULL,
    miestoPavadinimas VARCHAR(25),
    gatvesPavadinimas VARCHAR(25),
    namoNumeris VARCHAR(6),
    butoNumeris VARCHAR(6),
    PRIMARY KEY(gyvenamosiosVietosID)
);

CREATE TABLE UzsakytaLengvata(
	abonentoID INTEGER,
    komplektoID INTEGER,
    uzsakymoData DATETIME, /*YYY-MM-DD hh:mm:ss*/
    atsisakymoData DATETIME /*YYY-MM-DD hh:mm:ss*/
);

CREATE TABLE UzsakomaLengvata(
	komplektoID INTEGER AUTO_INCREMENT NOT NULL,
    kiekis INTEGER,
    kaina DECIMAL(5,2),
    rinkinioID INTEGER,
    PRIMARY KEY(komplektoID)
);

CREATE TABLE Lengvata(
	lengvatosID INTEGER AUTO_INCREMENT NOT NULL,
    kiekis INTEGER,
    kaina DECIMAL(5, 2),
    rinkinioID INTEGER,
    PRIMARY KEY(lengvatosID)
);

CREATE TABLE UzsakytasInternetoPlanas(
	internetoPlanoID INTEGER,
    abonentoID INTEGER,
    uzsakymoData DATETIME, /*YYY-MM-DD hh:mm:ss*/
    atsisakymoData DATETIME /*YYY-MM-DD hh:mm:ss*/
);

/*========================================AlterStuff=================================================*/

ALTER TABLE Iranga ADD CONSTRAINT FOREIGN KEY(irangosTipoID) REFERENCES IrangosTipas(irangosTipoID);
ALTER TABLE Planas ADD CONSTRAINT FOREIGN KEY(tipoID) REFERENCES PlanoTipas(tipoID);
ALTER TABLE Planas ADD CONSTRAINT FOREIGN KEY(operatoriausID) REFERENCES Operatorius(operatoriausID);
ALTER TABLE Planas ADD CONSTRAINT FOREIGN KEY(internetoPlanoID) REFERENCES InternetoPlanas(internetoPlanoID);
ALTER TABLE PlanoRinkinys ADD CONSTRAINT FOREIGN KEY(planoID) REFERENCES Planas(planoID);
ALTER TABLE PlanoRinkinys ADD CONSTRAINT FOREIGN KEY(paslaugosID) REFERENCES Paslauga(paslaugosID);
ALTER TABLE Lengvata ADD CONSTRAINT FOREIGN KEY(rinkinioID) REFERENCES PlanoRinkinys(rinkinioID);
ALTER TABLE UzsakomaLengvata ADD CONSTRAINT FOREIGN KEY(rinkinioID) REFERENCES PlanoRinkinys(rinkinioID);
ALTER TABLE UzsakytaLengvata ADD CONSTRAINT FOREIGN KEY(abonentoID) REFERENCES Abonentas(abonentoID);
ALTER TABLE UzsakytaLengvata ADD CONSTRAINT FOREIGN KEY(komplektoID) REFERENCES UzsakomaLengvata(komplektoID);
ALTER TABLE Abonentas ADD CONSTRAINT FOREIGN KEY(asmensID) REFERENCES Asmuo(asmensID);
ALTER TABLE Abonentas ADD CONSTRAINT FOREIGN KEY(planoID) REFERENCES Planas(planoID);
ALTER TABLE Asmuo ADD CONSTRAINT FOREIGN KEY(gyvenamosiosVietosID) REFERENCES GyvenamojiVieta(gyvenamosiosVietosID);
ALTER TABLE InternetoPlanas ADD CONSTRAINT FOREIGN KEY(operatoriausID) REFERENCES Operatorius(operatoriausID);
ALTER TABLE UzsakytasInternetoPlanas ADD CONSTRAINT FOREIGN KEY(internetoPlanoID) REFERENCES InternetoPlanas(internetoPlanoID);
ALTER TABLE UzsakytasInternetoPlanas ADD CONSTRAINT FOREIGN KEY(abonentoID) REFERENCES Abonentas(abonentoID);
ALTER TABLE PaslaugosKainaZonoje ADD CONSTRAINT FOREIGN KEY(operatoriausID) REFERENCES Operatorius(operatoriausID);
ALTER TABLE PaslaugosKainaZonoje ADD CONSTRAINT FOREIGN KEY(paslaugosID) REFERENCES Paslauga(paslaugosID);
ALTER TABLE PaslaugosKainaZonoje ADD CONSTRAINT FOREIGN KEY(zonosID) REFERENCES Zona(zonosID);
ALTER TABLE Salis ADD CONSTRAINT FOREIGN KEY(zonosID) REFERENCES Zona(zonosID);
ALTER TABLE RysysP2P ADD CONSTRAINT FOREIGN KEY(abonentoID) REFERENCES Abonentas(abonentoID);
ALTER TABLE RysysP2P ADD CONSTRAINT FOREIGN KEY(saliesKodas) REFERENCES Salis(saliesKodas);
ALTER TABLE RysysP2P ADD CONSTRAINT FOREIGN KEY(paslaugosID) REFERENCES Paslauga(paslaugosID);

/*========================================InsertStuff=================================================*/

INSERT INTO IrangosTipas(irangosTipoPavadinimas)
VALUES
	('Telefonai'),
    ('Kompiuteriai'),
    ('Modemai'),
    ('Televizoriai'),
    ('Plansetes'),
	('Laikrodziai'),
    ('Apyrankes');

INSERT INTO Iranga(irangosPavadinimas, IrangosTipoID)
VALUES
	('Sony Xperia 1 II ', 1),
    ('Apple iPhone SE (2020) 256GB', 1),
    ('Apple iPhone 7 32GB', 1),
    ('Samsung Galaxy A71', 1),
    ('Huawei P30 Lite', 1),
    ('OnePlus 7 128GB', 1),
    ('Huawei P Smart Z', 1),
    ('Xiaomi Redmi Note 8T', 1),
    ('Xiaomi Mi Note 10', 1),
    ('LG K40S', 1),
    ('Lenovo Ideapad S340-14IWL', 2),
    ('HP 250 G7', 2),
    ('Prestigio Smartbook 141 C3 14.1"', 2),
    ('Asus X509JA-BQ039T', 2),
    ('Asus VivoBook X412DA-EB050T', 2),
    ('Acer Aspire 5 A515-55-591C', 2),
    ('Lenovo IdeaPad S540-14IML', 2),
    ('Dell Inspiron 14 5491', 2),
    ('Apple MacBook Air 13” (2020)', 2),
    ('Apple MacBook Pro 13" (2019)', 2),
    ('Huawei MediaPad T5', 5),
    ('Samsung Galaxy Tab A (2019, 10.1, LTE)', 5),
    ('Lenovo Yoga Smart Tab 10.1"', 5),
    ('Lenovo Tab M10 10” LTE', 5),
    ('Lenovo Tab M10 Plus 10"', 5),
    ('Samsung Galaxy Tab S6 Lite', 5),
    ('Apple iPad 10.2 32 GB (2019)', 5),
    ('Apple iPad Pro 12.9', 5),
    ('Samsung Galaxy Tab S6 (6 GB / 128 GB)', 5),
    ('Lenovo Tab 4 8 LTE', 5),
    ('Huawei B535 modemas + neribotas internetas', 3),
    ('Alcatel LINK ZONE MW40V', 3),
    ('Alcatel Linkhub HH40', 3),
    ('Huawei E5783B-230 modemas', 3),
    ('Huawei B535-232 (LTE CAT7)', 3),
    ('Huawei E5785B-92c mobilus maršrutizatorius', 3),
    ('Xiaomi 32" HD MI Smart LED TV 4A ', 4),
    ('Samsung 43" UHD 4K Smart TV RU7092 išmanusis televizorius', 4),
    ('Samsung 55" UHD 4K Smart TV RU7092', 4),
    ('eSTAR 32" HD LED išmanusis televizorius', 4),
    ('eSTAR 55" UHD LED išmanusis televizorius', 4),
    ('Samsung 49" QLED 4K Smart TV Q60R išmanusis televizorius', 4),
    ('Allview 32" HD Smart LED', 4),
    ('Hisense 43" UHD 4K Smart TV H43B7100 išmanusis televizorius', 4);
    
    
INSERT INTO PlanoTipas(tipoPavadinimas) 
VALUES 
	('Interneto Planai'),
	('Pokalbių Planai'),
	('Planai Verslui'),
	('TV Planai');
    
INSERT INTO Operatorius(operatoriausPavadinimas) 
VALUES 
	('Tele2'),
	('Telia'),
	('Bite');
    
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) 
VALUES 
	('Laisvas Internetas 25 GB', '25GB', 4.90, NULL, 1), -- tele2
	('Laisvas Internetas 50 GB', '50GB', 6.90, NULL, 1),
	('Laisvas Internetas 100 GB', '100GB', 8.90, NULL, 1),
	('Laisvas Internetas 200 GB', '200GB', 15.90, NULL, 1),
	('Neribotas Laisvas Internetas', 'Neribotas', 17.90, NULL, 1),
	('Internetas 30 GB', '30GB', 6.90, NULL, 2),
	('Internetas 30 GB', '30GB', 6.90, 1.05, 2),
	('Internetas 30 GB', '30GB', 6.90, 2.55, 2),
	('Internetas 60 GB', '60GB', 8.90, NULL, 2),	
	('Internetas 60 GB', '60GB', 8.90, 1.05, 2),
	('Internetas 60 GB', '60GB', 8.90, 2.55, 2),
	('Internetas 120 GB', '120GB', 10.90, NULL, 2),
	('Internetas 120 GB', '120GB', 10.90, 1.05, 2),
	('Internetas 120 GB', '120GB', 10.90, 2.55, 2),
	('Internetas 240 GB', '240GB', 15.90, NULL, 2),
	('Internetas 240 GB', '240GB', 15.90, 1.05, 2),
	('Internetas 240 GB', '240GB', 15.90, 2.55, 2),
	('Neribotas Internetas', 'Neribotas', 19.90, NULL, 2),
	('Neribotas Internetas', 'Neribotas', 19.90, 1.05, 2),
	('Neribotas Internetas', 'Neribotas', 19.90, 2.55, 2),
	('Namų Internetas', 'Neribotas', 18.90, NULL, 3),	-- bitė
	('Kelionių Internetas', '50GB', 9.90, NULL, 3),
	('Daiktų Internetas', 2, 4.90, NULL, 3),
-- interneto planai pokalbiams
	('+1GB Prie Pokalbių', '1GB', NULL, NULL, 1),				-- TELE2
	('+5GB Prie Pokalbių', '5GB', NULL, NULL, 1),
	('+10GB Prie Pokalbių', '10GB', NULL, NULL, 1),
	('+20GB Prie Pokalbių', '20GB', NULL, NULL, 1),
	('+50GB Prie Pokalbių', '50GB', NULL, NULL, 1),
	('Neriboti GB Prie Pokalbių', 'Neribotas', NULL, NULL, 1),
	('Start', '1GB', 2, NULL, 2),	-- TELIA
	('Flexi 4', '4GB', 5, NULL, 2),
	('Flexi 8', '8GB', 9, NULL, 2),
	('Flexi 12', '12GB', 12, NULL, 2),
	('Flexi 20', '20GB', 16, NULL, 2),
	('Flexi 40', '40GB', 18, NULL, 2),
	('Neribotai', 'Neribotas', 22, NULL, 2),
	('Lengviau 1', '1GB', NULL, NULL, 3),	-- BITE
	('Lengviau 5', '5GB', NULL, NULL, 3),
	('Lengviau 10', '10GB', NULL, NULL, 3),
	('Lengviau 20', '20GB', NULL, NULL, 3),
	('Lengviau 50', '50GB', NULL, NULL, 3),
	('Lengviau 100', '100GB', NULL, NULL, 3),
	('Lengviau Neribotai', 'Neribotas', NULL, NULL, 3);
    
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) 
VALUES 
	('Laisvas Internetas 25 GB', 4.90, 1, 1, 1),
	('Laisvas Internetas 50 GB', 6.90, 1, 1, 2),
	('Laisvas Internetas 100 GB', 8.90, 1, 1, 3),
	('Laisvas Internetas 200 GB', 15.90, 1, 1, 4),
	('Neribotas Laisvas Internetas', 17.90, 1, 1, 5),
	('Internetas 30 GB ', 6.90, 1, 2, 6),
	('Internetas 30 GB ', 7.95, 1, 2, 7), 
	('Internetas 30 GB ', 9.45, 1, 2, 8),
	('Internetas 60 GB',  8.90, 1, 2, 9),
	('Internetas 60 GB',  9.95, 1, 2, 10),
	('Internetas 60 GB',  11.45, 1, 2, 11),
	('Internetas 120 GB',  10.90, 1, 2, 12),
	('Internetas 120 GB',  11.95, 1, 2, 13),
	('Internetas 120 GB',  13.45, 1, 2, 14),
	('Internetas 240 GB',  15.90, 1, 2, 15),
	('Internetas 240 GB',  16.95, 1, 2, 16),
	('Internetas 240 GB',  18.45, 1, 2, 17),
	('Neribotas Internetas', 19.90, 1, 2, 18),
	('Neribotas Internetas', 20.95, 1, 2, 19),
	('Neribotas Internetas', 22.45, 1, 2, 20),
	('Namų Internetas', 18.90, 1, 3, 21),
	('Kelionių Internetas', 9.90, 1, 3, 22),
	('Daiktų Internetas', 4.90, 1, 3, 23),
-- pokalbiu planai
	('Neriboti pokalbiai ir SMS + 1GB', 8.50, 2, 1, 24),	-- TELE2
	('Neriboti pokalbiai ir SMS + 5GB', 11.90, 2, 1, 25),
	('Neriboti pokalbiai ir SMS + 10GB', 15.90, 2, 1, 26),
	('Neriboti pokalbiai ir SMS + 20GB', 19.90, 2, 1, 27),
	('Neriboti pokalbiai ir SMS + 50GB', 15.90, 2, 1, 28),
	('Neriboti pokalbiai ir SMS + NERIBOTI GB', 27.90, 2, 1, 29),
	('Start', 9.00, 2, 2, 30), 	-- TELIA
	('Flexi 4', 12.00, 2, 2, 31),
	('Flexi 8', 16.00, 2, 2, 32),
	('Flexi 12', 19.00, 2, 2, 33),
	('Flexi 20', 23.00, 2, 2, 34),
	('Flexi 40', 25.00, 2, 2, 35),
	('Neribotai', 29.00, 2, 2, 36),
	('Lengviau 1', 8.90, 2, 3, 37),	-- BITE
	('Lengviau 5', 12.90, 2, 3, 38),
	('Lengviau 10', 16.90, 2, 3, 39),
	('Lengviau 20', 20.90, 2, 3, 40),
	('Lengviau 50', 24.90, 2, 3, 41),
	('Lengviau 100', 26.90, 2, 3, 42),
	('Lengviau Neribotai', 28.90, 2, 3, 43);


INSERT INTO GyvenamojiVieta (miestoPavadinimas, gatvesPavadinimas, namoNumeris, butoNumeris)
VALUES
	('Vilnius', 'Vilkpėdės g.', '8', 3),
    ('Šiauliai', 'Ragainės g.', '82', NULL),
    ('Kaunas', 'Savanorių pr.', '284a', 21),
    ('Kaunas', 'Islandijos pl.', '32', NULL),
    ('Vilnius', 'A. J. Povilaičio g.', '20', 11),
    ('Alytus', 'Gatv g.', '11', 2),
    ('Kaunas', 'Negatve g.', '9', 22);
    
INSERT INTO Asmuo(vardas, pavarde, telefonoNumeris, gyvenamosiosVietosID)
VALUES
	('Marijus', 'Janickas', 868082194, 1),
	('Žemyna', 'Sirinskaite', 864219491, 2),
	('Vile', 'Okmianskaite', 852788797, 3),
	('Petras', 'Palaima', 864383300, 4),
	('Vincas', 'Ceginskas', +37061272040, 5);
    
INSERT INTO Abonentas(sutartiesPradzia, sutartiesPabaiga, asmensID, planoID)
VALUES
	('2019-02-25', '2022-02-25', 1, 4),
    ('2018-05-12', '2021-05-12', 2, 7),
    ('2020-03-22', '2022-03-22', 3, 1),
    ('2019-01-04', '2019-07-04', 4, 5),
    ('2020-10-03', '2023-10-03', 5, 9);
    
INSERT INTO RysysInternetu(abonentoID, kiekisGB, kaina, rysioPradzia, rysioPabaiga) 
VALUES 
	(1, 2, 4, '2020-02-02', '2020-03-02'),
	(2, 1, 2.50, '2020-03-07', '2020-04-07'),
	(3, 1, 2, '2019-12-20', '2020-01-20'),
    (4, 4, 2.50, '2020-03-07', '2020-04-07'),
    (5, 10, 2.50, '2020-03-07', '2020-04-07');
    
INSERT INTO UzsakytasInternetoPlanas(internetoPlanoID, abonentoID, uzsakymoData, atsisakymoData) 
VALUES 
	(1, 1, '2020-01-01', '2023-01-01'),
	(4, 2, '2019-05-05', '2022-05-05'),
	(6, 3, '2018-03-03', '2020-03-03'),
    (9, 4, '2018-03-03', '2020-05-03'),
    (2, 5, '2020-01-01', '2021-01-01');
    
INSERT INTO Paslauga(paslaugosPavadinimas) 
VALUES 
	('MoQ'),
	('Telefeno Draudimas'),
	('Mobilus Parasas'),
	('Kelioniu Draudimas'),
	('Irenginiu Draudimas'),
	('Atsiskaitymas su "Google Play"'),
	('Atsiskaitymas su "App Store"'),
	('Automobilio Statymas');

INSERT INTO PlanoRinkinys(kaina, planoID, paslaugosID) 
VALUES 
	(20.10, 1, 1),
	(10.90, 9, 4),
	(6.90, 4, 5);
    
INSERT INTO Lengvata(kiekis, kaina, rinkinioID)
VALUES 
	(2, 40, 1),
	(2, 11.80, 2),
	(2, 7.80, 3);
    
INSERT INTO UzsakomaLengvata(kiekis, kaina, rinkinioID)
VALUES 
	(1, 20.10, 1),
	(1, 10.90, 2),
	(1, 6.90, 3);

INSERT INTO UzsakytaLengvata(abonentoID, komplektoID, uzsakymoData, atsisakymoData)
VALUES 
	(1, 1, '2020-01-01', '2023-01-01'),
	(2, 2, '2019-05-05', '2022-05-05'),
	(3, 3, '2018-03-03', '2020-03-03');

INSERT INTO Zona(zonosPavadinimas)
VALUES 
	('Baltijos salyse'),
	('Europos Sajungoje'),
	('Jungtines Amerikos Valstijos');
    
INSERT INTO PaslaugosKainaZonoje(operatoriausID, paslaugosID, zonosID, kaina)
VALUES
	(1, 1, 1, 5.50),
	(1, 2, 2, 10),
	(1, 2, 3, 25),
	(2, 3, 1, 4.40),
	(2, 3, 2, 7.40),
	(2, 3, 3, 13),
	(3, 6, 1, 0.5);
    
INSERT INTO Salis(saliesKodas, saliesPavadinimas, zonosID)
VALUES
	('LT', 'Lietuva', 1),
	('LV','Latvija', 1),
	('EE','Estija', 1),
	('FR','Prancuzija', 2),
	('JAV','Jungtines Amerikos Valstijos', 3);
    
INSERT INTO RysysP2P(abonentoID, saliesKodas, paslaugosID, rysioPradzia, rysioPabaiga)
VALUES
	(1, 'LT', 2, '2020-01-01', '2023-01-01'),
	(2, 'LV', 6, '2019-05-05', '2022-05-05'),
	(3, 'EE', 3, '2018-03-03', '2020-03-03');
    
/*========================================QueriesStuff=================================================*/


/*1 - select names of cities*/
SELECT DISTINCT miestoPavadinimas FROM GyvenamojiVieta;

/*2 - show the amount of entries in gyvenamojiVieta*/
SELECT COUNT(*) FROM GyvenamojiVieta;

/*3 - Plans with additional info of plan and operator*/
SELECT Planas.planoPavadinimas, Planas.kaina, InternetoPlanas.planoPavadinimas, InternetoPlanas.kiekisGB, InternetoPlanas.kaina, Operatorius.operatoriausPavadinimas
FROM Planas
INNER JOIN InternetoPlanas
ON Planas.internetoPlanoID = InternetoPlanas.internetoPlanoID
INNER JOIN Operatorius
ON InternetoPlanas.operatoriausID = Operatorius.operatoriausID;

/*4 - Amount of users from each city*/
SELECT DISTINCT GyvenamojiVieta.miestoPavadinimas AS City, 
COUNT(GyvenamojiVieta.miestoPavadinimas) AS NumberOfEntries 
FROM GyvenamojiVieta
GROUP BY GyvenamojiVieta.miestoPavadinimas;

/*5 - Shows living areas where no one is registered*/
SELECT GyvenamojiVieta.miestoPavadinimas, GyvenamojiVieta.gatvesPavadinimas, GyvenamojiVieta.namoNumeris, GyvenamojiVieta.butoNumeris
FROM GyvenamojiVieta
WHERE GyvenamojiVieta.gyvenamosiosVietosID NOT IN (SELECT Asmuo.gyvenamosiosVietosID FROM Asmuo);

/*6 - Most popular city*/
SELECT GyvenamojiVieta.miestoPavadinimas AS City, 
COUNT(GyvenamojiVieta.miestoPavadinimas) AS NumberOfEntries 
FROM GyvenamojiVieta
GROUP BY GyvenamojiVieta.miestoPavadinimas
ORDER BY NumberOfEntries DESC
LIMIT 1;

/*7 - Most offers proposing operator*/
SELECT Operatorius.operatoriausPavadinimas
FROM Operatorius
INNER JOIN Planas
ON Planas.operatoriausID = Operatorius.operatoriausID
GROUP BY Planas.operatoriausID
ORDER BY COUNT(*) DESC
LIMIT 1;

/*8 - Average of plan costs from each operator (cost > 15 eur.)*/
SELECT Operatorius.operatoriausPavadinimas AS Operator,
Planas.planoPavadinimas AS Plan,
AVG(
	CASE WHEN Planas.kaina > 15 
    THEN COALESCE(Planas.kaina,0) + COALESCE(InternetoPlanas.kaina,0) + COALESCE(InternetoPlanas.papildomaKaina,0)
    ELSE 0 END) AS Cost
FROM Planas
INNER JOIN Operatorius
ON Operatorius.operatoriausID = Planas.operatoriausID
INNER JOIN InternetoPlanas
ON Planas.internetoPlanoID = InternetoPlanas.internetoPlanoID
GROUP BY Operatorius.operatoriausPavadinimas;

/*9 - Count of phones*/
SELECT IrangosTipas.irangosTipoPavadinimas AS Device,
COUNT(Iranga.irangosID) AS Amount
FROM IrangosTipas
INNER JOIN Iranga
ON Iranga.irangosTipoID = IrangosTipas.irangosTipoID
WHERE IrangosTipas.irangosTipoPavadinimas = 'Telefonai';


/*10 - all plans that start with letter L*/
SELECT Planas.planoPavadinimas AS PlanTitle,
Planas.kaina AS Price,
PlanoTipas.tipoPavadinimas AS TypeName,
Operatorius.operatoriausPavadinimas AS Operator
FROM Planas
INNER JOIN PlanoTipas
ON PlanoTipas.tipoID = Planas.tipoID
INNER JOIN Operatorius
ON Operatorius.operatoriausID = Planas.operatoriausID
WHERE Planas.planoPavadinimas LIKE 'L%';


/*11 - Get client name, surname, start and end dates from clients that registered in 2020*/
SELECT Asmuo.vardas AS ClientName,
Asmuo.pavarde AS ClientSurname,
Abonentas.sutartiesPradzia AS StartDate,
Abonentas.sutartiesPabaiga AS EndDate
FROM Asmuo
INNER JOIN Abonentas
ON Abonentas.asmensID = Asmuo.asmensID
WHERE Abonentas.sutartiesPradzia LIKE '2020%';


/*12 - count how many countries are in each zone by descending order*/
SELECT Zona.zonosPavadinimas AS Zone,
COUNT(Salis.saliesKodas) AS Count
FROM Zona
INNER JOIN Salis
ON Zona.zonosID = Salis.zonosID
GROUP BY Zona.zonosPavadinimas
ORDER BY Count DESC;

/*13 - Services ordered from most expensive to least expensive*/
SELECT Operatorius.operatoriausPavadinimas AS Operator,
Paslauga.paslaugosPavadinimas AS Service,
Zona.zonosPavadinimas AS Zone,
PaslaugosKainaZonoje.kaina AS Price
FROM PaslaugosKainaZonoje
INNER JOIN Operatorius
ON Operatorius.operatoriausID = PaslaugosKainaZonoje.operatoriausID
INNER JOIN Paslauga
ON Paslauga.paslaugosID = PaslaugosKainaZonoje.paslaugosID
INNER JOIN Zona
ON Zona.zonosID = PaslaugosKainaZonoje.zonosID
ORDER BY Price DESC;

/*14 - Select services that have not been ordered*/
SELECT Paslauga.paslaugosPavadinimas AS Service
FROM Paslauga
WHERE Paslauga.paslaugosID NOT IN
		(SELECT PlanoRinkinys.paslaugosID FROM PlanoRinkinys);
        
/*15 - Shows only countries registered in baltic region*/
SELECT Salis.saliesPavadinimas AS Country,
Salis.saliesKodas AS CountryCode
FROM Salis
INNER JOIN Zona
ON Zona.zonosID = Salis.zonosID
WHERE Zona.zonosPavadinimas = "Baltijos salyse";

/*16 - Full Information on the client*/
SELECT Asmuo.vardas AS ClientName,
Asmuo.pavarde AS ClientSurname,
Asmuo.telefonoNumeris AS PhoneNumber,
GyvenamojiVieta.miestoPavadinimas AS City,
GyvenamojiVieta.gatvesPavadinimas AS Street,
GyvenamojiVieta.namoNumeris AS HouseNr,
GyvenamojiVieta.butoNumeris AS FlatNr,
Planas.planoPavadinimas AS Plan,
Abonentas.sutartiesPradzia AS StartDate,
Abonentas.sutartiesPabaiga AS EndDate
FROM Asmuo
INNER JOIN GyvenamojiVieta
ON GyvenamojiVieta.gyvenamosiosVietosID = Asmuo.gyvenamosiosVietosID
INNER JOIN Abonentas
ON Abonentas.asmensID = Asmuo.asmensID
INNER JOIN Planas
ON Planas.planoID = Abonentas.planoID;

/*17 - Selects only call plans*/
SELECT PlanoTipas.tipoPavadinimas AS PlanType,
Planas.planoPavadinimas AS PlanName,
Planas.kaina AS Price,
Operatorius.operatoriausPavadinimas AS Operator
FROM PlanoTipas
INNER JOIN Planas
ON Planas.tipoID = PlanoTipas.tipoID
INNER JOIN Operatorius
ON Operatorius.operatoriausID = Planas.operatoriausID
WHERE PlanoTipas.tipoPavadinimas = "Pokalbių Planai";

/*18 - Shows most data offering plans*/
SELECT InternetoPlanas.planoPavadinimas AS PlanName,
InternetoPlanas.kiekisGB AS DataGB,
Operatorius.operatoriausPavadinimas AS Operator
FROM InternetoPlanas
INNER JOIN Operatorius
ON Operatorius.operatoriausID = InternetoPlanas.operatoriausID
WHERE InternetoPlanas.kiekisGB = (SELECT MAX(InternetoPlanas.kiekisGB) FROM InternetoPlanas);

/*19 - Shows all samsung devices*/
SELECT Iranga.irangosPavadinimas AS Device,
IrangosTipas.irangosTipoPavadinimas AS DeviceType
FROM Iranga
INNER JOIN IrangosTipas
ON IrangosTipas.IrangosTipoID = Iranga.IrangosTipoID
WHERE Iranga.irangosPavadinimas LIKE 'Samsung%';

/*20 - Average price for internet plans*/
SELECT PlanoTipas.tipoPavadinimas AS PlanName,
COUNT(*) AS AmountOfPlans,
AVG(Planas.kaina) AS AveragePrice
FROM Planas
INNER JOIN PlanoTipas
ON PlanoTipas.tipoID = Planas.tipoID
WHERE PlanoTipas.tipoPavadinimas = "Interneto Planai";
