import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class Main {

    /**
     * This is a brute force implementation to get the highest profit one can get after buying a stock.
     * The indices indicate the buying/selling time.
     * This implementation however has a time complexity of o(n^2), due to the nested loops.
     * The inner loop sequence is n+1, n+2, ...
     *
     * @param stockPrices
     * @return
     */
    private static int getMaxProfit(int[] stockPrices) {
        // calculate the max profit
        // Buffer to store tmp profit
        // However if we want a negative profit, say everything is a loss on a particular day.
        // initializing profit to 0 is a bad idea; the function will always return 0
        int profit = stockPrices[1] - stockPrices[0];
        for (int i = 0; i < stockPrices.length; i++) {
            for (int j = i + 1; j < stockPrices.length; j++) {
                int tmp = stockPrices[j] - stockPrices[i];
                System.out.println("TEMP " + tmp);
                if (tmp > profit) profit = tmp;
            }
        }

        return profit;
    }

    /**
     * Greedy implementation of getMaxProfit()
     * Has a Big O(n) and space complexity of O(1)
     *
     * @param stockPrices
     * @return
     */
    private static int getMaxProfitOpt(int[] stockPrices) {

        // In case of less than two prices initial buy and corresponding sell
        // An out of bound error will occur. Mitigate this with a check.
        if (stockPrices.length < 2) {
            throw new IllegalArgumentException("Getting profit requires at least two sales.");
        }

        int minPrice = stockPrices[0];
        int profit = stockPrices[1] - stockPrices[0];

        // It is essential that the iteration starts at 1 since one must buy
        // before selling. Starting at 0 is synonymous to buying and selling
        // at the same time.
        for (int i = 1; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];
            int potentialProfit = currentPrice - minPrice;
            System.out.println("Potential profit @ " + potentialProfit);
            profit = Math.max(profit, potentialProfit);
            minPrice = Math.min(minPrice, currentPrice);
            System.out.println("Intermediate profit @ " + profit);
        }

        return profit;
    }


    @Test
    public void priceGoesUpThenDownTest() {
        final int actual = getMaxProfit(new int[]{1, 5, 3, 2});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownThenUpTest() {
        final int actual = getMaxProfit(new int[]{7, 2, 8, 9});
        final int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownThenUpTestOpt() {
        final int actual = getMaxProfitOpt(new int[]{7, 2, 8, 9});
        final int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesUpAllDayTest() {
        final int actual = getMaxProfit(new int[]{1, 6, 7, 9});
        final int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownAllDayTest() {
        final int actual = getMaxProfit(new int[]{9, 7, 4, 1});
        final int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownAllDayTestOpt() {
        final int actual = getMaxProfitOpt(new int[]{9, 7, 4, 1});
        final int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    public void priceStaysTheSameAllDayTest() {
        final int actual = getMaxProfit(new int[]{1, 1, 1, 1});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithOnePriceTest() {
        getMaxProfit(new int[]{5});
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyPricesTest() {
        getMaxProfit(new int[]{});
    }

    public static void main(String[] args) {
        System.out.println(ArrayStrings.isUniqueString("alice"));
        System.out.println(ArrayStrings.stringCompress("aaaaaaaaaaaaliccccce"));
        System.out.println(ArrayStrings.stringCompress("aaaaAAAAaliccccce"));
        System.out.println(ArrayStrings.stringCompressInefficient("aabcccccaaa"));
        System.out.println(ArrayStrings.stringCompressInefficient("aAbcccccaaa"));
        System.out.println(Recursion.factorial(10));
        System.out.println(ArrayStrings.isPermutation("little     ", "little"));
        System.out.println(ArrayStrings.isPermutation("boy", "yob"));
        System.out.println(ArrayStrings.permutation("dad", "add"));
        System.out.println(ArrayStrings.isPermutation("boy", "ytb"));
        System.out.println(ArrayStrings.urlify("Mr John Smith  "));
        int[] stockPrices = new int[]{10, 7, 5, 8, 11, 9};
        ArrayStrings.reverseString("Hellooo");
        System.out.println(getMaxProfit(stockPrices));
        System.out.println(getMaxProfit(new int[]{9, 7, 4, 1}));
        System.out.println(getMaxProfitOpt(new int[]{9, 7, 4, 1}));
        System.out.println("Opt: " + getMaxProfitOpt(new int[]{7, 2, 8, 9}));
        System.out.println("Opt: " + IntegerAlgorithms.isOrCanBePalindrome(999998));
        System.out.println("Opt: " + IntegerAlgorithms.isOrCanBePalindrome(10989));
    }
}
