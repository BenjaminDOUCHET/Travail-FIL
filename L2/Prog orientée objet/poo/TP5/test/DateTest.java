import org.junit.*;
import static org.junit.Assert.*;
import date.Date;
import date.Month;

public class DateTest {

   
    @Test
    public void dateTomorrowIsOkWhenNormal(){
    Date d = new Date(19,Month.february,2020);
    Date next = d.dateTomorrow();
    assertEquals(new Date(20,Month.february,2020),next);
    } 

    @Test
    public void dateTomorrowWhenEndOfMonth(){
    Date d = new Date(31,Month.may,2020);
    Date next = d.dateTomorrow();
    assertEquals(new Date(1,Month.june,2020),next);
    }

    @Test
    public void dateTomorrowWhenEndOfYear(){
    Date d = new Date(31,Month.december,2020);
    Date next = d.dateTomorrow();
    assertEquals(new Date(1,Month.january,2021),next);
    }

    @Test
    public void dateTomorrowOfFebruaryWhenLeapYear(){
    Date d = new Date(29,Month.february,2020);
    Date next = d.dateTomorrow();
    assertEquals(new Date(1,Month.march,2020),next);
    }

    @Test
    public void dateTomorrowOfFebruaryWhenNotLeapYear(){
    Date d = new Date(28,Month.february,2021);
    Date next = d.dateTomorrow();
    assertEquals(new Date(1,Month.march,2021),next);
    }
    
    
    
    @Test
    public void isLeapYearIsOkWhenLeapYear(){
      assertTrue(Date.isLeapYear(2020));
    }

    @Test
    public void isLeapYearIsOkWhenNotLeapYear(){
      assertFalse(Date.isLeapYear(2021));
    }



    @Test
    public void afterNDaysIsOkWhenNPositive(){
    Date d = new Date(19,Month.february,2020);
    Date other = d.afterNDays(15);
    assertEquals(new Date(5,Month.march,2020),other);
    Date other2 = d.afterNDays(367);
    assertEquals(new Date(20,Month.february,2021),other2);
    }


    @Test (expected = IllegalArgumentException.class)
    public void afterNDaysThrowsExceptionWhenNNegative(){
    Date d = new Date(1,Month.may,2020);
    d.afterNDays(-1);
    }


    @Test
    public void compareIsOkWhenDateIsBeforeOther(){
      Date date = new Date(19,Month.february,2020);
      Date other = new Date(18,Month.january,2021);
      assertTrue(date.compare(other)<0);
    }

    @Test
    public void compareIsOkWhenDateIsAfterOther(){
      Date other = new Date(19,Month.february,2020);
      Date date = new Date(18,Month.january,2021);
      assertTrue(date.compare(other)>0);
    }

    @Test
    public void compareIsOkWhenDateIsSameAsOther(){
      Date other = new Date(19,Month.february,2020);
      Date date = new Date(19,Month.february,2020);
      assertTrue(date.compare(other)==0);
    }
    
    
    @Test
    public void equalsTest(){
    Date d =  new Date(18,Month.march,2021);
    Date other1 = new Date(18,Month.march,2021);
    assertTrue(d.equals(other1));
    Date other2 =new Date(19,Month.march,2021);
    assertFalse(d.equals(other2));
    }

    @Test
    public void gapInDaysWhenIsOk(){
    Date d = new Date(1,Month.march,2020);
    Date other = new Date(5,Month.march,2020);
    assertEquals(4,d.gapInDays(other));
    }

    

    @Test
    public void gapInDaysWhenTheFirstDateIsSmallerThanTheSeconDate(){
    Date d= new Date(18,Month.february,2020);
    Date other = new Date(14,Month.april,2021);
    assertEquals(421,d.gapInDays(other));
    }

    @Test
    public void gapInDaysWhenTheSecondDateIsSmallerThanTHeFirstOne(){
    Date d= new Date(18,Month.march,2021);
    Date other = new Date(29,Month.january,2021);
    assertEquals(48,d.gapInDays(other));
    }
    
   



    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(DateTest.class);
}


}