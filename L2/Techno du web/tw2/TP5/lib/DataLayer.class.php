<?php
class DataLayer {
	// private ?PDO $conn = NULL; // le typage des attributs est valide uniquement pour PHP>=7.4

	private  $conn = NULL; // connexion de type PDO   compat PHP<=7.3
	
	/**
	 * @param $DSNFileName : file containing DSN 
	 */
	function __construct(string $DSNFileName){
        $dsn = "uri:$DSNFileName";
		$this->conn = new PDO($dsn);
		// paramètres de fonctionnement de PDO :
		$this->conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); // déclenchement d'exception en cas d'erreur
		$this->conn->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE,PDO::FETCH_ASSOC); // fetch renvoie une table associative
		// réglage d'un schéma par défaut :
		$this->conn->query('set search_path=authent');
	}
    
    
    function authentificationProvisoire(string $login, string $password) : ?Identite{
        $sql = <<<EOD
			select * from users
EOD;
		$stmt = $this->conn->prepare($sql);
        $stmt->execute();
        $res = NULL;
        while($ligne = $stmt->fetch()){
            if($ligne['login']==$login and $ligne['password']==$password){
                $res = new Identite($ligne['login'],$ligne['nom'],$ligne['prenom']);
            }
        }
        return $res;
    }
    
    function authentification(string $login, string $password) : ?Identite{ // version password hash
        $sql = <<<EOD
        select * from users
EOD;
    $stmt = $this->conn->prepare($sql);
    $stmt->execute();
    $res = NULL;

    while($ligne = $stmt->fetch()){
        if($ligne['login']==$login and crypt($password, $ligne['password']) == $ligne['password']){
            $res = new Identite($ligne['login'],$ligne['nom'],$ligne['prenom']);
        }
    }
    return $res ;

    }



    /**
    * @return bool indiquant si l'ajout a été réalisé
    */
    function createUser(string $login, string $password, string $nom, string $prenom) : bool	 {
        $sql = <<<EOD
        insert into "users" (login, password, nom, prenom)
        values (:login, :password, :nom, :prenom)
EOD;
    try{
    $stmt = $this->conn->prepare($sql);
    $stmt->bindValue(":login", $login);
    $stmt->bindValue(":password", password_hash($password,CRYPT_BLOWFISH));
    $stmt->bindValue(":nom", $nom);
    $stmt->bindValue(":prenom", $prenom);
    $stmt->execute();
    return TRUE;

    }
    catch(PDOException $e){
        return FALSE;
    }
    }






}
?>
