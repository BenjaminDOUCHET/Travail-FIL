

var setuplistener =  function(){
	
var cel = document.getElementById('celsius')
var far = document.getElementById("fahrenheit")
var ctf = document.getElementById("cToF")
var ftc = document.getElementById("fToC")
ctf.addEventListener("change" , enf ) 
ctf.addEventListener("click" , enf ) }



window.addEventListener('load' , setuplistener)



var celenfar = function (x) {
	if ( isNaN(x)){return 0}
	else {return (x*9)/5+32 }}

var enf = function() {
	var cel = document.getElementById('celsius')
	var far = document.getElementById("fahrenheit")
	 {far.value = celenfar(cel.value)}
}


