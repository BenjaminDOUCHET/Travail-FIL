<?php /*
   Licence Informatique Université de Lille 2020
   
   Assert : Une variable globale nommée $bibliHTML contient le code HTML permettant l'affcihage des livres

*/?>
<!DOCTYPE html>
<html lang="fr" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Bibliothèque</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="style/livre.css" title="style 1"/>
    </head>
    <body>
        <header>
            <h1>Bibliothèque</h1>
        </header>
        <?php
          echo $bibliHTML; 
        ?>
    </body>
    
</html>