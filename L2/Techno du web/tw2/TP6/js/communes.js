
window.addEventListener('load',initForm);
function initForm(){
  fetchFromJson('services/getTerritoires.php')
  .then(processAnswer)
  .then(makeOptions);
  
  document.forms.form_communes.addEventListener("submit", sendForm);

 

  // décommenter pour le recentrage de la carte :
  document.forms.form_communes.territoire.addEventListener("change",function(){
  centerMapElt(this[this.selectedIndex]);
  });

  
}

function processAnswer(answer){
  if (answer.status == "ok")
    return answer.result;
  else
    throw new Error(answer.message);
}


function makeOptions(tab){
  for (let territoire of tab){  
    let option = document.createElement('option');
    option.textContent = territoire.nom;
    option.value = territoire.id;
    document.forms.form_communes.territoire.appendChild(option);
    for (let k of ['min_lat','min_lon','max_lat','max_lon']){
      option.dataset[k] = territoire[k];
    }
  }
}


function sendForm(ev){ // form event listener
  ev.preventDefault();
  let formData = new FormData(this);
  fetch('./services/getCommune.php',{method: 'post', body : formData})
  .then(function(resp){
    return resp.json()
  })
  .then(makeCommunesItems);
  
  
}


function makeCommunesItems(tab){
  
  const listCom = document.getElementById('liste_communes');
  while(listCom.firstChild){
    listCom.removeChild(listCom.lastChild);
  }
  
  
  for(var i =0 ; i<tab.result.length ;i++ ){
    let li = document.createElement('Li');
    li.textContent = tab['result'][i].nom;
    li.id = tab['result'][i].insee;
    
    for (let k of ['min_lat','min_lon','max_lat','max_lon']){
      li.dataset[k] = tab['result'][i][k];
    }
    let currentLi = listCom.appendChild(li);
    currentLi.addEventListener("click", function(){fetchCommune(this.id)});
    currentLi.addEventListener("mouseover",function(){centerMapElt(this)});
  }
}


function fetchCommune(ev){
  let url = "./services/getDetails.php?insee="+ev;
  fetch(url).then(function(resp){
    return resp.json()})
    .then(displayCommune);
    
}



function displayCommune(commune){
  const detail = document.getElementById("details");

  //on vide le resultat précédent
  while(detail.firstChild){
    detail.removeChild(detail.lastChild);
  }

  //  on créer la table <table> et le <tbody> 
  var tbl = document.createElement("table");
  var tblBody = document.createElement("tbody");
  
  // on créer le thead
  var thead = document.createElement("thead");
  var hrow = document.createElement("tr");
  for(let k of ['insee','nom','nom_terr','suface','perimetre','pop2016','lat','lon']){
    var hcell = document.createElement("td");
    var hcellText = document.createTextNode(k);
    hcell.appendChild(hcellText);
    hrow.appendChild(hcell);
  }
  thead.appendChild(hrow);


  // on céer les cellules du tbody
  for (var i = 0; i <1; i++) {
    // on créer les table row
    var row = document.createElement("tr");
  
    for(let k of ['insee','nom','nom_terr','surface','perimetre','pop2016','lat','lon']) {
    // on créer le td et son contenu puis on concatène à la fin du tr en cours
   
        var cell = document.createElement("td");
        var cellText = document.createTextNode(commune['result'][k]);
        cell.appendChild(cellText);
        row.appendChild(cell);
      }
  
      //on mets la ligne dans le tbody
      tblBody.appendChild(row);
    }
    

    //on mets le thead dans la table
    tbl.appendChild(thead);
    // on mets le  <tbody> dans la <table>
    tbl.appendChild(tblBody);
    // on mets la <table> dans le <div>
    detail.appendChild(tbl);
    // sets the border attribute of tbl to 2;
    tbl.setAttribute("border", "2");
  
    createDetailMap(commune['result']);

}





/**
 * Recentre la carte principale autour d'une zone rectangulaire
 * elt doit comporter les attributs dataset.min_lat, dataset.min_lon, dataset.max_lat, dataset.max_lon, 
 */
function centerMapElt(elt){
  let ds = elt.dataset;
  map.fitBounds([[ds.min_lat,ds.min_lon],[ds.max_lat,ds.max_lon]]);
}
