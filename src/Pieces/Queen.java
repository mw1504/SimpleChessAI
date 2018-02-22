package Pieces;

import javafx.util.Pair;

public class Queen extends Pieces {

    public Queen(String colour, Pair<Integer, Integer> coord) {
        super("Queen", colour, coord);
    }

    /**
     * A Queen is arguably the strongest piece in chess due to it's ability to move in any direction any amount of spaces.
     * @param spaces positive is the forwards direction of the chosen direction.
     * @param direction number from 0 - 3 representing one of the 4 directions of a Queens movement in a clockwise rotation starting upwards.
     * @return boolean representing whether the move is valid or not
     */
    public boolean move(int spaces, int direction) {
        try {
            switch(direction) {
                case 0: this.setY(this.getY() + spaces);
                        break;
                case 1: this.setX(this.getX() + spaces);
                        this.setY(this.getY() + spaces);
                        break;
                case 2: this.setY(this.getY() + spaces);
                        break;
                case 3: this.setX(this.getX() + spaces);
                        this.setY(this.getY() - spaces);
                        break;
                default: throw new IllegalArgumentException("The number entered is not valid. Enter a number between 0 - 3.");
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
