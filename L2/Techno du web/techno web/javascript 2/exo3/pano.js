window.addEventListener("load",setupListeners)

var restPano =function(){
  pano.src="images/panoramique.jpg"
}

var changePano =function(){
  pano.src="images/panoramique2.jpg"
}


var setupListeners = function(){
  var pano = document.getElementById('panoramique')
  pano.addEventListener('mouseover', changePano)
  pano.addEventListener('mouseout',restPano)
}
