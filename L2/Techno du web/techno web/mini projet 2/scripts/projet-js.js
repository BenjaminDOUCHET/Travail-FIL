// projet JS 2020 - codez

const setupListener = function(){
  /* je déclare deux elements sur lequels je devrais travailler */

  let mem ;
  document.getElementById("toggle").addEventListener('click' , masque);
  document.getElementById("addinnerspace").addEventListener('click' , inspace)
  document.getElementById("addouterspace").addEventListener('click' , outspace)


  /* on récupère toutes les commentaires puis on les abonnes */
  const com = document.getElementsByClassName("comment");
  for(let elements of com){
    elements.addEventListener('mouseover', surligne);
    elements.addEventListener('mouseout' , restaure);
  }


}

window.addEventListener('DOMContentLoaded' , setupListener);

/* fonction pour ajouter de l'espace exterieur */

const outspace = function(){

  blocp = document.querySelectorAll("p") ;
  for( i = 0 ; i<blocp.length ;i++){
    var stylep = window.getComputedStyle(blocp[i])
    var valmarg = parseInt(stylep.marginTop)+5
    blocp[i].style.margin = valmarg.toString()+'px'
  }


  }






/* fonction pour ajouter de l'epace à l'interieur */
const inspace = function(){
  blocp = document.querySelectorAll("p") ;
  for( i = 0 ; i<blocp.length ;i++){
    var stylep = window.getComputedStyle(blocp[i])
    var valmarg = parseInt(stylep.paddingTop)+5
    blocp[i].style.padding = valmarg.toString()+'px'
  }


  }






/* fonction récupérant l'entier en tête de chaine */
const getNumber = function(x){
  return parseInt(x) ;
}



/* fonction surlignant le span.annote correspondant au div.comment en fonction de leurs numero */

const surligne = function(){
  let ann = document.getElementsByClassName("annote") ;
  for(let elmt of ann){
    if(getNumber(this.id) === getNumber(elmt.id)){
    mem = elmt.style.backgroundColor
    elmt.style.backgroundColor= "yellow"
    }

  }
}

/* ici on restaure le bacground color grace à la variable globale : mem */

const restaure = function(){
  let ann = document.getElementsByClassName("annote") ;
  for(let elmt of ann){
    if(getNumber(this.id) === getNumber(elmt.id)){
    elmt.style.backgroundColor= mem
    }
  }
}


/* fonction pour masquer les commentaires */
const masque = function(){

  boutton = document.getElementById('toggle')
  commentaires = document.getElementsByClassName('comment')

  for(var pas=0 ; pas < commentaires.length ; pas++ ){
      commentaires[pas].style.visibility='hidden'
    };
  boutton.textContent = "Afficher" ;
  boutton.removeEventListener('click' , masque);
  boutton.addEventListener('click', affiche) ;
}


/* fonction pour afficher  les commentaires */
const affiche =function(){
  boutton = document.getElementById('toggle');
  commentaires = document.getElementsByClassName('comment');


  for(var pas=0 ; pas < commentaires.length ; pas++ ){
    commentaires[pas].style.visibility='visible'
  };
  boutton.textContent = "Masquer";
  boutton.removeEventListener('click' , affiche);
  boutton.addEventListener('click', masque) ;
}
