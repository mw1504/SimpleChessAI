package Pieces;

import javafx.util.Pair;

public class Knight extends Pieces {

    public Knight(String colour, Pair<Integer, Integer> coord) {
        super("Knight", colour, coord);
    }

    /**
     * The knight is a peculiar piece, it moves in an L shape, meaning it has a possible of 8 different moves.
     * @param position number from 0 - 7 representing one of the 8 moves of a knight starting forwards in a clockwise rotation
     * @return boolean representing whether the move is valid or not
     */
    public boolean move(int position) {
        try {
            switch(position) {
                case 0: this.setX(this.getX() + 1);
                        this.setY(this.getY() + 2);
                        break;
                case 1: this.setX(this.getX() + 2);
                        this.setY(this.getY() + 1);
                        break;
                case 2: this.setX(this.getX() + 2);
                        this.setY(this.getY() - 1);
                        break;
                case 3: this.setX(this.getX() + 1);
                        this.setY(this.getY() - 2);
                        break;
                case 4: this.setX(this.getX() - 1);
                        this.setY(this.getY() - 2);
                        break;
                case 5: this.setX(this.getX() - 2);
                        this.setY(this.getY() - 1);
                        break;
                case 6: this.setX(this.getX() - 2);
                        this.setY(this.getY() + 1);
                        break;
                case 7: this.setX(this.getX() - 1);
                        this.setY(this.getY() + 2);
                        break;
                default: throw new IllegalArgumentException("The number entered is not valid. Enter a number between 0 - 7.");
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
