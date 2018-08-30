/**
 * 
 */
package com.xing.rover.main;

import java.io.InputStream;
import java.util.Scanner;

import com.xing.rover.exception.RoverException;
import com.xing.rover.service.MovementController;
import com.xing.rover.surface.Direction;
import com.xing.rover.surface.Point;
import com.xing.rover.surface.Position;

/**
 * @author Geeta
 *
 */
public class Rover {

    private MovementController movementController = new MovementController();

    /**
     * @param args
     */
    public static void main(String[] args) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("inputFile.txt");
        Rover rover = new Rover();
        rover.readFile(inputStream);
    }

    /**
     * @param rover
     * @param file
     */
    private void readFile(InputStream file) {
        char[] movementString;
        try (Scanner sc = new Scanner(file)) {
            if (sc != null && sc.hasNextLine()) {
                String[] upperRightPosition = splitStringBySpace(sc.nextLine());
                parsePlateau(upperRightPosition);
            } else {
                System.out.println("Input upper bound not given");
                return;
            }
            while (sc.hasNextLine()) {
                String[] positionString = splitStringBySpace(sc.nextLine());
                parsePosition(positionString);
                if (sc != null && sc.hasNextLine()) {
                    movementString = sc.nextLine().toCharArray();
                    movementController.handleMovement(movementString);
                } else {
                    System.out.println("Input movement string not given");
                    return;
                }
                displayNewPosition(movementController.getCurrentPosition());
            }

        } catch (NumberFormatException nfex) {
            System.out.println("Invalid input, location couldn't be parsed");
            nfex.printStackTrace();
        } catch (RoverException ex) {
            System.out.println("Other exception" + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * @param newPosition
     */
    public void displayNewPosition(Position newPosition) {
        System.out.println(newPosition.toString());
    }

    /**
     * @param sc
     * @param currentPosition
     * @throws Exception
     */
    public void parsePosition(String[] positionString) throws RoverException {
        if (positionString.length != 3) {
            System.out.println("Input rover position invalid");
            throw new RoverException("Input rover position invalid");
        }
        movementController.getCurrentPosition()
                .setCoordinates(new Point(Integer.parseInt(positionString[0]), Integer.parseInt(positionString[1])));
        movementController.getCurrentPosition().setDirection(Direction.valueOf(positionString[2]));
    }

    /**
     * @param sc
     * @throws Exception
     */
    public void parsePlateau(String[] upperRightPosition) throws RoverException {
        if (upperRightPosition.length != 2) {
            System.out.println("Input top right position invalid");
            throw new RoverException("Input top right position invalid");
        }
        movementController.getPlateau().setTopRight(
                new Point(Integer.parseInt(upperRightPosition[0]), Integer.parseInt(upperRightPosition[1])));
    }

    public String[] splitStringBySpace(String str) {
        return str.split(" ");
    }

    /**
     * @return the movementController
     */
    public MovementController getMovementController() {
        return movementController;
    }

    /**
     * @param movementController
     *            the movementController to set
     */
    public void setMovementController(MovementController movementController) {
        this.movementController = movementController;
    }

}
