DOUCHET Benjamin
COLLE Maxime

Exercice 5

$: stat test

à priori je suppose :

File = nom du fichier
Size = la taille du fichier en octet 
Bolcks = le nombre de block mémoire aloué pour le stockage e ce fichier
IO Blocks = je ne sais pas 
Device peut être le code de la machine usr laquel est stocké le fichier ?
Inode je ne sais pas 
Links = liens de ce ficchier avec d'autres fichiers
Acess = les droits d'accès 
Uid = user Id 
Gid = group Id 
Acess modify change = les date du dernier accès de la dernière modification 
Birth la date de création du fichier

Exercice 6

 j'ai tapé :
 % whatis stat

 j'ai eu en retour lesendroit où stat est référencé dans le man

Exercice 7

La commande stat repose sur la cmmande système du même nom "stat"
on vois que les données sont attenddues sous la forme %lx %ld dans le ccode de la fonction stat on peut donc en déduire que ce sont des types long int et long unsigned int suivant les cas.

io Blocks = taille des block pour les fichiers système I/O
block = nombre de block de taille 512 alloué  pour le fichier

Exercice 8

La valeur de block passe directement de 8 à 16 . ce qui veut dire qu'il 
alloue dynamiquement de la mémoire avec pour plus petite unité de mémoire 
512 octet

Exercice 9

ln test hLinkToTest
ln -s sLinkToTest 
cp test ./cpTest

Exercice 10 

sans surprise la fichier test ( donc le fichier initial) possède 2 liens 
et sa copie un seul lien.

on remarque que les numeros de i-node sont également différent.

Après destruction du fichier test , n peut retrouver le fichier uniquement dans le hard link et dans la copie. le soft link n'étant qu'une adresse vers le fichier test il n'est pas supprenant de ne plus pouvoir accèder au données détruites.

Exercice 11

voir code

Exercice 12

voir code

Exercice 13

voir code


