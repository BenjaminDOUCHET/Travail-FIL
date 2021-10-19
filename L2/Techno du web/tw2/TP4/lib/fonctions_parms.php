<?php
/*
 require(__DIR__."/color_defs.php"); // definit la constante COLOR_KEYWORDS

 /**
  *  prend en compte le paramètre $name passé en mode GET
  *   qui doit représenter une couleur CSS
  *  @return : valeur retenue
  *   - si le paramètre est absent ou vide, renvoie  $defaultValue
  *   - si le paramètre est incorrect, déclenche une exception ParmsException
  *
  */

  /*
 function checkColor(string $name, string $defaultValue) : string {
     $res=$_GET[$name];
     
     try{
          if($_GET[$name]==""){
               $res=$defaultValue;
          }
          elseif(preg_match(COLOR_REGEXP,$_GET[$name])){
              $res = $_GET[$name];
          }
          else{
               if(isset(COLOR_KEYWORDS[$_GET[$name]]) or $_GET[$name]=="transparent"){
                    $res = $_GET[$name];
               }
               else{
                    throw new ParmsException("not a referenced color");
               }
          }
          
     } 
     catch (ParmsException $e){
          require('views/pageErreur.html');
     }
     
     
     return (string)$res ;

  }
  
  */


 /**
  *  prend en compte le paramètre $name passé en mode GET
  *   qui doit représenter un entier sans signe
  *  @return : valeur retenue, convertie en int.
  *   - si le paramètre est absent ou vide, renvoie  $defaultValue
  *   - si le paramètre est incorrect, déclenche une exception ParmsException
  *
  */
function checkUnsignedInt(string $name, ?int $defaultValue=NULL, bool $mandatory=TRUE) : ?int{
     
$res=$_GET[$name];

try{
     if(($_GET[$name]=="" or !isset($_GET[$name])) and $defaultValue==NULL and $mandatory==TRUE){
          throw new ParmsException("no number in input");
     }
     elseif(($_GET[$name]=="" or !isset($_GET[$name])) and $defaultValue==NULL and $mandatory==FALSE){
          return NULL;
       }
     elseif($_GET[$name]==""){
          $res=$defaultValue;
     }
     elseif(ctype_digit($_GET[$name])==false){
          throw new ParmsException("not a positive number");
       }
     else{
          $res = $_GET[$name] ?? $defaultValue;
     }
     
} 
catch(ParmsException $e){
     require('views/pageErreur.php');
}

return (int)$res ;
} 
   
     
 ?>