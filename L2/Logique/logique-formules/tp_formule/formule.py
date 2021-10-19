# Binôme :
# Colle Maxime 
# DOUCHET Benjamin


class Et:
    """Classe permettant de construire des conjonctions de formules"""
    def __init__(self,gauche,droite):
        self.gauche = gauche
        self.droite  = droite

    def f_gauche(self):
        return self.gauche

    def f_droite(self):
        return self.droite

    def to_string(self):
        return "(" + self.f_gauche().to_string() + " ∧ " + self.f_droite().to_string() + ")"

    def hauteur(self) :
        return 1 + (self.gauche.hauteur()+self.droite.hauteur())

    def variables(self):
        return set(self.f_gauche().variables()).union(set(self.f_droite().variables()))

    def eval(self,valuation):
       
        return self.gauche.eval(valuation)and self.droite.eval(valuation)

    def pousse_negation(self,neg):
        if neg:
            return  "(" +self.f_gauche().pousse_negation(neg)  + " \/ " +  self.f_droite().pousse_negation(neg) + ")"
        else :
            return  "(" +self.f_gauche().pousse_negation(neg)  + " /\ " + self.f_droite().pousse_negation(neg) + ")"

class Ou:
    """Classe pemettant de construire des disjonctions de formules"""
    def __init__(self,gauche,droite):
        self.gauche = gauche
        self.droite  = droite

    def f_gauche(self):
        return self.gauche

    def f_droite(self):
        return self.droite

    def to_string(self):
        return "(" + self.gauche.to_string() + " ∨ " + self.droite.to_string() + ")"

    def hauteur(self) :
        return 1 + (self.gauche.hauteur()+self.droite.hauteur())


    def variables(self):
        return set(self.f_gauche().variables()).union(set(self.f_droite().variables()))

    def eval(self,valuation):
        
        return self.gauche.eval(valuation) or self.droite.eval(valuation)

    def pousse_negation(self,neg):
        if  neg :
            return "(" + self.f_gauche().pousse_negation(neg) + " /\ " + self.f_droite().pousse_negation( neg)  + ")"
        else :
            return "(" + self.f_gauche().pousse_negation(neg)  + " \/ " + self.f_droite().pousse_negation(neg) + ")"


class Non:
    """Classe permettant de construire des négations de formules"""
    def __init__(self,formule):
        self.formule = formule

    def f_formule(self):
        return self.formule

    def to_string(self):
        return "¬" + self.f_formule().to_string()

    def hauteur(self) :
        return 0 + self.f_formule().hauteur()

    def variables(self):
        return set(self.f_formule().variables())

    def eval(self,valuation):
        
        return not self.f_formule().eval(valuation)

    def pousse_negation(self,neg):
        if neg :
            return self.f_formule().pousse_negation(not neg) 
        else :
            return self.f_formule().pousse_negation(not neg) 



class Vrai:
    """Classe des tautologies"""
    def __init__(self):
        return

    def to_string(self):
        return "T"

    def hauteur(self) :
        return 0

    def variables(self):
        return set()

    def eval(self,valuation):
        return True

    def pousse_negation(self,neg):
        if neg:
            return 'faux'
        else :
            return 'vrai'

        


class Faux:
    """Classe des contradictions"""
    def __init__(self):
        return

    def to_string(self):
        return "⊥"

    def hauteur(self) :
        return 0

    def variables(self):
        return set()

    def eval(self,valuation):
        return False

    def pousse_negation(self,neg):
        if neg :
            return 'vrai'
        else :
            return 'faux'



class Variable:
    """Classe permettant de construire des variables propositionnelles"""
    def __init__(self,variable):
        self.nom_variable = variable

    def nom(self):
        return self.nom_variable

    def to_string(self):
        return self.nom()

    def hauteur(self) :
        return 0

    def variables(self):
        return set(self.nom())

    def eval(self,valuation):
        return valuation[self.nom_variable]

    def pousse_negation(self,neg):
        if neg :
            return  "~"+ self.nom()
        else :
            return self.nom()
