class Solution {

    int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public boolean exist(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(grid, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, String word, int row, int col, int index, boolean[][] visited) {

        // Goal condition
        if (index == word.length()) {
            return true;
        }

        // Boundary + constraints
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return false;

        if (visited[row][col])
            return false;

        if (grid[row][col] != word.charAt(index))
            return false;

        // Choose
        visited[row][col] = true;

        // Explore all 8 directions
        for (int d = 0; d < 8; d++) {
            int newRow = row + dr[d];
            int newCol = col + dc[d];

            if (dfs(grid, word, newRow, newCol, index + 1, visited)) {
                return true;
            }
        }

        // Backtrack
        visited[row][col] = false;

        return false;
    }
}