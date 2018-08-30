/**
 * 
 */
package com.xing.rover.surface;

/**
 * @author Geeta
 *
 */
public enum Direction {

    N(0, 1) {

        @Override
        public Direction spinLeftDirection() {
            return W;
        }

        @Override
        public Direction spinRightDirection() {
            return E;
        }

    },

    S(0, -1) {

        @Override
        public Direction spinLeftDirection() {
            return E;
        }

        @Override
        public Direction spinRightDirection() {
            return W;
        }
    },

    E(1, 0) {

        @Override
        public Direction spinLeftDirection() {
            return N;
        }

        @Override
        public Direction spinRightDirection() {
            return S;
        }
    },

    W(-1, 0) {

        @Override
        public Direction spinLeftDirection() {
            return S;
        }

        @Override
        public Direction spinRightDirection() {
            return N;
        }
    };

    private int xIncrement;
    private int yIncrement;

    public abstract Direction spinLeftDirection();

    public abstract Direction spinRightDirection();

    Direction(int xIncrement, int yIncrement) {
        this.setXIncrement(xIncrement);
        this.setYIncrement(yIncrement);
    }

    /**
     * @return the xIncrement
     */
    public int getXIncrement() {
        return xIncrement;
    }

    /**
     * @param xIncrement
     *            the xIncrement to set
     */
    public void setXIncrement(int xIncrement) {
        this.xIncrement = xIncrement;
    }

    /**
     * @return the yIncrement
     */
    public int getYIncrement() {
        return yIncrement;
    }

    /**
     * @param yIncrement
     *            the yIncrement to set
     */
    public void setYIncrement(int yIncrement) {
        this.yIncrement = yIncrement;
    }
}
