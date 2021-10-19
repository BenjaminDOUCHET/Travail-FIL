<?php


function elementBuilder(string $elementType,string  $content,string $elementClass="") : string {
	return "<$elementType class='$elementClass'>$content</$elementType>";
}




function authorsToHTML(string $authors) : string {
    $temp= explode("-" , $authors);
    foreach($temp as &$val){$val=trim($val);}
    return "<span>".implode('</span><span>',$temp)."</span>";
}


function coverToHTML(string $fileName) : string {
    return "<img src='"."couvertures/$fileName"."' alt='image de couverture'/>";
}


function propertyToHTML(string $propName, string $propValue) : string {
    if($propName ==="titre"){
        return elementBuilder("h2",$propValue , $propName);
    }
    if($propName==="couverture"){
        return elementBuilder("div",coverToHTML($propValue),$propName);
    }
    if($propName==="auteurs"){
        return elementBuilder("div",authorsToHTML($propValue),$propName);
    }
    if($propName==="annee"){
        return elementBuilder("time",$propValue,$propName);
    }
    else{
        return elementBuilder("div",$propValue,$propName);
    }
}




function bookToHTML(array $book) : string {
    $res="<div class='description'>";
    foreach($book as $key => $val){
        if($key==="couverture"){
            $res= propertyToHTML($key,$val).$res;
        }
        else{
            $res=$res.propertyToHTML($key,$val);
        }
    }
    return"<article>$res</div></article>";
}



// exercice 2

function libraryToHTML(BookReader $datalayer) : string {
    $res;
    $temp = $datalayer->readbook();
    while($temp !==NULL){
            $res.= bookToHTML($temp);
            $temp = $datalayer->readbook();
    }
    return $res ;
}

?>
