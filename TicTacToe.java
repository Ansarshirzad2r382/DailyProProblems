import java.util.*;

public class TicTacToe {
    public static char[][] gameBoard = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };

    // Überprüft, ob der Zug gültig ist
    public static boolean isValidMove(int row, int column) {
        return row >= 0 && row < gameBoard.length &&
                column >= 0 && column < gameBoard[0].length &&
                gameBoard[row][column] == ' ';
    }

    // Druckt das Spielbrett
    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    // Überprüft, ob ein Spieler gewonnen hat
    public static boolean isWon(int row, int column) {
        char player = gameBoard[row][column];

        // Überprüfe Zeile
        if (gameBoard[row][0] == player && gameBoard[row][1] == player && gameBoard[row][2] == player) {
            return true;
        }

        // Überprüfe Spalte
        if (gameBoard[0][column] == player && gameBoard[1][column] == player && gameBoard[2][column] == player) {
            return true;
        }

        // Überprüfe Diagonale
        if (row == column && gameBoard[0][0] == player && gameBoard[1][1] == player && gameBoard[2][2] == player) {
            return true;
        }
        if (row + column == 2 && gameBoard[0][2] == player && gameBoard[1][1] == player && gameBoard[2][0] == player) {
            return true;
        }

        return false;
    }

    // Führt den Zug des Spielers X aus
    public static void playX(int row, int column) {
        if (!isValidMove(row, column)) {
            return;
        }
        gameBoard[row][column] = 'X';
    }

    // Führt den Zug des Spielers O aus
    public static void playO(int row, int column) {
        if (!isValidMove(row, column)) {
            return;
        }
        gameBoard[row][column] = 'O';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row, column;

        // Schleife, bis das Spiel beendet ist
        while (true) {
            // Drucke das Spielbrett
            printBoard(gameBoard);

            // Eingabe des Spielers X
            System.out.println("Spieler X: Zeile und Spalte eingeben (z.B. 0 1):");
            row = sc.nextInt();
            column = sc.nextInt();
            playX(row, column);

            // Überprüfe, ob Spieler X gewonnen hat
            if (isWon(row, column)) {
                printBoard(gameBoard);
                System.out.println("Spieler X hat gewonnen!");
                break;
            }

            // Drucke das Spielbrett
            printBoard(gameBoard);

            // Eingabe des Spielers O
            System.out.println("Spieler O: Zeile und Spalte eingeben (z.B. 1 2):");
            row = sc.nextInt();
            column = sc.nextInt();
            playO(row, column);

            // Überprüfe, ob Spieler O gewonnen hat
            if (isWon(row, column)) {
                printBoard(gameBoard);
                System.out.println("Spieler O hat gewonnen!");
                break;
            }
        }
        sc.close();
    }
}
