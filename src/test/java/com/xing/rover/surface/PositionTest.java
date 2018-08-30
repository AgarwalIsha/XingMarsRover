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
public class PositionTest {

    @Test
    public void testPositionStringWithGivenPoint() {
        Point point = new Point(2, 3);
        Direction direction = Direction.N;
        Position position = new Position();
        position.setCoordinates(point);
        position.setDirection(direction);
        Assert.assertEquals("2 3 N", position.toString());
    }

    @Test
    public void testPositionStringWithoutPoint() {
        Direction direction = Direction.N;
        Position position = new Position();
        position.setDirection(direction);
        Assert.assertEquals("0 0 N", position.toString());
    }

    @Test
    public void testPositionStringWithoutDirection() {
        Point point = new Point(2, 3);
        Position position = new Position();
        position.setCoordinates(point);
        Assert.assertEquals("2 3 E", position.toString());
    }
}
