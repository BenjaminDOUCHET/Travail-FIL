SET client_encoding = 'UTF8';
CREATE SCHEMA IF NOT EXISTS authent;
SET search_path = 'authent';

CREATE TABLE users (
    login character varying(40) NOT NULL,
    password character varying(100) NOT NULL,
    nom character varying(40) NOT NULL,
    prenom character varying(40) NOT NULL,
    CONSTRAINT login_non_vide CHECK (((login)::text <> ''::text)),
    CONSTRAINT nom_non_vide CHECK (((nom)::text <> ''::text)),
    CONSTRAINT password_non_vide CHECK (((password)::text <> ''::text)),
    CONSTRAINT prenom_non_vide CHECK (((prenom)::text <> ''::text))
);
ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (login);

COMMENT ON TABLE users IS 'table des utilisateurs';



INSERT INTO users (login, password, nom, prenom) VALUES ('mallani', 'animal', 'Malle', 'Annie');
INSERT INTO users (login, password, nom, prenom) VALUES ('aporation', 'vapo', 'Aporation', 'Ève');
