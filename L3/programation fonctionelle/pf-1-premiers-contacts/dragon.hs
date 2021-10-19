-- TP Second contact COLLE DOUCHET

import Graphics.Gloss

main = animate (InWindow "Dragon" (500, 500) (0, 0)) white (dragonAnime (50,250) (450,250))

--dragonAnime a b t = Line (dragon a b !! (round t `mod` 20)
dragonAnime a b t = Line (dragonOrdre a b (round t `mod` 10))

--dessineDragon =  (dragon (0,1) (5,6))
dessineDragon =  (dragonOrdre (0,1) (5,6) 10)

-- Echauffement

alterne :: [a] -> [a]
alterne [] = []
alterne [x] = [x]
alterne (x:xs) = x:alterne(tail xs)

combine :: (a->b->c) -> [a] -> [b] -> [c]
combine f x [] = []
combine f [] y = []
combine f (x:xs) (y:ys) = (f x y) : combine f xs ys

-- Triangle de Pascal

pasPascal :: [Integer] -> [Integer]

pasPascal [] = [1]
pasPascal li = [1]++(zipWith (+) (tail li) (init li) )++[1]

pascal :: [[Integer]]
pascal = iterate pasPascal[1]

-- Courbe du dragon

type Point = (Float,Float)
type Path = [Main.Point]

pointAintercaler :: Main.Point -> Main.Point -> Main.Point
pointAintercaler (xa,ya) (xb,yb) = ((xa+xb)/2+(yb-ya)/2,(ya+yb)/2+(xa-xb)/2)

pasDragon :: Main.Path -> Main.Path
pasDragon [] = []
pasDragon [x] = [x]
pasDragon[xa,xb] = xa : [pointAintercaler xa xb] ++ [xb] 
pasDragon (xa:(xb:(xc:xs))) = xa : (pointAintercaler xa xb) : xb : (pointAintercaler xc xb) : pasDragon (xc:xs)


dragon :: Main.Point -> Main.Point -> [Main.Path]
dragon xa xb = iterate pasDragon [xa,xb]

dragonOrdre :: Main.Point -> Main.Point -> Int -> Main.Path
dragonOrdre xa xb 0 = [xa,xb]
dragonOrdre xa xb n = pasDragon(dragonOrdre xa xb (n-1))