class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        if (board.length * board[0].length < word.length()) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (word.length() == 1) return true;
                    else  {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        if (isValid(board, visited, word, 0, i, j)) return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, boolean[][] visited, String word, int start, int i, int j) {
        if (start == word.length()) return true;
        if (!positionValid(board, i, j) || visited[i][j] || board[i][j] != word.charAt(start)){
            return false;
        }
        visited[i][j] = true;
        boolean result = isValid(board, visited, word, start + 1, i - 1, j) ||
                isValid(board, visited, word, start + 1, i + 1, j) ||
                isValid(board, visited, word, start + 1, i, j - 1) ||
                isValid(board, visited, word, start + 1, i, j + 1);
        //这道题的重点就在这里！！！记得把visited set回去呀！！！因为再遍历的时候又是新的一轮！！！
        visited[i][j] = false;
        return result;
    }

    private boolean positionValid(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
