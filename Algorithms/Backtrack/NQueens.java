import java.util.*;

public class NQueens {
	List<List<String>> res = new ArrayList<>();
	public List<List<String>> solveNQueen(int n){
		char[][] board = new char[n][n];
		for(char[] i : board)
			Arrays.fill(i,'.');
		backtrack(board, 0);
		return res;
	}
	public void backtrack(char[][] board,int row) {
		if(row == board.length) {
			res.add(array2List(board));
			return;
		}
		for(int j = 0;j < board.length;j++) {
			if(!isValid(board,row,j)) {
				continue;
			}
			board[row][j] = 'Q';
			backtrack(board, row + 1);
			board[row][j] = '.';
		}
	}
	
    List<String> array2List(char[][] board){
        List<String> res = new LinkedList<>();
        for (char[] i : board){
            StringBuffer sb = new StringBuffer();
            for (char j : i){
                sb.append(j);
            }
            res.add(sb.toString());
        }
        return res;
    }
	
	public boolean isValid(char[][] board,int row,int col) {
		int N = board.length;
		//同一列 下面的还没放不用判断
		for(int i = 0;i < row;i++) {
			if(board[i][col] == 'Q')
				return false;
		}
		//判断左上角
		for(int i = row-1,j = col-1;i >= 0 && j >=0;i--,j--) {
			if(board[i][j] == 'Q')
				return false;
		}
		//判断右上角
		for(int i = row-1,j = col+1;i >= 0 && j < N;i--,j++) {
			if(board[i][j] == 'Q')
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int n = 8;
		int cnt = 0;
		List<List<String>> ans = new NQueens().solveNQueen(n);
		for(List<String> string : ans) {
			cnt++;
		}
		System.out.println(ans);
		System.out.println("共有" + cnt + "个解。");
	}
}
