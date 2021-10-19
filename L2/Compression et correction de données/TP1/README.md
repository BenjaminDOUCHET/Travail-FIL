# CDC COLLE DOUCHET

1 | Notion d’entropie

Question 1.1:

        La valeur maximale d'entropie d'un fichier est atteinte quand tout les caractères du fichers sont equiprobables. ainsi on aura LOG2(N) où N est le nombre total d'élement du fichier.

        on trouvera ceci pour un fichier utilisant un nombre egal de fois chaque caractère.

Question 1.2 :

```math
-\sum_{s=0}^{255} \frac{n_s}{N}log_2(\frac{n_s}{N})
```

```math
-\sum_{s=0}^{255} \frac{n_s}{N}(log_2(n_s)-log_2(N))
```

```math
-\sum_{s=0}^{255} \frac{n_s}{N}*(log_2(n_s)) + \sum_{s=0}^{255} \frac{n_s}{N}(log_2(N))
```

```math
-\frac{1}{N}\sum_{s=0}^{255} n_s log_2(n_s) + \frac{1}{N}  N  log_2(N)
```

```math
log_2(N)-\frac{\sum_{s=0}^{255}n_slog_2(n_s)}{N}
```


Questions 1.3 à 2.7 : 

traitée dasnle code


Question 2.8 : 

le thèorême du codage sans bruit nous montre que la 
longueure moyenne d'un codage est comprise (pour un alphabet de destination de taille 2) entre : 

entropie de S et entropie de S +1 

où S est l'alphabet source.


Question 2.9 :

le pourcentage de réduction de la taille du fichier sera donc :

```math
100-\frac{100H(s)nbCarac}{8nbCarac}
```


Question 3.2 :

Nous avons testé avec plusieur forme d'encodage de fichier. 
au vu des résultats on peut remarquer 2 choses : 
        certains fichiers ne peuvent pas être traités par nos fonction, ce qui peut vouloir dire qu'elles n'utilisent pas les caractères ascii que nous reconnaissons dans notre count_occurrences. 
        
        ainsi on peut supposer que ces fichier on deja une forme de compression dans leurs extension.
        donc on peut les regrouper en deux groupes : les fichier bruts , les fichier deja partiellement compréssés.