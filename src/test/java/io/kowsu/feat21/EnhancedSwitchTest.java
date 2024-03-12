package io.kowsu.feat21;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
    @created February/28/2024 - 11:35 AM
    @project spring-boot-web
    @author k.ramanjineyulu
*/
 class EnhancedSwitchTest {

     int calculateTime(DayOfWeek dayOfWeek) {
         return switch (dayOfWeek) {
             case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> 16;
             case SATURDAY, SUNDAY -> 24;
         };
     }


     @Test
     void calculateTest() {
         int timeOff = calculateTime(DayOfWeek.MONDAY);
         int timeOff1 = calculateTime(DayOfWeek.SATURDAY);
         assertEquals(16, timeOff);
         assertEquals(24, timeOff1);
     }
    
}
