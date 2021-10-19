


const setupListener=function() {
  document.getElementById('poke').addEventListener('click' , incre)
  
}



const incre = function(){
  const compteur= document.getElementById('compteur');
  var compt = parseInt(compteur.textContent);
  compt = compt + 1;
  compteur.textContent = compt;
  if ( compt == 5){
    document.getElementById('poke').removeEventListener('click' , incre)
  }
}

window.addEventListener('load' , setupListener)