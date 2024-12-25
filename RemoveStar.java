import java.util.Stack;

public class RemoveStar {

    /*
     * Removing Stars From a String
     * 
     * Choose a star in s.
     * Remove the closest non-star character to its left, as well as remove the star
     * itself.
     * Return the string after all stars have been removed.
     * 
     * Note:
     * 
     * The input will be generated such that the operation is always possible.
     * It can be shown that the resulting string will always be unique.
     * 
     * important: so the problem is about to remove the star and the left character
     * when we get to a star,
     * if we dont have any character befor the star then we we only remove the
     * start.
     * 
     * let's take a look at the following exp:
     * 
     * Example 1:
     * 
     * Input: s = "leet**cod*e"
     * Output: "lecoe"
     * Explanation: Performing the removals from left to right:
     * - The closest character to the 1st star is 't' in "leet**cod*e". s becomes
     * "lee*cod*e".
     * - The closest character to the 2nd star is 'e' in "lee*cod*e". s becomes
     * "lecod*e".
     * - The closest character to the 3rd star is 'd' in "lecod*e". s becomes
     * "lecoe".
     * There are no more stars, so we return "lecoe".
     * 
     */

    public static String rmeoveStars(String s) {
        Stack<Character> st = new Stack<>();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*' && !st.isEmpty()) {
                char c = st.pop();
            } else if (s.charAt(i) != '*') {
                st.push(s.charAt(i));
            }
        }
        while (!st.isEmpty()) {

            res = st.pop() + res;
        }
        return res;

    }

    public static void main(String[] args) {

        String res = rmeoveStars("leet**cod*e");
        System.out.println(res);
    }

}
