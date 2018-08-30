/**
 * 
 */
package com.xing.rover.main;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.xing.rover.exception.RoverException;
import com.xing.rover.surface.Direction;
import com.xing.rover.surface.Point;
import com.xing.rover.surface.Position;

/**
 * @author Geeta
 *
 */
public class RoverTest {
    @Test
    public void testValidParsePosition() throws RoverException {
        Position position = new Position();
        position.setCoordinates(new Point(5, 6));
        position.setDirection(Direction.N);
        Rover rover = new Rover();
        rover.parsePosition(position.toString().split(" "));
        Assert.assertEquals("5 6 N", rover.getMovementController().getCurrentPosition().toString());
    }

    @Test(expected = RoverException.class)
    public void testInvalidParsePosition() throws RoverException {
        String positionString = "1 2 3 N";
        Rover rover = new Rover();
        rover.parsePosition(positionString.split(" "));
    }

    @Test
    public void testValidParsePlateau() throws RoverException {
        Rover rover = new Rover();
        rover.parsePlateau(new Point(5, 6).toString().split(" "));
        Assert.assertEquals("0 0::5 6", rover.getMovementController().getPlateau().toString());
    }

    @Test(expected = RoverException.class)
    public void testInvalidParsePlateau() throws RoverException {
        String positionString = "1 2 3 4 5";
        Rover rover = new Rover();
        rover.parsePosition(positionString.split(" "));
    }

    @Test
    public void testSplitStringBySpace() {
        String positionString = "1 2 3 4 5";
        Rover rover = new Rover();
        Assert.assertEquals(Arrays.toString(positionString.split(" ")),
                Arrays.toString(rover.splitStringBySpace(positionString)));
    }

}