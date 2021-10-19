package date;
import date.Date;
import date.Month;
/**
 * DateMain  executes some munipilations of the class Date 
 *
 * @author COLLE Maxime, DOUCHET Benjamin
 */

public class DateMain{

    /**
   * Show some manipulation of Date.java and Mounth.java
   * 1 : Manipulation of getDay(), getYear(), getMonth(), and toString().
   * 2 : Manipulation of dateTomorrow()
   * 3 : Manipulation of isLeapYear()
   * 4 : Manipulation of afterNDays()
   * 5 : Manipulation of compare()
   * 6 : Manipulation of equals()
   * 7 : Manipulation of gapInDays()
   */
    public static void main(String[] args){
        Date d = new Date(12,Month.march,2020);
       
        String a; 
        a=d.toString();
        System.out.println("The date choosen is : "+a);
       
        Date other1 = d.dateTomorrow();
        System.out.println("The second date which is the next date  is "+other1);
        
        if(d.isLeapYear(d.getYear())){
             System.out.println("This date's year "+d.getYear()+" is a leap year");
        }
        else{
            System.out.println("This date's year "+d.getYear()+" is not a leap year");
        }

        System.out.println("After 12 days the date will be : "+d.afterNDays(12));
        

        if(d.compare(other1)==1){
            System.out.println(" The First date is more later than the first one ");
        }else if(d.compare(other1)==-1){
            System.out.println("The Second date is more later than the first one");
        }else{
            System.out.println("The two dates are the same ");
        }

        if(d.equals(other1)){
            System.out.println("The date : "+d+" and "+other1+" are equals");
        }
        else{
            System.out.println("The date : "+d+" and "+other1+" are not equals");
        }

        System.out.println("The numbers of days between "+d+" and "+other1+" is "+d.gapInDays(other1)+" day");

        
        




    }
}