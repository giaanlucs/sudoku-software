package Sodoku;

import java.util.Scanner;

public class Sodoku {

    static int[][] board = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printBoard();

        while (true) {
            System.out.println("Digite a linha, coluna e o número (1-9) para inserir:");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;
            int num = scanner.nextInt();

            if (isValidMove(row, col, num)) {
                board[row][col] = num;
                printBoard();
                if (isSolved()) {
                    System.out.println("Parabéns, você completou o Sudoku!");
                    break;
                }
            } else {
                System.out.println("Movimento inválido! Tente novamente.");
            }
        }

        scanner.close();
    }

    public static boolean isValidMove(int row, int col, int num) {
        // Verificar se o número já está na linha
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Verificar se o número já está na coluna
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Verificar se o número já está na subgrade 3x3
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printBoard() {
        System.out.println("Tabuleiro atual:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] == 0 ? " . " : " " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSolved() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}

