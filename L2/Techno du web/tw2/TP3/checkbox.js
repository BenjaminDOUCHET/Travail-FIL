var setupListeners = function(){
    var formBg = document.getElementById('checkbox');
   
    formBg.addEventListener('change', switchBg);
    
  }


window.addEventListener('DOMContentLoaded',setupListeners)


var switchBg =function(){
    var bg = document.getElementById('bg');
    bg.disabled = !bg.disabled;
   
}





