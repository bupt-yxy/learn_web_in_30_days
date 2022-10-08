import java.util.PriorityQueue;

public class Leetcode313 {
//    public int nthSuperUglyNumber(int n, int[] primes) {
//        int[] pt = new int[primes.length];
//        int[] dp = new int[n];
//        dp[0] = 1;
//        for (int i = 1;i < n;i++){
//            int min = Integer.MAX_VALUE;
//            for(int j = 0;j < primes.length;j++){
//                min = Math.min(primes[j]*dp[pt[j]],min);
//            }
//            for (int k = 0;k < primes.length;k++){
//                if (min == primes[k]*dp[pt[k]]) pt[k]++;
//            }
//            dp[i] = min;
//        }
//        return dp[n-1];
//    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> queue=new PriorityQueue<>();
        long res=1;
        for(int i=1;i<n;i++){
            for(int prime:primes){
                queue.add(prime*res);
            }
            res=queue.poll();
            while(!queue.isEmpty()&&res==queue.peek()) queue.poll();
        }
        return (int)res;
    }
    public static void main(String[] args){
        int[] prime = {2,7,13,19};
        int n = 12;
        System.out.println(new Leetcode313().nthSuperUglyNumber(n,prime));

    }
}
