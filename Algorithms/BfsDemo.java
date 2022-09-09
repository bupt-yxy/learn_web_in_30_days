import java.util.LinkedList;
import java.util.Queue;

public class BfsDemo {
    public void bfs(int[][] getConnected) {
        int N = getConnected.length;
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < N;i++) {
            if (!visited[i]) {
                visited[i] = true;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    System.out.println("访问： " + v);
                    for (int w = 0;w < N;w++) {
                        if (getConnected[v][w] == 1 && !visited[w]) {
                            visited[w] = true;
                            queue.offer(w);
                            System.out.println(v + "的邻居有： " + w);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] getConnected = {{1,1,1,1,0,0},{1,1,0,0,0,0},{1,0,1,0,0,0},{1,0,0,1,1,1},{0,0,0,1,1,0},{0,0,0,1,0,1}};
        new BfsDemo().bfs(getConnected);
    }
}
