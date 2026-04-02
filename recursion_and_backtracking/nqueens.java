import java.util.*;

class NQueens {

    // Solve all solutions
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        int[] board = new int[n];
        boolean[] columns = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        backtrackAll(0, n, board, columns, diag1, diag2, result);
        return result;
    }

    private void backtrackAll(int row, int n, int[] board,
                              boolean[] columns, boolean[] diag1, boolean[] diag2,
                              List<List<String>> result) {

        if (row == n) {
            result.add(buildBoard(board, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (columns[col] || diag1[row + col] || diag2[row - col + n - 1])
                continue;

            board[row] = col;
            columns[col] = true;
            diag1[row + col] = true;
            diag2[row - col + n - 1] = true;

            backtrackAll(row + 1, n, board, columns, diag1, diag2, result);

            columns[col] = false;
            diag1[row + col] = false;
            diag2[row - col + n - 1] = false;
        }
    }

    // Solve only ONE solution
    public List<String> solveOne(int n) {
        int[] board = new int[n];
        boolean[] columns = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        if (backtrackOne(0, n, board, columns, diag1, diag2)) {
            return buildBoard(board, n);
        }
        return new ArrayList<>();
    }

    private boolean backtrackOne(int row, int n, int[] board,
                                 boolean[] columns, boolean[] diag1, boolean[] diag2) {

        if (row == n) return true;

        for (int col = 0; col < n; col++) {
            if (columns[col] || diag1[row + col] || diag2[row - col + n - 1])
                continue;

            board[row] = col;
            columns[col] = true;
            diag1[row + col] = true;
            diag2[row - col + n - 1] = true;

            if (backtrackOne(row + 1, n, board, columns, diag1, diag2))
                return true;

            columns[col] = false;
            diag1[row + col] = false;
            diag2[row - col + n - 1] = false;
        }
        return false;
    }

    // Solve with forbidden cells
    public List<List<String>> solveWithForbidden(int n, boolean[][] forbidden) {
        List<List<String>> result = new ArrayList<>();

        int[] board = new int[n];
        boolean[] columns = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];

        backtrackForbidden(0, n, board, columns, diag1, diag2, forbidden, result);
        return result;
    }

    private void backtrackForbidden(int row, int n, int[] board,
                                    boolean[] columns, boolean[] diag1, boolean[] diag2,
                                    boolean[][] forbidden,
                                    List<List<String>> result) {

        if (row == n) {
            result.add(buildBoard(board, n));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (forbidden[row][col]) continue;

            if (columns[col] || diag1[row + col] || diag2[row - col + n - 1])
                continue;

            board[row] = col;
            columns[col] = true;
            diag1[row + col] = true;
            diag2[row - col + n - 1] = true;

            backtrackForbidden(row + 1, n, board, columns, diag1, diag2, forbidden, result);

            columns[col] = false;
            diag1[row + col] = false;
            diag2[row - col + n - 1] = false;
        }
    }

    private List<String> buildBoard(int[] board, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[board[i]] = 'Q';
            res.add(new String(row));
        }
        return res;
    }
}