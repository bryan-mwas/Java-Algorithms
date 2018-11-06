import java.util.Arrays;

public class IntegerAlgorithms {
    public static int reverseInt(int n) {
        int reverse = 0;
        while (n > 0) {
            reverse = reverse * 10 + n % 10;
            n /= 10;
        }
        return reverse;
    }

    static int count = 1;

    // This is wrong. Only for educational purposes
    static boolean isPalindrome(int n) {
        System.out.println("Invoked : " + count++ + " times");
        if (n < 0 || n > 999999) {
            System.out.println("Invoked : " + n + " times IF");
            return false;
        } else {
            System.out.println("Invoked : " + n + " times ELSE");
            int reverseInt = reverseInt(n);
            if (n != reverseInt) {
                int newN = n + reverseInt;
                // Ineffective since as soon as the last call in the stack returns false,
                // the func will proceed to return true based of the logic flow.
                isPalindrome(newN);
            }
            return true;
        }
    }

    static boolean isPalindromeOpt(int original, int reverse) {
        return original == reverse;
    }

    static boolean isOrCanBePalindrome(int num) {
        final int maxPalindrome = 1000000;
        while (num < maxPalindrome) {
            int reverse = reverseInt(num);
            boolean isPal = isPalindromeOpt(num, reverse);
            if (isPal) return true;
            num += reverse;
        }
        return false;
    }

    public static int lengthOfLongestSubstring(String s) {
        // Handle nulls
        if (s == null || s.length() == 0) return 0;
        // For every character check if its unique.
        // I assume that the string is in ASCII and it is case sensitive
        // Boolean to track letters
        boolean[] chars = new boolean[128];
        int intermediateLength = 0; // Longest substring tracker
        int highest = 0; // Gotten from Math.max() function
        for (int i = 0; i < s.length(); i++) {
            int value = s.charAt(i);
            if (chars[value]) {
                // Compare to update the highest value
                highest = Math.max(highest, intermediateLength);
                // Reset the tracker to 0 to track the next substring
                intermediateLength = 0;
                // Reinitialize the boolean. To start substring tracking
                chars = new boolean[128];
            }
            intermediateLength++;
            highest = Math.max(highest, intermediateLength);
            chars[value] = true;
        }
        return highest;
    }

    /**
     * Adds one to array
     * Time complexity of O(n)
     */
    public static int[] addOneToArray(int[] numArray) {
        // Validate input
        if (numArray == null || numArray.length == 0) {
            throw new IllegalArgumentException("Please enter valid input.");
        }
        int carry = 1;
        int total;
        for (int i = numArray.length - 1; i >= 0; i--) {
            total = carry + numArray[i];
            if (total == 10) {
                if (i == 0) {
                    numArray = new int[numArray.length + 1];
                    numArray[0] = 1;
                    return numArray;
                }
                System.out.println(Arrays.toString(numArray));
                numArray[i] = total % 10;
            } else {
                carry = 0;
                numArray[i] = total;
            }
        }
        return numArray;
    }

    static void pushZerosToEnd(int arr[], int n) {
        int count = 0;  // Count of non-zero elements

        // Traverse the array. If element encountered is
        // non-zero, then replace the element at index 'count'
        // with this element
        for (int i = 0; i < n; i++)
            if (arr[i] != 0) {
                arr[count++] = arr[i]; // here count is
                System.out.println("Arr" + arr[i] + " count" + count);
                System.out.println("Arr" + Arrays.toString(arr));
            }
        // incremented

        // Now all non-zero elements have been shifted to
        // front and 'count' is set as index of first 0.
        // Make all elements 0 from count to end.
        while (count < n)
            arr[count++] = 0;
    }
}
