package trie ;

import java.util.HashMap;
/**
 * Trie Class models tree or sub-tree of a word
 * it have for attribute :
 * 
 * fils a HashMap with String as key and Trie as Value 
 * fin a boolean to signify if we are currently on an end of a word
 */
public class Trie {

   private HashMap<String,Trie> fils ;
   private int num_noeud;
   private boolean fin;
   static int compt;
   
   /**
    * at the initiation the trie is empty
    */
   public Trie () {
     this.fils = new HashMap<String,Trie>();
     this.fin = false;
     this.num_noeud = 0;
     this.compt = 0;
   }

   public HashMap<String, Trie> getFils() {
       return fils;
   }

   public int getNum(){
      return this.num_noeud;
   }

   public void incNum(){
      this.compt+=1;
      //System.out.println("j'étais à :"+ this.getNum()+" jai incrémenté");
   }


   public void setNum(int i){
      this.num_noeud = i;
   }
   /**
    * add a String recursivly to the trie
    * @param word the word to add
    */
   public void add (String word) {
      Trie pointeur ;

      if(word.length() != 0){
      String lettre = Character.toString(word.charAt(0));
      String ssChaine = word.substring(1);
      pointeur = this.fils.get(lettre);
      if(pointeur == null){
         pointeur = new Trie();
         this.fils.put(lettre,pointeur);

      }
      pointeur.add(ssChaine);
      if(ssChaine.length()==0){
         this.fin = true;
      }
      
      }
      
      }
   
   
   /**
    * method to check if the param word is contained in the trie
    * @param word String the word to check
    * @return boleean true if word is in the trie , false if not
    */

   public boolean contains (String word) {
      //boolean res = true ;

      if(word.length()>0){

      String lettre = Character.toString(word.charAt(0));
      if(this.fils.containsKey(lettre)){
         String ssChaine = word.substring(1);
         return this.fils.get(lettre).contains(ssChaine);

      }
      else{
         return false;
      }
      }
      else{
         return /*res &&*/ this.fin;
      }
   }

   public int getCompt(){
      return this.compt;
   }


   private void auxPrint(Trie current){
      
      String color ="pink" ;

      if(this.fin){
         color = "blue";
      }

      if(this.getFils().keySet().isEmpty()){
         return;
      }

      else{
         for(String elt : this.getFils().keySet()){
            current.incNum();
            this.getFils().get(elt).setNum(current.getCompt());
            System.out.println(Integer.toString(this.getFils().get(elt).getNum())+" [style=filled,color="+color+"]");
            System.out.println(Integer.toString(this.getNum())+" -> "+Integer.toString(this.getFils().get(elt).getNum())+" [label=\" "+elt+"\"];");
            this.getFils().get(elt).auxPrint(this.getFils().get(elt));
          
         }

      }
   }   



   public void print(){
      System.out.println("digraph G {");
      this.auxPrint(this);
      System.out.println("}");
   
   }
}
