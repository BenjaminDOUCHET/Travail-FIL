package image.color;

/**
 * une GrayColor definie une nuance de gris
 * @author Benjamin DOUCHET, Maxime COLLE
 * @version 1.0
 */

public class GrayColor{
    
    private int grayLevel;
    private double alpha;


    /** Constructeur de la classe GrayColor
     * @param level int le niveau de gris de la couleur compris entre 0 et 255 inclus
     * si level dépasse des brones il sera ramené à la borne la plus proche
     */
    public GrayColor(int level){
       
        this.grayLevel = level;
       
        this.alpha=1;

    }


    /**
     * getter de la classe GrayLevel sur le param grayLevel
     * @return int le niveau de gris de la couleur
     */

    public int getGrayLevel(){
        return this.grayLevel;
    }

    /**
     * getter de la classe GrayLevel sur le param alpha
     * @return double le niveau d'opacité de la couleur
     */
    public double getAlpha(){
        return this.alpha;
    }

    /**
     * setter du param alpha de la couleur régissant son opactité
     * @param alph double compris entre 0(transparence complète) et 1(opacité complète)
     * si la valeur dépasse des bornes elle sera ramenée à la borne la plus proche
     */
    public void setAlpha(double alph){
        if(alph > 1){
            alph=1;
        }
        if(alph <0){
            alph=0;
        }
        this.alpha = alph;
    }

    /**
     * methode d'évaluation de l'égalité de deux GrayColor
     * @param o object l'objet à comparer
     * @return boolean true si les objets sont équivalents false sinon
     */
    public boolean equals(Object o){
        if(o instanceof GrayColor){
            GrayColor other = (GrayColor) o ;
            return this.getGrayLevel() == other.getGrayLevel() && this.getAlpha() == other.getAlpha();
        }
        else{
            return false;
        }
    }

} 