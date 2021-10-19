var setupListener = function(){
  document.getElementById('button').addEventListener('click' , imageSuivante) ;
  document.getElementById('buttonprec').addEventListener('click' , imagePrecedent) ;
  document.getElementById('play').addEventListener('click' , playdiapo) ;
  let timerdiapo
  majcompt()

}
window.addEventListener('DOMContentLoaded' ,setupListener)


var indiceImage = 0 ;

var afficheImage = function(){
  image = document.getElementById('diapo');
  image.src=tabImages[indiceImage];
  majcompt()
} ;




var majcompt = function(){
  var compteur = document.getElementById('compteur')
  compteur.textContent = String(indiceImage+1)+'/'+String(tabImages.length)
  var source = document.getElementById('source')
  var imageActu = document.getElementById('diapo')
  source.textContent = imageActu.src.substring(imageActu.src.lastIndexOf('/'))

}

var imageSuivante = function(){
  indiceImage = (indiceImage+1)%(tabImages.length) ;
  afficheImage();
} ;

var imagePrecedent = function(){
  indiceImage = (indiceImage-1)%(tabImages.length) ;
  if (indiceImage<0){ indiceImage =tabImages.length+indiceImage } ;
  afficheImage();
}


var playdiapo = function(){

  var duree = document.getElementById('temps')
  duree = parseInt(duree.value)
  if (isNaN(duree)){duree = 1}

  timerdiapo = window.setInterval(imageSuivante,duree*1000);
  var bout = document.getElementById('play');
  bout.removeEventListener('click' , playdiapo);
  bout.addEventListener('click', stopdiapo);
  bout.textContent = 'stop';
}



var stopdiapo =  function(){
   window.clearInterval(timerdiapo);
   var bout = document.getElementById('play');
   bout.removeEventListener('click' , stopdiapo);
   bout.addEventListener('click', playdiapo );
   bout.textContent = 'start';
  }
