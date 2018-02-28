package Pieces;

import javafx.util.Pair;


public class Rook extends Piece {

    public Rook(String colour, Pair<Integer, Integer> coord) {
        super("Rook", colour, coord);
    }

    /**
     * A Rook may move any amount of spaces sideways or lengthways.
     * @param spaces negative is downwards or leftwards movement
     * @param direction false is sideways movement
     * @return boolean representing whether the move is valid or not
     */
    public boolean move(int spaces, boolean direction) {
        try {
            if(!direction) {
                this.setX(this.getX() + spaces);
            } else {
                this.setY(this.getY() + spaces);
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

}
