

var setupListener = function(){
  let mem;
  var images = document.getElementsByTagName('img');
  for(let elements of images){
    elements.addEventListener('mouseover',change);
    elements.addEventListener('mouseout' , restaure)};
}

window.addEventListener('DOMContentLoaded' , setupListener);

var change = function(){
  mem = this.src;
  this.src="images/intrus.jpg";

}


var restaure = function(){
  this.src = mem;
}
