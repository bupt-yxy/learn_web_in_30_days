import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode77 {

    List<List<Integer>> result;
    LinkedList<Integer> path;

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        path = new LinkedList<>();
        backtrack(n, k, 1);
        return result;
    }

    public void backtrack(int n, int k, int start) {
        if (path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            backtrack(n, k, i+1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode77().combine(4,2));
    }
}
