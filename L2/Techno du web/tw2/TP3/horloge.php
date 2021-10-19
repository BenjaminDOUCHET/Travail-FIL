<?php
  
  require("lib/ParmsException.class.php");

  require("lib/fonctions_parms.php");
  $hands = checkColor('hands',"black");
  $markers =  checkColor('markers',"grey");
  $bg =  checkColor('bg',"transparent");
  require("lib/fonctions_clock.php");
  
/**
 * IMPORTANT : 
 * Ce script n'est qu'une ébauche.
 * 
 * En l'état actuel son fonctionnement n'est pas satisfaisant
 *
 * 
 * Utiliser directement les variable du tableau $_GET peut être dangereux
 *
 * Ce script est à modifier et compléter au cours de l'exercice
 * 
 */



$hours  = checkUnsignedInt('hours', 0);
$minutes = checkUnsignedInt('minutes', 0);

//de base on peux mettre : 
    // isset($_GET['seconds']) ? $GET['seconds']:'0' 
    // mais plus élégament :
    //$seconds = $_GET['seconds'] ?? '0';
$seconds  =checkUnsignedInt('seconds', 0);
$angles = angles($hours, $minutes, $seconds);
require('views/page.php');


?>