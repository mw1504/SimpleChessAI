package Pieces;

import javafx.util.Pair;

public class Pawn extends Pieces {
    private boolean firstMove;

    public Pawn(String Colour, Pair<Integer, Integer> coord) {
        super("Pawn", Colour, coord);
        firstMove = true;
    }
    
    /**
     * A Pawn has a special case of movement where on it's first move it can move one further.
     * @return boolean representing whether the move is valid or not
     */
    public boolean firstMove() {
        if (firstMove) {
            try {
                this.setX(this.getX() + 2);
            } catch (IllegalArgumentException e) {
                return false;
            }
            firstMove = false;
            return true;
        }
    }    

    /**
     * A Pawn may only move forwards.
     * @return boolean representing whether the move is valid or not
     */
    public boolean move() {
        firstMove = false;
        try {
            this.setX(this.getX() + 1);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    /**
     * A Pawn may only take pieces that are diagonally in front of it by one space
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
