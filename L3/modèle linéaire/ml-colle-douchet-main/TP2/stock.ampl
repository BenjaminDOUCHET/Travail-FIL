set USINE;

#param
param commande_inf >=0 ;
param commande_inter >=0 ;
param commande_sup >= 0 ;
param qual_inf{USINE} >=0;
param qual_inter{USINE} >=0;
param qual_sup{USINE} >=0;
param cout_fonct {USINE}>=0;



#variable
var jour_fonct{u in USINE}>=0;

#variable_calculees
var qte_prod_inf = sum{u in USINE}(qual_inf[u]*jour_fonct[u]);
var qte_prod_inter = sum{u in USINE}(qual_inter[u]*jour_fonct[u]);
var qte_prod_sup = sum{u in USINE}(qual_sup[u]*jour_fonct[u]);

#objectif
minimize cout_prod:
    sum{u in USINE}(jour_fonct[u]*cout_fonct[u]);


#contraintes
subject to order_inf:
   sum{u in USINE}
    (qual_inf[u]*jour_fonct[u])>= commande_inf;
subject to order_inter:
   sum{u in USINE}
    (qual_inter[u]*jour_fonct[u])>=  commande_inter;
subject to order_sup:
    sum{u in USINE}
        (qual_sup[u]*jour_fonct[u])>= commande_sup ;


#data
data;
set USINE:= A B;
param commande_inf = 16 ;
param commande_inter = 5 ;
param commande_sup= 20;
param: qual_inf qual_inter qual_sup cout_fonct :=
A 8 1 2 1000
B 2 1 7 2000;
