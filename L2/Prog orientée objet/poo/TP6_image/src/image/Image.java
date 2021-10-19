package image;

import image.util.*;
import image.color.*;
/**
 * une image se definie par sa hauteur et sa largeur
 * par un tableau à deux dimensions
 * 
 * @author Benjamin DOUCHET
 * @version 1.0
 */



public class Image implements ImageInterface{

    /**
     * attribut de la classe Image , représentée par un tableau à deux dimensions
     */
    private Pixel[][] pixels;


    /**
     * constructeur de la classe Image remplie par défaut de pixels Pixel 
     * de couleur GrayColor blanc
     * @param width int la largeur de l'image
     * @param height int la hauteur de l'image 
     */
    public Image(int width, int height){
        if(width <=0 || height <=0){
           System.out.println("Warning ! u have created an empty img !");
        }
        else{
            this.pixels = new Pixel[width][height];
            for(int i=0 ; i<this.pixels.length ; i++){
                for(int j=0 ; j<this.pixels[i].length ; j++){
                    GrayColor valueColor = new GrayColor(255);
                    Pixel value = new Pixel(valueColor);
                    this.pixels[i][j]= value;
                }
            }
        }
    }
    
    /**
     * Getter de la largeur de l'image
     * @return int la largeur de l'image
     */
    public int getWidth(){
        return this.pixels.length;
    }

    /**
     * getter de la hauteur de l'image
     * @return int la hauteur de l'image
     */
    public int getHeight(){
        return this.pixels[0].length;
    }
    
    /**
     * getter d'un pixel de l'image à l'emplacement x , y
     * @param x int la coordonnée en abscisse du pixel recherché
     * @param y int la coordonée en ordonée du pixel recherché 
     * @return Pixel le pixel recherché
     * @exception UnknownPixelException si les coordonnée son hors de l'image
     */
    public Pixel getPixel(int x , int y) throws UnknownPixelException {
        Pixel res;
        try{
        res =  this.pixels[x][y];
        }
        catch(java.lang.IndexOutOfBoundsException e){
            throw new UnknownPixelException("le pixel que vous recherchez n'est pas contenu dans l'image");
        }
        res =  this.pixels[x][y];
        return res;
    }


    /**
     * méthode de changement de couleur d'un pixel de l'image
     *  @param x int la coordonnée en abscisse du pixel à modifier
     *  @param y int la coordonée en ordonée du pixel à modifier
     *  @param color GrayColor la couleur voulu pour le pixel
     *  @exception UnknownPixelException si les coordonnée son hors de l'image
     */
    public void changeColorPixel (int x , int y , GrayColor color)throws UnknownPixelException{
        try{
        Pixel newPixel = new Pixel(color);
        this.getPixel(x,y).setColor(color);
        }
        catch( java.lang.ArrayIndexOutOfBoundsException e){
            throw new UnknownPixelException("le pixel que vous recherchez n'est pas contenu dans l'image");
        }
        Pixel newPixel = new Pixel(color);
        this.pixels[x][y].setColor(color);
    }
    

    /**
     * methode créant un rectangle et le remplissant de la couleur en param.
     * @param x int la coordonnée en abscisse de départ
     * @param y int la coordonée en ordonée de départ
     * @param width la largeur du rectangle
     * @param height la hauteur du rectangle
     * @param color GrayColor la couleur de renmplissage du rectangle
     * @exception UnknownPixelException si le rectangle ne peut pas être contenu dans l'image
     */

    public void fillRectangle(int x , int y , int width , int height , GrayColor color)throws UnknownPixelException{
        try{
            Pixel rectPixel = new Pixel(color);
            for(int i=x ; i<=(x+width) ; i++){
                for(int j=y ; j<=(y+height);j++){
                    this.pixels[i][j]= rectPixel;
                }
            }
        }
        catch(java.lang.ArrayIndexOutOfBoundsException e){
            throw new UnknownPixelException("le rectangle que vous dessinez dépasse de l'image");
            
        }
          
    }


    /**
     * methode permettant d'extraire les contours de l'image
     * @param threshold int le seuil d'extraction
     * @return Image l'image avec des contours extraits
     */
    public Image edges(int threshold){
        Image result = new Image(this.getWidth(),this.getHeight());
        GrayColor noir = new GrayColor(0);
        Pixel pixelNoir = new Pixel(noir);
        for(int i=0;i<this.pixels.length-1;i++){
            for(int j =0 ; j<this.pixels[i].length-1;j++)
                if(this.getPixel(i,j).colorLevelDifference(this.getPixel(i+1,j))>=threshold ||
                this.getPixel(i,j).colorLevelDifference(this.getPixel(i,j+1))>=threshold){
                    result.pixels[i][j]=pixelNoir;
                }
        }
        return result;
    }


    /**
     * methode permetant de décroitre la palette de nuances de gris
     * @param nbGrayLevels int une puissance de 2 comprise entre [2,128]
     * @return Image la nouvelle image décomposée suivant le nouvel echelonnage.
     */
    public Image decreaseNbGrayLevels(int nbGrayLevels){
        int sousInter = 256/nbGrayLevels;
        Image result = new Image(this.getWidth(),this.getHeight());
        GrayColor temp;
        Pixel pixelTemp;
        for(int i=0;i<this.pixels.length;i++){
            for(int j =0 ; j<this.pixels[i].length;j++){
                temp = new GrayColor((this.pixels[i][j].getColor().getGrayLevel()/sousInter)*sousInter);
                pixelTemp = new Pixel(temp);
                result.pixels[i][j]=pixelTemp;
                }
        }
        return result;
    }

    /**
     * methode d'évaluation de l'équivalence de deux images
     * @param o Object l'objet à comparer
     * @return Boolean true si les images sont identiques , false sinon 
     */
    public boolean equals(Object o){
        boolean res = true ;
        if(o instanceof Image){
            Image other = (Image) o;
            if(this.getWidth()!=other.getWidth() || this.getHeight()!= other.getHeight()){
                return false;
            }
            for(int i=0;i<this.pixels.length;i++){
                for(int j =0 ; j<this.pixels[i].length;j++){
                    if(this.getPixel(i,j).getColor().getGrayLevel() != other.getPixel(i,j).getColor().getGrayLevel()){
                        res = false;
                    }
                }
            }
        }
        else{
            res = false;
        }
        return res;
    }

}

