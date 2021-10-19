<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Formulaire de recherche de livres</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="" />
        <style>
           
        </style>
    </head>
    <body>
        <header>
            <h1>Formulaire de recherche de livres</h1>
        </header>
        
       <form action="bib_search.php" method="get">
        <label>Choix de l'auteur :
            <select name="author_id">
                <option value="">(tous)</option>
                <?= $optionsAuteurs ?>
            </select>
            <br />
        </label>
        <label for="year">Annee de parution  :</label>
        <input type="number" id="year" placeholder="0" name="year" step="1" min="0" max="2020">
        <br />
        <label for="word">titre contenant :</label>
        <input type="text" name="word" id="word"/>
        <br />
        <label for="cat">catégorie :</label>
        <input type="text" name="cat" id="cat"/>
        <br />
        <button type="submit" name="valid" value="1">Rechercher</button>
       </form>
     
    </body>
    
</html>