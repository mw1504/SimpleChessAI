package Pieces;

import javafx.util.Pair;

public class Piece {
    private String colour;
    private String name;
    private Pair<Integer, Integer> coord;

    protected Piece(String name, String colour, Pair<Integer, Integer> coord) {
        this.name = name;
        this.colour = colour;
        this.coord = coord;
    }

    public String getName() {
        return this.name;
    }

    public String getColour() {
        return this.colour;
    }

    public Pair<Integer, Integer> getCoord() {
        return this.coord;
    }

    protected void setX(int x) throws IllegalArgumentException {
        if ((x < 0) || (x > 7)) {
            throw new IllegalArgumentException("That move is an invalid move.");
        }
        this.coord = new Pair<>(x, this.coord.getValue());
    }

    public int getX() {
        return this.coord.getKey();
    }

    protected void setY(int y) throws IllegalArgumentException {
        if ((y < 0) || (y > 7)) {
            throw new IllegalArgumentException("That move is an invalid move.");
        }
        this.coord = new Pair<>(this.coord.getKey(), y);
    }

    public int getY() {
        return this.coord.getValue();
    }

    @Override
    public String toString() {
        return  this.colour + " " + this.name;
    }
}
