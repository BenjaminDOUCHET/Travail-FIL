/* farencel fontion convertissant une temperature en farenheit en température en cdegrès celsius
: param x in ou float : la température à convetir
: return in ou float : la temperature convertie
*/

var farencel = function (x){
  return (((x-32)*5)/9) }


/* celenfar fontion convertissant une temperature en degrès celsius en température en farenheit
: param x in ou float : la température à convetir
: return in ou float : la temperature convertie
*/

var celenfar = function (x) {
  return ((x*9)/5)+32 }

farencel(98.6)