import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.GroupLayout.Group;

public class GroupeAnagram {
    /*
     * 
     * 49. Group Anagrams
     * 
     * Given an array of strings strs, group the
     * anagrams
     * together. You can return the answer in any order.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * 
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 
     * Explanation:
     * 
     * There is no string in strs that can be rearranged to form "bat".
     * The strings "nat" and "tan" are anagrams as they can be rearranged to form
     * each other.
     * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to
     * form each other.
     * Example 2:
     * 
     * Input: strs = [""]
     * 
     * Output: [[""]]
     * 
     * Example 3:
     * 
     * Input: strs = ["a"]
     * 
     * Output: [["a"]]
     * 
     * a really easy explanation of how the code works ->
     * 
     * // ["eat","tea","tan","ate","nat","bat"]
     * // sort([ "aet", "aet", "ant", "aet", "ant", "abt"])
     * // if ("eat".equals(nums[j->i])) -> tempRes = [eat, tea, ate ] -> mark the
     * index to not take the index again
     * // if ("tea".equals(nums[j->i])) -> tempRes =
     * [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] seen = new boolean[strs.length];
        String[] sorted = new String[strs.length];

        /** alle Werte in strs in i position sortieren */
        for (int i = 0; i < strs.length; i++) {
            char[] sortArr = strs[i].toCharArray();
            Arrays.sort(sortArr);
            String temp = "";
            for (int j = 0; j < sortArr.length; j++) {
                temp += sortArr[j];
            }
            sorted[i] = temp;
        }

        for (int i = 0; i < strs.length; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = i; j < strs.length; j++) {

                /**
                 * Vergleiche den Wert an Index i mit dem Wert an Index j im sortierten Array
                 */
                if (sorted[i].equals(sorted[j]) && !seen[j]) {
                    temp.add(strs[j]);
                    seen[j] = true;

                }

            }
            if (temp.size() >= 1) // hier mit vermeiden wir das einfuegen eine leere temp Liste in res
                res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> res = groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
        System.out.println(res);
    }

}
