/**
 * 
 */
package com.xing.rover.service;

import org.junit.Assert;
import org.junit.Test;

import com.xing.rover.exception.RoverException;
import com.xing.rover.surface.Direction;
import com.xing.rover.surface.Plateau;
import com.xing.rover.surface.Point;
import com.xing.rover.surface.Position;

/**
 * @author Geeta
 *
 */
public class MovementControllerTest {

    @Test
    public void testNewCoordinates() throws RoverException {
        MovementController movementController = new MovementController();
        Plateau plateau = new Plateau();
        plateau.setTopRight(new Point(6, 6));
        Position position = new Position();
        position.setCoordinates(new Point(1, 2));
        position.setDirection(Direction.N);
        movementController.setCurrentPosition(position);
        movementController.setPlateau(plateau);
        movementController.newCoordinates();
        Assert.assertEquals("1 3 N", movementController.getCurrentPosition().toString());
    }

    @Test(expected = RoverException.class)
    public void testNewCoordinatesLimitExceeded() throws RoverException {
        MovementController movementController = new MovementController();
        Plateau plateau = new Plateau();
        plateau.setTopRight(new Point(6, 6));
        Position position = new Position();
        position.setCoordinates(new Point(6, 6));
        position.setDirection(Direction.N);
        movementController.setCurrentPosition(position);
        movementController.setPlateau(plateau);
        movementController.newCoordinates();
    }

    @Test
    public void testValidCheckInboundLimit() {
        Plateau plateau = new Plateau();
        plateau.setTopRight(new Point(6, 6));
        int newXPosition = 4;
        int newYPosition = 5;
        MovementController movementController = new MovementController();
        movementController.setPlateau(plateau);
        boolean withinLimit = movementController.checkInboundLimit(newXPosition, newYPosition);
        Assert.assertEquals(true, withinLimit);
    }

    @Test
    public void testInvalidCheckInboundLimit() {
        Plateau plateau = new Plateau();
        plateau.setTopRight(new Point(6, 6));
        int newXPosition = 7;
        int newYPosition = 9;
        MovementController movementController = new MovementController();
        movementController.setPlateau(plateau);
        boolean withinLimit = movementController.checkInboundLimit(newXPosition, newYPosition);
        Assert.assertEquals(false, withinLimit);
    }

    @Test
    public void testHandleMovement() throws RoverException {
        MovementController movementController = new MovementController();
        Position position = new Position();
        position.setCoordinates(new Point(1, 2));
        position.setDirection(Direction.N);
        Plateau plateau = new Plateau();
        plateau.setTopRight(new Point(6, 6));
        movementController.setPlateau(plateau);
        movementController.setCurrentPosition(position);
        movementController.handleMovement("LMLMLMLMM".toCharArray());
        Assert.assertEquals("1 3 N", movementController.getCurrentPosition().toString());
    }

    @Test(expected = RoverException.class)
    public void testInvalidHandleMovement() throws RoverException {
        MovementController movementController = new MovementController();
        Position position = new Position();
        position.setCoordinates(new Point(1, 2));
        position.setDirection(Direction.N);
        movementController.setCurrentPosition(position);
        Plateau plateau = new Plateau();
        plateau.setTopRight(new Point(6, 6));
        movementController.setPlateau(plateau);
        movementController.handleMovement("LMFFFLMLMLMM".toCharArray());
    }
}
