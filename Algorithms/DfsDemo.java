public class DfsDemo {
    public void dfs(int i, int[][] getConnected, boolean[] visited) {
        visited[i] = true;
        System.out.println("visit==> " + i);
        for (int j = 0;j < getConnected.length;j++){
            if (getConnected[i][j] == 1 && !visited[j])
                dfs(j, getConnected, visited);
        }
    }

    public static void main(String[] args) {
        int[][] getConnected = {{1,0,1,0,0,0},{0,1,0,0,0,1},{1,0,1,0,0,1},{0,0,0,1,1,0},{0,0,0,1,1,0},{0,1,1,0,0,1}};
        int N = getConnected.length;
        boolean[] visited = new boolean[N];
        int cnt = 0;
        for (int i = 0;i < N;i++) {
            if (!visited[i])
                cnt++;
                new DfsDemo().dfs(i, getConnected, visited);
        }
        System.out.println("cnt = " + cnt); //不连通的区域个数
    }
}
