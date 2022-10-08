public class Leetcode70 {
    public int climbStairs(int n){
        if (n <= 1) return n;
        //这里dp[i]是到i的方法个数，方法个数肯定是继承前面的dp[?]，只是有多个来源
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= dp.length-1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode70().climbStairs(3));
    }
}
