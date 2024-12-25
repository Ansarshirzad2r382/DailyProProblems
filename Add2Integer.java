class Add2Integer {
    /*
     * Add Strings
     * 
     * Given two non-negative integers, num1 and num2 represented as string, return
     * the sum of num1 and num2 as a string.
     * you must solve the problem by using logical operators.
     * 
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: num1 = "11", num2 = "123"
     * Output: "134"
     * Example 2:
     * 
     * Input: num1 = "456", num2 = "77"
     * Output: "533"
     * Example 3:
     * 
     * Input: num1 = "0", num2 = "0"
     * Output: "0"
     * 
     */

    public static String addStrings(String num1, String num2) {
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);

        while (n2 != 0) {
            long temp = (n1 & n2) << 1;
            n1 = n1 ^ n2;
            n2 = temp;

        }
        return String.valueOf(n1);
    }

    public static void main(String[] args) {
        String erg = addStrings("4", "3");
        System.out.println(erg);
    }
}