package com.cmrhyq.date;

import org.junit.Test;

import static com.cmrhyq.date.DateCalculation.calculationBirthday;

/**
 * <h1 style="color:white"></h1>
 *
 * @author Alan Huang
 * @version v0.0.1
 * @project UtilsPackage
 * @docRoot com.cmrhyq.date
 * @date 2023-02-16 20:07
 * @email cmrhyq@163.com
 * @since v0.0.1
 */
public class DateCalculationTest {

    @Test
    public void isSpecialChar(){
        calculationBirthday("1998-09-01");
    }
}
