package Pieces;

import javafx.util.Pair;

public class Bishop extends Piece {

    public Bishop(String colour, Pair<Integer, Integer> coord) {
        super("Bishop", colour, coord);
    }

    /**
     * A Bishop may only move along the diagonals.
     * @param spaces positive is upwards movement
     * @param direction false is leftwards movement
     * @return boolean representing whether the move is valid or not
     */
    public boolean move(int spaces, boolean direction) {
        try {
            if (!direction) {
                this.setX(this.getX() - Math.abs(spaces));
                this.setY(this.getY() + spaces);
            } else {
                this.setX(this.getX() + Math.abs(spaces));
                this.setY(this.getY() + spaces);
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }
}
