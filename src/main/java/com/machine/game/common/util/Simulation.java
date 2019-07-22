package com.machine.game.common.util;

import org.springframework.stereotype.Component;

import static com.machine.game.common.Constant.*;
import static com.machine.game.common.util.FileWriter.file;
import static com.machine.game.common.util.FileWriter.write;


@Component
public class Simulation {

    public static  String d1 = "";
    public static  String d2 = "";
    public static  String c1 = "";
    public static  String c2 = "";
    public static  String P = board[0][0];

    public static void printEmptyBoard(){
    // sets full board to " "
    for (int row = 0; row < board.length; row++)
        for (int column = 0; column < board[row].length; column++)
            board[row][column] = " ";
}


    public static void printBoard() {
        file.delete();
    write(" -4    -3    -2    -1     0     1     2     3     4" + "\n");
          write(  "  +-----+-----+-----+-----+-----+-----+-----+-----+" + "\n");
        for (int n = board.length - 1; n >= 0; n--) {
            for (int x = 1; x < board[n].length; x++) {
                write("  | " + board[n][x] );
            }
            write("  |  " + (n - 4) + "\n");
                    write("  +-----+-----+-----+-----+-----+-----+-----+-----+" + "\n");
        }
    }

    public static void updateBoard(int row, int column, String p) {

        board[row][column] = p;

    }

    public static void setDirection() {
        if (d1 == "")
            d1 = ">";
        if (d2 == "")
            d2 = "V";
    }

    public static void setColor() {
        if (c1 == "")
            c1 = "w";
        if (c2 == "")
            c2 = "b";
    }

    public static void printGrid(int steps) {
        int row = 0;
        int column = 0;
        int downIndex = 0;
        int rightIndex = 0;
        row += 8;
        column += 1;
        downIndex += 8;
        rightIndex += 1;
        setDirection();
        setColor();
        P = c1 + d1;
        board[row][column] = P;
        updateBoard(row, column, P);

        for (int i = 1; i <= steps; i++) {

            if (P.substring(0, 1).equals(c1)) {

                P = c2 + d2;
                updateBoard(downIndex - 1, rightIndex, P);
                downIndex = downIndex - 1;
            }

            else if (P.substring(0, 1).equals(c2)) {

                P = c1 + d1;
                updateBoard(downIndex, rightIndex + 1, P);
                rightIndex = rightIndex + 1;

            }
        }

        printBoard();

    }

}
