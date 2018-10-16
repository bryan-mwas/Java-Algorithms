public class Main {
    public static void main(String[] args) {
        System.out.println(ArrayStrings.isUniqueString("alice"));
        System.out.println(ArrayStrings.stringCompress("aaaaaaaaaaaaliccccce"));
        System.out.println(ArrayStrings.stringCompress("aaaaAAAAaliccccce"));
        System.out.println(ArrayStrings.stringCompressInefficient("aabcccccaaa"));
        System.out.println(ArrayStrings.stringCompressInefficient("aAbcccccaaa"));
        System.out.println(Recursion.factorial(10));
        System.out.println(ArrayStrings.isPermutation("little     ","little"));
        System.out.println(ArrayStrings.isPermutation("boy","yob"));
        System.out.println(ArrayStrings.permutation("dad","add"));
        System.out.println(ArrayStrings.isPermutation("boy","ytb"));
    }
}
