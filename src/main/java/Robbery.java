public class Robbery {
    /**
     * This function depicts dynamic programming
     * @param num
     * @return
     */
    public static int rob(int[] num) {
        int[] dp = new int[num.length + 1];

        dp[0] = 0;
        dp[1] = num[0];

        for (int i = 2; i <= num.length; i++) {
            if (dp[i - 1] > dp[i - 2] + num[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 2] + num[i - 1];
            }
        }

        return dp[num.length];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] { 1, 9, 0, 2, 44, 45, 50, 32 }));
    }
}
