package Test.Pieces;

import javafx.util.Pair;

import Pieces.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPiece {
    private Pawn pawn;
    private Rook rook;
    private Knight knight;
    private Bishop bishop;
    private Queen queen;
    private King king;

    /*@Before
    public void initAll() {
        this.pawn = new Pawn("Black", new Pair<>(0,0));
        this.rook = new Rook("Black", new Pair<>(0,0));
        this.knight = new Knight("Black", new Pair<>(0,0));
        this.bishop = new Bishop("White", new Pair<>(0,0));
        this.queen = new Queen("White", new Pair<>(0,0));
        this.king = new King("Black", new Pair<>(0,0));

    }

    @Test
    public void testPawn() {
        assertEquals("The name of the Pawn piece should be Pawn.", "Pawn", this.pawn.getName());
        assertEquals("The colour of the Pawn should be black.", "Black", this.pawn.getColour());
        assertEquals("The Coordinates of this Pawn should be 0, 0.", new Pair<>(0,0), this.pawn.getCoord());
        assertEquals("The x Coordinates of the Pawn should be 0.", 0, this.pawn.getX());
        assertEquals("The y Coordinates of the Pawn should be 0.", 0, this.pawn.getY());
        assertEquals("The toString should read black Pawn.", "Black Pawn", this.pawn.toString());
        this.pawn.firstMove();
        assertEquals("The first move should move the pawn two spaces forwards.", new Pair<>(2,0), this.pawn.getCoord());
        this.pawn.move();
        assertEquals("The second move or an alternate first move should move the pawn only one space forward.", new Pair<>(3,0), this.pawn.getCoord());
        this.pawn.attack(true);
        assertEquals("A Pawn has a special case for when it attacks, it attacks diagonally.", new Pair<>(4,1), this.pawn.getCoord());
        this.pawn.attack(false);
        assertEquals(new Pair<>(5,0), this.pawn.getCoord());
        assertEquals("A pawn should not be able to move outside the grid even for an attack", false, this.pawn.attack(false));
        while(pawn.getX() != 7) {
            assertEquals(true, pawn.move());
        }
        assertEquals("A pawn should not be able to move forward out of the grid", false, this.pawn.move());
    }

    @Test
    public void testRook() {
        assertEquals("The name of the Rook piece should be Rook.", "Rook", this.rook.getName());
        assertEquals("The colour of the Rook should be black.", "Black", this.rook.getColour());
        assertEquals("The Coordinates of this Rook should be 0, 0.", new Pair<>(0,0), this.rook.getCoord());
        assertEquals("The x Coordinates of the Rook should be 0.", 0, this.rook.getX());
        assertEquals("The y Coordinates of the Rook should be 0.", 0, this.rook.getY());
        assertEquals("The toString should read Black Rook.", "Black Rook", this.rook.toString());
        assertEquals("The x coordinate of the rook should be 7", true, this.rook.move(7, false));
        assertEquals("The y coordinate of the rook should be 4", true, this.rook.move(4, true));
        assertEquals(new Pair<>(7,4), this.rook.getCoord());
        assertEquals("A rook should not be able to move horizontally move outside the grid", false,this.rook.move( 6, false));
        assertEquals("A rook should not be able to vertically move outside of the grid", false, this.rook.move(7, true));
    }
*/
}
