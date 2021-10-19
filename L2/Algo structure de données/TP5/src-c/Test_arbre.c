#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "ArbreBinaire.h"
#include "Affichage.h"


#define max(a,b) ((a)>(b)?(a):(b))

#define DEBUT_ARBRE_MYSTERIEUX 12
#define FIN_ARBRE_MYSTERIEUX 24

/* Manipulation d'arbres binaires */

Noeud_t arbre1 (void) {
   Noeud_t principal,sous_gauche,sous_droit;
   principal = CreerNoeud(12);
   sous_gauche = CreerNoeud(9);
   AjouterGauche(principal,sous_gauche);
   sous_droit = CreerNoeud(8) ;
   AjouterDroite(principal,sous_droit);
   return principal;
}

Noeud_t arbre2 (void) {
   Noeud_t rang0 , rang1, rang2 , rang3;
   rang0 =CreerNoeud(12);
   rang1=CreerNoeud(9);
   AjouterGauche(rang0,rang1);
   rang2=CreerNoeud(5);
   AjouterDroite(rang1,rang2);
   rang3=CreerNoeud(7);
   AjouterGauche(rang2,rang3);
   return rang0;
}

Noeud_t arbre3 (void) {
   Noeud_t noeud00, noeud10,noeud11,noeud20,noeud21,noeud22,noeud30,noeud31;
   noeud30 = CreerNoeud(7);
   noeud31 = CreerNoeud(6);
   noeud22 = CreerNoeud(4);
   AjouterGauche(noeud22,noeud30);
   AjouterDroite(noeud22,noeud31);
   noeud20 = CreerNoeud(1);
   noeud21 = CreerNoeud(5);
   noeud10 = CreerNoeud(9);
   noeud11 = CreerNoeud(8);
   AjouterDroite(noeud10,noeud21);
   AjouterGauche(noeud10,noeud20);
   AjouterDroite(noeud11,noeud22);
   noeud00 = CreerNoeud(12);
   AjouterGauche(noeud00,noeud10);
   AjouterDroite(noeud00,noeud11);
   return noeud00;
}

void imprimer (Noeud_t a) {
   if (a->gauche){
      imprimer(Gauche(a));
   }
   printf("%ld",a->val);
   if (a->droite){
      imprimer(Droite(a));
      
   }
}

int taille (Noeud_t a) {
   if(!a->gauche && !a->droite){
      return 1;
   }
   else if (a->gauche && a->droite){
      return 1+taille(Gauche(a))+taille(Droite(a));
   }
   else if (a->gauche && !a->droite){
      return 1+taille(Gauche(a));
   }
   else{
      return 1+taille(Droite(a));
   }
}

int hauteur (Noeud_t a) {
   int g=0,d=0;
   if(!a->gauche && !a->droite){
      return 1;
   }
   else{
      if(a->gauche){
         g=1+hauteur(Gauche(a));
      }
      if(a->droite){
         d=1+hauteur(Droite(a));
      }
      if(g>d){
         return g;
      }
      else{
         return d;
      }


   }
}

int nbFeuilles(Noeud_t a) {
   if(!a->gauche && !a->droite){
      return 1;
   }
   else if (a->gauche && a->droite){
      return nbFeuilles(Gauche(a))+nbFeuilles(Droite(a));
   }
   else if (a->gauche && !a->droite){
      return nbFeuilles(Gauche(a));
   }
   else{
      return nbFeuilles(Droite(a));
   }
  
}


/* Comptage d'arbres */

int nbArbres(int n) {
   int k ;
   if(n==0 ){
      return 1;
   }
   else{
      int res =0 ;
      for(k = 0 ;k<n ; k++){
         res += nbArbres(k) * nbArbres(n-k-1);
      }
       return  res;
   }
}
    

int nbArbresEfficace(int n ){
   int c[20] ;
   int i =0 ;
   int k;
   int temp ;

   for(i=0;i<20;i++){
      c[i]=0;
   }
   
  
   c[0]=1;
   
   for(i=1 ; i<n+1 ;i++){
      temp = 0 ;
      for(k=0;k<i;k++){
        temp += c[k]*c[i-k-1];
        
      }
      c[i] = temp;
   }

   return c[n];


}


/* Manipulation d'arbres binaires de recherche */

Noeud_t abr1 (void) {
   Noeud_t noeud00, noeud10,noeud11,noeud20,noeud21,noeud30;   
   noeud30 = CreerNoeud(1);
   noeud20 = CreerNoeud(2);
   noeud21 = CreerNoeud(5);
   noeud10 = CreerNoeud(4);
   noeud11 = CreerNoeud(7);
   AjouterGauche(noeud20,noeud30);
   AjouterDroite(noeud10,noeud21);
   AjouterGauche(noeud10,noeud20);
   noeud00 = CreerNoeud(6);
   AjouterGauche(noeud00,noeud10);
   AjouterDroite(noeud00,noeud11);
   return noeud00;
}

Noeud_t ajouter (value_t v, Noeud_t a) {
   Noeud_t  newNode = CreerNoeud(v);
   
   if( ValeurDuNoeud(newNode) == ValeurDuNoeud(a)){
      return 0;
   }

   if (ValeurDuNoeud(newNode)>ValeurDuNoeud(a)){
      if(!Droite(a) || EstFeuille(a)){
         AjouterDroite(a,newNode);
      }
      else{
         return ajouter(v,Droite(a));
      }
   }
   else{
      if(!Gauche(a) || EstFeuille(a)){
          AjouterGauche(a,newNode);
      }
      else{
         return ajouter(v,Gauche(a));
      }
   }
   return 0;
}

Noeud_t abr2 (void) {
   int c[6] = {5,4,2,7,6,1};
   int i;
   Noeud_t arbre  =  CreerNoeud(c[0]);
   
   for(i=1;i<6;i++){
      ajouter(c[i],arbre);
   }
   
   return arbre;
}

Noeud_t abr3 (void) {
   int c[6] = {7,1,4,5,6,2};
   int i;
   Noeud_t arbre  = CreerNoeud(c[0]);
   
   for(i=1;i<6;i++){
      ajouter(c[i],arbre);
   }
   
   return arbre;
}


int appartient (value_t v, Noeud_t a ,int *cpt) {
  Noeud_t arbre = a ;
  
  
  while( arbre ){
      if(v == ValeurDuNoeud(arbre)){
         *cpt = *cpt+1 ;
      return 1;
      }
      if(v > ValeurDuNoeud(arbre)){
         *cpt = *cpt+1;
         arbre = Droite(arbre);
      } 
      else{
         arbre = Gauche(arbre);
         *cpt = *cpt+1;
      }
    }
    
    return 0;
}

int valeur_minimale (Noeud_t abr) {
   if( EstVide(abr)){
      return -1;
   }
   if(Gauche(abr)){
      return valeur_minimale(Gauche(abr));
   }
   else{
      return ValeurDuNoeud(abr);
   }
   
}

int valeur_maximale (Noeud_t abr) {
    if( EstVide(abr)){
      return -1;
   }
   if(Droite(abr)){
      return valeur_maximale(Droite(abr));
   }
   else{
      return ValeurDuNoeud(abr);
   }
}

/* Entier mysterieux */


Noeud_t construitArbreEntierMysterieux (value_t i, value_t j) { 
   int racine;
   Noeud_t newNode ;
   
   if(j-i<1){
      
      return CreerNoeud(i);
   }
   else if((j-i)/2+i == i){
      newNode = CreerNoeud(i);
      AjouterDroite(newNode,CreerNoeud(j));
      return newNode;
   }
   else{  
      racine = (j-i)/2;
      newNode = CreerNoeud(i+racine);
      AjouterDroite(newNode ,construitArbreEntierMysterieux(racine+i+1,j));
      AjouterGauche(newNode ,construitArbreEntierMysterieux(i,racine+i-1));
      return newNode;
   
   }
   
}


void jouer (int i, int j) {
srand(time(NULL));
Noeud_t ABR = construitArbreEntierMysterieux(i,j);
int trouve = 0;
int ran = rand() ;
int reponse = (ran%(j-i+1))+i;
int askVal;
printf("la reponse tirée est : %d \n" , reponse);

while(!trouve){
   askVal = ValeurDuNoeud(ABR);
   printf("Est-ce %d ?\n",askVal);
   if(askVal == reponse){
      printf("Gagné ! \n");
      trouve = 1;
   }
   else if(askVal<reponse){
      printf("Trop petit \n");

      ABR = Droite(ABR);
   }
   else{
      printf("Trop grand \n");
      ABR = Gauche(ABR);
   }
}



}




/* Tests sur les arbres binaires */

void testArbreBinaire(Noeud_t a) {
   imprimer(a); printf("\n");
   printf("Taille     = %d\n",(taille(a)));
   printf("Hauteur    = %d\n",(hauteur(a)));
   printf("nbFeuilles = %d\n",(nbFeuilles(a)));
}

/* Tests sur les arbres binaires de recherche */
void testABR (Noeud_t a) {
   int i;
   int compt = 0;
   int *cpt = &compt;
   
   imprimer(a); printf("\n");
   printf("Taille     = %d\n",(taille(a)));
   printf("Hauteur    = %d\n",(hauteur(a)));
   printf("nbFeuilles = %d\n",(nbFeuilles(a)));
   printf("Valeurs présentes dans l'arbre : ");
  
   
   for (i = 0; i <= 10; i++) {

      if (appartient(i,a,cpt)) {
         printf("%d ",i);
      }
      
   }

   
   printf("\n");
   /* décommpte des comparaisons */ 
   *cpt = 0; /* raz du compteur */ 
   appartient(0,a,cpt);
   printf("total des comparaisons pour la recherche du 0 : %d ", *cpt);
   
   printf("\n");
}
  
/* Programme principal */
int main (int argc, char **argv) {

   int i;
   Noeud_t arbre;
   Noeud_t a1 = arbre1();
   Noeud_t a2 = arbre2();
   Noeud_t a3 = arbre3();
   
   testArbreBinaire(a1);
   testArbreBinaire(a2);
   testArbreBinaire(a3);

   DetruireArbre(a1);
   DetruireArbre(a2);
   DetruireArbre(a3);

   for (i = 0; i <= 19; i++) {
      printf("Le nombre d'arbres à %d noeuds est %d\n",i,(nbArbresEfficace(i)));
   }
   
   a1 = abr1();
  
   a2 = abr2();
   
   
   a3 = abr3();
   
   testABR(a1);
   
   testABR(a2);
   
   testABR(a3);

  printf("la valeur minimale de a3 est %d et sa valeur maximale est : %d",valeur_minimale(a3),valeur_maximale(a3));
  putchar('\n');
   DetruireArbre(a1);
   DetruireArbre(a2);
   DetruireArbre(a3);


   printf("Arbre mysterieux entre %d et %d:\n", DEBUT_ARBRE_MYSTERIEUX, FIN_ARBRE_MYSTERIEUX);
  
   arbre = construitArbreEntierMysterieux(DEBUT_ARBRE_MYSTERIEUX, FIN_ARBRE_MYSTERIEUX);
   SauverArbreDansFichier(arbre,"test");
   imprimer(arbre);
   printf("\n");
  
   jouer(DEBUT_ARBRE_MYSTERIEUX, FIN_ARBRE_MYSTERIEUX);

   return 0;
   
}
