/**
 * 
 */
package com.xing.rover.surface;

/**
 * @author Geeta
 *
 */
public class Point {

    private int xPosition;

    private int yPosition;

    public Point(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getXPosition())).append(" ").append(getYPosition()).toString();
    }

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

}
