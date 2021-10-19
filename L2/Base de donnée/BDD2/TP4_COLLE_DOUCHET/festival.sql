--
-- PostgreSQL database dump
--

-- Dumped from database version 11.9 (Debian 11.9-0+deb10u1)
-- Dumped by pg_dump version 11.9 (Debian 11.9-0+deb10u1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: festival; Type: SCHEMA; Schema: -; Owner: douchet
--

CREATE SCHEMA festival;


ALTER SCHEMA festival OWNER TO douchet;

--
-- Name: SCHEMA festival; Type: COMMENT; Schema: -; Owner: douchet
--

COMMENT ON SCHEMA festival IS 'schema du tp4 de BDD2';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: auteur; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.auteur (
    numauteur integer NOT NULL,
    numpersonne integer
);


ALTER TABLE festival.auteur OWNER TO douchet;

--
-- Name: avoirbillet; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.avoirbillet (
    idtransaction integer NOT NULL,
    numfestival integer,
    numparticipant integer,
    numbillet integer
);


ALTER TABLE festival.avoirbillet OWNER TO douchet;

--
-- Name: avoirbillet_idtransaction_seq; Type: SEQUENCE; Schema: festival; Owner: douchet
--

CREATE SEQUENCE festival.avoirbillet_idtransaction_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE festival.avoirbillet_idtransaction_seq OWNER TO douchet;

--
-- Name: avoirbillet_idtransaction_seq; Type: SEQUENCE OWNED BY; Schema: festival; Owner: douchet
--

ALTER SEQUENCE festival.avoirbillet_idtransaction_seq OWNED BY festival.avoirbillet.idtransaction;


--
-- Name: billet; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.billet (
    numbillet integer NOT NULL,
    debut date,
    fin date,
    prix real
);


ALTER TABLE festival.billet OWNER TO douchet;

--
-- Name: categorie; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.categorie (
    titre character varying(20) NOT NULL,
    numcategorie integer NOT NULL
);


ALTER TABLE festival.categorie OWNER TO douchet;

--
-- Name: creer; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.creer (
    nom character varying(20) NOT NULL,
    numauteur integer NOT NULL,
    numjeu integer NOT NULL
);


ALTER TABLE festival.creer OWNER TO douchet;

--
-- Name: employe; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.employe (
    numemp character varying(20) NOT NULL,
    numpersonne integer
);


ALTER TABLE festival.employe OWNER TO douchet;

--
-- Name: festival; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.festival (
    titre character varying(20) NOT NULL,
    debut date,
    fin date,
    numfestival integer NOT NULL,
    numville character varying(20),
    numemp character varying(20)
);


ALTER TABLE festival.festival OWNER TO douchet;

--
-- Name: jeu; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.jeu (
    nom character varying(20) NOT NULL,
    numjeu integer NOT NULL,
    numcategorie integer
);


ALTER TABLE festival.jeu OWNER TO douchet;

--
-- Name: participant; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.participant (
    numparticipant integer NOT NULL,
    numpersonne integer
);


ALTER TABLE festival.participant OWNER TO douchet;

--
-- Name: pays; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.pays (
    nom character varying(20) NOT NULL
);


ALTER TABLE festival.pays OWNER TO douchet;

--
-- Name: personne; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.personne (
    nom character varying(20) NOT NULL,
    prenom character varying(20) NOT NULL,
    mail character varying(20) NOT NULL,
    numpersonne integer NOT NULL,
    nompays character varying(20)
);


ALTER TABLE festival.personne OWNER TO douchet;

--
-- Name: session; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.session (
    numero integer,
    date date,
    heuredebut integer,
    heuefin integer,
    numfestival integer NOT NULL,
    numsession character varying(20) NOT NULL,
    numjeu integer,
    numauteur integer
);


ALTER TABLE festival.session OWNER TO douchet;

--
-- Name: ville; Type: TABLE; Schema: festival; Owner: douchet
--

CREATE TABLE festival.ville (
    nom character varying(20) NOT NULL,
    numville character varying(20) NOT NULL
);


ALTER TABLE festival.ville OWNER TO douchet;

--
-- Name: avoirbillet idtransaction; Type: DEFAULT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.avoirbillet ALTER COLUMN idtransaction SET DEFAULT nextval('festival.avoirbillet_idtransaction_seq'::regclass);


--
-- Data for Name: auteur; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.auteur (numauteur, numpersonne) FROM stdin;
\.


--
-- Data for Name: avoirbillet; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.avoirbillet (idtransaction, numfestival, numparticipant, numbillet) FROM stdin;
\.


--
-- Data for Name: billet; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.billet (numbillet, debut, fin, prix) FROM stdin;
\.


--
-- Data for Name: categorie; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.categorie (titre, numcategorie) FROM stdin;
\.


--
-- Data for Name: creer; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.creer (nom, numauteur, numjeu) FROM stdin;
\.


--
-- Data for Name: employe; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.employe (numemp, numpersonne) FROM stdin;
\.


--
-- Data for Name: festival; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.festival (titre, debut, fin, numfestival, numville, numemp) FROM stdin;
\.


--
-- Data for Name: jeu; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.jeu (nom, numjeu, numcategorie) FROM stdin;
\.


--
-- Data for Name: participant; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.participant (numparticipant, numpersonne) FROM stdin;
\.


--
-- Data for Name: pays; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.pays (nom) FROM stdin;
\.


--
-- Data for Name: personne; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.personne (nom, prenom, mail, numpersonne, nompays) FROM stdin;
\.


--
-- Data for Name: session; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.session (numero, date, heuredebut, heuefin, numfestival, numsession, numjeu, numauteur) FROM stdin;
\.


--
-- Data for Name: ville; Type: TABLE DATA; Schema: festival; Owner: douchet
--

COPY festival.ville (nom, numville) FROM stdin;
\.


--
-- Name: avoirbillet_idtransaction_seq; Type: SEQUENCE SET; Schema: festival; Owner: douchet
--

SELECT pg_catalog.setval('festival.avoirbillet_idtransaction_seq', 1, false);


--
-- Name: auteur auteur_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.auteur
    ADD CONSTRAINT auteur_pkey PRIMARY KEY (numauteur);


--
-- Name: avoirbillet avoirbillet_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.avoirbillet
    ADD CONSTRAINT avoirbillet_pkey PRIMARY KEY (idtransaction);


--
-- Name: billet billet_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.billet
    ADD CONSTRAINT billet_pkey PRIMARY KEY (numbillet);


--
-- Name: categorie categorie_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.categorie
    ADD CONSTRAINT categorie_pkey PRIMARY KEY (numcategorie);


--
-- Name: creer creer_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.creer
    ADD CONSTRAINT creer_pkey PRIMARY KEY (numauteur, numjeu);


--
-- Name: employe employe_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.employe
    ADD CONSTRAINT employe_pkey PRIMARY KEY (numemp);


--
-- Name: festival festival_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.festival
    ADD CONSTRAINT festival_pkey PRIMARY KEY (numfestival);


--
-- Name: jeu jeu_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.jeu
    ADD CONSTRAINT jeu_pkey PRIMARY KEY (numjeu);


--
-- Name: participant participant_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.participant
    ADD CONSTRAINT participant_pkey PRIMARY KEY (numparticipant);


--
-- Name: pays pays_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.pays
    ADD CONSTRAINT pays_pkey PRIMARY KEY (nom);


--
-- Name: personne personne_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.personne
    ADD CONSTRAINT personne_pkey PRIMARY KEY (numpersonne);


--
-- Name: session session_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.session
    ADD CONSTRAINT session_pkey PRIMARY KEY (numsession, numfestival);


--
-- Name: ville ville_pkey; Type: CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.ville
    ADD CONSTRAINT ville_pkey PRIMARY KEY (numville);


--
-- Name: auteur auteur_numpersonne_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.auteur
    ADD CONSTRAINT auteur_numpersonne_fkey FOREIGN KEY (numpersonne) REFERENCES festival.personne(numpersonne);


--
-- Name: avoirbillet avoirbillet_numbillet_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.avoirbillet
    ADD CONSTRAINT avoirbillet_numbillet_fkey FOREIGN KEY (numbillet) REFERENCES festival.billet(numbillet);


--
-- Name: avoirbillet avoirbillet_numfestival_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.avoirbillet
    ADD CONSTRAINT avoirbillet_numfestival_fkey FOREIGN KEY (numfestival) REFERENCES festival.festival(numfestival);


--
-- Name: avoirbillet avoirbillet_numparticipant_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.avoirbillet
    ADD CONSTRAINT avoirbillet_numparticipant_fkey FOREIGN KEY (numparticipant) REFERENCES festival.participant(numparticipant);


--
-- Name: creer creer_numauteur_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.creer
    ADD CONSTRAINT creer_numauteur_fkey FOREIGN KEY (numauteur) REFERENCES festival.auteur(numauteur);


--
-- Name: creer creer_numjeu_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.creer
    ADD CONSTRAINT creer_numjeu_fkey FOREIGN KEY (numjeu) REFERENCES festival.jeu(numjeu);


--
-- Name: employe employe_numpersonne_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.employe
    ADD CONSTRAINT employe_numpersonne_fkey FOREIGN KEY (numpersonne) REFERENCES festival.personne(numpersonne);


--
-- Name: festival festival_numemp_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.festival
    ADD CONSTRAINT festival_numemp_fkey FOREIGN KEY (numemp) REFERENCES festival.employe(numemp);


--
-- Name: festival festival_numville_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.festival
    ADD CONSTRAINT festival_numville_fkey FOREIGN KEY (numville) REFERENCES festival.ville(numville);


--
-- Name: jeu jeu_numcategorie_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.jeu
    ADD CONSTRAINT jeu_numcategorie_fkey FOREIGN KEY (numcategorie) REFERENCES festival.categorie(numcategorie);


--
-- Name: participant participant_numpersonne_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.participant
    ADD CONSTRAINT participant_numpersonne_fkey FOREIGN KEY (numpersonne) REFERENCES festival.personne(numpersonne);


--
-- Name: personne personne_nompays_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.personne
    ADD CONSTRAINT personne_nompays_fkey FOREIGN KEY (nompays) REFERENCES festival.pays(nom);


--
-- Name: session session_numauteur_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.session
    ADD CONSTRAINT session_numauteur_fkey FOREIGN KEY (numauteur) REFERENCES festival.auteur(numauteur);


--
-- Name: session session_numfestival_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.session
    ADD CONSTRAINT session_numfestival_fkey FOREIGN KEY (numfestival) REFERENCES festival.festival(numfestival);


--
-- Name: session session_numjeu_fkey; Type: FK CONSTRAINT; Schema: festival; Owner: douchet
--

ALTER TABLE ONLY festival.session
    ADD CONSTRAINT session_numjeu_fkey FOREIGN KEY (numjeu) REFERENCES festival.jeu(numjeu);


--
-- PostgreSQL database dump complete
--

