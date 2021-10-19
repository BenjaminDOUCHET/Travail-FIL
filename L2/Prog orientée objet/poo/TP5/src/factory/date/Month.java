/**
 * Months (enum) defines each month of a year with its number of days as attribute
 *
 * @author COLLE Maxime, DOUCHET Benjamin
 * @version 1.0
 */

package date;


public enum Month{

  january(31), february(28), march(31), april(30), may(31), june(30), july(31), august(31), september(30), october(31), november(30), december(31);

  /** the days in the month */
  private final int days;

  /**
   * Months (enum) defines each month of a year with its number of days as attribute
   * @param n
   */
  private Month(int n){
    this.days = n;
  }

  /**
   * returns the number of days in the month
   * @param y the year in which there is the month we want to know the number of days
   * @return the number of days in the month
   */
  public int nbDays(int y){
    if ((this==Month.february)&&(Date.isLeapYear(y))){
      return 29;
    }
    else{
      return this.days;
    }
  }

  /**
   * returns the next month
   * @return the month right after
   */
  public Month nextMonth(){
    return Month.values()[(this.ordinal()+1)%(Month.values().length)];
  }
}
