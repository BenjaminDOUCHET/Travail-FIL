set PROD;

param heures_ouvrees >= 0;
param vitesse_production {PROD} >= 0;
param prix_vente {PROD} >= 0;
param vente_max {PROD} >= 0;
param tonnage_min {PROD} >= 0;
param tonnage >= 0 ;
param poid_prod {PROD} >=0;

var qte_produite {p in PROD} >= tonnage_min [p], <= vente_max [p];
var heure_prod = sum {p in PROD} (qte_produite [p] / vitesse_production [p]);



maximize profit :
    sum {p in PROD} poid_prod [p] * qte_produite[p];

subject to production_limitee :
    sum {p in PROD}
        (qte_produite [p] / vitesse_production [p]) <= heures_ouvrees;
subject to heure_prod_limit :
    heure_prod <= heures_ouvrees;



data;

set PROD := bandes rouleaux poutres;
param tonnage := 24750;
param heures_ouvrees := 40;
param: vitesse_production prix_vente vente_max tonnage_min poid_prod:=
bandes 200 25 6000 (tonnage*0.2) 10
rouleaux 140 30 4000 (tonnage*0.15) 5
poutres 160 29 3500 (tonnage*0.1) 15;


solve;
display qte_produite.lb, qte_produite, qte_produite.ub;