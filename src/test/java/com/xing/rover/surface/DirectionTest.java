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
public class DirectionTest {

    @Test
    public void testWestIsOnLeftOfNorth() {
        Direction north = Direction.N;
        Direction west = north.spinLeftDirection();
        Assert.assertEquals(Direction.W, west);
    }

    @Test
    public void testEastIsOnRightOfNorth() {
        Direction north = Direction.N;
        Direction east = north.spinRightDirection();
        Assert.assertEquals(Direction.E, east);
    }

    @Test
    public void testNorthIsOnRightOfWest() {
        Direction west = Direction.W;
        Direction north = west.spinRightDirection();
        Assert.assertEquals(Direction.N, north);
    }

    @Test
    public void testSouthIsOnLeftOfWest() {
        Direction west = Direction.W;
        Direction south = west.spinLeftDirection();
        Assert.assertEquals(Direction.S, south);
    }

    @Test
    public void testEastIsOnLeftOfSouth() {
        Direction south = Direction.S;
        Direction east = south.spinLeftDirection();
        Assert.assertEquals(Direction.E, east);
    }

    @Test
    public void testWestIsOnRightOfSouth() {
        Direction south = Direction.S;
        Direction west = south.spinRightDirection();
        Assert.assertEquals(Direction.W, west);
    }

    @Test
    public void testNorthIsOnLeftOfEast() {
        Direction east = Direction.E;
        Direction north = east.spinLeftDirection();
        Assert.assertEquals(Direction.N, north);
    }

    @Test
    public void testSouthIsOnRightOfEast() {
        Direction east = Direction.E;
        Direction south = east.spinRightDirection();
        Assert.assertEquals(Direction.S, south);
    }

    @Test
    public void testEastIsOneStepForwardOnXAxis() {
        Direction east = Direction.E;
        int stepSize = east.getXIncrement();
        Assert.assertEquals(1, stepSize);
    }

    @Test
    public void testEastIsStationaryOnYAxis() {
        Direction east = Direction.E;
        int stepSize = east.getYIncrement();
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void testWestIsOneStepBackOnXAxis() {
        Direction west = Direction.W;
        int stepSize = west.getXIncrement();
        Assert.assertEquals(-1, stepSize);
    }

    @Test
    public void testWestIsStationaryOnYAxis() {
        Direction west = Direction.W;
        int stepSize = west.getYIncrement();
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void testNorthIsOneStepForwardOnYAxis() {
        Direction north = Direction.N;
        int stepSize = north.getYIncrement();
        Assert.assertEquals(1, stepSize);
    }

    @Test
    public void testNorthIsStationaryOnXAxis() {
        Direction north = Direction.N;
        int stepSize = north.getXIncrement();
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void testSouthIsOneStepBackOnYAxis() {
        Direction south = Direction.S;
        int stepSize = south.getYIncrement();
        Assert.assertEquals(-1, stepSize);
    }

    @Test
    public void testSouthIsStationaryOnXAxis() {
        Direction south = Direction.S;
        int stepSize = south.getXIncrement();
        Assert.assertEquals(0, stepSize);
    }
}