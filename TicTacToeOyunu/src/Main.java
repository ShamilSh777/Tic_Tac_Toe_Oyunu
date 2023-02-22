import java.util.Scanner;

class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLUMNS = 3;
    private static char[][] board = new char[ROWS][COLUMNS];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        initializeBoard();

        while (!isGameOver()) {
            displayBoard();
            System.out.print("1ci Oyuncu " + currentPlayer + ",Gedish Edin (setir[1-" + ROWS + "] xana[1-" + COLUMNS + "]): ");
            System.out.println();
            int row = input.nextInt() - 1;
            int column = input.nextInt() - 1;
            if (row >= 0 && row < ROWS && column >= 0 && column < COLUMNS && board[row][column] == ' ') {
                board[row][column] = currentPlayer;
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';  //
            } else {
                System.out.println("Yalnish Gedish! Yeniden Ceht Edin.");
            }
        }

        displayBoard();
        char winner = (currentPlayer == 'X') ? 'O' : 'X';
        System.out.println("Oyuncu " + winner + " Qalib Geldi!");
    }

    private static void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                System.out.print(" " + board[i][j] + " |");
            }
            System.out.println();
            System.out.println("---+---+---");
        }
        System.out.println();
    }
    private static boolean isDraw() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isGameOver() {
        return isWinning('X') || isWinning('O') || isDraw();
    }

    private static boolean isWinning(char player) {
        // Check rows
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }


        // Check columns
        for (int j = 0; j < COLUMNS; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
        }
        return false;
    }
        }


