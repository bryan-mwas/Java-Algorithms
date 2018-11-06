import org.junit.Test;

import java.util.Arrays;

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
    public void longestSubstring() {
        final int actual = IntegerAlgorithms.lengthOfLongestSubstring("geeksforgeeks");
        final int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void longestSubstringCaseSensitive() {
        final int actual = IntegerAlgorithms.lengthOfLongestSubstring("qwerty");
        final int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void longestSubstringTrickyCase() {
        final int actual = IntegerAlgorithms.lengthOfLongestSubstring("advdfg");
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void addOneToArray() {
        final int[] actual = IntegerAlgorithms.addOneToArray(new int[]{1, 2, 9});
        final int[] expected = new int[]{1, 3, 0};
        assertEquals(expected, actual);
    }

    @Test
    public void longestSubstringReturns0ForNulls() {
        final int actual = IntegerAlgorithms.lengthOfLongestSubstring(null);
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void priceStaysTheSameAllDayTest() {
        final int actual = getMaxProfit(new int[]{1, 1, 1, 1});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void whenCallSubstring_thenCorrect() {
        String s = "Welcome to Testing";

        assertEquals("Welcome", s.substring(0, 7));
    }

    @Test
    public void reverseString() {
        final String actual = ArrayStrings.reverseString("aba");
        final String reverse = "aba";
        assertEquals(reverse, actual);
    }

    @Test
    public void testIsPalindrome() {
        final boolean actual = "aba".equals(ArrayStrings.reverseString("aba"));
        final boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void whenCallSubSequence_thenCorrect() {
        String s = "Welcome to Testing";

        assertEquals("Welcome", s.subSequence(0, 7));
    }

    @Test(expected = Exception.class)
    public void exceptionWithOnePriceTest() {
        getMaxProfit(new int[]{5});
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyPricesTest() {
        getMaxProfit(new int[]{});
    }

    public static String checkIfSmoothArray(int n , int [] arr) {
        boolean diffIs1 = false;
        for(int i = 0; i < arr.length; i++) {
            if(i+1 < arr.length) {
                diffIs1 = java.lang.Math.abs(arr[i + 1] - arr[i]) <= 1;
                System.out.println(java.lang.Math.abs(arr[i + 1] - arr[i]));
                if(!diffIs1) {
                    break;
                }
            }
        }
        if(diffIs1) return "YES";
        else return "NO";
    }

    @Test
    public void testSmoothArray() {
        final String actual = checkIfSmoothArray(4 ,new int[]{1,1,8,2});
        final String expected = "NO";
        assertEquals(expected, actual);
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
        System.out.println(getMaxProfit(stockPrices));
        System.out.println(getMaxProfit(new int[]{9, 7, 4, 1}));
        System.out.println(getMaxProfitOpt(new int[]{9, 7, 4, 1}));
        System.out.println("Opt: " + getMaxProfitOpt(new int[]{7, 2, 8, 9}));
        System.out.println("Opt: " + IntegerAlgorithms.isOrCanBePalindrome(999998));
        System.out.println("Opt: " + IntegerAlgorithms.isOrCanBePalindrome(10989));
        System.out.println("Caesar Cipher: " + ArrayStrings.caesarCipher("1:some test"));
        System.out.println("Permutation Palindrome: " + ArrayStrings.isPermutationPalindrome("icivc"));

        System.out.println("Array: " + Arrays.toString(IntegerAlgorithms.addOneToArray(new int[]{9, 9})));
        System.out.println("Array: " + Arrays.toString(IntegerAlgorithms.addOneToArray(new int[]{1, 3, 2, 4})));

        int arr[] = {1, 0, 0, 0, 4, 5, 6, 8};
        int n = arr.length;
        IntegerAlgorithms.pushZerosToEnd(arr, n);
        System.out.println("Array after pushing zeros to the back: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
