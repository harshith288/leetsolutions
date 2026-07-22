class Solution {
    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];

        for (int i = 0; i < moves.length; i++) {
            int row = moves[i][0];
            int col = moves[i][1];

            char player = (i % 2 == 0) ? 'X' : 'O';
            board[row][col] = player;

            if (won(board, player)) {
                return player == 'X' ? "A" : "B";
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

    private boolean won(char[][] board, char p) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == p && board[i][1] == p && board[i][2] == p)
                return true;

            if (board[0][i] == p && board[1][i] == p && board[2][i] == p)
                return true;
        }

        if (board[0][0] == p && board[1][1] == p && board[2][2] == p)
            return true;

        if (board[0][2] == p && board[1][1] == p && board[2][0] == p)
            return true;

        return false;
    }
}