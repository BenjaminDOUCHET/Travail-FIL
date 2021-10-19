package image;

import image.util.*;
import image.color.*;

public class ImageExampleMain {

   private static final String LAMP_IMAGE = "/images/lamp.pgm";
   private static final String CAT_IMAGE = "/images/chat.pgm";

   public static void main(String[] args) {

      // utilisation de ImageLoader pour créer des objets Image à partir d'un fichier au format PGM
      Image lampImg = ImageLoader.loadPGM(LAMP_IMAGE);
      Image catImg = ImageLoader.loadPGM(CAT_IMAGE);

      // création d'un objet qui permet d'afficher les images
      ImageDisplayer displayer = new ImageDisplayer();
      // affichages des deux images
      displayer.display(lampImg, "Lamp", 100, 100);
      displayer.display(catImg, "Chat", 450, 100);

   }

}
