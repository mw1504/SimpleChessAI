package Pieces;

import javafx.util.Pair;

public class King extends Pieces{

    public King(String colour, Pair<Integer, Integer> coord) {
        super("King", colour, coord);
    }

    /**
     * A King is the key piece, don't get it trapped or you will lose.
     * Much like the Queen it can move in any direction however it can only move by one space.
     * @param direction number from 0 - 7 representing one of the 8 moves of a King starting forwards in a clockwise rotation
     * @return boolean representing whether the move is valid or not
     */
    public boolean move(int direction) {
        try {
            switch(direction) {
                case 0: this.setY(this.getY() + 1);
                        break;
                case 1: this.setX(this.getX() + 1);
                        this.setY(this.getY() + 1);
                        break;
                case 2: this.setX(this.getX() + 1);
                        break;
                case 3: this.setX(this.getX() + 1);
                        this.setY(this.getY() - 1);
                        break;
                case 4: this.setY(this.getY() - 1);
                        break;
                case 5: this.setX(this.getX() - 1);
                        this.setY(this.getY() - 1);
                        break;
                case 6: this.setX(this.getX() - 1);
                        break;
                case 7: this.setX(this.getX() - 1);
                        this.setY(this.getY() + 1);
                        break;
                default: throw new IllegalArgumentException("The number entered is not valid. Enter a number between 0 - 7.");
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
