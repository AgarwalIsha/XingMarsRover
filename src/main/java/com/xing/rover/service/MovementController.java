/**
 * 
 */
package com.xing.rover.service;

import com.xing.rover.exception.RoverException;
import com.xing.rover.surface.Plateau;
import com.xing.rover.surface.Position;

/**
 * @author Geeta
 *
 */
public class MovementController {

    private Position currentPosition;
    private Plateau plateau;

    /**
     * @return the currentPosition
     */
    public Position getCurrentPosition() {
        if (null == currentPosition) {
            currentPosition = new Position();
        }
        return currentPosition;
    }

    /**
     * @param currentPosition
     *            the currentPosition to set
     */
    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    /**
     * @return the plateau
     */
    public Plateau getPlateau() {
        if (null == plateau) {
            plateau = new Plateau();
        }
        return plateau;
    }

    /**
     * @param plateau
     *            the plateau to set
     */
    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public void newCoordinates() throws RoverException {
        int newXPosition = currentPosition.getCoordinates().getXPosition()
                + currentPosition.getDirection().getXIncrement();
        int newYPosition = currentPosition.getCoordinates().getYPosition()
                + currentPosition.getDirection().getYIncrement();
        boolean withinLimit = checkInboundLimit(newXPosition, newYPosition);
        if (withinLimit) {
            currentPosition.getCoordinates().setXPosition(newXPosition);
            currentPosition.getCoordinates().setYPosition(newYPosition);
        } else {
            System.out.println("Cannot move, plateau outbound");
            throw new RoverException("Cannot move, plateau outbound");
        }
    }

    /**
     * @param plateau
     * @param newXPosition
     * @param newYPosition
     */
    public boolean checkInboundLimit(int newXPosition, int newYPosition) {
        boolean withinLimit = true;
        if (newXPosition > plateau.getTopRight().getXPosition() || newYPosition > plateau.getTopRight().getYPosition()
                || newXPosition < plateau.getBottomLeft().getXPosition()
                || newYPosition < plateau.getBottomLeft().getYPosition()) {
            System.out.println("Plateau outbound error");
            withinLimit = false;
        }
        return withinLimit;
    }

    /**
     * @param movementString
     * @throws Exception
     */
    public void handleMovement(char[] movementString) throws RoverException {

        for (char move : movementString) {
            switch (move) {
            case 'L':
                getCurrentPosition().setDirection(getCurrentPosition().getDirection().spinLeftDirection());
                break;
            case 'R':
                getCurrentPosition().setDirection(getCurrentPosition().getDirection().spinRightDirection());
                break;
            case 'M':
                newCoordinates();
                break;
            default:
                System.out.println("Invalid movement string");
                throw new RoverException("Invalid movement string");
            }
        }
    }
}
