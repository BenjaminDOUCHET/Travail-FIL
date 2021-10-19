/* ------------------------------
   commun.h
   Définition des types
   ------------------------------------------------------------
*/
#define NB_ETUS 30
#define TAILLE_NOM 32

struct etudiant_s {
    unsigned int numero;
    float moyenne;
    char nom[TAILLE_NOM];
    char prenom[TAILLE_NOM];
};

union bloc_u {
    struct etudiant_s etu;
    char data[sizeof(struct etudiant_s)];
};

struct promotion_s {
    unsigned int taille; 
    struct etudiant_s etudiants[NB_ETUS];
    
};

union blocs_u {
    struct promotion_s promo ;
    char data[sizeof(struct promotion_s)];
};