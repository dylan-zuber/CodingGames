import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    private static boolean[][] board = new boolean[32][22];

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        initBoard();
        int myTurn = 0;
        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).
            int x = 0, y = 0;
            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
                if(i == P) {
                    x = X1+1;
                    y = Y1+1;
                } else {
                    updateBoard(X1, Y1, P);
                }
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...")
            System.err.println(x + " " + y);
            if(board[x-1][y]) {
                System.out.println("LEFT");
            } else if(board[x][y+1]) {
                System.out.println("DOWN");
            } else if(board[x+1][y]) {
                System.out.println("RIGHT");
            } else {
                System.out.println("UP");
            }
            
            updateBoard(x, y, 0);
        }
    }

    public static void initBoard() {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(i == 0 || j == 0 || i == 31 || j == 21) {
                    board[i][j] = false;
                } else {
                    board[i][j] = true;
                }
            }
        }
    }

    public static void updateBoard(int x, int y, int p) {
        // p to be used to update board later on with where each player has been
        board[x][y] = false;
    }
}