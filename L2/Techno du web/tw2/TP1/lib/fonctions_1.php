<?php
//  créer les fonctions ici
function afficheVar (int $n ,string $s): string {
  return " \$n vaut $n et \$s vaut $s " ;
}

function n_parag(string $texte , int $n): string {
  $res = '';
  for($i=0 ; $i<=$n ; $i++){
    $res.= '<div>'.$texte.'</div>';
  }
  return $res;
}

function paragrapheTronque(string $texte , int $i): string{
    return '<div>'.substr($texte,0,$i).'</div>';

}

function diminue($texte) : string {
  $res ='';
  for($i=0; $i<=strlen($texte) ; $i++){
    $res.= paragrapheTronque($texte,$i);
  }
  return $res;
}

function paragrapheTronqueUl(string $texte , int $i): string{
      return '<li>'.substr($texte,0,$i).'</li>';}

function diminueUl($texte) : string {
  $res ='<ul>';
  for($i=0; $i<=strlen($texte) ; $i++){
    $res= paragrapheTronqueUl($texte,$i).$res;
  }
  return $res.'</ul>';
}

function multiplication(int $x , int $y): string{
  return"<li> $x*$y =".strval($x*$y).'</li>';
}

function tableMultiplication(int $x){
  $res='<ul>';
  for($i = 0 ; $i < 10 ; $i++){
    $res.= multiplication($x ,$i);
  }
  return $res.'</ul>';
}

function tablesMultiplication(){
  $res='<ul>';
  for($i=1 ; $i<=9 ; $i++){
    $res.='<li>'.tableMultiplication($i).'</li>';
  }
  return $res.'</ul>';
}

function tableauMult(){
  $res='<table id="multiplications"><tbody><tr><th>*</th><th>1</th><th>2</th><th>3</th><th>4</th><th>5</th><th>6</th><th>7</th><th>8</th><th>8</th></tr>';
  for($i =1 ; $i<10 ;$i++){
    $res.="<tr><th> $i </th>";
    for($j=1;$j<10;$j++){
      $res.='<td>'.strval($i*$j).'</td>';
    }
    $res.='</tr>';
  }
  return $res.'</tbody></table>';

}

?>
