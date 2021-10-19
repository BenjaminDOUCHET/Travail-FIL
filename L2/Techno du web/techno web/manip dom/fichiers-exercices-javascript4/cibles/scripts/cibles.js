// cibles.js
const TARGET_WIDTH = 40;
const TARGET_HEIGHT = 40;

/* return a random number x : 0 <= x < upperBound */
const alea = function(upperBound) {
    return Math.floor(Math.random() * upperBound);
}

const setupListeners = function() {
        let start = document.getElementById('start');
        start.addEventListener('click', createAllTargets );
}

window.addEventListener( 'DOMContentLoaded', setupListeners );

// createOneTarget
var createOneTarget = function(){
  target = document.createElement('div') ;
  target.className = "target"
 var terrain = document.getElementById('field')

    const proprietes = window.getComputedStyle(terrain);

  target.style.top = alea( parseInt(proprietes.height) - TARGET_HEIGHT ) + 'px'
  target.style.left = alea(parseInt(proprietes.width) - TARGET_WIDTH ) + 'px'

  field.appendChild(target)

}

ciblerest = document.querySelectorAll('div.target')
if (ciblerest.length != 0){
  document.getElementById('start').addEventListener('click' , )

}

var destroyTarget = function(){
  this.parentNode.removeChild(this)
  cibleres = document.getElementById('remaining')

}
