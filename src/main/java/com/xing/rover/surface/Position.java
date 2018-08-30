/**
 * 
 */
package com.xing.rover.surface;

/**
 * @author Geeta
 *
 */
public class Position {

    private Point coordinates;

    private Direction direction;

    /**
     * @return the coordinates
     */
    public Point getCoordinates() {
        if (null == coordinates) {
            coordinates = new Point(0, 0);
        }
        return coordinates;
    }

    /**
     * @param coordinates
     *            the coordinates to set
     */
    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        if (null == direction) {
            direction = Direction.E;
        }
        return direction;
    }

    /**
     * @param direction
     *            the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String toString() {
        return new StringBuilder(getCoordinates().toString()).append(" ").append(getDirection().toString()).toString();
    }
}
