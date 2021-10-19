
/**
 * Décrivez votre classe Lightbulb ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Lightbulb{
    private boolean alim ;
    private String color ;
    
    public Lightbulb(boolean pow , boolean state , String color){
        this.alim=pow;
        this.color=color;
    }
    
    
    /** regarde si l'ampoule est aliementé 
       @ return si l'ampoule est ou non sous tension **/
    public boolean getPower(){
        return this.alim;
    }
    
    /** renvoie la couleur de l'ampoule 
       @renturn la couleur de l'ampoule **/
    public String getColor(){
        return this.color;
    }
    
    /** regarde si l'ampoule est alumée ou éteinte
       @return si l'ampoule est allumé ou non**/
    public boolean isOn(){
        return this.getPower();
    }
    
    /** passe l'état de l'ampoule à allumé**/
    public void on(){
        this.alim=true;
    }
    
    /** passe l'état de l'ampoule à Eteint **/
    public void off(){
        this.alim=false;
    }
    
    /** renvoie une string avec les donées sur l'ampoule **/
    public String toString(){
        String temp;
        if (this.isOn()){
            temp="allumée";
        }
        else{
            temp = "éteinte";
        }
        return "cette ampoule de couleur"+this.getColor()+" est "+temp;
         
    }
    
    
    
}
