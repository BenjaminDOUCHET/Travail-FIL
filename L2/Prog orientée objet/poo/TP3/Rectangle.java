/** Douchet Benjamin
    Colle Maxime **/

/** classe Rectangle pour representer la forme
**/

public class Rectangle{

  private double lon=0;
  private double len=0;

  public Rectangle(double longu,double leng){
    this.len = leng ;
    this.lon = longu ;
  }
  /** séries des getter et setter **/

  public double getLen(){
    return this.len;
  }
  public void setLen(double x){
    this.len=x;
  }
  public double getLon(){
    return this.lon;
  }
  public void setLon(double x){
    return this.lon=x;
  }

/** calcule l'aire du Rectangle **/
  public double aire(){
    return this.len*this.lon;
  }
/** calcule le périmètre du rectangle **/
  public double peri(){
    return 2*this.len+2*this.lon;
  }
/** prédicat vérifant si le rectangle est carré **/
  public boolean estCarre(){
    return this.len==this.lon;
  }
/** methode vérifant l'égalité de deux instance de la classe Rectangle**/
  public boolean equals(Object o){
    if(!(o instanceof Rectangle)){
      return False;
    }
    else{
      Rectange other = (Rectange) o ;
      return this.len==other.getLen() && this.lon==other.getLon() || this.len==other.getLon() && this.lon==other.getLen() ;
    }
  }

}
