drop database projettutoree;
create database projettutoree;

use projettutoree;

CREATE TABLE etudiant (
   matricule  int NOT NULL,
   nom_Etudiant varchar(255) not null,
   Prenom_Etudiant varchar(255) not null,
   code_authentification  varchar(255) DEFAULT NULL,
   created_date  varchar(20) DEFAULT NULL,
   email varchar(20) not null,
--  created_by  varchar(20) DEFAULT NULL,
  -- modified_by  varchar(20) DEFAULT NULL,
  -- updated_date  varchar(20) DEFAULT NULL,
   -- primary key (code_etudiant),
   primary key(matricule)
  -- primary key (code_etudiant)
) ENGINE=InnoDB;


CREATE TABLE  intervention  (
   id_intervention  int NOT NULL,
   date_creation  varchar(255) DEFAULT NULL,
   contenu  varchar(255) DEFAULT NULL,
   statut  varchar(255) DEFAULT NULL,
   departement  varchar(255) DEFAULT NULL,
   matricule_Etudiant  int not NULL,
   primary key(id_intervention),
   foreign key(matricule_Etudiant) references Etudiant(matricule)
  --  primary key(id_intervention,reponse_id_reponse,personnel_code)
) ENGINE=InnoDB;


create table Personnel(
	id_personnel int not null,
    email varchar(20) not null,
    mot_de_passe varchar(20) not null,
    Nom_personnel varchar(20) not null,
    Prenom_personnel varchar(20) not null,
    roles varchar(20) not null,
    departement varchar(20) not null,
    primary key (id_personnel)
)engine=InnoDB;





CREATE TABLE  reponse  (
   id_reponse  int(11) NOT NULL,
   date_creation  varchar(255) DEFAULT NULL,
   Contenu  varchar(255) DEFAULT NULL,
   intervention_id int not NULL,
   personnel int not null,
   departement varchar(255) not NULL,
   primary key(id_reponse),
   foreign key (intervention_id) references intervention(id_intervention),
   foreign key(personnel) references Personnel(id_personnel)
  --  primary key(id_reponse)
) ENGINE=InnoDB;





CREATE TABLE  historique  (
   id_historique int not null,
   date_modification  date NOT NULL,
   etudiant_id  int NOT NULL,
   intervention_id  int NOT NULL,
   statut  varchar(255) DEFAULT NULL,
 --  etudiant_code  bigint(20) DEFAULT NULL,
  --  intervention_id  bigint(20) DEFAULT NULL,
    primary key (id_historique),
    foreign key (intervention_id) references intervention(id_intervention),
    foreign key(etudiant_id) references Etudiant(matricule)
) ENGINE=InnoDB;






CREATE TABLE  intervention_piece_jointes  (
   intervention_id_intervention  bigint(20) NOT NULL,
   piece_jointes_id_piece_jointe  int(11) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE  piecejointe  (
   id_piece_jointe  int(11) NOT NULL,
   nom_piece_jointe  varchar(255) DEFAULT NULL,
 --  piece_jointe  tinyint(4) DEFAULT NULL,
   intervention_id  int not NULL,
   primary key(id_piece_jointe),
   foreign key (intervention_id) references intervention(id_intervention)
  --  primary key (id_piece_jointe,intervention_id_intervention)
) ENGINE=InnoDB;

create table Utilisateur(
	id_utilisateur int not null,
	mot_de_passe varchar(255) DEFAULT NULL,
	roles varchar(255) DEFAULT NULL,
	matricule int default null,
    personnel int default null,
    email varchar(255) DEFAULT NULL,
    primary key(id_utilisateur),
    foreign key(matricule) references Etudiant(matricule),
    foreign key(personnel) references Personnel(id_personnel)
)ENGINE=InnoDB;





