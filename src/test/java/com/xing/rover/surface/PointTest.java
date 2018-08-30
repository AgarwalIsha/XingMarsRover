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
public class PointTest {

    @Test
    public void testPointString() {
        Point point = new Point(2, 3);
        Assert.assertEquals("2 3", point.toString());
    }
}