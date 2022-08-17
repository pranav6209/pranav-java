package com.pranav.company;

package edu.connectn;

/**
 * @author Chaitrali Jayantilal Doshi
 * Assignment No: 3
 * Date: 2016.10.26
 * Class Name: ConnectN
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class ConnectN {
    private int gameState[][];
    private int rows;
    private int columns;
    private int winningNumber;
    private int lastRow, lastColumn;

    private static Scanner scanner = new Scanner(System.in);

    public ConnectN() {
        // initialize
        // initialize class variables to default parameters
        // rows = 6
        this.rows = 6;
        // columns = 7
        this.columns = 7;
        // winning number = 4
        this.winningNumber = 4;
        // initialize game state
        this.gameState = new int[this.rows][this.columns];
        // initialize lastRow and lastColumn
        this.lastRow = 0;
        this.lastColumn = 0;
    }

    public ConnectN(int rows, int columns, int winningNumber) {
        // initialize
        // initialize class variables based on input parameters
        this.rows = rows;
        this.columns = columns;
        this.winningNumber = winningNumber;
        // initialize game state
        this.gameState = new int[this.rows][this.columns];
        // initialize lastRow and lastColumn
        this.lastRow = 0;
        this.lastColumn = 0;
    }

    public void clearGame() {
        // set all positions to empty
        // this.gameState = null;
        Arrays.fill(this.gameState, 0);
        this.rows = 0;
        this.columns = 0;
        this.winningNumber = 0;

        // initialize lastRow and lastColumn
        this.lastRow = 0;
        this.lastColumn = 0;
    }

    public boolean insertChip(int playerNumber, int columnNumber) {
        boolean inserted = false;

        // try to insert
        // start at row 0 (the top row)
        // loop through the rows until a non-empty position is found
        for (int i = 0; i < this.rows && !inserted; i++) {
            // if the top position is empty
            if (this.gameState[i][columnNumber - 1] == 0) {
                // set game state position to the player number
                this.gameState[i][columnNumber - 1] = playerNumber;
                // inserted = true
                inserted = true;
                // set last row and last column to the inserted position
                this.lastRow = i;
                this.lastColumn = columnNumber - 1;
            }
        }

        return inserted;
    }

    public void outputGameState() {
        // create a string builder

        StringBuilder sb = new StringBuilder();
        // loop through all rows
        // loop through all columns
        // append gameState[row][column] to the output string builder
        for (int i = this.rows - 1; i >= 0; i--) {
            for (int j = 0; j <= this.columns - 1; j++) {
                sb.append(gameState[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        // output the game state string
        System.out.println("\n" + sb);

    }

    private boolean isGameFull() {
        boolean isFull = true;

        // check if game board is full
        // loop through all columns
        // if the top position is empty then the game is not full
        for (int i = 0; i < this.columns && isFull; i++) {
            if (gameState[this.rows - 1][i] == 0) {
                isFull = false;
            }
        }
        return isFull;

    }

    public int detectWin() {
        int winner = -1;

        // detect win rows
        int checkRows = detectWinRows();
        if (checkRows != -1) {
            winner = checkRows;
        }

        // detect win columns
        if (winner == -1) {
            int checkColumns = detectWinColumns();
            if (checkColumns != -1) {
                winner = checkColumns;
            }
        }

        // detect win diagonals
        if (winner == -1) {
            int checkDiagonals = this.detectWinDiagonals();
            if (checkDiagonals != -1) {
                winner = checkDiagonals;
            }
        }

        return winner;
    }

    private int detectWinColumns() {

        int winColumns = -1;
        // return the player who has win or -1 if no player has win

        int lastPlayer = gameState[this.lastRow][this.lastColumn];
        int count = 1;
        boolean stopColumn = false;

        // start at last position
        // loop down the column as far as needed
        // added condition count < this.winningNumber to stop the loop when
        // count reaches to winning number
        for (int i = this.lastRow - 1; (i >= 0 && !stopColumn && count < this.winningNumber); i--) {
            if (gameState[i][this.lastColumn] != lastPlayer) {
                stopColumn = true;
            } else {
                count++;
            }
        }

        // set winColumn if count of number in a row is greater than winning
        // number
        if (count >= this.winningNumber) {
            winColumns = lastPlayer;
        }

        return winColumns;
    }

    private int detectWinRows() {

        int winRows = -1;
        int lastPlayer = gameState[this.lastRow][this.lastColumn];
        int count = 1; // count of chips in a row
        boolean stopLeft = false; // stop searching to the left
        boolean stopRight = false; // stop searching to the right

        // left size
        // loop starting at lastColumn-1 until out of bounds or stopLeft = false
        // if current position == player
        // increment count
        // else
        // stopLeft = true
        // added condition count < this.winningNumber to stop the loop when count reaches to winning number
        for (int i = lastColumn - 1; (i >= 0 && !stopLeft && count < this.winningNumber); i--) {
            if (gameState[this.lastRow][i] != lastPlayer) {
                stopLeft = true;
            } else {
                count++;
            }
        }

        // right side (similar to left side)
        for (int i = lastColumn + 1; (i < this.columns && !stopRight && count < this.winningNumber); i++) {
            if (gameState[this.lastRow][i] != lastPlayer) {
                stopRight = true;
            } else {
                count++;
            }
        }

        // if count >= winningNumber
        // set winRows to the last player
        if (count >= this.winningNumber) {
            winRows = lastPlayer;
        }

        return winRows;
    }

    private int detectWinDiagonals() {

        int winDiagonals = -1;
        int lastPlayer = gameState[lastRow][lastColumn];
        int countLeftToRight = 1; // count in a row for diagonals from left to
        // right
        int countRightToLeft = 1; // count in a row for diagonals from right to
        // left
        boolean stopLeft1 = false; // stop searching to the left (diagonal left
        // to right)
        boolean stopRight1 = false; // stop searching to the right (diagonal
        // right to left)
        boolean stopLeft2 = false; // stop searching to the left (diagonal left
        // to right)
        boolean stopRight2 = false; // stop searching to the right (diagonal
        // right to left)

        // use winRows code and modify to work with the changing rows
        // diagonal left to right
        for (int i = this.lastRow - 1, j = this.lastColumn - 1; (i >= 0 && j >= 0 && !stopLeft1
                && countLeftToRight < this.winningNumber); i--, j--) {
            if (gameState[i][j] != lastPlayer) {
                stopLeft1 = true;
            } else {
                countLeftToRight++;
            }
        }

        for (int i = this.lastRow + 1, j = this.lastColumn + 1; (i < this.rows && j < this.columns && !stopLeft2
                && countLeftToRight < this.winningNumber); i++, j++) {
            if (gameState[i][j] != lastPlayer) {
                stopLeft2 = true;
            } else {
                countLeftToRight++;
            }
        }

        // diagonal rightToLeft
        for (int i = this.lastRow - 1, j = this.lastColumn + 1; (i >= 0 && j < this.columns && !stopRight1
                && countRightToLeft < this.winningNumber); i--, j++) {
            if (gameState[i][j] != lastPlayer) {
                stopRight1 = true;
            } else {
                countRightToLeft++;
            }
        }

        for (int i = this.lastRow + 1, j = this.lastColumn - 1; (i < this.rows && j >= 0 && !stopRight2
                && countRightToLeft < this.winningNumber); i++, j--) {
            if (gameState[i][j] != lastPlayer) {
                stopRight2 = true;
            } else {
                countRightToLeft++;
            }
        }

        // if countLeftToRight or countRightToLeft >= winningNumber
        // setwinDiagonals to the last player
        if (countRightToLeft >= this.winningNumber || countLeftToRight >= this.winningNumber) {
            winDiagonals = lastPlayer;
        }

        return winDiagonals;
    }

    public void playGame() {

        int turn = 1;
        boolean gameOn = true;

        this.outputGameState();

        while (gameOn) {
            int input = 0;
            boolean validInput = false;

            // output players turn
            System.out.println("Player " + turn + "'s turn:");
            System.out.println("Enter a column number or -1 to quit the current game:");
            String userInput = scanner.next();

            while (!validInput) {
                try {
                    input = Integer.parseInt(userInput);
                    //check if game is full
                    if (this.isGameFull()) {
                        validInput = true;
                        gameOn = false;
                        System.out.println("The Game is Full !!!");
                    }
                    // else check if input == -1
                    // gameOn = false
                    else if (input == -1) {
                        validInput = true;
                        gameOn = false;
                    }
                    // for valid inputs
                    else if (input > 0 && input <= this.columns) {
                        validInput = true;
                        // try to insert chip
                        boolean chipInserted = this.insertChip(turn, input);
                        // if chip was inserted
                        // check for winner
                        if (chipInserted) {
                            this.outputGameState();
                            //check if game is over
                            // output winner
                            // gameOn = false
                            int winner = this.detectWin();
                            if (winner != -1) {
                                System.out.println("Player " + winner + " has won the Game !!!!\n");
                                validInput = true;
                                gameOn = false;
                            }
                            // else
                            // switch turn and output game state
                            else {
                                if (turn == 1) {
                                    turn = 2;
                                } else {
                                    turn = 1;
                                }
                            }
                        } else {
                            System.out.println(
                                    "\nCannot insert a chip in that column. Please enter any other column number.\n");
                        }

                    } else {
                        // while input is not valid
                        // ask for user input
                        System.out.println("\nInvalid input!!");
                        this.outputGameState();
                        System.out.println("Player " + turn + "'s turn:");
                        System.out.println("Enter a column number or -1 to quit the current game:");
                        userInput = scanner.next();
                    }

                } catch (Exception e) {
                    System.out.println("\nInvalid input!!");
                    this.outputGameState();
                    System.out.println("Player " + turn + "'s turn:");
                    System.out.println("Enter a column number or -1 to quit the current game:");
                    userInput = scanner.next();
                }

            }

        }
    }

    public static void main(String args[]) {

        int rows = 6;
        int columns = 7;
        int winningNumber = 4;

        System.out.println("Welcome to ConnectN:");

        if (args.length == 3) {
            // set rows, columns, and winningNumber to the input arguments
            rows = Integer.parseInt(args[0]);
            columns = Integer.parseInt(args[1]);
            winningNumber = Integer.parseInt(args[2]);
        }

        boolean keepPlaying = true;

        while (keepPlaying) {
            ConnectN connectN = new ConnectN(rows, columns, winningNumber);
            connectN.playGame();
            keepPlaying = false;

            boolean validInput = false;

            while (!validInput) {
                // ask if user wants to play again
                // continue loop if he/she does
                System.out.println("Do you want to start new game? (Enter Y for Yes and N for No):");
                String newGame = scanner.next();
                if (newGame.equals("Y") || newGame.equals("y")) {
                    System.out.println("\nNew Game:\nWelcome to ConnectN:");
                    validInput = true;
                    keepPlaying = true;
                } else if (newGame.equals("N") || newGame.equals("n")) {
                    validInput = true;
                    keepPlaying = false;
                    System.out.println("\nExit!!!");
                } else {
                    validInput = false;
                    System.out.println("\n\"" + newGame + "\" is not a valid input");
                }

            }
        }

        scanner.close();
    }
}
