
/**
 * Décrivez votre classe Stock ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Stock
{
    private int quantity;
    
    public int getQuantity(){
        return this.quantity;
    }
    
    /** constructeur de la class Stock **/
    public Stock(){
        this.quantity = 0;
    }
    
    public void add(int x){
        this.quantity = this.quantity+x;
    }
    
    public int remove(int x){
        int temp;
        if(this.quantity>x){
            this.quantity = this.quantity-x;
            return x;
        }
        else {
            temp= this.quantity;
            this.quantity =0;
            return x-temp;
        }
    }
    
    public String toString(){
        return "the stock's quantity is"+ Integer.toString(this.quantity);
    }
    
    public Stock(int x){
        this.quantity=x;
    }
    
    
    
    

    
}
