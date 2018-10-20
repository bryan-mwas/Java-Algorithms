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
}
