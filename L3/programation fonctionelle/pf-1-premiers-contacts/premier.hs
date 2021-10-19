import Distribution.Simple.Utils (xargs)
sommeDeXaY :: Int -> Int -> Int
sommeDeXaY x y = sum[x..y]

somme :: [Int]->Int
somme (x:xs) = x + somme xs
somme [] = 0

myLast :: [x]->x
myLast x = head(reverse x)

myInit :: [x] -> [x]
myInit x = reverse(tail(reverse x))

nElem :: Int -> [x] -> x
nElem n (x:xs)  | n>0 = nElem (n-1) xs
                | otherwise = x
                


myPlus :: [x]->[x]->[x]
myPlus [] y = y
myPlus x [] = x
myPlus (x:xs) y = x:myPlus xs y


myConcat :: [[x]]->[x]
myConcat [] = []
myConcat (x: []) = x
myConcat (x:xs) = myPlus x (myConcat xs)

myMap :: (x->y)->[x]->[y]
myMap x [] = []
myMap x (y:ys) = [(x y)] ++ (myMap x ys)

--Question 7 x = (!!) l on pourrais le traduire par l !! x donc , la fonction renverai la xème position de la liste l

myLength :: [x]->Int
myLength [] = 0
myLength x = somme ( myMap(\y->1 ) x)


mystere :: (a->a) -> a -> Int -> [a]
mystere f x n = if n<=0
                then []
                else x:mystere f (f x) (n-1)

mystere' :: (a->a) -> a -> Int -> [a]
mystere' f x n = take n (iterate (f) x)

listInt :: Int -> [Int]
listInt n = mystere (+1) 0 (n+1)