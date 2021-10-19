
/**
 * Date  defines a date with day, month and year
 *
 * @author Haman COLLE Maxime, DOUCHET Benjamin
 */

package date;

public class Date{

     /** A day is defined by its day, month and year
     * @param d this date day
     * @param m this date month
     * @param y this date year
     */
    public Date(int d, Month m, int y){
    this.d=d;
    this.m=m;
    this.y=y;
    }

    /** this date's day */
    private int d;
    /** this date's month */
    private Month m;
    /** this date's year */
    private int y;

    /** returns this date's day
    *@return this date's day
    */
    public int getDay(){
        return this.d;
    }

    /** returns this date's month
    *@return returns this date's month
    */
    public Month getMonth(){
        return this.m;
    }

    /** returns this date's year
    *@return returns this date's year
    */
    public int getYear(){
        return this.y;
    }

    /** returns tomorrow's date
     * @return tomorrow's date
     */
    public Date dateTomorrow(){
        int NextDay;
        Month NextMonth;
        int NextYear;
        if(this.d +1> this.m.nbDays(this.y)){
            NextDay=1;
            if(this.m==Month.december){
                NextYear=this.y+1;
            }else{
                NextYear=this.y;
            }
            NextMonth=this.m.nextMonth();
        }else{
            NextDay= this.d +1;
            NextYear=this.y;
            NextMonth=this.m;
        }
        return new Date(NextDay,NextMonth,NextYear);
    }

    /**returns true if this date's year is leap, else false
     * @return returns true if this date's year is leap, else false
     * @param y this date's year
     */
    public static boolean isLeapYear(int y){
        return ((y % 4 == 0) && (y % 100 != 0) || (y % 400 == 0));

    }

    /**
    *return the date of the day after n days
    *@return the date of the day after n days
    *@param n a positive number of days
    */
    public Date afterNDays(int n) throws IllegalArgumentException {
        if(n<0){
            throw new IllegalArgumentException("n has to be a positive integer");
        }
        Date j= new Date(this.d,this.m,this.y);
        for(int i=0;i<n;i++){
            j=j.dateTomorrow();
        }
        return j;
    }

    /** returns the later date if the two dates are different, else 0
    *@return the later date  if the two dates are different, else 0
    *@param OtherDay an other day
    */
    public int compare(Date OtherDay){
        if(this.y>OtherDay.getYear()){
            return 1;
        }else if(this.y<OtherDay.getYear()){
            return -1;
        }
        else{
            if(this.m.ordinal()>OtherDay.m.ordinal()){
                return 1;
            }else if(this.m.ordinal()<OtherDay.m.ordinal()){
                return -1;
            }
            else{
                if(this.d<OtherDay.getDay()){
                    return -1;
                }else if(this.d>OtherDay.getDay()){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }
    }

    /** returns true if the two dates are equals ,false else
    *@return true if the two dates are equals ,false else
    *@param OtherDay an other day
    */
    public boolean equals(Object OtherDay){
        if(OtherDay instanceof Date){
            Date d=(Date)OtherDay;
            int a = this.compare(d);
            if(a==0){
                return true;
            }
            return false;
        }
        else {
          return false;
        }
    }

    /** returns the number of days between two dates
     * @param date the date we want to know the difference with the first date (this)
     * @return the number of days between two dates
     */
    public int gapInDays(Date date){
       if (this.compare(date) == 0){
         return 0;
       }
       else{
         int gap = 0;
         if (this.compare(date) < 0){
           Date currentDay = this;
           while (!(currentDay.equals(date))){
             gap++;
             currentDay = currentDay.dateTomorrow();
           }
         }
         else{
           Date currentDay = date;
           while (!(currentDay.equals(this))){
             gap++;
             currentDay = currentDay.dateTomorrow();
         }
       }
       return gap;
     }
   }

    /** Show the date with a string
     * @return an sentens like : 'The date is the <day> of <mounth> of the year <year>'
     */
    public String toString(){
        return "The date is the "+this.d+" of "+this.m.name()+" of the year "+this.y;
    }
}
