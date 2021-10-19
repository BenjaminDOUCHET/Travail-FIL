<?php
set_include_path('..'.PATH_SEPARATOR);
require_once('lib/common_service.php');
require_once('lib/initDataLayer.php');
require('lib/fonctions_parms.php');

try{
  $insee = checkString("insee");
  $result = $data->getDetails($insee,NULL,FALSE);
  
  produceResult($result);
  
}
catch (PDOException $e){
    produceError($e->getMessage());
}


?>
