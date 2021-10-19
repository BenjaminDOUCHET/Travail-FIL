
var setupListener=function() {
  document.getElementById("plus").addEventListener('click' , incre) ;
  document.getElementById("moins").addEventListener('click' , decre) ;
  document.getElementById("sun").addEventListener('click' , change) ;
}



/*test*/

var test = function(){
  alert('ok')
}

/*augmentation de la taille */
var incre = function(){
  var img = document.getElementById('sun')
  var prop = getComputedStyle(img)
 	var taille = parseInt(prop.width)
  if (taille <= 480 ){
  img.style.width = (taille + 20)+"px"
  }

  }

/* diminution de la taille*/
var decre = function(){

  var img = document.getElementById('sun')
  var prop = getComputedStyle(img)
 	var taille = parseInt(prop.width)

  if (taille >= 270 ){
  img.style.width = (taille - 20)+"px"
  }

  }

/*focntion de changement de l'image*/

var change = function(){
  var img= document.getElementById("sun")
  var capt = img.alt

  if (capt == "soleil" ){
    img.src="../images/eclipse.jpg"
    img.alt="eclipse"
  }
  if (capt=="eclipse" ){
    img.src = "../images/soleil.jpg"
    img.alt = "soleil"
  }
}



window.addEventListener('load' ,setupListener)




vous voulez qu'on prépare un exercice pour la semaine prochaine ?
