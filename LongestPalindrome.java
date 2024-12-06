public class LongestPalindrome {
    // Longest Palindromic Substring
    /*
     * Given a string s, return the longest
     * palindromic
     * 
     * substring
     * in s.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * Example 2:
     * 
     * Input: s = "cbbd"
     * Output: "bb"
     */

    // The approach for this problem is as follows:
    // Since we need to check for palindromes starting from each character
    // (from the ith position to the end of the string), we require two loops.

    // The goal is to find the longest palindrome substring. For this:
    // - We first extract a temporary substring (temp) starting from index i to j.
    // - Then, we check if the temp substring is a palindrome using the isPal
    // function.
    // - If temp is a palindrome and its length is greater than the current res
    // string
    // (which stores the longest palindrome found so far), we update res to temp.

    // This process continues for every possible starting position i in the string.
    // The result is the longest palindrome substring stored in res.

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            for (int j = i; j < s.length(); j++) {
                temp += s.charAt(j);

                if (isPal(temp) && res.length() < temp.length()) {
                    res = temp;
                }
            }
        }
        return res;
    }

    public boolean isPal(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
