/* fonctions pour l'exercice sur la table périodique */


const setupListener = function(){
  const elements = document.getElementsByClassName('elementChimique');

  for(let elt of elements){
    elt.addEventListener('mouseover' , fairefocus);

  }
  document.getElementById('focus').innerHTML = elements[1].innerHTML
  document.getElementById('focus').className = elements[1].className


  token = 1;
  document.getElementById('checkFocus').addEventListener('change' , toggle);
  document.getElementById("checkMasse").addEventListener('change' , toggleMA)





}

window.addEventListener('DOMContentLoaded' , setupListener);

const toggleELT = function(){
  var massatom = document.querySelectorAll('div.ligne div.masseatomique')
  for(let elmt of massatom){

      if( !this.checked){
        massatom[pas].style.visibility = 'hidden' ;

      } else {
        massatom[pas].style.visibility = 'visible' ;

    }
}
}





const toggleMA = function(){
  var massatom = document.querySelectorAll('div.masseatomique')
  for(pas=1 ; pas< massatom.length ; pas++){

      if( !this.checked){
        massatom[pas].style.visibility = 'hidden' ;

      } else {
        massatom[pas].style.visibility = 'visible' ;
      }
}
}


































const fairefocus = function(){
  var trans = this.innerHTML;

  var cadre = document.getElementById('focus');

  cadre.innerHTML = trans;
  cadre.className  = this.className;

}

const clean = function(){
  var cadre = document.getElementById('focus')
  cadre.innerHTML = ""
  cadre.className = "elementChimique"
}




const toggle = function(){
  var focus = document.getElementById('focus')

  if( !this.checked){
    focus.style.visibility = 'hidden' ;

  } else {
    focus.style.visibility = 'visible' ;

  }
}
