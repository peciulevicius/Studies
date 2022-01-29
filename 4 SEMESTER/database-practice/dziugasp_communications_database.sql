-- CREATE DATABASE database_practice;															/*<----- CREATE DATABASE*/

CREATE TABLE IrangosTipas (																	/*<----- ĮrangosTipas*/
	irangosTipoID INTEGER NOT NULL AUTO_INCREMENT,
    irangosTipoPavadinimas VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY(irangosTipoID)
);
SELECT * FROM IrangosTipas;
DESCRIBE IrangosTipas;

CREATE TABLE Iranga (																		/*<----- Įranga*/
	irangosID INTEGER NOT NULL AUTO_INCREMENT,
    irangosPavadinimas VARCHAR(20) NOT NULL,
    irangosTipoPavadinimas VARCHAR(20) NOT NULL,
    PRIMARY KEY(irangosID),
    FOREIGN KEY(irangosTipoPavadinimas) REFERENCES IrangosTipas(irangosTipoPavadinimas)
);
SELECT * FROM Iranga;
DESCRIBE Iranga;

CREATE TABLE PlanoTipas (																	/*<----- PlanoTipas*/
	tipoID INTEGER NOT NULL AUTO_INCREMENT,
    tipoPavadinimas VARCHAR(20) NOT NULL,
    PRIMARY KEY(tipoID)
);
SELECT * FROM PlanoTipas;
DESCRIBE PlanoTipas;

CREATE TABLE Operatorius (																	/*<----- Operatorius*/
	operatoriausID INTEGER NOT NULL AUTO_INCREMENT,
    operatoriausPavadinimas CHAR(10) NOT NULL UNIQUE,
    PRIMARY KEY(operatoriausID)
);
SELECT * FROM Operatorius;
DESCRIBE Operatorius;

CREATE TABLE Paslauga (																		/*<----- Paslauga*/
	paslaugosID INTEGER NOT NULL AUTO_INCREMENT,
    paslaugosPavadinimas CHAR(50) NOT NULL,
    PRIMARY KEY(paslaugosID)
);
SELECT * FROM Paslauga;
DESCRIBE Paslauga;

CREATE TABLE InternetoPlanas (																/*<----- InternetoPlanas*/
	internetoPlanoID INTEGER NOT NULL AUTO_INCREMENT,
    planoPavadinimas VARCHAR(30) NOT NULL,
    kiekisGB CHAR(10) NOT NULL,
    kaina DECIMAL(5,2),
    papildomaKaina DECIMAL(4,2),
    operatoriausID INTEGER NOT NULL,
    PRIMARY KEY(internetoPlanoID),
    FOREIGN KEY(operatoriausID) REFERENCES Operatorius(operatoriausID)
);
SELECT * FROM InternetoPlanas;
DESCRIBE InternetoPlanas;

CREATE TABLE Planas (																		/*<----- Planas*/
	planoID INTEGER NOT NULL AUTO_INCREMENT,
    planoPavadinimas VARCHAR(40) NOT NULL,
    kaina DECIMAL(5,2) NOT NULL,
    tipoID INTEGER NOT NULL,
    operatoriausID INTEGER NOT NULL,
    internetoPlanoID INTEGER NOT NULL,
    PRIMARY KEY(planoID),
    FOREIGN KEY(tipoID) REFERENCES PlanoTipas(tipoID),
    FOREIGN KEY(operatoriausID) REFERENCES Operatorius(operatoriausID),
    FOREIGN KEY(internetoPlanoID) REFERENCES InternetoPlanas(internetoPlanoID)
);
SELECT * FROM Planas;
DESCRIBE Planas;

CREATE TABLE PlanoRinkinys (																/*<----- PlanoRinkinys*/
	rinkinioID INTEGER NOT NULL AUTO_INCREMENT,
    kaina DECIMAL(5,2) NOT NULL,
    planoID INTEGER NOT NULL,
    paslaugosID INTEGER NOT NULL,
    PRIMARY KEY(rinkinioID),
    FOREIGN KEY(planoID) REFERENCES Planas(planoID),
    FOREIGN KEY(paslaugosID) REFERENCES Paslauga(paslaugosID)
);
SELECT * FROM PlanoRinkinys;
DESCRIBE PlanoRinkinys;

CREATE TABLE Lengvata (																		/*<----- Lengvata*/
	lengvatosID INTEGER NOT NULL AUTO_INCREMENT,
    kiekis INTEGER NOT NULL,
    kaina DECIMAL(5,2) NOT NULL,
    rinkinioID INTEGER NOT NULL,
    PRIMARY KEY(lengvatosID),
    FOREIGN KEY(rinkinioID) REFERENCES PlanoRinkinys(rinkinioID)
);
SELECT * FROM Lengvata;
DESCRIBE Lengvata;

CREATE TABLE UzsakomaLengvata (																/*<----- UzsakomaLengvata*/
	komplektoID INTEGER NOT NULL AUTO_INCREMENT,
    kiekis INTEGER NOT NULL,
    kaina DECIMAL(5,2) NOT NULL,
    rinkinioID INTEGER NOT NULL,
    PRIMARY KEY(komplektoID),
    FOREIGN KEY(rinkinioID) REFERENCES PlanoRinkinys(rinkinioID)
);
SELECT * FROM UzsakomaLengvata;
DESCRIBE UzsakomaLengvata;

CREATE TABLE GyvenamojiVieta (																/*<----- GyvenamojiVieta*/
	gyvenamosiosVietosID INTEGER NOT NULL AUTO_INCREMENT,
	miestoPavadinimas VARCHAR(25) NOT NULL,
    gatvesPavadinimas VARCHAR(25) NOT NULL,
    namoNumeris CHAR(6),
    butoNumeris CHAR(6),
    PRIMARY KEY(gyvenamosiosVietosID)
);
SELECT * FROM GyvenamojiVieta;
DESCRIBE GyvenamojiVieta;

CREATE TABLE Asmuo (																		/*<----- Asmuo*/
	asmensID INTEGER NOT NULL UNIQUE,
    vardas VARCHAR(25) NOT NULL,
    pavarde VARCHAR(25) NOT NULL,
    telefonoNumeris CHAR(15) NOT NULL,
    gyvenamosiosVietosID INTEGER NOT NULL,
    PRIMARY KEY(asmensID),
    FOREIGN KEY(gyvenamosiosVietosID) REFERENCES GyvenamojiVieta(gyvenamosiosVietosID)
);
SELECT * FROM Asmuo;
DESCRIBE Asmuo;

CREATE TABLE Abonentas (																	/*<----- Abonentas*/
	abonentoID INTEGER NOT NULL AUTO_INCREMENT,
    numeris CHAR(20) NOT NULL,
    sutartiesPradzia DATE NOT NULL, /* YYYY-MM-DD (1000-01-01 - 9999-12-31) */
    sutartiesPabaiga DATE NOT NULL, /* YYYY-MM-DD (1000-01-01 - 9999-12-31) */
    asmensID INTEGER NOT NULL,
    planoID INTEGER NOT NULL,
    PRIMARY KEY(abonentoID),
    FOREIGN KEY(asmensID) REFERENCES Asmuo(asmensID)
);
SELECT * FROM Abonentas;
DESCRIBE Abonentas;

CREATE TABLE RysysInternetu (																/*<----- RysysInternetu*/
	abonentoID INTEGER NOT NULL,
	kiekisGB INTEGER NOT NULL,
    kaina DECIMAL(5,2) NOT NULL,
	rysioPradzia DATE NOT NULL,	/* YYYY-MM-DD (1000-01-01 - 9999-12-31) */
    rysioPabaiga DATE NOT NULL,	/* YYYY-MM-DD (1000-01-01 - 9999-12-31) */
    FOREIGN KEY(abonentoID) REFERENCES Abonentas(abonentoID)
);
SELECT * FROM RysysInternetu;
DESCRIBE RysysInternetu;

CREATE TABLE UzsakytaLengvata (																/*<----- UzsakytaLengvata*/
	abonentoID INTEGER NOT NULL,
	komplektoID INTEGER NOT NULL,
	uzsakymoData DATE NOT NULL,		/* YYYY-MM-DD (1000-01-01 - 9999-12-31) */
    atsisakymoData DATE NOT NULL,	/* YYYY-MM-DD (1000-01-01 - 9999-12-31) */
    FOREIGN KEY(abonentoID) REFERENCES Abonentas(abonentoID),
    FOREIGN KEY(komplektoID) REFERENCES UzsakomaLengvata(komplektoID)
);
SELECT * FROM UzsakytaLengvata;
DESCRIBE UzsakytaLengvata;

CREATE TABLE UzsakytasInternetoPlanas (														/*<----- UzsakytasInternetoPlanas*/
	internetoPlanoID INTEGER NOT NULL,
    abonentoID INTEGER NOT NULL,
	uzsakymoData DATE NOT NULL,		/* YYYY-MM-DD (1000-01-01 - 9999-12-31) */
    atsisakymoData DATE NOT NULL,	/* YYYY-MM-DD (1000-01-01 - 9999-12-31) */
    FOREIGN KEY(internetoPlanoID) REFERENCES InternetoPlanas(internetoPlanoID),
	FOREIGN KEY(abonentoID) REFERENCES Abonentas(abonentoID)
);
SELECT * FROM UzsakytasInternetoPlanas;
DESCRIBE UzsakytasInternetoPlanas;

CREATE TABLE Zona (																		/*<----- Zona */
	zonosID INTEGER NOT NULL AUTO_INCREMENT,
    zonosPavadinimas VARCHAR(50) NOT NULL,
    PRIMARY KEY(zonosID)
);
SELECT * FROM Zona;
DESCRIBE Zona;

CREATE TABLE PaslaugosKainaZonoje (														/*<----- PaslaugosKainaZonoje */
	operatoriausID INTEGER NOT NULL,
    paslaugosID INTEGER NOT NULL,
    zonosID INTEGER NOT NULL,
    kaina DECIMAL(5,2) NOT NULL,
    FOREIGN KEY(operatoriausID) REFERENCES Operatorius(operatoriausID),
    FOREIGN KEY(paslaugosID) REFERENCES Paslauga(paslaugosID),
    FOREIGN KEY(zonosID) REFERENCES Zona(zonosID)
);
SELECT * FROM PaslaugosKainaZonoje;
DESCRIBE PaslaugosKainaZonoje;

CREATE TABLE Salis (																	/*<----- Salis */
	saliesKodas CHAR(8) NOT NULL,
    saliesPavadinimas VARCHAR(40) NOT NULL,
    zonosID INTEGER NOT NULL,
    PRIMARY KEY(saliesKodas),
	FOREIGN KEY(zonosID) REFERENCES Zona(zonosID)
);
SELECT * FROM Salis;
DESCRIBE Salis;

CREATE TABLE RysysP2P(																	/*<----- RysysP2P */
abonentoID INTEGER NOT NULL,
saliesKodas CHAR(8) NOT NULL,
paslaugosID INTEGER NOT NULL,
rysioPradzia DATE NOT NULL,
rysioPabaiga DATE NOT NULL,
FOREIGN KEY(abonentoID) REFERENCES Abonentas(abonentoID),
FOREIGN KEY(saliesKodas) REFERENCES Salis(saliesKodas),
FOREIGN KEY(paslaugosID) REFERENCES Paslauga(paslaugosID)
);
SELECT * FROM RysysP2P;
DESCRIBE RysysP2P;

/*------------------------------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------DATA INSERTION--------------------------------------------------------------*/
/*------------------------------------------------------------------------------------------------------------------------------------------*/

-- irangosTipoID -> AUTO_INCREMENT
INSERT INTO IrangosTipas(irangosTipoPavadinimas) VALUES ('Modemai');
INSERT INTO IrangosTipas(irangosTipoPavadinimas) VALUES ('Telefonai');
INSERT INTO IrangosTipas(irangosTipoPavadinimas) VALUES ('Kompiuteriai');
INSERT INTO IrangosTipas(irangosTipoPavadinimas) VALUES ('Televizoriai');

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- irangosID -> AUTO_INCREMENT
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Huawei', 'Modemai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Alcatel', 'Modemai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('ZTE', 'Modemai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Huawei', 'Telefonai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Samsung', 'Telefonai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Apple', 'Telefonai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Xiaomi', 'Telefonai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Nokia', 'Telefonai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Sony', 'Telefonai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Asus', 'Kompiuteriai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Lenovo', 'Kompiuteriai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('HP', 'Kompiuteriai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('MSI', 'Kompiuteriai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('DELL', 'Kompiuteriai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Apple', 'Kompiuteriai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Sharp', 'Televizoriai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Philips', 'Televizoriai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('LG', 'Televizoriai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Samsung', 'Televizoriai');
INSERT INTO Iranga(irangosPavadinimas, irangosTipoPavadinimas) VALUES ('Sony', 'Televizoriai');

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- tipoID -> AUTO_INCREMENT
INSERT INTO PlanoTipas(tipoPavadinimas) VALUES ('Interneto Planai');
INSERT INTO PlanoTipas(tipoPavadinimas) VALUES ('Pokalbių Planai');
INSERT INTO PlanoTipas(tipoPavadinimas) VALUES ('Planai Verslui');
INSERT INTO PlanoTipas(tipoPavadinimas) VALUES ('TV Planai');

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- operatoriausID -> AUTO_INCREMENT
INSERT INTO Operatorius(operatoriausPavadinimas) VALUES ('Tele2');
INSERT INTO Operatorius(operatoriausPavadinimas) VALUES ('Telia');
INSERT INTO Operatorius(operatoriausPavadinimas) VALUES ('Bite');

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- internetoPlanoID -> AUTO_INCREMENT
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Laisvas Internetas 25 GB', '25GB', 4.90, NULL, 1); -- tele2
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Laisvas Internetas 50 GB', '50GB', 6.90, NULL, 1);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Laisvas Internetas 100 GB', '100GB', 8.90, NULL, 1);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Laisvas Internetas 200 GB', '200GB', 15.90, NULL, 1);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Neribotas Laisvas Internetas', 'Neribotas', 17.90, NULL, 1);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 30 GB', '30GB', 6.90, NULL, 2);	-- Papildoma kaina NULL be modemo (TELIA)
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 30 GB', '30GB', 6.90, 1.05, 2);	-- Papildoma kaina nešiojamo modemo mėnesiui
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 30 GB', '30GB', 6.90, 2.55, 2);	-- Papildoma kaina paprasto modemo mėnesiui
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 60 GB', '60GB', 8.90, NULL, 2);	
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 60 GB', '60GB', 8.90, 1.05, 2);	-- Ir t.t. visiem telia planams
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 60 GB', '60GB', 8.90, 2.55, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 120 GB', '120GB', 10.90, NULL, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 120 GB', '120GB', 10.90, 1.05, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 120 GB', '120GB', 10.90, 2.55, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 240 GB', '240GB', 15.90, NULL, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 240 GB', '240GB', 15.90, 1.05, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Internetas 240 GB', '240GB', 15.90, 2.55, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Neribotas Internetas', 'Neribotas', 19.90, NULL, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Neribotas Internetas', 'Neribotas', 19.90, 1.05, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Neribotas Internetas', 'Neribotas', 19.90, 2.55, 2); -- iki čia pildosi telia
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Namų Internetas', 'Neribotas', 18.90, NULL, 3);	-- bitė
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Kelionių Internetas', '50GB', 9.90, NULL, 3);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Daiktų Internetas', 2, 4.90, NULL, 3);
-- interneto planai pokalbiams
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('+1GB Prie Pokalbių', '1GB', NULL, NULL, 1);				-- TELE2
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('+5GB Prie Pokalbių', '5GB', NULL, NULL, 1);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('+10GB Prie Pokalbių', '10GB', NULL, NULL, 1);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('+20GB Prie Pokalbių', '20GB', NULL, NULL, 1);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('+50GB Prie Pokalbių', '50GB', NULL, NULL, 1);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Neriboti GB Prie Pokalbių', 'Neribotas', NULL, NULL, 1);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Start', '1GB', 2, NULL, 2);	-- TELIA
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Flexi 4', '4GB', 5, NULL, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Flexi 8', '8GB', 9, NULL, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Flexi 12', '12GB', 12, NULL, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Flexi 20', '20GB', 16, NULL, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Flexi 40', '40GB', 18, NULL, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Neribotai', 'Neribotas', 22, NULL, 2);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Lengviau 1', '1GB', NULL, NULL, 3);	-- BITE
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Lengviau 5', '5GB', NULL, NULL, 3);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Lengviau 10', '10GB', NULL, NULL, 3);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Lengviau 20', '20GB', NULL, NULL, 3);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Lengviau 50', '50GB', NULL, NULL, 3);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Lengviau 100', '100GB', NULL, NULL, 3);
INSERT INTO InternetoPlanas(planoPavadinimas, kiekisGB, kaina, papildomaKaina, operatoriausID) VALUES ('Lengviau Neribotai', 'Neribotas', NULL, NULL, 3);
-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- planoID -> AUTO_INCREMENT
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Laisvas Internetas 25 GB', 4.90, 1, 1, 1);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Laisvas Internetas 50 GB', 6.90, 1, 1, 2);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Laisvas Internetas 100 GB', 8.90, 1, 1, 3);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Laisvas Internetas 200 GB', 15.90, 1, 1, 4);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Neribotas Laisvas Internetas', 17.90, 1, 1, 5);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 30 GB ', 6.90, 1, 2, 6);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 30 GB ', 7.95, 1, 2, 7); -- kaina didesne del modemo pasirinkimo
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 30 GB ', 9.45, 1, 2, 8);	-- kaina didesne del modemo pasirinkimo
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 60 GB',  8.90, 1, 2, 9);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 60 GB',  9.95, 1, 2, 10);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 60 GB',  11.45, 1, 2, 11);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 120 GB',  10.90, 1, 2, 12);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 120 GB',  11.95, 1, 2, 13);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 120 GB',  13.45, 1, 2, 14);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 240 GB',  15.90, 1, 2, 15);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 240 GB',  16.95, 1, 2, 16);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Internetas 240 GB',  18.45, 1, 2, 17);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Neribotas Internetas', 19.90, 1, 2, 18);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Neribotas Internetas', 20.95, 1, 2, 19);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Neribotas Internetas', 22.45, 1, 2, 20);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Namų Internetas', 18.90, 1, 3, 21);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Kelionių Internetas', 9.90, 1, 3, 22);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Daiktų Internetas', 4.90, 1, 3, 23);
-- pokalbiu planai
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Neriboti pokalbiai ir SMS + 1GB', 8.50, 2, 1, 24);	-- TELE2
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Neriboti pokalbiai ir SMS + 5GB', 11.90, 2, 1, 25);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Neriboti pokalbiai ir SMS + 10GB', 15.90, 2, 1, 26);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Neriboti pokalbiai ir SMS + 20GB', 19.90, 2, 1, 27);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Neriboti pokalbiai ir SMS + 50GB', 15.90, 2, 1, 28);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Neriboti pokalbiai ir SMS + NERIBOTI GB', 27.90, 2, 1, 29);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Start', 9.00, 2, 2, 30); 	-- TELIA
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Flexi 4', 12.00, 2, 2, 31);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Flexi 8', 16.00, 2, 2, 32);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Flexi 12', 19.00, 2, 2, 33);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Flexi 20', 23.00, 2, 2, 34);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Flexi 40', 25.00, 2, 2, 35);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Neribotai', 29.00, 2, 2, 36);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Lengviau 1', 8.90, 2, 3, 37);	-- BITE
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Lengviau 5', 12.90, 2, 3, 38);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Lengviau 10', 16.90, 2, 3, 39);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Lengviau 20', 20.90, 2, 3, 40);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Lengviau 50', 24.90, 2, 3, 41);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Lengviau 100', 26.90, 2, 3, 42);
INSERT INTO Planas(planoPavadinimas, kaina, tipoID, operatoriausID, internetoPlanoID) VALUES ('Lengviau Neribotai', 28.90, 2, 3, 43);

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- gyvenamosiosVietosID -> AUTO_INCREMENT
INSERT INTO GyvenamojiVieta(miestoPavadinimas, gatvesPavadinimas, namoNumeris, butoNumeris) VALUES ('Vilnius', 'Fizikų gatvė', 6, 7);
INSERT INTO GyvenamojiVieta(miestoPavadinimas, gatvesPavadinimas, namoNumeris, butoNumeris) VALUES ('Kaunas', 'Asanavičiūtės gatvė', 43, 15);
INSERT INTO GyvenamojiVieta(miestoPavadinimas, gatvesPavadinimas, namoNumeris, butoNumeris) VALUES ('Šiauliai', 'Pavadinimas gatvė', 65, 12);
INSERT INTO GyvenamojiVieta(miestoPavadinimas, gatvesPavadinimas, namoNumeris, butoNumeris) VALUES ('Zarasai', 'Pavadinimas2 gatvė', 41, 55);
INSERT INTO GyvenamojiVieta(miestoPavadinimas, gatvesPavadinimas, namoNumeris, butoNumeris) VALUES ('Klaipėda', 'Pavadinimas3 gatvė', 56, 13);
INSERT INTO GyvenamojiVieta(miestoPavadinimas, gatvesPavadinimas, namoNumeris, butoNumeris) VALUES ('MOlėtai', 'Pavadinimas4 gatvė', 56, 13);

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Asmuo(asmensID, vardas, pavarde, telefonoNumeris, gyvenamosiosVietosID) VALUES (0001, 'Jonas', 'Jonaitis', 8655488425, 1);
INSERT INTO Asmuo(asmensID, vardas, pavarde, telefonoNumeris, gyvenamosiosVietosID) VALUES (0002, 'Petras', 'Petraitis', 8677325578, 2);
INSERT INTO Asmuo(asmensID, vardas, pavarde, telefonoNumeris, gyvenamosiosVietosID) VALUES (0003, 'Ponas', 'Ponaitis', 8699774545, 1);
INSERT INTO Asmuo(asmensID, vardas, pavarde, telefonoNumeris, gyvenamosiosVietosID) VALUES (0004, 'Jonce', 'hello', 8699774545, 1);
INSERT INTO Asmuo(asmensID, vardas, pavarde, telefonoNumeris, gyvenamosiosVietosID) VALUES (0005, 'Jonc', 'helloo', 8699634545, 5);
INSERT INTO Asmuo(asmensID, vardas, pavarde, telefonoNumeris, gyvenamosiosVietosID) VALUES (0006, 'Jon', 'Pavardenis', 8699634545, 4);
INSERT INTO Asmuo(asmensID, vardas, pavarde, telefonoNumeris, gyvenamosiosVietosID) VALUES (0007, 'Jonaaaas', 'Pavarde', 8699755665, 5);
INSERT INTO Asmuo(asmensID, vardas, pavarde, telefonoNumeris, gyvenamosiosVietosID) VALUES (0008, 'Darius', 'Pavarde', 8699755665, 3);
INSERT INTO Asmuo(asmensID, vardas, pavarde, telefonoNumeris, gyvenamosiosVietosID) VALUES (0009, 'Simas', 'Pavardeee', 8699755665, 3);

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- abonentoID -> AUTO_INCREMENT			[Jei žmogus nepasirašęs sutarties ir be sutarties paslaugom naudojasi, tada datos === null]
INSERT INTO Abonentas(numeris, sutartiesPradzia, sutartiesPabaiga, asmensID, planoID) VALUES ('8655488425', '2020-01-01', '2023-01-01', 0001, 3);
INSERT INTO Abonentas(numeris, sutartiesPradzia, sutartiesPabaiga, asmensID, planoID) VALUES ('8677325578', '2019-05-05', '2022-05-05', 0002, 5);
INSERT INTO Abonentas(numeris, sutartiesPradzia, sutartiesPabaiga, asmensID, planoID) VALUES ('8699774545', '2018-03-03', '2020-03-03', 0003, 8);
INSERT INTO Abonentas(numeris, sutartiesPradzia, sutartiesPabaiga, asmensID, planoID) VALUES ('8694552545', '2018-05-25', '2020-05-25', 0004, 7);
INSERT INTO Abonentas(numeris, sutartiesPradzia, sutartiesPabaiga, asmensID, planoID) VALUES ('8671117557', '2018-06-30', '2020-06-30', 0005, 8);
INSERT INTO Abonentas(numeris, sutartiesPradzia, sutartiesPabaiga, asmensID, planoID) VALUES ('8678945612', '2018-02-28', '2020-02-28', 0003, 8);
INSERT INTO Abonentas(numeris, sutartiesPradzia, sutartiesPabaiga, asmensID, planoID) VALUES ('8632165498', '2018-03-15', '2020-03-15', 0003, 4);

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO RysysInternetu(abonentoID, kiekisGB, kaina, rysioPradzia, rysioPabaiga) VALUES (1, 2, 4, '2020-02-02', '2020-03-02');
INSERT INTO RysysInternetu(abonentoID, kiekisGB, kaina, rysioPradzia, rysioPabaiga) VALUES (2, 1, 2.50, '2020-03-07', '2020-04-07');
INSERT INTO RysysInternetu(abonentoID, kiekisGB, kaina, rysioPradzia, rysioPabaiga) VALUES (3, 1, 2, '2019-12-20', '2020-01-20');

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO UzsakytasInternetoPlanas(internetoPlanoID, abonentoID, uzsakymoData, atsisakymoData) VALUES (1, 1, '2020-01-01', '2023-01-01');
INSERT INTO UzsakytasInternetoPlanas(internetoPlanoID, abonentoID, uzsakymoData, atsisakymoData) VALUES (4, 2, '2019-05-05', '2022-05-05');
INSERT INTO UzsakytasInternetoPlanas(internetoPlanoID, abonentoID, uzsakymoData, atsisakymoData) VALUES (6, 3, '2018-03-03', '2020-03-03');

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- paslaugosID -> AUTO_INCREMENT
INSERT INTO Paslauga(paslaugosPavadinimas) VALUES ('MoQ');
INSERT INTO Paslauga(paslaugosPavadinimas) VALUES ('Telefeno Draudimas');
INSERT INTO Paslauga(paslaugosPavadinimas) VALUES ('Mobilus Parasas');
INSERT INTO Paslauga(paslaugosPavadinimas) VALUES ('Kelioniu Draudimas');
INSERT INTO Paslauga(paslaugosPavadinimas) VALUES ('Irenginiu Draudimas');
INSERT INTO Paslauga(paslaugosPavadinimas) VALUES ('Atsiskaitymas su "Google Play"');
INSERT INTO Paslauga(paslaugosPavadinimas) VALUES ('Atsiskaitymas su "App Store"');
INSERT INTO Paslauga(paslaugosPavadinimas) VALUES ('Automobilio Statymas');

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- rinkinioID -> AUTO_INCREMENT
INSERT INTO PlanoRinkinys(kaina, planoID, paslaugosID) VALUES (20.10, 1, 1);
INSERT INTO PlanoRinkinys(kaina, planoID, paslaugosID) VALUES (10.90, 9, 4);
INSERT INTO PlanoRinkinys(kaina, planoID, paslaugosID) VALUES (6.90, 4, 5);

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- lengvatosID -> AUTO_INCREMENT
INSERT INTO Lengvata(kiekis, kaina, rinkinioID) VALUES (2, 40, 1);
INSERT INTO Lengvata(kiekis, kaina, rinkinioID) VALUES (2, 11.80, 2);
INSERT INTO Lengvata(kiekis, kaina, rinkinioID) VALUES (2, 7.80, 3);

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- komplektoID -> AUTO_INCREMENT
INSERT INTO UzsakomaLengvata(kiekis, kaina, rinkinioID) VALUES (1, 20.10, 1);
INSERT INTO UzsakomaLengvata(kiekis, kaina, rinkinioID) VALUES (1, 10.90, 2);
INSERT INTO UzsakomaLengvata(kiekis, kaina, rinkinioID) VALUES (1, 6.90, 3);

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO UzsakytaLengvata(abonentoID, komplektoID, uzsakymoData, atsisakymoData) VALUES (1, 1, '2020-01-01', '2023-01-01');
INSERT INTO UzsakytaLengvata(abonentoID, komplektoID, uzsakymoData, atsisakymoData) VALUES (2, 2, '2019-05-05', '2022-05-05');
INSERT INTO UzsakytaLengvata(abonentoID, komplektoID, uzsakymoData, atsisakymoData) VALUES (3, 3, '2018-03-03', '2020-03-03');

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- zonosID -> AUTO_INCREMENT
INSERT INTO Zona(zonosPavadinimas) VALUES ('Baltijos salyse');
INSERT INTO Zona(zonosPavadinimas) VALUES ('Europos Sajungoje');
INSERT INTO Zona(zonosPavadinimas) VALUES ('Jungtines Amerikos Valstijos');

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO PaslaugosKainaZonoje(operatoriausID, paslaugosID, zonosID, kaina) VALUES (1, 1, 1, 5.50);
INSERT INTO PaslaugosKainaZonoje(operatoriausID, paslaugosID, zonosID, kaina) VALUES (1, 2, 2, 10);
INSERT INTO PaslaugosKainaZonoje(operatoriausID, paslaugosID, zonosID, kaina) VALUES (1, 2, 3, 25);
INSERT INTO PaslaugosKainaZonoje(operatoriausID, paslaugosID, zonosID, kaina) VALUES (2, 3, 1, 4.40);
INSERT INTO PaslaugosKainaZonoje(operatoriausID, paslaugosID, zonosID, kaina) VALUES (2, 3, 2, 7.40);
INSERT INTO PaslaugosKainaZonoje(operatoriausID, paslaugosID, zonosID, kaina) VALUES (2, 3, 3, 13);
INSERT INTO PaslaugosKainaZonoje(operatoriausID, paslaugosID, zonosID, kaina) VALUES (3, 6, 1, 0.5);

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO Salis(saliesKodas, saliesPavadinimas, zonosID) VALUES ('LT', 'Lietuva', 1);
INSERT INTO Salis(saliesKodas, saliesPavadinimas, zonosID) VALUES('LV','Latvija', 1);
INSERT INTO Salis(saliesKodas, saliesPavadinimas, zonosID) VALUES('EE','Estija', 1);
INSERT INTO Salis(saliesKodas, saliesPavadinimas, zonosID) VALUES ('FR','Prancuzija', 2);
INSERT INTO Salis(saliesKodas, saliesPavadinimas, zonosID) VALUES ('JAV','Jungtines Amerikos Valstijos', 3);

-- ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- [Jei žmogus nepasirašęs papildomos paslaugos tada datos === null]
INSERT INTO RysysP2P(abonentoID, saliesKodas, paslaugosID, rysioPradzia, rysioPabaiga) VALUES (1, 'LT', 2, '2020-01-01', '2023-01-01');
INSERT INTO RysysP2P(abonentoID, saliesKodas, paslaugosID, rysioPradzia, rysioPabaiga) VALUES (2, 'LV', 6, '2019-05-05', '2022-05-05');
INSERT INTO RysysP2P(abonentoID, saliesKodas, paslaugosID, rysioPradzia, rysioPabaiga) VALUES (3, 'EE', 3, '2018-03-03', '2020-03-03');

/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------OTHER  QUERIES (joins and so on..)--------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------------------------------------------------------*/

-- 1. OUTPUTS THE COUNT OF ENTRIES IN THE TABLE "GYVENAMOJI VIETA"
SELECT COUNT(*) FROM GyvenamojiVieta;

-- 2. OUTPUTS INFORMATION ABOUT DEVICE NAME AND WHAT TYPE IT BELONGS TO
SELECT Iranga.irangosID , Iranga.irangosPavadinimas, IrangosTipas.irangosTipoID, IrangosTipas.irangosTipoPavadinimas 
FROM Iranga 
INNER JOIN IrangosTipas 
ON Iranga.irangosTipoPavadinimas = IrangosTipas.irangosTipoPavadinimas;

-- 3. OUTPUTS USERS COUNTS IN EACH CITY (DOES NOT OUTPUT CITIES THAT DO NOT HAVE ANY USERS)
SELECT GyvenamojiVieta.gyvenamosiosVietosID, miestoPavadinimas, COUNT(asmensID) 
FROM GyvenamojiVieta 
INNER JOIN Asmuo ON GyvenamojiVieta.gyvenamosiosVietosID= Asmuo.gyvenamosiosVietosID 
GROUP BY GyvenamojiVieta.gyvenamosiosVietosID, miestoPavadinimas
ORDER BY COUNT(asmensID) DESC;

-- 4. OUTPUTS CITIES THAT DO NOT HAVE A SINGLE USER IN THAT CITY 
SELECT GyvenamojiVieta.miestoPavadinimas FROM GyvenamojiVieta
WHERE gyvenamosiosVietosID NOT IN (SELECT gyvenamosiosVietosID FROM Asmuo);

-- 5. OUTPUTS ALL COMPUTERS
SELECT  Iranga.irangosID , Iranga.irangosPavadinimas, IrangosTipas.irangosTipoPavadinimas 
FROM Iranga 
INNER JOIN IrangosTipas 
ON Iranga.irangosTipoPavadinimas =IrangosTipas.irangosTipoPavadinimas 
WHERE IrangosTipas.irangosTipoPavadinimas = 'Kompiuteriai';


-- 6. OUTPUTS OPERATORS NAME WHO HAS TO OFFER THE MOST AMMOUNT OF PLANS
SELECT operatoriausPavadinimas, COUNT(Planas.operatoriausID) AS planuSkaicius
FROM Operatorius INNER JOIN Planas ON Operatorius.operatoriausID = Planas.operatoriausID
GROUP BY operatoriausPavadinimas
ORDER BY COUNT(planuSkaicius) DESC
LIMIT 1;

-- 7. OUTPUTS ALL OPERATORS OFFERED PLANS THAT HAS A PRICE AVERAVE OVER 15 EUROS. BASICALLY IT OUTPUTS OPERATOR AND ITS AVERAGE PRICE. (ALL IN DESCENDING ORDER)
SELECT operatoriausPavadinimas, AVG(kaina) AS vidutineKaina
FROM Planas INNER JOIN Operatorius ON Operatorius.operatoriausID = Planas.operatoriausID
WHERE kaina > 15
GROUP BY operatoriausPavadinimas 
ORDER BY vidutineKaina DESC;

-- 8. OUTPUTS PLANS THAT HAS A PRICE OF LESS THAN 10 EUROS
SELECT Planas.planoID, Planas.planoPavadinimas,Planas.kaina, PlanoTipas.tipoID,PlanoTipas.tipoPavadinimas 
FROM Planas 
INNER JOIN PlanoTipas 
ON Planas.tipoID = PlanoTipas.tipoID 
WHERE Planas.kaina <= 10;

-- 9. CLIENT AND SUBSCRIBER WITH PLAN INFORMATION
SELECT Asmuo.vardas, Asmuo.pavarde, Abonentas.abonentoID, Abonentas.numeris,Planas.planoPavadinimas,Planas.kaina 
FROM Asmuo 
INNER JOIN Abonentas 
ON Asmuo.asmensID = Abonentas.asmensID 
INNER JOIN Planas 
ON Abonentas.planoID = Planas.planoID;

-- 10. OPERATORS OFFERED INTERNET PLANS
SELECT Operatorius.operatoriausPavadinimas, InternetoPlanas.planoPavadinimas, InternetoPlanas.kiekisGB, InternetoPlanas.kaina 
FROM Operatorius 
INNER JOIN InternetoPlanas 
ON Operatorius.operatoriausID = InternetoPlanas.operatoriausID;

-- 11. ALL OFFERED PLANS COUNT
SELECT COUNT(*) FROM Planas;

-- 12. OUTPUTS ALL INFORMATION THAT WAS SEARCHED BY NAME
SELECT  Iranga.irangosID , Iranga.irangosPavadinimas, IrangosTipas.irangosTipoID, IrangosTipas.irangosTipoPavadinimas 
FROM Iranga 
INNER JOIN IrangosTipas 
ON Iranga.irangosTipoPavadinimas =IrangosTipas.irangosTipoPavadinimas 
WHERE Iranga.irangosPavadinimas= 'Huawei';

-- 13. OUTPUTS PHONE PLANS 
SELECT Planas.planoID, Planas.planoPavadinimas,Planas.kaina, PlanoTipas.tipoID,PlanoTipas.tipoPavadinimas 
FROM Planas 
INNER JOIN PlanoTipas 
ON Planas.tipoID = PlanoTipas.tipoID 
WHERE PlanoTipas.tipoID = 2;

-- 14. OUTPUTS INTERNET PLANS
SELECT Planas.planoID, Planas.planoPavadinimas,Planas.kaina, PlanoTipas.tipoID,PlanoTipas.tipoPavadinimas 
FROM Planas 
INNER JOIN PlanoTipas 
ON Planas.tipoID = PlanoTipas.tipoID 
WHERE PlanoTipas.tipoID = 1;

-- 15. OUTPUTS ALL PLANS THAT HAVE A NAME “FLEXI”
SELECT Planas.planoID, Planas.planoPavadinimas,Planas.kaina, PlanoTipas.tipoID,PlanoTipas.tipoPavadinimas 
FROM Planas 
INNER JOIN PlanoTipas 
ON Planas.tipoID = PlanoTipas.tipoID 
WHERE Planas.planoPavadinimas LIKE 'Flexi%';

-- 16. OUTPUTS ALL PLANS WITH THE NAME “LENGVIAU”
SELECT Planas.planoID, Planas.planoPavadinimas,Planas.kaina, PlanoTipas.tipoID,PlanoTipas.tipoPavadinimas 
FROM Planas 
INNER JOIN PlanoTipas 
ON Planas.tipoID = PlanoTipas.tipoID 
WHERE Planas.planoPavadinimas LIKE 'LENGVIAU%';

-- 17. ZONE AND SERVICE FEES RELATION
SELECT Zona.zonosPavadinimas, PaslaugosKainaZonoje.kaina, Paslauga.paslaugosPavadinimas 
FROM Zona 
INNER JOIN PaslaugosKainaZonoje 
ON Zona.zonosID=PaslaugosKainaZonoje.zonosID 
INNER JOIN Paslauga 
ON PaslaugosKainaZonoje.paslaugosID = Paslauga.paslaugosID;

-- 18. USER AND SUBSCRIBTION WITH INTERNET CONNECTIONS INFORMATION
SELECT Asmuo.vardas, Asmuo.pavarde, Abonentas.abonentoID, Abonentas.numeris, Abonentas.sutartiesPradzia, Abonentas.sutartiesPabaiga, RysysInternetu.kiekisGB, RysysInternetu.kaina 
FROM Asmuo 
INNER JOIN Abonentas 
ON Asmuo.asmensID= Abonentas.asmensID 
INNER JOIN RysysInternetu 
ON Abonentas.abonentoID = RysysInternetu.abonentoID;

-- 19. OUTPUTS USERS INFORMATION AND USERS LIVING LOCATION
SELECT Asmuo.asmensID, Asmuo.vardas, Asmuo.pavarde, Asmuo.telefonoNumeris, GyvenamojiVieta.miestoPavadinimas, GyvenamojiVieta.gatvesPavadinimas,GyvenamojiVieta.namoNumeris, GyvenamojiVieta.butoNumeris 
FROM Asmuo 
INNER JOIN GyvenamojiVieta 
ON Asmuo.gyvenamosiosVietosID =GyvenamojiVieta.gyvenamosiosVietosID;

-- 20. OUTPUTS USERS PLAN AND INTERNET PLAN INFORMTION
SELECT Asmuo.vardas, Asmuo.pavarde, Abonentas.abonentoID, Abonentas.numeris,Planas.planoPavadinimas,Planas.kaina, InternetoPlanas.kiekisGB 
FROM Asmuo 
INNER JOIN Abonentas 
ON Asmuo.asmensID= Abonentas.asmensID 
INNER JOIN Planas 
ON Abonentas.planoID = Planas.planoID 
INNER JOIN InternetoPlanas 
ON Planas.internetoPlanoID = InternetoPlanas.internetoPlanoID;

-- 21. OUTPUTS USERS NAME, SURNAME AND PLAN INFORMATION
SELECT Asmuo.asmensID, Asmuo.vardas, Asmuo.pavarde, Abonentas.abonentoID, Abonentas.numeris, Abonentas.sutartiesPradzia, Abonentas.sutartiesPabaiga 
FROM Asmuo 
INNER JOIN Abonentas 
ON Asmuo.asmensID = Abonentas.asmensID;

-- 22.  ZONES AND COUNTRIES INFORMATION 
SELECT Zona.zonosPavadinimas,Salis.saliesKodas, Salis.saliesPavadinimas 
FROM Zona 
INNER JOIN Salis 
ON Zona.zonosID = Salis.zonosID;

-- 23. OUTPUTS SUBSCRIBERS INFORMATION AND ASSOCIATION WITH INTERNET CONNECTION INFORMATION
SELECT Abonentas.abonentoID, Abonentas.numeris, Abonentas.sutartiesPradzia, Abonentas.sutartiesPabaiga, RysysInternetu.kiekisGB, RysysInternetu.kaina 
FROM Abonentas 
INNER JOIN RysysInternetu 
ON Abonentas.abonentoID = RysysInternetu.abonentoID;
