import java.util.HashSet;
import java.util.Set;

class LongestSubwit_RepCha {
    /*
     * Aufgabestellung:
     * Given a string s, find the length of the longest
     * substring
     * without repeating characters.
     * 
     * 
     * 
     * Example 1:
     * 
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * 
     * Input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * 
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a
     * substring.
     * 
     */
    public int lengthOfLongestSubstring(String s) {
        int erg = 0;
        for (int i = 0; i < s.length(); ++i) {
            String temp = ""; // Temporärer String
            boolean isvalid = true;
            for (int j = i; j < s.length() && isvalid; j++) {
                temp += s.charAt(j); // Zeichen zu temp hinzufügen

                // Überprüfe den zuletzt hinzugefügten Charakter
                if (checkDup(temp, temp.charAt(temp.length() - 1))) {
                    erg = Math.max(erg, temp.length());
                } else {
                    isvalid = false;
                }
            }
        }
        return erg;
    }

    public boolean checkDup(String a, char tar) {
        int count = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (a.charAt(i) == tar) {
                count++;
                if (count > 1) {
                    return false; // Mehr als ein Vorkommen gefunden
                }
            }
        }
        return count == 1; // True, wenn genau ein Vorkommen existiert
    }

    // Loesung 2 mit O(N^2) in dem wir Set benutzen
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                // wenn der subset diese zahl enthaelt ,dann entfernen wird left zahl und gehen
                // wir um 1 weiter.
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubwit_RepCha a = new LongestSubwit_RepCha();
        int erg = a.lengthOfLongestSubstring("bbbbb");
        System.out.println(erg);
    }
}
