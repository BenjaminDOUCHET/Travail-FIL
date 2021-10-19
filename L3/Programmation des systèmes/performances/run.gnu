set title "Temps et vitesse d'execution"
set output 'myCat.png'
set term png size 1024,768
set logscale x
set xlabel "taille buffer"

set ylabel "temps execution"
set style data linespoints
plot "ex2.dat" using 1:2 title "fichier 500Mo",\
     "ex3.dat" using 1:2 title "version std"
pause -1  "Hit return to continue"
