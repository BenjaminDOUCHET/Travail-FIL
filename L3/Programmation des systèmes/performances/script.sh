#!/bin/bash
# Exemple de script shell qui mesure le temps d'exécution de
# "macommande" avec des arguments différents
# on défnini la variable globale 
# Mon programme

MYCAT=./myCat
MYCATSTD=./myCat-std
TIME_CMD=/usr/bin/time
TIME_FILE=ex2.dat
TIME_FILE2=ex3.dat



function testFile (){
	dd if=/dev/urandom of=$1 bs=1M count=$2 
}



# on crée les fichiers pour le test 
mkdir test
testFile "test/file5.bin" 5 
chmod +rwx test/file5.bin
testFile "test/file200MO.bin" 200
chmod +rwx test/file200MO.bin

# on test le programme
$MYCAT 1024 test/file5.bin > test/file5
$MYCAT 1024 test/file200MO.bin > test/file200MO
diff test/file5.bin test/file5 && echo "TEST Petit fichier: OK"
diff test/file200MO.bin test/file200MO && echo "TEST fichier mesure: OK"


# on initialise le stockage
echo '# real user sys ' > $TIME_FILE


# on test en faisant varier le buffer


for size in `awk 'BEGIN{ for(i=32; i<=8388608; i*=2 ) print i }'`;
do
	
	$TIME_CMD -f "$size %e " $MYCAT $size test/file200MO.bin > /dev/null 2>> $TIME_FILE | time -f "$size %e" $MYCATSTD test/file200MO.bin > /dev/null 2>> $TIME_FILE2
done
#EOF