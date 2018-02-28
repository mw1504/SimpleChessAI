package Pieces;

import Board.Grid;
import javafx.util.Pair;

import java.util.Scanner;

public class Pawn extends Piece {
    private boolean firstMove;

    public Pawn(String Colour, Pair<Integer, Integer> coord) {
        super("Pawn", Colour, coord);
        firstMove = true;
    }
    
    /**
     * A Pawn has a special case of movement where on it's first move it can move one further.
     * @return boolean representing whether the move is valid or not
     */
    public boolean firstMove(Grid grid) {
        if (firstMove) {
            if (this.getColour().equals("White")) {
                if ((grid.getPiece(this.getX() - 1, this.getY()) != null) || (grid.getPiece(this.getX() - 2, this.getY()) != null)) {
                    throw new IllegalArgumentException("There is another piece in the way.");
                }
                this.setX(this.getX() - 2);
            } else {
                if ((grid.getPiece(this.getX() + 1, this.getY()) != null) || (grid.getPiece(this.getX() + 2, this.getY()) != null)) {
                    throw new IllegalArgumentException("There is another piece in the way.");
                }
                this.setX(this.getX() + 2);
            }
            firstMove = false;
            return true;
        }
        return false;
    }    

    /**
     * A Pawn may only move forwards.
     * @return boolean representing whether the move is valid or not
     */
    public boolean move(Grid grid) {
        if (this.getColour().equals("White")) {
            if (grid.getPiece(this.getX() - 1, this.getY()) != null) {
                throw new IllegalArgumentException("There is another piece in the way.");
            }
            this.setX(this.getX() - 1);
        } else {
            if (grid.getPiece(this.getX() + 1, this.getY()) != null) {
                throw new IllegalArgumentException("There is another piece in the way.");
            }
            this.setX(this.getX() + 1);
        }
        firstMove = false;
        return true;
    }

    /**
     * A Pawn may only take pieces that are diagonally in front of it by one space
     * @param direction whether the attack is to the left or the right
     * @return boolean representing whether the move is valid or not
     */
    public boolean attack(boolean direction, Grid grid) {
        if (this.getColour().equals("White") && !direction) {
            if (grid.getPiece(this.getX() - 1, this.getY() - 1) == null) {
                throw new IllegalArgumentException("There isn't a piece there to attack");
            } else {
                grid.removePiece(this.getX() - 1, this.getY() - 1);
            }
            this.setX(this.getX() - 1);
            this.setY(this.getY() - 1);
        } else if (this.getColour().equals("White") && direction) {
            if (grid.getPiece(this.getX() - 1, this.getY() + 1) == null) {
                throw new IllegalArgumentException("There isn't a piece there to attack");
            } else {
                grid.removePiece(this.getX() - 1, this.getY() + 1);
            }
            this.setX(this.getX() - 1);
            this.setY(this.getY() + 1);
        } else if (this.getColour().equals("Black") && !direction) {
            if (grid.getPiece(this.getX() + 1, this.getY() - 1) == null) {
                throw new IllegalArgumentException("There isn't a piece there to attack");
            } else {
                grid.removePiece(this.getX() + 1, this.getY() - 1);
            }
            this.setX(this.getX() + 1);
            this.setY(this.getY() - 1);
        } else if (this.getColour().equals("Black") && direction){
            if (grid.getPiece(this.getX() + 1, this.getY() + 1) == null) {
                throw new IllegalArgumentException("There isn't a piece there to attack");
            } else {
                grid.removePiece(this.getX() + 1, this.getY() + 1);
            }
            this.setX(this.getX() + 1);
            this.setY(this.getY() + 1);
        }
        firstMove = false;
        return true;
    }

    public Piece endOfBoard(Grid grid) {
        System.out.println("You've reached the end of the board with a pawn.");
        System.out.println("You can now upgrade this piece into another piece.");
        System.out.println("1. Rook");
        System.out.println("2. Knight");
        System.out.println("3. Bishop");
        System.out.println("4. Queen");
        System.out.print("Enter the number of your choice: ");
        Scanner keys = new Scanner(System.in);
        String input = "";
        Piece chosenPiece = null;
        while (chosenPiece == null) {
            input = keys.nextLine();
            switch(input) {
                case "1": chosenPiece = new Rook(this.getColour(), this.getCoord());
                        break;
                case "2": chosenPiece = new Knight(this.getColour(), this.getCoord());
                        break;
                case "3": chosenPiece = new Bishop(this.getColour(), this.getCoord());
                        break;
                case "4": chosenPiece = new Queen(this.getColour(), this.getCoord());
            }
            if (chosenPiece == null) {
                System.out.print("Please reenter your option: ");
            }
        }
        return chosenPiece;
    }

    /**
     * If a pawn hasn't had it's first move then this will output true otherwise if it has
     * had it's first move it will output false.
     * @return boolean representing whether or not the pawn has had it's first move
     */
    public boolean isFirstMove() {
        return this.firstMove;
    }
}
