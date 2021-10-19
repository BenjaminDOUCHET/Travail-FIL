from analyseur import formules_depuis_fichier

from formule import *


for f in formules_depuis_fichier("formules.txt"):
    values= {'a' : True, 'b' : False, 'c' : True , 'd' : False}
    print(f.to_string() , f.hauteur() , f.variables(), " ",f.eval(values))
    print("     ")


for f in formules_depuis_fichier("formules.txt"):
    values= {'a' : True, 'b' : False, 'c' : True , 'd' : False}
    print(f.to_string() ,"    ",f.pousse_negation(True),"     " ,f.pousse_negation(False) )
    

