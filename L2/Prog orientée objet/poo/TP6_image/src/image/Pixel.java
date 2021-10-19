package image;

import image.color.*;

/**
 * un pixel defini une portion d'écran
 * 
 * @author Benjamin DOUCHET, Maxime COLLE
 * @version 1.0
 */

public class Pixel {

    private image.color.GrayColor color;

    /**
     * Constructeur de la classe Pixel
     * @param color Graycolor la couleur du pixel a sa création
     */
    public Pixel(image.color.GrayColor color){
        this.color=color;
    }

    /**
     * getter de l'attibut color de Pixel
     * @return GrayColor la valeur de l'attribut
     */
    public GrayColor getColor(){
        return this.color;
    }

    /**
     * setter de l'attribut color de la classe Pixel
     * @param newcolor GrayColor la nouvelle couleur du pixel
     */
    public void setColor(image.color.GrayColor newcolor){
        this.color=newcolor;
    }

    /**
     * methode permettant de calsuler la difference de couleur entre deux pixels
     * @param other Pixel le pixel à comparer 
     * @return int le niveau de gris de difference entre les deux pixels
     */
    public int colorLevelDifference(Pixel other){
        return Math.abs(this.getColor().getGrayLevel()-other.getColor().getGrayLevel());
    }

    /**
     * méthode d'évalutation d'équivalence de pixels
     * @param o Object l'objet à évaluer
     * @return boolean true si les deux pixels sont équivalents false sinon 
     */

    public boolean equals(Object o){
        if(o instanceof Pixel){
            Pixel other = (Pixel) o;
            return this.getColor().equals(other.getColor());
        }
        else{
            return false;
        }
    }



}