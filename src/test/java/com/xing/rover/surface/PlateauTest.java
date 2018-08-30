/**
 * 
 */
package com.xing.rover.surface;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Geeta
 *
 */
public class PlateauTest {

    @Test
    public void testPlateauStringWithGivenTop() {
        Plateau plateau = new Plateau();
        plateau.setTopRight(new Point(5, 5));
        Assert.assertEquals("0 0::5 5", plateau.toString());
    }

    @Test
    public void testPlateauStringWithoutGivenTop() {
        Plateau plateau = new Plateau();
        Assert.assertEquals("0 0::0 0", plateau.toString());
    }
}
