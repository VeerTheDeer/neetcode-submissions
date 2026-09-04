class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Checking Rows
        for(int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.') {
                    continue;
                } else if(set.contains(board[i][j])) {
                    return false;
                } else {
                    set.add(board[i][j]);
                }
            }
        }

        //Checking Columns
        for(int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < board[i].length; j++) {
                if(board[j][i] == '.') {
                    continue;
                } else if(set.contains(board[j][i])) {
                    return false;
                } else {
                    set.add(board[j][i]);
                }
            }
        }

        for (int rowStart = 0; rowStart < 9; rowStart += 3) {
            for (int colStart = 0; colStart < 9; colStart += 3) {
                Set<Character> set = new HashSet<>();
                
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char current = board[rowStart + i][colStart + j];
                        
                        if (current == '.') {
                            continue;
                        } else if (set.contains(current)) {
                            return false;
                        } else {
                            set.add(current);
                        }
                    }
                }
            }
        }

        return true;
    }
}
