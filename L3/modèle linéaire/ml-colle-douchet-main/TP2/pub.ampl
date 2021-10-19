set PUB;

#parametres
param budget>=0;
param cout {PUB}>=0;
param conso_touche{PUB}>=0;
param unit_min{PUB}>=0;
param jour_travail{PUB} >=0;
param jour_travail_max >=0;

#variables
var nb_unit {p in PUB} >= unit_min[p];

#variables calculees
var budget_used = sum {p in PUB} (cout[p]*nb_unit[p]);
var jour_travail_used = sum {p in PUB} (jour_travail[p]*nb_unit[p]);


#objectif
maximize consomateur:
    sum{p in PUB}(nb_unit[p]*conso_touche[p]);

#contraintes

subject to max_budget :
    budget_used <= budget;
subject to travail_max:
    jour_travail_used<= jour_travail_max;



#data
data;
set PUB := tele mag radio;
param budget = 1000000 ;
param jour_travail_max = 500;
param: conso_touche cout unit_min jour_travail:=
tele 1800000 20000 10 5
mag 1000000 10000 2 15
radio 250000 2000 2 1;


solve;
display conso_touche , nb_unit;