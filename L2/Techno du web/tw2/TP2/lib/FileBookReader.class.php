<?php
class FileBookReader implements BookReader{
	
	private $file; // file resource
	
	function __construct(string $fileName){
		$this->file = fopen($fileName,'r');
	}
	

	/**
	 *  lit les données d'un livre et renvoie une table associative 
	 * représentant le livre lu 
	 * @return : array ou NULL
	 * attributs possibles : couverture,titre,serie,auteurs,année,catégorie
	 * renvoie NULL si les données ne contiennent plus de livre.
	 */

/*
	### version prof ###
    function readBook() : ?array {
    $line = fgets($this->file);
    while ($line !== FALSE && trim($line) == "")
        $line = fgets($this->file);
    $result = array();
    while ($line !== FALSE && trim($line) != ""){
        $pos = strpos($line,":");
        if ($pos === FALSE){
             throw new Exception("Absence de : ");
        }
        $name = trim(substr($line,0,$pos));
        $value = trim(substr($line, $pos+1));
        $result[$name] = $value;
        $line = fgets($this->file);
    }
    if (count($result)>0)
        return $result;
    else
        return NULL;
    }  
/*
	###version 1 ###
	function readBook() : ?array {
		$res = array() ;		
		for($i=0;$i<5;$i++){	
					
			$temp = trim(fgets($this->file));
			if(strpos($temp,":")===False){
				throw new exception(" message d'erreur ");
			}
			$res[trim(strstr($temp,':', True))] = trim(substr(strstr($temp,':'),1));	
		}
	return $res;
	}

*/

function readBook() : ?array {
	$res= array();
	$temp = fgets($this->file);
	while(strlen(trim($temp)) != 0 or $temp != false){
		if(strlen(trim($temp))!==0){
			if(strpos($temp,":")===False){
				throw new exception(" manque le séparateur ':' ");
			}
			else{
				$res[trim(strstr($temp,':', True))] = trim(substr(strstr($temp,':'),1));
			}
		}
	$temp = trim(fgets($this->file));
	}
	if(sizeof($res)==0){
		return NULL;
	}
	else{
	return $res;
	}
	}



}

?>
