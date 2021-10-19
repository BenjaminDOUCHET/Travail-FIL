-- TP COLLE DOUCHET
import Graphics.Gloss

type Symbole  = Char
type Mot      = [Symbole]
type Axiome   = Mot
type Regles   = Symbole -> Mot
type LSysteme = [Mot]
type EtatTortue = (Point, Float)
type EtatDessin = ([EtatTortue], [Path])

type Config = (EtatTortue -- État initial de la tortue
              ,Float      -- Longueur initiale d’un pas
              ,Float      -- Facteur d’échelle
              ,Float      -- Angle pour les rotations de la tortue
              ,[Symbole]) -- Liste des symboles compris par la tortue




--recursivité
motSuivant :: Regles -> Mot -> Mot

motSuivant f [] = []
motSuivant f (x:xs) = (f x) ++ motSuivant f xs


--compréhension
motSuivant' :: Regles -> Mot -> Mot
motSuivant' reg mot = concat [ reg imot | imot <- mot]

--fonction choisie

motSuivant'' :: Regles -> Mot -> Mot
motSuivant'' = concatMap


--flocon
--on dééfini l'axiome
axio :: Axiome
axio = "F-F++F-F"

-- on défini flocon 
flocon :: Regles
flocon 'F' = axio
flocon '+' = "+"
flocon '-' = "-"


lsysteme :: Axiome -> Regles -> LSysteme
lsysteme ax re  = iterate(motSuivant re) ax

--parti sur la tortue 

--extraction des données : 

etatInitial :: Config -> EtatTortue
etatInitial (elt,_,_,_,_) =elt

longueurPas :: Config -> Float
longueurPas (_,elt,_,_,_) = elt

facteurEchelle :: Config -> Float
facteurEchelle ( _,_,elt,_,_) =elt

angle :: Config -> Float
angle (_,_,_,elt,_) = elt

symbolesTortue :: Config -> [Symbole]
symbolesTortue (_,_,_,_,elt) =elt


-- fonctions de mouvement
avance :: Config -> EtatTortue -> EtatTortue
avance conf ((x,y),ang) = ((destX,destY),ang)
            where destX = x+(longueurPas conf) * (cos ang)
                  destY = y+(longueurPas conf) * (sin ang)

tourneAGauche :: Config -> EtatTortue -> EtatTortue
tourneAGauche conf ((x,y),angl) = ((x,y),angl+(angle conf))

tourneADroite :: Config -> EtatTortue -> EtatTortue
tourneADroite conf ((x,y),angl) = ((x,y),angl-(angle conf))

-- fonction filtre des mots.
filtreSymbolesTortue :: Config -> Mot -> Mot
filtreSymbolesTortue conf mo =[ m | m<-mo , m `elem` (symbolesTortue conf)]


-- fonctions de dessin


-- Nouvelle fonction d'interprêtation des symboles
interpreteSymbole :: Config -> EtatDessin -> Symbole -> EtatDessin
interpreteSymbole   conf (ei:es,pi:ps) s  | s == '[' = (ei:ei:es , pi:pi:ps)
                                          | s == ']'  = (es,pi:ps)
                                          | otherwise = (et':es, (pi++ [fst et']):ps)
                                                      where et' | s == 'F'  = avance conf ei
                                                                | s == '+'  = tourneAGauche conf ei
                                                                | s == '-'  = tourneADroite conf ei
                                                                | otherwise = error "wrong symbol"




interpreteMot :: Config -> Mot -> Picture
interpreteMot conf mo = line(head(snd(foldl (interpreteSymbole conf) etatD suitM)) )
                            where etatInter = fst (etatInitial conf)
                                  etatD = ([etatInitial conf] , [[etatInter]])
                                  suitM = filtreSymbolesTortue conf mo

    

lsystemeAnime :: LSysteme -> Config -> Float -> Picture
lsystemeAnime lsys conf@(eT , pas , fE , ang , path) x = interpreteMot newConf (lsys !! nieme )
                        where nieme = round x `mod` 8
                              newConf = (eT , pas*(fE^nieme) , fE , ang , path) 



----------- EXEMPLES ------------------

vonKoch1 :: LSysteme
vonKoch1 = lsysteme "F" regles
    where regles 'F' = "F-F++F-F"
          regles  s  = [s]

vonKoch2 :: LSysteme
vonKoch2 = lsysteme "F++F++F++" regles
    where regles 'F' = "F-F++F-F"
          regles  s  = [s]

hilbert :: LSysteme
hilbert = lsysteme "X" regles
    where regles 'X' = "+YF-XFX-FY+"
          regles 'Y' = "-XF+YFY+FX-"
          regles  s  = [s]

dragon :: LSysteme
dragon = lsysteme "FX" regles
    where regles 'X' = "X+YF+"
          regles 'Y' = "-FX-Y"
          regles  s  = [s]

vonKoch1Anime :: Float -> Picture
vonKoch1Anime = lsystemeAnime vonKoch1 (((-400, 0), 0), 800, 1/3, pi/3, "F+-")

vonKoch2Anime :: Float -> Picture
vonKoch2Anime = lsystemeAnime vonKoch2 (((-400, -250), 0), 800, 1/3, pi/3, "F+-")

hilbertAnime :: Float -> Picture
hilbertAnime = lsystemeAnime hilbert (((-400, -400), 0), 800, 1/2, pi/2, "F+-")

dragonAnime :: Float -> Picture
dragonAnime = lsystemeAnime dragon (((0, 0), 0), 50, 1, pi/2, "F+-")

brindille :: LSysteme
brindille = lsysteme "F" regles
    where regles 'F' = "F[-F]F[+F]F"
          regles  s  = [s]

broussaille :: LSysteme
broussaille = lsysteme "F" regles
    where regles 'F' = "FF-[-F+F+F]+[+F-F-F]"
          regles  s  = [s]

brindilleAnime :: Float -> Picture
brindilleAnime = lsystemeAnime brindille (((0, -400), pi/2), 800, 1/3, 25*pi/180, "F+-[]")

broussailleAnime :: Float -> Picture
broussailleAnime = lsystemeAnime broussaille (((0, -400), pi/2), 500, 2/5, 25*pi/180, "F+-[]")


dessin = interpreteMot (((-150,0),0),100,1,pi/3,"F+-") "F+F--F+F"

main :: IO()

main = display (InWindow "L-système" (1000, 1000) (0, 0)) white (brindilleAnime 50)