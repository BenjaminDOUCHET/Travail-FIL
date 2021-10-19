<?php
    spl_autoload_register(function($classe){require "lib/$classe.class.php";}); // règle de chargement des classes
    require("etc/dsn_filename.php"); // definition de DSN_FILENAME

    require("lib/fonctionsLivre.php");
    require("lib/fonctions_parms.php");
 
    try {
        
        
        $dl = new DataLayer(DSN_FILENAME);
        if($_GET["author_id"]!="" and isset($_GET["author_id"])){
            $authorId=checkUnsignedInt("author_id");   
        }
        if($_GET["year"]!="" and isset($_GET["year"])){
            $year=checkUnsignedInt("year");
        }
        if($_GET["word"]!="" and isset($_GET["word"])){
            $word = $_GET["word"];
        }
        if($_GET["cat"]!="" and isset($_GET["cat"])){
            $cat = $_GET["cat"];
        }

        $books = $dl->getBooksWithConds($year, $authorId,$word,$cat );
        $libraryHTML = booksArrayToHTML($books);
        require("views/pageBibliotheque.php");
        
    } catch (ParmsException $e) {
        require "views/pageErreur.php";
    }
?>