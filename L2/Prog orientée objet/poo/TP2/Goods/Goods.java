
/**
 * Décrivez votre classe Goods ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Goods
{
   private double value;
   private String name;
   /** contructeur intialisant value à 0 et name par la variable**/
   public Goods(String nom){
    this.value =0;
    this.name = nom;
    }
   
   /** contructeur intialisant value par valeur et name par la variable nom**/
   public Goods(String nom,double valeur){
    this.value=valeur;
    this.name=nom;
    }
   
   /** methode getter de value **/
   
   public double getValue(){
       return this.value;
    }
   
   /** methode setter de value **/
   
   public void setValue(double x){
    this.value  = x;
    }
   
   /** getter de name **/
   public String getName(){
    return this.name;
    }
    
   /** renvoie  l'état du goods sous forme de String**/ 
   public String toString(){
       return "The goods "+ this.name +" costs " + String.valueOf(this.value);
    }
   /** calcule le prix avec une Tva à 20%**/
   public double avecTva(){
       return this.value+this.value*0.2;
    }




}
