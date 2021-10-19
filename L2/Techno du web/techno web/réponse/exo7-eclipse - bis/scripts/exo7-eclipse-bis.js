
var setup=function(){
  var moins=document.getElementById("moins");
  moins.addEventListener("click",pluspetit);
  
  var plus=document.getElementById("plus");
  plus.addEventListener("click",plusgrand);
  
  
 var img = document.getElementById("sun");           
 img.addEventListener('click',change);           
 
 img = document.getElementById("sunbis");           
 img.addEventListener('click',change);        

 img = document.getElementById("suntrois");           
 img.addEventListener('click',change);        
 
 
}

window.addEventListener("load",setup);

function change(event){   

	var image = event.target;       
    image.src = '../images/eclipse.jpg';  

    image.removeEventListener("click",change);
	image.addEventListener("click",changebis);   
}     

function changebis(event){           
	this.src = '../images/soleil.jpg';       	 
	this.removeEventListener("click",changebis);
	this.addEventListener("click",change);    
} 






var plusgrand=function(){
    var image=document.getElementById("sun");
	var proprietes = window.getComputedStyle(image);
	var taille=parseInt(proprietes.width);

	if (taille <= 680 ){
		image.style.width = (taille + 20)+"px";
	} 
}


var pluspetit=function(){
    var image=document.getElementById("sun");
      var proprietes = window.getComputedStyle(image)
      var taille=parseInt(proprietes.width);
      if (taille> 270){
		image.style.width=(-20+taille)+"px";
    }

}

/*
 var imgchange=function(){
  var img= document.getElementById("sun");
  var capt = img.alt;
  
  if (capt == "soleil" ){
    img.src="../images/eclipse.jpg";
    img.alt="eclipse";
  }
  else if (capt=="eclipse" ){
    img.src = "../images/soleil.jpg";
    img.alt = "soleil";
  }
}
*/