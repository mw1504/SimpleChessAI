package Board;

import Pieces.*;
import javafx.util.Pair;

public class Grid {
    private Piece[][] grid = new Piece[8][8];

    public Grid() {
        initiateSide("White");
        initiateSide("Black");
    }

    private void initiateSide(String colour) {
        int row = 0;
        String thisColour = colour;
        if (colour.equals("White")) {
            row += 7;
            thisColour = colour;
        }
        this.grid[row][0] = new Rook(thisColour, new Pair<>(row,0));
        this.grid[row][7] = new Rook(thisColour, new Pair<>(row,7));
        this.grid[row][1] = new Knight(thisColour, new Pair<>(row,1));
        this.grid[row][6] = new Knight(thisColour, new Pair<>(row,6));
        this.grid[row][2] = new Bishop(thisColour, new Pair<>(row,2));
        this.grid[row][5] = new Bishop(thisColour, new Pair<>(row,5));
        this.grid[row][3] = new Queen(thisColour, new Pair<>(row,3));
        this.grid[row][4] = new King(thisColour, new Pair<>(row,4));
        if(colour.equals("White")) {
            row -= 1;
        } else {
            row += 1;
        }
        for(int i = 0; i < 8 ; i++) {
            this.grid[row][i] = new Pawn(thisColour, new Pair<>(row,i));
        }
    }

    public void updateGrid(Piece piece, int oldX, int oldY) {
        this.grid[piece.getX()][piece.getY()] = piece;
        this.grid[oldX][oldY] = null;
    }

    public Piece getPiece(int x, int y) {
        return this.grid[x][y];
    }

    public void removePiece(int x, int y) {
        this.grid[x][y] = null;
    }

    @Override
    public String toString() {
        String outputGrid = "";
        for(int i = 0; i < 8; i++) {
            outputGrid += "|------------";
        }
        outputGrid += "|\n";
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(this.grid[i][j] != null) {
                    outputGrid += "|" + this.grid[i][j].toString();
                    if(this.grid[i][j].toString().length() < 12) {
                        for(int k = this.grid[i][j].toString().length(); k < 12; k++) {
                            outputGrid += " ";
                        }
                    }
                } else {
                    outputGrid +="|            ";
                }
            }
            outputGrid +="|\n";
            for(int j = 0; j < 7; j++) {
                outputGrid += "|------------";
            }
            outputGrid +="|------------|\n";
        }
        return outputGrid;
    }
}
