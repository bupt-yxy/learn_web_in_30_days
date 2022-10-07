import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] num, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin: num) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1+dp[i-coin]);
            }
        }
        System.out.println("dp = " + Arrays.toString(dp));
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
