<?php




 /**
  *  prend en compte le paramètre $name passé en mode POST
  *  
  *  @return : valeur retenue, convertie en int.
  *   - si le paramètre est absent ou vide, renvoie  $defaultValue
  *   - si le paramètre est incorrect, déclenche une exception ParmsException
  *
  */
function checkParms(string $name, ?int $defaultValue=NULL, bool $mandatory=TRUE) : ?String{
     
$res=$_POST[$name];

try{
     if(($_POST[$name]=="" or !isset($_POST[$name])) and $defaultValue==NULL and $mandatory==TRUE){
          throw new ParmsException("no parms in input");
     }
     elseif(($_POST[$name]=="" or !isset($_POST[$name])) and $defaultValue==NULL and $mandatory==FALSE){
          return NULL;
       }
     elseif($_POST[$name]==""){
          $res=$defaultValue;
     }
    
     else{
          $res = $_POST[$name] ?? $defaultValue;
     }
     
} 
catch(ParmsException $e){
     require('views/pageErreur.php');
}

return $res ;
} 
   
     
 ?>