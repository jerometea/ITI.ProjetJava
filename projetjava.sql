DROP DATABASE projetjava;
CREATE DATABASE projetjava;
USE projetjava;

CREATE TABLE IF NOT EXISTS admin (
  id int(11)  PRIMARY KEY AUTO_INCREMENT,
  pseudo varchar(255)  NOT NULL,
  mdp varchar(255)  NOT NULL
);

CREATE TABLE IF NOT EXISTS personne (
  id int(11) PRIMARY KEY AUTO_INCREMENT,
  nom varchar(255) NOT NULL,
  prenom varchar(255) NOT NULL,
  date_naissance date NOT NULL,
  adresse varchar(255) NOT NULL,
  code_postale int(11) NOT NULL,
  numero_tel varchar(255) NOT NULL
);

DELETE FROM admin;
INSERT INTO admin(pseudo, mdp) VALUES ("plop", "plop");

DELETE FROM personne;
INSERT INTO personne VALUES(10, "Dupont", "Paul", "1995-09-11", "plop rue plop", "56465456", "654564654");
INSERT INTO personne VALUES(11, "Goerge", "blblbllb", "2018-09-11", "plop avenue plop", "687484846", "321212321");
