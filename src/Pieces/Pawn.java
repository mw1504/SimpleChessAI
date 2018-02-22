package Pieces;

import javafx.util.Pair;

public class Pawn extends Pieces {

    public Pawn(String Colour, Pair<Integer, Integer> coord) {
        super("Pawn", Colour, coord);
    }

    /**
     * A pawn may only move forwards.
     * @return boolean representing whether the move is valid or not
     */
    public boolean move() {
        try {
            this.setX(this.getX() + 1);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    /**
     * A pawn may only take pieces that are diagonally in front of it by one space
     * @param direction whether the attack is to the left or the right
     * @return boolean representing whether the move is valid or not
     */
    public boolean attack(boolean direction) {
        this.setX(this.getX() + 1);
        try {
            if (!direction) {
                this.setY(this.getY() - 1);
            } else {
                this.setY(this.getY() + 1);
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
