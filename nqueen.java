public class nqueen {
    static int count = 0;

    public static void main(String[] args) {
        int n = 8; // You can change the value of n here

        int[][] mat = new int[n][n];
        mat[0][1] = 1;

        nQueens(mat, 1, n);

        if (count == 0) {
            System.out.println("No solution for n=" + n);
        } else {
            System.out.println("Total solutions: " + count);
        }
    }

    public static void printMat(int[][] mat, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] mat, int row, int col, int n) {
        // Check the same column
        for (int i = 0; i < row; i++) {
            if (mat[i][col] == 1) {
                return false;
            }
        }

        // Check the right upper diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (mat[i][j] == 1) {
                return false;
            }
        }

        // Check the left upper diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void nQueens(int[][] mat, int row, int n) {
        if (row == n) {
            count++;
            System.out.println("Solution " + count);
            printMat(mat, n);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(mat, row, i, n)) {
                mat[row][i] = 1;
                nQueens(mat, row + 1, n);
                mat[row][i] = 0;
            }
        }
    }
}