package image;
import image.color.*;
import image.util.*;

/**
 * Class Main de Image 
 * 
 * 
 * @author Benjamin DOUCHET, Maxime COLLE
 * @version 1.0
 */


public class ImageMain {
    
    public static void main(String[] args){

       
        /**on vas créer d'abord le cadre de test */
        Image cadre = new Image(200,150);
        GrayColor noir = new GrayColor(0);
        GrayColor gris128 = new GrayColor(128);
        GrayColor gris200 = new GrayColor(200);
        cadre.fillRectangle(20,30,30,50,noir);
        cadre.fillRectangle(50,100,40,40,gris128);
        cadre.fillRectangle(90,20,70,50,gris200);
        
        ImageDisplayer displayer = new ImageDisplayer();
        
        displayer.display(cadre , "test rectangles" , 400 , 100 );
        /** on affiche les différents traitements de l'image */
        
        displayer.display(ImageLoader.loadPGM(args[0]), args[0], 400, 400);
        displayer.display(ImageLoader.loadPGM(args[0]).edges(Integer.parseInt(args[1])), args[0], 800, 400);
        displayer.display(ImageLoader.loadPGM(args[0]).decreaseNbGrayLevels(Integer.parseInt(args[2])), args[0], 1200, 400);
    }
}
