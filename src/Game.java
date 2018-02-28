import Board.Grid;
import Pieces.*;
import javafx.util.Pair;

import java.util.Scanner;

public class Game {
    private int[] turnOrder;
    private int currentTurn;
    private Grid chessBoard;

    public void initiateGame() {
        turnOrder = new int[]{0,1};
        currentTurn = turnOrder[0];
        chessBoard = new Grid();
    }

    private Piece checkPiece(int x, int y) {
        if ((x < 0) || (x > 7) || (y < 0) || (y > 7)) {
            throw new IllegalArgumentException("That square isn't on the chessboard.");
        }
        Piece chosenPiece = this.chessBoard.getPiece(x, y);
        if (chosenPiece == null) {
            throw new IllegalArgumentException("There is no piece on that Square.");
        }
        return chosenPiece;
    }

    private String action(Pawn pawn) {
        String input = "";
        Scanner keys = new Scanner(System.in);
        boolean actionCompleted = false;
        while (input != "q" && !actionCompleted) {
            if (pawn.isFirstMove()) {
                System.out.println("This pawn has 3 options of movement pick one now:");
            } else {
                System.out.println("This pawn has 2 options of movement pick one now:");
            }
            System.out.println("1. Move one square forward.");
            System.out.println("2. Attack in a direction of left or right.");
            if (pawn.isFirstMove()) {
                System.out.println("3. Move two spaces forward as it's the pawns first move.");
            }
            System.out.print("Enter the number of your choice now:");
            input = keys.nextLine();
            switch (input) {
                case "1": pawn.move(this.chessBoard);
                        actionCompleted = true;
                        break;
                case "2": {
                    System.out.print("Which direction would you like to attack (L/R):");
                    input = keys.nextLine();
                    if (input.equals("L")) {
                        pawn.attack(false, this.chessBoard);
                    } else if (input.equals("R")) {
                        pawn.attack(true, this.chessBoard);
                    }
                    actionCompleted = true;
                    break;
                }
                case "3": {
                    if (!pawn.isFirstMove()) {
                        break;
                    }
                    pawn.firstMove(this.chessBoard);
                    actionCompleted = true;
                    break;
                }
            }
        }
        return input;
    }

    private String action(Rook rook) {
        return null;
    }

    private String action(Knight knight) {
        return null;
    }

    private String action(Bishop bishop) {
        return null;
    }

    private String action(Queen queen) {
        System.out.print("How many spaces would you like to move the queen: ");
        Scanner keys = new Scanner(System.in);
        String input = keys.nextLine();
        if (input.equals("q")) {
            return input;
        }
        int spaces = Integer.parseInt(input);
        System.out.println("Which direction would you like to move it in: ");
        System.out.println("1. Upwards");
        System.out.println("2. Forward Diagonal");
        System.out.println("3. Sideways");
        System.out.println("4. Backwards Diagonal");
        System.out.print("Enter your choice now: ");
        input = keys.nextLine();
        if (input.equals("q")) {
            return input;
        }
        int direction = Integer.parseInt(input) - 1;
        queen.move(spaces, direction, this.chessBoard);
        return "";
    }

    private String action(King king) {
      return "test";
    }

    public void playGame() {
        String input = "";
        Scanner keys = new Scanner(System.in);
        while (!input.toLowerCase().equals("q")) {
            if (currentTurn == 0) {
                System.out.println("It is Whites turn.");
            } else {
                System.out.println("It is Blacks turn.");
            }
            System.out.println("Select the piece you want to move:");
            System.out.println(this.chessBoard);
            input = keys.nextLine();
            int[] location = new int[2];
            location[0] = Integer.parseInt(input.split(",")[0]);
            location[1] = Integer.parseInt(input.split(",")[1]);
            Piece piece = this.checkPiece(location[0], location[1]);
            switch (piece.getName()) {
                case "Pawn": input = this.action((Pawn) piece);
                        if (piece.getX() == 7) {
                            piece = ((Pawn) piece).endOfBoard(this.chessBoard);
                        }
                        break;
                case "Rook": input = this.action((Rook) piece);
                        break;
                case "Knight": input = this.action((Knight) piece);
                        break;
                case "Bishop": input = this.action((Bishop) piece);
                        break;
                case "Queen": input = this.action((Queen) piece);
                        break;
                case "King": input = this.action((King) piece);
                        break;
                default: throw new IllegalArgumentException("An error occurred");
            }
            this.chessBoard.updateGrid(piece, location[0], location[1]);
        }
    }
}
