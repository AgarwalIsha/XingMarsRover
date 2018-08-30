/**
 * 
 */
package com.xing.rover.surface;

/**
 * @author Geeta
 *
 */
public class Plateau {

    private Point bottomLeft;

    private Point topRight;

    /**
     * @return the bottomLeft
     */
    public Point getBottomLeft() {
        if (null == bottomLeft) {
            bottomLeft = new Point(0, 0);
        }
        return bottomLeft;
    }

    public Plateau(Point topRight) {
        this.topRight = topRight;
        this.bottomLeft = new Point(0, 0);
    }

    public Plateau() {
    }

    /**
     * @param bottomLeft
     *            the bottomLeft to set
     */
    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    /**
     * @return the topRight
     */
    public Point getTopRight() {
        if (null == topRight) {
            topRight = new Point(0, 0);
        }
        return topRight;
    }

    /**
     * @param topRight
     *            the topRight to set
     */
    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public String toString() {
        return new StringBuilder(String.valueOf(getBottomLeft())).append("::").append(getTopRight()).toString();
    }

}
