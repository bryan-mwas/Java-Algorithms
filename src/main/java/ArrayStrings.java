import java.util.Arrays;

class ArrayStrings {
    /**
     * Checks if a provided string has all unique characters.
     *
     * @param s
     * @return
     */
    static boolean isUniqueString(String s) {
        // Limit length to 128
        if (s.length() > 128) return false;
        else {
            boolean charSet[] = new boolean[128];
            for (int i = 0; i < s.length(); i++) {
                System.out.println(s.charAt(i) + " at index " + i);
                int charValue = s.charAt(i);
                if (charSet[charValue]) {
                    return false;
                }
                charSet[charValue] = true;
            }
        }
        return true;
    }

    /**
     * Reduces the String size by replacing repetitive letters with count value.
     *
     * @param str BIG O(n + c^2), where n is the length of original string and c is the
     *            number of character sequences
     * @return
     */
    static String stringCompressInefficient(String str) {
        String compressed = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                // Inefficient as this copy the whole String to a new onw
                compressed += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed : str;
    }

    /**
     * Reduces the String size by replacing repetitive letters with count value.
     *
     * @param str BIG O(n)
     * @return
     */
    static String stringCompress(String str) {
        // The string builder is efficient than using a normal string
        // It creates a resizable array of all strings and copies them back to a string when necessary
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    static boolean isPermutation(String a, String b) {
        if (a.length() != b.length())
            return false;
        else {
            return sort(a).equals(sort(b));
        }
    }

    static boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] letters = new int[128];

        char[] chars = s.toCharArray();
        for (char c : chars) {
            letters[c]++;
            System.out.println("Increment: " + letters[c]);
        }

        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            letters[c]--;
            System.out.println("Decrement " + letters[c]);
            if (letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
     * has sufficient space at the end to hold the additional characters, and that you are given the "true"
     * length of the string. (Note: If implementing in Java, please use a character array so that you can
     * perform this operation in place.)
     */
    static char[] urlify(char[] str, int trueLength) {
        int spaceCount = 0, index, i;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + (spaceCount * 2);
        System.out.println("Index: " + index);
        if (trueLength < str.length) str[trueLength] = '\0'; // end array
        for (i = trueLength - 1; i > 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                char c = str[i];
                System.out.println("Index!!: " + i);
                str[index - 1] = c;
                index--;
            }
        }
        return str;
    }

    static String urlify(String string) {
        string = string.trim(); // Remove prevailing or trailing whitespace
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ')
                stringBuilder.append("%20");
            else
                stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int a = s.length() - 1; a >= 0; a--) {
            stringBuilder.append(s.charAt(a));
        }
        return stringBuilder.toString();
    }


    /**
     * This only works for the following cases,
     * Cases to work on
     *
     * @param s
     * @return
     */
    static String caesarCipher(String s) {
        // Validation
        if (s == null) {
            return null;
        }
        // Split the string based on :
        String splitString[] = s.split(":");
        int cipher = Integer.parseInt(splitString[0]);
        System.out.println("Cipher " + cipher);
        String actual = splitString[1];
        System.out.println(actual);
        if (cipher < -1000000000 || cipher > 1000000000) return null;
        int stringShift = cipher % 26;
        int integerShift = cipher % 10;
        System.out.println("Cipher int " + integerShift);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < actual.length(); i++) {
            if (actual.charAt(i) >= 'A' && actual.charAt(i) <= 'Z' ||
                    actual.charAt(i) >= 'a' && actual.charAt(i) <= 'z' ||
                    actual.charAt(i) >= '0' && actual.charAt(i) <= '9') {
                if (actual.charAt(i) >= '0' && actual.charAt(i) <= '9') {
                    char number = (char) (actual.charAt(i) + integerShift);
                    System.out.println("Number :" + actual.charAt(i) + integerShift);
                    if (number > '9') {
                        number = (char) (number - 10);
                    } else if (number < '0') {
                        number = (char) (number + 10);
                    }
                    result.append(number);
                    System.out.println("Output number: " + number);
                } else {
                    char letter = (char) (actual.charAt(i) + stringShift);
                    System.out.println("String :" + (actual.charAt(i) + stringShift));
                    if (letter > 'z') {
                        letter = (char) (letter - 26);
                    } else if (letter < 'a') {
                        letter = (char) (letter + 26);
                    }
                    result.append(letter);
                    System.out.println("Output letter: " + letter);
                }
            } else {
                result.append(actual.charAt(i));
            }
        }
        return result.toString();
    }

    static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    /**
     * Permutation of a palindrome
     */
    static boolean isPermutationPalindrome(String str) {
        // Validation
        if (str == null || str.length() > 128) return false;
        // A string must have at least one odd character count for
        // it to be considered a permutation of a palindrome
        // Introduce a hash table
        int chars[] = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        // Track the odd count state.
        int countOdd = 0;
        for (char c : str.toCharArray()) {
            int numericValue = getCharNumber(c);
            chars[numericValue]++;
            if (chars[numericValue] % 2 == 1) {
                countOdd++;
            } else {
                countOdd--;
            }
        }

        return countOdd <= 1;
    }


}
